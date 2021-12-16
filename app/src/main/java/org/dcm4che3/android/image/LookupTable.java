/*    */ package org.dcm4che3.android.image;
/*    */ 
/*    */ import org.dcm4che3.android.Raster;

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
/*    */ 
/*    */ 
/*    */ public abstract class LookupTable
/*    */ {
/*    */   protected StoredValue inBits;
/*    */   protected int outBits;
/*    */   protected int offset;
/*    */   
/*    */   public LookupTable(StoredValue inBits, int outBits, int offset) {
/* 55 */     this.inBits = inBits;
/* 56 */     this.outBits = outBits;
/* 57 */     this.offset = offset;
/*    */   }
/*    */   
/*    */   public abstract int length();
/*    */   
/*    */   public abstract void lookup(Raster paramRaster1, Raster paramRaster2);
/*    */   
/*    */   public abstract void lookup(byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2, int paramInt3);
/*    */   
/*    */   public abstract void lookup(short[] paramArrayOfshort, int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3);
/*    */   
/*    */   public abstract void lookup(byte[] paramArrayOfbyte, int paramInt1, short[] paramArrayOfshort, int paramInt2, int paramInt3);
/*    */   
/*    */   public abstract void lookup(short[] paramArrayOfshort1, int paramInt1, short[] paramArrayOfshort2, int paramInt2, int paramInt3);
/*    */   
/*    */   public abstract LookupTable adjustOutBits(int paramInt);
/*    */   
/*    */   public abstract void inverse();
/*    */   
/*    */   public abstract LookupTable combine(LookupTable paramLookupTable);
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/image/LookupTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */