/*     */ package org.dcm4che3.util;
/*     */ 
/*     */

import org.dcm4che3.data.UID;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.UUID;
import java.util.regex.Pattern;

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
/*     */ public class UIDUtils
/*     */ {
/*     */   private static final String UUID_ROOT = "2.25";
/*  62 */   private static final Pattern PATTERN = Pattern.compile("[012]((\\.0)|(\\.[1-9]\\d*))+");
/*     */ 
/*     */   
/*  65 */   private static String root = "2.25";
/*     */   
/*     */   public static final String getRoot() {
/*  68 */     return root;
/*     */   }
/*     */   
/*     */   public static final void setRoot(String root) {
/*  72 */     checkRoot(root);
/*  73 */     UIDUtils.root = root;
/*     */   }
/*     */   
/*     */   private static void checkRoot(String root) {
/*  77 */     if (root.length() > 24)
/*  78 */       throw new IllegalArgumentException("root length > 24"); 
/*  79 */     if (!isValid(root))
/*  80 */       throw new IllegalArgumentException(root); 
/*     */   }
/*     */   
/*     */   public static boolean isValid(String uid) {
/*  84 */     return (uid.length() <= 64 && PATTERN.matcher(uid).matches());
/*     */   }
/*     */   
/*     */   public static String createUID() {
/*  88 */     return randomUID(root);
/*     */   }
/*     */   
/*     */   public static String createNameBasedUID(byte[] name) {
/*  92 */     return nameBasedUID(name, root);
/*     */   }
/*     */   
/*     */   public static String createNameUID(byte[] name, String root) {
/*  96 */     checkRoot(root);
/*  97 */     return nameBasedUID(name, root);
/*     */   }
/*     */   
/*     */   public static String createUID(String root) {
/* 101 */     checkRoot(root);
/* 102 */     return randomUID(root);
/*     */   }
/*     */   
/*     */   public static String createUIDIfNull(String uid) {
/* 106 */     return (uid == null) ? randomUID(root) : uid;
/*     */   }
/*     */   
/*     */   public static String createUIDIfNull(String uid, String root) {
/* 110 */     checkRoot(root);
/* 111 */     return (uid == null) ? randomUID(root) : uid;
/*     */   }
/*     */   
/*     */   private static String randomUID(String root) {
/* 115 */     return toUID(root, UUID.randomUUID());
/*     */   }
/*     */   
/*     */   private static String nameBasedUID(byte[] name, String root) {
/* 119 */     return toUID(root, UUID.nameUUIDFromBytes(name));
/*     */   }
/*     */   
/*     */   private static String toUID(String root, UUID uuid) {
/* 123 */     byte[] b17 = new byte[17];
/* 124 */     ByteUtils.longToBytesBE(uuid.getMostSignificantBits(), b17, 1);
/* 125 */     ByteUtils.longToBytesBE(uuid.getLeastSignificantBits(), b17, 9);
/* 126 */     String uuidStr = (new BigInteger(b17)).toString();
/* 127 */     int rootlen = root.length();
/* 128 */     int uuidlen = uuidStr.length();
/* 129 */     char[] cs = new char[rootlen + uuidlen + 1];
/* 130 */     root.getChars(0, rootlen, cs, 0);
/* 131 */     cs[rootlen] = '.';
/* 132 */     uuidStr.getChars(0, uuidlen, cs, rootlen + 1);
/* 133 */     return new String(cs);
/*     */   }
/*     */   
/*     */   public static StringBuilder promptTo(String uid, StringBuilder sb) {
/* 137 */     return sb.append(uid).append(" - ").append(UID.nameOf(uid));
/*     */   }
/*     */   
/*     */   public static String[] findUIDs(String regex) {
/* 141 */     Pattern p = Pattern.compile(regex);
/* 142 */     Field[] fields = UID.class.getFields();
/* 143 */     String[] uids = new String[fields.length];
/* 144 */     int j = 0;
/* 145 */     for (int i = 0; i < fields.length; i++) {
/* 146 */       Field field = fields[i];
/* 147 */       if (p.matcher(field.getName()).matches())
/*     */         try {
/* 149 */           uids[j++] = (String)field.get(null);
/* 150 */         } catch (Exception ignore) {} 
/*     */     } 
/* 152 */     return Arrays.<String>copyOf(uids, j);
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/util/UIDUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */