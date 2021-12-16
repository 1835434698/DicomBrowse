/*     */ package org.dcm4che3.android.stream;
/*     */ 
/*     */

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Stack;

/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ImageInputStreamImpl
/*     */   implements ImageInputStream
/*     */ {
/*  46 */   private Stack markByteStack = new Stack();
/*     */ 
/*     */   
/*  49 */   private Stack markBitStack = new Stack();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isClosed = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int BYTE_BUF_LENGTH = 8192;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   byte[] byteBuf = new byte[8192];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   protected ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected long streamPos;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int bitOffset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   protected long flushedPos = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void checkClosed() throws IOException {
/* 111 */     if (this.isClosed) {
/* 112 */       throw new IOException("closed");
/*     */     }
/*     */   }
/*     */   
/*     */   public void setByteOrder(ByteOrder byteOrder) {
/* 117 */     this.byteOrder = byteOrder;
/*     */   }
/*     */   
/*     */   public ByteOrder getByteOrder() {
/* 121 */     return this.byteOrder;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int read() throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(byte[] b) throws IOException {
/* 157 */     return read(b, 0, b.length);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readBytes(IIOByteBuffer buf, int len) throws IOException {
/* 190 */     if (len < 0) {
/* 191 */       throw new IndexOutOfBoundsException("len < 0!");
/*     */     }
/* 193 */     if (buf == null) {
/* 194 */       throw new NullPointerException("buf == null!");
/*     */     }
/*     */     
/* 197 */     byte[] data = new byte[len];
/* 198 */     len = read(data, 0, len);
/*     */     
/* 200 */     buf.setData(data);
/* 201 */     buf.setOffset(0);
/* 202 */     buf.setLength(len);
/*     */   }
/*     */   
/*     */   public boolean readBoolean() throws IOException {
/* 206 */     int ch = read();
/* 207 */     if (ch < 0) {
/* 208 */       throw new EOFException();
/*     */     }
/* 210 */     return (ch != 0);
/*     */   }
/*     */   
/*     */   public byte readByte() throws IOException {
/* 214 */     int ch = read();
/* 215 */     if (ch < 0) {
/* 216 */       throw new EOFException();
/*     */     }
/* 218 */     return (byte)ch;
/*     */   }
/*     */   
/*     */   public int readUnsignedByte() throws IOException {
/* 222 */     int ch = read();
/* 223 */     if (ch < 0) {
/* 224 */       throw new EOFException();
/*     */     }
/* 226 */     return ch;
/*     */   }
/*     */   
/*     */   public short readShort() throws IOException {
/* 230 */     if (read(this.byteBuf, 0, 2) < 0) {
/* 231 */       throw new EOFException();
/*     */     }
/*     */     
/* 234 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 235 */       return (short)((this.byteBuf[0] & 0xFF) << 8 | (this.byteBuf[1] & 0xFF) << 0);
/*     */     }
/*     */     
/* 238 */     return (short)((this.byteBuf[1] & 0xFF) << 8 | (this.byteBuf[0] & 0xFF) << 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int readUnsignedShort() throws IOException {
/* 244 */     return readShort() & 0xFFFF;
/*     */   }
/*     */   
/*     */   public char readChar() throws IOException {
/* 248 */     return (char)readShort();
/*     */   }
/*     */   
/*     */   public int readInt() throws IOException {
/* 252 */     if (read(this.byteBuf, 0, 4) < 0) {
/* 253 */       throw new EOFException();
/*     */     }
/*     */     
/* 256 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 257 */       return (this.byteBuf[0] & 0xFF) << 24 | (this.byteBuf[1] & 0xFF) << 16 | (this.byteBuf[2] & 0xFF) << 8 | (this.byteBuf[3] & 0xFF) << 0;
/*     */     }
/*     */ 
/*     */     
/* 261 */     return (this.byteBuf[3] & 0xFF) << 24 | (this.byteBuf[2] & 0xFF) << 16 | (this.byteBuf[1] & 0xFF) << 8 | (this.byteBuf[0] & 0xFF) << 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long readUnsignedInt() throws IOException {
/* 268 */     return readInt() & 0xFFFFFFFFL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long readLong() throws IOException {
/* 275 */     int i1 = readInt();
/* 276 */     int i2 = readInt();
/*     */     
/* 278 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 279 */       return (i1 << 32L) + (i2 & 0xFFFFFFFFL);
/*     */     }
/* 281 */     return (i2 << 32L) + (i1 & 0xFFFFFFFFL);
/*     */   }
/*     */ 
/*     */   
/*     */   public float readFloat() throws IOException {
/* 286 */     return Float.intBitsToFloat(readInt());
/*     */   }
/*     */   
/*     */   public double readDouble() throws IOException {
/* 290 */     return Double.longBitsToDouble(readLong());
/*     */   }
/*     */   
/*     */   public String readLine() throws IOException {
/* 294 */     StringBuffer input = new StringBuffer();
/* 295 */     int c = -1;
/* 296 */     boolean eol = false;
/*     */     
/* 298 */     while (!eol) {
/* 299 */       long cur; switch (c = read()) {
/*     */         case -1:
/*     */         case 10:
/* 302 */           eol = true;
/*     */           continue;
/*     */         case 13:
/* 305 */           eol = true;
/* 306 */           cur = getStreamPosition();
/* 307 */           if (read() != 10) {
/* 308 */             seek(cur);
/*     */           }
/*     */           continue;
/*     */       } 
/* 312 */       input.append((char)c);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 317 */     if (c == -1 && input.length() == 0) {
/* 318 */       return null;
/*     */     }
/* 320 */     return input.toString();
/*     */   }
/*     */   public String readUTF() throws IOException {
/*     */     String ret;
/* 324 */     this.bitOffset = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 329 */     ByteOrder oldByteOrder = getByteOrder();
/* 330 */     setByteOrder(ByteOrder.BIG_ENDIAN);
/*     */ 
/*     */     
/*     */     try {
/* 334 */       ret = DataInputStream.readUTF(this);
/* 335 */     } catch (IOException e) {
/*     */       
/* 337 */       setByteOrder(oldByteOrder);
/* 338 */       throw e;
/*     */     } 
/*     */     
/* 341 */     setByteOrder(oldByteOrder);
/* 342 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFully(byte[] b, int off, int len) throws IOException {
/* 347 */     if (off < 0 || len < 0 || off + len > b.length || off + len < 0) {
/* 348 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > b.length!");
/*     */     }
/*     */ 
/*     */     
/* 352 */     while (len > 0) {
/* 353 */       int nbytes = read(b, off, len);
/* 354 */       if (nbytes == -1) {
/* 355 */         throw new EOFException();
/*     */       }
/* 357 */       off += nbytes;
/* 358 */       len -= nbytes;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void readFully(byte[] b) throws IOException {
/* 363 */     readFully(b, 0, b.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFully(short[] s, int off, int len) throws IOException {
/* 368 */     if (off < 0 || len < 0 || off + len > s.length || off + len < 0) {
/* 369 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > s.length!");
/*     */     }
/*     */ 
/*     */     
/* 373 */     while (len > 0) {
/* 374 */       int nelts = Math.min(len, this.byteBuf.length / 2);
/* 375 */       readFully(this.byteBuf, 0, nelts * 2);
/* 376 */       toShorts(this.byteBuf, s, off, nelts);
/* 377 */       off += nelts;
/* 378 */       len -= nelts;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFully(char[] c, int off, int len) throws IOException {
/* 384 */     if (off < 0 || len < 0 || off + len > c.length || off + len < 0) {
/* 385 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > c.length!");
/*     */     }
/*     */ 
/*     */     
/* 389 */     while (len > 0) {
/* 390 */       int nelts = Math.min(len, this.byteBuf.length / 2);
/* 391 */       readFully(this.byteBuf, 0, nelts * 2);
/* 392 */       toChars(this.byteBuf, c, off, nelts);
/* 393 */       off += nelts;
/* 394 */       len -= nelts;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFully(int[] i, int off, int len) throws IOException {
/* 400 */     if (off < 0 || len < 0 || off + len > i.length || off + len < 0) {
/* 401 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > i.length!");
/*     */     }
/*     */ 
/*     */     
/* 405 */     while (len > 0) {
/* 406 */       int nelts = Math.min(len, this.byteBuf.length / 4);
/* 407 */       readFully(this.byteBuf, 0, nelts * 4);
/* 408 */       toInts(this.byteBuf, i, off, nelts);
/* 409 */       off += nelts;
/* 410 */       len -= nelts;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFully(long[] l, int off, int len) throws IOException {
/* 416 */     if (off < 0 || len < 0 || off + len > l.length || off + len < 0) {
/* 417 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > l.length!");
/*     */     }
/*     */ 
/*     */     
/* 421 */     while (len > 0) {
/* 422 */       int nelts = Math.min(len, this.byteBuf.length / 8);
/* 423 */       readFully(this.byteBuf, 0, nelts * 8);
/* 424 */       toLongs(this.byteBuf, l, off, nelts);
/* 425 */       off += nelts;
/* 426 */       len -= nelts;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFully(float[] f, int off, int len) throws IOException {
/* 432 */     if (off < 0 || len < 0 || off + len > f.length || off + len < 0) {
/* 433 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > f.length!");
/*     */     }
/*     */ 
/*     */     
/* 437 */     while (len > 0) {
/* 438 */       int nelts = Math.min(len, this.byteBuf.length / 4);
/* 439 */       readFully(this.byteBuf, 0, nelts * 4);
/* 440 */       toFloats(this.byteBuf, f, off, nelts);
/* 441 */       off += nelts;
/* 442 */       len -= nelts;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFully(double[] d, int off, int len) throws IOException {
/* 448 */     if (off < 0 || len < 0 || off + len > d.length || off + len < 0) {
/* 449 */       throw new IndexOutOfBoundsException("off < 0 || len < 0 || off + len > d.length!");
/*     */     }
/*     */ 
/*     */     
/* 453 */     while (len > 0) {
/* 454 */       int nelts = Math.min(len, this.byteBuf.length / 8);
/* 455 */       readFully(this.byteBuf, 0, nelts * 8);
/* 456 */       toDoubles(this.byteBuf, d, off, nelts);
/* 457 */       off += nelts;
/* 458 */       len -= nelts;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void toShorts(byte[] b, short[] s, int off, int len) {
/* 463 */     int boff = 0;
/* 464 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 465 */       for (int j = 0; j < len; j++) {
/* 466 */         int b0 = b[boff];
/* 467 */         int b1 = b[boff + 1] & 0xFF;
/* 468 */         s[off + j] = (short)(b0 << 8 | b1);
/* 469 */         boff += 2;
/*     */       } 
/*     */     } else {
/* 472 */       for (int j = 0; j < len; j++) {
/* 473 */         int b0 = b[boff + 1];
/* 474 */         int b1 = b[boff] & 0xFF;
/* 475 */         s[off + j] = (short)(b0 << 8 | b1);
/* 476 */         boff += 2;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void toChars(byte[] b, char[] c, int off, int len) {
/* 482 */     int boff = 0;
/* 483 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 484 */       for (int j = 0; j < len; j++) {
/* 485 */         int b0 = b[boff];
/* 486 */         int b1 = b[boff + 1] & 0xFF;
/* 487 */         c[off + j] = (char)(b0 << 8 | b1);
/* 488 */         boff += 2;
/*     */       } 
/*     */     } else {
/* 491 */       for (int j = 0; j < len; j++) {
/* 492 */         int b0 = b[boff + 1];
/* 493 */         int b1 = b[boff] & 0xFF;
/* 494 */         c[off + j] = (char)(b0 << 8 | b1);
/* 495 */         boff += 2;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void toInts(byte[] b, int[] i, int off, int len) {
/* 501 */     int boff = 0;
/* 502 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 503 */       for (int j = 0; j < len; j++) {
/* 504 */         int b0 = b[boff];
/* 505 */         int b1 = b[boff + 1] & 0xFF;
/* 506 */         int b2 = b[boff + 2] & 0xFF;
/* 507 */         int b3 = b[boff + 3] & 0xFF;
/* 508 */         i[off + j] = b0 << 24 | b1 << 16 | b2 << 8 | b3;
/* 509 */         boff += 4;
/*     */       } 
/*     */     } else {
/* 512 */       for (int j = 0; j < len; j++) {
/* 513 */         int b0 = b[boff + 3];
/* 514 */         int b1 = b[boff + 2] & 0xFF;
/* 515 */         int b2 = b[boff + 1] & 0xFF;
/* 516 */         int b3 = b[boff] & 0xFF;
/* 517 */         i[off + j] = b0 << 24 | b1 << 16 | b2 << 8 | b3;
/* 518 */         boff += 4;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void toLongs(byte[] b, long[] l, int off, int len) {
/* 524 */     int boff = 0;
/* 525 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 526 */       for (int j = 0; j < len; j++) {
/* 527 */         int b0 = b[boff];
/* 528 */         int b1 = b[boff + 1] & 0xFF;
/* 529 */         int b2 = b[boff + 2] & 0xFF;
/* 530 */         int b3 = b[boff + 3] & 0xFF;
/* 531 */         int b4 = b[boff + 4];
/* 532 */         int b5 = b[boff + 5] & 0xFF;
/* 533 */         int b6 = b[boff + 6] & 0xFF;
/* 534 */         int b7 = b[boff + 7] & 0xFF;
/*     */         
/* 536 */         int i0 = b0 << 24 | b1 << 16 | b2 << 8 | b3;
/* 537 */         int i1 = b4 << 24 | b5 << 16 | b6 << 8 | b7;
/*     */         
/* 539 */         l[off + j] = i0 << 32L | i1 & 0xFFFFFFFFL;
/* 540 */         boff += 8;
/*     */       } 
/*     */     } else {
/* 543 */       for (int j = 0; j < len; j++) {
/* 544 */         int b0 = b[boff + 7];
/* 545 */         int b1 = b[boff + 6] & 0xFF;
/* 546 */         int b2 = b[boff + 5] & 0xFF;
/* 547 */         int b3 = b[boff + 4] & 0xFF;
/* 548 */         int b4 = b[boff + 3];
/* 549 */         int b5 = b[boff + 2] & 0xFF;
/* 550 */         int b6 = b[boff + 1] & 0xFF;
/* 551 */         int b7 = b[boff] & 0xFF;
/*     */         
/* 553 */         int i0 = b0 << 24 | b1 << 16 | b2 << 8 | b3;
/* 554 */         int i1 = b4 << 24 | b5 << 16 | b6 << 8 | b7;
/*     */         
/* 556 */         l[off + j] = i0 << 32L | i1 & 0xFFFFFFFFL;
/* 557 */         boff += 8;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void toFloats(byte[] b, float[] f, int off, int len) {
/* 563 */     int boff = 0;
/* 564 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 565 */       for (int j = 0; j < len; j++) {
/* 566 */         int b0 = b[boff];
/* 567 */         int b1 = b[boff + 1] & 0xFF;
/* 568 */         int b2 = b[boff + 2] & 0xFF;
/* 569 */         int b3 = b[boff + 3] & 0xFF;
/* 570 */         int i = b0 << 24 | b1 << 16 | b2 << 8 | b3;
/* 571 */         f[off + j] = Float.intBitsToFloat(i);
/* 572 */         boff += 4;
/*     */       } 
/*     */     } else {
/* 575 */       for (int j = 0; j < len; j++) {
/* 576 */         int b0 = b[boff + 3];
/* 577 */         int b1 = b[boff + 2] & 0xFF;
/* 578 */         int b2 = b[boff + 1] & 0xFF;
/* 579 */         int b3 = b[boff + 0] & 0xFF;
/* 580 */         int i = b0 << 24 | b1 << 16 | b2 << 8 | b3;
/* 581 */         f[off + j] = Float.intBitsToFloat(i);
/* 582 */         boff += 4;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void toDoubles(byte[] b, double[] d, int off, int len) {
/* 588 */     int boff = 0;
/* 589 */     if (this.byteOrder == ByteOrder.BIG_ENDIAN) {
/* 590 */       for (int j = 0; j < len; j++) {
/* 591 */         int b0 = b[boff];
/* 592 */         int b1 = b[boff + 1] & 0xFF;
/* 593 */         int b2 = b[boff + 2] & 0xFF;
/* 594 */         int b3 = b[boff + 3] & 0xFF;
/* 595 */         int b4 = b[boff + 4];
/* 596 */         int b5 = b[boff + 5] & 0xFF;
/* 597 */         int b6 = b[boff + 6] & 0xFF;
/* 598 */         int b7 = b[boff + 7] & 0xFF;
/*     */         
/* 600 */         int i0 = b0 << 24 | b1 << 16 | b2 << 8 | b3;
/* 601 */         int i1 = b4 << 24 | b5 << 16 | b6 << 8 | b7;
/* 602 */         long l = i0 << 32L | i1 & 0xFFFFFFFFL;
/*     */         
/* 604 */         d[off + j] = Double.longBitsToDouble(l);
/* 605 */         boff += 8;
/*     */       } 
/*     */     } else {
/* 608 */       for (int j = 0; j < len; j++) {
/* 609 */         int b0 = b[boff + 7];
/* 610 */         int b1 = b[boff + 6] & 0xFF;
/* 611 */         int b2 = b[boff + 5] & 0xFF;
/* 612 */         int b3 = b[boff + 4] & 0xFF;
/* 613 */         int b4 = b[boff + 3];
/* 614 */         int b5 = b[boff + 2] & 0xFF;
/* 615 */         int b6 = b[boff + 1] & 0xFF;
/* 616 */         int b7 = b[boff] & 0xFF;
/*     */         
/* 618 */         int i0 = b0 << 24 | b1 << 16 | b2 << 8 | b3;
/* 619 */         int i1 = b4 << 24 | b5 << 16 | b6 << 8 | b7;
/* 620 */         long l = i0 << 32L | i1 & 0xFFFFFFFFL;
/*     */         
/* 622 */         d[off + j] = Double.longBitsToDouble(l);
/* 623 */         boff += 8;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public long getStreamPosition() throws IOException {
/* 629 */     checkClosed();
/* 630 */     return this.streamPos;
/*     */   }
/*     */   
/*     */   public int getBitOffset() throws IOException {
/* 634 */     checkClosed();
/* 635 */     return this.bitOffset;
/*     */   }
/*     */   
/*     */   public void setBitOffset(int bitOffset) throws IOException {
/* 639 */     checkClosed();
/* 640 */     if (bitOffset < 0 || bitOffset > 7) {
/* 641 */       throw new IllegalArgumentException("bitOffset must be betwwen 0 and 7!");
/*     */     }
/* 643 */     this.bitOffset = bitOffset;
/*     */   }
/*     */   
/*     */   public int readBit() throws IOException {
/* 647 */     checkClosed();
/*     */ 
/*     */     
/* 650 */     int newBitOffset = this.bitOffset + 1 & 0x7;
/*     */     
/* 652 */     int val = read();
/* 653 */     if (val == -1) {
/* 654 */       throw new EOFException();
/*     */     }
/*     */     
/* 657 */     if (newBitOffset != 0) {
/*     */       
/* 659 */       seek(getStreamPosition() - 1L);
/*     */       
/* 661 */       val >>= 8 - newBitOffset;
/*     */     } 
/* 663 */     this.bitOffset = newBitOffset;
/*     */     
/* 665 */     return val & 0x1;
/*     */   }
/*     */   
/*     */   public long readBits(int numBits) throws IOException {
/* 669 */     checkClosed();
/*     */     
/* 671 */     if (numBits < 0 || numBits > 64) {
/* 672 */       throw new IllegalArgumentException();
/*     */     }
/* 674 */     if (numBits == 0) {
/* 675 */       return 0L;
/*     */     }
/*     */ 
/*     */     
/* 679 */     int bitsToRead = numBits + this.bitOffset;
/*     */ 
/*     */     
/* 682 */     int newBitOffset = this.bitOffset + numBits & 0x7;
/*     */ 
/*     */     
/* 685 */     long accum = 0L;
/* 686 */     while (bitsToRead > 0) {
/* 687 */       int val = read();
/* 688 */       if (val == -1) {
/* 689 */         throw new EOFException();
/*     */       }
/*     */       
/* 692 */       accum <<= 8L;
/* 693 */       accum |= val;
/* 694 */       bitsToRead -= 8;
/*     */     } 
/*     */ 
/*     */     
/* 698 */     if (newBitOffset != 0) {
/* 699 */       seek(getStreamPosition() - 1L);
/*     */     }
/* 701 */     this.bitOffset = newBitOffset;
/*     */ 
/*     */     
/* 704 */     accum >>>= -bitsToRead;
/*     */ 
/*     */     
/* 707 */     accum &= -1L >>> 64 - numBits;
/*     */     
/* 709 */     return accum;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long length() {
/* 720 */     return -1L;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int skipBytes(int n) throws IOException {
/* 739 */     long pos = getStreamPosition();
/* 740 */     seek(pos + n);
/* 741 */     return (int)(getStreamPosition() - pos);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long skipBytes(long n) throws IOException {
/* 760 */     long pos = getStreamPosition();
/* 761 */     seek(pos + n);
/* 762 */     return getStreamPosition() - pos;
/*     */   }
/*     */   
/*     */   public void seek(long pos) throws IOException {
/* 766 */     checkClosed();
/*     */ 
/*     */     
/* 769 */     if (pos < this.flushedPos) {
/* 770 */       throw new IndexOutOfBoundsException("pos < flushedPos!");
/*     */     }
/*     */     
/* 773 */     this.streamPos = pos;
/* 774 */     this.bitOffset = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mark() {
/*     */     try {
/* 784 */       this.markByteStack.push(Long.valueOf(getStreamPosition()));
/* 785 */       this.markBitStack.push(Integer.valueOf(getBitOffset()));
/* 786 */     } catch (IOException e) {}
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
/*     */   
/*     */   public void reset() throws IOException {
/* 800 */     if (this.markByteStack.empty()) {
/*     */       return;
/*     */     }
/*     */     
/* 804 */     long pos = ((Long)this.markByteStack.pop()).longValue();
/* 805 */     if (pos < this.flushedPos) {
/* 806 */       throw new IOException("Previous marked position has been discarded!");
/*     */     }
/*     */     
/* 809 */     seek(pos);
/*     */     
/* 811 */     int offset = ((Integer)this.markBitStack.pop()).intValue();
/* 812 */     setBitOffset(offset);
/*     */   }
/*     */   
/*     */   public void flushBefore(long pos) throws IOException {
/* 816 */     checkClosed();
/* 817 */     if (pos < this.flushedPos) {
/* 818 */       throw new IndexOutOfBoundsException("pos < flushedPos!");
/*     */     }
/* 820 */     if (pos > getStreamPosition()) {
/* 821 */       throw new IndexOutOfBoundsException("pos > getStreamPosition()!");
/*     */     }
/*     */     
/* 824 */     this.flushedPos = pos;
/*     */   }
/*     */   
/*     */   public void flush() throws IOException {
/* 828 */     flushBefore(getStreamPosition());
/*     */   }
/*     */   
/*     */   public long getFlushedPosition() {
/* 832 */     return this.flushedPos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCached() {
/* 840 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCachedMemory() {
/* 848 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCachedFile() {
/* 856 */     return false;
/*     */   }
/*     */   
/*     */   public void close() throws IOException {
/* 860 */     checkClosed();
/*     */     
/* 862 */     this.isClosed = true;
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
/*     */   protected void finalize() throws Throwable {
/* 875 */     if (!this.isClosed) {
/*     */       try {
/* 877 */         close();
/* 878 */       } catch (IOException e) {}
/*     */     }
/*     */     
/* 881 */     super.finalize();
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/stream/ImageInputStreamImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */