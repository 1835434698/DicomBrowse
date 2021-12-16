/*    */ package org.dcm4che3.android.imageio.dicom;
/*    */ 
/*    */ import org.dcm4che3.data.Attributes;

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
/*    */ public class DicomMetaData
/*    */ {
/*    */   private final Attributes fileMetaInformation;
/*    */   private final Attributes attributes;
/*    */   
/*    */   public DicomMetaData(Attributes fileMetaInformation, Attributes attributes) {
/* 55 */     this.fileMetaInformation = fileMetaInformation;
/* 56 */     this.attributes = attributes;
/*    */   }
/*    */   
/*    */   public final Attributes getFileMetaInformation() {
/* 60 */     return this.fileMetaInformation;
/*    */   }
/*    */   
/*    */   public final Attributes getAttributes() {
/* 64 */     return this.attributes;
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/imageio/dicom/DicomMetaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */