/*     */ package org.dcm4che3.data;
/*     */ 
/*     */

import org.dcm4che3.io.DicomEncodingOptions;
import org.dcm4che3.io.DicomOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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
/*     */ public class Fragments
/*     */   extends ArrayList<Object>
/*     */   implements Value
/*     */ {
/*     */   private static final long serialVersionUID = -6667210062541083610L;
/*     */   private final String privateCreator;
/*     */   private final int tag;
/*     */   private final VR vrTag;
/*     */   private final boolean bigEndian;
/*     */   
/*     */   public Fragments(String privateCreator, int tag, VR vrTag, boolean bigEndian, int initialCapacity) {
/*  62 */     super(initialCapacity);
/*  63 */     this.privateCreator = privateCreator;
/*  64 */     this.tag = tag;
/*  65 */     this.vrTag = vrTag;
/*  66 */     this.bigEndian = bigEndian;
/*     */   }
/*     */   
/*     */   public String privateCreator() {
/*  70 */     return this.privateCreator;
/*     */   }
/*     */   
/*     */   public final int tag() {
/*  74 */     return this.tag;
/*     */   }
/*     */   
/*     */   public final VR vr() {
/*  78 */     return this.vrTag;
/*     */   }
/*     */   
/*     */   public final boolean bigEndian() {
/*  82 */     return this.bigEndian;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  87 */     return "" + size() + " Fragments";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(Object frag) {
/*  92 */     add(size(), frag);
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(int index, Object frag) {
/*  98 */     super.add(index, (frag == null || (frag instanceof byte[] && ((byte[])frag).length == 0)) ? Value.NULL : frag);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends Object> c) {
/* 106 */     return addAll(size(), c);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(int index, Collection<? extends Object> c) {
/* 111 */     for (Object o : c)
/* 112 */       add(index++, o); 
/* 113 */     return !c.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeTo(DicomOutputStream out, VR vrTag) throws IOException {
/* 119 */     for (Object frag : this) {
/* 120 */       out.writeAttribute(-73728, vrTag, frag, null);
/*     */     }
/*     */   }
/*     */   
/*     */   public int calcLength(DicomEncodingOptions encOpts, boolean explicitVR, VR vrTag) {
/* 125 */     int len = 0;
/* 126 */     for (Object frag : this) {
/* 127 */       len += 8;
/* 128 */       if (frag instanceof Value) {
/* 129 */         len += ((Value)frag).calcLength(encOpts, explicitVR, vrTag); continue;
/*     */       } 
/* 131 */       len += ((byte[])frag).length + 1 & 0xFFFFFFFE;
/*     */     } 
/* 133 */     return len;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getEncodedLength(DicomEncodingOptions encOpts, boolean explicitVR, VR vrTag) {
/* 138 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] toBytes(VR vrTag, boolean bigEndian) throws IOException {
/* 143 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/Fragments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */