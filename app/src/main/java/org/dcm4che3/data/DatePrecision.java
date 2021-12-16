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
/*    */ public class DatePrecision
/*    */ {
/*    */   public int lastField;
/*    */   public boolean includeTimezone;
/*    */   
/*    */   public DatePrecision() {
/* 50 */     this(14, false);
/*    */   }
/*    */   
/*    */   public DatePrecision(int lastField) {
/* 54 */     this(lastField, false);
/*    */   }
/*    */   
/*    */   public DatePrecision(int lastField, boolean includeTimezone) {
/* 58 */     this.lastField = lastField;
/* 59 */     this.includeTimezone = includeTimezone;
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/DatePrecision.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */