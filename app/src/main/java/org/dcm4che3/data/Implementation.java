/*    */ package org.dcm4che3.data;
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
/*    */ public class Implementation
/*    */ {
/*    */   private static final String IMPL_CLASS_UID = "1.2.40.0.13.1.1";
/* 47 */   private static final String IMPL_VERS_NAME = versionName();
/*    */   private static String versionName() {
/* 49 */     StringBuilder sb = new StringBuilder(16);
/* 50 */     sb.append("dcm4che-");
/* 51 */     sb.append(Implementation.class.getPackage().getImplementationVersion());
/*    */     
/* 53 */     return sb.substring(0, Math.min(16, sb.length()));
/*    */   }
/*    */   
/*    */   public static String getClassUID() {
/* 57 */     return "1.2.40.0.13.1.1";
/*    */   }
/*    */   
/*    */   public static String getVersionName() {
/* 61 */     return IMPL_VERS_NAME;
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/Implementation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */