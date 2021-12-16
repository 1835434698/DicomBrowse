/*     */ package org.dcm4che3.android.stream;
/*     */ 
/*     */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class MemoryCache
/*     */ {
/*     */   private static final int BUFFER_LENGTH = 8192;
/*  61 */   private ArrayList cache = new ArrayList();
/*     */ 
/*     */   
/*  64 */   private long cacheStart = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   private long length = 0L;
/*     */   
/*     */   private byte[] getCacheBlock(long blockNum) throws IOException {
/*  72 */     long blockOffset = blockNum - this.cacheStart;
/*  73 */     if (blockOffset > 2147483647L)
/*     */     {
/*     */       
/*  76 */       throw new IOException("Cache addressing limit exceeded!");
/*     */     }
/*  78 */     return (byte[]) this.cache.get((int)blockOffset);
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
/*     */   public long loadFromStream(InputStream stream, long pos) throws IOException {
/*  91 */     if (pos < this.length) {
/*  92 */       return pos;
/*     */     }
/*     */     
/*  95 */     int offset = (int)(this.length % 8192L);
/*  96 */     byte[] buf = null;
/*     */     
/*  98 */     long len = pos - this.length;
/*  99 */     if (offset != 0) {
/* 100 */       buf = getCacheBlock(this.length / 8192L);
/*     */     }
/*     */     
/* 103 */     while (len > 0L) {
/* 104 */       if (buf == null) {
/*     */         try {
/* 106 */           buf = new byte[8192];
/* 107 */         } catch (OutOfMemoryError e) {
/* 108 */           throw new IOException("No memory left for cache!");
/*     */         } 
/* 110 */         offset = 0;
/*     */       } 
/*     */       
/* 113 */       int left = 8192 - offset;
/* 114 */       int nbytes = (int)Math.min(len, left);
/* 115 */       nbytes = stream.read(buf, offset, nbytes);
/* 116 */       if (nbytes == -1) {
/* 117 */         return this.length;
/*     */       }
/*     */       
/* 120 */       if (offset == 0) {
/* 121 */         this.cache.add(buf);
/*     */       }
/*     */       
/* 124 */       len -= nbytes;
/* 125 */       this.length += nbytes;
/* 126 */       offset += nbytes;
/*     */       
/* 128 */       if (offset >= 8192)
/*     */       {
/*     */         
/* 131 */         buf = null;
/*     */       }
/*     */     } 
/*     */     
/* 135 */     return pos;
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
/*     */   public void writeToStream(OutputStream stream, long pos, long len) throws IOException {
/* 151 */     if (pos + len > this.length) {
/* 152 */       throw new IndexOutOfBoundsException("Argument out of cache");
/*     */     }
/* 154 */     if (pos < 0L || len < 0L) {
/* 155 */       throw new IndexOutOfBoundsException("Negative pos or len");
/*     */     }
/* 157 */     if (len == 0L) {
/*     */       return;
/*     */     }
/*     */     
/* 161 */     long bufIndex = pos / 8192L;
/* 162 */     if (bufIndex < this.cacheStart) {
/* 163 */       throw new IndexOutOfBoundsException("pos already disposed");
/*     */     }
/* 165 */     int offset = (int)(pos % 8192L);
/*     */     
/* 167 */     byte[] buf = getCacheBlock(bufIndex++);
/* 168 */     while (len > 0L) {
/* 169 */       if (buf == null) {
/* 170 */         buf = getCacheBlock(bufIndex++);
/* 171 */         offset = 0;
/*     */       } 
/* 173 */       int nbytes = (int)Math.min(len, (8192 - offset));
/* 174 */       stream.write(buf, offset, nbytes);
/* 175 */       buf = null;
/* 176 */       len -= nbytes;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pad(long pos) throws IOException {
/* 185 */     long currIndex = this.cacheStart + this.cache.size() - 1L;
/* 186 */     long lastIndex = pos / 8192L;
/* 187 */     long numNewBuffers = lastIndex - currIndex; long i;
/* 188 */     for (i = 0L; i < numNewBuffers; i++) {
/*     */       try {
/* 190 */         this.cache.add(new byte[8192]);
/* 191 */       } catch (OutOfMemoryError e) {
/* 192 */         throw new IOException("No memory left for cache!");
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(byte[] b, int off, int len, long pos) throws IOException {
/* 214 */     if (b == null) {
/* 215 */       throw new NullPointerException("b == null!");
/*     */     }
/*     */     
/* 218 */     if (off < 0 || len < 0 || pos < 0L || off + len > b.length || off + len < 0)
/*     */     {
/* 220 */       throw new IndexOutOfBoundsException();
/*     */     }
/*     */ 
/*     */     
/* 224 */     long lastPos = pos + len - 1L;
/* 225 */     if (lastPos >= this.length) {
/* 226 */       pad(lastPos);
/* 227 */       this.length = lastPos + 1L;
/*     */     } 
/*     */ 
/*     */     
/* 231 */     int offset = (int)(pos % 8192L);
/* 232 */     while (len > 0) {
/* 233 */       byte[] buf = getCacheBlock(pos / 8192L);
/* 234 */       int nbytes = Math.min(len, 8192 - offset);
/* 235 */       System.arraycopy(b, off, buf, offset, nbytes);
/*     */       
/* 237 */       pos += nbytes;
/* 238 */       off += nbytes;
/* 239 */       len -= nbytes;
/* 240 */       offset = 0;
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
/*     */ 
/*     */   
/*     */   public void write(int b, long pos) throws IOException {
/* 256 */     if (pos < 0L) {
/* 257 */       throw new ArrayIndexOutOfBoundsException("pos < 0");
/*     */     }
/*     */ 
/*     */     
/* 261 */     if (pos >= this.length) {
/* 262 */       pad(pos);
/* 263 */       this.length = pos + 1L;
/*     */     } 
/*     */ 
/*     */     
/* 267 */     byte[] buf = getCacheBlock(pos / 8192L);
/* 268 */     int offset = (int)(pos % 8192L);
/* 269 */     buf[offset] = (byte)b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLength() {
/* 278 */     return this.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(long pos) throws IOException {
/* 287 */     if (pos >= this.length) {
/* 288 */       return -1;
/*     */     }
/*     */     
/* 291 */     byte[] buf = getCacheBlock(pos / 8192L);
/* 292 */     if (buf == null) {
/* 293 */       return -1;
/*     */     }
/*     */     
/* 296 */     return buf[(int)(pos % 8192L)] & 0xFF;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void read(byte[] b, int off, int len, long pos) throws IOException {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnonnull -> 14
/*     */     //   4: new java/lang/NullPointerException
/*     */     //   7: dup
/*     */     //   8: ldc 'b == null!'
/*     */     //   10: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   13: athrow
/*     */     //   14: iload_2
/*     */     //   15: iflt -> 43
/*     */     //   18: iload_3
/*     */     //   19: iflt -> 43
/*     */     //   22: lload #4
/*     */     //   24: lconst_0
/*     */     //   25: lcmp
/*     */     //   26: iflt -> 43
/*     */     //   29: iload_2
/*     */     //   30: iload_3
/*     */     //   31: iadd
/*     */     //   32: aload_1
/*     */     //   33: arraylength
/*     */     //   34: if_icmpgt -> 43
/*     */     //   37: iload_2
/*     */     //   38: iload_3
/*     */     //   39: iadd
/*     */     //   40: ifge -> 51
/*     */     //   43: new java/lang/IndexOutOfBoundsException
/*     */     //   46: dup
/*     */     //   47: invokespecial <init> : ()V
/*     */     //   50: athrow
/*     */     //   51: lload #4
/*     */     //   53: iload_3
/*     */     //   54: i2l
/*     */     //   55: ladd
/*     */     //   56: aload_0
/*     */     //   57: getfield length : J
/*     */     //   60: lcmp
/*     */     //   61: ifle -> 72
/*     */     //   64: new java/lang/IndexOutOfBoundsException
/*     */     //   67: dup
/*     */     //   68: invokespecial <init> : ()V
/*     */     //   71: athrow
/*     */     //   72: lload #4
/*     */     //   74: ldc2_w 8192
/*     */     //   77: ldiv
/*     */     //   78: lstore #6
/*     */     //   80: lload #4
/*     */     //   82: l2i
/*     */     //   83: sipush #8192
/*     */     //   86: irem
/*     */     //   87: istore #8
/*     */     //   89: iload_3
/*     */     //   90: ifle -> 145
/*     */     //   93: iload_3
/*     */     //   94: sipush #8192
/*     */     //   97: iload #8
/*     */     //   99: isub
/*     */     //   100: invokestatic min : (II)I
/*     */     //   103: istore #9
/*     */     //   105: aload_0
/*     */     //   106: lload #6
/*     */     //   108: dup2
/*     */     //   109: lconst_1
/*     */     //   110: ladd
/*     */     //   111: lstore #6
/*     */     //   113: invokespecial getCacheBlock : (J)[B
/*     */     //   116: astore #10
/*     */     //   118: aload #10
/*     */     //   120: iload #8
/*     */     //   122: aload_1
/*     */     //   123: iload_2
/*     */     //   124: iload #9
/*     */     //   126: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*     */     //   129: iload_3
/*     */     //   130: iload #9
/*     */     //   132: isub
/*     */     //   133: istore_3
/*     */     //   134: iload_2
/*     */     //   135: iload #9
/*     */     //   137: iadd
/*     */     //   138: istore_2
/*     */     //   139: iconst_0
/*     */     //   140: istore #8
/*     */     //   142: goto -> 89
/*     */     //   145: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #313	-> 0
/*     */     //   #314	-> 4
/*     */     //   #317	-> 14
/*     */     //   #319	-> 43
/*     */     //   #321	-> 51
/*     */     //   #322	-> 64
/*     */     //   #325	-> 72
/*     */     //   #326	-> 80
/*     */     //   #327	-> 89
/*     */     //   #328	-> 93
/*     */     //   #329	-> 105
/*     */     //   #330	-> 118
/*     */     //   #332	-> 129
/*     */     //   #333	-> 134
/*     */     //   #334	-> 139
/*     */     //   #335	-> 142
/*     */     //   #336	-> 145
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   105	37	9	nbytes	I
/*     */     //   118	24	10	buf	[B
/*     */     //   0	146	0	this	Lorg/org.dcm4che3/android/stream/MemoryCache;
/*     */     //   0	146	1	b	[B
/*     */     //   0	146	2	off	I
/*     */     //   0	146	3	len	I
/*     */     //   0	146	4	pos	J
/*     */     //   80	66	6	index	J
/*     */     //   89	57	8	offset	I
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void disposeBefore(long pos) {
/* 346 */     long index = pos / 8192L;
/* 347 */     if (index < this.cacheStart) {
/* 348 */       throw new IndexOutOfBoundsException("pos already disposed");
/*     */     }
/* 350 */     long numBlocks = Math.min(index - this.cacheStart, this.cache.size()); long i;
/* 351 */     for (i = 0L; i < numBlocks; i++) {
/* 352 */       this.cache.remove(0);
/*     */     }
/* 354 */     this.cacheStart = index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 363 */     this.cache.clear();
/* 364 */     this.cacheStart = 0L;
/* 365 */     this.length = 0L;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/stream/MemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */