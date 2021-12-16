/*     */ package org.dcm4che3.android.stream;
/*     */ 
/*     */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

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
/*     */ public class FileImageInputStream
/*     */   extends ImageInputStreamImpl
/*     */ {
/*     */   private RandomAccessFile raf;
/*     */   
/*     */   public FileImageInputStream(File f) throws FileNotFoundException, IOException {
/*  68 */     this((f == null) ? null : new RandomAccessFile(f, "r"));
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
/*     */ 
/*     */ 
/*     */   
/*     */   public FileImageInputStream(RandomAccessFile raf) {
/*  85 */     if (raf == null) {
/*  86 */       throw new IllegalArgumentException("raf == null!");
/*     */     }
/*  88 */     this.raf = raf;
/*     */   }
/*     */   
/*     */   public int read() throws IOException {
/*  92 */     checkClosed();
/*  93 */     this.bitOffset = 0;
/*  94 */     int val = this.raf.read();
/*  95 */     if (val != -1) {
/*  96 */       this.streamPos++;
/*     */     }
/*  98 */     return val;
/*     */   }
/*     */   
/*     */   public int read(byte[] b, int off, int len) throws IOException {
/* 102 */     checkClosed();
/* 103 */     this.bitOffset = 0;
/* 104 */     int nbytes = this.raf.read(b, off, len);
/* 105 */     if (nbytes != -1) {
/* 106 */       this.streamPos += nbytes;
/*     */     }
/* 108 */     return nbytes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long length() {
/*     */     try {
/* 120 */       checkClosed();
/* 121 */       return this.raf.length();
/* 122 */     } catch (IOException e) {
/* 123 */       return -1L;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void seek(long pos) throws IOException {
/* 128 */     checkClosed();
/* 129 */     if (pos < this.flushedPos) {
/* 130 */       throw new IndexOutOfBoundsException("pos < flushedPos!");
/*     */     }
/* 132 */     this.bitOffset = 0;
/* 133 */     this.raf.seek(pos);
/* 134 */     this.streamPos = this.raf.getFilePointer();
/*     */   }
/*     */   
/*     */   public void close() throws IOException {
/* 138 */     super.close();
/* 139 */     this.raf = null;
/*     */   }
/*     */   
/*     */   protected void finalize() throws Throwable {}
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/stream/FileImageInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */