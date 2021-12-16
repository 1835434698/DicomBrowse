/*     */ package org.dcm4che3.data;
/*     */ 
/*     */

import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.StringTokenizer;

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
/*     */ public class SpecificCharacterSet
/*     */ {
/*  96 */   public static final SpecificCharacterSet DEFAULT = new SpecificCharacterSet(new Codec[] { Codec.ISO_646 }, new String[] { "ISO_IR 100" });
/*     */ 
/*     */   
/*  99 */   private static ThreadLocal<SoftReference<Encoder>> cachedEncoder1 = new ThreadLocal<SoftReference<Encoder>>();
/*     */ 
/*     */   
/* 102 */   private static ThreadLocal<SoftReference<Encoder>> cachedEncoder2 = new ThreadLocal<SoftReference<Encoder>>();
/*     */   
/*     */   protected final Codec[] codecs;
/*     */   protected final String[] dicomCodes;
/*     */   
/*     */   private enum Codec
/*     */   {
/* 109 */     ISO_646("US-ASCII", 10306, 0),
/* 110 */     ISO_8859_1("ISO-8859-1", 10306, 11585),
/* 111 */     ISO_8859_2("ISO-8859-2", 10306, 11586),
/* 112 */     ISO_8859_3("ISO-8859-3", 10306, 11587),
/* 113 */     ISO_8859_4("ISO-8859-4", 10306, 11588),
/* 114 */     ISO_8859_5("ISO-8859-5", 10306, 11596),
/* 115 */     ISO_8859_6("ISO-8859-6", 10306, 11591),
/* 116 */     ISO_8859_7("ISO-8859-7", 10306, 11590),
/* 117 */     ISO_8859_8("ISO-8859-8", 10306, 11592),
/* 118 */     ISO_8859_9("ISO-8859-9", 10306, 11597),
/* 119 */     JIS_X_201("JIS_X0201", 10314, 10569),
/* 120 */     TIS_620("TIS-620", 10306, 11604),
/* 121 */     JIS_X_208("x-JIS0208", -1, 9282),
/* 122 */     JIS_X_212("JIS_X0212-1990", -1, 2369604),
/* 123 */     KS_X_1001("EUC-KR", 0, 2369859),
/* 124 */     UTF_8("UTF-8", 0, 0),
/* 125 */     GB18030("GB18030", 0, 0);
/*     */     
/*     */     private final String charsetName;
/*     */     private final int escSeq0;
/*     */     private final int escSeq1;
/*     */     
/*     */     Codec(String charsetName, int escSeq0, int escSeq1) {
/* 132 */       this.charsetName = charsetName;
/* 133 */       this.escSeq0 = escSeq0;
/* 134 */       this.escSeq1 = escSeq1;
/*     */     }
/*     */     
/*     */     public static Codec forCode(String code) {
/* 138 */       if (code == null) {
/* 139 */         return ISO_646;
/*     */       }
/* 141 */       switch (last2digits(code)) {
/*     */         case 0:
/* 143 */           if (code.equals("ISO_IR 100") || code.equals("ISO 2022 IR 100"))
/* 144 */             return ISO_8859_1; 
/*     */           break;
/*     */         case 1:
/* 147 */           if (code.equals("ISO_IR 101") || code.equals("ISO 2022 IR 101"))
/* 148 */             return ISO_8859_2; 
/*     */           break;
/*     */         case 6:
/* 151 */           if (code.equals("ISO 2022 IR 6"))
/* 152 */             return ISO_646; 
/*     */           break;
/*     */         case 9:
/* 155 */           if (code.equals("ISO_IR 109") || code.equals("ISO 2022 IR 109"))
/* 156 */             return ISO_8859_3; 
/*     */           break;
/*     */         case 10:
/* 159 */           if (code.equals("ISO_IR 110") || code.equals("ISO 2022 IR 110"))
/* 160 */             return ISO_8859_4; 
/*     */           break;
/*     */         case 13:
/* 163 */           if (code.equals("ISO_IR 13") || code.equals("ISO 2022 IR 13"))
/* 164 */             return JIS_X_201; 
/*     */           break;
/*     */         case 26:
/* 167 */           if (code.equals("ISO_IR 126") || code.equals("ISO 2022 IR 126"))
/* 168 */             return ISO_8859_7; 
/*     */           break;
/*     */         case 27:
/* 171 */           if (code.equals("ISO_IR 127") || code.equals("ISO 2022 IR 127"))
/* 172 */             return ISO_8859_6; 
/*     */           break;
/*     */         case 30:
/* 175 */           if (code.equals("GB18030"))
/* 176 */             return GB18030; 
/*     */           break;
/*     */         case 38:
/* 179 */           if (code.equals("ISO_IR 138") || code.equals("ISO 2022 IR 138"))
/* 180 */             return ISO_8859_8; 
/*     */           break;
/*     */         case 44:
/* 183 */           if (code.equals("ISO_IR 144") || code.equals("ISO 2022 IR 144"))
/* 184 */             return ISO_8859_5; 
/*     */           break;
/*     */         case 48:
/* 187 */           if (code.equals("ISO_IR 148") || code.equals("ISO 2022 IR 148"))
/* 188 */             return ISO_8859_9; 
/*     */           break;
/*     */         case 49:
/* 191 */           if (code.equals("ISO 2022 IR 149"))
/* 192 */             return KS_X_1001; 
/*     */           break;
/*     */         case 59:
/* 195 */           if (code.equals("ISO 2022 IR 159"))
/* 196 */             return JIS_X_212; 
/*     */           break;
/*     */         case 66:
/* 199 */           if (code.equals("ISO_IR 166") || code.equals("ISO 2022 IR 166"))
/* 200 */             return TIS_620; 
/*     */           break;
/*     */         case 87:
/* 203 */           if (code.equals("ISO 2022 IR 87"))
/* 204 */             return JIS_X_208; 
/*     */           break;
/*     */         case 92:
/* 207 */           if (code.equals("ISO_IR 192"))
/* 208 */             return UTF_8; 
/*     */           break;
/*     */       } 
/* 211 */       return ISO_646;
/*     */     }
/*     */     
/*     */     private static int last2digits(String code) {
/* 215 */       int len = code.length();
/* 216 */       if (len < 2)
/* 217 */         return -1; 
/* 218 */       char ch1 = code.charAt(len - 1);
/* 219 */       char ch2 = code.charAt(len - 2);
/* 220 */       return (ch2 & 0xF) * 10 + (ch1 & 0xF);
/*     */     }
/*     */     
/*     */     public byte[] encode(String val) {
/*     */       try {
/* 225 */         return val.getBytes(this.charsetName);
/* 226 */       } catch (UnsupportedEncodingException e) {
/* 227 */         throw new AssertionError(e);
/*     */       } 
/*     */     }
/*     */     
/*     */     public String decode(byte[] b, int off, int len) {
/*     */       try {
/* 233 */         return new String(b, off, len, this.charsetName);
/* 234 */       } catch (UnsupportedEncodingException e) {
/* 235 */         throw new AssertionError(e);
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean containsASCII() {
/* 240 */       return (this.escSeq0 >= 0);
/*     */     }
/*     */     
/*     */     public int getEscSeq0() {
/* 244 */       return this.escSeq0;
/*     */     }
/*     */     
/*     */     public int getEscSeq1() {
/* 248 */       return this.escSeq1;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class Encoder {
/*     */     final Codec codec;
/*     */     final CharsetEncoder encoder;
/*     */
/*     */     public Encoder(Codec codec) {
/* 257 */       this.codec = codec;
/* 258 */       this.encoder = Charset.forName(codec.charsetName).newEncoder();
/*     */     }
/*     */
/*     */
/*     */     public boolean encode(CharBuffer cb, ByteBuffer bb, boolean escSeq, CodingErrorAction errorAction) {
/* 263 */       this.encoder.onMalformedInput(errorAction).onUnmappableCharacter(errorAction).reset();
/*     */
/*     */
/* 266 */       int cbmark = cb.position();
/* 267 */       int bbmark = bb.position();
/*     */       try {
/* 269 */         if (escSeq)
/* 270 */           escSeq(bb, this.codec.getEscSeq1());
/* 271 */         CoderResult cr = this.encoder.encode(cb, bb, true);
/* 272 */         if (!cr.isUnderflow())
/* 273 */           cr.throwException();
/* 274 */         cr = this.encoder.flush(bb);
/* 275 */         if (!cr.isUnderflow())
/* 276 */           cr.throwException();
/* 277 */       } catch (CharacterCodingException x) {
/* 278 */         cb.position(cbmark);
/* 279 */         bb.position(bbmark);
/* 280 */         return false;
/*     */       }
/* 282 */       return true;
/*     */     }
/*     */
/*     */     private static void escSeq(ByteBuffer bb, int seq) {
/* 286 */       bb.put((byte)27);
/* 287 */       int b1 = seq >> 16;
/* 288 */       if (b1 != 0)
/* 289 */         bb.put((byte)b1);
/* 290 */       bb.put((byte)(seq >> 8));
/* 291 */       bb.put((byte)seq);
/*     */     }
/*     */   }
/*     */
/*     */   private static final class ISO2022
/*     */     extends SpecificCharacterSet {
/*     */     private ISO2022(Codec[] charsetInfos, String... codes) {
/* 298 */       super(charsetInfos, codes);
/*     */     }
/*     */
/*     */
/*     */     public byte[] encode(String val, String delimiters) {
/* 303 */       int strlen = val.length();
/* 304 */       CharBuffer cb = CharBuffer.wrap(val.toCharArray());
/* 305 */       Encoder enc1 = SpecificCharacterSet.encoder(SpecificCharacterSet.cachedEncoder1, this.codecs[0]);
/* 306 */       byte[] buf = new byte[strlen];
/* 307 */       ByteBuffer bb = ByteBuffer.wrap(buf);
/*     */
/*     */
/* 310 */       if (!enc1.encode(cb, bb, false, CodingErrorAction.REPORT)) {
/*     */
/*     */
/* 313 */         Encoder[] encs = new Encoder[this.codecs.length];
/* 314 */         encs[0] = enc1;
/* 315 */         encs[1] = SpecificCharacterSet.encoder(SpecificCharacterSet.cachedEncoder2, this.codecs[1]);
/* 316 */         StringTokenizer comps = new StringTokenizer(val, delimiters, true);
/*     */
/* 318 */         buf = new byte[2 * strlen + 4 * (comps.countTokens() + 1)];
/* 319 */         bb = ByteBuffer.wrap(buf);
/* 320 */         int cur = 0;
/* 321 */         while (comps.hasMoreTokens()) {
/* 322 */           String comp = comps.nextToken();
/* 323 */           if (comp.length() == 1 && delimiters.indexOf(comp.charAt(0)) >= 0) {
/*     */
/*     */
/*     */
/* 327 */             if (!this.codecs[cur].containsASCII())
/* 328 */               Encoder.escSeq(bb, this.codecs[0].getEscSeq0());
/* 329 */             bb.put((byte)comp.charAt(0));
/* 330 */             cur = 0;
/*     */             continue;
/*     */           }
/* 333 */           cb = CharBuffer.wrap(comp.toCharArray());
/*     */
/* 335 */           if (encs[cur].encode(cb, bb, false, CodingErrorAction.REPORT)) {
/*     */             continue;
/*     */           }
/* 338 */           int next = cur;
/*     */
/*     */
/*     */           do {
/* 342 */             next = (next + 1) % encs.length;
/* 343 */             if (next == cur) {
/*     */
/*     */
/*     */
/*     */
/*     */
/* 349 */               if (!this.codecs[cur].containsASCII())
/* 350 */                 Encoder.escSeq(bb, this.codecs[0].getEscSeq0());
/* 351 */               encs[0].encode(cb, bb, false, CodingErrorAction.REPLACE);
/*     */
/* 353 */               next = 0;
/*     */               break;
/*     */             }
/* 356 */             if (encs[next] != null)
/* 357 */               continue;  encs[next] = new Encoder(this.codecs[next]);
/* 358 */           } while (!encs[next].encode(cb, bb, true, CodingErrorAction.REPORT));
/*     */
/* 360 */           cur = next;
/*     */         }
/* 362 */         if (!this.codecs[cur].containsASCII())
/* 363 */           Encoder.escSeq(bb, this.codecs[0].getEscSeq0());
/*     */       }
/* 365 */       return Arrays.copyOf(buf, bb.position());
/*     */     }
/*     */
/*     */
/*     */     public String decode(byte[] b) {
/* 370 */       Codec codec = this.codecs[0];
/* 371 */       int off = 0;
/* 372 */       int cur = 0;
/* 373 */       int step = 1;
/* 374 */       StringBuffer sb = new StringBuffer(b.length);
/* 375 */       while (cur < b.length) {
/* 376 */         if (b[cur] == 27) {
/* 377 */           if (off < cur) {
/* 378 */             sb.append(codec.decode(b, off, cur - off));
/*     */           }
/* 380 */           cur += 3;
/* 381 */           switch (((b[cur - 2] & 0xFF) << 8) + (b[cur - 1] & 0xFF)) {
/*     */             case 9256:
/* 383 */               if (b[cur++] == 68) {
/* 384 */                 codec = Codec.JIS_X_212;
/* 385 */                 step = 2; break;
/*     */               }
/* 387 */               sb.append(codec.decode(b, cur - 4, 4));
/*     */               break;
/*     */
/*     */             case 9257:
/* 391 */               if (b[cur++] == 67) {
/* 392 */                 codec = Codec.KS_X_1001;
/* 393 */                 step = -1; break;
/*     */               }
/* 395 */               sb.append(codec.decode(b, cur - 4, 4));
/*     */               break;
/*     */
/*     */             case 9282:
/* 399 */               codec = Codec.JIS_X_208;
/* 400 */               step = 2;
/*     */               break;
/*     */             case 10306:
/* 403 */               codec = Codec.ISO_646;
/* 404 */               step = 1;
/*     */               break;
/*     */             case 10314:
/*     */             case 10569:
/* 408 */               codec = Codec.JIS_X_201;
/* 409 */               step = 1;
/*     */               break;
/*     */             case 11585:
/* 412 */               codec = Codec.ISO_8859_1;
/* 413 */               step = 1;
/*     */               break;
/*     */             case 11586:
/* 416 */               codec = Codec.ISO_8859_2;
/* 417 */               step = 1;
/*     */               break;
/*     */             case 11587:
/* 420 */               codec = Codec.ISO_8859_3;
/* 421 */               step = 1;
/*     */               break;
/*     */             case 11588:
/* 424 */               codec = Codec.ISO_8859_4;
/* 425 */               step = 1;
/*     */               break;
/*     */             case 11590:
/* 428 */               codec = Codec.ISO_8859_7;
/* 429 */               step = 1;
/*     */               break;
/*     */             case 11591:
/* 432 */               codec = Codec.ISO_8859_6;
/* 433 */               step = 1;
/*     */               break;
/*     */             case 11592:
/* 436 */               codec = Codec.ISO_8859_8;
/* 437 */               step = 1;
/*     */               break;
/*     */             case 11596:
/* 440 */               codec = Codec.ISO_8859_5;
/* 441 */               step = 1;
/*     */               break;
/*     */             case 11597:
/* 444 */               codec = Codec.ISO_8859_9;
/* 445 */               step = 1;
/*     */               break;
/*     */             case 11604:
/* 448 */               codec = Codec.TIS_620;
/* 449 */               step = 1;
/*     */               break;
/*     */             default:
/* 452 */               sb.append(codec.decode(b, cur - 3, 3)); break;
/*     */           } 
/* 454 */           off = cur; continue;
/*     */         } 
/* 456 */         cur += (step > 0) ? step : ((b[cur] < 0) ? 2 : 1);
/*     */       } 
/*     */       
/* 459 */       if (off < cur) {
/* 460 */         sb.append(codec.decode(b, off, cur - off));
/*     */       }
/* 462 */       return sb.toString();
/*     */     }
/*     */   }
/*     */   
/*     */   public static SpecificCharacterSet valueOf(String... codes) {
/* 467 */     if (codes == null || codes.length == 0) {
/* 468 */       return DEFAULT;
/*     */     }
/* 470 */     Codec[] infos = new Codec[codes.length];
/* 471 */     for (int i = 0; i < codes.length; i++)
/* 472 */       infos[i] = Codec.forCode(codes[i]); 
/* 473 */     return (codes.length > 1) ? new ISO2022(infos, codes) : new SpecificCharacterSet(infos, codes);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] toCodes() {
/* 479 */     return this.dicomCodes;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Encoder encoder(ThreadLocal<SoftReference<Encoder>> tl, Codec codec) {
/*     */     SoftReference<Encoder> sr;
/*     */     Encoder enc;
/* 486 */     if ((sr = tl.get()) == null || (enc = sr.get()) == null || enc.codec != codec)
/*     */     {
/* 488 */       tl.set(new SoftReference<Encoder>(enc = new Encoder(codec))); } 
/* 489 */     return enc;
/*     */   }
/*     */   
/*     */   protected SpecificCharacterSet(Codec[] codecs, String... codes) {
/* 493 */     this.codecs = codecs;
/* 494 */     this.dicomCodes = codes;
/*     */   }
/*     */   
/*     */   public byte[] encode(String val, String delimiters) {
/* 498 */     return this.codecs[0].encode(val);
/*     */   }
/*     */   
/*     */   public String decode(byte[] val) {
/* 502 */     return this.codecs[0].decode(val, 0, val.length);
/*     */   }
/*     */   
/*     */   public boolean isUTF8() {
/* 506 */     return this.codecs[0].equals(Codec.UTF_8);
/*     */   }
/*     */   
/*     */   public boolean isASCII() {
/* 510 */     return this.codecs[0].equals(Codec.ISO_646);
/*     */   }
/*     */   
/*     */   public boolean containsASCII() {
/* 514 */     return this.codecs[0].containsASCII();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object other) {
/* 519 */     if (other == null) {
/* 520 */       return false;
/*     */     }
/* 522 */     if (getClass() != other.getClass()) {
/* 523 */       return false;
/*     */     }
/* 525 */     SpecificCharacterSet othercs = (SpecificCharacterSet)other;
/* 526 */     return Arrays.equals((Object[])this.codecs, (Object[])othercs.codecs);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 531 */     return Arrays.hashCode((Object[])this.codecs);
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/SpecificCharacterSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */