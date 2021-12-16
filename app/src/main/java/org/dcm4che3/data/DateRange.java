/*     */ package org.dcm4che3.data;
/*     */ 
/*     */

import java.io.Serializable;
import java.util.Date;

/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DateRange
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 88574297440294935L;
/*     */   private final Date start;
/*     */   private final Date end;
/*     */   
/*     */   public DateRange(Date start, Date end) {
/*  56 */     this.start = start;
/*  57 */     this.end = end;
/*     */   }
/*     */   
/*     */   public final Date getStartDate() {
/*  61 */     return this.start;
/*     */   }
/*     */   
/*     */   public final Date getEndDate() {
/*  65 */     return this.end;
/*     */   }
/*     */   
/*     */   public boolean isStartDateExeedsEndDate() {
/*  69 */     return (this.start != null && this.end != null && this.start.after(this.end));
/*     */   }
/*     */   
/*     */   public boolean contains(Date when) {
/*  73 */     return ((this.start == null || !this.start.after(when)) && (this.end == null || !this.end.before(when)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  79 */     if (obj == this) {
/*  80 */       return true;
/*     */     }
/*  82 */     if (!(obj instanceof DateRange)) {
/*  83 */       return false;
/*     */     }
/*  85 */     DateRange other = (DateRange)obj;
/*  86 */     return (((this.start == null) ? (other.start == null) : this.start.equals(other.start)) && ((this.end == null) ? (other.end == null) : this.end.equals(other.end)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     int code = 0;
/*  97 */     if (this.start != null)
/*  98 */       code = this.start.hashCode(); 
/*  99 */     if (this.end != null)
/* 100 */       code ^= this.start.hashCode(); 
/* 101 */     return code;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 106 */     return "[" + this.start + ", " + this.end + "]";
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/DateRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */