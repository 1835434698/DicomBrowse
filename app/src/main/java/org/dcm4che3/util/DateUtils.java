/*     */ package org.dcm4che3.util;
/*     */ 
/*     */

import org.dcm4che3.data.DatePrecision;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
/*     */ 
/*     */ 
/*     */ public class DateUtils
/*     */ {
/*  54 */   public static final Date[] EMPTY_DATES = new Date[0];
/*     */   
/*     */   private static TimeZone cachedTimeZone;
/*     */   
/*     */   private static Calendar cal(TimeZone tz) {
/*  59 */     Calendar cal = (tz != null) ? new GregorianCalendar(tz) : new GregorianCalendar();
/*     */ 
/*     */     
/*  62 */     cal.clear();
/*  63 */     return cal;
/*     */   }
/*     */   
/*     */   private static Calendar cal(TimeZone tz, Date date) {
/*  67 */     Calendar cal = (tz != null) ? new GregorianCalendar(tz) : new GregorianCalendar();
/*     */ 
/*     */     
/*  70 */     cal.setTime(date);
/*  71 */     return cal;
/*     */   }
/*     */   
/*     */   private static void ceil(Calendar cal, int field) {
/*  75 */     cal.add(field, 1);
/*  76 */     cal.add(14, -1);
/*     */   }
/*     */   
/*     */   public static String formatDA(TimeZone tz, Date date) {
/*  80 */     return formatDA(tz, date, new StringBuilder(8)).toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static StringBuilder formatDA(TimeZone tz, Date date, StringBuilder toAppendTo) {
/*  85 */     return formatDT(cal(tz, date), toAppendTo, 5);
/*     */   }
/*     */   
/*     */   public static String formatTM(TimeZone tz, Date date) {
/*  89 */     return formatTM(tz, date, new DatePrecision());
/*     */   }
/*     */   
/*     */   public static String formatTM(TimeZone tz, Date date, DatePrecision precision) {
/*  93 */     return formatTM(cal(tz, date), new StringBuilder(10), precision.lastField).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static StringBuilder formatTM(Calendar cal, StringBuilder toAppendTo, int lastField) {
/*  99 */     appendXX(cal.get(11), toAppendTo);
/* 100 */     if (lastField > 11) {
/* 101 */       appendXX(cal.get(12), toAppendTo);
/* 102 */       if (lastField > 12) {
/* 103 */         appendXX(cal.get(13), toAppendTo);
/* 104 */         if (lastField > 13) {
/* 105 */           toAppendTo.append('.');
/* 106 */           appendXXX(cal.get(14), toAppendTo);
/*     */         } 
/*     */       } 
/*     */     } 
/* 110 */     return toAppendTo;
/*     */   }
/*     */   
/*     */   public static String formatDT(TimeZone tz, Date date) {
/* 114 */     return formatDT(tz, date, new DatePrecision());
/*     */   }
/*     */   
/*     */   public static String formatDT(TimeZone tz, Date date, DatePrecision precision) {
/* 118 */     return formatDT(tz, date, new StringBuilder(23), precision).toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static StringBuilder formatDT(TimeZone tz, Date date, StringBuilder toAppendTo, DatePrecision precision) {
/* 123 */     Calendar cal = cal(tz, date);
/* 124 */     formatDT(cal, toAppendTo, precision.lastField);
/* 125 */     if (precision.includeTimezone) {
/* 126 */       int offset = cal.get(15) + cal.get(16);
/*     */       
/* 128 */       appendZZZZZ(offset, toAppendTo);
/*     */     } 
/* 130 */     return toAppendTo;
/*     */   }
/*     */   
/*     */   private static StringBuilder appendZZZZZ(int offset, StringBuilder sb) {
/* 134 */     if (offset < 0) {
/* 135 */       offset = -offset;
/* 136 */       sb.append('-');
/*     */     } else {
/* 138 */       sb.append('+');
/* 139 */     }  int min = offset / 60000;
/* 140 */     appendXX(min / 60, sb);
/* 141 */     appendXX(min % 60, sb);
/* 142 */     return sb;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String formatTimezoneOffsetFromUTC(TimeZone tz) {
/* 154 */     return appendZZZZZ(tz.getRawOffset(), new StringBuilder(5)).toString();
/*     */   }
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
/*     */   public static String formatTimezoneOffsetFromUTC(TimeZone tz, Date date) {
/* 167 */     return appendZZZZZ(tz.getOffset((date == null) ? System.currentTimeMillis() : date.getTime()), new StringBuilder(5)).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static StringBuilder formatDT(Calendar cal, StringBuilder toAppendTo, int lastField) {
/* 174 */     appendXXXX(cal.get(1), toAppendTo);
/* 175 */     if (lastField > 1) {
/* 176 */       appendXX(cal.get(2) + 1, toAppendTo);
/* 177 */       if (lastField > 2) {
/* 178 */         appendXX(cal.get(5), toAppendTo);
/* 179 */         if (lastField > 5) {
/* 180 */           formatTM(cal, toAppendTo, lastField);
/*     */         }
/*     */       } 
/*     */     } 
/* 184 */     return toAppendTo;
/*     */   }
/*     */   
/*     */   private static void appendXXXX(int i, StringBuilder toAppendTo) {
/* 188 */     if (i < 1000)
/* 189 */       toAppendTo.append('0'); 
/* 190 */     appendXXX(i, toAppendTo);
/*     */   }
/*     */   
/*     */   private static void appendXXX(int i, StringBuilder toAppendTo) {
/* 194 */     if (i < 100)
/* 195 */       toAppendTo.append('0'); 
/* 196 */     appendXX(i, toAppendTo);
/*     */   }
/*     */   
/*     */   private static void appendXX(int i, StringBuilder toAppendTo) {
/* 200 */     if (i < 10)
/* 201 */       toAppendTo.append('0'); 
/* 202 */     toAppendTo.append(i);
/*     */   }
/*     */   
/*     */   public static Date parseDA(TimeZone tz, String s) {
/* 206 */     return parseDA(tz, s, false);
/*     */   }
/*     */   
/*     */   public static Date parseDA(TimeZone tz, String s, boolean ceil) {
/* 210 */     Calendar cal = cal(tz);
/* 211 */     int length = s.length();
/* 212 */     if (length != 8 && (length != 10 || Character.isDigit(s.charAt(4))))
/* 213 */       throw new IllegalArgumentException(s); 
/*     */     try {
/* 215 */       int pos = 0;
/* 216 */       cal.set(1, Integer.parseInt(s.substring(pos, pos + 4)));
/*     */       
/* 218 */       pos += 4;
/* 219 */       if (!Character.isDigit(s.charAt(pos)))
/* 220 */         pos++; 
/* 221 */       cal.set(2, Integer.parseInt(s.substring(pos, pos + 2)) - 1);
/*     */       
/* 223 */       pos += 2;
/* 224 */       if (!Character.isDigit(s.charAt(pos)))
/* 225 */         pos++; 
/* 226 */       cal.set(5, Integer.parseInt(s.substring(pos)));
/*     */       
/* 228 */       if (ceil)
/* 229 */         ceil(cal, 5); 
/* 230 */     } catch (NumberFormatException e) {
/* 231 */       throw new IllegalArgumentException(s);
/*     */     } 
/* 233 */     return cal.getTime();
/*     */   }
/*     */   
/*     */   public static Date parseTM(TimeZone tz, String s, DatePrecision precision) {
/* 237 */     return parseTM(tz, s, false, precision);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date parseTM(TimeZone tz, String s, boolean ceil, DatePrecision precision) {
/* 242 */     return parseTM(cal(tz), s, ceil, precision);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Date parseTM(Calendar cal, String s, boolean ceil, DatePrecision precision) {
/* 247 */     int length = s.length();
/* 248 */     int pos = 0;
/* 249 */     if (pos + 2 > length) {
/* 250 */       throw new IllegalArgumentException(s);
/*     */     }
/*     */     try {
/* 253 */       cal.set(precision.lastField = 11, Integer.parseInt(s.substring(pos, pos + 2)));
/*     */       
/* 255 */       pos += 2;
/* 256 */       if (pos < length) {
/* 257 */         if (!Character.isDigit(s.charAt(pos)))
/* 258 */           pos++; 
/* 259 */         if (pos + 2 > length) {
/* 260 */           throw new IllegalArgumentException(s);
/*     */         }
/* 262 */         cal.set(precision.lastField = 12, Integer.parseInt(s.substring(pos, pos + 2)));
/*     */         
/* 264 */         pos += 2;
/* 265 */         if (pos < length) {
/* 266 */           if (!Character.isDigit(s.charAt(pos)))
/* 267 */             pos++; 
/* 268 */           if (pos + 2 > length)
/* 269 */             throw new IllegalArgumentException(s); 
/* 270 */           cal.set(precision.lastField = 13, Integer.parseInt(s.substring(pos, pos + 2)));
/*     */           
/* 272 */           pos += 2;
/* 273 */           if (pos < length) {
/* 274 */             float f = Float.parseFloat(s.substring(pos));
/* 275 */             if (f >= 1.0F || f < 0.0F)
/* 276 */               throw new IllegalArgumentException(s); 
/* 277 */             cal.set(precision.lastField = 14, (int)(f * 1000.0F));
/*     */             
/* 279 */             return cal.getTime();
/*     */           } 
/*     */         } 
/*     */       } 
/* 283 */       if (ceil)
/* 284 */         ceil(cal, precision.lastField); 
/* 285 */     } catch (NumberFormatException e) {
/* 286 */       throw new IllegalArgumentException(s);
/*     */     } 
/* 288 */     return cal.getTime();
/*     */   }
/*     */   
/*     */   public static Date parseDT(TimeZone tz, String s, DatePrecision precision) {
/* 292 */     return parseDT(tz, s, false, precision);
/*     */   }
/*     */   
/*     */   public static TimeZone timeZone(String s) {
/*     */     TimeZone tz;
/* 297 */     if (s.length() != 5 || (tz = safeTimeZone(s)) == null)
/* 298 */       throw new IllegalArgumentException("Illegal Timezone Offset: " + s); 
/* 299 */     return tz;
/*     */   }
/*     */   
/*     */   private static TimeZone safeTimeZone(String s) {
/* 303 */     String tzid = tzid(s);
/* 304 */     if (tzid == null) {
/* 305 */       return null;
/*     */     }
/* 307 */     TimeZone tz = cachedTimeZone;
/* 308 */     if (tz == null || !tz.getID().equals(tzid)) {
/* 309 */       cachedTimeZone = tz = TimeZone.getTimeZone(tzid);
/*     */     }
/* 311 */     return tz;
/*     */   }
/*     */   
/*     */   private static String tzid(String s) {
/* 315 */     int length = s.length();
/* 316 */     if (length > 4) {
/* 317 */       char[] tzid = { 'G', 'M', 'T', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, ':', Character.MIN_VALUE, Character.MIN_VALUE };
/* 318 */       s.getChars(length - 5, length - 2, tzid, 3);
/* 319 */       s.getChars(length - 2, length, tzid, 7);
/* 320 */       if ((tzid[3] == '+' || tzid[3] == '-') && Character.isDigit(tzid[4]) && Character.isDigit(tzid[5]) && Character.isDigit(tzid[7]) && Character.isDigit(tzid[8]))
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 325 */         return new String(tzid);
/*     */       }
/*     */     } 
/* 328 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date parseDT(TimeZone tz, String s, boolean ceil, DatePrecision precision) {
/* 333 */     int length = s.length();
/* 334 */     TimeZone tz1 = safeTimeZone(s);
/* 335 */     if (precision.includeTimezone = (tz1 != null)) {
/* 336 */       length -= 5;
/* 337 */       tz = tz1;
/*     */     } 
/* 339 */     Calendar cal = cal(tz);
/*     */     try {
/* 341 */       int pos = 0;
/* 342 */       if (pos + 4 > length)
/* 343 */         throw new IllegalArgumentException(s); 
/* 344 */       cal.set(precision.lastField = 1, Integer.parseInt(s.substring(pos, pos + 4)));
/*     */       
/* 346 */       pos += 4;
/* 347 */       if (pos < length) {
/* 348 */         if (!Character.isDigit(s.charAt(pos)))
/* 349 */           pos++; 
/* 350 */         if (pos + 2 > length)
/* 351 */           throw new IllegalArgumentException(s); 
/* 352 */         cal.set(precision.lastField = 2, Integer.parseInt(s.substring(pos, pos + 2)) - 1);
/*     */         
/* 354 */         pos += 2;
/* 355 */         if (pos < length) {
/* 356 */           if (!Character.isDigit(s.charAt(pos)))
/* 357 */             pos++; 
/* 358 */           if (pos + 2 > length)
/* 359 */             throw new IllegalArgumentException(s); 
/* 360 */           cal.set(precision.lastField = 5, Integer.parseInt(s.substring(pos, pos + 2)));
/*     */           
/* 362 */           pos += 2;
/* 363 */           if (pos < length) {
/* 364 */             return parseTM(cal, s.substring(pos, length), ceil, precision);
/*     */           }
/*     */         } 
/*     */       } 
/* 368 */     } catch (NumberFormatException e) {
/* 369 */       throw new IllegalArgumentException(s);
/*     */     } 
/* 371 */     if (ceil)
/* 372 */       ceil(cal, precision.lastField); 
/* 373 */     return cal.getTime();
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/util/DateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */