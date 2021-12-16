/*     */ package org.dcm4che3.util;
/*     */ 
/*     */

import android.annotation.SuppressLint;

import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

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
/*     */ public class StringUtils
/*     */ {
/*  52 */   public static String LINE_SEPARATOR = AccessController.<String>doPrivileged(new PrivilegedAction<String>()
/*     */       {
/*     */         public String run() {
/*  55 */           return System.getProperty("line.separator");
/*     */         }
/*     */       });
/*     */ 
/*     */   
/*  60 */   public static String[] EMPTY_STRING = new String[0];
/*     */   
/*     */   public static StringBuilder appendLine(StringBuilder sb, Object... ss) {
/*  63 */     for (Object s : ss)
/*  64 */       sb.append(s); 
/*  65 */     return sb.append(LINE_SEPARATOR);
/*     */   }
/*     */   
/*     */   public static String concat(String[] ss, char delim) {
/*  69 */     int n = ss.length;
/*  70 */     if (n == 0) {
/*  71 */       return "";
/*     */     }
/*  73 */     if (n == 1) {
/*  74 */       String s = ss[0];
/*  75 */       return (s != null) ? s : "";
/*     */     } 
/*  77 */     int len = n - 1;
/*  78 */     for (String s : ss) {
/*  79 */       if (s != null)
/*  80 */         len += s.length(); 
/*     */     } 
/*  82 */     char[] cs = new char[len];
/*  83 */     for (int i = 0, off = 0; i < n; i++) {
/*  84 */       if (i != 0)
/*  85 */         cs[off++] = delim; 
/*  86 */       String s = ss[i];
/*  87 */       if (s != null) {
/*  88 */         int l = s.length();
/*  89 */         s.getChars(0, l, cs, off);
/*  90 */         off += l;
/*     */       } 
/*     */     } 
/*  93 */     return new String(cs);
/*     */   }
/*     */   
/*     */   public static Object splitAndTrim(String s, char delim) {
/*  97 */     int count = 1;
/*  98 */     int delimPos = -1;
/*  99 */     while ((delimPos = s.indexOf(delim, delimPos + 1)) >= 0) {
/* 100 */       count++;
/*     */     }
/* 102 */     if (count == 1) {
/* 103 */       return substring(s, 0, s.length());
/*     */     }
/* 105 */     String[] ss = new String[count];
/* 106 */     int delimPos2 = s.length();
/* 107 */     while (--count >= 0) {
/* 108 */       delimPos = s.lastIndexOf(delim, delimPos2 - 1);
/* 109 */       ss[count] = substring(s, delimPos + 1, delimPos2);
/* 110 */       delimPos2 = delimPos;
/*     */     } 
/* 112 */     return ss;
/*     */   }
/*     */   
/*     */   public static String[] split(String s, char delim) {
/* 116 */     if (s == null || s.isEmpty()) {
/* 117 */       return EMPTY_STRING;
/*     */     }
/* 119 */     int count = 1;
/* 120 */     int delimPos = -1;
/* 121 */     while ((delimPos = s.indexOf(delim, delimPos + 1)) >= 0) {
/* 122 */       count++;
/*     */     }
/* 124 */     if (count == 1) {
/* 125 */       return new String[] { s };
/*     */     }
/* 127 */     String[] ss = new String[count];
/* 128 */     int delimPos2 = s.length();
/* 129 */     while (--count >= 0) {
/* 130 */       delimPos = s.lastIndexOf(delim, delimPos2 - 1);
/* 131 */       ss[count] = s.substring(delimPos + 1, delimPos2);
/* 132 */       delimPos2 = delimPos;
/*     */     } 
/* 134 */     return ss;
/*     */   }
/*     */   
/*     */   public static String cut(String s, int index, char delim) {
/* 138 */     int i = 0;
/* 139 */     int begin = 0;
/*     */     int end;
/* 141 */     while ((end = s.indexOf(delim, begin)) >= 0) {
/* 142 */       if (i++ == index)
/* 143 */         return s.substring(begin, end); 
/* 144 */       begin = end + 1;
/*     */     } 
/* 146 */     return (i == index) ? s.substring(begin) : "";
/*     */   }
/*     */   
/*     */   private static String substring(String s, int beginIndex, int endIndex) {
/* 150 */     while (beginIndex < endIndex && s.charAt(beginIndex) <= ' ')
/* 151 */       beginIndex++; 
/* 152 */     while (beginIndex < endIndex && s.charAt(endIndex - 1) <= ' ')
/* 153 */       endIndex--; 
/* 154 */     return (beginIndex < endIndex) ? s.substring(beginIndex, endIndex) : "";
/*     */   }
/*     */   
/*     */   public static String trimTrailing(String s) {
/* 158 */     int endIndex = s.length();
/* 159 */     while (endIndex > 0 && s.charAt(endIndex - 1) <= ' ')
/* 160 */       endIndex--; 
/* 161 */     return s.substring(0, endIndex);
/*     */   }
/*     */   
/*     */   public static int parseIS(String s) {
/* 165 */     return (s != null && s.length() != 0) ? Integer.parseInt((s.charAt(0) == '+') ? s.substring(1) : s) : 0;
/*     */   }
/*     */ 
/*     */

    @SuppressLint("NewApi")
    public static long parseUV(String s) {
        return s != null && s.length() != 0
                ? Long.parseUnsignedLong(s)
                : 0L;
    }
/*     */   
/*     */   public static double parseDS(String s) {
/* 171 */     return (s != null && s.length() != 0) ? Double.parseDouble(s.replace(',', '.')) : 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String formatDS(float f) {
/* 177 */     String s = Float.toString(f);
/* 178 */     int l = s.length();
/* 179 */     if (s.startsWith(".0", l - 2))
/* 180 */       return s.substring(0, l - 2); 
/* 181 */     int e = s.indexOf('E', l - 5);
/* 182 */     return (e > 0 && s.startsWith(".0", e - 2)) ? cut(s, e - 2, e) : s;
/*     */   }
/*     */   
/*     */   public static String formatDS(double d) {
/* 186 */     String s = Double.toString(d);
/* 187 */     int l = s.length();
/* 188 */     if (s.startsWith(".0", l - 2))
/* 189 */       return s.substring(0, l - 2); 
/* 190 */     int skip = l - 16;
/* 191 */     int e = s.indexOf('E', l - 5);
/* 192 */     return (e < 0) ? ((skip > 0) ? s.substring(0, 16) : s) : (s.startsWith(".0", e - 2) ? cut(s, e - 2, e) : ((skip > 0) ? cut(s, e - skip, e) : s));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String cut(String s, int begin, int end) {
/* 198 */     int l = s.length();
/* 199 */     char[] ch = new char[l - end - begin];
/* 200 */     s.getChars(0, begin, ch, 0);
/* 201 */     s.getChars(end, l, ch, begin);
/* 202 */     return new String(ch);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean matches(String s, String key, boolean matchNullOrEmpty, boolean ignoreCase) {
/* 207 */     if (key == null || key.isEmpty()) {
/* 208 */       return true;
/*     */     }
/* 210 */     if (s == null || s.isEmpty()) {
/* 211 */       return matchNullOrEmpty;
/*     */     }
/* 213 */     return containsWildCard(key) ? compilePattern(key, ignoreCase).matcher(s).matches() : (ignoreCase ? key.equalsIgnoreCase(s) : key.equals(s));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Pattern compilePattern(String key, boolean ignoreCase) {
/* 219 */     StringTokenizer stk = new StringTokenizer(key, "*?", true);
/* 220 */     StringBuilder regex = new StringBuilder();
/* 221 */     while (stk.hasMoreTokens()) {
/* 222 */       String tk = stk.nextToken();
/* 223 */       char ch1 = tk.charAt(0);
/* 224 */       if (ch1 == '*') {
/* 225 */         regex.append(".*"); continue;
/* 226 */       }  if (ch1 == '?') {
/* 227 */         regex.append("."); continue;
/*     */       } 
/* 229 */       regex.append("\\Q").append(tk).append("\\E");
/*     */     } 
/*     */     
/* 232 */     return Pattern.compile(regex.toString(), ignoreCase ? 2 : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean containsWildCard(String s) {
/* 237 */     return (s.indexOf('*') >= 0 || s.indexOf('?') >= 0);
/*     */   }
/*     */   
/*     */   public static String[] maskNull(String[] ss) {
/* 241 */     return maskNull(ss, EMPTY_STRING);
/*     */   }
/*     */   
/*     */   public static <T> T maskNull(T o, T mask) {
/* 245 */     return (o == null) ? mask : o;
/*     */   }
/*     */   
/*     */   public static <T> T nullify(T o, T val) {
/* 249 */     return val.equals(o) ? null : o;
/*     */   }
/*     */   
/*     */   public static String maskEmpty(String s, String mask) {
/* 253 */     return (s == null || s.isEmpty()) ? mask : s;
/*     */   }
/*     */   
/*     */   public static String truncate(String s, int maxlen) {
/* 257 */     return (s.length() > maxlen) ? s.substring(0, maxlen) : s;
/*     */   }
/*     */   
/*     */   public static <T> boolean equals(T o1, T o2) {
/* 261 */     return (o1 == o2 || (o1 != null && o1.equals(o2)));
/*     */   }
/*     */   
/*     */   public static String replaceSystemProperties(String s) {
/* 265 */     int i = s.indexOf("${");
/* 266 */     if (i == -1) {
/* 267 */       return s;
/*     */     }
/* 269 */     StringBuilder sb = new StringBuilder(s.length());
/* 270 */     int j = -1;
/*     */     do {
/* 272 */       sb.append(s.substring(j + 1, i));
/* 273 */       if ((j = s.indexOf('}', i + 2)) == -1) {
/* 274 */         j = i - 1;
/*     */         break;
/*     */       } 
/* 277 */       String val = System.getProperty(s.substring(i + 2, j));
/* 278 */       sb.append((val != null) ? val : s.substring(i, j + 1));
/* 279 */       i = s.indexOf("${", j + 1);
/* 280 */     } while (i != -1);
/* 281 */     sb.append(s.substring(j + 1));
/* 282 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static String resourceURL(String name) {
/* 291 */     ClassLoader tcl = Thread.currentThread().getContextClassLoader();
/* 292 */     URL url = tcl.getResource(name);
/* 293 */     return (url != null) ? url.toString() : null;
/*     */   }
/*     */   
/*     */   public static boolean isUpperCase(String s) {
/* 297 */     int len = s.length();
/* 298 */     for (int i = 0; i < len; i++) {
/* 299 */       char ch = s.charAt(i);
/* 300 */       if (Character.toUpperCase(ch) != ch)
/* 301 */         return false; 
/*     */     } 
/* 303 */     return (len != 0);
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/util/StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */