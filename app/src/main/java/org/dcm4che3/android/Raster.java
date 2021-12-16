/*     */ package org.dcm4che3.android;
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
/*     */ public class Raster
/*     */ {
/*     */   public static final int TYPE_BYTE = 0;
/*     */   public static final int TYPE_USHORT = 1;
/*     */   public static final int TYPE_SHORT = 2;
/*     */   public static final int TYPE_INT = 3;
/*     */   public static final int TYPE_FLOAT = 4;
/*     */   public static final int TYPE_DOUBLE = 5;
/*     */   public static final int TYPE_LONG = 6;
/*     */   public static final int TYPE_UNDEFINED = 32;
/*     */   protected int width;
/*     */   protected int height;
/*     */   protected int dataType;
/*     */   protected int iLength;
/*     */   protected int iSize;
/*     */   protected byte[] bData;
/*     */   protected short[] sData;
/*     */   protected int[] iData;
/*     */   protected long[] lData;
/*     */   protected float[] fData;
/*     */   protected double[] dData;
/*     */   
/*     */   public int getDataType() {
/*  64 */     return this.dataType;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/*  69 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  74 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getByteData() {
/*  79 */     return this.bData;
/*     */   }
/*     */ 
/*     */   
/*     */   public short[] getShortData() {
/*  84 */     return this.sData;
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] getIntData() {
/*  89 */     return this.iData;
/*     */   }
/*     */   
/*     */   public float[] getFloatData() {
/*  93 */     return this.fData;
/*     */   }
/*     */   
/*     */   public double[] getDoubleData() {
/*  97 */     return this.dData;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Raster(int width, int height, int dataType) {
/* 103 */     this.width = width;
/* 104 */     this.height = height;
/* 105 */     this.dataType = dataType;
/* 106 */     this.iLength = width * height;
/* 107 */     switch (dataType) {
/*     */       case 2:
/* 109 */         this.sData = new short[this.iLength];
/* 110 */         this.iSize = this.iLength * 2;
/*     */         return;
/*     */       
/*     */       case 1:
/* 114 */         this.sData = new short[this.iLength];
/* 115 */         this.iSize = this.iLength * 2;
/*     */         return;
/*     */       case 3:
/* 118 */         this.iData = new int[this.iLength];
/* 119 */         this.iSize = this.iLength * 4;
/*     */         return;
/*     */       case 4:
/* 122 */         this.fData = new float[this.iLength];
/* 123 */         this.iSize = this.iLength * 8;
/*     */         return;
/*     */       case 5:
/* 126 */         this.dData = new double[this.iLength];
/* 127 */         this.iSize = this.iLength * 8;
/*     */         return;
/*     */       case 6:
/* 130 */         this.lData = new long[this.iLength];
/* 131 */         this.iSize = this.iLength * 8;
/*     */         return;
/*     */     } 
/*     */     
/* 135 */     this.bData = new byte[this.iLength];
/* 136 */     this.iSize = this.iLength;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/* 147 */     return this.iLength;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 157 */     return this.iSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getVal(int index) {
/* 162 */     int v = 0;
/* 163 */     switch (this.dataType)
/*     */     { case 2:
/* 165 */         v = this.sData[index];
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
/* 177 */         return v;case 1: v = RasterUtil.uShortToInt(this.sData[index]); return v;case 3: v = this.iData[index]; return v; }  v = this.bData[index]; return v;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVal(int index, int v) {
/* 182 */     switch (this.dataType) {
/*     */       case 2:
/* 184 */         this.sData[index] = (short)v;
/*     */         return;
/*     */       
/*     */       case 1:
/* 188 */         this.sData[index] = RasterUtil.intToUShort(v);
/*     */         return;
/*     */       
/*     */       case 3:
/* 192 */         this.iData[index] = v;
/*     */         return;
/*     */     } 
/* 195 */     this.bData[index] = (byte)v;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/Raster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */