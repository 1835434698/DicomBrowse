/*    */ package org.dcm4che3.android.imageio.stream;
/*    */ 
/*    */

import org.dcm4che3.android.stream.ImageInputStream;

import java.io.IOException;
import java.io.InputStream;

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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ImageInputStreamAdapter
/*    */   extends InputStream
/*    */ {
/*    */   private final ImageInputStream iis;
/*    */   private long markedPos;
/*    */   private IOException markException;
/*    */   
/*    */   public ImageInputStreamAdapter(ImageInputStream iis) {
/* 61 */     this.iis = iis;
/*    */   }
/*    */ 
/*    */   
/*    */   public int read() throws IOException {
/* 66 */     return this.iis.read();
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized void mark(int readlimit) {
/*    */     try {
/* 72 */       this.markedPos = this.iis.getStreamPosition();
/* 73 */       this.markException = null;
/* 74 */     } catch (IOException e) {
/* 75 */       this.markException = e;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean markSupported() {
/* 81 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(byte[] b, int off, int len) throws IOException {
/* 86 */     return this.iis.read(b, off, len);
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized void reset() throws IOException {
/* 91 */     if (this.markException != null)
/* 92 */       throw this.markException; 
/* 93 */     this.iis.seek(this.markedPos);
/*    */   }
/*    */ 
/*    */   
/*    */   public long skip(long n) throws IOException {
/* 98 */     return this.iis.skipBytes((int)n);
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/imageio/stream/ImageInputStreamAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */