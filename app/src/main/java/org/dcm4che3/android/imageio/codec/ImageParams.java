/*     */ package org.dcm4che3.android.imageio.codec;
/*     */ 
/*     */

import org.dcm4che3.android.image.PhotometricInterpretation;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.VR;

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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ImageParams
/*     */ {
/*     */   private final int rows;
/*     */   private final int cols;
/*     */   private final int samples;
/*     */   private final int pixelRepresentation;
/*     */   private final int bitsAllocated;
/*     */   private final int bitsStored;
/*     */   private final int frames;
/*     */   private final int frameLength;
/*     */   private final int length;
/*     */   private PhotometricInterpretation pmi;
/*     */   private int planarConfiguration;
/*     */   
/*     */   public ImageParams(Attributes attrs) {
/*  72 */     this.rows = attrs.getInt(2621456, 0);
/*  73 */     this.cols = attrs.getInt(2621457, 0);
/*  74 */     this.samples = attrs.getInt(2621442, 0);
/*  75 */     this.pmi = PhotometricInterpretation.fromString(attrs.getString(2621444, "MONOCHROME2"));
/*     */     
/*  77 */     this.bitsAllocated = attrs.getInt(2621696, 8);
/*  78 */     this.bitsStored = attrs.getInt(2621697, this.bitsAllocated);
/*  79 */     this.planarConfiguration = attrs.getInt(2621446, 0);
/*  80 */     this.pixelRepresentation = attrs.getInt(2621699, 0);
/*  81 */     this.frames = attrs.getInt(2621448, 1);
/*  82 */     this.frameLength = this.rows * this.cols * this.samples * (this.bitsAllocated >>> 3);
/*  83 */     this.length = this.frameLength * this.frames;
/*     */   }
/*     */   
/*     */   public int getRows() {
/*  87 */     return this.rows;
/*     */   }
/*     */   
/*     */   public int getColumns() {
/*  91 */     return this.cols;
/*     */   }
/*     */   
/*     */   public int getSamples() {
/*  95 */     return this.samples;
/*     */   }
/*     */   
/*     */   public int getBitsAllocated() {
/*  99 */     return this.bitsAllocated;
/*     */   }
/*     */   
/*     */   public int getBitsStored() {
/* 103 */     return this.bitsStored;
/*     */   }
/*     */   
/*     */   public int getFrameLength() {
/* 107 */     return this.frameLength;
/*     */   }
/*     */   
/*     */   public int getLength() {
/* 111 */     return this.length;
/*     */   }
/*     */   
/*     */   public PhotometricInterpretation getPhotometricInterpretation() {
/* 115 */     return this.pmi;
/*     */   }
/*     */   
/*     */   public int getEncodedLength() {
/* 119 */     return this.length + 1 & 0xFFFFFFFE;
/*     */   }
/*     */   
/*     */   public boolean paddingNull() {
/* 123 */     return ((this.length & 0x1) != 0);
/*     */   }
/*     */   
/*     */   public boolean isBanded() {
/* 127 */     return (this.planarConfiguration != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSigned() {
/* 132 */     return (this.pixelRepresentation != 0);
/*     */   }
/*     */   
/*     */   public int getFrames() {
/* 136 */     return this.frames;
/*     */   }
/*     */   
/*     */   public void decompress(Attributes attrs, TransferSyntaxType tstype) {
/* 140 */     if (this.samples > 1) {
/* 141 */       this.pmi = this.pmi.decompress();
/* 142 */       this.planarConfiguration = tstype.getPlanarConfiguration();
/* 143 */       attrs.setString(2621444, VR.CS, this.pmi.toString());
/* 144 */       attrs.setInt(2621446, VR.US, new int[] { this.planarConfiguration });
/*     */     } 
/*     */   }
/*     */   
/*     */   public void compress(Attributes attrs, TransferSyntaxType tstype) {
/* 149 */     if (this.samples > 1) {
/* 150 */       this.pmi = tstype.compress(this.pmi);
/* 151 */       this.planarConfiguration = tstype.getPlanarConfiguration();
/* 152 */       attrs.setString(2621444, VR.CS, this.pmi.toString());
/* 153 */       attrs.setInt(2621446, VR.US, new int[] { this.planarConfiguration });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/imageio/codec/ImageParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */