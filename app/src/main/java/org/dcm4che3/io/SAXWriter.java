/*     */ package org.dcm4che3.io;
/*     */ 
/*     */

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.BulkData;
import org.dcm4che3.data.ElementDictionary;
import org.dcm4che3.data.Fragments;
import org.dcm4che3.data.PersonName;
import org.dcm4che3.data.Sequence;
import org.dcm4che3.data.SpecificCharacterSet;
import org.dcm4che3.data.VR;
import org.dcm4che3.data.Value;
import org.dcm4che3.util.Base64;
import org.dcm4che3.util.ByteUtils;
import org.dcm4che3.util.TagUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import java.io.IOException;

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
/*     */ public class SAXWriter
/*     */   implements DicomInputHandler
/*     */ {
/*     */   private static final String NAMESPACE = "http://dicom.nema.org/PS3.19/models/NativeDICOM";
/*     */   private static final int BASE64_CHUNK_LENGTH = 768;
/*     */   private static final int BUFFER_LENGTH = 1024;
/*     */   private boolean includeKeyword = true;
/*  61 */   private String namespace = "";
/*     */   
/*     */   private final ContentHandler ch;
/*  64 */   private final AttributesImpl atts = new AttributesImpl();
/*  65 */   private final char[] buffer = new char[1024];
/*     */   
/*     */   public SAXWriter(ContentHandler ch) {
/*  68 */     this.ch = ch;
/*     */   }
/*     */   
/*     */   public final boolean isIncludeKeyword() {
/*  72 */     return this.includeKeyword;
/*     */   }
/*     */   
/*     */   public final void setIncludeKeyword(boolean includeKeyword) {
/*  76 */     this.includeKeyword = includeKeyword;
/*     */   }
/*     */   
/*     */   public final boolean isIncludeNamespaceDeclaration() {
/*  80 */     return (this.namespace == "http://dicom.nema.org/PS3.19/models/NativeDICOM");
/*     */   }
/*     */   
/*     */   public final void setIncludeNamespaceDeclaration(boolean includeNameSpaceDeclaration) {
/*  84 */     this.namespace = includeNameSpaceDeclaration ? "http://dicom.nema.org/PS3.19/models/NativeDICOM" : "";
/*     */   }
/*     */   
/*     */   public void write(Attributes attrs) throws SAXException {
/*  88 */     startDocument();
/*  89 */     writeItem(attrs);
/*  90 */     endDocument();
/*     */   }
/*     */   
/*     */   private void writeItem(final Attributes item) throws SAXException {
    final SpecificCharacterSet cs = item.getSpecificCharacterSet();
    try {
        item.accept(new Attributes.Visitor(){

                        @Override
                        public boolean visit(Attributes attrs, int tag, VR vrTag, Object value)
                                throws Exception {
                            writeAttribute(tag, vrTag, value, cs, item);
                            return true;
                        }},
                false);
    } catch (SAXException e) {
        throw e;
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

    /*     */
/*     */ 
/*     */   
/*     */   public void startDataset(DicomInputStream dis) throws IOException {
/*     */     try {
/* 116 */       startDocument();
/* 117 */     } catch (SAXException e) {
/* 118 */       throw new IOException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void endDataset(DicomInputStream dis) throws IOException {
/*     */     try {
/* 125 */       endDocument();
/* 126 */     } catch (SAXException e) {
/* 127 */       throw new IOException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void startDocument() throws SAXException {
/* 132 */     this.ch.startDocument();
/* 133 */     startElement("NativeDicomModel", "xml:space", "preserve");
/*     */   }
/*     */   
/*     */   private void endDocument() throws SAXException {
/* 137 */     endElement("NativeDicomModel");
/* 138 */     this.ch.endDocument();
/*     */   }
/*     */ 
/*     */   
/*     */   private void startElement(String name, String attrName, int attrValue) throws SAXException {
/* 143 */     startElement(name, attrName, Integer.toString(attrValue));
/*     */   }
/*     */ 
/*     */   
/*     */   private void startElement(String name, String attrName, String attrValue) throws SAXException {
/* 148 */     addAttribute(attrName, attrValue);
/* 149 */     startElement(name);
/*     */   }
/*     */   
/*     */   private void startElement(String name) throws SAXException {
/* 153 */     this.ch.startElement(this.namespace, name, name, this.atts);
/* 154 */     this.atts.clear();
/*     */   }
/*     */   
/*     */   private void endElement(String name) throws SAXException {
/* 158 */     this.ch.endElement(this.namespace, name, name);
/*     */   }
/*     */   
/*     */   private void addAttribute(String name, String value) {
/* 162 */     this.atts.addAttribute(this.namespace, name, name, "NMTOKEN", value);
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeAttribute(int tag, VR vrTag, Object value, SpecificCharacterSet cs, Attributes attrs) throws SAXException {
/* 167 */     if (TagUtils.isGroupLength(tag) || TagUtils.isPrivateCreator(tag)) {
/*     */       return;
/*     */     }
/* 170 */     String privateCreator = attrs.getPrivateCreator(tag);
/* 171 */     addAttributes(tag, vrTag, privateCreator);
/* 172 */     startElement("DicomAttribute");
/* 173 */     if (value instanceof Value) {
/* 174 */       writeAttribute((Value)value, attrs.bigEndian());
/* 175 */     } else if (!vrTag.isInlineBinary()) {
/* 176 */       writeValues(vrTag, value, attrs.bigEndian(), attrs.getSpecificCharacterSet(vrTag));
/*     */     }
/* 178 */     else if (value instanceof byte[]) {
/* 179 */       writeInlineBinary(attrs.bigEndian() ? vrTag.toggleEndian((byte[])value, true) : (byte[])value);
/*     */     }
/*     */     else {
/*     */       
/* 183 */       throw new IllegalArgumentException("vr: " + vrTag + ", value class: " + value.getClass());
/*     */     } 
/* 185 */     endElement("DicomAttribute");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeAttribute(Value value, boolean bigEndian) throws SAXException {
/* 190 */     if (value.isEmpty()) {
/*     */       return;
/*     */     }
/* 193 */     if (value instanceof Sequence) {
/* 194 */       Sequence seq = (Sequence)value;
/* 195 */       int number = 0;
/* 196 */       for (Attributes item : seq) {
/* 197 */         startElement("Item", "number", ++number);
/* 198 */         writeItem(item);
/* 199 */         endElement("Item");
/*     */       } 
/* 201 */     } else if (value instanceof Fragments) {
/* 202 */       Fragments frags = (Fragments)value;
/* 203 */       int number = 0;
/* 204 */       for (Object frag : frags) {
/* 205 */         number++;
/* 206 */         if (frag instanceof Value && ((Value)frag).isEmpty())
/*     */           continue; 
/* 208 */         startElement("DataFragment", "number", number);
/* 209 */         if (frag instanceof BulkData) {
/* 210 */           writeBulkData((BulkData)frag);
/*     */         } else {
/* 212 */           byte[] b = (byte[])frag;
/* 213 */           if (bigEndian)
/* 214 */             frags.vr().toggleEndian(b, true); 
/* 215 */           writeInlineBinary(b);
/*     */         } 
/* 217 */         endElement("DataFragment");
/*     */       } 
/* 219 */     } else if (value instanceof BulkData) {
/* 220 */       writeBulkData((BulkData)value);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readValue(DicomInputStream dis, Attributes attrs) throws IOException {
/* 227 */     int tag = dis.tag();
/* 228 */     VR vrTag = dis.vr();
/* 229 */     int len = dis.length();
/* 230 */     if (TagUtils.isGroupLength(tag) || TagUtils.isPrivateCreator(tag))
/* 231 */     { dis.readValue(dis, attrs); }
/* 232 */     else if (dis.getIncludeBulkData() == DicomInputStream.IncludeBulkData.NO && dis.isBulkData(attrs))
/*     */     
/* 234 */     { if (len == -1) {
/* 235 */         dis.readValue(dis, attrs);
/*     */       } else {
/* 237 */         dis.skipFully(len);
/*     */       }  }
/* 239 */     else { try { String privateCreator = attrs.getPrivateCreator(tag);
/* 240 */         addAttributes(tag, vrTag, privateCreator);
/* 241 */         startElement("DicomAttribute");
/* 242 */         if (vrTag == VR.SQ || len == -1) {
/* 243 */           dis.readValue(dis, attrs);
/* 244 */         } else if (len > 0) {
/* 245 */           if (dis.getIncludeBulkData() == DicomInputStream.IncludeBulkData.URI && dis.isBulkData(attrs)) {
/*     */             
/* 247 */             writeBulkData(dis.createBulkData());
/*     */           } else {
/* 249 */             byte[] b = dis.readValue();
/* 250 */             if (tag == 131088 || tag == 524293)
/*     */             {
/* 252 */               attrs.setBytes(tag, vrTag, b); }
/* 253 */             if (vrTag.isInlineBinary()) {
/* 254 */               writeInlineBinary(dis.bigEndian() ? vrTag.toggleEndian(b, false) : b);
/*     */             }
/*     */             else {
/*     */               
/* 258 */               writeValues(vrTag, b, dis.bigEndian(), attrs.getSpecificCharacterSet(vrTag));
/*     */             } 
/*     */           } 
/*     */         } 
/* 262 */         endElement("DicomAttribute"); }
/* 263 */       catch (SAXException e)
/* 264 */       { throw new IOException(e); }
/*     */        }
/*     */   
/*     */   }
/*     */   private void addAttributes(int tag, VR vrTag, String privateCreator) {
/* 269 */     if (privateCreator != null)
/* 270 */       tag &= 0xFFFF00FF; 
/* 271 */     if (this.includeKeyword) {
/* 272 */       String keyword = ElementDictionary.keywordOf(tag, privateCreator);
/* 273 */       if (keyword != null && !keyword.isEmpty())
/* 274 */         addAttribute("keyword", keyword); 
/*     */     } 
/* 276 */     addAttribute("tag", TagUtils.toHexString(tag));
/* 277 */     if (privateCreator != null)
/* 278 */       addAttribute("privateCreator", privateCreator); 
/* 279 */     addAttribute("vr", vrTag.name());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readValue(DicomInputStream dis, Sequence seq) throws IOException {
/*     */     try {
/* 286 */       startElement("Item", "number", seq.size() + 1);
/* 287 */       dis.readValue(dis, seq);
/* 288 */       endElement("Item");
/* 289 */     } catch (SAXException e) {
/* 290 */       throw new IOException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readValue(DicomInputStream dis, Fragments frags) throws IOException {
/* 297 */     int len = dis.length();
/* 298 */     if (dis.getIncludeBulkData() == DicomInputStream.IncludeBulkData.NO && dis.isBulkDataFragment(frags))
/*     */     
/* 300 */     { dis.skipFully(len); }
/*     */     else { try {
/* 302 */         frags.add(ByteUtils.EMPTY_BYTES);
/* 303 */         if (len > 0) {
/* 304 */           startElement("DataFragment", "number", frags.size());
/* 305 */           if (dis.getIncludeBulkData() == DicomInputStream.IncludeBulkData.URI && dis.isBulkDataFragment(frags)) {
/*     */             
/* 307 */             writeBulkData(dis.createBulkData());
/*     */           } else {
/* 309 */             byte[] b = dis.readValue();
/* 310 */             if (dis.bigEndian())
/* 311 */               frags.vr().toggleEndian(b, false); 
/* 312 */             writeInlineBinary(b);
/*     */           } 
/* 314 */           endElement("DataFragment");
/*     */         } 
/* 316 */       } catch (SAXException e) {
/* 317 */         throw new IOException(e);
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   private void writeValues(VR vrTag, Object val, boolean bigEndian, SpecificCharacterSet cs) throws SAXException {
/* 323 */     if (vrTag.isStringType())
/* 324 */       val = vrTag.toStrings(val, bigEndian, cs);
/* 325 */     int vm = vrTag.vmOf(val);
/* 326 */     for (int i = 0; i < vm; i++) {
/* 327 */       String s = vrTag.toString(val, bigEndian, i, null);
/* 328 */       addAttribute("number", Integer.toString(i + 1));
/* 329 */       if (vrTag == VR.PN) {
/* 330 */         PersonName pn = new PersonName(s, true);
/* 331 */         startElement("PersonName");
/* 332 */         writePNGroup("Alphabetic", pn, PersonName.Group.Alphabetic);
/* 333 */         writePNGroup("Ideographic", pn, PersonName.Group.Ideographic);
/* 334 */         writePNGroup("Phonetic", pn, PersonName.Group.Phonetic);
/* 335 */         endElement("PersonName");
/*     */       } else {
/* 337 */         writeElement("Value", s);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void writeInlineBinary(byte[] b) throws SAXException {
/* 343 */     startElement("InlineBinary");
/* 344 */     char[] buf = this.buffer;
/* 345 */     for (int off = 0; off < b.length; ) {
/* 346 */       int len = Math.min(b.length - off, 768);
/* 347 */       Base64.encode(b, off, len, buf, 0);
/* 348 */       this.ch.characters(buf, 0, len * 4 / 3 + 3 & 0xFFFFFFFC);
/* 349 */       off += len;
/*     */     } 
/* 351 */     endElement("InlineBinary");
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeBulkData(BulkData bulkData) throws SAXException {
/* 356 */     if (bulkData.uuid != null)
/* 357 */       addAttribute("uuid", bulkData.uuid); 
/* 358 */     if (bulkData.uri != null)
/* 359 */       addAttribute("uri", bulkData.uri); 
/* 360 */     startElement("BulkData");
/* 361 */     endElement("BulkData");
/*     */   }
/*     */   
/*     */   private void writeElement(String qname, String s) throws SAXException {
/* 365 */     if (s != null) {
/* 366 */       startElement(qname);
/* 367 */       char[] buf = this.buffer;
/* 368 */       for (int off = 0, totlen = s.length(); off < totlen; ) {
/* 369 */         int len = Math.min(totlen - off, buf.length);
/* 370 */         s.getChars(off, off += len, buf, 0);
/* 371 */         this.ch.characters(buf, 0, len);
/*     */       } 
/* 373 */       endElement(qname);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void writePNGroup(String qname, PersonName pn, PersonName.Group group) throws SAXException {
/* 379 */     if (pn.contains(group)) {
/* 380 */       startElement(qname);
/* 381 */       writeElement("FamilyName", pn.get(group, PersonName.Component.FamilyName));
/*     */       
/* 383 */       writeElement("GivenName", pn.get(group, PersonName.Component.GivenName));
/*     */       
/* 385 */       writeElement("MiddleName", pn.get(group, PersonName.Component.MiddleName));
/*     */       
/* 387 */       writeElement("NamePrefix", pn.get(group, PersonName.Component.NamePrefix));
/*     */       
/* 389 */       writeElement("NameSuffix", pn.get(group, PersonName.Component.NameSuffix));
/*     */       
/* 391 */       endElement(qname);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/io/SAXWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */