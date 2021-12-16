/*    */ package org.dcm4che3.emf;
/*    */ 
/*    */
import org.dcm4che3.util.UIDUtils;

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
/*    */ public class HashUIDMapper
/*    */   implements UIDMapper
/*    */ {
/*    */   public String get(String uid) {
/* 52 */     return UIDUtils.createNameBasedUID(uid.getBytes());
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/emf/HashUIDMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */