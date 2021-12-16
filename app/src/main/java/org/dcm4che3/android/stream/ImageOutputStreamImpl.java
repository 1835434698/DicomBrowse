/*     */ package org.dcm4che3.android.stream;
/*     */ 
/*     */

import java.io.IOException;
import java.io.UTFDataFormatException;
import java.nio.ByteOrder;

/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ImageOutputStreamImpl
/*     */   extends ImageInputStreamImpl
/*     */   implements ImageOutputStream
/*     */ {
/*     */   public abstract void write(int paramInt) throws IOException;
/*     */   
/*     */   public void write(byte[] b) throws IOException {
/*  51 */     write(b, 0, b.length);
/*     */   }
/*     */   
/*     */   public abstract void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException;
/*     */   
/*     */   public void writeBoolean(boolean v) throws IOException {
/*  57 */     write(v ? 1 : 0);
/*     */   }
/*     */   
/*     */   public void writeByte(int v) throws IOException {
/*  61 */     write(v);
/*     */   }
/*     */   
/*     */   public void writeShort(int v) throws IOException {
/*  65 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/*  66 */       this.byteBuf[0] = (byte)(v >>> 8);
/*  67 */       this.byteBuf[1] = (byte)(v >>> 0);
/*     */     } else {
/*  69 */       this.byteBuf[0] = (byte)(v >>> 0);
/*  70 */       this.byteBuf[1] = (byte)(v >>> 8);
/*     */     } 
/*  72 */     write(this.byteBuf, 0, 2);
/*     */   }
/*     */   
/*     */   public void writeChar(int v) throws IOException {
/*  76 */     writeShort(v);
/*     */   }
/*     */   
/*     */   public void writeInt(int v) throws IOException {
/*  80 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/*  81 */       this.byteBuf[0] = (byte)(v >>> 24);
/*  82 */       this.byteBuf[1] = (byte)(v >>> 16);
/*  83 */       this.byteBuf[2] = (byte)(v >>> 8);
/*  84 */       this.byteBuf[3] = (byte)(v >>> 0);
/*     */     } else {
/*  86 */       this.byteBuf[0] = (byte)(v >>> 0);
/*  87 */       this.byteBuf[1] = (byte)(v >>> 8);
/*  88 */       this.byteBuf[2] = (byte)(v >>> 16);
/*  89 */       this.byteBuf[3] = (byte)(v >>> 24);
/*     */     } 
/*  91 */     write(this.byteBuf, 0, 4);
/*     */   }
/*     */   
/*     */   public void writeLong(long v) throws IOException {
/*  95 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/*  96 */       this.byteBuf[0] = (byte)(int)(v >>> 56L);
/*  97 */       this.byteBuf[1] = (byte)(int)(v >>> 48L);
/*  98 */       this.byteBuf[2] = (byte)(int)(v >>> 40L);
/*  99 */       this.byteBuf[3] = (byte)(int)(v >>> 32L);
/* 100 */       this.byteBuf[4] = (byte)(int)(v >>> 24L);
/* 101 */       this.byteBuf[5] = (byte)(int)(v >>> 16L);
/* 102 */       this.byteBuf[6] = (byte)(int)(v >>> 8L);
/* 103 */       this.byteBuf[7] = (byte)(int)(v >>> 0L);
/*     */     } else {
/* 105 */       this.byteBuf[0] = (byte)(int)(v >>> 0L);
/* 106 */       this.byteBuf[1] = (byte)(int)(v >>> 8L);
/* 107 */       this.byteBuf[2] = (byte)(int)(v >>> 16L);
/* 108 */       this.byteBuf[3] = (byte)(int)(v >>> 24L);
/* 109 */       this.byteBuf[4] = (byte)(int)(v >>> 32L);
/* 110 */       this.byteBuf[5] = (byte)(int)(v >>> 40L);
/* 111 */       this.byteBuf[6] = (byte)(int)(v >>> 48L);
/* 112 */       this.byteBuf[7] = (byte)(int)(v >>> 56L);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     write(this.byteBuf, 0, 4);
/* 119 */     write(this.byteBuf, 4, 4);
/*     */   }
/*     */   
/*     */   public void writeFloat(float v) throws IOException {
/* 123 */     writeInt(Float.floatToIntBits(v));
/*     */   }
/*     */   
/*     */   public void writeDouble(double v) throws IOException {
/* 127 */     writeLong(Double.doubleToLongBits(v));
/*     */   }
/*     */   
/*     */   public void writeBytes(String s) throws IOException {
/* 131 */     int len = s.length();
/* 132 */     for (int i = 0; i < len; i++) {
/* 133 */       write((byte)s.charAt(i));
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeChars(String s) throws IOException {
/* 138 */     int len = s.length();
/*     */     
/* 140 */     byte[] b = new byte[len * 2];
/* 141 */     int boff = 0;
/* 142 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 143 */       for (int i = 0; i < len; i++) {
/* 144 */         int v = s.charAt(i);
/* 145 */         b[boff++] = (byte)(v >>> 8);
/* 146 */         b[boff++] = (byte)(v >>> 0);
/*     */       } 
/*     */     } else {
/* 149 */       for (int i = 0; i < len; i++) {
/* 150 */         int v = s.charAt(i);
/* 151 */         b[boff++] = (byte)(v >>> 0);
/* 152 */         b[boff++] = (byte)(v >>> 8);
/*     */       } 
/*     */     } 
/*     */     
/* 156 */     write(b, 0, len * 2);
/*     */   }
/*     */   
/*     */   public void writeUTF(String s) throws IOException {
/* 160 */     int strlen = s.length();
/* 161 */     int utflen = 0;
/* 162 */     char[] charr = new char[strlen];
/* 163 */     int boff = 0;
/*     */     
/* 165 */     s.getChars(0, strlen, charr, 0);
/*     */     
/* 167 */     for (int i = 0; i < strlen; i++) {
/* 168 */       int c = charr[i];
/* 169 */       if (c >= 1 && c <= 127) {
/* 170 */         utflen++;
/* 171 */       } else if (c > 2047) {
/* 172 */         utflen += 3;
/*     */       } else {
/* 174 */         utflen += 2;
/*     */       } 
/*     */     } 
/*     */     
/* 178 */     if (utflen > 65535) {
/* 179 */       throw new UTFDataFormatException("utflen > 65536!");
/*     */     }
/*     */     
/* 182 */     byte[] b = new byte[utflen + 2];
/* 183 */     b[boff++] = (byte)(utflen >>> 8 & 0xFF);
/* 184 */     b[boff++] = (byte)(utflen >>> 0 & 0xFF);
/* 185 */     for (int j = 0; j < strlen; j++) {
/* 186 */       int c = charr[j];
/* 187 */       if (c >= 1 && c <= 127) {
/* 188 */         b[boff++] = (byte)c;
/* 189 */       } else if (c > 2047) {
/* 190 */         b[boff++] = (byte)(0xE0 | c >> 12 & 0xF);
/* 191 */         b[boff++] = (byte)(0x80 | c >> 6 & 0x3F);
/* 192 */         b[boff++] = (byte)(0x80 | c >> 0 & 0x3F);
/*     */       } else {
/* 194 */         b[boff++] = (byte)(0xC0 | c >> 6 & 0x1F);
/* 195 */         b[boff++] = (byte)(0x80 | c >> 0 & 0x3F);
/*     */       } 
/*     */     } 
/* 198 */     write(b, 0, utflen + 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeShorts(short[] s, int off, int len) throws IOException {
/* 203 */     if (off < 0 || len < 0 || off + len > s.length || off + len < 0) {
/* 204 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > s.length!");
/*     */     }
/*     */ 
/*     */     
/* 208 */     byte[] b = new byte[len * 2];
/* 209 */     int boff = 0;
/* 210 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 211 */       for (int i = 0; i < len; i++) {
/* 212 */         short v = s[off + i];
/* 213 */         b[boff++] = (byte)(v >>> 8);
/* 214 */         b[boff++] = (byte)(v >>> 0);
/*     */       } 
/*     */     } else {
/* 217 */       for (int i = 0; i < len; i++) {
/* 218 */         short v = s[off + i];
/* 219 */         b[boff++] = (byte)(v >>> 0);
/* 220 */         b[boff++] = (byte)(v >>> 8);
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     write(b, 0, len * 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeChars(char[] c, int off, int len) throws IOException {
/* 229 */     if (off < 0 || len < 0 || off + len > c.length || off + len < 0) {
/* 230 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > c.length!");
/*     */     }
/*     */ 
/*     */     
/* 234 */     byte[] b = new byte[len * 2];
/* 235 */     int boff = 0;
/* 236 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 237 */       for (int i = 0; i < len; i++) {
/* 238 */         char v = c[off + i];
/* 239 */         b[boff++] = (byte)(v >>> 8);
/* 240 */         b[boff++] = (byte)(v >>> 0);
/*     */       } 
/*     */     } else {
/* 243 */       for (int i = 0; i < len; i++) {
/* 244 */         char v = c[off + i];
/* 245 */         b[boff++] = (byte)(v >>> 0);
/* 246 */         b[boff++] = (byte)(v >>> 8);
/*     */       } 
/*     */     } 
/*     */     
/* 250 */     write(b, 0, len * 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeInts(int[] i, int off, int len) throws IOException {
/* 255 */     if (off < 0 || len < 0 || off + len > i.length || off + len < 0) {
/* 256 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > i.length!");
/*     */     }
/*     */ 
/*     */     
/* 260 */     byte[] b = new byte[len * 4];
/* 261 */     int boff = 0;
/* 262 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 263 */       for (int j = 0; j < len; j++) {
/* 264 */         int v = i[off + j];
/* 265 */         b[boff++] = (byte)(v >>> 24);
/* 266 */         b[boff++] = (byte)(v >>> 16);
/* 267 */         b[boff++] = (byte)(v >>> 8);
/* 268 */         b[boff++] = (byte)(v >>> 0);
/*     */       } 
/*     */     } else {
/* 271 */       for (int j = 0; j < len; j++) {
/* 272 */         int v = i[off + j];
/* 273 */         b[boff++] = (byte)(v >>> 0);
/* 274 */         b[boff++] = (byte)(v >>> 8);
/* 275 */         b[boff++] = (byte)(v >>> 16);
/* 276 */         b[boff++] = (byte)(v >>> 24);
/*     */       } 
/*     */     } 
/*     */     
/* 280 */     write(b, 0, len * 4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeLongs(long[] l, int off, int len) throws IOException {
/* 285 */     if (off < 0 || len < 0 || off + len > l.length || off + len < 0) {
/* 286 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > l.length!");
/*     */     }
/*     */ 
/*     */     
/* 290 */     byte[] b = new byte[len * 8];
/* 291 */     int boff = 0;
/* 292 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 293 */       for (int i = 0; i < len; i++) {
/* 294 */         long v = l[off + i];
/* 295 */         b[boff++] = (byte)(int)(v >>> 56L);
/* 296 */         b[boff++] = (byte)(int)(v >>> 48L);
/* 297 */         b[boff++] = (byte)(int)(v >>> 40L);
/* 298 */         b[boff++] = (byte)(int)(v >>> 32L);
/* 299 */         b[boff++] = (byte)(int)(v >>> 24L);
/* 300 */         b[boff++] = (byte)(int)(v >>> 16L);
/* 301 */         b[boff++] = (byte)(int)(v >>> 8L);
/* 302 */         b[boff++] = (byte)(int)(v >>> 0L);
/*     */       } 
/*     */     } else {
/* 305 */       for (int i = 0; i < len; i++) {
/* 306 */         long v = l[off + i];
/* 307 */         b[boff++] = (byte)(int)(v >>> 0L);
/* 308 */         b[boff++] = (byte)(int)(v >>> 8L);
/* 309 */         b[boff++] = (byte)(int)(v >>> 16L);
/* 310 */         b[boff++] = (byte)(int)(v >>> 24L);
/* 311 */         b[boff++] = (byte)(int)(v >>> 32L);
/* 312 */         b[boff++] = (byte)(int)(v >>> 40L);
/* 313 */         b[boff++] = (byte)(int)(v >>> 48L);
/* 314 */         b[boff++] = (byte)(int)(v >>> 56L);
/*     */       } 
/*     */     } 
/*     */     
/* 318 */     write(b, 0, len * 8);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeFloats(float[] f, int off, int len) throws IOException {
/* 323 */     if (off < 0 || len < 0 || off + len > f.length || off + len < 0) {
/* 324 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > f.length!");
/*     */     }
/*     */ 
/*     */     
/* 328 */     byte[] b = new byte[len * 4];
/* 329 */     int boff = 0;
/* 330 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 331 */       for (int i = 0; i < len; i++) {
/* 332 */         int v = Float.floatToIntBits(f[off + i]);
/* 333 */         b[boff++] = (byte)(v >>> 24);
/* 334 */         b[boff++] = (byte)(v >>> 16);
/* 335 */         b[boff++] = (byte)(v >>> 8);
/* 336 */         b[boff++] = (byte)(v >>> 0);
/*     */       } 
/*     */     } else {
/* 339 */       for (int i = 0; i < len; i++) {
/* 340 */         int v = Float.floatToIntBits(f[off + i]);
/* 341 */         b[boff++] = (byte)(v >>> 0);
/* 342 */         b[boff++] = (byte)(v >>> 8);
/* 343 */         b[boff++] = (byte)(v >>> 16);
/* 344 */         b[boff++] = (byte)(v >>> 24);
/*     */       } 
/*     */     } 
/*     */     
/* 348 */     write(b, 0, len * 4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeDoubles(double[] d, int off, int len) throws IOException {
/* 353 */     if (off < 0 || len < 0 || off + len > d.length || off + len < 0) {
/* 354 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > d.length!");
/*     */     }
/*     */ 
/*     */     
/* 358 */     byte[] b = new byte[len * 8];
/* 359 */     int boff = 0;
/* 360 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 361 */       for (int i = 0; i < len; i++) {
/* 362 */         long v = Double.doubleToLongBits(d[off + i]);
/* 363 */         b[boff++] = (byte)(int)(v >>> 56L);
/* 364 */         b[boff++] = (byte)(int)(v >>> 48L);
/* 365 */         b[boff++] = (byte)(int)(v >>> 40L);
/* 366 */         b[boff++] = (byte)(int)(v >>> 32L);
/* 367 */         b[boff++] = (byte)(int)(v >>> 24L);
/* 368 */         b[boff++] = (byte)(int)(v >>> 16L);
/* 369 */         b[boff++] = (byte)(int)(v >>> 8L);
/* 370 */         b[boff++] = (byte)(int)(v >>> 0L);
/*     */       } 
/*     */     } else {
/* 373 */       for (int i = 0; i < len; i++) {
/* 374 */         long v = Double.doubleToLongBits(d[off + i]);
/* 375 */         b[boff++] = (byte)(int)(v >>> 0L);
/* 376 */         b[boff++] = (byte)(int)(v >>> 8L);
/* 377 */         b[boff++] = (byte)(int)(v >>> 16L);
/* 378 */         b[boff++] = (byte)(int)(v >>> 24L);
/* 379 */         b[boff++] = (byte)(int)(v >>> 32L);
/* 380 */         b[boff++] = (byte)(int)(v >>> 40L);
/* 381 */         b[boff++] = (byte)(int)(v >>> 48L);
/* 382 */         b[boff++] = (byte)(int)(v >>> 56L);
/*     */       } 
/*     */     } 
/*     */     
/* 386 */     write(b, 0, len * 8);
/*     */   }
/*     */   
/*     */   public void writeBit(int bit) throws IOException {
/* 390 */     writeBits(0x1L & bit, 1);
/*     */   }
/*     */   
/*     */   public void writeBits(long bits, int numBits) throws IOException {
/* 394 */     checkClosed();
/*     */     
/* 396 */     if (numBits < 0 || numBits > 64) {
/* 397 */       throw new IllegalArgumentException("Bad value for numBits!");
/*     */     }
/* 399 */     if (numBits == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 407 */     if (getStreamPosition() > 0L || this.bitOffset > 0) {
/* 408 */       int offset = this.bitOffset;
/* 409 */       int partialByte = read();
/* 410 */       if (partialByte != -1) {
/* 411 */         seek(getStreamPosition() - 1L);
/*     */       } else {
/* 413 */         partialByte = 0;
/*     */       } 
/*     */       
/* 416 */       if (numBits + offset < 8) {
/*     */         
/* 418 */         int shift = 8 - offset + numBits;
/* 419 */         int mask = -1 >>> 32 - numBits;
/* 420 */         partialByte &= mask << shift ^ 0xFFFFFFFF;
/* 421 */         partialByte = (int)(partialByte | (bits & mask) << shift);
/* 422 */         write(partialByte);
/* 423 */         seek(getStreamPosition() - 1L);
/* 424 */         this.bitOffset = offset + numBits;
/* 425 */         numBits = 0;
/*     */       } else {
/*     */         
/* 428 */         int num = 8 - offset;
/* 429 */         int mask = -1 >>> 32 - num;
/* 430 */         partialByte &= mask ^ 0xFFFFFFFF;
/* 431 */         partialByte = (int)(partialByte | bits >> numBits - num & mask);
/*     */ 
/*     */         
/* 434 */         write(partialByte);
/* 435 */         numBits -= num;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 440 */     if (numBits > 7) {
/* 441 */       int extra = numBits % 8;
/* 442 */       for (int numBytes = numBits / 8; numBytes > 0; numBytes--) {
/* 443 */         int shift = (numBytes - 1) * 8 + extra;
/* 444 */         int value = (int)((shift == 0) ? (bits & 0xFFL) : (bits >> shift & 0xFFL));
/*     */ 
/*     */         
/* 447 */         write(value);
/*     */       } 
/* 449 */       numBits = extra;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 455 */     if (numBits != 0) {
/*     */ 
/*     */       
/* 458 */       int partialByte = 0;
/* 459 */       partialByte = read();
/* 460 */       if (partialByte != -1) {
/* 461 */         seek(getStreamPosition() - 1L);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 466 */         partialByte = 0;
/*     */       } 
/*     */       
/* 469 */       int shift = 8 - numBits;
/* 470 */       int mask = -1 >>> 32 - numBits;
/* 471 */       partialByte &= mask << shift ^ 0xFFFFFFFF;
/* 472 */       partialByte = (int)(partialByte | (bits & mask) << shift);
/*     */       
/* 474 */       write(partialByte);
/* 475 */       seek(getStreamPosition() - 1L);
/* 476 */       this.bitOffset = numBits;
/*     */     } 
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
/*     */   protected final void flushBits() throws IOException {
/* 490 */     checkClosed();
/* 491 */     if (this.bitOffset != 0) {
/* 492 */       int offset = this.bitOffset;
/* 493 */       int partialByte = read();
/* 494 */       if (partialByte < 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 499 */         partialByte = 0;
/* 500 */         this.bitOffset = 0;
/*     */       } else {
/*     */         
/* 503 */         seek(getStreamPosition() - 1L);
/* 504 */         partialByte &= -1 << 8 - offset;
/*     */       } 
/* 506 */       write(partialByte);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/stream/ImageOutputStreamImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */