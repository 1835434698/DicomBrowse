/*     */ package org.dcm4che3.android.image;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum PhotometricInterpretation
/*     */ {
/*  48 */   MONOCHROME1
/*     */   {
/*     */     public boolean isMonochrome() {
/*  51 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isInvers() {
/*  56 */       return true;
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  61 */   MONOCHROME2
/*     */   {
/*     */     public boolean isMonochrome() {
/*  64 */       return true;
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  69 */   PALETTE_COLOR
/*     */   {
/*     */     public String toString() {
/*  72 */       return "PALETTE COLOR";
/*     */     }
/*     */   },
/*     */ 
/*     */   
/*  77 */   RGB {
/*     */   
/*     */   },
/*  80 */   YBR_FULL {
/*     */   
/*     */   },
/*  83 */   YBR_FULL_422
/*     */   {
/*     */     public int frameLength(int w, int h, int samples, int bitsAllocated) {
/*  86 */       return ColorSubsampling.YBR_XXX_422.frameLength(w, h);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PhotometricInterpretation decompress() {
/*  93 */       return RGB;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isSubSambled() {
/*  98 */       return true;
/*     */     }
/*     */   },
/* 101 */   YBR_PARTIAL_422
/*     */   {
/*     */     public int frameLength(int w, int h, int samples, int bitsAllocated) {
/* 104 */       return ColorSubsampling.YBR_XXX_422.frameLength(w, h);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PhotometricInterpretation decompress() {
/* 113 */       return RGB;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isSubSambled() {
/* 118 */       return true;
/*     */     }
/*     */   },
/* 121 */   YBR_PARTIAL_420
/*     */   {
/*     */     public int frameLength(int w, int h, int samples, int bitsAllocated) {
/* 124 */       return ColorSubsampling.YBR_XXX_420.frameLength(w, h);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PhotometricInterpretation decompress() {
/* 132 */       return RGB;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isSubSambled() {
/* 137 */       return true;
/*     */     }
/*     */   },
/* 140 */   YBR_ICT
/*     */   {
/*     */     
/*     */     public PhotometricInterpretation decompress()
/*     */     {
/* 145 */       return RGB;
/*     */     }
/*     */   },
/* 148 */   YBR_RCT
/*     */   {
/*     */ 
/*     */     
/*     */     public PhotometricInterpretation decompress()
/*     */     {
/* 154 */       return RGB;
/*     */     }
/*     */   };
/*     */   
/*     */   public static PhotometricInterpretation fromString(String s) {
/* 159 */     return s.equals("PALETTE COLOR") ? PALETTE_COLOR : valueOf(s);
/*     */   }
/*     */   
/*     */   public int frameLength(int w, int h, int samples, int bitsAllocated) {
/* 163 */     return w * h * samples * (bitsAllocated >> 3);
/*     */   }
/*     */   
/*     */   public boolean isMonochrome() {
/* 167 */     return false;
/*     */   }
/*     */   
/*     */   public PhotometricInterpretation decompress() {
/* 171 */     return this;
/*     */   }
/*     */   
/*     */   public boolean isInvers() {
/* 175 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isSubSambled() {
/* 179 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/image/PhotometricInterpretation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */