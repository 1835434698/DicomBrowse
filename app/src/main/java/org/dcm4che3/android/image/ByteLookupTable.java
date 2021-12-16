/*     */ package org.dcm4che3.android.image;
/*     */ 
/*     */ import org.dcm4che3.android.Raster;

/*     */
/*     */ public class ByteLookupTable
/*     */   extends LookupTable
/*     */ {
/*     */   private final byte[] lut;
/*     */   
/*     */   ByteLookupTable(StoredValue inBits, int outBits, int offset, byte[] lut) {
/*  11 */     super(inBits, outBits, offset);
/*  12 */     this.lut = lut;
/*     */   }
/*     */   
/*     */   ByteLookupTable(StoredValue inBits, int outBits, int offset, int size, boolean flip) {
/*  16 */     this(inBits, outBits, offset, new byte[size]);
/*  17 */     int maxOut = (1 << outBits) - 1;
/*  18 */     int maxIndex = size - 1;
/*  19 */     int midIndex = maxIndex / 2;
/*  20 */     if (flip) {
/*  21 */       for (int i = 0; i < size; i++)
/*  22 */         this.lut[maxIndex - i] = (byte)((i * maxOut + midIndex) / maxIndex); 
/*     */     } else {
/*  24 */       for (int i = 0; i < size; i++)
/*  25 */         this.lut[i] = (byte)((i * maxOut + midIndex) / maxIndex); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int length() {
/*  30 */     return this.lut.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public void lookup(byte[] src, int srcPos, byte[] dest, int destPos, int length) {
/*  35 */     for (int i = srcPos, endPos = srcPos + length, j = destPos; i < endPos;)
/*  36 */       dest[j++] = this.lut[index(src[i++])]; 
/*     */   }
/*     */   
/*     */   private int index(int pixel) {
/*  40 */     int index = this.inBits.valueOf(pixel) - this.offset;
/*  41 */     return Math.min(Math.max(0, index), this.lut.length - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void lookup(short[] src, int srcPos, byte[] dest, int destPos, int length) {
/*  46 */     for (int i = srcPos, endPos = srcPos + length, j = destPos; i < endPos;) {
/*  47 */       dest[j++] = this.lut[index(src[i++])];
/*     */     }
/*     */   }
/*     */   
/*     */   public void lookup(byte[] src, int srcPos, short[] dest, int destPos, int length) {
/*  52 */     for (int i = srcPos, endPos = srcPos + length, j = destPos; i < endPos;) {
/*  53 */       dest[j++] = (short)(this.lut[index(src[i++])] & 0xFF);
/*     */     }
/*     */   }
/*     */   
/*     */   public void lookup(short[] src, int srcPos, short[] dest, int destPos, int length) {
/*  58 */     for (int i = srcPos, endPos = srcPos + length, j = destPos; i < endPos;) {
/*  59 */       dest[j++] = (short)(this.lut[index(src[i++])] & 0xFF);
/*     */     }
/*     */   }
/*     */   
/*     */   public void lookup(Raster srcRaster, Raster destRaster) {
/*  64 */     if (srcRaster.getDataType() == 0 && (destRaster.getDataType() == 2 || destRaster.getDataType() == 1)) {
/*  65 */       lookup(srcRaster.getByteData(), 0, destRaster.getShortData(), 0, srcRaster.length());
/*  66 */     } else if ((srcRaster.getDataType() == 2 || srcRaster.getDataType() == 1) && destRaster.getDataType() == 0) {
/*  67 */       lookup(srcRaster.getShortData(), 0, destRaster.getByteData(), 0, srcRaster.length());
/*  68 */     } else if ((srcRaster.getDataType() == 2 || srcRaster.getDataType() == 1) && (destRaster.getDataType() == 2 || destRaster.getDataType() == 2)) {
/*  69 */       lookup(srcRaster.getShortData(), 0, destRaster.getShortData(), 0, srcRaster.length());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public LookupTable adjustOutBits(int outBits) {
/*  75 */     int diff = outBits - this.outBits;
/*  76 */     if (diff != 0) {
/*  77 */       byte[] lut = this.lut;
/*  78 */       if (outBits > 8) {
/*  79 */         short[] ss = new short[lut.length];
/*  80 */         for (int i = 0; i < lut.length; i++)
/*  81 */           ss[i] = (short)((lut[i] & 0xFF) << diff); 
/*  82 */         return new ShortLookupTable(this.inBits, outBits, this.offset, ss);
/*     */       } 
/*  84 */       if (diff < 0) {
/*  85 */         diff = -diff;
/*  86 */         for (int i = 0; i < lut.length; i++)
/*  87 */           lut[i] = (byte)((lut[i] & 0xFF) >> diff); 
/*     */       } else {
/*  89 */         for (int i = 0; i < lut.length; i++)
/*  90 */           lut[i] = (byte)(lut[i] << diff); 
/*  91 */       }  this.outBits = outBits;
/*     */     } 
/*  93 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void inverse() {
/*  98 */     byte[] lut = this.lut;
/*  99 */     int maxOut = (1 << this.outBits) - 1;
/* 100 */     for (int i = 0; i < lut.length; i++) {
/* 101 */       lut[i] = (byte)(maxOut - lut[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public LookupTable combine(LookupTable other) {
/* 107 */     byte[] lut = this.lut;
/* 108 */     if (other.outBits > 8) {
/* 109 */       short[] ss = new short[lut.length];
/* 110 */       other.lookup(lut, 0, ss, 0, lut.length);
/* 111 */       return new ShortLookupTable(this.inBits, other.outBits, this.offset, ss);
/*     */     } 
/* 113 */     other.lookup(lut, 0, lut, 0, lut.length);
/* 114 */     this.outBits = other.outBits;
/* 115 */     return this;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/image/ByteLookupTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */