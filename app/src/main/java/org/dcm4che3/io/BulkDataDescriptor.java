/*    */ package org.dcm4che3.io;
/*    */ 
/*    */

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.ItemPointer;
import org.dcm4che3.data.VR;
import org.dcm4che3.util.TagUtils;

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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BulkDataDescriptor
/*    */ {
/* 54 */   public static final BulkDataDescriptor DEFAULT = new BulkDataDescriptor()
/*    */     {
/*    */       
/*    */       public boolean isBulkData(String privateCreator, int tag, VR vrTag, int length, ItemPointer... itemPointer)
/*    */       {
/* 59 */         switch (TagUtils.normalizeRepeatingGroup(tag)) {
/*    */           case 2654176:
/*    */           case 4325393:
/*    */           case 1342185484:
/*    */           case 1342189568:
/*    */           case 1442840608:
/*    */           case 1610625024:
/*    */           case 2145386512:
/* 67 */             return (itemPointer.length == 0);
/*    */           case 1409290256:
/* 69 */             return (itemPointer.length == 1 && (itemPointer[0]).sequenceTag == 1409286400);
/*    */         } 
/*    */         
/* 72 */         return false;
/*    */       }
/*    */     };
/*    */   
/* 76 */   public static final BulkDataDescriptor PIXELDATA = new BulkDataDescriptor()
/*    */     {
/*    */       
/*    */       public boolean isBulkData(String privateCreator, int tag, VR vrTag, int length, ItemPointer... itemPointer)
/*    */       {
/* 81 */         return (tag == 2145386512);
/*    */       }
/*    */     };
/*    */   
/*    */   public static BulkDataDescriptor valueOf(final Attributes blkAttrs) {
/* 86 */     return new BulkDataDescriptor()
/*    */       {
/*    */         
/*    */         public boolean isBulkData(String privateCreator, int tag, VR vrTag, int length, ItemPointer... itemPointer)
/*    */         {
/* 91 */           Attributes item = blkAttrs;
/* 92 */           for (ItemPointer ip : itemPointer) {
/* 93 */             item = item.getNestedDataset(ip.privateCreator, ip.sequenceTag, ip.itemIndex);
/*    */           }
/*    */           
/* 96 */           return (item != null && item.contains(privateCreator, tag));
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public abstract boolean isBulkData(String paramString, int paramInt1, VR paramVRTag, int paramInt2, ItemPointer... paramVarArgs);
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/io/BulkDataDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */