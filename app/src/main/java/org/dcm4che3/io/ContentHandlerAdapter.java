/*     */ package org.dcm4che3.io;
/*     */ 
/*     */

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.BulkData;
import org.dcm4che3.data.ElementDictionary;
import org.dcm4che3.data.Fragments;
import org.dcm4che3.data.PersonName;
import org.dcm4che3.data.Sequence;
import org.dcm4che3.data.VR;
import org.dcm4che3.util.Base64;
import org.dcm4che3.util.ByteUtils;
import org.dcm4che3.util.TagUtils;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

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
/*     */ public class ContentHandlerAdapter
/*     */   extends DefaultHandler
/*     */ {
/*     */   private Attributes fmi;
/*     */   private final boolean bigEndian;
/*  60 */   private final LinkedList<Attributes> items = new LinkedList<Attributes>();
/*  61 */   private final LinkedList<Sequence> seqs = new LinkedList<Sequence>();
/*     */   
/*  63 */   private final ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
/*  64 */   private final char[] carry = new char[4];
/*     */   private int carryLen;
/*  66 */   private final StringBuilder sb = new StringBuilder(64);
/*  67 */   private final ArrayList<String> values = new ArrayList<String>();
/*     */   private PersonName pn;
/*     */   private PersonName.Group pnGroup;
/*     */   private int tag;
/*     */   private String privateCreator;
/*     */   private VR vrTag;
/*     */   private BulkData bulkData;
/*     */   private Fragments dataFragments;
/*     */   private boolean processCharacters;
/*     */   private boolean inlineBinary;
/*     */   
/*     */   public ContentHandlerAdapter(Attributes attrs) {
/*  79 */     if (attrs == null)
/*  80 */       throw new NullPointerException(); 
/*  81 */     this.items.add(attrs);
/*  82 */     this.bigEndian = attrs.bigEndian();
/*     */   }
/*     */   
/*     */   public Attributes getFileMetaInformation() {
/*  86 */     return this.fmi;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes atts) throws SAXException {
/*  92 */     switch (qName.charAt(0)) {
/*     */       case 'A':
/*  94 */         if (qName.equals("Alphabetic"))
/*  95 */           startPNGroup(PersonName.Group.Alphabetic); 
/*     */         break;
/*     */       case 'B':
/*  98 */         if (qName.equals("BulkData"))
/*  99 */           bulkData(atts.getValue("uuid"), atts.getValue("uri")); 
/*     */         break;
/*     */       case 'D':
/* 102 */         if (qName.equals("DicomAttribute")) {
/* 103 */           startDicomAttribute((int)Long.parseLong(atts.getValue("tag"), 16), atts.getValue("privateCreator"), atts.getValue("vr"));
/*     */           
/*     */           break;
/*     */         } 
/* 107 */         if (qName.equals("DataFragment"))
/* 108 */           startDataFragment(Integer.parseInt(atts.getValue("number"))); 
/*     */         break;
/*     */       case 'F':
/* 111 */         if (qName.equals("FamilyName"))
/* 112 */           startText(); 
/*     */         break;
/*     */       case 'G':
/* 115 */         if (qName.equals("GivenName"))
/* 116 */           startText(); 
/*     */         break;
/*     */       case 'I':
/* 119 */         if (qName.equals("Item")) {
/* 120 */           startItem(Integer.parseInt(atts.getValue("number"))); break;
/* 121 */         }  if (qName.equals("InlineBinary")) {
/* 122 */           startInlineBinary(); break;
/* 123 */         }  if (qName.equals("Ideographic"))
/* 124 */           startPNGroup(PersonName.Group.Ideographic); 
/*     */         break;
/*     */       case 'L':
/* 127 */         if (qName.equals("Length"))
/* 128 */           startText(); 
/*     */         break;
/*     */       case 'M':
/* 131 */         if (qName.equals("MiddleName"))
/* 132 */           startText(); 
/*     */         break;
/*     */       case 'N':
/* 135 */         if (qName.equals("NamePrefix") || qName.equals("NameSuffix"))
/* 136 */           startText(); 
/*     */         break;
/*     */       case 'O':
/* 139 */         if (qName.equals("Offset"))
/* 140 */           startText(); 
/*     */         break;
/*     */       case 'P':
/* 143 */         if (qName.equals("PersonName")) {
/* 144 */           startPersonName(Integer.parseInt(atts.getValue("number"))); break;
/* 145 */         }  if (qName.equals("Phonetic"))
/* 146 */           startPNGroup(PersonName.Group.Phonetic); 
/*     */         break;
/*     */       case 'T':
/* 149 */         if (qName.equals("TransferSyntax"))
/* 150 */           startText(); 
/*     */         break;
/*     */       case 'U':
/* 153 */         if (qName.equals("URI"))
/* 154 */           startText(); 
/*     */         break;
/*     */       case 'V':
/* 157 */         if (qName.equals("Value")) {
/* 158 */           startValue(Integer.parseInt(atts.getValue("number")));
/* 159 */           startText();
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void bulkData(String uuid, String uri) {
/* 166 */     this.bulkData = new BulkData(uuid, uri, ((Attributes)this.items.getLast()).bigEndian());
/*     */   }
/*     */   
/*     */   private void startInlineBinary() {
/* 170 */     this.processCharacters = true;
/* 171 */     this.inlineBinary = true;
/* 172 */     this.bout.reset();
/*     */   }
/*     */   
/*     */   private void startText() {
/* 176 */     this.processCharacters = true;
/* 177 */     this.inlineBinary = false;
/* 178 */     this.sb.setLength(0);
/*     */   }
/*     */ 
/*     */   
/*     */   private void startDicomAttribute(int tag, String privateCreator, String vr) {
/* 183 */     this.tag = tag;
/* 184 */     this.privateCreator = privateCreator;
/* 185 */     this.vrTag = (vr != null) ? VR.valueOf(vr) : ElementDictionary.vrOf(tag, privateCreator);
/*     */     
/* 187 */     if (this.vrTag == VR.SQ)
/* 188 */       this.seqs.add(((Attributes)this.items.getLast()).newSequence(privateCreator, tag, 10)); 
/*     */   }
/*     */   
/*     */   private void startDataFragment(int number) {
/* 192 */     if (this.dataFragments == null) {
/* 193 */       this.dataFragments = ((Attributes)this.items.getLast()).newFragments(this.privateCreator, this.tag, this.vrTag, 10);
/*     */     }
/* 195 */     while (this.dataFragments.size() < number - 1)
/* 196 */       this.dataFragments.add(ByteUtils.EMPTY_BYTES); 
/*     */   }
/*     */   
/*     */   private void startItem(int number) {
/* 200 */     Sequence seq = this.seqs.getLast();
/* 201 */     while (seq.size() < number - 1)
/* 202 */       seq.add(new Attributes(0)); 
/* 203 */     Attributes item = new Attributes();
/* 204 */     seq.add(item);
/* 205 */     this.items.add(item);
/*     */   }
/*     */   
/*     */   private void startValue(int number) {
/* 209 */     while (this.values.size() < number - 1)
/* 210 */       this.values.add(null); 
/*     */   }
/*     */   
/*     */   private void startPersonName(int number) {
/* 214 */     startValue(number);
/* 215 */     this.pn = new PersonName();
/*     */   }
/*     */   
/*     */   private void startPNGroup(PersonName.Group pnGroup) {
/* 219 */     this.pnGroup = pnGroup;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void characters(char[] ch, int offset, int len) throws SAXException {
/* 225 */     if (this.processCharacters) {
/* 226 */       if (this.inlineBinary) {
/*     */         try {
/* 228 */           if (this.carryLen != 0) {
/* 229 */             int copy = 4 - this.carryLen;
/* 230 */             System.arraycopy(ch, offset, this.carry, this.carryLen, copy);
/* 231 */             Base64.decode(this.carry, 0, 4, this.bout);
/* 232 */             offset += copy;
/* 233 */             len -= copy;
/*     */           } 
/* 235 */           if ((this.carryLen = len & 0x3) != 0) {
/* 236 */             len -= this.carryLen;
/* 237 */             System.arraycopy(ch, offset + len, this.carry, 0, this.carryLen);
/*     */           } 
/* 239 */           Base64.decode(ch, offset, len, this.bout);
/* 240 */         } catch (IOException e) {
/* 241 */           throw new RuntimeException(e);
/*     */         } 
/*     */       } else {
/* 244 */         this.sb.append(ch, offset, len);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void endElement(String uri, String localName, String qName) throws SAXException {
/* 250 */     switch (qName.charAt(0)) {
/*     */       case 'D':
/* 252 */         if (qName.equals("DicomAttribute")) {
/* 253 */           endDicomAttribute(); break;
/* 254 */         }  if (qName.equals("DataFragment"))
/* 255 */           endDataFragment(); 
/*     */         break;
/*     */       case 'F':
/* 258 */         if (qName.equals("FamilyName"))
/* 259 */           endPNComponent(PersonName.Component.FamilyName); 
/*     */         break;
/*     */       case 'G':
/* 262 */         if (qName.equals("GivenName"))
/* 263 */           endPNComponent(PersonName.Component.GivenName); 
/*     */         break;
/*     */       case 'I':
/* 266 */         if (qName.equals("Item"))
/* 267 */           endItem(); 
/*     */         break;
/*     */       case 'M':
/* 270 */         if (qName.equals("MiddleName"))
/* 271 */           endPNComponent(PersonName.Component.MiddleName); 
/*     */         break;
/*     */       case 'N':
/* 274 */         if (qName.equals("NamePrefix")) {
/* 275 */           endPNComponent(PersonName.Component.NamePrefix); break;
/* 276 */         }  if (qName.equals("NameSuffix"))
/* 277 */           endPNComponent(PersonName.Component.NameSuffix); 
/*     */         break;
/*     */       case 'P':
/* 280 */         if (qName.equals("PersonName"))
/* 281 */           endPersonName(); 
/*     */         break;
/*     */       case 'V':
/* 284 */         if (qName.equals("Value")) {
/* 285 */           endValue();
/*     */         }
/*     */         break;
/*     */     } 
/* 289 */     this.processCharacters = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void endDocument() throws SAXException {
/* 294 */     if (this.fmi != null)
/* 295 */       this.fmi.trimToSize(); 
/* 296 */     ((Attributes)this.items.getFirst()).trimToSize();
/*     */   }
/*     */   
/*     */   private void endDataFragment() {
/* 300 */     if (this.bulkData != null) {
/* 301 */       this.dataFragments.add(this.bulkData);
/* 302 */       this.bulkData = null;
/*     */     } else {
/* 304 */       this.dataFragments.add(getBytes());
/*     */     } 
/*     */   }
/*     */   
/*     */   private void endDicomAttribute() {
/* 309 */     if (this.vrTag == VR.SQ) {
/* 310 */       ((Sequence)this.seqs.removeLast()).trimToSize();
/*     */       return;
/*     */     } 
/* 313 */     if (this.dataFragments != null) {
/* 314 */       this.dataFragments.trimToSize();
/* 315 */       this.dataFragments = null;
/*     */       return;
/*     */     } 
/* 318 */     Attributes attrs = this.items.getLast();
/* 319 */     if (TagUtils.isFileMetaInformation(this.tag)) {
/* 320 */       if (this.fmi == null)
/* 321 */         this.fmi = new Attributes(); 
/* 322 */       attrs = this.fmi;
/*     */     } 
/* 324 */     if (this.bulkData != null) {
/* 325 */       attrs.setValue(this.privateCreator, this.tag, this.vrTag, this.bulkData);
/* 326 */       this.bulkData = null;
/* 327 */     } else if (this.inlineBinary) {
/* 328 */       attrs.setBytes(this.privateCreator, this.tag, this.vrTag, getBytes());
/*     */     } else {
/* 330 */       attrs.setString(this.privateCreator, this.tag, this.vrTag, getStrings());
/*     */     } 
/*     */   }
/*     */   
/*     */   private void endItem() {
/* 335 */     ((Attributes)this.items.removeLast()).trimToSize();
/* 336 */     this.vrTag = VR.SQ;
/*     */   }
/*     */   
/*     */   private void endPersonName() {
/* 340 */     this.values.add(this.pn.toString());
/* 341 */     this.pn = null;
/*     */   }
/*     */   
/*     */   private void endValue() {
/* 345 */     this.values.add(getString());
/*     */   }
/*     */   
/*     */   private void endPNComponent(PersonName.Component pnComp) {
/* 349 */     this.pn.set(this.pnGroup, pnComp, getString());
/*     */   }
/*     */   
/*     */   private String getString() {
/* 353 */     return this.sb.toString();
/*     */   }
/*     */   
/*     */   private byte[] getBytes() {
/* 357 */     byte[] b = this.bout.toByteArray();
/* 358 */     return this.bigEndian ? this.vrTag.toggleEndian(b, false) : b;
/*     */   }
/*     */   
/*     */   private String[] getStrings() {
/*     */     try {
/* 363 */       return this.values.<String>toArray(new String[this.values.size()]);
/*     */     } finally {
/* 365 */       this.values.clear();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/io/ContentHandlerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */