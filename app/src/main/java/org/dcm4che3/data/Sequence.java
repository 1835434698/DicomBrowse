/*     */ package org.dcm4che3.data;
/*     */ 
/*     */

import org.dcm4che3.io.DicomEncodingOptions;
import org.dcm4che3.io.DicomOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

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
/*     */ public class Sequence
/*     */   extends ArrayList<Attributes>
/*     */   implements Value
/*     */ {
/*     */   private static final long serialVersionUID = 7062970085409148066L;
/*     */   private final Attributes parent;
/*     */   private final String privateCreator;
/*     */   private final int tag;
/*  61 */   private int length = -1;
/*     */   
/*     */   Sequence(Attributes parent, String privateCreator, int tag, int initialCapacity) {
/*  64 */     super(initialCapacity);
/*  65 */     this.parent = parent;
/*  66 */     this.privateCreator = privateCreator;
/*  67 */     this.tag = tag;
/*     */   }
/*     */   
/*     */   public final Attributes getParent() {
/*  71 */     return this.parent;
/*     */   }
/*     */   
/*     */   public void trimToSize(boolean recursive) {
/*  75 */     trimToSize();
/*  76 */     if (recursive)
/*  77 */       for (Attributes attrs : this) {
/*  78 */         attrs.trimToSize(recursive);
/*     */       } 
/*     */   }
/*     */   
/*     */   public int indexOf(Object o) {
/*  83 */     ListIterator<Attributes> it = listIterator();
/*  84 */     while (it.hasNext()) {
/*  85 */       if (it.next() == o)
/*  86 */         return it.previousIndex(); 
/*  87 */     }  return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(Attributes attrs) {
/*  92 */     return super.add(attrs.setParent(this.parent, this.privateCreator, this.tag));
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(int index, Attributes attrs) {
/*  97 */     super.add(index, attrs.setParent(this.parent, this.privateCreator, this.tag));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends Attributes> c) {
/* 102 */     setParent(c);
/* 103 */     return super.addAll(c);
/*     */   }
/*     */   
/*     */   private void setParent(Collection<? extends Attributes> c) {
/* 107 */     boolean bigEndian = this.parent.bigEndian();
/* 108 */     for (Attributes attrs : c) {
/* 109 */       if (attrs.bigEndian() != bigEndian) {
/* 110 */         throw new IllegalArgumentException("Endian of Item must match Endian of parent Data Set");
/*     */       }
/* 112 */       if (!attrs.isRoot()) {
/* 113 */         throw new IllegalArgumentException("Item already contained by Sequence");
/*     */       }
/*     */     } 
/* 116 */     for (Attributes attrs : c) {
/* 117 */       attrs.setParent(this.parent, this.privateCreator, this.tag);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean addAll(int index, Collection<? extends Attributes> c) {
/* 122 */     setParent(c);
/* 123 */     return super.addAll(index, c);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 128 */     for (Attributes attrs : this)
/* 129 */       attrs.setParent(null, null, 0); 
/* 130 */     super.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public Attributes remove(int index) {
/* 135 */     return ((Attributes)super.remove(index)).setParent(null, null, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object o) {
/* 140 */     if (o instanceof Attributes && super.remove(o)) {
/* 141 */       ((Attributes)o).setParent(null, null, 0);
/* 142 */       return true;
/*     */     } 
/* 144 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Attributes set(int index, Attributes attrs) {
/* 149 */     return super.set(index, attrs.setParent(this.parent, this.privateCreator, this.tag));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 154 */     return "" + size() + " Items";
/*     */   }
/*     */ 
/*     */   
/*     */   public int calcLength(DicomEncodingOptions encOpts, boolean explicitVR, VR vrTag) {
/* 159 */     int len = 0;
/* 160 */     for (Attributes item : this) {
/* 161 */       len += 8 + item.calcLength(encOpts, explicitVR);
/* 162 */       if (item.isEmpty() ? encOpts.undefEmptyItemLength : encOpts.undefItemLength)
/*     */       {
/* 164 */         len += 8; } 
/*     */     } 
/* 166 */     if (isEmpty() ? encOpts.undefEmptySequenceLength : encOpts.undefSequenceLength)
/*     */     {
/* 168 */       len += 8; } 
/* 169 */     this.length = len;
/* 170 */     return len;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getEncodedLength(DicomEncodingOptions encOpts, boolean explicitVR, VR vrTag) {
/* 175 */     if (isEmpty()) {
/* 176 */       return encOpts.undefEmptySequenceLength ? -1 : 0;
/*     */     }
/* 178 */     if (encOpts.undefSequenceLength) {
/* 179 */       return -1;
/*     */     }
/* 181 */     if (this.length == -1) {
/* 182 */       calcLength(encOpts, explicitVR, vrTag);
/*     */     }
/* 184 */     return this.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(DicomOutputStream out, VR vrTag) throws IOException {
/* 189 */     for (Attributes item : this) {
/* 190 */       item.writeItemTo(out);
/*     */     }
/*     */   }
/*     */   
/*     */   public byte[] toBytes(VR vrTag, boolean bigEndian) throws IOException {
/* 195 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/Sequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */