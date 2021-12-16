/*     */ package org.dcm4che3.android.imageio.stream;
/*     */ 
/*     */

import org.dcm4che3.android.stream.ImageInputStream;
import org.dcm4che3.android.stream.ImageInputStreamImpl;
import org.dcm4che3.data.BulkData;
import org.dcm4che3.data.Fragments;
import org.dcm4che3.util.ByteUtils;

import java.io.IOException;
import java.util.Arrays;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SegmentedImageInputStream
/*     */   extends ImageInputStreamImpl
/*     */ {
/*     */   private final ImageInputStream stream;
/*     */   private long[] segmentPositionsList;
/*     */   private int[] segmentLengths;
/*     */   private int curSegment;
/*     */   private long curSegmentEnd;
/*  63 */   private byte[] header = new byte[8];
/*     */ 
/*     */   
/*     */   public SegmentedImageInputStream(ImageInputStream stream, Fragments pixeldataFragments, int frameIndex) throws IOException {
/*  67 */     long[] offsets = new long[pixeldataFragments.size() - frameIndex + 1];
/*  68 */     int[] length = new int[offsets.length];
/*  69 */     for (int i = 0; i < length.length; i++) {
/*  70 */       BulkData bulkData = (BulkData)pixeldataFragments.get(i + frameIndex + 1);
/*  71 */       offsets[i] = bulkData.offset;
/*  72 */       length[i] = bulkData.length;
/*     */     } 
/*  74 */     this.stream = stream;
/*  75 */     this.segmentPositionsList = offsets;
/*  76 */     this.segmentLengths = length;
/*  77 */     seek(0L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SegmentedImageInputStream(ImageInputStream stream, long[] segmentPositionsList, int[] segmentLengths) throws IOException {
/*  83 */     this.stream = stream;
/*  84 */     this.segmentPositionsList = (long[])segmentPositionsList.clone();
/*  85 */     this.segmentLengths = (int[])segmentLengths.clone();
/*  86 */     seek(0L);
/*     */   }
/*     */   
/*     */   public SegmentedImageInputStream(ImageInputStream stream, long pos, int len) throws IOException {
/*  90 */     this.stream = stream;
/*  91 */     this.segmentPositionsList = new long[] { pos };
/*  92 */     this.segmentLengths = new int[] { len };
/*  93 */     seek(0L);
/*     */   }
/*     */   
/*     */   public long getLastSegmentEnd() {
/*  97 */     int i = this.segmentPositionsList.length - 1;
/*  98 */     return this.segmentPositionsList[i] + this.segmentLengths[i];
/*     */   }
/*     */   
/*     */   private int offsetOf(int segment) {
/* 102 */     int pos = 0;
/* 103 */     for (int i = 0; i < segment; i++)
/* 104 */       pos += this.segmentLengths[i]; 
/* 105 */     return pos;
/*     */   }
/*     */ 
/*     */   
/*     */   public void seek(long pos) throws IOException {
/* 110 */     super.seek(pos);
/* 111 */     for (int i = 0, off = 0; i < this.segmentLengths.length; i++) {
/* 112 */       int end = off + this.segmentLengths[i];
/* 113 */       if (pos < end) {
/* 114 */         this.stream.seek(this.segmentPositionsList[i] + pos - off);
/* 115 */         this.curSegment = i;
/* 116 */         this.curSegmentEnd = end;
/*     */         return;
/*     */       } 
/* 119 */       off = end;
/*     */     } 
/* 121 */     this.curSegment = -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/* 126 */     if (!prepareRead()) {
/* 127 */       return -1;
/*     */     }
/* 129 */     this.bitOffset = 0;
/* 130 */     int val = this.stream.read();
/* 131 */     if (val != -1) {
/* 132 */       this.streamPos++;
/*     */     }
/* 134 */     return val;
/*     */   }
/*     */   
/*     */   private boolean prepareRead() throws IOException {
/* 138 */     if (this.curSegment < 0) {
/* 139 */       return false;
/*     */     }
/* 141 */     if (this.streamPos < this.curSegmentEnd) {
/* 142 */       return true;
/*     */     }
/* 144 */     if (this.curSegment + 1 >= this.segmentPositionsList.length) {
/* 145 */       this.stream.mark();
/* 146 */       this.stream.readFully(this.header);
/* 147 */       this.stream.reset();
/* 148 */       if (ByteUtils.bytesToTagLE(this.header, 0) != -73728) {
/* 149 */         return false;
/*     */       }
/* 151 */       addSegment(getLastSegmentEnd() + 8L, ByteUtils.bytesToIntLE(this.header, 4));
/*     */     } 
/*     */     
/* 154 */     seek(offsetOf(this.curSegment + 1));
/* 155 */     return true;
/*     */   }
/*     */   
/*     */   private void addSegment(long pos, int len) {
/* 159 */     int i = this.segmentPositionsList.length;
/* 160 */     this.segmentPositionsList = Arrays.copyOf(this.segmentPositionsList, i + 1);
/* 161 */     this.segmentLengths = Arrays.copyOf(this.segmentLengths, i + 1);
/* 162 */     this.segmentPositionsList[i] = pos;
/* 163 */     this.segmentLengths[i] = len;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] b, int off, int len) throws IOException {
/* 168 */     if (!prepareRead()) {
/* 169 */       return -1;
/*     */     }
/* 171 */     this.bitOffset = 0;
/* 172 */     int nbytes = this.stream.read(b, off, Math.min(len, (int)(this.curSegmentEnd - this.streamPos)));
/*     */     
/* 174 */     if (nbytes != -1) {
/* 175 */       this.streamPos += nbytes;
/*     */     }
/* 177 */     return nbytes;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/imageio/stream/SegmentedImageInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */