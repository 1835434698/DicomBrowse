/*     */ package org.dcm4che3.util;
/*     */ 
/*     */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
/*     */ public class Base64
/*     */ {
/*  50 */   private static final char[] BASE64 = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   private static final byte[] INV_BASE64 = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
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
/*     */   public static void encode(byte[] src, int srcPos, int srcLen, char[] dest, int destPos) {
/*  69 */     if (srcPos < 0 || srcLen < 0 || srcLen > src.length - srcPos)
/*  70 */       throw new IndexOutOfBoundsException(); 
/*  71 */     int destLen = srcLen * 4 / 3 + 3 & 0xFFFFFFFC;
/*  72 */     if (destPos < 0 || destLen > dest.length - destPos) {
/*  73 */       throw new IndexOutOfBoundsException();
/*     */     }
/*  75 */     int n = srcLen / 3;
/*  76 */     int r = srcLen - 3 * n;
/*  77 */     while (n-- > 0) {
/*  78 */       byte b1; dest[destPos++] = BASE64[(b1 = src[srcPos++]) >>> 2 & 0x3F]; byte b2;
/*  79 */       dest[destPos++] = BASE64[(b1 & 0x3) << 4 | (b2 = src[srcPos++]) >>> 4 & 0xF];
/*     */       byte b3;
/*  81 */       dest[destPos++] = BASE64[(b2 & 0xF) << 2 | (b3 = src[srcPos++]) >>> 6 & 0x3];
/*     */       
/*  83 */       dest[destPos++] = BASE64[b3 & 0x3F];
/*     */     } 
/*  85 */     if (r > 0) {
/*  86 */       if (r == 1) {
/*  87 */         byte b1; dest[destPos++] = BASE64[(b1 = src[srcPos]) >>> 2 & 0x3F];
/*  88 */         dest[destPos++] = BASE64[(b1 & 0x3) << 4];
/*  89 */         dest[destPos++] = '=';
/*  90 */         dest[destPos++] = '=';
/*     */       } else {
/*  92 */         byte b1; dest[destPos++] = BASE64[(b1 = src[srcPos++]) >>> 2 & 0x3F]; byte b2;
/*  93 */         dest[destPos++] = BASE64[(b1 & 0x3) << 4 | (b2 = src[srcPos]) >>> 4 & 0xF];
/*     */         
/*  95 */         dest[destPos++] = BASE64[(b2 & 0xF) << 2];
/*  96 */         dest[destPos++] = '=';
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void decode(char[] ch, int off, int len, OutputStream out) throws IOException {
/* 103 */     for (len -= 2; len >= 0; ) {
/* 104 */       byte b2; out.write((byte)(INV_BASE64[ch[off++]] << 2 | (b2 = INV_BASE64[ch[off++]]) >>> 4));
/*     */       
/* 106 */       if (len-- == 0 || ch[off] == '=')
/*     */         break;  byte b3;
/* 108 */       out.write((byte)(b2 << 4 | (b3 = INV_BASE64[ch[off++]]) >>> 2));
/*     */       
/* 110 */       if (len-- == 0 || ch[off] == '=')
/*     */         break; 
/* 112 */       out.write((byte)(b3 << 6 | INV_BASE64[ch[off++]]));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toBase64(byte[] bytes) {
/* 122 */     char[] encodedChars = new char[bytes.length * 4 / 3 + 3 & 0xFFFFFFFC];
/* 123 */     encode(bytes, 0, bytes.length, encodedChars, 0);
/* 124 */     return new String(encodedChars);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] fromBase64(String base64String) throws IOException {
/* 134 */     int encodedLength = base64String.length();
/* 135 */     int decodedLength = encodedLength * 3 / 4;
/*     */     
/* 137 */     char[] encodedChars = new char[encodedLength];
/* 138 */     base64String.getChars(0, encodedLength, encodedChars, 0);
/*     */     
/* 140 */     ByteArrayOutputStream stream = new ByteArrayOutputStream(decodedLength);
/* 141 */     decode(encodedChars, 0, encodedLength, stream);
/*     */     
/* 143 */     return stream.toByteArray();
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/util/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */