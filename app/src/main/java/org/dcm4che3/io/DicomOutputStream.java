/*     */ package org.dcm4che3.io;
/*     */ 
/*     */

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.BulkData;
import org.dcm4che3.data.SpecificCharacterSet;
import org.dcm4che3.data.VR;
import org.dcm4che3.data.Value;
import org.dcm4che3.util.ByteUtils;
import org.dcm4che3.util.TagUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

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
/*     */ public class DicomOutputStream
/*     */   extends FilterOutputStream
/*     */ {
/*  55 */   private static final byte[] DICM = new byte[] { 68, 73, 67, 77 };
/*     */   
/*  57 */   private byte[] preamble = new byte[128];
/*     */   
/*     */   private boolean explicitVR;
/*     */   private boolean bigEndian;
/*  61 */   private DicomEncodingOptions encOpts = DicomEncodingOptions.DEFAULT;
/*     */   
/*  63 */   private final byte[] buf = new byte[12];
/*     */ 
/*     */   
/*     */   public DicomOutputStream(OutputStream out, String tsuid) throws IOException {
/*  67 */     super(out);
/*  68 */     switchTransferSyntax(tsuid);
/*     */   }
/*     */   
/*     */   public DicomOutputStream(File file) throws IOException {
/*  72 */     this(new BufferedOutputStream(new FileOutputStream(file)), "1.2.840.10008.1.2.1");
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setPreamble(byte[] preamble) {
/*  77 */     if (preamble.length != 128) {
/*  78 */       throw new IllegalArgumentException("preamble.length=" + preamble.length);
/*     */     }
/*  80 */     this.preamble = (byte[])preamble.clone();
/*     */   }
/*     */   
/*     */   public final boolean isExplicitVR() {
/*  84 */     return this.explicitVR;
/*     */   }
/*     */   
/*     */   public final boolean isBigEndian() {
/*  88 */     return this.bigEndian;
/*     */   }
/*     */   
/*     */   public final DicomEncodingOptions getEncodingOptions() {
/*  92 */     return this.encOpts;
/*     */   }
/*     */   
/*     */   public final void setEncodingOptions(DicomEncodingOptions encOpts) {
/*  96 */     if (encOpts == null)
/*  97 */       throw new NullPointerException(); 
/*  98 */     this.encOpts = encOpts;
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] b, int off, int len) throws IOException {
/* 103 */     this.out.write(b, off, len);
/*     */   }
/*     */   
/*     */   public void writeCommand(Attributes cmd) throws IOException {
/* 107 */     if (this.explicitVR || this.bigEndian) {
/* 108 */       throw new IllegalStateException("explicitVR=" + this.explicitVR + ", bigEndian=" + this.bigEndian);
/*     */     }
/* 110 */     cmd.writeGroupTo(this, 0);
/*     */   }
/*     */   
/*     */   public void writeFileMetaInformation(Attributes fmi) throws IOException {
/* 114 */     if (!this.explicitVR || this.bigEndian) {
/* 115 */       throw new IllegalStateException("explicitVR=" + this.explicitVR + ", bigEndian=" + this.bigEndian);
/*     */     }
/* 117 */     String tsuid = fmi.getString(131088, null);
/* 118 */     write(this.preamble);
/* 119 */     write(DICM);
/* 120 */     fmi.writeGroupTo(this, 131072);
/* 121 */     switchTransferSyntax(tsuid);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeDataset(Attributes fmi, Attributes dataset) throws IOException {
/* 126 */     if (fmi != null)
/* 127 */       writeFileMetaInformation(fmi); 
/* 128 */     if (dataset.bigEndian() != this.bigEndian || this.encOpts.groupLength || !this.encOpts.undefSequenceLength || !this.encOpts.undefItemLength)
/*     */     {
/*     */ 
/*     */       
/* 132 */       dataset = new Attributes(dataset, this.bigEndian); } 
/* 133 */     if (this.encOpts.groupLength)
/* 134 */       dataset.calcLength(this.encOpts, this.explicitVR); 
/* 135 */     dataset.writeTo(this);
/*     */   }
/*     */   
/*     */   private void switchTransferSyntax(String tsuid) throws IOException {
/* 139 */     this.bigEndian = tsuid.equals("1.2.840.10008.1.2.2");
/* 140 */     this.explicitVR = !tsuid.equals("1.2.840.10008.1.2");
/* 141 */     if (tsuid.equals("1.2.840.10008.1.2.1.99") || tsuid.equals("1.2.840.10008.1.2.4.95"))
/*     */     {
/* 143 */       this.out = new DeflaterOutputStream(this.out, new Deflater(-1, true));
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeHeader(int tag, VR vrTag, int len) throws IOException {
/*     */     int headerLen;
/* 149 */     byte[] b = this.buf;
/* 150 */     ByteUtils.tagToBytes(tag, b, 0, this.bigEndian);
/*     */     
/* 152 */     if (!TagUtils.isItem(tag) && this.explicitVR) {
/* 153 */       ByteUtils.shortToBytesBE(vrTag.code(), b, 4);
/* 154 */       if ((headerLen = vrTag.headerLength()) == 8) {
/* 155 */         ByteUtils.shortToBytes(len, b, 6, this.bigEndian);
/*     */       } else {
/* 157 */         b[7] = 0; b[6] = 0;
/* 158 */         ByteUtils.intToBytes(len, b, 8, this.bigEndian);
/*     */       } 
/*     */     } else {
/* 161 */       ByteUtils.intToBytes(len, b, 4, this.bigEndian);
/* 162 */       headerLen = 8;
/*     */     } 
/* 164 */     this.out.write(b, 0, headerLen);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeAttribute(int tag, VR vrTag, Object value, SpecificCharacterSet cs) throws IOException {
/* 170 */     if (value instanceof Value) {
/* 171 */       writeAttribute(tag, vrTag, (Value)value);
/*     */     } else {
/* 173 */       writeAttribute(tag, vrTag, (value instanceof byte[]) ? (byte[])value : vrTag.toBytes(value, cs));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeAttribute(int tag, VR vrTag, byte[] val) throws IOException {
/* 180 */     int padlen = val.length & 0x1;
/* 181 */     writeHeader(tag, vrTag, val.length + padlen);
/* 182 */     this.out.write(val);
/* 183 */     if (padlen > 0)
/* 184 */       this.out.write(vrTag.paddingByte());
/*     */   }
/*     */   
/*     */   public void writeAttribute(int tag, VR vrTag, Value val) throws IOException {
/* 188 */     if (val instanceof BulkData && this.out instanceof ObjectOutputStream) {
/*     */       
/* 190 */       writeHeader(tag, vrTag, 64507);
/* 191 */       ((BulkData)val).serializeTo((ObjectOutputStream)this.out);
/*     */     } else {
/* 193 */       int length = val.getEncodedLength(this.encOpts, this.explicitVR, vrTag);
/* 194 */       writeHeader(tag, vrTag, length);
/* 195 */       val.writeTo(this, vrTag);
/* 196 */       if (length == -1)
/* 197 */         writeHeader(-73507, (VR)null, 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void writeGroupLength(int tag, int len) throws IOException {
/* 202 */     byte[] b = this.buf;
/* 203 */     ByteUtils.tagToBytes(tag, b, 0, this.bigEndian);
/* 204 */     if (this.explicitVR) {
/* 205 */       ByteUtils.shortToBytesBE(VR.UL.code(), b, 4);
/* 206 */       ByteUtils.shortToBytes(4, b, 6, this.bigEndian);
/*     */     } else {
/* 208 */       ByteUtils.intToBytes(4, b, 4, this.bigEndian);
/*     */     } 
/* 210 */     ByteUtils.intToBytes(len, b, 8, this.bigEndian);
/* 211 */     this.out.write(b, 0, 12);
/*     */   }
/*     */   
/*     */   public void finish() throws IOException {
/* 215 */     if (this.out instanceof DeflaterOutputStream) {
/* 216 */       ((DeflaterOutputStream)this.out).finish();
/*     */     }
/*     */   }
/*     */   
/*     */   public void close() throws IOException {
/*     */     try {
/* 222 */       finish();
/* 223 */     } catch (IOException ignored) {}
/*     */     
/* 225 */     super.close();
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/io/DicomOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */