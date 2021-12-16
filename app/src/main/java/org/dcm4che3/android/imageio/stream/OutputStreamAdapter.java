/*    */ package org.dcm4che3.android.imageio.stream;
/*    */ 
/*    */

import org.dcm4che3.android.stream.ImageOutputStreamImpl;

import java.io.IOException;
import java.io.OutputStream;

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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OutputStreamAdapter
/*    */   extends ImageOutputStreamImpl
/*    */ {
/*    */   private final OutputStream out;
/*    */   
/*    */   public OutputStreamAdapter(OutputStream out) {
/* 56 */     this.out = out;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(int b) throws IOException {
/* 61 */     this.out.write(b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] b, int off, int len) throws IOException {
/* 66 */     this.out.write(b, off, len);
/*    */   }
/*    */ 
/*    */   
/*    */   public int read() throws IOException {
/* 71 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] b, int off, int len) throws IOException {
/* 76 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/imageio/stream/OutputStreamAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */