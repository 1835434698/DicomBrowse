/*    */ package org.dcm4che3.io;
/*    */ 
/*    */ import java.io.IOException;

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
/*    */ public class DicomStreamException
/*    */   extends IOException
/*    */ {
/*    */   private static final long serialVersionUID = -6502979077324809342L;
/*    */   
/*    */   public DicomStreamException() {}
/*    */   
/*    */   public DicomStreamException(String message) {
/* 54 */     super(message);
/*    */   }
/*    */   
/*    */   public DicomStreamException(Throwable cause) {
/* 58 */     super(cause);
/*    */   }
/*    */   
/*    */   public DicomStreamException(String message, Throwable cause) {
/* 62 */     super(message, cause);
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/io/DicomStreamException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */