/*    */ package org.dcm4che3.data;
/*    */ 
/*    */

import java.io.IOException;
import java.util.HashMap;

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
/*    */ public class IODCache
/*    */ {
/* 51 */   private final HashMap<String, IOD> map = new HashMap<String, IOD>();
/*    */   
/*    */   public void clear() {
/* 54 */     this.map.clear();
/*    */   }
/*    */   
/*    */   public IOD get(String uri) throws IOException {
/* 58 */     IOD iod = this.map.get(uri);
/* 59 */     if (iod == null)
/* 60 */       this.map.put(uri, iod = IOD.load(uri)); 
/* 61 */     return iod;
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/IODCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */