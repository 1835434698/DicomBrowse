/*    */ package org.dcm4che3.io;
/*    */ 
/*    */

import java.io.IOException;
import java.io.OutputStream;
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
/*    */ public class RAFOutputStreamAdapter
/*    */   extends OutputStream
/*    */ {
/*    */   private final RandomAccessFile raf;
/*    */   
/*    */   public RAFOutputStreamAdapter(RandomAccessFile raf) {
/* 53 */     this.raf = raf;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] b, int off, int len) throws IOException {
/* 58 */     this.raf.write(b, off, len);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(int b) throws IOException {
/* 63 */     this.raf.write(b);
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/io/RAFOutputStreamAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */