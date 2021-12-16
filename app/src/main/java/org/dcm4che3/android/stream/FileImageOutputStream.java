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
/*     */ public class FileImageOutputStream
/*     */   extends ImageOutputStreamImpl
/*     */ {
/*     */   private RandomAccessFile raf;
/*     */   
/*     */   public FileImageOutputStream(File f) throws FileNotFoundException, IOException {
/*  63 */     this((f == null) ? null : new RandomAccessFile(f, "rw"));
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
/*     */   public FileImageOutputStream(RandomAccessFile raf) {
/*  76 */     if (raf == null) {
/*  77 */       throw new IllegalArgumentException("raf == null!");
/*     */     }
/*  79 */     this.raf = raf;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*  84 */     checkClosed();
/*  85 */     this.bitOffset = 0;
/*  86 */     int val = this.raf.read();
/*  87 */     if (val != -1) {
/*  88 */       this.streamPos++;
/*     */     }
/*  90 */     return val;
/*     */   }
/*     */   
/*     */   public int read(byte[] b, int off, int len) throws IOException {
/*  94 */     checkClosed();
/*  95 */     this.bitOffset = 0;
/*  96 */     int nbytes = this.raf.read(b, off, len);
/*  97 */     if (nbytes != -1) {
/*  98 */       this.streamPos += nbytes;
/*     */     }
/* 100 */     return nbytes;
/*     */   }
/*     */   
/*     */   public void write(int b) throws IOException {
/* 104 */     flushBits();
/* 105 */     this.raf.write(b);
/* 106 */     this.streamPos++;
/*     */   }
/*     */   
/*     */   public void write(byte[] b, int off, int len) throws IOException {
/* 110 */     flushBits();
/* 111 */     this.raf.write(b, off, len);
/* 112 */     this.streamPos += len;
/*     */   }
/*     */   
/*     */   public long length() {
/*     */     try {
/* 117 */       checkClosed();
/* 118 */       return this.raf.length();
/* 119 */     } catch (IOException e) {
/* 120 */       return -1L;
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
/*     */   
/*     */   public void seek(long pos) throws IOException {
/* 136 */     checkClosed();
/* 137 */     if (pos < this.flushedPos) {
/* 138 */       throw new IndexOutOfBoundsException("pos < flushedPos!");
/*     */     }
/* 140 */     this.bitOffset = 0;
/* 141 */     this.raf.seek(pos);
/* 142 */     this.streamPos = this.raf.getFilePointer();
/*     */   }
/*     */   
/*     */   public void close() throws IOException {
/* 146 */     super.close();
/* 147 */     this.raf = null;
/*     */   }
/*     */   
/*     */   protected void finalize() throws Throwable {}
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/stream/FileImageOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */