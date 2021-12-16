/*     */ package org.dcm4che3.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ByteUtils
/*     */ {
/*  46 */   public static final byte[] EMPTY_BYTES = new byte[0];
/*  47 */   public static final int[] EMPTY_INTS = new int[0];
/*  48 */   public static final float[] EMPTY_FLOATS = new float[0];
/*  49 */   public static final double[] EMPTY_DOUBLES = new double[0];
/*     */   
/*     */   public static int bytesToVR(byte[] bytes, int off) {
/*  52 */     return bytesToUShortBE(bytes, off);
/*     */   }
/*     */   
/*     */   public static int bytesToUShort(byte[] bytes, int off, boolean bigEndian) {
/*  56 */     return bigEndian ? bytesToUShortBE(bytes, off) : bytesToUShortLE(bytes, off);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int bytesToUShortBE(byte[] bytes, int off) {
/*  61 */     return ((bytes[off] & 0xFF) << 8) + (bytes[off + 1] & 0xFF);
/*     */   }
/*     */   
/*     */   public static int bytesToUShortLE(byte[] bytes, int off) {
/*  65 */     return ((bytes[off + 1] & 0xFF) << 8) + (bytes[off] & 0xFF);
/*     */   }
/*     */   
/*     */   public static int bytesToShort(byte[] bytes, int off, boolean bigEndian) {
/*  69 */     return bigEndian ? bytesToShortBE(bytes, off) : bytesToShortLE(bytes, off);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int bytesToShortBE(byte[] bytes, int off) {
/*  74 */     return (bytes[off] << 8) + (bytes[off + 1] & 0xFF);
/*     */   }
/*     */   
/*     */   public static int bytesToShortLE(byte[] bytes, int off) {
/*  78 */     return (bytes[off + 1] << 8) + (bytes[off] & 0xFF);
/*     */   }
/*     */   
/*     */   public static void bytesToShorts(byte[] src, int srcPos, short[] dest, int destPos, int length, boolean bigEndian) {
/*  82 */     if (bigEndian) {
/*  83 */       bytesToShortsBE(src, srcPos, dest, destPos, length);
/*     */     } else {
/*  85 */       bytesToShortsLE(src, srcPos, dest, destPos, length);
/*     */     } 
/*     */   }
/*     */   public static void bytesToShortsBE(byte[] src, int srcPos, short[] dest, int destPos, int length) {
/*  89 */     for (int i = 0; i < length; i++)
/*  90 */       dest[destPos + i] = (short)bytesToShortBE(src, srcPos + (i << 1)); 
/*     */   }
/*     */   
/*     */   public static void bytesToShortsLE(byte[] src, int srcPos, short[] dest, int destPos, int length) {
/*  94 */     for (int i = 0; i < length; i++)
/*  95 */       dest[destPos + i] = (short)bytesToShortLE(src, srcPos + (i << 1)); 
/*     */   }
/*     */   
/*     */   public static int bytesToInt(byte[] bytes, int off, boolean bigEndian) {
/*  99 */     return bigEndian ? bytesToIntBE(bytes, off) : bytesToIntLE(bytes, off);
/*     */   }
/*     */   
/*     */   public static int bytesToIntBE(byte[] bytes, int off) {
/* 103 */     return (bytes[off] << 24) + ((bytes[off + 1] & 0xFF) << 16) + ((bytes[off + 2] & 0xFF) << 8) + (bytes[off + 3] & 0xFF);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int bytesToIntLE(byte[] bytes, int off) {
/* 108 */     return (bytes[off + 3] << 24) + ((bytes[off + 2] & 0xFF) << 16) + ((bytes[off + 1] & 0xFF) << 8) + (bytes[off] & 0xFF);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int bytesToTag(byte[] bytes, int off, boolean bigEndian) {
/* 113 */     return bigEndian ? bytesToTagBE(bytes, off) : bytesToTagLE(bytes, off);
/*     */   }
/*     */   
/*     */   public static int bytesToTagBE(byte[] bytes, int off) {
/* 117 */     return bytesToIntBE(bytes, off);
/*     */   }
/*     */   
/*     */   public static int bytesToTagLE(byte[] bytes, int off) {
/* 121 */     return (bytes[off + 1] << 24) + ((bytes[off] & 0xFF) << 16) + ((bytes[off + 3] & 0xFF) << 8) + (bytes[off + 2] & 0xFF);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float bytesToFloat(byte[] bytes, int off, boolean bigEndian) {
/* 126 */     return bigEndian ? bytesToFloatBE(bytes, off) : bytesToFloatLE(bytes, off);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float bytesToFloatBE(byte[] bytes, int off) {
/* 131 */     return Float.intBitsToFloat(bytesToIntBE(bytes, off));
/*     */   }
/*     */   
/*     */   public static float bytesToFloatLE(byte[] bytes, int off) {
/* 135 */     return Float.intBitsToFloat(bytesToIntLE(bytes, off));
/*     */   }
/*     */   
/*     */   public static long bytesToLong(byte[] bytes, int off, boolean bigEndian) {
/* 139 */     return bigEndian ? bytesToLongBE(bytes, off) : bytesToLongLE(bytes, off);
/*     */   }
/*     */ 
/*     */   
/*     */   public static long bytesToLongBE(byte[] bytes, int off) {
/* 144 */     return (bytes[off] << 56L) + ((bytes[off + 1] & 0xFF) << 48L) + ((bytes[off + 2] & 0xFF) << 40L) + ((bytes[off + 3] & 0xFF) << 32L) + ((bytes[off + 4] & 0xFF) << 24L) + ((bytes[off + 5] & 0xFF) << 16) + ((bytes[off + 6] & 0xFF) << 8) + (bytes[off + 7] & 0xFF);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long bytesToLongLE(byte[] bytes, int off) {
/* 155 */     return (bytes[off + 7] << 56L) + ((bytes[off + 6] & 0xFF) << 48L) + ((bytes[off + 5] & 0xFF) << 40L) + ((bytes[off + 4] & 0xFF) << 32L) + ((bytes[off + 3] & 0xFF) << 24L) + ((bytes[off + 2] & 0xFF) << 16) + ((bytes[off + 1] & 0xFF) << 8) + (bytes[off] & 0xFF);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double bytesToDouble(byte[] bytes, int off, boolean bigEndian) {
/* 166 */     return bigEndian ? bytesToDoubleBE(bytes, off) : bytesToDoubleLE(bytes, off);
/*     */   }
/*     */ 
/*     */   
/*     */   public static double bytesToDoubleBE(byte[] bytes, int off) {
/* 171 */     return Double.longBitsToDouble(bytesToLongBE(bytes, off));
/*     */   }
/*     */   
/*     */   public static double bytesToDoubleLE(byte[] bytes, int off) {
/* 175 */     return Double.longBitsToDouble(bytesToLongLE(bytes, off));
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] shortToBytes(int i, byte[] bytes, int off, boolean bigEndian) {
/* 180 */     return bigEndian ? shortToBytesBE(i, bytes, off) : shortToBytesLE(i, bytes, off);
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] shortToBytesBE(int i, byte[] bytes, int off) {
/* 185 */     bytes[off] = (byte)(i >> 8);
/* 186 */     bytes[off + 1] = (byte)i;
/* 187 */     return bytes;
/*     */   }
/*     */   
/*     */   public static byte[] shortToBytesLE(int i, byte[] bytes, int off) {
/* 191 */     bytes[off + 1] = (byte)(i >> 8);
/* 192 */     bytes[off] = (byte)i;
/* 193 */     return bytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] intToBytes(int i, byte[] bytes, int off, boolean bigEndian) {
/* 198 */     return bigEndian ? intToBytesBE(i, bytes, off) : intToBytesLE(i, bytes, off);
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] intToBytesBE(int i, byte[] bytes, int off) {
/* 203 */     bytes[off] = (byte)(i >> 24);
/* 204 */     bytes[off + 1] = (byte)(i >> 16);
/* 205 */     bytes[off + 2] = (byte)(i >> 8);
/* 206 */     bytes[off + 3] = (byte)i;
/* 207 */     return bytes;
/*     */   }
/*     */   
/*     */   public static byte[] intToBytesLE(int i, byte[] bytes, int off) {
/* 211 */     bytes[off + 3] = (byte)(i >> 24);
/* 212 */     bytes[off + 2] = (byte)(i >> 16);
/* 213 */     bytes[off + 1] = (byte)(i >> 8);
/* 214 */     bytes[off] = (byte)i;
/* 215 */     return bytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] tagToBytes(int i, byte[] bytes, int off, boolean bigEndian) {
/* 220 */     return bigEndian ? tagToBytesBE(i, bytes, off) : tagToBytesLE(i, bytes, off);
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] tagToBytesBE(int i, byte[] bytes, int off) {
/* 225 */     return intToBytesBE(i, bytes, off);
/*     */   }
/*     */   
/*     */   public static byte[] tagToBytesLE(int i, byte[] bytes, int off) {
/* 229 */     bytes[off + 1] = (byte)(i >> 24);
/* 230 */     bytes[off] = (byte)(i >> 16);
/* 231 */     bytes[off + 3] = (byte)(i >> 8);
/* 232 */     bytes[off + 2] = (byte)i;
/* 233 */     return bytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] floatToBytes(float f, byte[] bytes, int off, boolean bigEndian) {
/* 238 */     return bigEndian ? floatToBytesBE(f, bytes, off) : floatToBytesLE(f, bytes, off);
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] floatToBytesBE(float f, byte[] bytes, int off) {
/* 243 */     return intToBytesBE(Float.floatToIntBits(f), bytes, off);
/*     */   }
/*     */   
/*     */   public static byte[] floatToBytesLE(float f, byte[] bytes, int off) {
/* 247 */     return intToBytesLE(Float.floatToIntBits(f), bytes, off);
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] doubleToBytes(double d, byte[] bytes, int off, boolean bigEndian) {
/* 252 */     return bigEndian ? doubleToBytesBE(d, bytes, off) : doubleToBytesLE(d, bytes, off);
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] doubleToBytesBE(double d, byte[] bytes, int off) {
/* 257 */     return longToBytesBE(Double.doubleToLongBits(d), bytes, off);
/*     */   }
/*     */   
/*     */   public static byte[] doubleToBytesLE(double d, byte[] bytes, int off) {
/* 261 */     return longToBytesLE(Double.doubleToLongBits(d), bytes, off);
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] longToBytes(long l, byte[] bytes, int off, boolean bigEndian) {
/* 266 */     return bigEndian ? longToBytesBE(l, bytes, off) : longToBytesLE(l, bytes, off);
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] longToBytesBE(long l, byte[] bytes, int off) {
/* 271 */     bytes[off] = (byte)(int)(l >> 56L);
/* 272 */     bytes[off + 1] = (byte)(int)(l >> 48L);
/* 273 */     bytes[off + 2] = (byte)(int)(l >> 40L);
/* 274 */     bytes[off + 3] = (byte)(int)(l >> 32L);
/* 275 */     bytes[off + 4] = (byte)(int)(l >> 24L);
/* 276 */     bytes[off + 5] = (byte)(int)(l >> 16L);
/* 277 */     bytes[off + 6] = (byte)(int)(l >> 8L);
/* 278 */     bytes[off + 7] = (byte)(int)l;
/* 279 */     return bytes;
/*     */   }
/*     */   
/*     */   public static byte[] longToBytesLE(long l, byte[] bytes, int off) {
/* 283 */     bytes[off + 7] = (byte)(int)(l >> 56L);
/* 284 */     bytes[off + 6] = (byte)(int)(l >> 48L);
/* 285 */     bytes[off + 5] = (byte)(int)(l >> 40L);
/* 286 */     bytes[off + 4] = (byte)(int)(l >> 32L);
/* 287 */     bytes[off + 3] = (byte)(int)(l >> 24L);
/* 288 */     bytes[off + 2] = (byte)(int)(l >> 16L);
/* 289 */     bytes[off + 1] = (byte)(int)(l >> 8L);
/* 290 */     bytes[off] = (byte)(int)l;
/* 291 */     return bytes;
/*     */   }
/*     */   
/*     */   public static byte[][] swapShorts(byte[][] bs) {
/* 295 */     int carry = 0;
/* 296 */     for (int i = 0; i < bs.length; i++) {
/* 297 */       byte[] b = bs[i];
/* 298 */       if (carry != 0)
/* 299 */         swapLastFirst(bs[i - 1], b); 
/* 300 */       int len = b.length - carry;
/* 301 */       swapShorts(b, carry, len & 0xFFFFFFFE);
/* 302 */       carry = len & 0x1;
/*     */     } 
/* 304 */     return bs;
/*     */   }
/*     */   
/*     */   public static byte[] swapShorts(byte[] b, int off, int len) {
/* 308 */     checkLength(len, 2);
/* 309 */     for (int i = off, n = off + len; i < n; i += 2)
/* 310 */       swap(b, i, i + 1); 
/* 311 */     return b;
/*     */   }
/*     */   
/*     */   public static byte[] swapInts(byte[] b, int off, int len) {
/* 315 */     checkLength(len, 4);
/* 316 */     for (int i = off, n = off + len; i < n; i += 4) {
/* 317 */       swap(b, i, i + 3);
/* 318 */       swap(b, i + 1, i + 2);
/*     */     } 
/* 320 */     return b;
/*     */   }
/*     */   
/*     */   public static byte[] swapLongs(byte[] b, int off, int len) {
/* 324 */     checkLength(len, 8);
/* 325 */     for (int i = off, n = off + len; i < n; i += 8) {
/* 326 */       swap(b, i, i + 7);
/* 327 */       swap(b, i + 1, i + 6);
/* 328 */       swap(b, i + 2, i + 5);
/* 329 */       swap(b, i + 3, i + 4);
/*     */     } 
/* 331 */     return b;
/*     */   }
/*     */   
/*     */   private static void checkLength(int len, int numBytes) {
/* 335 */     if (len < 0 || len % numBytes != 0)
/* 336 */       throw new IllegalArgumentException("length: " + len); 
/*     */   }
/*     */   
/*     */   private static void swap(byte[] bytes, int a, int b) {
/* 340 */     byte t = bytes[a];
/* 341 */     bytes[a] = bytes[b];
/* 342 */     bytes[b] = t;
/*     */   }
/*     */   
/*     */   private static void swapLastFirst(byte[] b1, byte[] b2) {
/* 346 */     int last = b1.length - 1;
/* 347 */     byte t = b2[0];
/* 348 */     b2[0] = b1[last];
/* 349 */     b1[last] = t;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/util/ByteUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */