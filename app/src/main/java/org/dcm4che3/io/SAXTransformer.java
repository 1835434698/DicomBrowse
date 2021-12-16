/*     */ package org.dcm4che3.io;
/*     */ 
/*     */

import org.dcm4che3.data.Attributes;
import org.xml.sax.SAXException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;

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
/*     */ public abstract class SAXTransformer
/*     */ {
/*  58 */   private static SAXTransformerFactory factory = (SAXTransformerFactory)TransformerFactory.newInstance();
/*     */ 
/*     */ 
/*     */   
/*     */   public static SAXWriter getSAXWriter(Templates templates, Attributes result) throws TransformerConfigurationException {
/*  63 */     return getSAXWriter(templates, result, (SetupTransformer)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static SAXWriter getSAXWriter(Templates templates, Attributes result, SetupTransformer setup) throws TransformerConfigurationException {
/*  69 */     return getSAXWriter(templates, new SAXResult(new ContentHandlerAdapter(result)), setup);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SAXWriter getSAXWriter(Templates templates, Result result) throws TransformerConfigurationException {
/*  76 */     return getSAXWriter(templates, result, (SetupTransformer)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static SAXWriter getSAXWriter(Templates templates, Result result, SetupTransformer setup) throws TransformerConfigurationException {
/*  82 */     return getSAXWriter(factory.newTransformerHandler(templates), result, setup);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SAXWriter getSAXWriter(Result result) throws TransformerConfigurationException {
/*  89 */     return getSAXWriter(result, (SetupTransformer)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static SAXWriter getSAXWriter(Result result, SetupTransformer setup) throws TransformerConfigurationException {
/*  94 */     return getSAXWriter(factory.newTransformerHandler(), result, setup);
/*     */   }
/*     */ 
/*     */   
/*     */   private static SAXWriter getSAXWriter(TransformerHandler th, Result result, SetupTransformer setup) {
/*  99 */     th.setResult(result);
/* 100 */     if (setup != null)
/* 101 */       setup.setup(th.getTransformer()); 
/* 102 */     return new SAXWriter(th);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Attributes transform(Attributes ds, Templates templates, boolean includeNameSpaceDeclaration, boolean includeKeword) throws SAXException, TransformerConfigurationException {
/* 108 */     return transform(ds, templates, includeNameSpaceDeclaration, includeKeword, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Attributes transform(Attributes ds, Templates templates, boolean includeNameSpaceDeclaration, boolean includeKeword, SetupTransformer setup) throws SAXException, TransformerConfigurationException {
/* 116 */     Attributes modify = new Attributes();
/* 117 */     SAXWriter w = getSAXWriter(templates, modify, setup);
/*     */     
/* 119 */     w.setIncludeNamespaceDeclaration(includeNameSpaceDeclaration);
/* 120 */     w.setIncludeKeyword(includeKeword);
/* 121 */     w.write(ds);
/* 122 */     return modify;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Templates newTemplates(Source source) throws TransformerConfigurationException {
/* 127 */     return factory.newTemplates(source);
/*     */   }
/*     */   
/*     */   public static interface SetupTransformer {
/*     */     void setup(Transformer param1Transformer);
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/io/SAXTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */