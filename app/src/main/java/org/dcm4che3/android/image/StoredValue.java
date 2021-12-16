/*     */ package org.dcm4che3.android.image;
/*     */ 
/*     */ import org.dcm4che3.data.Attributes;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class StoredValue
/*     */ {
/*     */   public abstract int valueOf(int paramInt);
/*     */   
/*     */   public abstract int minValue();
/*     */   
/*     */   public abstract int maxValue();
/*     */   
/*     */   public static class Unsigned
/*     */     extends StoredValue
/*     */   {
/*     */     private final int mask;
/*     */     
/*     */     public Unsigned(int bitsStored) {
/*  61 */       this.mask = (1 << bitsStored) - 1;
/*     */     }
/*     */ 
/*     */     
/*     */     public int valueOf(int pixel) {
/*  66 */       return pixel & this.mask;
/*     */     }
/*     */ 
/*     */     
/*     */     public int minValue() {
/*  71 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int maxValue() {
/*  76 */       return this.mask;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Signed
/*     */     extends StoredValue {
/*     */     private final int bitsStored;
/*     */     private final int shift;
/*     */     
/*     */     public Signed(int bitsStored) {
/*  86 */       this.bitsStored = bitsStored;
/*  87 */       this.shift = 32 - bitsStored;
/*     */     }
/*     */ 
/*     */     
/*     */     public int valueOf(int pixel) {
/*  92 */       return pixel << this.shift >> this.shift;
/*     */     }
/*     */ 
/*     */     
/*     */     public int minValue() {
/*  97 */       return -(1 << this.bitsStored - 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public int maxValue() {
/* 102 */       return (1 << this.bitsStored - 1) - 1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static StoredValue valueOf(Attributes attrs) {
/* 107 */     int bitsStored = attrs.getInt(2621697, 0);
/* 108 */     if (bitsStored == 0)
/* 109 */       bitsStored = attrs.getInt(2621696, 8); 
/* 110 */     return (attrs.getInt(2621699, 0) != 0) ? new Signed(bitsStored) : new Unsigned(bitsStored);
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/image/StoredValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */