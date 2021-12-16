/*     */ package org.dcm4che3.android.image;
/*     */ 
/*     */

import org.dcm4che3.android.Raster;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Sequence;
import org.dcm4che3.util.TagUtils;

import java.util.Arrays;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Overlays
/*     */ {
/*     */   public static int[] getActiveOverlayGroupOffsets(Attributes psattrs) {
/*  58 */     return getOverlayGroupOffsets(psattrs, 1610616833, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int[] getActiveOverlayGroupOffsets(Attributes attrs, int activationMask) {
/*  63 */     return getOverlayGroupOffsets(attrs, 1610612752, activationMask);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int[] getOverlayGroupOffsets(Attributes attrs, int tag, int activationMask) {
/*  68 */     int len = 0;
/*  69 */     int[] result = new int[16];
/*  70 */     for (int i = 0; i < result.length; i++) {
/*  71 */       int gg0000 = i << 17;
/*  72 */       if ((activationMask & 1 << i) != 0 && attrs.containsValue(tag | gg0000))
/*     */       {
/*  74 */         result[len++] = gg0000; } 
/*     */     } 
/*  76 */     return Arrays.copyOf(result, len);
/*     */   }
/*     */   
/*     */   public static int[] getEmbeddedOverlayGroupOffsets(Attributes attrs) {
/*  80 */     int len = 0;
/*  81 */     int[] result = new int[16];
/*  82 */     for (int i = 0; i < result.length; i++) {
/*  83 */       int gg0000 = i << 17;
/*  84 */       if (attrs.getInt(0x60000100 | gg0000, 1) != 1)
/*  85 */         result[len++] = gg0000; 
/*     */     } 
/*  87 */     return Arrays.copyOf(result, len);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void extractFromPixeldata(Raster raster, int mask, byte[] ovlyData, int off, int length) {
/*  93 */     int rows = raster.getHeight();
/*  94 */     int columns = raster.getWidth();
/*     */     
/*  96 */     switch (raster.getDataType()) {
/*     */       case 2:
/*  98 */         extractFromPixeldata(raster.getShortData(), rows, columns, columns, mask, ovlyData, off, length);
/*     */         return;
/*     */     } 
/*     */     
/* 102 */     extractFromPixeldata(raster.getByteData(), rows, columns, columns, mask, ovlyData, off, length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void extractFromPixeldata(byte[] pixeldata, int rows, int columns, int stride, int mask, byte[] ovlyData, int off, int length) {
/* 111 */     int y = 0, i = off, imax = off + length;
/* 112 */     for (; y < columns && i < imax; y++) {
/* 113 */       for (int j = y * stride, jmax = j + rows; j < jmax && i < imax; j++, i++) {
/* 114 */         if ((pixeldata[j] & mask) != 0) {
/* 115 */           ovlyData[i >>> 3] = (byte)(ovlyData[i >>> 3] | 1 << (i & 0x7));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void extractFromPixeldata(short[] pixeldata, int rows, int columns, int stride, int mask, byte[] ovlyData, int off, int length) {
/* 123 */     int y = 0, i = off, imax = off + length;
/* 124 */     for (; y < rows && i < imax; y++) {
/* 125 */       for (int j = y * stride, jmax = j + columns; j < jmax && i < imax; j++, i++) {
/* 126 */         if ((pixeldata[j] & mask) != 0) {
/* 127 */           ovlyData[i >>> 3] = (byte)(ovlyData[i >>> 3] | 1 << (i & 0x7));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getRecommendedDisplayGrayscaleValue(Attributes psAttrs, int gg0000) {
/* 135 */     int tagOverlayActivationLayer = 0x60001001 | gg0000;
/* 136 */     String layerName = psAttrs.getString(tagOverlayActivationLayer);
/* 137 */     if (layerName == null) {
/* 138 */       throw new IllegalArgumentException("Missing " + TagUtils.toString(tagOverlayActivationLayer) + " Overlay Activation Layer");
/*     */     }
/*     */     
/* 141 */     Sequence layers = psAttrs.getSequence(7340128);
/* 142 */     if (layers == null) {
/* 143 */       throw new IllegalArgumentException("Missing " + TagUtils.toString(7340128) + " Graphic Layer Sequence");
/*     */     }
/*     */ 
/*     */     
/* 147 */     for (Attributes layer : layers) {
/* 148 */       if (layerName.equals(layer.getString(7340034)))
/* 149 */         return layer.getInt(6422540, -1); 
/*     */     } 
/* 151 */     throw new IllegalArgumentException("No Graphic Layer: " + layerName);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void applyOverlay(int frameIndex, Raster raster, Attributes attrs, int gg0000, int pixelValue, byte[] ovlyData) {
/* 157 */     int imageFrameOrigin = attrs.getInt(0x60000051 | gg0000, 1);
/* 158 */     int framesInOverlay = attrs.getInt(0x60000015 | gg0000, 1);
/* 159 */     int ovlyFrameIndex = frameIndex - imageFrameOrigin + 1;
/* 160 */     if (ovlyFrameIndex < 0 || ovlyFrameIndex >= framesInOverlay) {
/*     */       return;
/*     */     }
/* 163 */     int tagOverlayRows = 0x60000010 | gg0000;
/* 164 */     int tagOverlayColumns = 0x60000011 | gg0000;
/* 165 */     int tagOverlayData = 0x60003000 | gg0000;
/* 166 */     int tagOverlayOrigin = 0x60000050 | gg0000;
/*     */     
/* 168 */     int ovlyRows = attrs.getInt(tagOverlayRows, -1);
/* 169 */     int ovlyColumns = attrs.getInt(tagOverlayColumns, -1);
/* 170 */     int[] ovlyOrigin = attrs.getInts(tagOverlayOrigin);
/* 171 */     if (ovlyData == null) {
/* 172 */       ovlyData = attrs.getSafeBytes(tagOverlayData);
/*     */     }
/* 174 */     if (ovlyData == null) {
/* 175 */       throw new IllegalArgumentException("Missing " + TagUtils.toString(tagOverlayData) + " Overlay Data");
/*     */     }
/*     */     
/* 178 */     if (ovlyRows <= 0) {
/* 179 */       throw new IllegalArgumentException(TagUtils.toString(tagOverlayRows) + " Overlay Rows [" + ovlyRows + "]");
/*     */     }
/*     */     
/* 182 */     if (ovlyColumns <= 0) {
/* 183 */       throw new IllegalArgumentException(TagUtils.toString(tagOverlayColumns) + " Overlay Columns [" + ovlyColumns + "]");
/*     */     }
/*     */     
/* 186 */     if (ovlyOrigin == null) {
/* 187 */       throw new IllegalArgumentException("Missing " + TagUtils.toString(tagOverlayOrigin) + " Overlay Origin");
/*     */     }
/*     */     
/* 190 */     if (ovlyOrigin.length != 2) {
/* 191 */       throw new IllegalArgumentException(TagUtils.toString(tagOverlayOrigin) + " Overlay Origin " + Arrays.toString(ovlyOrigin));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     int ovlyLen = ovlyRows * ovlyColumns;
/* 199 */     int ovlyOff = ovlyLen * ovlyFrameIndex;
/* 200 */     int i = ovlyOff >>> 3;
/* 201 */     for (int end = ovlyOff + ovlyLen + 7 >>> 3; i < end; i++) {
/* 202 */       int ovlyBits = ovlyData[i] & 0xFF;
/* 203 */       for (int j = 0; ovlyBits >>> j != 0; j++) {
/* 204 */         if ((ovlyBits & 1 << j) != 0) {
/*     */ 
/*     */           
/* 207 */           int ovlyIndex = (i << 3) + j - ovlyOff;
/* 208 */           if (ovlyIndex >= ovlyLen);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/image/Overlays.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */