/*    */ package org.dcm4che3.android.image;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum ColorSubsampling
/*    */ {
/* 46 */   YBR_XXX_422
/*    */   {
/*    */     public int frameLength(int w, int h) {
/* 49 */       return w * h * 2;
/*    */     }
/*    */ 
/*    */     
/*    */     public int indexOfY(int x, int y, int w) {
/* 54 */       return (w * y + x) * 2 - x % 2;
/*    */     }
/*    */ 
/*    */     
/*    */     public int indexOfBR(int x, int y, int w) {
/* 59 */       return w * y * 2 + (x >> 1 << 2) + 2;
/*    */     }
/*    */   },
/* 62 */   YBR_XXX_420
/*    */   {
/*    */     public int frameLength(int w, int h) {
/* 65 */       return w * h / 2 * 3;
/*    */     }
/*    */ 
/*    */     
/*    */     public int indexOfY(int x, int y, int w) {
/* 70 */       int withoutBR = y / 2;
/* 71 */       int withBR = y - withoutBR;
/* 72 */       return w * (withBR * 2 + withoutBR) + ((y % 2 == 0) ? (x * 2 - x % 2) : x);
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public int indexOfBR(int x, int y, int w) {
/* 78 */       return w * y / 2 * 3 + (x >> 1 << 2) + 2;
/*    */     }
/*    */   };
/*    */   
/*    */   public abstract int frameLength(int paramInt1, int paramInt2);
/*    */   
/*    */   public abstract int indexOfY(int paramInt1, int paramInt2, int paramInt3);
/*    */   
/*    */   public abstract int indexOfBR(int paramInt1, int paramInt2, int paramInt3);
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/image/ColorSubsampling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */