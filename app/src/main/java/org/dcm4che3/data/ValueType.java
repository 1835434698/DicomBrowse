package org.dcm4che3.data;

import java.util.Date;
import java.util.TimeZone;

interface ValueType {
  boolean isStringValue();
  
  boolean useSpecificCharacterSet();
  
  boolean isIntValue();
  
  boolean isTemporalType();
  
  int numEndianBytes();
  
  byte[] toggleEndian(byte[] paramArrayOfbyte, boolean paramBoolean);
  
  byte[] toBytes(Object paramObject, SpecificCharacterSet paramSpecificCharacterSet);
  
  String toString(Object paramObject, boolean paramBoolean, int paramInt, String paramString);
  
  Object toStrings(Object paramObject, boolean paramBoolean, SpecificCharacterSet paramSpecificCharacterSet);
  
  int toInt(Object paramObject, boolean paramBoolean, int paramInt1, int paramInt2);
  
  int[] toInts(Object paramObject, boolean paramBoolean);
  
  float toFloat(Object paramObject, boolean paramBoolean, int paramInt, float paramFloat);
  
  float[] toFloats(Object paramObject, boolean paramBoolean);
  
  double toDouble(Object paramObject, boolean paramBoolean, int paramInt, double paramDouble);
  
  double[] toDoubles(Object paramObject, boolean paramBoolean);
  
  Date toDate(Object paramObject, TimeZone paramTimeZone, int paramInt, boolean paramBoolean, Date paramDate, DatePrecision paramDatePrecision);
  
  Date[] toDate(Object paramObject, TimeZone paramTimeZone, boolean paramBoolean, DatePrecisions paramDatePrecisions);
  
  Object toValue(byte[] paramArrayOfbyte);
  
  Object toValue(String paramString, boolean paramBoolean);
  
  Object toValue(String[] paramArrayOfString, boolean paramBoolean);
  
  Object toValue(int[] paramArrayOfint, boolean paramBoolean);
  
  Object toValue(float[] paramArrayOffloat, boolean paramBoolean);
  
  Object toValue(double[] paramArrayOfdouble, boolean paramBoolean);
  
  Object toValue(Date[] paramArrayOfDate, TimeZone paramTimeZone, DatePrecision paramDatePrecision);
  
  boolean prompt(Object paramObject, boolean paramBoolean, SpecificCharacterSet paramSpecificCharacterSet, int paramInt, StringBuilder paramStringBuilder);
  
  int vmOf(Object paramObject);
}


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/ValueType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */