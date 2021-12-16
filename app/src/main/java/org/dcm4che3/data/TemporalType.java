/*    */ package org.dcm4che3.data;
/*    */ 
/*    */

import org.dcm4che3.util.DateUtils;

import java.util.Date;
import java.util.TimeZone;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ enum TemporalType
/*    */ {
/* 52 */   DA
/*    */   {
/*    */     public Date parse(TimeZone tz, String s, boolean ceil, DatePrecision precision)
/*    */     {
/* 56 */       precision.lastField = 5;
/* 57 */       return DateUtils.parseDA(tz, s, ceil);
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public String format(TimeZone tz, Date date, DatePrecision precision) {
/* 63 */       return DateUtils.formatDA(tz, date);
/*    */     } },
/* 65 */   DT
/*    */   {
/*    */     public Date parse(TimeZone tz, String s, boolean ceil, DatePrecision precision)
/*    */     {
/* 69 */       return DateUtils.parseDT(tz, s, ceil, precision);
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public String format(TimeZone tz, Date date, DatePrecision precision) {
/* 75 */       return DateUtils.formatDT(tz, date, precision);
/*    */     } },
/* 77 */   TM
/*    */   {
/*    */     public Date parse(TimeZone tz, String s, boolean ceil, DatePrecision precision)
/*    */     {
/* 81 */       return DateUtils.parseTM(tz, s, ceil, precision);
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public String format(TimeZone tz, Date date, DatePrecision precision) {
/* 87 */       return DateUtils.formatTM(tz, date, precision);
/*    */     }
/*    */   };
/*    */   
/*    */   public abstract Date parse(TimeZone paramTimeZone, String paramString, boolean paramBoolean, DatePrecision paramDatePrecision);
/*    */   
/*    */   public abstract String format(TimeZone paramTimeZone, Date paramDate, DatePrecision paramDatePrecision);
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/TemporalType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */