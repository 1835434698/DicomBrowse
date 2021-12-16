/*     */ package org.dcm4che3.data;
/*     */ 
/*     */

import org.dcm4che3.util.StringUtils;

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
/*     */ 
/*     */ 
/*     */ enum StringValueType
/*     */   implements ValueType
/*     */ {
/*  51 */   ASCII(false, true, null, null),
/*  52 */   STRING(true, true, "\\", null),
/*  53 */   TEXT(true, false, "\n\f\r", null),
/*  54 */   UR(false, false, null, null),
/*  55 */   DA(false, true, null, TemporalType.DA),
/*  56 */   DT(false, true, null, TemporalType.DT),
/*  57 */   TM(false, true, null, TemporalType.TM),
/*  58 */   PN(true, true, "^=\\", null),
/*  59 */   DS(false, true, null, null)
/*     */   {
/*     */     
/*     */     public byte[] toBytes(Object val, SpecificCharacterSet cs)
/*     */     {
/*  64 */       if (val instanceof double[])
/*  65 */         val = toStrings((double[])val); 
/*  66 */       return super.toBytes(val, cs);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString(Object val, boolean bigEndian, int valueIndex, String defVal) {
/*  73 */       if (val instanceof double[]) {
/*  74 */         double[] ds = (double[])val;
/*  75 */         return (valueIndex < ds.length && !Double.isNaN(ds[valueIndex])) ? StringUtils.formatDS(ds[valueIndex]) : defVal;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  80 */       return super.toString(val, bigEndian, valueIndex, defVal);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object toStrings(Object val, boolean bigEndian, SpecificCharacterSet cs) {
/*  87 */       return (val instanceof double[]) ? toStrings((double[])val) : super.toStrings(val, bigEndian, cs);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private Object toStrings(double[] ds) {
/*  93 */       if (ds.length == 1) {
/*  94 */         return StringUtils.formatDS(ds[0]);
/*     */       }
/*  96 */       String[] ss = new String[ds.length];
/*  97 */       for (int i = 0; i < ds.length; i++) {
/*  98 */         ss[i] = !Double.isNaN(ds[i]) ? StringUtils.formatDS(ds[i]) : "";
/*     */       }
/* 100 */       return ss;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public float toFloat(Object val, boolean bigEndian, int valueIndex, float defVal) {
/* 106 */       double[] ds = (double[])val;
/* 107 */       return (valueIndex < ds.length && !Double.isNaN(ds[valueIndex])) ? (float)ds[valueIndex] : defVal;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float[] toFloats(Object val, boolean bigEndian) {
/* 114 */       double[] ds = (double[])val;
/* 115 */       float[] fs = new float[ds.length];
/* 116 */       for (int i = 0; i < fs.length; i++)
/* 117 */         fs[i] = (float)ds[i]; 
/* 118 */       return fs;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double toDouble(Object val, boolean bigEndian, int valueIndex, double defVal) {
/* 124 */       double[] ds = (double[])val;
/* 125 */       return (valueIndex < ds.length && !Double.isNaN(ds[valueIndex])) ? ds[valueIndex] : defVal;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double[] toDoubles(Object val, boolean bigEndian) {
/* 132 */       return (double[])val;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object toValue(float[] fs, boolean bigEndian) {
/* 137 */       if (fs == null || fs.length == 0) {
/* 138 */         return Value.NULL;
/*     */       }
/* 140 */       if (fs.length == 1) {
/* 141 */         return StringUtils.formatDS(fs[0]);
/*     */       }
/* 143 */       String[] ss = new String[fs.length];
/* 144 */       for (int i = 0; i < fs.length; i++)
/* 145 */         ss[i] = StringUtils.formatDS(fs[i]); 
/* 146 */       return ss;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object toValue(double[] ds, boolean bigEndian) {
/* 151 */       if (ds == null || ds.length == 0) {
/* 152 */         return Value.NULL;
/*     */       }
/* 154 */       return ds;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean prompt(Object val, boolean bigEndian, SpecificCharacterSet cs, int maxChars, StringBuilder sb) {
/* 160 */       if (val instanceof double[])
/* 161 */         val = toStrings((double[])val); 
/* 162 */       return super.prompt(val, bigEndian, cs, maxChars, sb);
/*     */     }
/*     */   },
/* 165 */   IS(false, true, null, null)
/*     */   {
/*     */     public boolean isIntValue()
/*     */     {
/* 169 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public byte[] toBytes(Object val, SpecificCharacterSet cs) {
/* 175 */       if (val instanceof int[])
/* 176 */         val = toStrings((int[])val); 
/* 177 */       return super.toBytes(val, cs);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString(Object val, boolean bigEndian, int valueIndex, String defVal) {
/* 184 */       if (val instanceof int[]) {
/* 185 */         int[] is = (int[])val;
/* 186 */         return (valueIndex < is.length && is[valueIndex] != Integer.MIN_VALUE) ? Integer.toString(is[valueIndex]) : defVal;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 191 */       return super.toString(val, bigEndian, valueIndex, defVal);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object toStrings(Object val, boolean bigEndian, SpecificCharacterSet cs) {
/* 198 */       return (val instanceof int[]) ? toStrings((int[])val) : super.toStrings(val, bigEndian, cs);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private Object toStrings(int[] is) {
/* 204 */       if (is.length == 1) {
/* 205 */         return Integer.toString(is[0]);
/*     */       }
/* 207 */       String[] ss = new String[is.length];
/* 208 */       for (int i = 0; i < is.length; i++) {
/* 209 */         ss[i] = (is[i] != Integer.MIN_VALUE) ? Integer.toString(is[i]) : "";
/*     */       }
/* 211 */       return ss;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int toInt(Object val, boolean bigEndian, int valueIndex, int defVal) {
/* 217 */       int[] is = (int[])val;
/* 218 */       return (valueIndex < is.length && is[valueIndex] != Integer.MIN_VALUE) ? is[valueIndex] : defVal;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int[] toInts(Object val, boolean bigEndian) {
/* 225 */       return (int[])val;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object toValue(int[] is, boolean bigEndian) {
/* 230 */       if (is == null || is.length == 0) {
/* 231 */         return Value.NULL;
/*     */       }
/* 233 */       return is;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean prompt(Object val, boolean bigEndian, SpecificCharacterSet cs, int maxChars, StringBuilder sb) {
/* 239 */       if (val instanceof int[])
/* 240 */         val = toStrings((int[])val); 
/* 241 */       return super.prompt(val, bigEndian, cs, maxChars, sb);
/*     */     }
/*     */   };
/*     */ 
/*     */   
/*     */   final boolean useSpecificCharacterSet;
/*     */   final boolean multipleValues;
/*     */   final String delimiters;
/*     */   final TemporalType temporalType;
/*     */   
/*     */   StringValueType(boolean useSpecificCharacterSet, boolean multipleValues, String delimiters, TemporalType temperalType) {
/* 252 */     this.useSpecificCharacterSet = useSpecificCharacterSet;
/* 253 */     this.multipleValues = multipleValues;
/* 254 */     this.delimiters = delimiters;
/* 255 */     this.temporalType = temperalType;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStringValue() {
/* 260 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isIntValue() {
/* 265 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTemporalType() {
/* 270 */     return (this.temporalType != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int numEndianBytes() {
/* 275 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] toggleEndian(byte[] b, boolean preserve) {
/* 280 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useSpecificCharacterSet() {
/* 285 */     return this.useSpecificCharacterSet;
/*     */   }
/*     */   
/*     */   private SpecificCharacterSet cs(SpecificCharacterSet cs) {
/* 289 */     return this.useSpecificCharacterSet ? cs : SpecificCharacterSet.DEFAULT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] toBytes(Object val, SpecificCharacterSet cs) {
/* 295 */     if (val instanceof byte[]) {
/* 296 */       return (byte[])val;
/*     */     }
/* 298 */     if (val instanceof String) {
/* 299 */       return cs(cs).encode((String)val, this.delimiters);
/*     */     }
/* 301 */     if (val instanceof String[]) {
/* 302 */       return cs(cs).encode(StringUtils.concat((String[])val, '\\'), this.delimiters);
/*     */     }
/*     */     
/* 305 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString(Object val, boolean bigEndian, int valueIndex, String defVal) {
/* 312 */     if (val instanceof String) {
/* 313 */       return (valueIndex == 0) ? (String)val : defVal;
/*     */     }
/* 315 */     if (val instanceof String[]) {
/* 316 */       String[] ss = (String[])val;
/* 317 */       return (valueIndex < ss.length && !ss[valueIndex].isEmpty()) ? ss[valueIndex] : defVal;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 322 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object toStrings(Object val, boolean bigEndian, SpecificCharacterSet cs) {
/* 329 */     if (val instanceof byte[]) {
/* 330 */       String s = cs(cs).decode((byte[])val);
/* 331 */       return this.multipleValues ? StringUtils.splitAndTrim(s, '\\') : StringUtils.trimTrailing(s);
/*     */     } 
/*     */     
/* 334 */     if (val instanceof String || val instanceof String[])
/*     */     {
/* 336 */       return val;
/*     */     }
/* 338 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int toInt(Object val, boolean bigEndian, int valueIndex, int defVal) {
/* 344 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] toInts(Object val, boolean bigEndian) {
/* 349 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float toFloat(Object val, boolean bigEndian, int valueIndex, float defVal) {
/* 355 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] toFloats(Object val, boolean bigEndian) {
/* 360 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double toDouble(Object val, boolean bigEndian, int valueIndex, double defVal) {
/* 366 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] toDoubles(Object val, boolean bigEndian) {
/* 371 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date toDate(Object val, TimeZone tz, int valueIndex, boolean ceil, Date defVal, DatePrecision precision) {
/* 378 */     if (this.temporalType == null) {
/* 379 */       throw new UnsupportedOperationException();
/*     */     }
/* 381 */     if (val instanceof String) {
/* 382 */       return (valueIndex == 0) ? this.temporalType.parse(tz, (String)val, ceil, precision) : defVal;
/*     */     }
/*     */ 
/*     */     
/* 386 */     if (val instanceof String[]) {
/* 387 */       String[] ss = (String[])val;
/* 388 */       return (valueIndex < ss.length && ss[valueIndex] != null) ? this.temporalType.parse(tz, ss[valueIndex], ceil, precision) : defVal;
/*     */     } 
/*     */ 
/*     */     
/* 392 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date[] toDate(Object val, TimeZone tz, boolean ceil, DatePrecisions precisions) {
/* 398 */     if (this.temporalType == null) {
/* 399 */       throw new UnsupportedOperationException();
/*     */     }
/* 401 */     if (val instanceof String) {
/* 402 */       precisions.precisions = new DatePrecision[1];
/* 403 */       return new Date[] { this.temporalType.parse(tz, (String)val, ceil, precisions.precisions[0] = new DatePrecision()) };
/*     */     } 
/*     */     
/* 406 */     if (val instanceof String[]) {
/* 407 */       String[] ss = (String[])val;
/* 408 */       Date[] is = new Date[ss.length];
/* 409 */       precisions.precisions = new DatePrecision[ss.length];
/* 410 */       for (int i = 0; i < is.length; i++) {
/* 411 */         if (ss[i] != null) {
/* 412 */           is[i] = this.temporalType.parse(tz, ss[i], ceil, precisions.precisions[i] = new DatePrecision());
/*     */         }
/*     */       } 
/*     */       
/* 416 */       return is;
/*     */     } 
/* 418 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(byte[] b) {
/* 423 */     return (b != null && b.length > 0) ? b : Value.NULL;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(String s, boolean bigEndian) {
/* 428 */     if (s == null || s.isEmpty()) {
/* 429 */       return Value.NULL;
/*     */     }
/* 431 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(String[] ss, boolean bigEndian) {
/* 436 */     if (ss == null || ss.length == 0) {
/* 437 */       return Value.NULL;
/*     */     }
/* 439 */     if (ss.length == 1) {
/* 440 */       return toValue(ss[0], bigEndian);
/*     */     }
/* 442 */     return ss;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(int[] is, boolean bigEndian) {
/* 447 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(float[] fs, boolean bigEndian) {
/* 452 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(double[] ds, boolean bigEndian) {
/* 457 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(Date[] ds, TimeZone tz, DatePrecision precision) {
/* 462 */     if (this.temporalType == null) {
/* 463 */       throw new UnsupportedOperationException();
/*     */     }
/* 465 */     if (ds == null || ds.length == 0) {
/* 466 */       return Value.NULL;
/*     */     }
/* 468 */     if (ds.length == 1) {
/* 469 */       return this.temporalType.format(tz, ds[0], precision);
/*     */     }
/* 471 */     String[] ss = new String[ds.length];
/* 472 */     for (int i = 0; i < ss.length; i++) {
/* 473 */       ss[i] = this.temporalType.format(tz, ds[i], precision);
/*     */     }
/* 475 */     return ss;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean prompt(Object val, boolean bigEndian, SpecificCharacterSet cs, int maxChars, StringBuilder sb) {
/* 481 */     if (val instanceof byte[]) {
/* 482 */       return prompt(cs(cs).decode((byte[])val), maxChars, sb);
/*     */     }
/* 484 */     if (val instanceof String) {
/* 485 */       return prompt((String)val, maxChars, sb);
/*     */     }
/* 487 */     if (val instanceof String[]) {
/* 488 */       return prompt((String[])val, maxChars, sb);
/*     */     }
/* 490 */     return prompt(val.toString(), maxChars, sb);
/*     */   }
/*     */   
/*     */   static boolean prompt(String s, int maxChars, StringBuilder sb) {
/* 494 */     int maxLength = sb.length() + maxChars;
/* 495 */     sb.append(s.trim());
/* 496 */     if (sb.length() > maxLength) {
/* 497 */       sb.setLength(maxLength + 1);
/* 498 */       return false;
/*     */     } 
/* 500 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean prompt(String[] ss, int maxChars, StringBuilder sb) {
/* 505 */     int maxLength = sb.length() + maxChars;
/* 506 */     for (String s : ss) {
/* 507 */       if (s != null)
/* 508 */         sb.append(s); 
/* 509 */       if (sb.length() > maxLength) {
/* 510 */         sb.setLength(maxLength + 1);
/* 511 */         return false;
/*     */       } 
/* 513 */       sb.append('\\');
/*     */     } 
/* 515 */     sb.setLength(sb.length() - 1);
/* 516 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int vmOf(Object val) {
/* 521 */     if (val instanceof String) {
/* 522 */       return 1;
/*     */     }
/* 524 */     if (val instanceof String[]) {
/* 525 */       String[] ss = (String[])val;
/* 526 */       return ss.length;
/*     */     } 
/*     */     
/* 529 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/StringValueType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */