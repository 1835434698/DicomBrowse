/*    */ package org.dcm4che3.android.image;
/*    */ 
/*    */ import org.dcm4che3.data.Attributes;

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
/*    */ public class PixelAspectRatio
/*    */ {
/*    */   public static float forImage(Attributes attrs) {
/* 51 */     return forImage(attrs, 2621492, new int[] { 2621488, 1577316, 1581072 });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static float forPresentationState(Attributes attrs) {
/* 58 */     return forImage(attrs, 7340290, new int[] { 7340289 });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static float forImage(Attributes attrs, int aspectRatioTag, int... pixelSpacingTags) {
/* 64 */     int[] ratio = attrs.getInts(aspectRatioTag);
/* 65 */     if (ratio != null && ratio.length == 2 && ratio[0] > 0 && ratio[1] > 0)
/*    */     {
/* 67 */       return ratio[0] / ratio[1];
/*    */     }
/* 69 */     for (int pixelSpacingTag : pixelSpacingTags) {
/* 70 */       float[] spaces = attrs.getFloats(pixelSpacingTag);
/* 71 */       if (spaces != null && spaces.length == 2 && spaces[0] > 0.0F && spaces[1] > 0.0F)
/*    */       {
/* 73 */         return spaces[0] / spaces[1]; } 
/*    */     } 
/* 75 */     return 1.0F;
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/image/PixelAspectRatio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */