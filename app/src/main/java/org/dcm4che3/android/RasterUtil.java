 package org.dcm4che3.android;

 import android.graphics.Bitmap;
 import android.graphics.Color;

 public class RasterUtil
 {
   public static int rgb565to24(short v) {
/*   9 */     int i = uShortToInt(v);
/*  10 */     byte r = (byte)(i & 0x1F);
/*  11 */     byte g = (byte)(i & 0x3F);
/*  12 */     byte b = (byte)(i & 0x1F);
/*  13 */     return Color.rgb(r, g, b);
   }
 
   
   public static int rgb24to565(byte r, byte g, byte b) {
/*  18 */     int i = r << 8 & 0xF800 | g << 3 & 0x7E0 | b >> 3;
 
     
/*  21 */     return i;
   }
 
 
 
 
 
 
 
   
   public static short intToUShort(int ushort) {
/*  32 */     if (ushort > 32767 && ushort < 65536) {
/*  33 */       ushort -= 65536;
     }
/*  35 */     return (short)ushort;
   }
 
 
 
 
 
 
   
   public static int uShortToInt(short ushort) {
/*  45 */     int v = ushort;
/*  46 */     if (v < 0) {
/*  47 */       v += 65536;
     }
/*  49 */     return v;
   }
 
 
 
 
 
 
   
   public static int longToUInt(long lInt) {
/*  59 */     if (lInt > 2147483647L && lInt < 4294967295L) {
/*  60 */       lInt -= 4294967295L;
     }
/*  62 */     return (int)lInt;
   }
 
 
 
 
 
   
   public static long uIntToLong(int i) {
/*  71 */     long v = i;
     
/*  73 */     if (v < 0L) {
/*  74 */       v += 4294967295L;
     }
/*  76 */     return v;
   }
   
   public static Bitmap gray8ToBitmap(int width, int height, byte[] data) {
/*  80 */     int ilength = data.length;
/*  81 */     int[] colors = new int[ilength];
/*  82 */     for (int i = 0; i < ilength; i++) {
/*  83 */       int v = data[i] & 0xFF;
/*  84 */       colors[i] = Color.rgb(v, v, v);
     } 
     
/*  87 */     Bitmap bmp = Bitmap.createBitmap(colors, width, height, Bitmap.Config.ARGB_8888);
/*  88 */     return bmp;
   }
   
   public static Bitmap ARGBToBitmap(int width, int height, int[] data) {
/*  92 */     int ilength = data.length;
/*  93 */     int[] colors = new int[ilength];
/*  94 */     System.arraycopy(data, 0, colors, 0, ilength);
/*  95 */     Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
/*  96 */     return bmp;
   }
 
 
   
   public static Bitmap RGB16ToBitmap(int width, int height, short[] data) {
/* 102 */     int ilength = data.length;
/* 103 */     int[] colors = new int[ilength];
/* 104 */     for (int i = 0; i < ilength; i++) {
/* 105 */       colors[i] = rgb565to24(data[i]);
     }
/* 107 */     Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
     
/* 109 */     return bmp;
   }
 
   
   public static Bitmap rasterToBitmap(Raster raster) {
/* 114 */     switch (raster.dataType) {
       case 0:
/* 116 */         return gray8ToBitmap(raster.getWidth(), raster.getHeight(), raster.getByteData());
       case 1:
/* 118 */         return RGB16ToBitmap(raster.getWidth(), raster.getHeight(), raster.getShortData());
       case 3:
/* 120 */         return ARGBToBitmap(raster.getWidth(), raster.getHeight(), raster.getIntData());
     } 
/* 122 */     return null;
   }
 }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/RasterUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */