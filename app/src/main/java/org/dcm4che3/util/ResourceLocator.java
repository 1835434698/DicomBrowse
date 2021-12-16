/*    */ package org.dcm4che3.util;
/*    */ 
/*    */ import java.net.URL;

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
/*    */ 
/*    */ public class ResourceLocator
/*    */ {
/*    */   public static String resourceURL(String name) {
/* 53 */     ClassLoader tcl = Thread.currentThread().getContextClassLoader();
/* 54 */     URL url = tcl.getResource(name);
/* 55 */     return (url != null) ? url.toString() : null;
/*    */   }
/*    */   
/*    */   public static String getResource(String resource, Object source) {
/* 59 */     Class<?> c = (source == null) ? null : source.getClass();
/* 60 */     return getResource(resource, c);
/*    */   }
/*    */   
/*    */   public static String getResource(String resource, Class<?> c) {
/* 64 */     URL url = getResourceURL(resource, c);
/* 65 */     return (url != null) ? url.toString() : null;
/*    */   }
/*    */   
/*    */   public static URL getResourceURL(String resource, Object source) {
/* 69 */     Class<?> c = (source == null) ? null : source.getClass();
/* 70 */     return getResourceURL(resource, c);
/*    */   }
/*    */   
/*    */   public static URL getResourceURL(String resource, Class<?> c) {
/* 74 */     if (c != null) {
/* 75 */       ClassLoader classLoader1 = c.getClassLoader();
/* 76 */       if (classLoader1 != null) {
/* 77 */         return classLoader1.getResource(resource);
/*    */       }
/*    */     } 
/* 80 */     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
/* 81 */     if (classLoader != null) {
/* 82 */       return classLoader.getResource(resource);
/*    */     }
/* 84 */     return ClassLoader.getSystemResource(resource);
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/util/ResourceLocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */