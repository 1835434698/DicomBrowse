/*     */ package org.dcm4che3.util;
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
/*     */ public class TagUtils
/*     */ {
/*  49 */   private static char[] HEX_DIGITS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String shortToHexString(int n) {
/*  55 */     char[] s = { HEX_DIGITS[n >>> 12 & 0xF], HEX_DIGITS[n >>> 8 & 0xF], HEX_DIGITS[n >>> 4 & 0xF], HEX_DIGITS[n >>> 0 & 0xF] };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     return new String(s);
/*     */   }
/*     */   
/*     */   public static String toHexString(int tag) {
/*  64 */     char[] s = { HEX_DIGITS[tag >>> 28], HEX_DIGITS[tag >>> 24 & 0xF], HEX_DIGITS[tag >>> 20 & 0xF], HEX_DIGITS[tag >>> 16 & 0xF], HEX_DIGITS[tag >>> 12 & 0xF], HEX_DIGITS[tag >>> 8 & 0xF], HEX_DIGITS[tag >>> 4 & 0xF], HEX_DIGITS[tag >>> 0 & 0xF] };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  73 */     return new String(s);
/*     */   }
/*     */   
/*     */   public static String toHexString(byte[] b) {
/*  77 */     char[] s = new char[b.length << 1];
/*  78 */     for (int i = 0, j = 0; i < b.length; i++) {
/*  79 */       s[j++] = HEX_DIGITS[b[i] >>> 4 & 0xF];
/*  80 */       s[j++] = HEX_DIGITS[b[i] & 0xF];
/*     */     } 
/*  82 */     return new String(s);
/*     */   }
/*     */   
/*     */   public static String toString(int tag) {
/*  86 */     char[] s = { '(', HEX_DIGITS[tag >>> 28], HEX_DIGITS[tag >>> 24 & 0xF], HEX_DIGITS[tag >>> 20 & 0xF], HEX_DIGITS[tag >>> 16 & 0xF], ',', HEX_DIGITS[tag >>> 12 & 0xF], HEX_DIGITS[tag >>> 8 & 0xF], HEX_DIGITS[tag >>> 4 & 0xF], HEX_DIGITS[tag >>> 0 & 0xF], ')' };
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
/*  98 */     return new String(s);
/*     */   }
/*     */   
/*     */   public static int groupNumber(int tag) {
/* 102 */     return tag >>> 16;
/*     */   }
/*     */   
/*     */   public static int elementNumber(int tag) {
/* 106 */     return tag & 0xFFFF;
/*     */   }
/*     */   
/*     */   public static boolean isGroupLength(int tag) {
/* 110 */     return (elementNumber(tag) == 0);
/*     */   }
/*     */   
/*     */   public static boolean isPrivateCreator(int tag) {
/* 114 */     return ((tag & 0x10000) != 0 && (tag & 0xFF00) == 0 && (tag & 0xF0) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isPrivateGroup(int tag) {
/* 120 */     return ((tag & 0x10000) != 0);
/*     */   }
/*     */   
/*     */   public static boolean isPrivateTag(int tag) {
/* 124 */     return ((tag & 0x10000) != 0 && (tag & 0xFF00) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int toTag(int groupNumber, int elementNumber) {
/* 129 */     return groupNumber << 16 | elementNumber;
/*     */   }
/*     */   
/*     */   public static int toPrivateTag(int creatorTag, int elementNumber) {
/* 133 */     return creatorTag & 0xFFFF0000 | (creatorTag & 0xFF) << 8 | elementNumber & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int creatorTagOf(int tag) {
/* 139 */     return tag & 0xFFFF0000 | tag >>> 8 & 0xFF;
/*     */   }
/*     */   
/*     */   public static int groupLengthTagOf(int tag) {
/* 143 */     return tag & 0xFFFF0000;
/*     */   }
/*     */   
/*     */   public static boolean isItem(int tag) {
/* 147 */     return (tag == -73728 || tag == -73715 || tag == -73507);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isFileMetaInformation(int tag) {
/* 153 */     return ((tag & 0xFFFF0000) == 131072);
/*     */   }
/*     */   
/*     */   public static int normalizeRepeatingGroup(int tag) {
/* 157 */     int gg000000 = tag & 0xFFE00000;
/* 158 */     return (gg000000 == 1342177280 || gg000000 == 1610612736) ? (tag & 0xFFE0FFFF) : tag;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/util/TagUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */