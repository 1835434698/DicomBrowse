/*    */ package org.dcm4che3.io;
/*    */ 
/*    */

import org.dcm4che3.data.Attributes;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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
/*    */ public class SAXReader
/*    */ {
/*    */   public static Attributes parse(String uri, Attributes attrs) throws ParserConfigurationException, SAXException, IOException {
/* 57 */     if (attrs == null)
/* 58 */       attrs = new Attributes(); 
/* 59 */     SAXParserFactory f = SAXParserFactory.newInstance();
/* 60 */     SAXParser parser = f.newSAXParser();
/* 61 */     parser.parse(uri, new ContentHandlerAdapter(attrs));
/* 62 */     return attrs;
/*    */   }
/*    */ 
/*    */   
/*    */   public static Attributes parse(InputStream is, Attributes attrs) throws ParserConfigurationException, SAXException, IOException {
/* 67 */     if (attrs == null)
/* 68 */       attrs = new Attributes(); 
/* 69 */     SAXParserFactory f = SAXParserFactory.newInstance();
/* 70 */     SAXParser parser = f.newSAXParser();
/* 71 */     parser.parse(is, new ContentHandlerAdapter(attrs));
/* 72 */     return attrs;
/*    */   }
/*    */ 
/*    */   
/*    */   public static Attributes parse(String uri) throws ParserConfigurationException, SAXException, IOException {
/* 77 */     return parse(uri, (Attributes)null);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Attributes parse(InputStream is) throws ParserConfigurationException, SAXException, IOException {
/* 82 */     return parse(is, (Attributes)null);
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/io/SAXReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */