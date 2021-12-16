/*    */ package org.dcm4che3.data;
/*    */ 
/*    */ import java.io.Serializable;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemPointer
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 5183950023496022964L;
/*    */   public final int sequenceTag;
/*    */   public final String privateCreator;
/*    */   public final int itemIndex;
/*    */   
/*    */   public ItemPointer(int sequenceTag) {
/* 55 */     this(null, sequenceTag, 0);
/*    */   }
/*    */   
/*    */   public ItemPointer(int sequenceTag, int itemIndex) {
/* 59 */     this(null, sequenceTag, itemIndex);
/*    */   }
/*    */   
/*    */   public ItemPointer(String privateCreator, int sequenceTag) {
/* 63 */     this(privateCreator, sequenceTag, 0);
/*    */   }
/*    */   
/*    */   public ItemPointer(String privateCreator, int sequenceTag, int itemIndex) {
/* 67 */     this.sequenceTag = sequenceTag;
/* 68 */     this.privateCreator = privateCreator;
/* 69 */     this.itemIndex = itemIndex;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 74 */     if (this == o) return true; 
/* 75 */     if (o == null || getClass() != o.getClass()) return false;
/*    */     
/* 77 */     ItemPointer that = (ItemPointer)o;
/*    */     
/* 79 */     if (this.itemIndex != that.itemIndex) return false; 
/* 80 */     if (this.sequenceTag != that.sequenceTag) return false; 
/* 81 */     if ((this.privateCreator != null) ? !this.privateCreator.equals(that.privateCreator) : (that.privateCreator != null)) {
/* 82 */       return false;
/*    */     }
/* 84 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 89 */     int result = this.sequenceTag;
/* 90 */     result = 31 * result + ((this.privateCreator != null) ? this.privateCreator.hashCode() : 0);
/* 91 */     result = 31 * result + this.itemIndex;
/* 92 */     return result;
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/ItemPointer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */