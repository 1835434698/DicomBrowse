/*     */ package org.dcm4che3.android.image;
/*     */ 
/*     */ import org.dcm4che3.android.Raster;

/*     */
/*     */ public class ShortLookupTable
/*     */   extends LookupTable
/*     */ {
/*     */   private final short[] lut;
/*     */   
/*     */   ShortLookupTable(StoredValue inBits, int outBits, int offset, short[] lut) {
/*  11 */     super(inBits, outBits, offset);
/*  12 */     this.lut = lut;
/*     */   }
/*     */   
/*     */   ShortLookupTable(StoredValue inBits, int outBits, int offset, int size, boolean flip) {
/*  16 */     this(inBits, outBits, offset, new short[size]);
/*  17 */     int maxOut = (1 << outBits) - 1;
/*  18 */     int maxIndex = size - 1;
/*  19 */     int midIndex = size / 2;
/*  20 */     if (flip) {
/*  21 */       for (int i = 0; i < size; i++)
/*  22 */         this.lut[maxIndex - i] = (short)((i * maxOut + midIndex) / maxIndex); 
/*     */     } else {
/*  24 */       for (int i = 0; i < size; i++)
/*  25 */         this.lut[i] = (short)((i * maxOut + midIndex) / maxIndex); 
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
/*  36 */       dest[j++] = (byte)this.lut[index(src[i++] & 0xFF)]; 
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
/*  47 */       dest[j++] = (byte)this.lut[index(src[i++] & 0xFFFF)];
/*     */     }
/*     */   }
/*     */   
/*     */   public void lookup(byte[] src, int srcPos, short[] dest, int destPos, int length) {
/*  52 */     for (int i = srcPos, endPos = srcPos + length, j = destPos; i < endPos;) {
/*  53 */       dest[j++] = this.lut[index(src[i++] & 0xFF)];
/*     */     }
/*     */   }
/*     */   
/*     */   public void lookup(short[] src, int srcPos, short[] dest, int destPos, int length) {
/*  58 */     for (int i = srcPos, endPos = srcPos + length, j = destPos; i < endPos;) {
/*  59 */       dest[j++] = this.lut[index(src[i++] & 0xFFFF)];
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
/*  77 */       short[] lut = this.lut;
/*  78 */       if (diff < 0) {
/*  79 */         diff = -diff;
/*  80 */         for (int i = 0; i < lut.length; i++)
/*  81 */           lut[i] = (short)((lut[i] & 0xFFFF) >> diff); 
/*     */       } else {
/*  83 */         for (int i = 0; i < lut.length; i++)
/*  84 */           lut[i] = (short)(lut[i] << diff); 
/*  85 */       }  this.outBits = outBits;
/*     */     } 
/*  87 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void inverse() {
/*  92 */     short[] lut = this.lut;
/*  93 */     int maxOut = (1 << this.outBits) - 1;
/*  94 */     for (int i = 0; i < lut.length; i++) {
/*  95 */       lut[i] = (short)(maxOut - lut[i]);
/*     */     }
/*     */   }
/*     */   
/*     */   public LookupTable combine(LookupTable other) {
/* 100 */     short[] lut = this.lut;
/* 101 */     other.lookup(lut, 0, lut, 0, lut.length);
/* 102 */     this.outBits = other.outBits;
/* 103 */     return this;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/image/ShortLookupTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */