/*     */ package org.dcm4che3.data;
/*     */ 
/*     */

import org.dcm4che3.util.TagUtils;

import java.io.Serializable;
import java.util.ArrayList;

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
/*     */ public class ValueSelector
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 8346808223314626639L;
/*  54 */   private static final ItemPointer[] NO_ITEMPOINTERS = new ItemPointer[0];
/*     */   
/*     */   private static final int MIN_ITEM_POINTER_STR_LEN = 43;
/*     */   
/*     */   public final int tag;
/*     */   public final String privateCreator;
/*     */   public final VR vrTag;
/*     */   public final int valueIndex;
/*     */   public final ItemPointer[] itemPointers;
/*     */   
/*     */   public ValueSelector(String privateCreator, int tag, VR vrTag, int index, ItemPointer... itemPointers) {
/*  65 */     this.tag = tag;
/*  66 */     this.privateCreator = privateCreator;
/*  67 */     this.vrTag = vrTag;
/*  68 */     this.valueIndex = index;
/*  69 */     this.itemPointers = (ItemPointer[])itemPointers.clone();
/*     */   }
/*     */   
/*     */   public String selectStringValue(Attributes attrs, String defVal) {
/*  73 */     Attributes item = attrs.getNestedDataset(this.itemPointers);
/*  74 */     return (item != null) ? item.getString(this.privateCreator, this.tag, this.vrTag, this.valueIndex, defVal) : defVal;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  79 */     StringBuilder sb = new StringBuilder(32);
/*  80 */     for (ItemPointer ip : this.itemPointers) {
/*  81 */       appendTo(ip.sequenceTag, ip.privateCreator, ip.itemIndex, "\"]/Item[@number=\"", "\"]/", sb);
/*     */     }
/*  83 */     appendTo(this.tag, this.privateCreator, this.valueIndex, "\"]/Value[@number=\"", "\"]", sb);
/*     */     
/*  85 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private void appendTo(int tag, String privateCreator, int index, String valueOrItem, String suffix, StringBuilder sb) {
/*  90 */     sb.append("DicomAttribute[@tag=\"").append(TagUtils.toHexString(tag));
/*  91 */     if (privateCreator != null)
/*  92 */       sb.append("\" and @privateCreator=\"").append(privateCreator); 
/*  93 */     if (this.vrTag != null)
/*  94 */       sb.append("\" and @vr=\"").append(this.vrTag);
/*  95 */     sb.append(valueOrItem).append(index + 1).append(suffix);
/*     */   }
/*     */   
/*     */   public static ValueSelector valueOf(String s) {
/*  99 */     int fromIndex = s.lastIndexOf("DicomAttribute");
/*     */     try {
/* 101 */       return new ValueSelector(selectPrivateCreator(s, fromIndex), selectTag(s, fromIndex), selectVR(s, fromIndex), selectNumber(s, fromIndex) - 1, itemPointersOf(s, fromIndex));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 107 */     catch (Exception e) {
/* 108 */       throw new IllegalArgumentException(s);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int selectTag(String s, int fromIndex) {
/* 113 */     String tagStr = select("@tag=", s, fromIndex);
/* 114 */     return Integer.parseInt(tagStr, 16);
/*     */   }
/*     */   
/*     */   private static String selectPrivateCreator(String s, int fromIndex) {
/* 118 */     return select("@privateCreator=", s, fromIndex);
/*     */   }
/*     */   
/*     */   private static int selectNumber(String s, int fromIndex) {
/* 122 */     String no = select("@number=", s, fromIndex);
/* 123 */     return Integer.parseInt(no);
/*     */   }
/*     */   
/*     */   private static VR selectVR(String s, int fromIndex) {
/* 127 */     String vrStr = select("@vr=", s, fromIndex);
/* 128 */     return (vrStr != null) ? VR.valueOf(vrStr) : null;
/*     */   }
/*     */   
/*     */   private static ItemPointer[] itemPointersOf(String s, int endIndex) {
/* 132 */     if (endIndex == 0) {
/* 133 */       return NO_ITEMPOINTERS;
/*     */     }
/* 135 */     ArrayList<ItemPointer> list = new ArrayList<ItemPointer>();
/* 136 */     int fromIndex = 0;
/* 137 */     while (fromIndex < endIndex) {
/* 138 */       list.add(new ItemPointer(selectPrivateCreator(s, fromIndex), selectTag(s, fromIndex), selectNumber(s, fromIndex) - 1));
/*     */ 
/*     */ 
/*     */       
/* 142 */       fromIndex = s.indexOf("DicomAttribute", fromIndex + 43);
/*     */     } 
/*     */     
/* 145 */     return list.<ItemPointer>toArray(new ItemPointer[list.size()]);
/*     */   }
/*     */   
/*     */   private static String select(String key, String s, int fromIndex) {
/* 149 */     int pos = s.indexOf(key, fromIndex);
/* 150 */     if (pos < 0) {
/* 151 */       return null;
/*     */     }
/* 153 */     int quotePos = pos + key.length();
/* 154 */     int beginIndex = quotePos + 1;
/* 155 */     return s.substring(beginIndex, s.indexOf(s.charAt(quotePos), beginIndex));
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/ValueSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */