/*    */ package org.dcm4che3.io;
/*    */ 
/*    */

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RAFInputStreamAdapter
/*    */   extends InputStream
/*    */ {
/*    */   private final RandomAccessFile raf;
/*    */   private long markedPos;
/*    */   private IOException markException;
/*    */   
/*    */   public RAFInputStreamAdapter(RandomAccessFile raf) {
/* 55 */     if (raf == null)
/* 56 */       throw new NullPointerException(); 
/* 57 */     this.raf = raf;
/*    */   }
/*    */ 
/*    */   
/*    */   public int read() throws IOException {
/* 62 */     return this.raf.read();
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] b, int off, int len) throws IOException {
/* 67 */     return this.raf.read(b, off, len);
/*    */   }
/*    */ 
/*    */   
/*    */   public long skip(long n) throws IOException {
/* 72 */     return this.raf.skipBytes((int)n);
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized void mark(int readlimit) {
/*    */     try {
/* 78 */       this.markedPos = this.raf.getFilePointer();
/* 79 */       this.markException = null;
/* 80 */     } catch (IOException e) {
/* 81 */       this.markException = e;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized void reset() throws IOException {
/* 87 */     if (this.markException != null)
/* 88 */       throw this.markException; 
/* 89 */     this.raf.seek(this.markedPos);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean markSupported() {
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/io/RAFInputStreamAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */