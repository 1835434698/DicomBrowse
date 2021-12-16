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
/*    */ public enum YBR
/*    */ {
/* 46 */   FULL
/*    */   {
/*    */     public float[] toRGB(float[] ybr) {
/* 49 */       return convert(ybr, YBR.FROM_YBR_FULL);
/*    */     }
/*    */ 
/*    */     
/*    */     public float[] fromRGB(float[] rgb) {
/* 54 */       return convert(rgb, YBR.TO_YBR_FULL);
/*    */     }
/*    */   },
/* 57 */   PARTIAL
/*    */   {
/*    */     public float[] toRGB(float[] ybr) {
/* 60 */       return convert(ybr, YBR.FROM_YBR_PARTIAL);
/*    */     }
/*    */ 
/*    */     
/*    */     public float[] fromRGB(float[] rgb) {
/* 65 */       return convert(rgb, YBR.TO_YBR_PARTIAL);
/*    */     } };
/*    */   
/*    */   static {
/* 69 */     TO_YBR_FULL = new double[] { 0.299D, 0.587D, 0.114D, 0.0D, -0.1687D, -0.3313D, 0.5D, 0.5D, 0.5D, -0.4187D, -0.0813D, 0.5D };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 75 */     TO_YBR_PARTIAL = new double[] { 0.2568D, 0.5041D, 0.0979D, 0.0625D, -0.1482D, -0.291D, 0.4392D, 0.5D, 0.4392D, -0.3678D, -0.0714D, 0.5D };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 81 */     FROM_YBR_FULL = new double[] { 1.0D, -3.681999032610751E-5D, 1.4019875769352639D, -0.7009753784724688D, 1.0D, -0.34411328131331737D, -0.7141038211151132D, 0.5291085512142153D, 1.0D, 1.7719781167370596D, -1.345834129159976E-4D, -0.8859217666620718D };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 87 */     FROM_YBR_PARTIAL = new double[] { 1.1644154634373545D, -9.503599204778129E-5D, 1.5960018776303868D, -0.8707293872840042D, 1.1644154634373545D, -0.39172456367367336D, -0.8130133682767554D, 0.5295929995103797D, 1.1644154634373545D, 2.017290682233469D, -1.3527300480981362E-4D, -1.0813536710791642D };
/*    */   }
/*    */ 
/*    */   
/*    */   private static double[] TO_YBR_FULL;
/*    */   
/*    */   private static double[] TO_YBR_PARTIAL;
/*    */   private static final double[] FROM_YBR_FULL;
/*    */   private static final double[] FROM_YBR_PARTIAL;
/*    */   
/*    */   private static float[] convert(float[] in, double[] a) {
/* 98 */     return new float[] { (float)Math.max(0.0D, Math.min(1.0D, a[0] * in[0] + a[1] * in[1] + a[2] * in[2] + a[3])), (float)Math.max(0.0D, Math.min(1.0D, a[4] * in[0] + a[5] * in[1] + a[6] * in[2] + a[7])), (float)Math.max(0.0D, Math.min(1.0D, a[8] * in[0] + a[9] * in[1] + a[10] * in[2] + a[11])) };
/*    */   }
/*    */   
/*    */   public abstract float[] toRGB(float[] paramArrayOffloat);
/*    */   
/*    */   public abstract float[] fromRGB(float[] paramArrayOffloat);
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/image/YBR.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */