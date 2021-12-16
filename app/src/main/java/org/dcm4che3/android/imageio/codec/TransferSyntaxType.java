/*     */ package org.dcm4che3.android.imageio.codec;
/*     */ 
/*     */

import org.dcm4che3.android.image.PhotometricInterpretation;

import java.util.HashMap;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum TransferSyntaxType
/*     */ {
/*  51 */   NATIVE
/*     */   {
/*     */     public boolean isPixeldataEncapsulated() {
/*  54 */       return false;
/*     */     }
/*     */   },
/*  57 */   JPEG_BASELINE
/*     */   {
/*     */     public int getMaxBitsStored() {
/*  60 */       return 8;
/*     */     }
/*     */ 
/*     */     
/*     */     public PhotometricInterpretation compress(PhotometricInterpretation pmi) {
/*  65 */       return (pmi == PhotometricInterpretation.RGB) ? PhotometricInterpretation.YBR_FULL_422 : pmi;
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */   
/*  71 */   JPEG_EXTENDED
/*     */   {
/*     */     public int getMaxBitsStored() {
/*  74 */       return 12;
/*     */     }
/*     */ 
/*     */     
/*     */     public PhotometricInterpretation compress(PhotometricInterpretation pmi) {
/*  79 */       return (pmi == PhotometricInterpretation.RGB) ? PhotometricInterpretation.YBR_FULL_422 : pmi;
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  84 */   JPEG_LOSSLESS,
/*  85 */   JPEG_2000
/*     */   {
/*     */     public boolean canEncodeSigned() {
/*  88 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public PhotometricInterpretation compress(PhotometricInterpretation pmi) {
/*  93 */       return (pmi == PhotometricInterpretation.RGB) ? PhotometricInterpretation.YBR_ICT : pmi;
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  98 */   JPEG_2000_LOSSLESS
/*     */   {
/*     */     public boolean canEncodeSigned() {
/* 101 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public PhotometricInterpretation compress(PhotometricInterpretation pmi) {
/* 106 */       return (pmi == PhotometricInterpretation.RGB) ? PhotometricInterpretation.YBR_RCT : pmi;
/*     */     }
/*     */   },
/*     */ 
/*     */   
/* 111 */   RLE
/*     */   {
/*     */     public int getPlanarConfiguration() {
/* 114 */       return 1;
/*     */     }
/*     */   },
/* 117 */   JPIP
/*     */   {
/*     */     public boolean isPixeldataEncapsulated() {
/* 120 */       return false;
/*     */     }
/*     */   },
/* 123 */   MPEG
/*     */   {
/*     */     public int getMaxBitsStored() {
/* 126 */       return 8;
/*     */     }
/*     */   };
/*     */   
/*     */   public boolean isPixeldataEncapsulated() {
/* 131 */     return true;
/*     */   }
/*     */   private static final HashMap<String, TransferSyntaxType> map;
/*     */   public boolean canEncodeSigned() {
/* 135 */     return false;
/*     */   }
/*     */   
/*     */   public int getPlanarConfiguration() {
/* 139 */     return 0;
/*     */   }
/*     */   
/*     */   public int getMaxBitsStored() {
/* 143 */     return 16;
/*     */   }
/*     */   
/*     */   public PhotometricInterpretation compress(PhotometricInterpretation pmi) {
/* 147 */     return pmi;
/*     */   }
/*     */   static {
/* 150 */     map = new HashMap<String, TransferSyntaxType>();
/*     */ 
/*     */ 
/*     */     
/* 154 */     map.put("1.2.840.10008.1.2", NATIVE);
/* 155 */     map.put("1.2.840.10008.1.2.1", NATIVE);
/* 156 */     map.put("1.2.840.10008.1.2.1.99", NATIVE);
/* 157 */     map.put("1.2.840.10008.1.2.2", NATIVE);
/* 158 */     map.put("1.2.840.10008.1.2.4.50", JPEG_BASELINE);
/* 159 */     map.put("1.2.840.10008.1.2.4.51", JPEG_EXTENDED);
/* 160 */     map.put("1.2.840.10008.1.2.4.57", JPEG_LOSSLESS);
/* 161 */     map.put("1.2.840.10008.1.2.4.70", JPEG_LOSSLESS);
/* 162 */     map.put("1.2.840.10008.1.2.4.80", JPEG_LOSSLESS);
/* 163 */     map.put("1.2.840.10008.1.2.4.81", JPEG_LOSSLESS);
/* 164 */     map.put("1.2.840.10008.1.2.4.90", JPEG_2000_LOSSLESS);
/* 165 */     map.put("1.2.840.10008.1.2.4.91", JPEG_2000);
/* 166 */     map.put("1.2.840.10008.1.2.4.92", JPEG_2000_LOSSLESS);
/* 167 */     map.put("1.2.840.10008.1.2.4.93", JPEG_2000);
/* 168 */     map.put("1.2.840.10008.1.2.4.94", JPIP);
/* 169 */     map.put("1.2.840.10008.1.2.4.95", JPIP);
/* 170 */     map.put("1.2.840.10008.1.2.4.100", MPEG);
/* 171 */     map.put("1.2.840.10008.1.2.4.101", MPEG);
/* 172 */     map.put("1.2.840.10008.1.2.4.102", MPEG);
/* 173 */     map.put("1.2.840.10008.1.2.4.103", MPEG);
/* 174 */     map.put("1.2.840.10008.1.2.5", RLE);
/*     */   }
/*     */   
/*     */   public static TransferSyntaxType forUID(String uid) {
/* 178 */     return map.get(uid);
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/imageio/codec/TransferSyntaxType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */