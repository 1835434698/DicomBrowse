/*     */ package org.dcm4che3.data;
/*     */ 
/*     */

import org.dcm4che3.util.ByteUtils;
import org.dcm4che3.util.ResourceLocator;
import org.dcm4che3.util.StringUtils;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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
/*     */ public class IOD
/*     */   extends ArrayList<IOD.DataElement>
/*     */ {
/*     */   private static final long serialVersionUID = -5065822488885801576L;
/*     */   private DataElementType type;
/*     */   private Condition condition;
/*     */   
/*     */   public enum DataElementType
/*     */   {
/*  66 */     TYPE_0, TYPE_1, TYPE_2, TYPE_3;
/*     */   }
/*     */   
/*     */   public static class DataElement
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = -7460474415381086525L;
/*     */     public final int tag;
/*     */     public final VR vr;
/*     */     public final DataElementType type;
/*     */     public final int minVM;
/*     */     public final int maxVM;
/*     */     public final int valueNumber;
/*     */     private Condition condition;
/*     */     private Object values;
/*  81 */     private int lineNumber = -1;
/*     */
/*     */
/*     */     public DataElement(int tag, VR vr, DataElementType type, int minVM, int maxVM, int valueNumber) {
/*  85 */       this.tag = tag;
/*  86 */       this.vr = vr;
/*  87 */       this.type = type;
/*  88 */       this.minVM = minVM;
/*  89 */       this.maxVM = maxVM;
/*  90 */       this.valueNumber = valueNumber;
/*     */     }
/*     */
/*     */     public DataElement setCondition(Condition condition) {
/*  94 */       this.condition = condition;
/*  95 */       return this;
/*     */     }
/*     */
/*     */     public Condition getCondition() {
/*  99 */       return this.condition;
/*     */     }
/*     */
/*     */     public int getValueNumber() {
/* 103 */       return this.valueNumber;
/*     */     }
/*     */
/*     */     public DataElement setValues(String... values) {
/* 107 */       if (this.vr == VR.SQ)
/* 108 */         throw new IllegalStateException("vr=SQ");
/* 109 */       this.values = values;
/* 110 */       return this;
/*     */     }
/*     */
/*     */     public DataElement setValues(int... values) {
/* 114 */       if (!this.vr.isIntType())
/* 115 */         throw new IllegalStateException("vr=" + this.vr);
/* 116 */       this.values = values;
/* 117 */       return this;
/*     */     }
/*     */
/*     */     public DataElement setValues(Code... values) {
/* 121 */       if (this.vr != VR.SQ)
/* 122 */         throw new IllegalStateException("vr=" + this.vr);
/* 123 */       this.values = values;
/* 124 */       return this;
/*     */     }
/*     */
/*     */     public DataElement addItemIOD(IOD iod) {
/* 128 */       if (this.values == null) {
/* 129 */         this.values = new IOD[] { iod };
/*     */       } else {
/* 131 */         IOD[] iods = (IOD[])this.values;
/* 132 */         iods = Arrays.<IOD>copyOf(iods, iods.length + 1);
/* 133 */         iods[iods.length - 1] = iod;
/* 134 */         this.values = iods;
/*     */       }
/* 136 */       return this;
/*     */     }
/*     */
/*     */     public Object getValues() {
/* 140 */       return this.values;
/*     */     }
/*     */
/*     */     public int getLineNumber() {
/* 144 */       return this.lineNumber;
/*     */     }
/*     */
/*     */     public DataElement setLineNumber(int lineNumber) {
/* 148 */       this.lineNumber = lineNumber;
/* 149 */       return this;
/*     */     }
/*     */   }
/*     */
/*     */   public static abstract class Condition
/*     */   {
/*     */     protected String id;
/*     */     protected boolean not;
/*     */
/*     */     public Condition id(String id) {
/* 159 */       this.id = id;
/* 160 */       return this;
/*     */     }
/*     */
/*     */     public final String id() {
/* 164 */       return this.id;
/*     */     }
/*     */
/*     */     public final Condition not() {
/* 168 */       this.not = !this.not;
/* 169 */       return this;
/*     */     }
/*     */
/*     */     public abstract boolean match(Attributes param1Attributes);
/*     */
/*     */     public void addChild(Condition child) {
/* 175 */       throw new UnsupportedOperationException();
/*     */     }
/*     */
/*     */     public Condition trim() {
/* 179 */       return this;
/*     */     }
/*     */
/*     */     public boolean isEmpty() {
/* 183 */       return false;
/*     */     }
/*     */   }
/*     */
/*     */   static abstract class CompositeCondition
/*     */     extends Condition {
/* 189 */     protected final ArrayList<Condition> childs = new ArrayList<Condition>();
/*     */
/*     */
/*     */     public abstract boolean match(Attributes param1Attributes);
/*     */
/*     */     public void addChild(Condition child) {
/* 195 */       this.childs.add(child);
/*     */     }
/*     */
/*     */
/*     */     public Condition trim() {
/* 200 */       int size = this.childs.size();
/* 201 */       if (size == 1) {
/* 202 */         Condition child = ((Condition)this.childs.get(0)).id(this.id);
/* 203 */         return this.not ? child.not() : child;
/*     */       }
/* 205 */       this.childs.trimToSize();
/* 206 */       return this;
/*     */     }
/*     */
/*     */
/*     */     public boolean isEmpty() {
/* 211 */       return this.childs.isEmpty();
/*     */     }
/*     */   }
/*     */
/*     */   public static class And
/*     */     extends CompositeCondition {
/*     */     public boolean match(Attributes attrs) {
/* 218 */       for (Condition child : this.childs) {
/* 219 */         if (!child.match(attrs))
/* 220 */           return this.not;
/*     */       }
/* 222 */       return !this.not;
/*     */     }
/*     */   }
/*     */
/*     */   public static class Or
/*     */     extends CompositeCondition {
/*     */     public boolean match(Attributes attrs) {
/* 229 */       for (Condition child : this.childs) {
/* 230 */         if (child.match(attrs))
/* 231 */           return !this.not;
/*     */       }
/* 233 */       return this.not;
/*     */     }
/*     */   }
/*     */
/*     */   public static class Present extends Condition {
/*     */     protected final int tag;
/*     */     protected final int[] itemPath;
/*     */
/*     */     public Present(int tag, int... itemPath) {
/* 242 */       this.tag = tag;
/* 243 */       this.itemPath = itemPath;
/*     */     }
/*     */
/*     */     public boolean match(Attributes attrs) {
/* 247 */       return this.not ? (!item(attrs).containsValue(this.tag)) : item(attrs).containsValue(this.tag);
/*     */     }
/*     */
/*     */
/*     */     protected Attributes item(Attributes attrs) {
/* 252 */       for (int sqtag : this.itemPath) {
/* 253 */         if (sqtag == -1) {
/* 254 */           attrs = (sqtag == -1) ? attrs.getParent() : attrs.getNestedDataset(sqtag);
/*     */         }
/*     */       }
/*     */
/* 258 */       return attrs;
/*     */     }
/*     */   }
/*     */
/*     */   public static class MemberOf
/*     */     extends Present {
/*     */     private final VR vr;
/*     */     private final int valueIndex;
/*     */     private final boolean matchNotPresent;
/*     */     private Object values;
/*     */
/*     */     public MemberOf(int tag, VR vr, int valueIndex, boolean matchNotPresent, int... itemPath) {
/* 270 */       super(tag, itemPath);
/* 271 */       this.vr = vr;
/* 272 */       this.valueIndex = valueIndex;
/* 273 */       this.matchNotPresent = matchNotPresent;
/*     */     }
/*     */
/*     */     public VR vr() {
/* 277 */       return this.vr;
/*     */     }
/*     */
/*     */     public MemberOf setValues(String... values) {
/* 281 */       if (this.vr == VR.SQ)
/* 282 */         throw new IllegalStateException("vr=SQ");
/* 283 */       this.values = values;
/* 284 */       return this;
/*     */     }
/*     */
/*     */     public MemberOf setValues(int... values) {
/* 288 */       if (!this.vr.isIntType())
/* 289 */         throw new IllegalStateException("vr=" + this.vr);
/* 290 */       this.values = values;
/* 291 */       return this;
/*     */     }
/*     */
/*     */     public MemberOf setValues(Code... values) {
/* 295 */       if (this.vr != VR.SQ)
/* 296 */         throw new IllegalStateException("vr=" + this.vr);
/* 297 */       this.values = values;
/* 298 */       return this;
/*     */     }
/*     */
/*     */     public boolean match(Attributes attrs) {
/* 302 */       if (this.values == null)
/* 303 */         throw new IllegalStateException("values not initialized");
/* 304 */       Attributes item = item(attrs);
/* 305 */       if (item == null) {
/* 306 */         return this.matchNotPresent;
/*     */       }
/* 308 */       if (this.values instanceof int[]) {
/* 309 */         return this.not ? (!match(item, (int[])this.values)) : match(item, (int[])this.values);
/*     */       }
/* 311 */       if (this.values instanceof Code[]) {
/* 312 */         return this.not ? (!match(item, (Code[])this.values)) : match(item, (Code[])this.values);
/*     */       }
/*     */
/* 315 */       return this.not ? (!match(item, (String[])this.values)) : match(item, (String[])this.values);
/*     */     }
/*     */
/*     */
/*     */     private boolean match(Attributes item, String[] ss) {
/* 320 */       String val = item.getString(this.tag, this.valueIndex);
/* 321 */       if (val == null)
/* 322 */         return this.not ? (!this.matchNotPresent) : this.matchNotPresent;
/* 323 */       for (String s : ss) {
/* 324 */         if (s.equals(val))
/* 325 */           return !this.not;
/*     */       }
/* 327 */       return this.not;
/*     */     }
/*     */
/*     */     private boolean match(Attributes item, Code[] codes) {
/* 331 */       Sequence seq = item.getSequence(this.tag);
/* 332 */       if (seq != null)
/* 333 */         for (Attributes codeItem : seq) {
/*     */           try {
/* 335 */             Code val = new Code(codeItem);
/* 336 */             for (Code code : codes) {
/* 337 */               if (code.equals(val))
/* 338 */                 return !this.not;
/*     */             }
/* 340 */           } catch (NullPointerException npe) {}
/*     */         }
/* 342 */       return this.not;
/*     */     }
/*     */
/*     */     private boolean match(Attributes item, int[] is) {
/* 346 */       int val = item.getInt(this.tag, this.valueIndex, -2147483648);
/* 347 */       if (val == Integer.MIN_VALUE)
/* 348 */         return this.matchNotPresent;
/* 349 */       for (int i : is) {
/* 350 */         if (i == val)
/* 351 */           return true;
/*     */       }
/* 353 */       return false;
/*     */     }
/*     */   }
/*     */
/*     */
/*     */
/* 359 */   private int lineNumber = -1;
/*     */
/*     */   public void setType(DataElementType type) {
/* 362 */     this.type = type;
/*     */   }
/*     */
/*     */   public DataElementType getType() {
/* 366 */     return this.type;
/*     */   }
/*     */
/*     */   public void setCondition(Condition condition) {
/* 370 */     this.condition = condition;
/*     */   }
/*     */
/*     */   public Condition getCondition() {
/* 374 */     return this.condition;
/*     */   }
/*     */
/*     */   public int getLineNumber() {
/* 378 */     return this.lineNumber;
/*     */   }
/*     */
/*     */   public void setLineNumber(int lineNumber) {
/* 382 */     this.lineNumber = lineNumber;
/*     */   }
/*     */
/*     */   public void parse(String uri) throws IOException {
/*     */     try {
/* 387 */       SAXParserFactory f = SAXParserFactory.newInstance();
/* 388 */       SAXParser parser = f.newSAXParser();
/* 389 */       parser.parse(uri, new SAXHandler(this));
/* 390 */     } catch (SAXException e) {
/* 391 */       throw new IOException("Failed to parse " + uri, e);
/* 392 */     } catch (ParserConfigurationException e) {
/* 393 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */
/*     */   private static class SAXHandler
/*     */     extends DefaultHandler {
/* 399 */     private StringBuilder sb = new StringBuilder();
/*     */     private boolean processCharacters;
/*     */     private boolean elementConditions;
/*     */     private boolean itemConditions;
/*     */     private String idref;
/* 404 */     private List<String> values = new ArrayList<String>();
/* 405 */     private List<Code> codes = new ArrayList<Code>();
/* 406 */     private LinkedList<IOD> iodStack = new LinkedList<IOD>();
/* 407 */     private LinkedList<Condition> conditionStack = new LinkedList<Condition>();
/* 408 */     private Map<String, IOD> id2iod = new HashMap<String, IOD>();
/* 409 */     private Map<String, Condition> id2cond = new HashMap<String, Condition>();
/*     */     private Locator locator;
/*     */
/*     */     public SAXHandler(IOD iod) {
/* 413 */       this.iodStack.add(iod);
/*     */     }
/*     */
/*     */
/*     */     public void setDocumentLocator(Locator locator) {
/* 418 */       this.locator = locator;
/*     */     }
/*     */
/*     */
/*     */
/*     */     public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes atts) throws SAXException {
/* 424 */       switch (qName.charAt(0)) {
/*     */         case 'A':
/* 426 */           if (qName.equals("And"))
/* 427 */             startCondition(qName, new And());
/*     */           break;
/*     */         case 'C':
/* 430 */           if (qName.equals("Code")) {
/* 431 */             startCode(atts.getValue("codeValue"), atts.getValue("codingSchemeDesignator"), atts.getValue("codingSchemeVersion"), atts.getValue("codeMeaning"));
/*     */           }
/*     */
/*     */
/*     */
/*     */         case 'D':
/* 437 */           if (qName.equals("DataElement")) {
/* 438 */             startDataElement(atts.getValue("tag"), atts.getValue("vr"), atts.getValue("type"), atts.getValue("vm"), atts.getValue("items"), atts.getValue("valueNumber"));
/*     */           }
/*     */           break;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */         case 'I':
/* 447 */           if (qName.equals("If")) {
/* 448 */             startIf(atts.getValue("id"), atts.getValue("idref")); break;
/* 449 */           }  if (qName.equals("Item")) {
/* 450 */             startItem(atts.getValue("id"), atts.getValue("idref"), atts.getValue("type"));
/*     */           }
/*     */           break;
/*     */
/*     */         case 'M':
/* 455 */           if (qName.equals("MemberOf"))
/* 456 */             startCondition(qName, memberOf(atts));
/*     */           break;
/*     */         case 'N':
/* 459 */           if (qName.equals("NotAnd")) {
/* 460 */             startCondition(qName, (new And()).not()); break;
/* 461 */           }  if (qName.equals("NotMemberOf")) {
/* 462 */             startCondition(qName, memberOf(atts).not()); break;
/* 463 */           }  if (qName.equals("NotOr")) {
/* 464 */             startCondition(qName, (new Or()).not()); break;
/* 465 */           }  if (qName.equals("NotPresent"))
/* 466 */             startCondition(qName, present(atts).not());
/*     */           break;
/*     */         case 'O':
/* 469 */           if (qName.equals("Or"))
/* 470 */             startCondition(qName, new Or());
/*     */           break;
/*     */         case 'P':
/* 473 */           if (qName.equals("Present"))
/* 474 */             startCondition(qName, present(atts));
/*     */           break;
/*     */         case 'V':
/* 477 */           if (qName.equals("Value")) {
/* 478 */             startValue();
/*     */           }
/*     */           break;
/*     */       }
/*     */     }
/*     */
/*     */     private Present present(org.xml.sax.Attributes atts) throws SAXException {
/* 485 */       int[] tagPath = tagPathOf(atts.getValue("tag"));
/* 486 */       int lastIndex = tagPath.length - 1;
/* 487 */       return new Present(tagPath[lastIndex], (lastIndex > 0) ? Arrays.copyOf(tagPath, lastIndex) : ByteUtils.EMPTY_INTS);
/*     */     }
/*     */
/*     */
/*     */
/*     */
/*     */     private MemberOf memberOf(org.xml.sax.Attributes atts) throws SAXException {
/* 494 */       int[] tagPath = tagPathOf(atts.getValue("tag"));
/* 495 */       int lastIndex = tagPath.length - 1;
/* 496 */       return new MemberOf(tagPath[lastIndex], vrOf(atts.getValue("vr")), valueNumberOf(atts.getValue("valueNumber"), 1) - 1, matchNotPresentOf(atts.getValue("matchNotPresent")), (lastIndex > 0) ? Arrays.copyOf(tagPath, lastIndex) : ByteUtils.EMPTY_INTS);
/*     */     }
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
/*     */     private void startCode(String codeValue, String codingSchemeDesignator, String codingSchemeVersion, String codeMeaning) throws SAXException {
/* 509 */       if (codeValue == null)
/* 510 */         throw new SAXException("missing codeValue attribute");
/* 511 */       if (codingSchemeDesignator == null)
/* 512 */         throw new SAXException("missing codingSchemeDesignator attribute");
/* 513 */       if (codeMeaning == null)
/* 514 */         throw new SAXException("missing codeMeaning attribute");
/* 515 */       this.codes.add(new Code(codeValue, codingSchemeDesignator, codingSchemeVersion, codeMeaning));
/*     */     }
/*     */
/*     */
/*     */
/*     */
/*     */     public void endElement(String uri, String localName, String qName) throws SAXException {
/* 522 */       switch (qName.charAt(0)) {
/*     */         case 'A':
/* 524 */           if (qName.equals("And"))
/* 525 */             endCondition(qName);
/*     */           break;
/*     */         case 'D':
/* 528 */           if (qName.equals("DataElement"))
/* 529 */             endDataElement();
/*     */           break;
/*     */         case 'I':
/* 532 */           if (qName.equals("If")) {
/* 533 */             endCondition(qName); break;
/* 534 */           }  if (qName.equals("Item"))
/* 535 */             endItem();
/*     */           break;
/*     */         case 'M':
/* 538 */           if (qName.equals("MemberOf"))
/* 539 */             endCondition(qName);
/*     */           break;
/*     */         case 'N':
/* 542 */           if (qName.equals("NotAnd")) {
/* 543 */             endCondition(qName); break;
/* 544 */           }  if (qName.equals("NotMemberOf")) {
/* 545 */             endCondition(qName); break;
/* 546 */           }  if (qName.equals("NotOr")) {
/* 547 */             endCondition(qName); break;
/* 548 */           }  if (qName.equals("NotPresent"))
/* 549 */             endCondition(qName);
/*     */           break;
/*     */         case 'O':
/* 552 */           if (qName.equals("Or"))
/* 553 */             endCondition(qName);
/*     */           break;
/*     */         case 'P':
/* 556 */           if (qName.equals("Present"))
/* 557 */             endCondition(qName);
/*     */           break;
/*     */         case 'V':
/* 560 */           if (qName.equals("Value"))
/* 561 */             endValue();
/*     */           break;
/*     */       }
/* 564 */       this.processCharacters = false;
/* 565 */       this.idref = null;
/*     */     }
/*     */
/*     */
/*     */
/*     */     public void characters(char[] ch, int start, int length) throws SAXException {
/* 571 */       if (this.processCharacters) {
/* 572 */         this.sb.append(ch, start, length);
/*     */       }
/*     */     }
/*     */
/*     */
/*     */     private void startDataElement(String tagStr, String vrStr, String typeStr, String vmStr, String items, String valueNumberStr) throws SAXException {
/* 578 */       if (this.idref != null) {
/* 579 */         throw new SAXException("<Item> with idref must be empty");
/*     */       }
/* 581 */       IOD iod = this.iodStack.getLast();
/* 582 */       int tag = tagOf(tagStr);
/* 583 */       VR vr = vrOf(vrStr);
/* 584 */       DataElementType type = typeOf(typeStr);
/*     */
/* 586 */       int minVM = -1;
/* 587 */       int maxVM = -1;
/* 588 */       String vm = (vr == VR.SQ) ? items : vmStr;
/* 589 */       if (vm != null) {
/*     */         try {
/* 591 */           String[] ss = StringUtils.split(vm, '-');
/* 592 */           if (ss[0].charAt(0) != 'n') {
/* 593 */             minVM = Integer.parseInt(ss[0]);
/* 594 */             if (ss.length > 1) {
/* 595 */               if (ss[1].charAt(0) != 'n')
/* 596 */                 maxVM = Integer.parseInt(ss[1]);
/*     */             } else {
/* 598 */               maxVM = minVM;
/*     */             }
/*     */           }
/* 601 */         } catch (IllegalArgumentException e) {
/* 602 */           throw new SAXException(((vr == VR.SQ) ? "invalid items=\"" : "invalid vm=\"") + vm + '"');
/*     */         }
/*     */       }
/*     */
/*     */
/*     */
/* 608 */       DataElement el = new DataElement(tag, vr, type, minVM, maxVM, valueNumberOf(valueNumberStr, 0));
/*     */
/* 610 */       if (this.locator != null)
/* 611 */         el.setLineNumber(this.locator.getLineNumber());
/* 612 */       iod.add(el);
/* 613 */       this.elementConditions = true;
/* 614 */       this.itemConditions = false;
/*     */     }
/*     */
/*     */     private DataElementType typeOf(String s) throws SAXException {
/* 618 */       if (s == null)
/* 619 */         throw new SAXException("missing type attribute");
/*     */       try {
/* 621 */         return DataElementType.valueOf("TYPE_" + s);
/* 622 */       } catch (IllegalArgumentException e) {
/* 623 */         throw new SAXException("unrecognized type=\"" + s + '"');
/*     */       }
/*     */     }
/*     */
/*     */     private VR vrOf(String s) throws SAXException {
/*     */       try {
/* 629 */         return VR.valueOf(s);
/* 630 */       } catch (NullPointerException e) {
/* 631 */         throw new SAXException("missing vr attribute");
/* 632 */       } catch (IllegalArgumentException e) {
/* 633 */         throw new SAXException("unrecognized vr=\"" + s + '"');
/*     */       }
/*     */     }
/*     */
/*     */     private int tagOf(String s) throws SAXException {
/*     */       try {
/* 639 */         return (int)Long.parseLong(s, 16);
/* 640 */       } catch (NullPointerException e) {
/* 641 */         throw new SAXException("missing tag attribute");
/* 642 */       } catch (IllegalArgumentException e) {
/* 643 */         throw new SAXException("invalid tag=\"" + s + '"');
/*     */       }
/*     */     }
/*     */
/*     */     private int[] tagPathOf(String s) throws SAXException {
/* 648 */       String[] ss = StringUtils.split(s, '/');
/* 649 */       if (ss.length == 0) {
/* 650 */         throw new SAXException("missing tag attribute");
/*     */       }
/*     */       try {
/* 653 */         int[] tagPath = new int[ss.length];
/* 654 */         for (int i = 0; i < tagPath.length; i++) {
/* 655 */           tagPath[i] = ss[i].equals("..") ? -1 : (int)Long.parseLong(s, 16);
/*     */         }
/*     */
/* 658 */         return tagPath;
/* 659 */       } catch (IllegalArgumentException e) {
/* 660 */         throw new SAXException("invalid tag=\"" + s + '"');
/*     */       }
/*     */     }
/*     */
/*     */
/*     */     private int valueNumberOf(String s, int def) throws SAXException {
/*     */       try {
/* 667 */         return (s != null) ? Integer.parseInt(s) : def;
/* 668 */       } catch (IllegalArgumentException e) {
/* 669 */         throw new SAXException("invalid valueNumber=\"" + s + '"');
/*     */       }
/*     */     }
/*     */
/*     */     private boolean matchNotPresentOf(String s) {
/* 674 */       return (s != null && s.equalsIgnoreCase("true"));
/*     */     }
/*     */
/*     */
/*     */     private DataElement getLastDataElement() {
/* 679 */       IOD iod = this.iodStack.getLast();
/* 680 */       return iod.get(iod.size() - 1);
/*     */     }
/*     */
/*     */     private void endDataElement() throws SAXException {
/* 684 */       DataElement el = getLastDataElement();
/* 685 */       if (!this.values.isEmpty()) {
/*     */         try {
/* 687 */           if (el.vr.isIntType())
/* 688 */           { el.setValues(parseInts(this.values)); }
/*     */           else
/* 690 */           { el.setValues(this.values.<String>toArray(new String[this.values.size()])); }
/* 691 */         } catch (IllegalStateException e) {
/* 692 */           throw new SAXException("unexpected <Value>");
/*     */         }
/* 694 */         this.values.clear();
/*     */       }
/* 696 */       if (!this.codes.isEmpty()) {
/*     */         try {
/* 698 */           el.setValues(this.codes.<Code>toArray(new Code[this.codes.size()]));
/* 699 */         } catch (IllegalStateException e) {
/* 700 */           throw new SAXException("unexpected <Code>");
/*     */         }
/* 702 */         this.codes.clear();
/*     */       }
/* 704 */       this.elementConditions = false;
/*     */     }
/*     */
/*     */     private int[] parseInts(List<String> list) {
/* 708 */       int[] is = new int[list.size()];
/* 709 */       for (int i = 0; i < is.length; i++)
/* 710 */         is[i] = Integer.parseInt((String)list.get(i));
/* 711 */       return is;
/*     */     }
/*     */
/*     */     private void startValue() {
/* 715 */       this.sb.setLength(0);
/* 716 */       this.processCharacters = true;
/*     */     }
/*     */
/*     */     private void endValue() {
/* 720 */       this.values.add(this.sb.toString());
/*     */     }
/*     */
/*     */     private void startItem(String id, String idref, String type) throws SAXException {
/*     */       IOD iod;
/* 725 */       if (idref != null) {
/* 726 */         if (type != null) {
/* 727 */           throw new SAXException("<Item> with idref must not specify type");
/*     */         }
/* 729 */         iod = this.id2iod.get(idref);
/* 730 */         if (iod == null) {
/* 731 */           throw new SAXException("could not resolve <Item idref:\"" + idref + "\"/>");
/*     */         }
/*     */       } else {
/* 734 */         iod = new IOD();
/* 735 */         if (type != null)
/* 736 */           iod.setType(typeOf(type));
/* 737 */         if (this.locator != null)
/* 738 */           iod.setLineNumber(this.locator.getLineNumber());
/*     */       }
/* 740 */       getLastDataElement().addItemIOD(iod);
/* 741 */       this.iodStack.add(iod);
/* 742 */       if (id != null) {
/* 743 */         this.id2iod.put(id, iod);
/*     */       }
/* 745 */       this.idref = idref;
/* 746 */       this.itemConditions = true;
/* 747 */       this.elementConditions = false;
/*     */     }
/*     */
/*     */     private void endItem() {
/* 751 */       ((IOD)this.iodStack.removeLast()).trimToSize();
/* 752 */       this.itemConditions = false;
/*     */     }
/*     */     private void startIf(String id, String idref) throws SAXException {
/*     */       Condition cond;
/* 756 */       if (!this.conditionStack.isEmpty()) {
/* 757 */         throw new SAXException("unexpected <If>");
/*     */       }
/*     */
/* 760 */       if (idref != null) {
/* 761 */         cond = this.id2cond.get(idref);
/* 762 */         if (cond == null) {
/* 763 */           throw new SAXException("could not resolve <If idref:\"" + idref + "\"/>");
/*     */         }
/*     */       } else {
/* 766 */         cond = (new And()).id(id);
/*     */       }
/* 768 */       this.conditionStack.add(cond);
/* 769 */       if (id != null)
/* 770 */         this.id2cond.put(id, cond);
/* 771 */       this.idref = idref;
/*     */     }
/*     */
/*     */
/*     */     private void startCondition(String name, Condition cond) throws SAXException {
/* 776 */       if (!this.elementConditions && !this.itemConditions) {
/* 777 */         throw new SAXException("unexpected <" + name + '>');
/*     */       }
/* 779 */       this.conditionStack.add(cond);
/*     */     }
/*     */
/*     */     private void endCondition(String name) throws SAXException {
/* 783 */       Condition cond = this.conditionStack.removeLast();
/* 784 */       if (cond.isEmpty()) {
/* 785 */         throw new SAXException('<' + name + "> must not be empty");
/*     */       }
/* 787 */       if (!this.values.isEmpty()) {
/*     */         try {
/* 789 */           MemberOf memberOf = (MemberOf)cond;
/* 790 */           if (memberOf.vr.isIntType())
/* 791 */           { memberOf.setValues(parseInts(this.values)); }
/*     */           else
/* 793 */           { memberOf.setValues(this.values.<String>toArray(new String[this.values.size()])); }
/* 794 */         } catch (Exception e) {
/* 795 */           throw new SAXException("unexpected <Value> contained by <" + name + ">");
/*     */         }
/*     */
/* 798 */         this.values.clear();
/*     */       }
/*     */
/* 801 */       if (!this.codes.isEmpty()) {
/*     */         try {
/* 803 */           ((MemberOf)cond).setValues(this.codes.<Code>toArray(new Code[this.codes.size()]));
/* 804 */         } catch (Exception e) {
/* 805 */           throw new SAXException("unexpected <Code> contained by <" + name + ">");
/*     */         }
/*     */
/* 808 */         this.codes.clear();
/*     */       }
/*     */
/* 811 */       if (this.conditionStack.isEmpty()) {
/* 812 */         if (this.elementConditions) {
/* 813 */           getLastDataElement().setCondition(cond.trim());
/*     */         } else {
/* 815 */           ((IOD)this.iodStack.getLast()).setCondition(cond.trim());
/* 816 */         }  this.elementConditions = false;
/* 817 */         this.itemConditions = false;
/*     */       } else {
/* 819 */         ((Condition)this.conditionStack.getLast()).addChild(cond.trim());
/*     */       } 
/*     */     } }
/*     */   
/*     */   public static IOD load(String uri) throws IOException {
/* 824 */     if (uri.startsWith("resource:")) {
/*     */       try {
/* 826 */         uri = ResourceLocator.getResource(uri.substring(9), IOD.class);
/* 827 */       } catch (NullPointerException npe) {
/* 828 */         throw new FileNotFoundException(uri);
/*     */       } 
/* 830 */     } else if (uri.indexOf(':') < 2) {
/* 831 */       uri = (new File(uri)).toURI().toString();
/*     */     } 
/* 833 */     IOD iod = new IOD();
/* 834 */     iod.parse(uri);
/* 835 */     iod.trimToSize();
/* 836 */     return iod;
/*     */   }
/*     */   
/*     */   public static IOD valueOf(Code code) {
/* 840 */     IOD iod = new IOD();
/* 841 */     iod.add((new DataElement(524544, VR.SH, DataElementType.TYPE_1, 1, 1, 0)).setValues(new String[] { code.getCodeValue() }));
/*     */ 
/*     */     
/* 844 */     iod.add((new DataElement(524546, VR.SH, DataElementType.TYPE_1, 1, 1, 0)).setValues(new String[] { code.getCodingSchemeDesignator() }));
/*     */ 
/*     */     
/* 847 */     String codingSchemeVersion = code.getCodingSchemeVersion();
/* 848 */     if (codingSchemeVersion == null) {
/* 849 */       iod.add(new DataElement(524547, VR.SH, DataElementType.TYPE_0, -1, -1, 0));
/*     */     } else {
/*     */       
/* 852 */       iod.add(new DataElement(524547, VR.SH, DataElementType.TYPE_1, 1, 1, 0));
/*     */     } 
/*     */     
/* 855 */     return iod;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/IOD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */