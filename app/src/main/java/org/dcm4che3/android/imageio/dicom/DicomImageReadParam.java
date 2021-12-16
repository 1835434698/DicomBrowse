/*     */ package org.dcm4che3.android.imageio.dicom;
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
/*     */ public class DicomImageReadParam
/*     */ {
/*     */   private float windowCenter;
/*     */   private float windowWidth;
/*     */   private boolean autoWindowing = true;
/*     */   private boolean preferWindow = true;
/*     */   private int windowIndex;
/*     */   private int voiLUTIndex;
/*  55 */   private int overlayActivationMask = 15;
/*  56 */   private int overlayGrayscaleValue = 65535;
/*     */   private Attributes presentationState;
/*     */   
/*     */   public float getWindowCenter() {
/*  60 */     return this.windowCenter;
/*     */   }
/*     */   
/*     */   public void setWindowCenter(float windowCenter) {
/*  64 */     this.windowCenter = windowCenter;
/*     */   }
/*     */   
/*     */   public float getWindowWidth() {
/*  68 */     return this.windowWidth;
/*     */   }
/*     */   
/*     */   public void setWindowWidth(float windowWidth) {
/*  72 */     this.windowWidth = windowWidth;
/*     */   }
/*     */   
/*     */   public boolean isAutoWindowing() {
/*  76 */     return this.autoWindowing;
/*     */   }
/*     */   
/*     */   public void setAutoWindowing(boolean autoWindowing) {
/*  80 */     this.autoWindowing = autoWindowing;
/*     */   }
/*     */   
/*     */   public boolean isPreferWindow() {
/*  84 */     return this.preferWindow;
/*     */   }
/*     */   
/*     */   public void setPreferWindow(boolean preferWindow) {
/*  88 */     this.preferWindow = preferWindow;
/*     */   }
/*     */   
/*     */   public int getWindowIndex() {
/*  92 */     return this.windowIndex;
/*     */   }
/*     */   
/*     */   public void setWindowIndex(int windowIndex) {
/*  96 */     this.windowIndex = Math.max(windowIndex, 0);
/*     */   }
/*     */   
/*     */   public int getVOILUTIndex() {
/* 100 */     return this.voiLUTIndex;
/*     */   }
/*     */   
/*     */   public void setVOILUTIndex(int voiLUTIndex) {
/* 104 */     this.voiLUTIndex = Math.max(voiLUTIndex, 0);
/*     */   }
/*     */   
/*     */   public Attributes getPresentationState() {
/* 108 */     return this.presentationState;
/*     */   }
/*     */   
/*     */   public void setPresentationState(Attributes presentationState) {
/* 112 */     this.presentationState = presentationState;
/*     */   }
/*     */   
/*     */   public int getOverlayActivationMask() {
/* 116 */     return this.overlayActivationMask;
/*     */   }
/*     */   
/*     */   public void setOverlayActivationMask(int overlayActivationMask) {
/* 120 */     this.overlayActivationMask = overlayActivationMask;
/*     */   }
/*     */   
/*     */   public int getOverlayGrayscaleValue() {
/* 124 */     return this.overlayGrayscaleValue;
/*     */   }
/*     */   
/*     */   public void setOverlayGrayscaleValue(int overlayGrayscaleValue) {
/* 128 */     this.overlayGrayscaleValue = overlayGrayscaleValue;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/imageio/dicom/DicomImageReadParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */