/*     */ package org.dcm4che3.android.stream;
/*     */ 
/*     */

import java.io.IOException;
import java.io.OutputStream;

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
/*     */ public class MemoryCacheImageOutputStream
/*     */   extends ImageOutputStreamImpl
/*     */ {
/*     */   private OutputStream stream;
/*  46 */   private MemoryCache cache = new MemoryCache();
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
/*     */   public MemoryCacheImageOutputStream(OutputStream stream) {
/*  58 */     if (stream == null) {
/*  59 */       throw new IllegalArgumentException("stream == null!");
/*     */     }
/*  61 */     this.stream = stream;
/*     */   }
/*     */   
/*     */   public int read() throws IOException {
/*  65 */     checkClosed();
/*     */     
/*  67 */     this.bitOffset = 0;
/*     */     
/*  69 */     int val = this.cache.read(this.streamPos);
/*  70 */     if (val != -1) {
/*  71 */       this.streamPos++;
/*     */     }
/*  73 */     return val;
/*     */   }
/*     */   
/*     */   public int read(byte[] b, int off, int len) throws IOException {
/*  77 */     checkClosed();
/*     */     
/*  79 */     if (b == null) {
/*  80 */       throw new NullPointerException("b == null!");
/*     */     }
/*     */     
/*  83 */     if (off < 0 || len < 0 || off + len > b.length || off + len < 0) {
/*  84 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off+len > b.length || off+len < 0!");
/*     */     }
/*     */ 
/*     */     
/*  88 */     this.bitOffset = 0;
/*     */     
/*  90 */     if (len == 0) {
/*  91 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  96 */     long bytesLeftInCache = this.cache.getLength() - this.streamPos;
/*  97 */     if (bytesLeftInCache <= 0L) {
/*  98 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     len = (int)Math.min(bytesLeftInCache, len);
/* 105 */     this.cache.read(b, off, len, this.streamPos);
/* 106 */     this.streamPos += len;
/* 107 */     return len;
/*     */   }
/*     */   
/*     */   public void write(int b) throws IOException {
/* 111 */     flushBits();
/* 112 */     this.cache.write(b, this.streamPos);
/* 113 */     this.streamPos++;
/*     */   }
/*     */   
/*     */   public void write(byte[] b, int off, int len) throws IOException {
/* 117 */     flushBits();
/* 118 */     this.cache.write(b, off, len, this.streamPos);
/* 119 */     this.streamPos += len;
/*     */   }
/*     */   
/*     */   public long length() {
/*     */     try {
/* 124 */       checkClosed();
/* 125 */       return this.cache.getLength();
/* 126 */     } catch (IOException e) {
/* 127 */       return -1L;
/*     */     } 
/*     */   }
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
/*     */   public boolean isCached() {
/* 142 */     return true;
/*     */   }
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
/*     */   public boolean isCachedFile() {
/* 155 */     return false;
/*     */   }
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
/*     */   public boolean isCachedMemory() {
/* 168 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 178 */     long length = this.cache.getLength();
/* 179 */     seek(length);
/* 180 */     flushBefore(length);
/* 181 */     super.close();
/* 182 */     this.cache.reset();
/* 183 */     this.cache = null;
/* 184 */     this.stream = null;
/*     */   }
/*     */   
/*     */   public void flushBefore(long pos) throws IOException {
/* 188 */     long oFlushedPos = this.flushedPos;
/* 189 */     super.flushBefore(pos);
/*     */     
/* 191 */     long flushBytes = this.flushedPos - oFlushedPos;
/* 192 */     this.cache.writeToStream(this.stream, oFlushedPos, flushBytes);
/* 193 */     this.cache.disposeBefore(this.flushedPos);
/* 194 */     this.stream.flush();
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/stream/MemoryCacheImageOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */