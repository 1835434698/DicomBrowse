/*    */ package org.dcm4che3.io;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DicomEncodingOptions
/*    */ {
/* 47 */   public static final DicomEncodingOptions DEFAULT = new DicomEncodingOptions(false, true, false, true, false);
/*    */   
/*    */   public final boolean groupLength;
/*    */   
/*    */   public final boolean undefSequenceLength;
/*    */   
/*    */   public final boolean undefEmptySequenceLength;
/*    */   
/*    */   public final boolean undefItemLength;
/*    */   public final boolean undefEmptyItemLength;
/*    */   
/*    */   public DicomEncodingOptions(boolean groupLength, boolean undefSeqLength, boolean undefEmptySeqLength, boolean undefItemLength, boolean undefEmptyItemLength) {
/* 59 */     if (undefEmptySeqLength && !undefSeqLength) {
/* 60 */       throw new IllegalArgumentException("undefEmptySeqLength && !undefSeqLength");
/*    */     }
/* 62 */     if (undefEmptyItemLength && !undefItemLength) {
/* 63 */       throw new IllegalArgumentException("undefEmptyItemLength && !undefItemLength");
/*    */     }
/* 65 */     this.groupLength = groupLength;
/* 66 */     this.undefSequenceLength = undefSeqLength;
/* 67 */     this.undefEmptySequenceLength = undefEmptySeqLength;
/* 68 */     this.undefItemLength = undefItemLength;
/* 69 */     this.undefEmptyItemLength = undefEmptyItemLength;
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/io/DicomEncodingOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */