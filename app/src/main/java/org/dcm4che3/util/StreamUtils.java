/*     */ package org.dcm4che3.util;
/*     */ 
/*     */

import android.util.Log;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

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
/*     */ public class StreamUtils
/*     */ {
/*     */   private static final int COPY_BUFFER_SIZE = 2048;
/*     */   
/*     */   public static void readFully(InputStream in, byte[] b, int off, int len) throws IOException {
    byte[] b1;
    if (b.length > 100){
        b1 = new byte[100];
        System.arraycopy(b, 0, b1, 0, 100);
    }else {
        b1 = new byte[b.length];
        System.arraycopy(b, 0, b1, 0, b.length);
    }
                Log.d("tangzy", "111_ readFully off = "+ off+", len = "+len +", b = "+bytesToHexString(b1));
/*  58 */     if (off < 0 || len < 0 || off + len > b.length)
/*  59 */       throw new IndexOutOfBoundsException(); 
/*  60 */     while (len > 0) {
/*  61 */       int count = in.read(b, off, len);
/*  62 */       if (count < 0)
/*  63 */         throw new EOFException(); 
/*  64 */       off += count;
/*  65 */       len -= count;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void skipFully(InputStream in, long n) throws IOException {
/*  70 */     while (n > 0L) {
/*  71 */       long count = in.skip(n);
/*  72 */       if (count <= 0L)
/*  73 */         throw new EOFException(); 
/*  74 */       n -= count;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void copy(InputStream in, OutputStream out, byte[] buf) throws IOException {
/*     */     int count;
/*  81 */     while ((count = in.read(buf, 0, buf.length)) > 0) {
/*  82 */       out.write(buf, 0, count);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void copy(InputStream in, OutputStream out) throws IOException {
/*  87 */     copy(in, out, new byte[2048]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void copy(InputStream in, OutputStream out, int len, byte[] buf) throws IOException {
/*  92 */     if (len < 0)
/*  93 */       throw new IndexOutOfBoundsException(); 
/*  94 */     while (len > 0) {
/*  95 */       int count = in.read(buf, 0, Math.min(len, buf.length));
/*  96 */       if (count < 0)
/*  97 */         throw new EOFException(); 
/*  98 */       out.write(buf, 0, count);
/*  99 */       len -= count;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void copy(InputStream in, OutputStream out, int len) throws IOException {
/* 105 */     copy(in, out, len, new byte[Math.min(len, 2048)]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void copy(InputStream in, OutputStream out, int len, int swapBytes, byte[] buf) throws IOException {
/* 110 */     if (swapBytes == 1) {
/* 111 */       copy(in, out, len, buf);
/*     */       return;
/*     */     } 
/* 114 */     if (swapBytes != 2 && swapBytes != 4)
/* 115 */       throw new IllegalArgumentException("swapBytes: " + swapBytes); 
/* 116 */     if (len < 0 || len % swapBytes != 0)
/* 117 */       throw new IllegalArgumentException("length: " + len); 
/* 118 */     int off = 0;
/* 119 */     while (len > 0) {
/* 120 */       int count = in.read(buf, off, Math.min(len, buf.length - off));
/* 121 */       if (count < 0)
/* 122 */         throw new EOFException(); 
/* 123 */       len -= count;
/* 124 */       count += off;
/* 125 */       off = count % swapBytes;
/* 126 */       count -= off;
/* 127 */       switch (swapBytes) {
/*     */         case 2:
/* 129 */           ByteUtils.swapShorts(buf, 0, count);
/*     */           break;
/*     */         case 4:
/* 132 */           ByteUtils.swapInts(buf, 0, count);
/*     */           break;
/*     */         case 8:
/* 135 */           ByteUtils.swapLongs(buf, 0, count);
/*     */           break;
/*     */       } 
/* 138 */       out.write(buf, 0, count);
/* 139 */       if (off > 0) {
/* 140 */         System.arraycopy(buf, count, buf, 0, off);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void copy(InputStream in, OutputStream out, int len, int swapBytes) throws IOException {
/* 146 */     copy(in, out, len, swapBytes, new byte[Math.min(len, 2048)]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static InputStream openFileOrURL(String name) throws IOException {
/* 151 */     if (name.startsWith("resource:")) {
/* 152 */       URL url = ResourceLocator.getResourceURL(name.substring(9), StreamUtils.class);
/* 153 */       if (url == null)
/* 154 */         throw new FileNotFoundException(name); 
/* 155 */       return url.openStream();
/*     */     } 
/* 157 */     if (name.indexOf(':') < 2)
/* 158 */       return new FileInputStream(name); 
/* 159 */     return (new URL(name)).openStream();
/*     */   }

    // 这个方法的源码
    public static String toBinaryString(byte[] var0) {
        String var1 = "";

        for(int var2 = 0; var2 < var0.length; ++var2) {
            byte var3 = var0[var2];

            for(int var4 = 0; var4 < 8; ++var4) {
                int var5 = var3 >>> var4 & 1;
                var1 = var1 + var5;
            }

            if (var2 != var0.length - 1) {
                var1 = var1 + " ";
            }
        }

        return var1;
    }
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
    /**
     * Convert hex string to byte[]
     * @param hexString the hex string
     * @return byte[]
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }
    /**
     * Convert char to byte
     * @param c char
     * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/util/StreamUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */