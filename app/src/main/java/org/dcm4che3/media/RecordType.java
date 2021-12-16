/*    */ package org.dcm4che3.media;
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
/*    */ public enum RecordType
/*    */ {
/* 45 */   PATIENT,
/* 46 */   STUDY,
/* 47 */   SERIES,
/* 48 */   IMAGE,
/* 49 */   OVERLAY,
/* 50 */   VOI_LUT,
/* 51 */   CURVE,
/* 52 */   STORED_PRINT,
/* 53 */   RT_DOSE,
/* 54 */   RT_STRUCTURE_SET,
/* 55 */   RT_PLAN,
/* 56 */   RT_TREAT_RECORD,
/* 57 */   PRESENTATION,
/* 58 */   WAVEFORM,
/* 59 */   SR_DOCUMENT,
/* 60 */   KEY_OBJECT_DOC,
/* 61 */   SPECTROSCOPY,
/* 62 */   RAW_DATA,
/* 63 */   REGISTRATION,
/* 64 */   FIDUCIAL,
/* 65 */   HANGING_PROTOCOL,
/* 66 */   ENCAP_DOC,
/* 67 */   HL7_STRUC_DOC,
/* 68 */   VALUE_MAP,
/* 69 */   STEREOMETRIC,
/* 70 */   PALETTE,
/* 71 */   SURFACE,
/* 72 */   MEASUREMENT,
/* 73 */   PLAN,
/* 74 */   PRIVATE;
/*    */   
/*    */   public String code() {
/* 77 */     return name().replace('_', ' ');
/*    */   }
/*    */   
/*    */   public static RecordType forCode(String code) {
/*    */     try {
/* 82 */       return valueOf(code.replace(' ', '_'));
/* 83 */     } catch (IllegalArgumentException e) {
/* 84 */       throw new IllegalArgumentException(code);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/media/RecordType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */