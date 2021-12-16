package org.dcm4che3.data;

import java.util.ServiceLoader;


public abstract class ElementDictionary
{
/*  44 */   private static final ServiceLoader<ElementDictionary> loader = ServiceLoader.load(ElementDictionary.class);
  
  private final String privateCreator;
  private final Class<?> tagClass;
  
  protected ElementDictionary(String privateCreator, Class<?> tagClass) {
/*  50 */     this.privateCreator = privateCreator;
/*  51 */     this.tagClass = tagClass;
  }
  
  public static ElementDictionary getStandardElementDictionary() {
/*  55 */     return StandardElementDictionary.INSTANCE;
  }

  
  public static ElementDictionary getElementDictionary(String privateCreator) {
/*  60 */     if (privateCreator != null)
/*  61 */       synchronized (loader) {
/*  62 */         for (ElementDictionary dict : loader) {
/*  63 */           if (privateCreator.equals(dict.getPrivateCreator()))
/*  64 */             return dict; 
        } 
/*  66 */       }   return getStandardElementDictionary();
  }
  
  public static void reload() {
/*  70 */     synchronized (loader) {
/*  71 */       loader.reload();
    } 
  }
  
  public static VR vrOf(int tag, String privateCreator) {
    return getElementDictionary(privateCreator).vrOf(tag);
  }
  
  public static String keywordOf(int tag, String privateCreator) {
/*  80 */     return getElementDictionary(privateCreator).keywordOf(tag);
  }
  
  public static int tagForKeyword(String keyword, String privateCreatorID) {
/*  84 */     return getElementDictionary(privateCreatorID).tagForKeyword(keyword);
  }
  
  public final String getPrivateCreator() {
/*  88 */     return this.privateCreator;
  }
  
  public Class<?> getTagClass() {
/*  92 */     return this.tagClass;
  }
  
  public abstract VR vrOf(int paramInt);
  
  public abstract String keywordOf(int paramInt);
  
  public int tmTagOf(int daTag) {
/* 100 */     return 0;
  }
  
  public int daTagOf(int tmTag) {
/* 104 */     return 0;
  }
  
  public int tagForKeyword(String keyword) {
/* 108 */     if (this.tagClass != null)
      try {
/* 110 */         return this.tagClass.getField(keyword).getInt(null);
/* 111 */       } catch (Exception ignore) {} 
/* 112 */     return -1;
  }
}
