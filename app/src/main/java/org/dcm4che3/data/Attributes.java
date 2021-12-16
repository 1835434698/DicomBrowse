/*      */ package org.dcm4che3.data;
/*      */ 
/*      */

import org.dcm4che3.io.BulkDataDescriptor;
import org.dcm4che3.io.DicomEncodingOptions;
import org.dcm4che3.io.DicomInputStream;
import org.dcm4che3.io.DicomOutputStream;
import org.dcm4che3.util.ByteUtils;
import org.dcm4che3.util.DateUtils;
import org.dcm4che3.util.StringUtils;
import org.dcm4che3.util.TagUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;

/*      */
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Attributes
/*      */   implements Serializable
/*      */ {
///*   70 */    // private static final Logger LOG = LoggerFactory.getLogger(Attributes.class);
/*      */   
/*      */   private static final int INIT_CAPACITY = 16;
/*      */   
/*      */   private static final int TO_STRING_LIMIT = 50;
/*      */   private static final int TO_STRING_WIDTH = 78;
/*      */   private transient Attributes parent;
/*      */   private transient String parentSequencePrivateCreator;
/*      */   private transient int parentSequenceTag;
/*      */   private transient int[] tags;
/*      */   private transient VR[] vrs;
/*      */   private transient Object[] values;
/*      */   private transient int size;
/*      */   private transient SpecificCharacterSet cs;
/*      */   private transient TimeZone tz;
/*   85 */   private transient int length = -1;
/*      */   
/*      */   private transient int[] groupLengths;
/*      */   private transient int groupLengthIndex0;
/*      */   private final boolean bigEndian;
/*   90 */   private long itemPosition = -1L; private boolean containsSpecificCharacterSet;
/*      */   private boolean containsTimezoneOffsetFromUTC;
/*      */   private Map<String, Object> properties;
/*      */   private TimeZone defaultTimeZone;
/*      */   private static final long serialVersionUID = 7868714416968825241L;
/*      */   
/*      */   public Attributes() {
/*   97 */     this(false, 16);
/*      */   }
/*      */   
/*      */   public Attributes(boolean bigEndian) {
/*  101 */     this(bigEndian, 16);
/*      */   }
/*      */   
/*      */   public Attributes(int initialCapacity) {
/*  105 */     this(false, initialCapacity);
/*      */   }
/*      */   
/*      */   public Attributes(boolean bigEndian, int initialCapacity) {
/*  109 */     this.bigEndian = bigEndian;
/*  110 */     init(initialCapacity);
/*      */   }
/*      */   
/*      */   public void clear() {
/*  114 */     this.size = 0;
/*  115 */     Arrays.fill(this.tags, 0);
/*  116 */     Arrays.fill((Object[])this.vrs, (Object)null);
/*  117 */     Arrays.fill(this.values, (Object)null);
/*      */   }
/*      */   
/*      */   private void init(int initialCapacity) {
/*  121 */     this.tags = new int[initialCapacity];
/*  122 */     this.vrs = new VR[initialCapacity];
/*  123 */     this.values = new Object[initialCapacity];
/*      */   }
/*      */   
/*      */   public Attributes(Attributes other) {
/*  127 */     this(other, other.bigEndian);
/*      */   }
/*      */   
/*      */   public Attributes(Attributes other, boolean bigEndian) {
/*  131 */     this(bigEndian, other.size);
/*  132 */     if (other.properties != null)
/*  133 */       this.properties = new HashMap<String, Object>(other.properties); 
/*  134 */     addAll(other);
/*      */   }
/*      */   
/*      */   public Attributes(Attributes other, int... selection) {
/*  138 */     this(other, other.bigEndian, selection);
/*      */   }
/*      */   
/*      */   public Attributes(Attributes other, boolean bigEndian, int... selection) {
/*  142 */     this(bigEndian, selection.length);
/*  143 */     if (other.properties != null)
/*  144 */       this.properties = new HashMap<String, Object>(other.properties); 
/*  145 */     addSelected(other, selection);
/*      */   }
/*      */   
/*      */   public Attributes(Attributes other, boolean bigEndian, Attributes selection) {
/*  149 */     this(bigEndian, selection.size());
/*  150 */     if (other.properties != null)
/*  151 */       this.properties = new HashMap<String, Object>(other.properties); 
/*  152 */     addSelected(other, selection);
/*      */   }
/*      */   
/*      */   public Map<String, Object> getProperties() {
/*  156 */     return this.properties;
/*      */   }
/*      */   
/*      */   public void setProperties(Map<String, Object> properties) {
/*  160 */     this.properties = properties;
/*      */   }
/*      */   
/*      */   public Object getProperty(String key, Object defVal) {
/*  164 */     if (this.properties == null) {
/*  165 */       return defVal;
/*      */     }
/*  167 */     Object val = this.properties.get(key);
/*  168 */     return (val != null) ? val : defVal;
/*      */   }
/*      */   
/*      */   public Object setProperty(String key, Object value) {
/*  172 */     if (this.properties == null)
/*  173 */       this.properties = new HashMap<String, Object>(); 
/*  174 */     return this.properties.put(key, value);
/*      */   }
/*      */   
/*      */   public Object clearProperty(String key) {
/*  178 */     return (this.properties != null) ? this.properties.remove(key) : null;
/*      */   }
/*      */   
/*      */   public final boolean isRoot() {
/*  182 */     return (this.parent == null);
/*      */   }
/*      */   
/*      */   public Attributes getRoot() {
/*  186 */     return isRoot() ? this : this.parent.getRoot();
/*      */   }
/*      */   
/*      */   public final int getLevel() {
/*  190 */     return isRoot() ? 0 : (1 + this.parent.getLevel());
/*      */   }
/*      */   
/*      */   public final boolean bigEndian() {
/*  194 */     return this.bigEndian;
/*      */   }
/*      */   
/*      */   public final Attributes getParent() {
/*  198 */     return this.parent;
/*      */   }
/*      */   
/*      */   public String getParentSequencePrivateCreator() {
/*  202 */     return this.parentSequencePrivateCreator;
/*      */   }
/*      */   
/*      */   public int getParentSequenceTag() {
/*  206 */     return this.parentSequenceTag;
/*      */   }
/*      */   
/*      */   public final int getLength() {
/*  210 */     return this.length;
/*      */   }
/*      */   
/*      */   Attributes setParent(Attributes parent, String parentSequencePrivateCreator, int parentSequenceTag) {
/*  214 */     if (parent != null) {
/*  215 */       if (parent.bigEndian != this.bigEndian) {
/*  216 */         throw new IllegalArgumentException("Endian of Item must match Endian of parent Data Set");
/*      */       }
/*  218 */       if (this.parent != null) {
/*  219 */         throw new IllegalArgumentException("Item already contained by Sequence");
/*      */       }
/*  221 */       if (!this.containsSpecificCharacterSet)
/*  222 */         this.cs = null; 
/*  223 */       if (!this.containsTimezoneOffsetFromUTC)
/*  224 */         this.tz = null; 
/*      */     } 
/*  226 */     this.parent = parent;
/*  227 */     this.parentSequencePrivateCreator = parentSequencePrivateCreator;
/*  228 */     this.parentSequenceTag = parentSequenceTag;
/*  229 */     return this;
/*      */   }
/*      */   
/*      */   public final long getItemPosition() {
/*  233 */     return this.itemPosition;
/*      */   }
/*      */   
/*      */   public final void setItemPosition(long itemPosition) {
/*  237 */     this.itemPosition = itemPosition;
/*      */   }
/*      */   
/*      */   public final boolean isEmpty() {
/*  241 */     return (this.size == 0);
/*      */   }
/*      */   
/*      */   public final int size() {
/*  245 */     return this.size;
/*      */   }
/*      */   
/*      */   public ItemPointer[] itemPointers() {
/*  249 */     return itemPointers(0);
/*      */   }
/*      */   
/*      */   private ItemPointer[] itemPointers(int n) {
/*  253 */     if (this.parent == null) {
/*  254 */       return new ItemPointer[n];
/*      */     }
/*  256 */     ItemPointer[] itemPointers = this.parent.itemPointers(n + 1);
/*  257 */     itemPointers[itemPointers.length - n - 1] = new ItemPointer(this.parentSequencePrivateCreator, this.parentSequenceTag, itemIndex());
/*      */     
/*  259 */     return itemPointers;
/*      */   }
/*      */   
/*      */   public int itemIndex() {
/*  263 */     if (this.parent == null) {
/*  264 */       return -1;
/*      */     }
/*  266 */     Sequence seq = this.parent.getSequence(this.parentSequencePrivateCreator, this.parentSequenceTag);
/*  267 */     if (seq == null) {
/*  268 */       return -1;
/*      */     }
/*  270 */     return seq.indexOf(this);
/*      */   }
/*      */   
/*      */   public int[] tags() {
/*  274 */     return Arrays.copyOf(this.tags, this.size);
/*      */   }
/*      */   
/*      */   public void trimToSize() {
/*  278 */     trimToSize(false);
/*      */   }
/*      */   
/*      */   public void trimToSize(boolean recursive) {
/*  282 */     int oldCapacity = this.tags.length;
/*  283 */     if (this.size < oldCapacity) {
/*  284 */       this.tags = Arrays.copyOf(this.tags, this.size);
/*  285 */       this.vrs = Arrays.<VR>copyOf(this.vrs, this.size);
/*  286 */       this.values = Arrays.copyOf(this.values, this.size);
/*      */     } 
/*  288 */     if (recursive)
/*  289 */       for (Object value : this.values) {
/*  290 */         if (value instanceof Sequence) {
/*  291 */           ((Sequence)value).trimToSize(recursive);
/*  292 */         } else if (value instanceof Fragments) {
/*  293 */           ((Fragments)value).trimToSize();
/*      */         } 
/*      */       }  
/*      */   }
/*      */   public void internalizeStringValues(boolean decode) {
/*  298 */     SpecificCharacterSet cs = getSpecificCharacterSet();
/*  299 */     for (int i = 0; i < this.values.length; i++) {
/*  300 */       VR vrTag = this.vrs[i];
/*  301 */       Object value = this.values[i];
/*  302 */       if (vrTag.isStringType()) {
/*  303 */         if (value instanceof byte[]) {
/*  304 */           if (!decode)
/*      */             continue;
/*  306 */           value = vrTag.toStrings(value, this.bigEndian, cs);
/*      */         }
/*  308 */         if (value instanceof String) {
/*  309 */           this.values[i] = ((String)value).intern();
/*  310 */         } else if (value instanceof String[]) {
/*  311 */           String[] ss = (String[])value;
/*  312 */           for (int j = 0; j < ss.length; j++)
/*  313 */             ss[j] = ss[j].intern();
/*      */         }  continue;
/*  315 */       }  if (value instanceof Sequence)
/*  316 */         for (Attributes item :  (Sequence) value) {
/*  317 */           item.internalizeStringValues(decode);
/*      */         }
/*      */       continue;
/*      */     }
/*      */   }
/*      */   
/*      */   private void decodeStringValuesUsingSpecificCharacterSet() {
/*  324 */     SpecificCharacterSet cs = getSpecificCharacterSet();
/*  325 */     for (int i = 0; i < this.size; i++) {
/*  326 */       Object value = this.values[i];
/*  327 */       if (value instanceof Sequence)
/*  328 */       { for (Attributes item :  (Sequence) value)
/*  329 */           item.decodeStringValuesUsingSpecificCharacterSet();  }
/*  330 */       else { VR vrTag; if ((vrTag = this.vrs[i]).useSpecificCharacterSet() &&
/*  331 */           value instanceof byte[])
/*  332 */           this.values[i] = vrTag.toStrings(value, this.bigEndian, cs);  }
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   private void ensureCapacity(int minCapacity) {
/*  338 */     int oldCapacity = this.tags.length;
/*  339 */     if (minCapacity > oldCapacity) {
/*  340 */       int newCapacity = Math.max(minCapacity, oldCapacity << 1);
/*  341 */       this.tags = Arrays.copyOf(this.tags, newCapacity);
/*  342 */       this.vrs = Arrays.<VR>copyOf(this.vrs, newCapacity);
/*  343 */       this.values = Arrays.copyOf(this.values, newCapacity);
/*      */     } 
/*      */   }
/*      */   
/*      */   public Attributes getNestedDataset(int sequenceTag) {
/*  348 */     return getNestedDataset(null, sequenceTag, 0);
/*      */   }
/*      */   
/*      */   public Attributes getNestedDataset(int sequenceTag, int itemIndex) {
/*  352 */     return getNestedDataset(null, sequenceTag, itemIndex);
/*      */   }
/*      */   
/*      */   public Attributes getNestedDataset(String privateCreator, int sequenceTag) {
/*  356 */     return getNestedDataset(privateCreator, sequenceTag, 0);
/*      */   }
/*      */   
/*      */   public Attributes getNestedDataset(String privateCreator, int sequenceTag, int itemIndex) {
/*  360 */     Object value = getValue(privateCreator, sequenceTag);
/*  361 */     if (!(value instanceof Sequence)) {
/*  362 */       return null;
/*      */     }
/*  364 */     Sequence sq = (Sequence)value;
/*  365 */     if (itemIndex >= sq.size()) {
/*  366 */       return null;
/*      */     }
/*  368 */     return sq.get(itemIndex);
/*      */   }
/*      */   
/*      */   public Attributes getNestedDataset(ItemPointer... itemPointers) {
/*  372 */     Attributes item = this;
/*  373 */     for (ItemPointer ip : itemPointers) {
/*  374 */       Object value = item.getValue(ip.privateCreator, ip.sequenceTag);
/*  375 */       if (!(value instanceof Sequence)) {
/*  376 */         return null;
/*      */       }
/*  378 */       Sequence sq = (Sequence)value;
/*  379 */       if (ip.itemIndex >= sq.size()) {
/*  380 */         return null;
/*      */       }
/*  382 */       item = sq.get(ip.itemIndex);
/*      */     } 
/*  384 */     return item;
/*      */   }
/*      */   
/*      */   private int indexForInsertOf(int tag) {
/*  388 */     return (this.size == 0) ? -1 : ((this.tags[this.size - 1] < tag) ? -(this.size + 1) : indexOf(tag));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int indexOf(int tag) {
/*  394 */     return Arrays.binarySearch(this.tags, 0, this.size, tag);
/*      */   }
/*      */   
/*      */   private int indexOf(String privateCreator, int tag) {
/*  398 */     if (privateCreator != null) {
/*  399 */       int creatorTag = creatorTagOf(privateCreator, tag, false);
/*  400 */       if (creatorTag == -1)
/*  401 */         return -1; 
/*  402 */       tag = TagUtils.toPrivateTag(creatorTag, tag);
/*      */     } 
/*  404 */     return indexOf(tag);
/*      */   }
/*      */   
/*      */   private int creatorTagOf(String privateCreator, int tag, boolean reserve) {
/*  408 */     if (!TagUtils.isPrivateGroup(tag)) {
/*  409 */       throw new IllegalArgumentException(TagUtils.toString(tag) + " is not a private Data Element");
/*      */     }
/*      */     
/*  412 */     int group = tag & 0xFFFF0000;
/*  413 */     int creatorTag = group | 0x10;
/*  414 */     int index = indexOf(creatorTag);
/*  415 */     if (index < 0)
/*  416 */       index = -index - 1; 
/*  417 */     while (index < this.size && (this.tags[index] & 0xFFFFFF00) == group) {
/*  418 */       creatorTag = this.tags[index];
/*  419 */       if (this.vrs[index] == VR.LO) {
/*  420 */         Object creatorID = decodeStringValue(index);
/*  421 */         if (privateCreator.equals(creatorID))
/*  422 */           return creatorTag; 
/*      */       } 
/*  424 */       index++;
/*  425 */       creatorTag++;
/*      */     } 
/*  427 */     if (!reserve) {
/*  428 */       return -1;
/*      */     }
/*  430 */     if ((creatorTag & 0xFF00) != 0) {
/*  431 */       throw new IllegalStateException("No free block for Private Element " + TagUtils.toString(tag));
/*      */     }
/*  433 */     setString(creatorTag, VR.LO, privateCreator);
/*  434 */     return creatorTag;
/*      */   }
/*      */   
/*      */   private Object decodeStringValue(int index) {
/*  438 */     Object value = this.values[index];
/*  439 */     if (value instanceof byte[]) {
/*  440 */       value = this.vrs[index].toStrings(value, this.bigEndian, getSpecificCharacterSet(this.vrs[index]));
/*      */       
/*  442 */       if (value instanceof String && ((String)value).isEmpty())
/*  443 */         value = Value.NULL; 
/*  444 */       this.values[index] = value;
/*      */     } 
/*  446 */     return value;
/*      */   }
/*      */   
/*      */   public SpecificCharacterSet getSpecificCharacterSet(VR vrTag) {
/*  450 */     return vrTag.useSpecificCharacterSet() ? getSpecificCharacterSet() : SpecificCharacterSet.DEFAULT;
/*      */   }
/*      */ 
/*      */   
/*      */   private double[] decodeDSValue(int index) {
/*      */     double[] ds;
/*  456 */     Object value = this.values[index];
/*  457 */     if (value == Value.NULL) {
/*  458 */       return ByteUtils.EMPTY_DOUBLES;
/*      */     }
/*  460 */     if (value instanceof double[]) {
/*  461 */       return (double[])value;
/*      */     }
/*      */     
/*  464 */     if (value instanceof byte[]) {
/*  465 */       value = this.vrs[index].toStrings(value, this.bigEndian, SpecificCharacterSet.DEFAULT);
/*      */     }
/*  467 */     if (value instanceof String) {
/*  468 */       String s = (String)value;
/*  469 */       if (s.isEmpty()) {
/*  470 */         this.values[index] = Value.NULL;
/*  471 */         return ByteUtils.EMPTY_DOUBLES;
/*      */       } 
/*  473 */       ds = new double[] { StringUtils.parseDS(s) };
/*      */     } else {
/*  475 */       String[] ss = (String[])value;
/*  476 */       ds = new double[ss.length];
/*  477 */       for (int i = 0; i < ds.length; i++) {
/*  478 */         String s = ss[i];
/*  479 */         ds[i] = (s != null && !s.isEmpty()) ? StringUtils.parseDS(s) : Double.NaN;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  484 */     this.values[index] = ds;
/*  485 */     return ds;
/*      */   }
/*      */   private int[] decodeISValue(int index) {
/*      */     int[] is;
/*  489 */     Object value = this.values[index];
/*  490 */     if (value == Value.NULL) {
/*  491 */       return ByteUtils.EMPTY_INTS;
/*      */     }
/*  493 */     if (value instanceof int[]) {
/*  494 */       return (int[])value;
/*      */     }
/*      */     
/*  497 */     if (value instanceof byte[]) {
/*  498 */       value = this.vrs[index].toStrings(value, this.bigEndian, SpecificCharacterSet.DEFAULT);
/*      */     }
/*  500 */     if (value instanceof String) {
/*  501 */       String s = (String)value;
/*  502 */       if (s.isEmpty()) {
/*  503 */         this.values[index] = Value.NULL;
/*  504 */         return ByteUtils.EMPTY_INTS;
/*      */       } 
/*  506 */       is = new int[] { StringUtils.parseIS(s) };
/*      */     } else {
/*  508 */       String[] ss = (String[])value;
/*  509 */       is = new int[ss.length];
/*  510 */       for (int i = 0; i < is.length; i++) {
/*  511 */         String s = ss[i];
/*  512 */         is[i] = (s != null && !s.isEmpty()) ? StringUtils.parseIS(s) : Integer.MIN_VALUE;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  517 */     this.values[index] = is;
/*  518 */     return is;
/*      */   }
/*      */   
/*      */   private void updateVR(int index, VR vrTag) {
/*  522 */     VR prev = this.vrs[index];
/*  523 */     if (vrTag == prev) {
/*      */       return;
/*      */     }
/*  526 */     Object value = this.values[index];
/*  527 */     if (value != Value.NULL && !(value instanceof byte[]) && (!vrTag.isStringType() || (!(value instanceof String) && !(value instanceof String[]))))
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  532 */       throw new IllegalStateException("value instanceof " + value.getClass());
/*      */     }
/*  534 */     this.vrs[index] = vrTag;
/*      */   }
/*      */   
/*      */   private static boolean isEmpty(Object value) {
/*  538 */     return (value instanceof Value && ((Value)value).isEmpty());
/*      */   }
/*      */   
/*      */   public boolean contains(int tag) {
/*  542 */     return (indexOf(tag) >= 0);
/*      */   }
/*      */   
/*      */   public boolean contains(String privateCreator, int tag) {
/*  546 */     return (indexOf(privateCreator, tag) >= 0);
/*      */   }
/*      */   
/*      */   public boolean containsValue(int tag) {
/*  550 */     return containsValue(null, tag);
/*      */   }
/*      */   
/*      */   public boolean containsValue(String privateCreator, int tag) {
/*  554 */     int index = indexOf(privateCreator, tag);
/*  555 */     return (index >= 0 && !isEmpty(this.vrs[index].isStringType() ? decodeStringValue(index) : this.values[index]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String privateCreatorOf(int tag) {
/*  562 */     if (!TagUtils.isPrivateTag(tag)) {
/*  563 */       return null;
/*      */     }
/*  565 */     int creatorTag = tag & 0xFFFF0000 | tag >>> 8 & 0xFF;
/*  566 */     int index = indexOf(creatorTag);
/*  567 */     if (index < 0 || this.vrs[index] != VR.LO || this.values[index] == Value.NULL) {
/*  568 */       return null;
/*      */     }
/*  570 */     Object value = decodeStringValue(index);
/*  571 */     if (value == Value.NULL) {
/*  572 */       return null;
/*      */     }
/*  574 */     return VR.LO.toString(value, false, 0, (String)null);
/*      */   }
/*      */   
/*      */   public Object getValue(int tag) {
/*  578 */     return getValue(null, tag, null);
/*      */   }
/*      */   
/*      */   public Object getValue(int tag, VR.Holder vr) {
/*  582 */     return getValue(null, tag, vr);
/*      */   }
/*      */   
/*      */   public Object getValue(String privateCreator, int tag) {
/*  586 */     return getValue(privateCreator, tag, null);
/*      */   }
/*      */   
/*      */   public Object getValue(String privateCreator, int tag, VR.Holder vr) {
/*  590 */     int index = indexOf(privateCreator, tag);
/*  591 */     if (index < 0) {
/*  592 */       return null;
/*      */     }
/*  594 */     if (vr != null)
/*  595 */       vr.vr = this.vrs[index];
/*  596 */     return this.values[index];
/*      */   }
/*      */   
/*      */   public VR getVR(int tag) {
/*  600 */     return getVR(null, tag);
/*      */   }
/*      */   
/*      */   public VR getVR(String privateCreator, int tag) {
/*  604 */     int index = indexOf(privateCreator, tag);
/*  605 */     if (index < 0) {
/*  606 */       return null;
/*      */     }
/*  608 */     return this.vrs[index];
/*      */   }
/*      */   
/*      */   public Sequence getSequence(int tag) {
/*  612 */     return getSequence(null, tag);
/*      */   }
/*      */   
/*      */   public Sequence getSequence(String privateCreator, int tag) {
/*  616 */     int index = indexOf(privateCreator, tag);
/*  617 */     if (index < 0) {
/*  618 */       return null;
/*      */     }
/*  620 */     Object value = this.values[index];
/*  621 */     if (value == Value.NULL) {
/*  622 */       this.values[index] = new Sequence(this, privateCreator, tag, 0); return new Sequence(this, privateCreator, tag, 0);
/*  623 */     }  return (value instanceof Sequence) ? (Sequence)value : null;
/*      */   }
/*      */   
/*      */   public byte[] getBytes(int tag) throws IOException {
/*  627 */     return getBytes(null, tag);
/*      */   }
/*      */   
/*      */   public byte[] getBytes(String privateCreator, int tag) throws IOException {
/*  631 */     int index = indexOf(privateCreator, tag);
/*  632 */     if (index < 0) {
/*  633 */       return null;
/*      */     }
/*  635 */     Object value = this.values[index];
/*  636 */     VR vrTag = this.vrs[index];
/*      */     
/*      */     try {
/*  639 */       if (value instanceof Value) {
/*  640 */         return ((Value)value).toBytes(vrTag, this.bigEndian);
/*      */       }
/*  642 */       return vrTag.toBytes(value, getSpecificCharacterSet(vrTag));
/*  643 */     } catch (UnsupportedOperationException e) {
/*  644 */       //  // LOG.info("Attempt to access {} {} as bytes", TagUtils.toString(tag), vrTag);
/*  645 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   public byte[] getSafeBytes(int tag) {
/*  650 */     return getSafeBytes(null, tag);
/*      */   }
/*      */   
/*      */   public byte[] getSafeBytes(String privateCreator, int tag) {
/*      */     try {
/*  655 */       return getBytes(privateCreator, tag);
/*  656 */     } catch (IOException e) {
/*  657 */       //  // LOG.info("Access " + TagUtils.toString(tag) + " throws i/o exception", e);
/*      */       
/*  659 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   public String getString(int tag) {
/*  664 */     return getString(null, tag, null, 0, null);
/*      */   }
/*      */   
/*      */   public String getString(int tag, String defVal) {
/*  668 */     return getString(null, tag, null, 0, defVal);
/*      */   }
/*      */   
/*      */   public String getString(int tag, int valueIndex) {
/*  672 */     return getString(null, tag, null, valueIndex, null);
/*      */   }
/*      */   
/*      */   public String getString(int tag, int valueIndex, String defVal) {
/*  676 */     return getString(null, tag, null, valueIndex, defVal);
/*      */   }
/*      */   
/*      */   public String getString(String privateCreator, int tag) {
/*  680 */     return getString(privateCreator, tag, null, 0, null);
/*      */   }
/*      */   
/*      */   public String getString(String privateCreator, int tag, String defVal) {
/*  684 */     return getString(privateCreator, tag, null, 0, defVal);
/*      */   }
/*      */   
/*      */   public String getString(String privateCreator, int tag, VR vrTag) {
/*  688 */     return getString(privateCreator, tag, vrTag, 0, null);
/*      */   }
/*      */   
/*      */   public String getString(String privateCreator, int tag, VR vrTag, String defVal) {
/*  692 */     return getString(privateCreator, tag, vrTag, 0, defVal);
/*      */   }
/*      */   
/*      */   public String getString(String privateCreator, int tag, int valueIndex) {
/*  696 */     return getString(privateCreator, tag, null, valueIndex, null);
/*      */   }
/*      */   
/*      */   public String getString(String privateCreator, int tag, int valueIndex, String defVal) {
/*  700 */     return getString(privateCreator, tag, null, valueIndex, defVal);
/*      */   }
/*      */   
/*      */   public String getString(String privateCreator, int tag, VR vrTag, int valueIndex) {
/*  704 */     return getString(privateCreator, tag, vrTag, valueIndex, null);
/*      */   }
/*      */   
/*      */   public String getString(String privateCreator, int tag, VR vrTag, int valueIndex, String defVal) {
/*  708 */     int index = indexOf(privateCreator, tag);
/*  709 */     if (index < 0) {
/*  710 */       return defVal;
/*      */     }
/*  712 */     Object value = this.values[index];
/*  713 */     if (value == Value.NULL) {
/*  714 */       return defVal;
/*      */     }
/*  716 */     if (vrTag == null) {
/*  717 */       vrTag = this.vrs[index];
/*      */     } else {
/*  719 */       updateVR(index, vrTag);
/*  720 */     }  if (vrTag.isStringType()) {
/*  721 */       value = decodeStringValue(index);
/*  722 */       if (value == Value.NULL) {
/*  723 */         return defVal;
/*      */       }
/*      */     } 
/*      */     try {
/*  727 */       return vrTag.toString(value, this.bigEndian, valueIndex, defVal);
/*  728 */     } catch (UnsupportedOperationException e) {
/*  729 */       //  // LOG.info("Attempt to access {} {} as string", TagUtils.toString(tag), vrTag);
/*  730 */       return defVal;
/*      */     } 
/*      */   }
/*      */   
/*      */   public String[] getStrings(int tag) {
/*  735 */     return getStrings(null, tag, null);
/*      */   }
/*      */   
/*      */   public String[] getStrings(String privateCreator, int tag) {
/*  739 */     return getStrings(privateCreator, tag, null);
/*      */   }
/*      */   
/*      */   public String[] getStrings(String privateCreator, int tag, VR vrTag) {
/*  743 */     int index = indexOf(privateCreator, tag);
/*  744 */     if (index < 0) {
/*  745 */       return null;
/*      */     }
/*  747 */     Object value = this.values[index];
/*  748 */     if (value == Value.NULL) {
/*  749 */       return StringUtils.EMPTY_STRING;
/*      */     }
/*  751 */     if (vrTag == null) {
/*  752 */       vrTag = this.vrs[index];
/*      */     } else {
/*  754 */       updateVR(index, vrTag);
/*  755 */     }  if (vrTag.isStringType()) {
/*  756 */       value = decodeStringValue(index);
/*  757 */       if (value == Value.NULL)
/*  758 */         return StringUtils.EMPTY_STRING; 
/*      */     } 
/*      */     try {
/*  761 */       return toStrings(vrTag.toStrings(value, this.bigEndian, getSpecificCharacterSet(vrTag)));
/*      */     }
/*  763 */     catch (UnsupportedOperationException e) {
/*  764 */       //  // LOG.info("Attempt to access {} {} as string", TagUtils.toString(tag), vrTag);
/*  765 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   private static String[] toStrings(Object val) {
/*  770 */     (new String[1])[0] = (String)val; return (val instanceof String) ? new String[1] : (String[])val;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getInt(int tag, int defVal) {
/*  776 */     return getInt(null, tag, null, 0, defVal);
/*      */   }
/*      */   
/*      */   public int getInt(int tag, int valueIndex, int defVal) {
/*  780 */     return getInt(null, tag, null, valueIndex, defVal);
/*      */   }
/*      */   
/*      */   public int getInt(String privateCreator, int tag, int defVal) {
/*  784 */     return getInt(privateCreator, tag, null, 0, defVal);
/*      */   }
/*      */   
/*      */   public int getInt(String privateCreator, int tag, VR vrTag, int defVal) {
/*  788 */     return getInt(privateCreator, tag, vrTag, 0, defVal);
/*      */   }
/*      */   
/*      */   public int getInt(String privateCreator, int tag, int valueIndex, int defVal) {
/*  792 */     return getInt(privateCreator, tag, null, valueIndex, defVal);
/*      */   }
/*      */   
/*      */   public int getInt(String privateCreator, int tag, VR vrTag, int valueIndex, int defVal) {
/*  796 */     int index = indexOf(privateCreator, tag);
/*  797 */     if (index < 0) {
/*  798 */       return defVal;
/*      */     }
/*  800 */     Object value = this.values[index];
/*  801 */     if (value == Value.NULL) {
/*  802 */       return defVal;
/*      */     }
/*  804 */     if (vrTag == null) {
/*  805 */       vrTag = this.vrs[index];
/*      */     } else {
/*  807 */       updateVR(index, vrTag);
/*  808 */     }  if (vrTag == VR.IS) {
/*  809 */       value = decodeISValue(index);
/*      */     }
/*      */     try {
/*  812 */       return vrTag.toInt(value, this.bigEndian, valueIndex, defVal);
/*  813 */     } catch (UnsupportedOperationException e) {
/*  814 */       //  // LOG.info("Attempt to access {} {} as int", TagUtils.toString(tag), vrTag);
/*  815 */       return defVal;
/*  816 */     } catch (IllegalArgumentException e) {
/*  817 */       //  // LOG.info("Invalid value of {} {}", TagUtils.toString(tag), vrTag);
/*  818 */       return defVal;
/*      */     } 
/*      */   }
/*      */   
/*      */   public int[] getInts(int tag) {
/*  823 */     return getInts(null, tag, null);
/*      */   }
/*      */   
/*      */   public int[] getInts(String privateCreator, int tag) {
/*  827 */     return getInts(privateCreator, tag, null);
/*      */   }
/*      */   
/*      */   public int[] getInts(String privateCreator, int tag, VR vrTag) {
/*  831 */     int index = indexOf(privateCreator, tag);
/*  832 */     if (index < 0) {
/*  833 */       return null;
/*      */     }
/*  835 */     Object value = this.values[index];
/*  836 */     if (value == Value.NULL) {
/*  837 */       return ByteUtils.EMPTY_INTS;
/*      */     }
/*  839 */     if (vrTag == null) {
/*  840 */       vrTag = this.vrs[index];
/*      */     } else {
/*  842 */       updateVR(index, vrTag);
/*  843 */     }  if (vrTag == VR.IS) {
/*  844 */       value = decodeISValue(index);
/*      */     }
/*      */     try {
/*  847 */       return vrTag.toInts(value, this.bigEndian);
/*  848 */     } catch (UnsupportedOperationException e) {
/*  849 */       //  // LOG.info("Attempt to access {} {} as int", TagUtils.toString(tag), vrTag);
/*  850 */       return null;
/*  851 */     } catch (IllegalArgumentException e) {
/*  852 */       //  // LOG.info("Invalid value of {} {}", TagUtils.toString(tag), vrTag);
/*  853 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   public float getFloat(int tag, float defVal) {
/*  858 */     return getFloat(null, tag, null, 0, defVal);
/*      */   }
/*      */   
/*      */   public float getFloat(int tag, int valueIndex, float defVal) {
/*  862 */     return getFloat(null, tag, null, valueIndex, defVal);
/*      */   }
/*      */   
/*      */   public float getFloat(String privateCreator, int tag, float defVal) {
/*  866 */     return getFloat(privateCreator, tag, null, 0, defVal);
/*      */   }
/*      */   
/*      */   public float getFloat(String privateCreator, int tag, VR vrTag, float defVal) {
/*  870 */     return getFloat(privateCreator, tag, vrTag, 0, defVal);
/*      */   }
/*      */   
/*      */   public float getFloat(String privateCreator, int tag, int valueIndex, float defVal) {
/*  874 */     return getFloat(privateCreator, tag, null, valueIndex, defVal);
/*      */   }
/*      */   
/*      */   public float getFloat(String privateCreator, int tag, VR vrTag, int valueIndex, float defVal) {
/*  878 */     int index = indexOf(privateCreator, tag);
/*  879 */     if (index < 0) {
/*  880 */       return defVal;
/*      */     }
/*  882 */     Object value = this.values[index];
/*  883 */     if (value == Value.NULL) {
/*  884 */       return defVal;
/*      */     }
/*  886 */     if (vrTag == null) {
/*  887 */       vrTag = this.vrs[index];
/*      */     } else {
/*  889 */       updateVR(index, vrTag);
/*  890 */     }  if (vrTag == VR.DS) {
/*  891 */       value = decodeDSValue(index);
/*      */     }
/*      */     try {
/*  894 */       return vrTag.toFloat(value, this.bigEndian, valueIndex, defVal);
/*  895 */     } catch (UnsupportedOperationException e) {
/*  896 */       //  // LOG.info("Attempt to access {} {} as float", TagUtils.toString(tag), vrTag);
/*  897 */       return defVal;
/*  898 */     } catch (IllegalArgumentException e) {
/*  899 */       //  // LOG.info("Invalid value of {} {}", TagUtils.toString(tag), vrTag);
/*  900 */       return defVal;
/*      */     } 
/*      */   }
/*      */   
/*      */   public float[] getFloats(int tag) {
/*  905 */     return getFloats(null, tag, null);
/*      */   }
/*      */   
/*      */   public float[] getFloats(String privateCreator, int tag) {
/*  909 */     return getFloats(privateCreator, tag, null);
/*      */   }
/*      */   
/*      */   public float[] getFloats(String privateCreator, int tag, VR vrTag) {
/*  913 */     int index = indexOf(privateCreator, tag);
/*  914 */     if (index < 0) {
/*  915 */       return null;
/*      */     }
/*  917 */     Object value = this.values[index];
/*  918 */     if (value == Value.NULL) {
/*  919 */       return ByteUtils.EMPTY_FLOATS;
/*      */     }
/*  921 */     if (vrTag == null) {
/*  922 */       vrTag = this.vrs[index];
/*      */     } else {
/*  924 */       updateVR(index, vrTag);
/*  925 */     }  if (vrTag == VR.DS) {
/*  926 */       value = decodeDSValue(index);
/*      */     }
/*      */     try {
/*  929 */       return vrTag.toFloats(value, this.bigEndian);
/*  930 */     } catch (UnsupportedOperationException e) {
/*  931 */       //  // LOG.info("Attempt to access {} {} as float", TagUtils.toString(tag), vrTag);
/*  932 */       return null;
/*  933 */     } catch (IllegalArgumentException e) {
/*  934 */       //  // LOG.info("Invalid value of {} {}", TagUtils.toString(tag), vrTag);
/*  935 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   public double getDouble(int tag, double defVal) {
/*  940 */     return getDouble(null, tag, null, 0, defVal);
/*      */   }
/*      */   
/*      */   public double getDouble(int tag, int valueIndex, double defVal) {
/*  944 */     return getDouble(null, tag, null, valueIndex, defVal);
/*      */   }
/*      */   
/*      */   public double getDouble(String privateCreator, int tag, double defVal) {
/*  948 */     return getDouble(privateCreator, tag, null, 0, defVal);
/*      */   }
/*      */   
/*      */   public double getDouble(String privateCreator, int tag, VR vrTag, double defVal) {
/*  952 */     return getDouble(privateCreator, tag, vrTag, 0, defVal);
/*      */   }
/*      */   
/*      */   public double getDouble(String privateCreator, int tag, int valueIndex, double defVal) {
/*  956 */     return getDouble(privateCreator, tag, null, valueIndex, defVal);
/*      */   }
/*      */   
/*      */   public double getDouble(String privateCreator, int tag, VR vrTag, int valueIndex, double defVal) {
/*  960 */     int index = indexOf(privateCreator, tag);
/*  961 */     if (index < 0) {
/*  962 */       return defVal;
/*      */     }
/*  964 */     Object value = this.values[index];
/*  965 */     if (value == Value.NULL) {
/*  966 */       return defVal;
/*      */     }
/*  968 */     if (vrTag == null) {
/*  969 */       vrTag = this.vrs[index];
/*      */     } else {
/*  971 */       updateVR(index, vrTag);
/*  972 */     }  if (vrTag == VR.DS) {
/*  973 */       value = decodeDSValue(index);
/*      */     }
/*      */     try {
/*  976 */       return vrTag.toDouble(value, this.bigEndian, valueIndex, defVal);
/*  977 */     } catch (UnsupportedOperationException e) {
/*  978 */       //  // LOG.info("Attempt to access {} {} as double", TagUtils.toString(tag), vrTag);
/*  979 */       return defVal;
/*  980 */     } catch (IllegalArgumentException e) {
/*  981 */       //  // LOG.info("Invalid value of {} {}", TagUtils.toString(tag), vrTag);
/*  982 */       return defVal;
/*      */     } 
/*      */   }
/*      */   
/*      */   public double[] getDoubles(int tag) {
/*  987 */     return getDoubles(null, tag, null);
/*      */   }
/*      */   
/*      */   public double[] getDoubles(String privateCreator, int tag) {
/*  991 */     return getDoubles(privateCreator, tag, null);
/*      */   }
/*      */   
/*      */   public double[] getDoubles(String privateCreator, int tag, VR vrTag) {
/*  995 */     int index = indexOf(privateCreator, tag);
/*  996 */     if (index < 0) {
/*  997 */       return null;
/*      */     }
/*  999 */     Object value = this.values[index];
/* 1000 */     if (value == Value.NULL) {
/* 1001 */       return ByteUtils.EMPTY_DOUBLES;
/*      */     }
/* 1003 */     if (vrTag == null) {
/* 1004 */       vrTag = this.vrs[index];
/*      */     } else {
/* 1006 */       updateVR(index, vrTag);
/* 1007 */     }  if (vrTag == VR.DS)
/* 1008 */       value = decodeDSValue(index); 
/*      */     try {
/* 1010 */       return vrTag.toDoubles(value, this.bigEndian);
/* 1011 */     } catch (UnsupportedOperationException e) {
/* 1012 */       //  // LOG.info("Attempt to access {} {} as double", TagUtils.toString(tag), vrTag);
/* 1013 */       return null;
/* 1014 */     } catch (IllegalArgumentException e) {
/* 1015 */       //  // LOG.info("Invalid value of {} {}", TagUtils.toString(tag), vrTag);
/* 1016 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   public Date getDate(int tag) {
/* 1021 */     return getDate(null, tag, null, 0, null, new DatePrecision());
/*      */   }
/*      */   
/*      */   public Date getDate(int tag, DatePrecision precision) {
/* 1025 */     return getDate(null, tag, null, 0, null, precision);
/*      */   }
/*      */   
/*      */   public Date getDate(int tag, Date defVal) {
/* 1029 */     return getDate(null, tag, null, 0, defVal, new DatePrecision());
/*      */   }
/*      */   
/*      */   public Date getDate(int tag, Date defVal, DatePrecision precision) {
/* 1033 */     return getDate(null, tag, null, 0, defVal, precision);
/*      */   }
/*      */   
/*      */   public Date getDate(int tag, int valueIndex) {
/* 1037 */     return getDate(null, tag, null, valueIndex, null, new DatePrecision());
/*      */   }
/*      */   
/*      */   public Date getDate(int tag, int valueIndex, DatePrecision precision) {
/* 1041 */     return getDate(null, tag, null, valueIndex, null, precision);
/*      */   }
/*      */   
/*      */   public Date getDate(int tag, int valueIndex, Date defVal) {
/* 1045 */     return getDate(null, tag, null, valueIndex, defVal, new DatePrecision());
/*      */   }
/*      */ 
/*      */   
/*      */   public Date getDate(int tag, int valueIndex, Date defVal, DatePrecision precision) {
/* 1050 */     return getDate(null, tag, null, valueIndex, defVal, precision);
/*      */   }
/*      */   
/*      */   public Date getDate(String privateCreator, int tag) {
/* 1054 */     return getDate(privateCreator, tag, null, 0, null, new DatePrecision());
/*      */   }
/*      */   
/*      */   public Date getDate(String privateCreator, int tag, DatePrecision precision) {
/* 1058 */     return getDate(privateCreator, tag, null, 0, null, precision);
/*      */   }
/*      */ 
/*      */   
/*      */   public Date getDate(String privateCreator, int tag, Date defVal, DatePrecision precision) {
/* 1063 */     return getDate(privateCreator, tag, null, 0, defVal, precision);
/*      */   }
/*      */   
/*      */   public Date getDate(String privateCreator, int tag, VR vrTag) {
/* 1067 */     return getDate(privateCreator, tag, vrTag, 0, null, new DatePrecision());
/*      */   }
/*      */ 
/*      */   
/*      */   public Date getDate(String privateCreator, int tag, VR vrTag, DatePrecision precision) {
/* 1072 */     return getDate(privateCreator, tag, vrTag, 0, null, precision);
/*      */   }
/*      */   
/*      */   public Date getDate(String privateCreator, int tag, VR vrTag, Date defVal) {
/* 1076 */     return getDate(privateCreator, tag, vrTag, 0, defVal, new DatePrecision());
/*      */   }
/*      */ 
/*      */   
/*      */   public Date getDate(String privateCreator, int tag, VR vrTag, Date defVal, DatePrecision precision) {
/* 1081 */     return getDate(privateCreator, tag, vrTag, 0, defVal, precision);
/*      */   }
/*      */   
/*      */   public Date getDate(String privateCreator, int tag, int valueIndex) {
/* 1085 */     return getDate(privateCreator, tag, null, valueIndex, null, new DatePrecision());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDate(String privateCreator, int tag, int valueIndex, DatePrecision precision) {
/* 1091 */     return getDate(privateCreator, tag, null, valueIndex, null, precision);
/*      */   }
/*      */ 
/*      */   
/*      */   public Date getDate(String privateCreator, int tag, int valueIndex, Date defVal) {
/* 1096 */     return getDate(privateCreator, tag, null, valueIndex, defVal, new DatePrecision());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDate(String privateCreator, int tag, int valueIndex, Date defVal, DatePrecision precision) {
/* 1102 */     return getDate(privateCreator, tag, null, valueIndex, defVal, precision);
/*      */   }
/*      */   
/*      */   public Date getDate(String privateCreator, int tag, VR vrTag, int valueIndex) {
/* 1106 */     return getDate(privateCreator, tag, vrTag, valueIndex, null, new DatePrecision());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDate(String privateCreator, int tag, VR vrTag, int valueIndex, DatePrecision precision) {
/* 1112 */     return getDate(privateCreator, tag, vrTag, valueIndex, null, precision);
/*      */   }
/*      */ 
/*      */   
/*      */   public Date getDate(String privateCreator, int tag, VR vrTag, int valueIndex, Date defVal) {
/* 1117 */     return getDate(privateCreator, tag, vrTag, valueIndex, defVal, new DatePrecision());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Date getDate(String privateCreator, int tag, VR vrTag, int valueIndex, Date defVal, DatePrecision precision) {
/* 1123 */     int index = indexOf(privateCreator, tag);
/* 1124 */     if (index < 0) {
/* 1125 */       return defVal;
/*      */     }
/* 1127 */     Object value = this.values[index];
/* 1128 */     if (value == Value.NULL) {
/* 1129 */       return defVal;
/*      */     }
/* 1131 */     if (vrTag == null) {
/* 1132 */       vrTag = this.vrs[index];
/*      */     } else {
/* 1134 */       updateVR(index, vrTag);
/* 1135 */     }  if (!vrTag.isTemporalType()) {
/* 1136 */       //  // LOG.info("Attempt to access {} {} as date", TagUtils.toString(tag), vrTag);
/* 1137 */       return defVal;
/*      */     } 
/*      */     try {
/* 1140 */       value = decodeStringValue(index);
/* 1141 */       if (value == Value.NULL) {
/* 1142 */         return defVal;
/*      */       }
/* 1144 */       return vrTag.toDate(value, getTimeZone(), valueIndex, false, defVal, precision);
/* 1145 */     } catch (IllegalArgumentException e) {
/* 1146 */       //  // LOG.info("Invalid value of {} {}", TagUtils.toString(tag), vrTag);
/* 1147 */       return defVal;
/*      */     } 
/*      */   }
/*      */   
/*      */   public Date getDate(long tag) {
/* 1152 */     return getDate((String)null, tag, (Date)null, new DatePrecision());
/*      */   }
/*      */   
/*      */   public Date getDate(long tag, DatePrecision precision) {
/* 1156 */     return getDate((String)null, tag, (Date)null, precision);
/*      */   }
/*      */   
/*      */   public Date getDate(long tag, Date defVal) {
/* 1160 */     return getDate((String)null, tag, defVal, new DatePrecision());
/*      */   }
/*      */   
/*      */   public Date getDate(long tag, Date defVal, DatePrecision precision) {
/* 1164 */     return getDate((String)null, tag, defVal, precision);
/*      */   }
/*      */   
/*      */   public Date getDate(String privateCreator, long tag) {
/* 1168 */     return getDate(privateCreator, tag, (Date)null, new DatePrecision());
/*      */   }
/*      */   
/*      */   public Date getDate(String privateCreator, long tag, DatePrecision precision) {
/* 1172 */     return getDate(privateCreator, tag, (Date)null, precision);
/*      */   }
/*      */   
/*      */   public Date getDate(String privateCreator, long tag, Date defVal) {
/* 1176 */     return getDate(privateCreator, tag, defVal, new DatePrecision());
/*      */   }
/*      */ 
/*      */   
/*      */   public Date getDate(String privateCreator, long tag, Date defVal, DatePrecision precision) {
/* 1181 */     int daTag = (int)(tag >>> 32L);
/* 1182 */     int tmTag = (int)tag;
/*      */     
/* 1184 */     String tm = getString(privateCreator, tmTag, VR.TM, (String)null);
/* 1185 */     if (tm == null) {
/* 1186 */       return getDate(daTag, defVal, precision);
/*      */     }
/* 1188 */     String da = getString(privateCreator, daTag, VR.DA, (String)null);
/* 1189 */     if (da == null)
/* 1190 */       return defVal; 
/*      */     try {
/* 1192 */       return VR.DT.toDate(da + tm, getTimeZone(), 0, false, (Date)null, precision);
/*      */     }
/* 1194 */     catch (IllegalArgumentException e) {
/* 1195 */       //  // LOG.info("Invalid value of {} DA or {} TM", TagUtils.toString(daTag), TagUtils.toString(tmTag));
/*      */ 
/*      */       
/* 1198 */       return defVal;
/*      */     } 
/*      */   }
/*      */   
/*      */   public Date[] getDates(int tag) {
/* 1203 */     return getDates(null, tag, null, new DatePrecisions());
/*      */   }
/*      */   
/*      */   public Date[] getDates(int tag, DatePrecisions precisions) {
/* 1207 */     return getDates(null, tag, null, precisions);
/*      */   }
/*      */   
/*      */   public Date[] getDates(String privateCreator, int tag) {
/* 1211 */     return getDates(privateCreator, tag, null, new DatePrecisions());
/*      */   }
/*      */ 
/*      */   
/*      */   public Date[] getDates(String privateCreator, int tag, DatePrecisions precisions) {
/* 1216 */     return getDates(privateCreator, tag, null, precisions);
/*      */   }
/*      */   
/*      */   public Date[] getDates(String privateCreator, int tag, VR vrTag) {
/* 1220 */     return getDates(privateCreator, tag, vrTag, new DatePrecisions());
/*      */   }
/*      */ 
/*      */   
/*      */   public Date[] getDates(String privateCreator, int tag, VR vrTag, DatePrecisions precisions) {
/* 1225 */     int index = indexOf(privateCreator, tag);
/* 1226 */     if (index < 0) {
/* 1227 */       return null;
/*      */     }
/* 1229 */     Object value = this.values[index];
/* 1230 */     if (value == Value.NULL) {
/* 1231 */       return DateUtils.EMPTY_DATES;
/*      */     }
/* 1233 */     if (vrTag == null) {
/* 1234 */       vrTag = this.vrs[index];
/*      */     } else {
/* 1236 */       updateVR(index, vrTag);
/* 1237 */     }  if (!vrTag.isTemporalType()) {
/* 1238 */       //  // LOG.info("Attempt to access {} {} as date", TagUtils.toString(tag), vrTag);
/* 1239 */       return DateUtils.EMPTY_DATES;
/*      */     } 
/*      */     try {
/* 1242 */       value = decodeStringValue(index);
/* 1243 */       if (value == Value.NULL) {
/* 1244 */         return DateUtils.EMPTY_DATES;
/*      */       }
/* 1246 */       return vrTag.toDates(value, getTimeZone(), false, precisions);
/* 1247 */     } catch (IllegalArgumentException e) {
/* 1248 */       //  // LOG.info("Invalid value of {} {}", TagUtils.toString(tag), vrTag);
/* 1249 */       return DateUtils.EMPTY_DATES;
/*      */     } 
/*      */   }
/*      */   
/*      */   public Date[] getDates(long tag) {
/* 1254 */     return getDates((String)null, tag, new DatePrecisions());
/*      */   }
/*      */   
/*      */   public Date[] getDates(long tag, DatePrecisions precisions) {
/* 1258 */     return getDates((String)null, tag, precisions);
/*      */   }
/*      */   
/*      */   public Date[] getDates(String privateCreator, long tag) {
/* 1262 */     return getDates(privateCreator, tag, new DatePrecisions());
/*      */   }
/*      */ 
/*      */   
/*      */   public Date[] getDates(String privateCreator, long tag, DatePrecisions precisions) {
/* 1267 */     int daTag = (int)(tag >>> 32L);
/* 1268 */     int tmTag = (int)tag;
/*      */     
/* 1270 */     String[] tm = getStrings(privateCreator, tmTag);
/* 1271 */     if (tm == null || tm.length == 0) {
/* 1272 */       return getDates(daTag, precisions);
/*      */     }
/* 1274 */     String[] da = getStrings(privateCreator, daTag);
/* 1275 */     if (da == null || da.length == 0) {
/* 1276 */       return DateUtils.EMPTY_DATES;
/*      */     }
/* 1278 */     Date[] dates = new Date[da.length];
/* 1279 */     precisions.precisions = new DatePrecision[da.length];
/* 1280 */     int i = 0;
/*      */     try {
/* 1282 */       TimeZone tz = getTimeZone();
/* 1283 */       while (i < tm.length) {
/* 1284 */         dates[i++] = VR.DT.toDate(da[i] + tm[i], tz, 0, false, (Date)null, precisions.precisions[i] = new DatePrecision());
/*      */       }
/* 1286 */       while (i < da.length) {
/* 1287 */         dates[i++] = VR.DA.toDate(da[i], tz, 0, false, (Date)null, precisions.precisions[i] = new DatePrecision());
/*      */       }
/* 1289 */     } catch (IllegalArgumentException e) {
/* 1290 */       //  // LOG.info("Invalid value of {} DA or {} TM", TagUtils.toString(daTag), TagUtils.toString(tmTag));
/*      */ 
/*      */       
/* 1293 */       dates = Arrays.<Date>copyOf(dates, i);
/*      */     } 
/* 1295 */     return dates;
/*      */   }
/*      */   
/*      */   public DateRange getDateRange(int tag) {
/* 1299 */     return getDateRange(null, tag, null, null);
/*      */   }
/*      */   
/*      */   public DateRange getDateRange(int tag, DateRange defVal) {
/* 1303 */     return getDateRange(null, tag, null, defVal);
/*      */   }
/*      */   
/*      */   public DateRange getDateRange(String privateCreator, int tag) {
/* 1307 */     return getDateRange(privateCreator, tag, null, null);
/*      */   }
/*      */   
/*      */   public DateRange getDateRange(String privateCreator, int tag, DateRange defVal) {
/* 1311 */     return getDateRange(privateCreator, tag, null, defVal);
/*      */   }
/*      */   
/*      */   public DateRange getDateRange(String privateCreator, int tag, VR vrTag) {
/* 1315 */     return getDateRange(privateCreator, tag, vrTag, null);
/*      */   }
/*      */   
/*      */   public DateRange getDateRange(String privateCreator, int tag, VR vrTag, DateRange defVal) {
/* 1319 */     int index = indexOf(privateCreator, tag);
/* 1320 */     if (index < 0) {
/* 1321 */       return defVal;
/*      */     }
/* 1323 */     Object value = this.values[index];
/* 1324 */     if (value == Value.NULL) {
/* 1325 */       return defVal;
/*      */     }
/* 1327 */     if (vrTag == null) {
/* 1328 */       vrTag = this.vrs[index];
/*      */     } else {
/* 1330 */       updateVR(index, vrTag);
/* 1331 */     }  if (!vrTag.isTemporalType()) {
/* 1332 */       //  // LOG.info("Attempt to access {} {} as date", TagUtils.toString(tag), vrTag);
/* 1333 */       return defVal;
/*      */     } 
/* 1335 */     value = decodeStringValue(index);
/* 1336 */     if (value == Value.NULL) {
/* 1337 */       return defVal;
/*      */     }
/*      */     try {
/* 1340 */       return toDateRange((value instanceof String) ? (String)value : ((String[])value)[0], vrTag);
/*      */     }
/* 1342 */     catch (IllegalArgumentException e) {
/* 1343 */       //  // LOG.info("Invalid value of {} {}", TagUtils.toString(tag), vrTag);
/* 1344 */       return defVal;
/*      */     } 
/*      */   }
/*      */   
/*      */   private DateRange toDateRange(String s, VR vrTag) {
/* 1349 */     String[] range = splitRange(s);
/* 1350 */     TimeZone tz = getTimeZone();
/* 1351 */     DatePrecision precision = new DatePrecision();
/* 1352 */     Date start = (range[0] == null) ? null : vrTag.toDate(range[0], tz, 0, false, (Date)null, precision);
/*      */     
/* 1354 */     Date end = (range[1] == null) ? null : vrTag.toDate(range[1], tz, 0, true, (Date)null, precision);
/*      */     
/* 1356 */     return new DateRange(start, end);
/*      */   }
/*      */   
/*      */   private static String[] splitRange(String s) {
/* 1360 */     String[] range = new String[2];
/* 1361 */     int delim = s.indexOf('-');
/* 1362 */     if (delim == -1) {
/* 1363 */       range[1] = s; range[0] = s;
/*      */     } else {
/* 1365 */       if (delim > 0)
/* 1366 */         range[0] = s.substring(0, delim); 
/* 1367 */       if (delim < s.length() - 1)
/* 1368 */         range[1] = s.substring(delim + 1); 
/*      */     } 
/* 1370 */     return range;
/*      */   }
/*      */   
/*      */   public DateRange getDateRange(long tag) {
/* 1374 */     return getDateRange((String)null, tag, (DateRange)null);
/*      */   }
/*      */   
/*      */   public DateRange getDateRange(long tag, DateRange defVal) {
/* 1378 */     return getDateRange((String)null, tag, defVal);
/*      */   }
/*      */   
/*      */   public DateRange getDateRange(String privateCreator, long tag) {
/* 1382 */     return getDateRange(privateCreator, tag, (DateRange)null);
/*      */   }
/*      */   
/*      */   public DateRange getDateRange(String privateCreator, long tag, DateRange defVal) {
/* 1386 */     int daTag = (int)(tag >>> 32L);
/* 1387 */     int tmTag = (int)tag;
/*      */     
/* 1389 */     String tm = getString(privateCreator, tmTag, VR.TM, (String)null);
/* 1390 */     if (tm == null) {
/* 1391 */       return getDateRange(daTag, defVal);
/*      */     }
/* 1393 */     String da = getString(privateCreator, daTag, VR.DA, (String)null);
/* 1394 */     if (da == null) {
/* 1395 */       return defVal;
/*      */     }
/*      */     try {
/* 1398 */       return toDateRange(da, tm);
/* 1399 */     } catch (IllegalArgumentException e) {
/* 1400 */       //  // LOG.info("Invalid value of {} TM", TagUtils.toString((int)tag));
/* 1401 */       return defVal;
/*      */     } 
/*      */   }
/*      */   
/*      */   private DateRange toDateRange(String da, String tm) {
/* 1406 */     String[] darange = splitRange(da);
/* 1407 */     String[] tmrange = splitRange(tm);
/* 1408 */     DatePrecision precision = new DatePrecision();
/* 1409 */     TimeZone tz = getTimeZone();
/* 1410 */     return new DateRange((darange[0] == null) ? null : VR.DT.toDate((tmrange[0] == null) ? darange[0] : (darange[0] + tmrange[0]), tz, 0, false, (Date)null, precision), (darange[1] == null) ? null : VR.DT.toDate((tmrange[1] == null) ? darange[1] : (darange[1] + tmrange[1]), tz, 0, true, (Date)null, precision));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSpecificCharacterSet(String... codes) {
/* 1431 */     decodeStringValuesUsingSpecificCharacterSet();
/* 1432 */     setString(524293, VR.CS, codes);
/*      */   }
/*      */   
/*      */   public SpecificCharacterSet getSpecificCharacterSet() {
/* 1436 */     if (this.cs != null) {
/* 1437 */       return this.cs;
/*      */     }
/* 1439 */     if (this.containsSpecificCharacterSet) {
/* 1440 */       this.cs = SpecificCharacterSet.valueOf(getStrings(null, 524293, VR.CS));
/*      */     } else {
/* 1442 */       if (this.parent != null) {
/* 1443 */         return this.parent.getSpecificCharacterSet();
/*      */       }
/* 1445 */       this.cs = SpecificCharacterSet.DEFAULT;
/*      */     } 
/* 1447 */     return this.cs;
/*      */   }
/*      */   
/*      */   public boolean containsTimezoneOffsetFromUTC() {
/* 1451 */     return this.containsTimezoneOffsetFromUTC;
/*      */   }
/*      */   
/*      */   public void setDefaultTimeZone(TimeZone tz) {
/* 1455 */     this.defaultTimeZone = tz;
/*      */   }
/*      */   
/*      */   public TimeZone getDefaultTimeZone() {
/* 1459 */     if (this.defaultTimeZone != null) {
/* 1460 */       return this.defaultTimeZone;
/*      */     }
/* 1462 */     if (this.parent != null) {
/* 1463 */       return this.parent.getDefaultTimeZone();
/*      */     }
/* 1465 */     return TimeZone.getDefault();
/*      */   }
/*      */   
/*      */   public TimeZone getTimeZone() {
/* 1469 */     if (this.tz != null) {
/* 1470 */       return this.tz;
/*      */     }
/* 1472 */     if (this.containsTimezoneOffsetFromUTC)
/* 1473 */     { String s = getString(524801);
/* 1474 */       if (s != null)
/*      */         try {
/* 1476 */           this.tz = DateUtils.timeZone(s);
/* 1477 */         } catch (IllegalArgumentException e) {
/* 1478 */           //  // LOG.info(e.getMessage());
/*      */         }   }
/* 1480 */     else { if (this.parent != null) {
/* 1481 */         return this.parent.getTimeZone();
/*      */       }
/* 1483 */       this.tz = getDefaultTimeZone(); }
/*      */     
/* 1485 */     return this.tz;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTimezoneOffsetFromUTC(String utcOffset) {
/* 1495 */     TimeZone tz = DateUtils.timeZone(utcOffset);
/* 1496 */     updateTimezone(getTimeZone(), tz);
/* 1497 */     setString(524801, VR.SH, utcOffset);
/* 1498 */     this.tz = tz;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTimezone(TimeZone tz) {
/* 1513 */     updateTimezone(getTimeZone(), tz);
/* 1514 */     if (tz.useDaylightTime()) {
/* 1515 */       remove(524801);
/* 1516 */       setDefaultTimeZone(tz);
/*      */     } else {
/* 1518 */       setString(524801, VR.SH, DateUtils.formatTimezoneOffsetFromUTC(tz));
/*      */     } 
/*      */     
/* 1521 */     this.tz = tz;
/*      */   }
/*      */   
/*      */   private void updateTimezone(TimeZone from, TimeZone to) {
/* 1525 */     if (from.hasSameRules(to)) {
/*      */       return;
/*      */     }
/* 1528 */     for (int i = 0; i < this.size; i++) {
/* 1529 */       Object val = this.values[i];
/* 1530 */       if (val instanceof Sequence) {
/* 1531 */         Sequence new_name = (Sequence)val;
/* 1532 */         for (Attributes item : new_name) {
/* 1533 */           item.updateTimezone(item.getTimeZone(), to);
/* 1534 */           item.remove(524801);
/*      */         } 
/* 1536 */       } else if ((this.vrs[i] == VR.TM && this.tags[i] != 1048626) || (this.vrs[i] == VR.DT && this.tags[i] != 524550 && this.tags[i] != 524551)) {
/*      */ 
/*      */         
/* 1539 */         updateTimezone(from, to, i);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   private void updateTimezone(TimeZone from, TimeZone to, int tmIndex) {
/* 1544 */     Object tm = decodeStringValue(tmIndex);
/* 1545 */     if (tm == Value.NULL) {
/*      */       return;
/*      */     }
/* 1548 */     int tmTag = this.tags[tmIndex];
/* 1549 */     if (this.vrs[tmIndex] == VR.DT)
/* 1550 */     { if (tm instanceof String[]) {
/* 1551 */         String[] tms = (String[])tm;
/* 1552 */         for (int i = 0; i < tms.length; i++) {
/* 1553 */           tms[i] = updateTimeZoneDT(from, to, tms[i]);
/*      */         }
/*      */       } else {
/* 1556 */         this.values[tmIndex] = updateTimeZoneDT(from, to, (String)tm);
/*      */       }  }
/* 1558 */     else { int daTag = ElementDictionary.getElementDictionary(privateCreatorOf(tmTag)).daTagOf(tmTag);
/* 1559 */       int daIndex = (daTag != 0) ? indexOf(daTag) : -1;
/* 1560 */       Object da = (daIndex >= 0) ? decodeStringValue(daIndex) : Value.NULL;
/*      */       
/* 1562 */       if (tm instanceof String[]) {
/* 1563 */         String[] tms = (String[])tm;
/* 1564 */         if (da instanceof String[]) {
/* 1565 */           String[] das = (String[])da;
/* 1566 */           for (int i = 0; i < tms.length; i++) {
/* 1567 */             if (i < das.length) {
/* 1568 */               String dt = updateTimeZoneDT(from, to, das[i] + tms[i]);
/*      */               
/* 1570 */               das[i] = dt.substring(0, 8);
/* 1571 */               tms[i] = dt.substring(8);
/*      */             } else {
/* 1573 */               tms[i] = updateTimeZoneTM(from, to, tms[i]);
/*      */             } 
/*      */           } 
/*      */         } else {
/* 1577 */           if (da == Value.NULL) {
/* 1578 */             tms[0] = updateTimeZoneTM(from, to, tms[0]);
/*      */           } else {
/* 1580 */             String dt = updateTimeZoneDT(from, to, (String)da + tms[0]);
/*      */             
/* 1582 */             this.values[daIndex] = dt.substring(0, 8);
/* 1583 */             tms[0] = dt.substring(8);
/*      */           } 
/* 1585 */           for (int i = 1; i < tms.length; i++) {
/* 1586 */             tms[i] = updateTimeZoneTM(from, to, tms[i]);
/*      */           }
/*      */         }
/*      */       
/* 1590 */       } else if (da instanceof String[]) {
/* 1591 */         String[] das = (String[])da;
/* 1592 */         String dt = updateTimeZoneDT(from, to, das[0] + (String)tm);
/*      */         
/* 1594 */         das[0] = dt.substring(0, 8);
/* 1595 */         this.values[tmIndex] = dt.substring(8);
/*      */       } else {
/* 1597 */         String[] tmRange = null;
/* 1598 */         if (isRange((String)tm)) {
/* 1599 */           tmRange = splitRange((String)tm);
/* 1600 */           if (tmRange[0] == null)
/* 1601 */             tmRange[0] = "000000.000"; 
/* 1602 */           if (tmRange[1] == null)
/* 1603 */             tmRange[1] = "235959.999"; 
/*      */         } 
/* 1605 */         if (da == Value.NULL) {
/* 1606 */           if (tmRange != null) {
/* 1607 */             tmRange[0] = updateTimeZoneTM(from, to, tmRange[0]);
/*      */             
/* 1609 */             tmRange[1] = updateTimeZoneTM(from, to, tmRange[1]);
/*      */             
/* 1611 */             this.values[tmIndex] = toDateRangeString(tmRange[0], tmRange[1]);
/*      */           } else {
/*      */             
/* 1614 */             this.values[tmIndex] = updateTimeZoneTM(from, to, (String)tm);
/*      */           }
/*      */         
/*      */         }
/* 1618 */         else if (tmRange != null || isRange((String)da)) {
/* 1619 */           String[] daRange = splitRange((String)da);
/* 1620 */           if (daRange[0] == null) {
/* 1621 */             daRange[0] = "";
/* 1622 */             tmRange[0] = updateTimeZoneTM(from, to, tmRange[0]);
/*      */           } else {
/* 1624 */             String dt = updateTimeZoneDT(from, to, daRange[0] + tmRange[0]);
/*      */             
/* 1626 */             daRange[0] = dt.substring(0, 8);
/* 1627 */             tmRange[0] = dt.substring(8);
/*      */           } 
/* 1629 */           if (daRange[1] == null) {
/* 1630 */             daRange[1] = "";
/* 1631 */             tmRange[1] = updateTimeZoneTM(from, to, tmRange[1]);
/*      */           } else {
/* 1633 */             String dt = updateTimeZoneDT(from, to, daRange[1] + tmRange[1]);
/*      */             
/* 1635 */             daRange[1] = dt.substring(0, 8);
/* 1636 */             tmRange[1] = dt.substring(8);
/*      */           } 
/* 1638 */           this.values[daIndex] = toDateRangeString(daRange[0], daRange[1]);
/*      */           
/* 1640 */           this.values[tmIndex] = toDateRangeString(tmRange[0], tmRange[1]);
/*      */         } else {
/*      */           
/* 1643 */           String dt = updateTimeZoneDT(from, to, (String)da + (String)tm);
/*      */           
/* 1645 */           this.values[daIndex] = dt.substring(0, 8);
/* 1646 */           this.values[tmIndex] = dt.substring(8);
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isRange(String s) {
/* 1655 */     return (s.indexOf('-') >= 0);
/*      */   }
/*      */   
/*      */   private String updateTimeZoneDT(TimeZone from, TimeZone to, String dt) {
/* 1659 */     int dtlen = dt.length();
/* 1660 */     if (dtlen > 8) {
/* 1661 */       char ch = dt.charAt(dtlen - 5);
/* 1662 */       if (ch == '+' || ch == '-')
/* 1663 */         return dt; 
/*      */     } 
/*      */     try {
/* 1666 */       DatePrecision precision = new DatePrecision();
/* 1667 */       Date date = DateUtils.parseDT(from, dt, false, precision);
/* 1668 */       dt = DateUtils.formatDT(to, date, precision);
/* 1669 */     } catch (IllegalArgumentException e) {}
/*      */     
/* 1671 */     return dt;
/*      */   }
/*      */   
/*      */   private String updateTimeZoneTM(TimeZone from, TimeZone to, String tm) {
/*      */     try {
/* 1676 */       DatePrecision precision = new DatePrecision();
/* 1677 */       Date date = DateUtils.parseTM(from, tm, false, precision);
/* 1678 */       tm = DateUtils.formatTM(to, date, precision);
/* 1679 */     } catch (IllegalArgumentException e) {}
/*      */     
/* 1681 */     return tm;
/*      */   }
/*      */   
/*      */   public String getPrivateCreator(int tag) {
/* 1685 */     return TagUtils.isPrivateTag(tag) ? getString(TagUtils.creatorTagOf(tag), (String)null) : null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Object remove(int tag) {
/* 1691 */     return remove(null, tag);
/*      */   }
/*      */   
/*      */   public Object remove(String privateCreator, int tag) {
/* 1695 */     int index = indexOf(privateCreator, tag);
/* 1696 */     if (index < 0) {
/* 1697 */       return null;
/*      */     }
/* 1699 */     Object value = this.values[index];
/*      */ 
/*      */ 
/*      */     
/* 1703 */     int numMoved = this.size - index - 1;
/* 1704 */     if (numMoved > 0) {
/* 1705 */       System.arraycopy(this.tags, index + 1, this.tags, index, numMoved);
/* 1706 */       System.arraycopy(this.vrs, index + 1, this.vrs, index, numMoved);
/* 1707 */       System.arraycopy(this.values, index + 1, this.values, index, numMoved);
/*      */     } 
/* 1709 */     this.values[--this.size] = null;
/*      */     
/* 1711 */     if (tag == 524293) {
/* 1712 */       this.containsSpecificCharacterSet = false;
/* 1713 */       this.cs = null;
/* 1714 */     } else if (tag == 524801) {
/* 1715 */       this.containsTimezoneOffsetFromUTC = false;
/* 1716 */       this.tz = null;
/*      */     } 
/*      */     
/* 1719 */     return value;
/*      */   }
/*      */   
/*      */   public Object setNull(int tag, VR vrTag) {
/* 1723 */     return setNull(null, tag, vrTag);
/*      */   }
/*      */   
/*      */   public Object setNull(String privateCreator, int tag, VR vrTag) {
/* 1727 */     return set(privateCreator, tag, vrTag, Value.NULL);
/*      */   }
/*      */   
/*      */   public Object setBytes(int tag, VR vrTag, byte[] b) {
/* 1731 */     return setBytes(null, tag, vrTag, b);
/*      */   }
/*      */   
/*      */   public Object setBytes(String privateCreator, int tag, VR vrTag, byte[] b) {
/* 1735 */     return set(privateCreator, tag, vrTag, vrTag.toValue(b));
/*      */   }
/*      */   
/*      */   public Object setString(int tag, VR vrTag, String s) {
/* 1739 */     return setString((String)null, tag, vrTag, s);
/*      */   }
/*      */   
/*      */   public Object setString(String privateCreator, int tag, VR vrTag, String s) {
/* 1743 */     return set(privateCreator, tag, vrTag, vrTag.toValue(s, this.bigEndian));
/*      */   }
/*      */   
/*      */   public Object setString(int tag, VR vrTag, String... ss) {
/* 1747 */     return setString((String)null, tag, vrTag, ss);
/*      */   }
/*      */   
/*      */   public Object setString(String privateCreator, int tag, VR vrTag, String... ss) {
/* 1751 */     return set(privateCreator, tag, vrTag, vrTag.toValue(ss, this.bigEndian));
/*      */   }
/*      */   
/*      */   public Object setInt(int tag, VR vrTag, int... is) {
/* 1755 */     return setInt(null, tag, vrTag, is);
/*      */   }
/*      */   
/*      */   public Object setInt(String privateCreator, int tag, VR vrTag, int... is) {
/* 1759 */     return set(privateCreator, tag, vrTag, vrTag.toValue(is, this.bigEndian));
/*      */   }
/*      */   
/*      */   public Object setFloat(int tag, VR vrTag, float... fs) {
/* 1763 */     return setFloat(null, tag, vrTag, fs);
/*      */   }
/*      */   
/*      */   public Object setFloat(String privateCreator, int tag, VR vrTag, float... fs) {
/* 1767 */     return set(privateCreator, tag, vrTag, vrTag.toValue(fs, this.bigEndian));
/*      */   }
/*      */   
/*      */   public Object setDouble(int tag, VR vrTag, double... ds) {
/* 1771 */     return setDouble(null, tag, vrTag, ds);
/*      */   }
/*      */   
/*      */   public Object setDouble(String privateCreator, int tag, VR vrTag, double... ds) {
/* 1775 */     return set(privateCreator, tag, vrTag, vrTag.toValue(ds, this.bigEndian));
/*      */   }
/*      */   
/*      */   public Object setDate(int tag, VR vrTag, Date... ds) {
/* 1779 */     return setDate((String)null, tag, vrTag, ds);
/*      */   }
/*      */   
/*      */   public Object setDate(int tag, VR vrTag, DatePrecision precision, Date... ds) {
/* 1783 */     return setDate(null, tag, vrTag, precision, ds);
/*      */   }
/*      */ 
/*      */   
/*      */   public Object setDate(String privateCreator, int tag, VR vrTag, Date... ds) {
/* 1788 */     return setDate(privateCreator, tag, vrTag, new DatePrecision(), ds);
/*      */   }
/*      */ 
/*      */   
/*      */   public Object setDate(String privateCreator, int tag, VR vrTag, DatePrecision precision, Date... ds) {
/* 1793 */     return set(privateCreator, tag, vrTag, vrTag.toValue(ds, getTimeZone(), precision));
/*      */   }
/*      */   
/*      */   public void setDate(long tag, Date dt) {
/* 1797 */     setDate((String)null, tag, dt);
/*      */   }
/*      */   
/*      */   public void setDate(long tag, DatePrecision precision, Date dt) {
/* 1801 */     setDate((String)null, tag, precision, dt);
/*      */   }
/*      */   
/*      */   public void setDate(String privateCreator, long tag, Date dt) {
/* 1805 */     setDate(privateCreator, tag, new DatePrecision(), dt);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDate(String privateCreator, long tag, DatePrecision precision, Date dt) {
/* 1810 */     int daTag = (int)(tag >>> 32L);
/* 1811 */     int tmTag = (int)tag;
/* 1812 */     setDate(privateCreator, daTag, VR.DA, precision, new Date[] { dt });
/* 1813 */     setDate(privateCreator, tmTag, VR.TM, precision, new Date[] { dt });
/*      */   }
/*      */   
/*      */   public Object setDateRange(int tag, VR vrTag, DateRange range) {
/* 1817 */     return setDateRange(null, tag, vrTag, range);
/*      */   }
/*      */   
/*      */   public Object setDateRange(String privateCreator, int tag, VR vrTag, DateRange range) {
/* 1821 */     return set(privateCreator, tag, vrTag, toString(range, vrTag, getTimeZone()));
/*      */   }
/*      */   
/*      */   private static String toString(DateRange range, VR vrTag, TimeZone tz) {
/* 1825 */     DatePrecision precision = new DatePrecision();
/* 1826 */     String start = (range.getStartDate() != null) ? (String) vrTag.toValue(new Date[] { range.getStartDate() }, tz, precision) : "";
/*      */ 
/*      */ 
/*      */     
/* 1830 */     String end = (range.getEndDate() != null) ? (String) vrTag.toValue(new Date[] { range.getEndDate() }, tz, precision) : "";
/*      */ 
/*      */ 
/*      */     
/* 1834 */     return toDateRangeString(start, end);
/*      */   }
/*      */   
/*      */   private static String toDateRangeString(String start, String end) {
/* 1838 */     return start.equals(end) ? start : (start + '-' + end);
/*      */   }
/*      */   
/*      */   public void setDateRange(long tag, DateRange dr) {
/* 1842 */     setDateRange((String)null, tag, dr);
/*      */   }
/*      */   
/*      */   public void setDateRange(String privateCreator, long tag, DateRange range) {
/* 1846 */     int daTag = (int)(tag >>> 32L);
/* 1847 */     int tmTag = (int)tag;
/* 1848 */     setDateRange(privateCreator, daTag, VR.DA, range);
/* 1849 */     setDateRange(privateCreator, tmTag, VR.TM, range);
/*      */   }
/*      */   
/*      */   public Object setValue(int tag, VR vrTag, Object value) {
/* 1853 */     return setValue(null, tag, vrTag, value);
/*      */   }
/*      */   
/*      */   public Object setValue(String privateCreator, int tag, VR vrTag, Object value) {
/* 1857 */     return set(privateCreator, tag, vrTag, (value != null) ? value : Value.NULL);
/*      */   }
/*      */   
/*      */   public Sequence newSequence(int tag, int initialCapacity) {
/* 1861 */     return newSequence(null, tag, initialCapacity);
/*      */   }
/*      */   
/*      */   public Sequence newSequence(String privateCreator, int tag, int initialCapacity) {
/* 1865 */     Sequence seq = new Sequence(this, privateCreator, tag, initialCapacity);
/* 1866 */     set(privateCreator, tag, VR.SQ, seq);
/* 1867 */     return seq;
/*      */   }
/*      */   
/*      */   public Sequence ensureSequence(int tag, int initialCapacity) {
/* 1871 */     return ensureSequence(null, tag, initialCapacity);
/*      */   }
/*      */   public Sequence ensureSequence(String privateCreator, int tag, int initialCapacity) {
/*      */     Sequence seq;
/* 1875 */     if (privateCreator != null) {
/* 1876 */       int creatorTag = creatorTagOf(privateCreator, tag, true);
/* 1877 */       tag = TagUtils.toPrivateTag(creatorTag, tag);
/*      */     } 
/*      */ 
/*      */     
/* 1881 */     int index = indexOf(tag);
/* 1882 */     if (index >= 0)
/* 1883 */     { Object oldValue = this.values[index];
/* 1884 */       if (oldValue instanceof Sequence) {
/* 1885 */         seq = (Sequence)oldValue;
/*      */       } else {
/* 1887 */         this.values[index] = seq = new Sequence(this, privateCreator, tag, initialCapacity);
/*      */       }  }
/* 1889 */     else { seq = new Sequence(this, privateCreator, tag, initialCapacity);
/* 1890 */       insert(-index - 1, tag, VR.SQ, seq); }
/*      */     
/* 1892 */     return seq;
/*      */   }
/*      */ 
/*      */   
/*      */   public Fragments newFragments(int tag, VR vrTag, int initialCapacity) {
/* 1897 */     return newFragments(null, tag, vrTag, initialCapacity);
/*      */   }
/*      */ 
/*      */   
/*      */   public Fragments newFragments(String privateCreator, int tag, VR vrTag, int initialCapacity) {
/* 1902 */     Fragments frags = new Fragments(privateCreator, tag, vrTag, this.bigEndian, initialCapacity);
/* 1903 */     set(privateCreator, tag, vrTag, frags);
/* 1904 */     return frags;
/*      */   }
/*      */   
/*      */   private Object set(String privateCreator, int tag, VR vrTag, Object value) {
/* 1908 */     if (vrTag == null) {
/* 1909 */       throw new NullPointerException("vr");
/*      */     }
/* 1911 */     if (privateCreator != null) {
/* 1912 */       int creatorTag = creatorTagOf(privateCreator, tag, true);
/* 1913 */       tag = TagUtils.toPrivateTag(creatorTag, tag);
/*      */     } 
/*      */     
/* 1916 */     if (TagUtils.isGroupLength(tag)) {
/* 1917 */       return null;
/*      */     }
/* 1919 */     Object oldValue = set(tag, vrTag, value);
/*      */     
/* 1921 */     if (tag == 524293) {
/* 1922 */       this.containsSpecificCharacterSet = true;
/* 1923 */       this.cs = null;
/* 1924 */     } else if (tag == 524801) {
/* 1925 */       this.containsTimezoneOffsetFromUTC = (value != Value.NULL);
/* 1926 */       this.tz = null;
/*      */     } 
/*      */     
/* 1929 */     return oldValue;
/*      */   }
/*      */ 
/*      */   
/*      */   public void addBulkDataReference(String privateCreator, int tag, VR vrTag, BulkData bulkData, ItemPointer... itemPointers) {
/* 1934 */     Sequence seq = ensureSequence(-458760, 8);
/* 1935 */     Attributes item = new Attributes(this.bigEndian, 7);
/* 1936 */     seq.add(item);
/* 1937 */     item.setString(528784, VR.UR, bulkData.uri);
/* 1938 */     item.setInt(7471142, VR.AT, new int[] { tag });
/* 1939 */     item.setString(7471184, VR.CS, vrTag.name());
/* 1940 */     if (privateCreator != null)
/* 1941 */       item.setString(7471190, VR.LO, privateCreator);
/* 1942 */     if (itemPointers.length > 0) {
/* 1943 */       int[] seqTags = new int[itemPointers.length];
/* 1944 */       int[] itemNumbers = new int[itemPointers.length];
/* 1945 */       String[] privateCreators = null;
/* 1946 */       for (int i = 0; i < itemPointers.length; i++) {
/* 1947 */         ItemPointer ip = itemPointers[i];
/* 1948 */         seqTags[i] = ip.sequenceTag;
/* 1949 */         itemNumbers[i] = ip.itemIndex + 1;
/* 1950 */         if (ip.privateCreator != null) {
/* 1951 */           if (privateCreators == null)
/* 1952 */             privateCreators = new String[itemPointers.length]; 
/* 1953 */           privateCreators[i] = ip.privateCreator;
/*      */         } 
/*      */       } 
/* 1956 */       item.setInt(7471186, VR.AT, seqTags);
/* 1957 */       if (privateCreators != null)
/* 1958 */         item.setString(7471188, VR.LO, privateCreators);
/* 1959 */       item.setInt(7606359, VR.IS, itemNumbers);
/*      */     } 
/* 1961 */     item.trimToSize();
/*      */   }
/*      */   
/*      */   private Object set(int tag, VR vrTag, Object value) {
/* 1965 */     int index = indexForInsertOf(tag);
/* 1966 */     if (index >= 0) {
/* 1967 */       Object oldValue = this.values[index];
/* 1968 */       this.vrs[index] = vrTag;
/* 1969 */       this.values[index] = value;
/* 1970 */       return oldValue;
/*      */     } 
/* 1972 */     insert(-index - 1, tag, vrTag, value);
/* 1973 */     return null;
/*      */   }
/*      */   
/*      */   private void insert(int index, int tag, VR vrTag, Object value) {
/* 1977 */     ensureCapacity(this.size + 1);
/* 1978 */     int numMoved = this.size - index;
/* 1979 */     if (numMoved > 0) {
/* 1980 */       System.arraycopy(this.tags, index, this.tags, index + 1, numMoved);
/* 1981 */       System.arraycopy(this.vrs, index, this.vrs, index + 1, numMoved);
/* 1982 */       System.arraycopy(this.values, index, this.values, index + 1, numMoved);
/*      */     } 
/* 1984 */     this.tags[index] = tag;
/* 1985 */     this.vrs[index] = vrTag;
/* 1986 */     this.values[index] = value;
/* 1987 */     this.size++;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean addAll(Attributes other) {
/* 1992 */     return add(other, null, null, 0, 0, null, false, false, false, null);
/*      */   }
/*      */   
/*      */   public boolean merge(Attributes other) {
/* 1996 */     return add(other, null, null, 0, 0, null, true, false, false, null);
/*      */   }
/*      */   
/*      */   public boolean testMerge(Attributes other) {
/* 2000 */     return add(other, null, null, 0, 0, null, true, false, true, null);
/*      */   }
/*      */   
/*      */   public boolean addSelected(Attributes other, Attributes selection) {
/* 2004 */     return add(other, selection.tags, null, 0, selection.size, selection, false, false, false, null);
/*      */   }
/*      */   
/*      */   public boolean addSelected(Attributes other, String privateCreator, int tag) {
/* 2008 */     int index = other.indexOf(privateCreator, tag);
/* 2009 */     if (index < 0)
/* 2010 */       return false; 
/* 2011 */     Object value = other.values[index];
/* 2012 */     if (value instanceof Sequence) {
/* 2013 */       set(privateCreator, tag, (Sequence)value, (Attributes)null);
/* 2014 */     } else if (value instanceof Fragments) {
/* 2015 */       set(privateCreator, tag, (Fragments)value);
/*      */     } else {
/* 2017 */       VR vrTag = other.vrs[index];
/* 2018 */       set(privateCreator, tag, vrTag, toggleEndian(vrTag, value, (this.bigEndian != other.bigEndian)));
/*      */     } 
/*      */     
/* 2021 */     return true;
/*      */   }
/*      */   
/*      */   public boolean addWithoutBulkData(Attributes other, BulkDataDescriptor descriptor) {
/* 2025 */     boolean toggleEndian = (this.bigEndian != other.bigEndian);
/* 2026 */     int[] tags = other.tags;
/* 2027 */     VR[] srcVRTags = other.vrs;
/* 2028 */     Object[] srcValues = other.values;
/* 2029 */     int otherSize = other.size;
/* 2030 */     int numAdd = 0;
/* 2031 */     String privateCreator = null;
/* 2032 */     int creatorTag = 0;
/* 2033 */     ItemPointer[] itemPointer = itemPointers();
/* 2034 */     for (int i = 0; i < otherSize; i++) {
/* 2035 */       int tag = tags[i];
/* 2036 */       VR vrTag = srcVRTags[i];
/* 2037 */       Object value = srcValues[i];
/* 2038 */       if (TagUtils.isPrivateCreator(tag)) {
/* 2039 */         if (contains(tag)) {
/*      */           continue;
/*      */         }
/* 2042 */         if (vrTag == VR.LO) {
/* 2043 */           value = other.decodeStringValue(i);
/* 2044 */           if (value instanceof String && creatorTagOf((String)value, tag, false) != -1) {
/*      */             continue;
/*      */           }
/*      */         } 
/*      */       } 
/* 2049 */       if (TagUtils.isPrivateTag(tag)) {
/* 2050 */         int tmp = TagUtils.creatorTagOf(tag);
/* 2051 */         if (creatorTag != tmp) {
/* 2052 */           creatorTag = tmp;
/* 2053 */           privateCreator = other.privateCreatorOf(tag);
/*      */         } 
/*      */       } else {
/* 2056 */         creatorTag = 0;
/* 2057 */         privateCreator = null;
/*      */       } 
/* 2059 */       int vallen = (value instanceof byte[]) ? ((byte[])value).length : -1;
/*      */ 
/*      */       
/* 2062 */       if (!descriptor.isBulkData(privateCreator, tag, vrTag, vallen, itemPointer)) {
/*      */ 
/*      */         
/* 2065 */         if (value instanceof Sequence) {
/* 2066 */           Sequence src = (Sequence)value;
/* 2067 */           setWithoutBulkData(privateCreator, tag, src, descriptor);
/* 2068 */         } else if (value instanceof Fragments) {
/* 2069 */           set(privateCreator, tag, (Fragments)value);
/*      */         } else {
/* 2071 */           set(privateCreator, tag, vrTag, toggleEndian(vrTag, value, toggleEndian));
/*      */         } 
/*      */         
/* 2074 */         numAdd++;
/*      */       }  continue;
/* 2076 */     }  return (numAdd != 0);
/*      */   }
/*      */ 
/*      */   
/*      */   private void setWithoutBulkData(String privateCreator, int tag, Sequence seq, BulkDataDescriptor descriptor) {
/* 2081 */     Sequence newSequence = newSequence(privateCreator, tag, seq.size());
/* 2082 */     for (Attributes item : seq) {
/* 2083 */       Attributes newItem = new Attributes(this.bigEndian, item.size());
/* 2084 */       newSequence.add(newItem);
/* 2085 */       newItem.addWithoutBulkData(item, descriptor);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addSelected(Attributes other, int... selection) {
/* 2099 */     return addSelected(other, selection, 0, selection.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addSelected(Attributes other, int[] selection, int fromIndex, int toIndex) {
/* 2115 */     return add(other, selection, null, fromIndex, toIndex, null, false, false, false, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean mergeSelected(Attributes other, int... selection) {
/* 2129 */     return add(other, selection, null, 0, selection.length, null, true, false, false, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean testMergeSelected(Attributes other, int... selection) {
/* 2141 */     return add(other, selection, null, 0, selection.length, null, true, false, true, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addNotSelected(Attributes other, int... selection) {
/* 2154 */     return addNotSelected(other, selection, 0, selection.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addNotSelected(Attributes other, int[] selection, int fromIndex, int toIndex) {
/* 2170 */     return add(other, null, selection, fromIndex, toIndex, null, false, false, false, null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean add(Attributes other, int[] include, int[] exclude, int fromIndex, int toIndex, Attributes selection, boolean merge, boolean update, boolean simulate, Attributes modified) {
/* 2176 */     boolean toggleEndian = (this.bigEndian != other.bigEndian);
/* 2177 */     boolean modifiedToggleEndian = (modified != null && this.bigEndian != modified.bigEndian);
/*      */     
/* 2179 */     int[] tags = other.tags;
/* 2180 */     VR[] srcVRTags = other.vrs;
/* 2181 */     Object[] srcValues = other.values;
/* 2182 */     int otherSize = other.size;
/* 2183 */     int numAdd = 0;
/* 2184 */     String privateCreator = null;
/* 2185 */     int creatorTag = 0;
/* 2186 */     for (int i = 0; i < otherSize; i++) {
/* 2187 */       int tag = tags[i];
/* 2188 */       VR vrTag = srcVRTags[i];
/* 2189 */       Object value = srcValues[i];
/* 2190 */       if (TagUtils.isPrivateCreator(tag)) {
/* 2191 */         if (contains(tag)) {
/*      */           continue;
/*      */         }
/* 2194 */         if (vrTag == VR.LO) {
/* 2195 */           value = other.decodeStringValue(i);
/* 2196 */           if (value instanceof String && creatorTagOf((String)value, tag, false) != -1) {
/*      */             continue;
/*      */           }
/*      */         } 
/*      */       } 
/* 2201 */       if (include != null && Arrays.binarySearch(include, fromIndex, toIndex, tag) < 0)
/*      */         continue; 
/* 2203 */       if (exclude != null && Arrays.binarySearch(exclude, fromIndex, toIndex, tag) >= 0)
/*      */         continue; 
/* 2205 */       if (TagUtils.isPrivateTag(tag)) {
/* 2206 */         int tmp = TagUtils.creatorTagOf(tag);
/* 2207 */         if (creatorTag != tmp) {
/* 2208 */           creatorTag = tmp;
/* 2209 */           privateCreator = other.privateCreatorOf(tag);
/*      */         } 
/*      */       } else {
/* 2212 */         creatorTag = 0;
/* 2213 */         privateCreator = null;
/*      */       } 
/* 2215 */       if (merge || update) {
/* 2216 */         int j = indexOf(tag);
/* 2217 */         if (j >= 0) {
/* 2218 */           if (update && equalValues(other, j, i)) {
/*      */             continue;
/*      */           }
/* 2221 */           Object origValue = this.vrs[j].isStringType() ? decodeStringValue(j) : this.values[j];
/*      */ 
/*      */           
/* 2224 */           if (!isEmpty(origValue)) {
/* 2225 */             if (merge) {
/*      */               continue;
/*      */             }
/* 2228 */             if (modified != null) {
/* 2229 */               if (origValue instanceof Sequence) {
/* 2230 */                 modified.set(privateCreator, tag, (Sequence)origValue, (Attributes)null);
/* 2231 */               } else if (origValue instanceof Fragments) {
/* 2232 */                 modified.set(privateCreator, tag, (Fragments)origValue);
/*      */               } else {
/* 2234 */                 modified.set(privateCreator, tag, vrTag, toggleEndian(vrTag, origValue, modifiedToggleEndian));
/*      */               } 
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 2241 */       if (!simulate) {
/* 2242 */         if (value instanceof Sequence) {
/* 2243 */           set(privateCreator, tag, (Sequence)value, (selection != null) ? selection.getNestedDataset(tag) : null);
/*      */ 
/*      */         
/*      */         }
/* 2247 */         else if (value instanceof Fragments) {
/* 2248 */           set(privateCreator, tag, (Fragments)value);
/*      */         } else {
/* 2250 */           set(privateCreator, tag, vrTag, toggleEndian(vrTag, value, toggleEndian));
/*      */         } 
/*      */       }
/*      */       
/* 2254 */       numAdd++; continue;
/*      */     } 
/* 2256 */     return (numAdd != 0);
/*      */   }
/*      */   
/*      */   public boolean update(Attributes newAttrs, Attributes modified) {
/* 2260 */     return add(newAttrs, null, null, 0, 0, null, false, true, false, modified);
/*      */   }
/*      */   
/*      */   public boolean testUpdate(Attributes newAttrs, Attributes modified) {
/* 2264 */     return add(newAttrs, null, null, 0, 0, null, false, true, true, modified);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean updateSelected(Attributes newAttrs, Attributes modified, int... selection) {
/* 2282 */     return add(newAttrs, selection, null, 0, selection.length, null, false, true, false, modified);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean testUpdateSelected(Attributes newAttrs, Attributes modified, int... selection) {
/* 2298 */     return add(newAttrs, selection, null, 0, selection.length, null, false, true, true, modified);
/*      */   }
/*      */ 
/*      */   
/*      */   private static Object toggleEndian(VR vrTag, Object value, boolean toggleEndian) {
/* 2303 */     return (toggleEndian && value instanceof byte[]) ? vrTag.toggleEndian((byte[])value, true) : value;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object o) {
/* 2310 */     if (o == this) {
/* 2311 */       return true;
/*      */     }
/* 2313 */     if (!(o instanceof Attributes)) {
/* 2314 */       return false;
/*      */     }
/* 2316 */     Attributes other = (Attributes)o;
/* 2317 */     if (this.size != other.size) {
/* 2318 */       return false;
/*      */     }
/* 2320 */     int creatorTag = 0;
/* 2321 */     int otherCreatorTag = 0;
/* 2322 */     for (int i = 0; i < this.size; i++) {
/* 2323 */       int tag = this.tags[i];
/* 2324 */       if (!TagUtils.isPrivateGroup(tag)) {
/* 2325 */         if (tag != other.tags[i] || !equalValues(other, i, i))
/* 2326 */           return false; 
/* 2327 */       } else if (TagUtils.isPrivateTag(tag)) {
/* 2328 */         int tmp = TagUtils.creatorTagOf(tag);
/* 2329 */         if (creatorTag != tmp) {
/* 2330 */           creatorTag = tmp;
/* 2331 */           otherCreatorTag = other.creatorTagOf(privateCreatorOf(tag), tag, false);
/* 2332 */           if (otherCreatorTag == -1)
/* 2333 */             return false; 
/*      */         } 
/* 2335 */         int j = other.indexOf(TagUtils.toPrivateTag(otherCreatorTag, tag));
/* 2336 */         if (j < 0 || !equalValues(other, i, j))
/* 2337 */           return false; 
/*      */       } 
/*      */     } 
/* 2340 */     return true;
/*      */   }
/*      */   
/*      */   public Attributes diff(Attributes b, boolean both) {
/* 2344 */     Object[] otherValues = b.values;
/* 2345 */     Attributes inAnotInB = new Attributes();
/* 2346 */     Attributes inBnotInA = new Attributes();
/* 2347 */     Attributes diffBoth = new Attributes();
/* 2348 */     for (int indexOfTag = 0; indexOfTag < this.tags.length && this.tags[indexOfTag] != 0; indexOfTag++) {
/* 2349 */       if (TagUtils.isPrivateGroup(this.tags[indexOfTag]))
/* 2350 */       { if (TagUtils.isPrivateCreator(this.tags[indexOfTag])) {
/*      */           
/* 2352 */           diffAttr(b, otherValues, inAnotInB, indexOfTag);
/*      */         } else {
/*      */           
/* 2355 */           int privateCreatorTag = TagUtils.creatorTagOf(this.tags[indexOfTag]);
/* 2356 */           Object o = getValue(privateCreatorTag);
/* 2357 */           Object o1 = b.values[b.indexOf(privateCreatorTag)];
/* 2358 */           if (b.contains(privateCreatorTag) && o1.equals(o)) {
/* 2359 */             diffAttr(b, otherValues, inAnotInB, indexOfTag);
/*      */           } else {
/* 2361 */             inAnotInB.set(this.tags[indexOfTag], this.vrs[indexOfTag], this.values[indexOfTag]);
/*      */           } 
/*      */         }  }
/* 2364 */       else { diffAttr(b, otherValues, inAnotInB, indexOfTag); }
/*      */     
/*      */     } 
/*      */     
/* 2368 */     inBnotInA.addAll(filterOutPrivateCreator(inAnotInB, b));
/* 2369 */     if (both) {
/* 2370 */       diffBoth.addAll(inAnotInB);
/* 2371 */       diffBoth.addAll(inBnotInA);
/*      */     } 
/* 2373 */     return both ? diffBoth : inAnotInB;
/*      */   }
/*      */   
/*      */   private Attributes filterOutPrivateCreator(Attributes inAnotInB, Attributes b) {
/* 2377 */     for (int tag : b.tags) {
/* 2378 */       if (!inAnotInB.contains(tag) && TagUtils.isPrivateCreator(tag))
/* 2379 */         b.remove(tag); 
/* 2380 */     }  return b;
/*      */   }
/*      */ 
/*      */   
/*      */   private void diffAttr(Attributes b, Object[] otherValues, Attributes inAnotInB, int indexOfTag) {
/* 2385 */     if (!b.contains(this.tags[indexOfTag]) || !otherValues[b.indexOf(this.tags[indexOfTag])].equals(this.values[indexOfTag])) {
/*      */       
/* 2387 */       inAnotInB.set(this.tags[indexOfTag], this.vrs[indexOfTag], this.values[indexOfTag]);
/*      */     }
/* 2389 */     else if (!TagUtils.isPrivateCreator(this.tags[indexOfTag])) {
/* 2390 */       b.remove(this.tags[indexOfTag]);
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean equalValues(Attributes other, int index, int otherIndex) {
/* 2395 */     VR vrTag = this.vrs[index];
/* 2396 */     if (vrTag != other.vrs[otherIndex])
/* 2397 */       return false; 
/* 2398 */     if (vrTag.isStringType()) {
/* 2399 */       if (vrTag == VR.IS)
/* 2400 */         return equalISValues(other, index, otherIndex); 
/* 2401 */       if (vrTag == VR.DS) {
/* 2402 */         return equalDSValues(other, index, otherIndex);
/*      */       }
/* 2404 */       return equalStringValues(other, index, otherIndex);
/* 2405 */     }  Object v1 = this.values[index];
/* 2406 */     Object v2 = other.values[otherIndex];
/* 2407 */     if (v1 instanceof byte[]) {
/* 2408 */       if (v2 instanceof byte[] && ((byte[])v1).length == ((byte[])v2).length) {
/* 2409 */         if (this.bigEndian != other.bigEndian)
/* 2410 */           v2 = vrTag.toggleEndian((byte[])v2, true);
/* 2411 */         return Arrays.equals((byte[])v1, (byte[])v2);
/*      */       } 
/*      */     } else {
/* 2414 */       return v1.equals(v2);
/* 2415 */     }  return false;
/*      */   }
/*      */   
/*      */   private boolean equalISValues(Attributes other, int index, int otherIndex) {
/*      */     try {
/* 2420 */       return Arrays.equals(decodeISValue(index), other.decodeISValue(otherIndex));
/* 2421 */     } catch (NumberFormatException e) {
/* 2422 */       return equalStringValues(other, index, otherIndex);
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean equalDSValues(Attributes other, int index, int otherIndex) {
/*      */     try {
/* 2428 */       return Arrays.equals(decodeDSValue(index), other.decodeDSValue(otherIndex));
/* 2429 */     } catch (NumberFormatException e) {
/* 2430 */       return equalStringValues(other, index, otherIndex);
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean equalStringValues(Attributes other, int index, int otherIndex) {
/* 2435 */     Object v1 = decodeStringValue(index);
/* 2436 */     Object v2 = other.decodeStringValue(otherIndex);
/* 2437 */     if (v1 instanceof String[]) {
/* 2438 */       if (v2 instanceof String[])
/* 2439 */         return Arrays.equals((Object[])v1, (Object[])v2); 
/*      */     } else {
/* 2441 */       return v1.equals(v2);
/* 2442 */     }  return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 2447 */     int h = 0;
/* 2448 */     for (int i = 0; i < this.size; i++) {
/* 2449 */       int tag = this.tags[i];
/* 2450 */       if (!TagUtils.isPrivateGroup(tag))
/* 2451 */         h = 31 * h + tag; 
/*      */     } 
/* 2453 */     return h;
/*      */   }
/*      */ 
/*      */   
/*      */   private void set(String privateCreator, int tag, Sequence src, Attributes selection) {
/* 2458 */     Sequence dst = newSequence(privateCreator, tag, src.size());
/* 2459 */     for (Attributes item : src) {
/* 2460 */       dst.add((selection != null && !selection.isEmpty()) ? new Attributes(item, this.bigEndian, selection) : new Attributes(item, this.bigEndian));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void set(String privateCreator, int tag, Fragments src) {
/* 2466 */     boolean toogleEndian = (src.bigEndian() != this.bigEndian);
/* 2467 */     VR vrTag = src.vr();
/* 2468 */     Fragments dst = newFragments(privateCreator, tag, vrTag, src.size());
/* 2469 */     for (Object frag : src) {
/* 2470 */       dst.add(toggleEndian(vrTag, frag, toogleEndian));
/*      */     }
/*      */   }
/*      */   
/*      */   public String toString() {
/* 2475 */     return toString(50, 78);
/*      */   }
/*      */   
/*      */   public String toString(int limit, int maxWidth) {
/* 2479 */     return toStringBuilder(limit, maxWidth, new StringBuilder(1024)).toString();
/*      */   }
/*      */ 
/*      */   
/*      */   public StringBuilder toStringBuilder(StringBuilder sb) {
/* 2484 */     return toStringBuilder(50, 78, sb);
/*      */   }
/*      */   
/*      */   public StringBuilder toStringBuilder(int limit, int maxWidth, StringBuilder sb) {
/* 2488 */     if (appendAttributes(limit, maxWidth, sb, "") > limit)
/* 2489 */       sb.append("...\n"); 
/* 2490 */     return sb;
/*      */   }
/*      */   
/*      */   private int appendAttributes(int limit, int maxWidth, StringBuilder sb, String prefix) {
/* 2494 */     int lines = 0;
/* 2495 */     int creatorTag = 0;
/* 2496 */     String privateCreator = null;
/* 2497 */     for (int i = 0; i < this.size && 
/* 2498 */       ++lines <= limit; i++) {
/*      */       
/* 2500 */       int tag = this.tags[i];
/* 2501 */       if (TagUtils.isPrivateTag(tag)) {
/* 2502 */         int tmp = TagUtils.creatorTagOf(tag);
/* 2503 */         if (creatorTag != tmp) {
/* 2504 */           creatorTag = tmp;
/* 2505 */           privateCreator = getString(creatorTag, (String)null);
/*      */         } 
/*      */       } else {
/* 2508 */         creatorTag = 0;
/* 2509 */         privateCreator = null;
/*      */       } 
/* 2511 */       Object value = this.values[i];
/* 2512 */       appendAttribute(privateCreator, tag, this.vrs[i], value, sb.length() + maxWidth, sb, prefix);
/*      */       
/* 2514 */       if (value instanceof Sequence)
/* 2515 */         lines += appendItems((Sequence)value, limit - lines, maxWidth, sb, prefix + '>'); 
/*      */     } 
/* 2517 */     return lines;
/*      */   }
/*      */ 
/*      */   
/*      */   private int appendItems(Sequence sq, int limit, int maxWidth, StringBuilder sb, String prefix) {
/* 2522 */     int lines = 0;
/* 2523 */     int itemNo = 0;
/* 2524 */     for (Attributes item : sq) {
/* 2525 */       if (++lines > limit)
/*      */         break; 
/* 2527 */       sb.append(prefix).append("Item #").append(++itemNo).append('\n');
/* 2528 */       lines += item.appendAttributes(limit - lines, maxWidth, sb, prefix);
/*      */     } 
/* 2530 */     return lines;
/*      */   }
/*      */ 
/*      */   
/*      */   private StringBuilder appendAttribute(String privateCreator, int tag, VR vrTag, Object value, int maxLength, StringBuilder sb, String prefix) {
/* 2535 */     sb.append(prefix).append(TagUtils.toString(tag)).append(' ').append(vrTag).append(" [");
/* 2536 */     if (vrTag.prompt(value, this.bigEndian, getSpecificCharacterSet(vrTag), maxLength - sb.length() - 1, sb)) {
/*      */       
/* 2538 */       sb.append("] ").append(ElementDictionary.keywordOf(tag, privateCreator));
/* 2539 */       if (sb.length() > maxLength)
/* 2540 */         sb.setLength(maxLength); 
/* 2541 */       sb.append('\n');
/*      */     } 
/* 2543 */     return sb;
/*      */   }
/*      */   
/*      */   public int calcLength(DicomEncodingOptions encOpts, boolean explicitVR) {
/* 2547 */     if (isEmpty()) {
/* 2548 */       return 0;
/*      */     }
/* 2550 */     this.groupLengths = encOpts.groupLength ? new int[countGroups()] : null;
/*      */ 
/*      */     
/* 2553 */     this.length = calcLength(encOpts, explicitVR, getSpecificCharacterSet(), this.groupLengths);
/*      */     
/* 2555 */     return this.length;
/*      */   }
/*      */ 
/*      */   
/*      */   private int calcLength(DicomEncodingOptions encOpts, boolean explicitVR, SpecificCharacterSet cs, int[] groupLengths) {
/* 2560 */     int totlen = 0;
/* 2561 */     int groupLengthTag = -1;
/* 2562 */     int groupLengthIndex = -1;
/*      */ 
/*      */     
/* 2565 */     for (int i = 0; i < this.size; i++) {
/* 2566 */       VR vrTag = this.vrs[i];
/* 2567 */       Object val = this.values[i];
/* 2568 */       int len = explicitVR ? vrTag.headerLength() : 8;
/* 2569 */       if (val instanceof Value) {
/* 2570 */         len += ((Value)val).calcLength(encOpts, explicitVR, vrTag);
/*      */       } else {
/* 2572 */         if (!(val instanceof byte[]))
/* 2573 */           this.values[i] = val = vrTag.toBytes(val, cs);
/* 2574 */         len += ((byte[])val).length + 1 & 0xFFFFFFFE;
/*      */       } 
/* 2576 */       totlen += len;
/* 2577 */       if (groupLengths != null) {
/* 2578 */         int tmp = TagUtils.groupLengthTagOf(this.tags[i]);
/* 2579 */         if (groupLengthTag != tmp) {
/* 2580 */           groupLengthTag = tmp;
/* 2581 */           groupLengthIndex++;
/* 2582 */           totlen += 12;
/*      */         } 
/* 2584 */         groupLengths[groupLengthIndex] = groupLengths[groupLengthIndex] + len;
/*      */       } 
/*      */     } 
/* 2587 */     return totlen;
/*      */   }
/*      */   
/*      */   private int countGroups() {
/* 2591 */     int groupLengthTag = -1;
/* 2592 */     int count = 0;
/* 2593 */     for (int i = 0; i < this.size; i++) {
/* 2594 */       int tmp = TagUtils.groupLengthTagOf(this.tags[i]);
/* 2595 */       if (groupLengthTag != tmp) {
/* 2596 */         if (groupLengthTag < 0)
/* 2597 */           this.groupLengthIndex0 = count; 
/* 2598 */         groupLengthTag = tmp;
/* 2599 */         count++;
/*      */       } 
/*      */     } 
/* 2602 */     return count;
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeTo(DicomOutputStream out) throws IOException {
/* 2607 */     if (isEmpty()) {
/*      */       return;
/*      */     }
/* 2610 */     if (this.groupLengths == null && (out.getEncodingOptions()).groupLength) {
/* 2611 */       throw new IllegalStateException("groupLengths not initialized by calcLength()");
/*      */     }
/*      */     
/* 2614 */     SpecificCharacterSet cs = getSpecificCharacterSet();
/* 2615 */     if (this.tags[0] < 0) {
/* 2616 */       int index0 = -(1 + indexOf(0));
/* 2617 */       writeTo(out, cs, index0, this.size, this.groupLengthIndex0);
/* 2618 */       writeTo(out, cs, 0, index0, 0);
/*      */     } else {
/* 2620 */       writeTo(out, cs, 0, this.size, 0);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void writeItemTo(DicomOutputStream out) throws IOException {
/* 2625 */     DicomEncodingOptions encOpts = out.getEncodingOptions();
/* 2626 */     int len = getEncodedItemLength(encOpts, out.isExplicitVR());
/* 2627 */     out.writeHeader(-73728, null, len);
/* 2628 */     writeTo(out);
/* 2629 */     if (len == -1) {
/* 2630 */       out.writeHeader(-73715, null, 0);
/*      */     }
/*      */   }
/*      */   
/*      */   private int getEncodedItemLength(DicomEncodingOptions encOpts, boolean explicitVR) {
/* 2635 */     if (isEmpty()) {
/* 2636 */       return encOpts.undefEmptyItemLength ? -1 : 0;
/*      */     }
/* 2638 */     if (encOpts.undefItemLength) {
/* 2639 */       return -1;
/*      */     }
/* 2641 */     if (this.length == -1) {
/* 2642 */       calcLength(encOpts, explicitVR);
/*      */     }
/* 2644 */     return this.length;
/*      */   }
/*      */ 
/*      */   
/*      */   private void writeTo(DicomOutputStream out, SpecificCharacterSet cs, int start, int end, int groupLengthIndex) throws IOException {
/* 2649 */     boolean groupLength = (this.groupLengths != null);
/* 2650 */     int groupLengthTag = -1;
/* 2651 */     for (int i = start; i < end; i++) {
/* 2652 */       int tag = this.tags[i];
/* 2653 */       if (groupLength) {
/* 2654 */         int tmp = TagUtils.groupLengthTagOf(tag);
/* 2655 */         if (groupLengthTag != tmp) {
/* 2656 */           groupLengthTag = tmp;
/* 2657 */           out.writeGroupLength(groupLengthTag, this.groupLengths[groupLengthIndex++]);
/*      */         } 
/*      */       } 
/*      */       
/* 2661 */       out.writeAttribute(tag, this.vrs[i], this.values[i], cs);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean accept(Visitor visitor, boolean visitNestedDatasets) throws Exception {
/* 2675 */     if (isEmpty()) {
/* 2676 */       return true;
/*      */     }
/* 2678 */     if (this.tags[0] < 0) {
/* 2679 */       int index0 = -(1 + indexOf(0));
/* 2680 */       return (accept(visitor, visitNestedDatasets, index0, this.size) && accept(visitor, visitNestedDatasets, 0, index0));
/*      */     } 
/*      */     
/* 2683 */     return accept(visitor, visitNestedDatasets, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean accept(Visitor visitor, boolean visitNestedDatasets, int start, int end) throws Exception {
/* 2689 */     for (int i = start; i < end; i++) {
/* 2690 */       if (!visitor.visit(this, this.tags[i], this.vrs[i], this.values[i]))
/* 2691 */         return false; 
/* 2692 */       if (visitNestedDatasets && this.values[i] instanceof Sequence)
/* 2693 */         for (Attributes item : (Sequence) this.values[i]) {
/* 2694 */           if (!item.accept(visitor, true)) {
/* 2695 */             return false;
/*      */           }
/*      */         }  
/*      */     } 
/* 2699 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeGroupTo(DicomOutputStream out, int groupLengthTag) throws IOException {
/* 2704 */     if (isEmpty()) {
/* 2705 */       throw new IllegalStateException("No attributes");
/*      */     }
/* 2707 */     checkInGroup(0, groupLengthTag);
/* 2708 */     checkInGroup(this.size - 1, groupLengthTag);
/* 2709 */     SpecificCharacterSet cs = getSpecificCharacterSet();
/* 2710 */     out.writeGroupLength(groupLengthTag, calcLength(out.getEncodingOptions(), out.isExplicitVR(), cs, null));
/*      */     
/* 2712 */     writeTo(out, cs, 0, this.size, 0);
/*      */   }
/*      */ 
/*      */   
/*      */   private void checkInGroup(int i, int groupLengthTag) {
/* 2717 */     int tag = this.tags[i];
/* 2718 */     if (TagUtils.groupLengthTagOf(tag) != groupLengthTag) {
/* 2719 */       throw new IllegalStateException(TagUtils.toString(tag) + " does not belong to group (" + TagUtils.shortToHexString(TagUtils.groupNumber(groupLengthTag)) + ",eeee).");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Attributes createFileMetaInformation(String tsuid) {
/* 2728 */     return createFileMetaInformation(getString(524312, (String)null), getString(524310, (String)null), tsuid);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Attributes createFileMetaInformation(String iuid, String cuid, String tsuid) {
/* 2736 */     if (iuid.isEmpty() || cuid.isEmpty() || tsuid.isEmpty()) {
/* 2737 */       throw new IllegalArgumentException();
/*      */     }
/* 2739 */     Attributes fmi = new Attributes(6);
/* 2740 */     fmi.setBytes(131073, VR.OB, new byte[] { 0, 1 });
/*      */     
/* 2742 */     fmi.setString(131074, VR.UI, cuid);
/* 2743 */     fmi.setString(131075, VR.UI, iuid);
/* 2744 */     fmi.setString(131088, VR.UI, tsuid);
/* 2745 */     fmi.setString(131090, VR.UI, Implementation.getClassUID());
/*      */     
/* 2747 */     fmi.setString(131091, VR.SH, Implementation.getVersionName());
/*      */     
/* 2749 */     return fmi;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean matches(Attributes keys, boolean ignorePNCase, boolean matchNoValue) {
/* 2754 */     int[] keyTags = keys.tags;
/* 2755 */     VR[] keyVrTags = keys.vrs;
/* 2756 */     Object[] keyValues = keys.values;
/* 2757 */     int keysSize = keys.size;
/* 2758 */     String privateCreator = null;
/* 2759 */     int creatorTag = 0;
/* 2760 */     for (int i = 0; i < keysSize; i++) {
/* 2761 */       int tag = keyTags[i];
/* 2762 */       if (!TagUtils.isPrivateCreator(tag)) {
/*      */ 
/*      */         
/* 2765 */         if (TagUtils.isPrivateGroup(tag)) {
/* 2766 */           int tmp = TagUtils.creatorTagOf(tag);
/* 2767 */           if (creatorTag != tmp) {
/* 2768 */             creatorTag = tmp;
/* 2769 */             privateCreator = keys.getString(creatorTag, (String)null);
/*      */           } 
/*      */         } else {
/* 2772 */           creatorTag = 0;
/* 2773 */           privateCreator = null;
/*      */         } 
/*      */         
/* 2776 */         Object keyValue = keyValues[i];
/* 2777 */         if (!isEmpty(keyValue))
/*      */         {
/*      */           
/* 2780 */           if (keyVrTags[i].isStringType()) {
/* 2781 */             if (!matches(privateCreator, tag, keyVrTags[i], ignorePNCase, matchNoValue, keys.getStrings(privateCreator, tag, null)))
/*      */             {
/* 2783 */               return false; } 
/* 2784 */           } else if (keyValue instanceof Sequence) {
/* 2785 */             if (!matches(privateCreator, tag, ignorePNCase, matchNoValue, (Sequence)keyValue))
/*      */             {
/* 2787 */               return false; } 
/*      */           } else {
/* 2789 */             throw new UnsupportedOperationException("Keys with VR: " + keyVrTags[i] + " not supported");
/*      */           }  } 
/*      */       } 
/*      */     } 
/* 2793 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean matches(String privateCreator, int tag, VR vrTag, boolean ignorePNCase, boolean matchNoValue, String[] keyVals) {
/* 2798 */     String[] vals = getStrings(privateCreator, tag, null);
/* 2799 */     if (vals == null || vals.length == 0) {
/* 2800 */       return matchNoValue;
/*      */     }
/* 2802 */     boolean ignoreCase = (ignorePNCase && vrTag == VR.PN);
/* 2803 */     for (String keyVal : keyVals) {
/* 2804 */       if (vrTag == VR.PN) {
/* 2805 */         keyVal = (new PersonName(keyVals[0])).toString();
/*      */       }
/* 2807 */       if (StringUtils.containsWildCard(keyVal))
/* 2808 */       { Pattern pattern = StringUtils.compilePattern(keyVal, ignoreCase);
/* 2809 */         for (String val : vals) {
/* 2810 */           if (val == null) {
/* 2811 */             if (matchNoValue) {
/* 2812 */               return true;
/*      */             }
/*      */           } else {
/* 2815 */             if (vrTag == VR.PN)
/* 2816 */               val = (new PersonName(val)).toString(); 
/* 2817 */             if (pattern.matcher(val).matches())
/* 2818 */               return true; 
/*      */           } 
/*      */         }  }
/* 2821 */       else { for (String val : vals) {
/* 2822 */           if (val == null) {
/* 2823 */             if (matchNoValue) {
/* 2824 */               return true;
/*      */             }
/*      */           } else {
/* 2827 */             if (vrTag == VR.PN)
/* 2828 */               val = (new PersonName(val)).toString(); 
/* 2829 */             if (ignoreCase ? keyVal.equalsIgnoreCase(val) : keyVal.equals(val))
/*      */             {
/* 2831 */               return true; } 
/*      */           } 
/*      */         }  }
/*      */     
/* 2835 */     }  return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean matches(String privateCreator, int tag, boolean ignorePNCase, boolean matchNoValue, Sequence keySeq) {
/* 2840 */     int n = keySeq.size();
/* 2841 */     if (n > 1) {
/* 2842 */       throw new IllegalArgumentException("Keys contain Sequence " + TagUtils.toString(tag) + " with " + n + " Items");
/*      */     }
/*      */     
/* 2845 */     Attributes keys = keySeq.get(0);
/* 2846 */     if (keys.isEmpty()) {
/* 2847 */       return true;
/*      */     }
/* 2849 */     Object value = getValue(privateCreator, tag);
/* 2850 */     if (value == null || isEmpty(value)) {
/* 2851 */       return matchNoValue;
/*      */     }
/* 2853 */     if (value instanceof Sequence) {
/* 2854 */       Sequence sq = (Sequence)value;
/* 2855 */       for (Attributes item : sq) {
/* 2856 */         if (item.matches(keys, ignorePNCase, matchNoValue))
/* 2857 */           return true; 
/*      */       } 
/* 2859 */     }  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void writeObject(ObjectOutputStream out) throws IOException {
/* 2865 */     out.defaultWriteObject();
/* 2866 */     out.writeInt(this.size);
/*      */     
/* 2868 */     DicomOutputStream dout = new DicomOutputStream(out, this.bigEndian ? "1.2.840.10008.1.2.2" : "1.2.840.10008.1.2.1");
/*      */ 
/*      */     
/* 2871 */     dout.writeDataset(null, this);
/* 2872 */     dout.writeHeader(-73715, null, 0);
/*      */   }
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
/* 2877 */     in.defaultReadObject();
/* 2878 */     init(in.readInt());
/*      */     
/* 2880 */     DicomInputStream din = new DicomInputStream(in, this.bigEndian ? "1.2.840.10008.1.2.2" : "1.2.840.10008.1.2.1");
/*      */ 
/*      */     
/* 2883 */     din.readAttributes(this, -1, -73715);
/*      */   }
/*      */   
/*      */   public ValidationResult validate(IOD iod) {
/* 2887 */     ValidationResult result = new ValidationResult();
/* 2888 */     HashMap<String, Boolean> resolvedConditions = new HashMap<String, Boolean>();
/* 2889 */     for (IOD.DataElement el : iod) {
/* 2890 */       validate(el, result, resolvedConditions);
/*      */     }
/* 2892 */     return result;
/*      */   }
/*      */   
/*      */   public void validate(IOD.DataElement el, ValidationResult result) {
/* 2896 */     validate(el, result, null);
/*      */   }
/*      */ 
/*      */   
/*      */   private void validate(IOD.DataElement el, ValidationResult result, Map<String, Boolean> processedConditions) {
/* 2901 */     IOD.Condition condition = el.getCondition();
/* 2902 */     if (condition != null) {
/* 2903 */       String id = condition.id();
/* 2904 */       Boolean match = (id != null) ? processedConditions.get(id) : null;
/* 2905 */       if (match == null) {
/* 2906 */         match = Boolean.valueOf(condition.match(this));
/* 2907 */         if (id != null)
/* 2908 */           processedConditions.put(id, match); 
/*      */       } 
/* 2910 */       if (!match.booleanValue())
/*      */         return; 
/*      */     } 
/* 2913 */     int index = indexOf(el.tag);
/* 2914 */     if (index < 0) {
/* 2915 */       if (el.type == IOD.DataElementType.TYPE_1 || el.type == IOD.DataElementType.TYPE_2)
/*      */       {
/* 2917 */         result.addMissingAttribute(el);
/*      */       }
/*      */       return;
/*      */     } 
/* 2921 */     Object value = this.values[index];
/* 2922 */     if (isEmpty(value)) {
/* 2923 */       if (el.type == IOD.DataElementType.TYPE_1) {
/* 2924 */         result.addMissingAttributeValue(el);
/*      */       }
/*      */       return;
/*      */     } 
/* 2928 */     if (el.type == IOD.DataElementType.TYPE_0) {
/* 2929 */       result.addNotAllowedAttribute(el);
/*      */       return;
/*      */     } 
/* 2932 */     VR vrTag = this.vrs[index];
/* 2933 */     if (vrTag.isStringType()) {
/* 2934 */       value = decodeStringValue(index);
/*      */     }
/*      */     
/* 2937 */     Object validVals = el.getValues();
/* 2938 */     if (el.vr == VR.SQ) {
/* 2939 */       if (!(value instanceof Sequence)) {
/* 2940 */         result.addInvalidAttributeValue(el, ValidationResult.Invalid.VR);
/*      */         return;
/*      */       } 
/* 2943 */       Sequence seq = (Sequence)value;
/* 2944 */       int seqSize = seq.size();
/* 2945 */       if (el.maxVM > 0 && seqSize > el.maxVM) {
/* 2946 */         result.addInvalidAttributeValue(el, ValidationResult.Invalid.MultipleItems);
/*      */         
/*      */         return;
/*      */       } 
/* 2950 */       if (validVals instanceof Code[]) {
/* 2951 */         boolean invalidItem = false;
/* 2952 */         ValidationResult[] itemValidationResults = new ValidationResult[seqSize];
/* 2953 */         for (int i = 0; i < seqSize; i++) {
/* 2954 */           ValidationResult itemValidationResult = validateCode(seq.get(i), (Code[])validVals);
/*      */           
/* 2956 */           invalidItem = (invalidItem || !itemValidationResult.isValid());
/* 2957 */           itemValidationResults[i] = itemValidationResult;
/*      */         } 
/* 2959 */         if (invalidItem) {
/* 2960 */           result.addInvalidAttributeValue(el, ValidationResult.Invalid.Code, itemValidationResults, null);
/*      */         }
/*      */       }
/* 2963 */       else if (validVals instanceof IOD[]) {
/* 2964 */         IOD[] itemIODs = (IOD[])validVals;
/* 2965 */         int[] matchingItems = new int[itemIODs.length];
/* 2966 */         boolean invalidItem = false;
/* 2967 */         ValidationResult[] itemValidationResults = new ValidationResult[seqSize];
/* 2968 */         for (int i = 0; i < seqSize; i++) {
/* 2969 */           ValidationResult itemValidationResult = new ValidationResult();
/* 2970 */           HashMap<String, Boolean> resolvedItemConditions = new HashMap<String, Boolean>();
/*      */           
/* 2972 */           Attributes item = seq.get(i);
/* 2973 */           for (int j = 0; j < itemIODs.length; j++) {
/* 2974 */             IOD itemIOD = itemIODs[j];
/* 2975 */             IOD.Condition itemCondition = itemIOD.getCondition();
/* 2976 */             if (itemCondition != null) {
/* 2977 */               String id = itemCondition.id();
/* 2978 */               Boolean match = (id != null) ? resolvedItemConditions.get(id) : null;
/* 2979 */               if (match == null) {
/* 2980 */                 match = Boolean.valueOf(itemCondition.match(item));
/* 2981 */                 if (id != null)
/* 2982 */                   resolvedItemConditions.put(id, match); 
/*      */               } 
/* 2984 */               if (!match.booleanValue())
/*      */                 continue; 
/*      */             } 
/* 2987 */             matchingItems[j] = matchingItems[j] + 1;
/* 2988 */             for (IOD.DataElement itemEl : itemIOD)
/* 2989 */               item.validate(itemEl, itemValidationResult, resolvedItemConditions); 
/*      */             continue;
/*      */           } 
/* 2992 */           invalidItem = (invalidItem || !itemValidationResult.isValid());
/* 2993 */           itemValidationResults[i] = itemValidationResult;
/*      */         } 
/* 2995 */         IOD[] missingItems = checkforMissingItems(matchingItems, itemIODs);
/* 2996 */         if (invalidItem || missingItems != null) {
/* 2997 */           result.addInvalidAttributeValue(el, ValidationResult.Invalid.Item, itemValidationResults, missingItems);
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 3005 */     if (el.maxVM > 0 || el.minVM > 1) {
/* 3006 */       int vm = vrTag.vmOf(value);
/* 3007 */       if ((el.maxVM > 0 && vm > el.maxVM) || (el.minVM > 1 && vm < el.minVM)) {
/*      */         
/* 3009 */         result.addInvalidAttributeValue(el, ValidationResult.Invalid.VM);
/*      */         return;
/*      */       } 
/*      */     } 
/* 3013 */     if (validVals == null) {
/*      */       return;
/*      */     }
/* 3016 */     if (validVals instanceof String[]) {
/* 3017 */       if (!vrTag.isStringType()) {
/* 3018 */         result.addInvalidAttributeValue(el, ValidationResult.Invalid.VR);
/*      */         return;
/*      */       } 
/* 3021 */       if (!isValidValue(toStrings(value), el.valueNumber, (String[])validVals)) {
/* 3022 */         result.addInvalidAttributeValue(el, ValidationResult.Invalid.Value);
/*      */       }
/* 3024 */     } else if (validVals instanceof int[]) {
/* 3025 */       if (vrTag == VR.IS) {
/* 3026 */         value = decodeISValue(index);
/* 3027 */       } else if (!vrTag.isIntType()) {
/* 3028 */         result.addInvalidAttributeValue(el, ValidationResult.Invalid.VR);
/*      */         return;
/*      */       } 
/* 3031 */       if (!isValidValue(vrTag.toInts(value, this.bigEndian), el.valueNumber, (int[])validVals)) {
/* 3032 */         result.addInvalidAttributeValue(el, ValidationResult.Invalid.Value);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private IOD[] checkforMissingItems(int[] matchingItems, IOD[] itemIODs) {
/* 3038 */     IOD[] missingItems = new IOD[matchingItems.length];
/* 3039 */     int n = 0;
/* 3040 */     for (int i = 0; i < matchingItems.length; i++) {
/* 3041 */       IOD itemIOD = itemIODs[i];
/* 3042 */       if (matchingItems[i] == 0 && itemIOD.getType() == IOD.DataElementType.TYPE_1)
/*      */       {
/* 3044 */         missingItems[n++] = itemIOD; } 
/*      */     } 
/* 3046 */     return (n > 0) ? Arrays.<IOD>copyOf(missingItems, n) : null;
/*      */   }
/*      */   
/*      */   private ValidationResult validateCode(Attributes item, Code[] validVals) {
/* 3050 */     ValidationResult result = null;
/* 3051 */     for (Code code : validVals) {
/* 3052 */       result = item.validate(IOD.valueOf(code));
/* 3053 */       if (result.isValid())
/*      */         break; 
/*      */     } 
/* 3056 */     return result;
/*      */   }
/*      */   
/*      */   private boolean isValidValue(String[] val, int valueNumber, String[] validVals) {
/* 3060 */     if (valueNumber != 0) {
/* 3061 */       return (val.length < valueNumber || isOneOf(val[valueNumber - 1], validVals));
/*      */     }
/* 3063 */     for (int i = 0; i < val.length; i++) {
/* 3064 */       if (!isOneOf(val[i], validVals))
/* 3065 */         return false; 
/* 3066 */     }  return true;
/*      */   }
/*      */   
/*      */   private <T> boolean isOneOf(Object val, T[] ss) {
/* 3070 */     if (ss == null)
/* 3071 */       return true; 
/* 3072 */     for (T s : ss) {
/* 3073 */       if (val.equals(s))
/* 3074 */         return true; 
/* 3075 */     }  return false;
/*      */   }
/*      */   
/*      */   private boolean isValidValue(int[] val, int valueNumber, int[] validVals) {
/* 3079 */     if (valueNumber != 0) {
/* 3080 */       return (val.length < valueNumber || isOneOf(val[valueNumber - 1], validVals));
/*      */     }
/* 3082 */     for (int i = 0; i < val.length; i++) {
/* 3083 */       if (!isOneOf(val[i], validVals))
/* 3084 */         return false; 
/* 3085 */     }  return true;
/*      */   }
/*      */   
/*      */   private boolean isOneOf(int val, int[] is) {
/* 3089 */     if (is == null)
/* 3090 */       return true; 
/* 3091 */     for (int i : is) {
/* 3092 */       if (val == i)
/* 3093 */         return true; 
/* 3094 */     }  return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Attributes getModified(Attributes other, Attributes result) {
/* 3107 */     if (result == null)
/* 3108 */       result = new Attributes(other.size); 
/* 3109 */     int creatorTag = -1;
/* 3110 */     int prevOtherCreatorTag = -1;
/* 3111 */     int otherCreatorTag = -1;
/* 3112 */     String privateCreator = null;
/* 3113 */     for (int i = 0; i < other.size; i++) {
/* 3114 */       int tag = other.tags[i];
/* 3115 */       if ((tag & 0x10000) != 0) {
/* 3116 */         if ((tag & 0xFF00) == 0) {
/*      */           continue;
/*      */         }
/* 3119 */         otherCreatorTag = TagUtils.creatorTagOf(tag);
/* 3120 */         if (prevOtherCreatorTag != otherCreatorTag) {
/* 3121 */           prevOtherCreatorTag = otherCreatorTag;
/* 3122 */           creatorTag = -1;
/* 3123 */           int k = other.indexOf(otherCreatorTag);
/* 3124 */           if (k >= 0) {
/* 3125 */             Object o = other.decodeStringValue(k);
/* 3126 */             if (o instanceof String) {
/* 3127 */               privateCreator = (String)o;
/* 3128 */               creatorTag = creatorTagOf(privateCreator, tag, false);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/* 3133 */         if (creatorTag == -1) {
/*      */           continue;
/*      */         }
/* 3136 */         tag = TagUtils.toPrivateTag(creatorTag, tag);
/*      */       } else {
/* 3138 */         privateCreator = null;
/*      */       } 
/*      */       
/* 3141 */       int j = indexOf(tag);
/* 3142 */       if (j >= 0) {
/*      */ 
/*      */         
/* 3145 */         Object origValue = this.values[j];
/* 3146 */         if (!(origValue instanceof Value) || !((Value)origValue).isEmpty())
/*      */         {
/*      */           
/* 3149 */           if (!equalValues(other, j, i))
/*      */           {
/*      */             
/* 3152 */             if (origValue instanceof Sequence) {
/* 3153 */               result.set(privateCreator, tag, (Sequence)origValue, (Attributes)null);
/* 3154 */             } else if (origValue instanceof Fragments) {
/* 3155 */               result.set(privateCreator, tag, (Fragments)origValue);
/*      */             } else {
/* 3157 */               result.set(privateCreator, tag, this.vrs[i], origValue);
/*      */             }  }  } 
/*      */       }  continue;
/* 3160 */     }  return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Attributes getRemovedOrModified(Attributes other) {
/* 3172 */     Attributes modified = new Attributes(this.size);
/* 3173 */     int creatorTag = -1;
/* 3174 */     int prevCreatorTag = -1;
/* 3175 */     int otherCreatorTag = 0;
/* 3176 */     String privateCreator = null;
/* 3177 */     for (int i = 0; i < this.size; i++) {
/* 3178 */       int tag = this.tags[i];
/* 3179 */       if ((tag & 0x10000) != 0) {
/* 3180 */         if ((tag & 0xFF00) == 0) {
/*      */           continue;
/*      */         }
/* 3183 */         creatorTag = TagUtils.creatorTagOf(tag);
/* 3184 */         if (prevCreatorTag != creatorTag) {
/* 3185 */           prevCreatorTag = creatorTag;
/* 3186 */           otherCreatorTag = -1;
/* 3187 */           privateCreator = null;
/* 3188 */           int k = indexOf(creatorTag);
/* 3189 */           if (k >= 0) {
/* 3190 */             Object o = decodeStringValue(k);
/* 3191 */             if (o instanceof String) {
/* 3192 */               privateCreator = (String)o;
/* 3193 */               otherCreatorTag = other.creatorTagOf(privateCreator, tag, false);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/* 3198 */         if (privateCreator == null) {
/*      */           continue;
/*      */         }
/* 3201 */         if (otherCreatorTag != -1)
/* 3202 */           tag = TagUtils.toPrivateTag(otherCreatorTag, tag); 
/*      */       } else {
/* 3204 */         otherCreatorTag = 0;
/* 3205 */         privateCreator = null;
/*      */       } 
/*      */       
/* 3208 */       Object origValue = this.values[i];
/* 3209 */       if (origValue instanceof Value && ((Value)origValue).isEmpty()) {
/*      */         continue;
/*      */       }
/* 3212 */       if (otherCreatorTag >= 0) {
/* 3213 */         int j = other.indexOf(tag);
/* 3214 */         if (j >= 0 && equalValues(other, i, j)) {
/*      */           continue;
/*      */         }
/*      */       } 
/* 3218 */       if (origValue instanceof Sequence) {
/* 3219 */         modified.set(privateCreator, tag, (Sequence)origValue, (Attributes)null);
/* 3220 */       } else if (origValue instanceof Fragments) {
/* 3221 */         modified.set(privateCreator, tag, (Fragments)origValue);
/*      */       } else {
/* 3223 */         modified.set(privateCreator, tag, this.vrs[i], origValue);
/*      */       }  continue;
/*      */     } 
/* 3226 */     return modified;
/*      */   }
/*      */   
/*      */   public static interface Visitor {
/*      */     boolean visit(Attributes param1Attributes, int param1Int, VR param1VRTag, Object param1Object) throws Exception;
/*      */   }
/*      */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/Attributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */