/*    */ package org.dcm4che3.io;
/*    */ 
/*    */

import java.util.HashMap;

import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.stream.StreamSource;

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
/*    */ public class TemplatesCache
/*    */ {
/*    */   private static TemplatesCache defaultCache;
/* 54 */   private final HashMap<String, Templates> map = new HashMap<String, Templates>();
/*    */   
/*    */   public static synchronized TemplatesCache getDefault() {
/* 57 */     if (defaultCache == null) {
/* 58 */       defaultCache = new TemplatesCache();
/*    */     }
/* 60 */     return defaultCache;
/*    */   }
/*    */   
/*    */   public static synchronized void setDefault(TemplatesCache cache) {
/* 64 */     if (cache == null) {
/* 65 */       throw new NullPointerException();
/*    */     }
/* 67 */     defaultCache = cache;
/*    */   }
/*    */   
/*    */   public void clear() {
/* 71 */     this.map.clear();
/*    */   }
/*    */   
/*    */   public Templates get(String uri) throws TransformerConfigurationException {
/* 75 */     Templates tpl = this.map.get(uri);
/* 76 */     if (tpl == null)
/* 77 */       this.map.put(uri, tpl = SAXTransformer.newTemplates(new StreamSource(uri))); 
/* 78 */     return tpl;
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/io/TemplatesCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */