/*     */ package org.dcm4che3.android.stream;
/*     */ 
/*     */

import java.io.IOException;
import java.io.InputStream;

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
/*     */ public class MemoryCacheImageInputStream
/*     */   extends ImageInputStreamImpl
/*     */ {
/*     */   private InputStream stream;
/*  47 */   private MemoryCache cache = new MemoryCache();
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
/*     */   public MemoryCacheImageInputStream(InputStream stream) {
/*  61 */     if (stream == null) {
/*  62 */       throw new IllegalArgumentException("stream == null!");
/*     */     }
/*  64 */     this.stream = stream;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*  70 */     checkClosed();
/*  71 */     this.bitOffset = 0;
/*  72 */     long pos = this.cache.loadFromStream(this.stream, this.streamPos + 1L);
/*  73 */     if (pos >= this.streamPos + 1L) {
/*  74 */       return this.cache.read(this.streamPos++);
/*     */     }
/*  76 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] b, int off, int len) throws IOException {
/*  81 */     checkClosed();
/*     */     
/*  83 */     if (b == null) {
/*  84 */       throw new NullPointerException("b == null!");
/*     */     }
/*  86 */     if (off < 0 || len < 0 || off + len > b.length || off + len < 0) {
/*  87 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off+len > b.length || off+len < 0!");
/*     */     }
/*     */ 
/*     */     
/*  91 */     this.bitOffset = 0;
/*     */     
/*  93 */     if (len == 0) {
/*  94 */       return 0;
/*     */     }
/*     */     
/*  97 */     long pos = this.cache.loadFromStream(this.stream, this.streamPos + len);
/*     */     
/*  99 */     len = (int)(pos - this.streamPos);
/*     */     
/* 101 */     if (len > 0) {
/* 102 */       this.cache.read(b, off, len, this.streamPos);
/* 103 */       this.streamPos += len;
/* 104 */       return len;
/*     */     } 
/* 106 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void flushBefore(long pos) throws IOException {
/* 111 */     super.flushBefore(pos);
/* 112 */     this.cache.disposeBefore(pos);
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
/* 126 */     return true;
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
/* 139 */     return false;
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
/* 152 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 160 */     super.close();
/*     */     
/* 162 */     this.stream = null;
/* 163 */     this.cache = null;
/*     */   }
/*     */   
/*     */   protected void finalize() throws Throwable {}
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/stream/MemoryCacheImageInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */