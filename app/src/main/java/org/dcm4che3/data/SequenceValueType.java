/*     */ package org.dcm4che3.data;
/*     */ 
/*     */

import java.util.Date;
import java.util.TimeZone;

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
/*     */ enum SequenceValueType
/*     */   implements ValueType
/*     */ {
/*  48 */   SQ;
/*     */ 
/*     */   
/*     */   public boolean isStringValue() {
/*  52 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useSpecificCharacterSet() {
/*  57 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isIntValue() {
/*  62 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTemporalType() {
/*  67 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int numEndianBytes() {
/*  72 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] toggleEndian(byte[] b, boolean preserve) {
/*  77 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] toBytes(Object val, SpecificCharacterSet cs) {
/*  82 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString(Object val, boolean bigEndian, int valueIndex, String defVal) {
/*  88 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object toStrings(Object val, boolean bigEndian, SpecificCharacterSet cs) {
/*  94 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int toInt(Object val, boolean bigEndian, int valueIndex, int defVal) {
/* 100 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] toInts(Object val, boolean bigEndian) {
/* 105 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float toFloat(Object val, boolean bigEndian, int valueIndex, float defVal) {
/* 111 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] toFloats(Object val, boolean bigEndian) {
/* 116 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double toDouble(Object val, boolean bigEndian, int valueIndex, double defVal) {
/* 122 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] toDoubles(Object val, boolean bigEndian) {
/* 127 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date toDate(Object val, TimeZone tz, int valueIndex, boolean ceil, Date defVal, DatePrecision precision) {
/* 133 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date[] toDate(Object val, TimeZone tz, boolean ceil, DatePrecisions precisions) {
/* 139 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(byte[] b) {
/* 144 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(String s, boolean bigEndian) {
/* 149 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(String[] ss, boolean bigEndian) {
/* 154 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(int[] is, boolean bigEndian) {
/* 159 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(float[] fs, boolean bigEndian) {
/* 164 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(double[] ds, boolean bigEndian) {
/* 169 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(Date[] ds, TimeZone tz, DatePrecision precision) {
/* 174 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean prompt(Object val, boolean bigEndian, SpecificCharacterSet cs, int maxChars, StringBuilder sb) {
/* 180 */     sb.append(val);
/* 181 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int vmOf(Object val) {
/* 186 */     return 1;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/SequenceValueType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */