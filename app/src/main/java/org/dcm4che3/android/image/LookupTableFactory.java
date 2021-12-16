/*     */ package org.dcm4che3.android.image;
/*     */ 
/*     */

import org.dcm4che3.android.Raster;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.util.ByteUtils;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LookupTableFactory
/*     */ {
/*     */   private final StoredValue storedValue;
/*  53 */   private float rescaleSlope = 1.0F;
/*  54 */   private float rescaleIntercept = 0.0F;
/*     */   
/*     */   private LookupTable modalityLUT;
/*     */   private float windowCenter;
/*     */   private float windowWidth;
/*     */   private LookupTable voiLUT;
/*     */   private LookupTable presentationLUT;
/*     */   private boolean inverse;
/*     */   
/*     */   public LookupTableFactory(StoredValue storedValue) {
/*  64 */     this.storedValue = storedValue;
/*     */   }
/*     */   
/*     */   public void setModalityLUT(Attributes attrs) {
/*  68 */     this.rescaleIntercept = attrs.getFloat(2625618, 0.0F);
/*  69 */     this.rescaleSlope = attrs.getFloat(2625619, 1.0F);
/*  70 */     this.modalityLUT = createLUT(this.storedValue, attrs.getNestedDataset(2633728));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPresentationLUT(Attributes attrs) {
/*  75 */     Attributes pLUT = attrs.getNestedDataset(542113808);
/*  76 */     if (pLUT != null) {
/*  77 */       int[] desc = pLUT.getInts(2633730);
/*  78 */       if (desc != null && desc.length == 3) {
/*  79 */         int len = (desc[0] == 0) ? 65536 : desc[0];
/*  80 */         this.presentationLUT = createLUT(new StoredValue.Unsigned(log2(len)), resetOffset(desc), pLUT.getSafeBytes(2633734), pLUT.bigEndian());
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  85 */       String pShape = attrs.getString(542113824);
/*  86 */       this.inverse = (pShape != null) ? "INVERSE".equals(pShape) : "MONOCHROME1".equals(attrs.getString(2621444));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int[] resetOffset(int[] desc) {
/*  94 */     if (desc[1] == 0) {
/*  95 */       return desc;
/*     */     }
/*  97 */     int[] copy = (int[])desc.clone();
/*  98 */     copy[1] = 0;
/*  99 */     return copy;
/*     */   }
/*     */   
/*     */   public void setWindowCenter(float windowCenter) {
/* 103 */     this.windowCenter = windowCenter;
/*     */   }
/*     */   
/*     */   public void setWindowWidth(float windowWidth) {
/* 107 */     this.windowWidth = windowWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVOI(Attributes img, int windowIndex, int voiLUTIndex, boolean preferWindow) {
/* 112 */     if (img == null) {
/*     */       return;
/*     */     }
/* 115 */     Attributes vLUT = img.getNestedDataset(2633744, voiLUTIndex);
/* 116 */     if (preferWindow || vLUT == null) {
/* 117 */       float[] wcs = img.getFloats(2625616);
/* 118 */       float[] wws = img.getFloats(2625617);
/* 119 */       if (wcs != null && wcs.length != 0 && wws != null && wws.length != 0) {
/*     */         
/* 121 */         int index = (windowIndex < Math.min(wcs.length, wws.length)) ? windowIndex : 0;
/*     */ 
/*     */         
/* 124 */         this.windowCenter = wcs[index];
/* 125 */         this.windowWidth = wws[index];
/*     */         return;
/*     */       } 
/*     */     } 
/* 129 */     if (vLUT != null) {
/* 130 */       this.voiLUT = createLUT((this.modalityLUT != null) ? new StoredValue.Unsigned(this.modalityLUT.outBits) : this.storedValue, vLUT);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private LookupTable createLUT(StoredValue inBits, Attributes attrs) {
/* 137 */     if (attrs == null) {
/* 138 */       return null;
/*     */     }
/* 140 */     return createLUT(inBits, attrs.getInts(2633730), attrs.getSafeBytes(2633734), attrs.bigEndian());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private LookupTable createLUT(StoredValue inBits, int[] desc, byte[] data, boolean bigEndian) {
/* 147 */     if (desc == null) {
/* 148 */       return null;
/*     */     }
/* 150 */     if (desc.length != 3) {
/* 151 */       return null;
/*     */     }
/* 153 */     int len = (desc[0] == 0) ? 65536 : desc[0];
/* 154 */     int offset = (short)desc[1];
/* 155 */     int outBits = desc[2];
/* 156 */     if (data == null) {
/* 157 */       return null;
/*     */     }
/* 159 */     if (data.length == len << 1) {
/* 160 */       if (outBits > 8) {
/* 161 */         if (outBits > 16) {
/* 162 */           return null;
/*     */         }
/* 164 */         short[] ss = new short[len];
/* 165 */         if (bigEndian) {
/* 166 */           for (int i = 0; i < ss.length; i++)
/* 167 */             ss[i] = (short)ByteUtils.bytesToShortBE(data, i << 1); 
/*     */         } else {
/* 169 */           for (int i = 0; i < ss.length; i++)
/* 170 */             ss[i] = (short)ByteUtils.bytesToShortLE(data, i << 1); 
/*     */         } 
/* 172 */         return new ShortLookupTable(inBits, outBits, offset, ss);
/*     */       } 
/*     */       
/* 175 */       data = halfLength(data, bigEndian ? 1 : 0);
/*     */     } 
/* 177 */     if (data.length != len) {
/* 178 */       return null;
/*     */     }
/* 180 */     if (outBits > 8) {
/* 181 */       return null;
/*     */     }
/* 183 */     return new ByteLookupTable(inBits, outBits, offset, data);
/*     */   }
/*     */   
/*     */   static byte[] halfLength(byte[] data, int hilo) {
/* 187 */     byte[] bs = new byte[data.length >> 1];
/* 188 */     for (int i = 0; i < bs.length; i++) {
/* 189 */       bs[i] = data[i << 1 | hilo];
/*     */     }
/* 191 */     return bs;
/*     */   }
/*     */   
/*     */   public LookupTable createLUT(int outBits) {
/* 195 */     LookupTable lut = combineModalityVOILUT((this.presentationLUT != null) ? log2(this.presentationLUT.length()) : outBits);
/*     */ 
/*     */     
/* 198 */     if (this.presentationLUT != null) {
/* 199 */       lut = lut.combine(this.presentationLUT.adjustOutBits(outBits));
/* 200 */     } else if (this.inverse) {
/* 201 */       lut.inverse();
/* 202 */     }  return lut;
/*     */   }
/*     */   
/*     */   private static int log2(int value) {
/* 206 */     int i = 0;
/* 207 */     while (value >>> i != 0)
/* 208 */       i++; 
/* 209 */     return i - 1;
/*     */   }
/*     */   
/*     */   private LookupTable combineModalityVOILUT(int outBits) {
/* 213 */     float m = this.rescaleSlope;
/* 214 */     float b = this.rescaleIntercept;
/* 215 */     LookupTable modalityLUT = this.modalityLUT;
/* 216 */     LookupTable lut = this.voiLUT;
/* 217 */     if (lut == null) {
/* 218 */       int size, offset; float c = this.windowCenter;
/* 219 */       float w = this.windowWidth;
/*     */       
/* 221 */       if (w == 0.0F && modalityLUT != null) {
/* 222 */         return modalityLUT.adjustOutBits(outBits);
/*     */       }
/*     */       
/* 225 */       StoredValue inBits = (modalityLUT != null) ? new StoredValue.Unsigned(modalityLUT.outBits) : this.storedValue;
/*     */ 
/*     */       
/* 228 */       if (w != 0.0F) {
/* 229 */         size = Math.max(2, Math.abs(Math.round(w / m)));
/* 230 */         offset = Math.round(c / m - b) - size / 2;
/*     */       } else {
/* 232 */         offset = inBits.minValue();
/* 233 */         size = inBits.maxValue() - inBits.minValue() + 1;
/*     */       } 
/* 235 */       if (outBits > 8) {  } else {  }  lut = new ByteLookupTable(inBits, outBits, offset, size, (m < 0.0F));
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 240 */       lut = lut.adjustOutBits(outBits);
/*     */     } 
/* 242 */     return (modalityLUT != null) ? modalityLUT.combine(lut) : lut;
/*     */   }
/*     */   
/*     */   public boolean autoWindowing(Attributes img, Raster raster) {
/* 246 */     if (this.modalityLUT != null || this.voiLUT != null || this.windowWidth != 0.0F) {
/* 247 */       return false;
/*     */     }
/* 249 */     int min = img.getInt(2621702, 0);
/* 250 */     int max = img.getInt(2621703, 0);
/* 251 */     if (max == 0) {
/*     */       
/* 253 */       int[] min_max = calcMinMax(this.storedValue, raster, raster.getDataType());
/*     */       
/* 255 */       min = min_max[0];
/* 256 */       max = min_max[1];
/*     */     } 
/* 258 */     this.windowCenter = ((min + max + 1) / 2) * this.rescaleSlope + this.rescaleIntercept;
/* 259 */     this.windowWidth = Math.abs((max + 1 - min) * this.rescaleSlope);
/* 260 */     return true;
/*     */   }
/*     */   
/*     */   private int[] calcMinMax(StoredValue storedValue, Raster raster, int datatype) {
/* 264 */     int min = Integer.MAX_VALUE;
/* 265 */     int max = Integer.MIN_VALUE;
/* 266 */     int h = raster.getHeight();
/* 267 */     int stride = raster.getWidth();
/* 268 */     for (int y = 0; y < h; y++) {
/* 269 */       for (int i = y * stride, end = i + stride; i < end; i++) {
/* 270 */         int v = 0;
/* 271 */         switch (datatype) {
/*     */           case 0:
/* 273 */             v = raster.getByteData()[i];
/*     */             break;
/*     */           case 2:
/* 276 */             v = raster.getShortData()[i];
/*     */             break;
/*     */           case 1:
/* 279 */             v = raster.getShortData()[i];
/* 280 */             if (v < 0) {
/* 281 */               v += 65536;
/*     */             }
/*     */             break;
/*     */           default:
/* 285 */             v = raster.getByteData()[i];
/*     */             break;
/*     */         } 
/*     */         
/* 289 */         int val = storedValue.valueOf(v);
/* 290 */         if (val < min) min = val; 
/* 291 */         if (val > max) max = val; 
/*     */       } 
/* 293 */     }  return new int[] { min, max };
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/image/LookupTableFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */