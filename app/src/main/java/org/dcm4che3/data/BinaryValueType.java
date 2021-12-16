/*     */ package org.dcm4che3.data;
/*     */ 
/*     */

import android.annotation.SuppressLint;

import org.dcm4che3.util.ByteUtils;
import org.dcm4che3.util.StringUtils;
import org.dcm4che3.util.TagUtils;

import java.util.Date;
import java.util.TimeZone;

/*     */
/*     */ 
/*     */ enum BinaryValueType
/*     */   implements ValueType
/*     */ {
/*  53 */   BYTE(1, 1)
/*     */   {
/*     */     public byte[] toggleEndian(byte[] b, boolean preserve)
/*     */     {
/*  57 */       return b;
/*     */     }

    @Override
    public Object toValue(double[] paramArrayOfdouble, boolean paramBoolean) {
        return null;
    }

    /*     */
/*     */
/*     */     protected int toInt(byte[] b, int off, boolean bigEndian) {
/*  62 */       return b[off];
/*     */     }
/*     */
/*     */
/*     */     protected byte[] toBytes(int i, byte[] b, int off, boolean bigEndian) {
/*  67 */       b[off] = (byte)i;
/*  68 */       return b;
/*     */     }
/*     */   },
/*  71 */   SHORT(2, 2)
/*     */   {
/*     */     public boolean isIntValue()
/*     */     {
/*  75 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public byte[] toggleEndian(byte[] b, boolean preserve) {
/*  80 */       return ByteUtils.swapShorts(preserve ? (byte[])b.clone() : b, 0, b.length);
/*     */     }
/*     */ 
/*     */     
/*     */     protected int toInt(byte[] b, int off, boolean bigEndian) {
/*  85 */       return ByteUtils.bytesToShort(b, off, bigEndian);
/*     */     }
/*     */ 
/*     */     
/*     */     protected byte[] toBytes(int i, byte[] b, int off, boolean bigEndian) {
/*  90 */       return ByteUtils.shortToBytes(i, b, off, bigEndian);
/*     */     }
/*     */   },
/*  93 */   USHORT(2, 2)
/*     */   {
/*     */     public boolean isIntValue()
/*     */     {
/*  97 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public byte[] toggleEndian(byte[] b, boolean preserve) {
/* 102 */       return ByteUtils.swapShorts(preserve ? (byte[])b.clone() : b, 0, b.length);
/*     */     }
/*     */ 
/*     */     
/*     */     protected int toInt(byte[] b, int off, boolean bigEndian) {
/* 107 */       return ByteUtils.bytesToUShort(b, off, bigEndian);
/*     */     }
/*     */ 
/*     */     
/*     */     protected byte[] toBytes(int i, byte[] b, int off, boolean bigEndian) {
/* 112 */       return ByteUtils.shortToBytes(i, b, off, bigEndian);
/*     */     }
/*     */   },
/* 115 */   INT(4, 4)
/*     */   {
/*     */     public boolean isIntValue()
/*     */     {
/* 119 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public byte[] toggleEndian(byte[] b, boolean preserve) {
/* 124 */       return ByteUtils.swapInts(preserve ? (byte[])b.clone() : b, 0, b.length);
/*     */     }
/*     */ 
/*     */     
/*     */     protected int toInt(byte[] b, int off, boolean bigEndian) {
/* 129 */       return ByteUtils.bytesToInt(b, off, bigEndian);
/*     */     }
/*     */ 
/*     */     
/*     */     protected byte[] toBytes(int i, byte[] b, int off, boolean bigEndian) {
/* 134 */       return ByteUtils.intToBytes(i, b, off, bigEndian);
/*     */     }
/*     */   },
    UINT(4, 4) {

        @Override
        public boolean isIntValue() {
            return true;
        }

        @Override
        public byte[] toggleEndian(byte[] b, boolean preserve) {
            return ByteUtils.swapInts(preserve ? b.clone() : b, 0, b.length);
        }

        @Override
        protected int toInt(byte[] b, int off, boolean bigEndian) {
            return ByteUtils.bytesToInt(b, off, bigEndian);
        }

//        @Override
        protected long toLong(byte[] b, int off, boolean bigEndian) {
            return toInt(b, off, bigEndian);
        }

        @Override
        protected byte[] toBytes(int i, byte[] b, int off, boolean bigEndian) {
            return ByteUtils.intToBytes(i, b, off, bigEndian);
        }

//        @Override
        protected byte[] toBytes(long l, byte[] b, int off, boolean bigEndian) {
            return toBytes((int) l, b, off, bigEndian);
        }

        @SuppressLint("NewApi")
        @Override
        protected String toString(byte[] b, int off, boolean bigEndian) {
            return Integer.toUnsignedString(toInt(b, off, bigEndian));
        }
    },
/* 137 */   TAG(4, 2)
/*     */   {
/*     */     public byte[] toggleEndian(byte[] b, boolean preserve)
/*     */     {
/* 141 */       return ByteUtils.swapShorts(preserve ? (byte[])b.clone() : b, 0, b.length);
/*     */     }
/*     */ 
/*     */     
/*     */     protected String toString(byte[] b, int off, boolean bigEndian) {
/* 146 */       return TagUtils.toHexString(toInt(b, off, bigEndian));
/*     */     }
/*     */ 
/*     */     
/*     */     protected int toInt(byte[] b, int off, boolean bigEndian) {
/* 151 */       return ByteUtils.bytesToTag(b, off, bigEndian);
/*     */     }
/*     */ 
/*     */     
/*     */     protected byte[] toBytes(String s, byte[] b, int off, boolean bigEndian) {
/* 156 */       return toBytes(Integer.parseInt(s, 16), b, off, bigEndian);
/*     */     }
/*     */ 
/*     */     
/*     */     protected byte[] toBytes(int i, byte[] b, int off, boolean bigEndian) {
/* 161 */       return ByteUtils.tagToBytes(i, b, off, bigEndian);
/*     */     }
/*     */   },
    LONG(8, 8) {

        @Override
        public boolean isIntValue() {
            return true;
        }

        @Override
        public byte[] toggleEndian(byte[] b, boolean preserve) {
            return ByteUtils.swapLongs(preserve ? b.clone() : b, 0, b.length);
        }

        @Override
        protected int toInt(byte[] b, int off, boolean bigEndian) {
            return (int) toLong(b, off, bigEndian);
        }

//        @Override
        protected long toLong(byte[] b, int off, boolean bigEndian) {
            return ByteUtils.bytesToLong(b, off, bigEndian);
        }

        @Override
        protected byte[] toBytes(int i, byte[] b, int off, boolean bigEndian) {
            return toBytes((long) i, b, off, bigEndian);
        }

//        @Override
        protected byte[] toBytes(long l, byte[] b, int off, boolean bigEndian) {
            return ByteUtils.longToBytes(l, b, off, bigEndian);
        }
    },
    ULONG(8, 8) {

        @Override
        public boolean isIntValue() {
            return true;
        }

        @Override
        public byte[] toggleEndian(byte[] b, boolean preserve) {
            return ByteUtils.swapLongs(preserve ? b.clone() : b, 0, b.length);
        }

        @Override
        protected int toInt(byte[] b, int off, boolean bigEndian) {
            return (int) toLong(b, off, bigEndian);
        }

//        @Override
        protected long toLong(byte[] b, int off, boolean bigEndian) {
            return ByteUtils.bytesToLong(b, off, bigEndian);
        }

        @Override
        protected byte[] toBytes(String s, byte[] b, int off, boolean bigEndian) {
            return toBytes(StringUtils.parseUV(s), b, off, bigEndian);
        }

        @Override
        protected byte[] toBytes(int i, byte[] b, int off, boolean bigEndian) {
            return toBytes((long) i, b, off, bigEndian);
        }

//        @Override
        protected byte[] toBytes(long l, byte[] b, int off, boolean bigEndian) {
            return ByteUtils.longToBytes(l, b, off, bigEndian);
        }

        @SuppressLint("NewApi")
        @Override
        protected String toString(byte[] b, int off, boolean bigEndian) {
            return Long.toUnsignedString(toLong(b, off, bigEndian));
        }
    },
/* 164 */   FLOAT(4, 4)
/*     */   {
/*     */     public byte[] toggleEndian(byte[] b, boolean preserve)
/*     */     {
/* 168 */       return ByteUtils.swapInts(preserve ? (byte[])b.clone() : b, 0, b.length);
/*     */     }
/*     */ 
/*     */     
/*     */     protected String toString(byte[] b, int off, boolean bigEndian) {
/* 173 */       return StringUtils.formatDS(ByteUtils.bytesToFloat(b, off, bigEndian));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected float toFloat(byte[] b, int off, boolean bigEndian) {
/* 179 */       return ByteUtils.bytesToFloat(b, off, bigEndian);
/*     */     }
/*     */ 
/*     */     
/*     */     protected double toDouble(byte[] b, int off, boolean bigEndian) {
/* 184 */       return ByteUtils.bytesToFloat(b, off, bigEndian);
/*     */     }
/*     */ 
/*     */     
/*     */     protected byte[] toBytes(String s, byte[] b, int off, boolean bigEndian) {
/* 189 */       return toBytes(Float.parseFloat(s), b, off, bigEndian);
/*     */     }
/*     */ 
/*     */     
/*     */     protected byte[] toBytes(float f, byte[] b, int off, boolean bigEndian) {
/* 194 */       return ByteUtils.floatToBytes(f, b, off, bigEndian);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected byte[] toBytes(double d, byte[] b, int off, boolean bigEndian) {
/* 200 */       return ByteUtils.floatToBytes((float)d, b, off, bigEndian);
/*     */     }
/*     */   },
/* 203 */   DOUBLE(8, 8)
/*     */   {
/*     */     public byte[] toggleEndian(byte[] b, boolean preserve)
/*     */     {
/* 207 */       return ByteUtils.swapLongs(preserve ? (byte[])b.clone() : b, 0, b.length);
/*     */     }
/*     */ 
/*     */     
/*     */     protected String toString(byte[] b, int off, boolean bigEndian) {
/* 212 */       return StringUtils.formatDS(ByteUtils.bytesToDouble(b, off, bigEndian));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected float toFloat(byte[] b, int off, boolean bigEndian) {
/* 218 */       return (float)ByteUtils.bytesToDouble(b, off, bigEndian);
/*     */     }
/*     */ 
/*     */     
/*     */     protected double toDouble(byte[] b, int off, boolean bigEndian) {
/* 223 */       return ByteUtils.bytesToDouble(b, off, bigEndian);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected byte[] toBytes(String s, byte[] b, int off, boolean bigEndian) {
/* 229 */       return toBytes(Double.parseDouble(s), b, off, bigEndian);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected byte[] toBytes(float f, byte[] b, int off, boolean bigEndian) {
/* 235 */       return ByteUtils.doubleToBytes(f, b, off, bigEndian);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected byte[] toBytes(double d, byte[] b, int off, boolean bigEndian) {
/* 241 */       return ByteUtils.doubleToBytes(d, b, off, bigEndian);
/*     */     }
/*     */   };
/*     */   
/*     */   final int numBytes;
/*     */   final int numEndianBytes;
/*     */   
/*     */   BinaryValueType(int numBytes, int numEndianBytes) {
/* 249 */     this.numBytes = numBytes;
/* 250 */     this.numEndianBytes = numEndianBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isIntValue() {
/* 255 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStringValue() {
/* 260 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useSpecificCharacterSet() {
/* 265 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTemporalType() {
/* 270 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int numEndianBytes() {
/* 275 */     return this.numEndianBytes;
/*     */   }
/*     */   
/*     */   protected String toString(byte[] b, int off, boolean bigEndian) {
/* 279 */     return Integer.toString(toInt(b, off, bigEndian));
/*     */   }
/*     */   
/*     */   protected int toInt(byte[] b, int off, boolean bigEndian) {
/* 283 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   protected float toFloat(byte[] b, int off, boolean bigEndian) {
/* 287 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   protected double toDouble(byte[] b, int off, boolean bigEndian) {
/* 291 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   protected byte[] toBytes(String s, byte[] b, int off, boolean bigEndian) {
/* 295 */     return toBytes(StringUtils.parseIS(s), b, off, bigEndian);
/*     */   }
/*     */   
/*     */   protected byte[] toBytes(int i, byte[] b, int off, boolean bigEndian) {
/* 299 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   protected byte[] toBytes(float f, byte[] b, int off, boolean bigEndian) {
/* 303 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   protected byte[] toBytes(double d, byte[] b, int off, boolean bigEndian) {
/* 307 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] toBytes(Object val, SpecificCharacterSet cs) {
/* 312 */     if (val instanceof byte[]) {
/* 313 */       return (byte[])val;
/*     */     }
/* 315 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString(Object val, boolean bigEndian, int valueIndex, String defVal) {
/* 321 */     if (!(val instanceof byte[])) {
/* 322 */       throw new UnsupportedOperationException();
/*     */     }
/* 324 */     byte[] b = (byte[])val;
/* 325 */     int len = b.length;
/* 326 */     int off = valueIndex * this.numBytes;
/* 327 */     return (off + this.numBytes <= len) ? toString(b, off, bigEndian) : defVal;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkLength(int len) {
/* 333 */     if (len % this.numBytes != 0) {
/* 334 */       throw new IllegalArgumentException("length: " + len);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toStrings(Object val, boolean bigEndian, SpecificCharacterSet cs) {
    if (!(val instanceof byte[]))
        throw new UnsupportedOperationException();

    byte[] b = (byte[]) val;
    int len = b.length;
    checkLength(len);
    if (len == numBytes)
        return toString(b, 0, bigEndian);

    String[] ss = new String[len / numBytes];
    for (int i = 0, off = 0; i < ss.length; i++, off += numBytes)
        ss[i] = toString(b, off, bigEndian);
    return ss;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int toInt(Object val, boolean bigEndian, int valueIndex, int defVal) {
/* 358 */     if (!(val instanceof byte[])) {
/* 359 */       throw new UnsupportedOperationException();
/*     */     }
/* 361 */     byte[] b = (byte[])val;
/* 362 */     int len = b.length;
/* 363 */     int off = valueIndex * this.numBytes;
/* 364 */     return (off + this.numBytes <= len) ? toInt(b, off, bigEndian) : defVal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] toInts(Object val, boolean bigEndian) {
    if (!(val instanceof byte[]))
        throw new UnsupportedOperationException();

    byte[] b = (byte[]) val;
    int len = b.length;
    checkLength(len);
    int[] is = new int[len / numBytes];
    for (int i = 0, off = 0; i < is.length; i++, off += numBytes)
        is[i] = toInt(b, off, bigEndian);
    return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float toFloat(Object val, boolean bigEndian, int valueIndex, float defVal) {
/* 386 */     if (!(val instanceof byte[])) {
/* 387 */       throw new UnsupportedOperationException();
/*     */     }
/* 389 */     byte[] b = (byte[])val;
/* 390 */     int len = b.length;
/* 391 */     int off = valueIndex * this.numBytes;
/* 392 */     return (off + this.numBytes <= len) ? toFloat(b, off, bigEndian) : defVal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float[] toFloats(Object val, boolean bigEndian) {
    if (!(val instanceof byte[]))
        throw new UnsupportedOperationException();

    byte[] b = (byte[]) val;
    int len = b.length;
    checkLength(len);
    float[] fs = new float[len / numBytes];
    for (int i = 0, off = 0; i < fs.length; i++, off += numBytes)
        fs[i] = toFloat(b, off, bigEndian);
    return fs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double toDouble(Object val, boolean bigEndian, int valueIndex, double defVal) {
/* 414 */     if (!(val instanceof byte[])) {
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/* 417 */     byte[] b = (byte[])val;
/* 418 */     int len = b.length;
/* 419 */     int off = valueIndex * this.numBytes;
/* 420 */     return (off + this.numBytes <= len) ? toDouble(b, off, bigEndian) : defVal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double[] toDoubles(Object val, boolean bigEndian) {
    if (!(val instanceof byte[]))
        throw new UnsupportedOperationException();

    byte[] b = (byte[]) val;
    int len = b.length;
    checkLength(len);
    double[] ds = new double[len / numBytes];
    for (int i = 0, off = 0; i < ds.length; i++, off += numBytes)
        ds[i] = toDouble(b, off, bigEndian);
    return ds;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date toDate(Object val, TimeZone tz, int valueIndex, boolean ceil, Date defVal, DatePrecision precision) {
/* 442 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Date[] toDate(Object val, TimeZone tz, boolean ceil, DatePrecisions precisions) {
/* 448 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(byte[] b) {
/* 453 */     return (b != null && b.length > 0) ? b : Value.NULL;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(String s, boolean bigEndian) {
/* 458 */     if (s == null || s.isEmpty()) {
/* 459 */       return Value.NULL;
/*     */     }
/* 461 */     return toBytes(s, new byte[this.numBytes], 0, bigEndian);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toValue(String[] ss, boolean bigEndian) {
    if (ss == null || ss.length == 0)
        return Value.NULL;

    if (ss.length == 1)
        return toValue(ss[0], bigEndian);

    byte[] b = new byte[ss.length * numBytes];
    for (int i = 0, off = 0; i < ss.length; i++, off += numBytes)
        toBytes(ss[i], b, off, bigEndian);

    return b;
/*     */   }
/*     */

    @Override
    public Object toValue(int[] is, boolean bigEndian) {
        if (is == null || is.length == 0)
            return Value.NULL;

        byte[] b = new byte[is.length * numBytes];
        for (int i = 0, off = 0; i < is.length; i++, off += numBytes)
            toBytes(is[i], b, off, bigEndian);

        return b;
    }

    public Object toValue(long[] ls, boolean bigEndian) {
        if (ls == null || ls.length == 0)
            return Value.NULL;

        byte[] b = new byte[ls.length * numBytes];
        for (int i = 0, off = 0; i < ls.length; i++, off += numBytes)
            toBytes(ls[i], b, off, bigEndian);

        return b;
    }

    @Override
    public Object toValue(float[] fs, boolean bigEndian) {
        if (fs == null || fs.length == 0)
            return Value.NULL;

        byte[] b = new byte[fs.length * numBytes];
        for (int i = 0, off = 0; i < fs.length; i++, off += numBytes)
            toBytes(fs[i], b, off, bigEndian);

        return b;
    }
    @Override
    public Object toValue(double[] ds, boolean bigEndian) {
        if (ds == null || ds.length == 0)
            return Value.NULL;

        byte[] b = new byte[ds.length * numBytes];
        for (int i = 0, off = 0; i < ds.length; i++, off += numBytes)
            toBytes(ds[i], b, off, bigEndian);

        return b;
    }
    /*     */   public Object toValue(Date[] ds, TimeZone tz, DatePrecision precision) {
/* 517 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean prompt(Object val, boolean bigEndian, SpecificCharacterSet cs, int maxChars, StringBuilder sb) {
/* 523 */     if (val instanceof byte[]) {
/* 524 */       return prompt((byte[])val, bigEndian, maxChars, sb);
/*     */     }
/* 526 */     return StringValueType.prompt(val.toString(), maxChars, sb);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean prompt(byte[] b, boolean bigEndian, int maxChars, StringBuilder sb) {
    int maxLength = sb.length() + maxChars;
    for (int i = b.length / numBytes, off = 0; i-- > 0; off += numBytes) {
        sb.append(toString(b, off, bigEndian));
        if (sb.length() > maxLength) {
            sb.setLength(maxLength+1);
            return false;
        }
        if (i > 0)
            sb.append('\\');
    }
    return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int vmOf(Object val) {
/* 546 */     if (val instanceof byte[]) {
/* 547 */       return ((byte[])val).length / this.numBytes;
/*     */     }
/* 549 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/BinaryValueType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */