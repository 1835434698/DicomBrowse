/*     */ package org.dcm4che3.media;
/*     */ 
/*     */

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Sequence;
import org.dcm4che3.data.VR;
import org.dcm4che3.io.ContentHandlerAdapter;
import org.dcm4che3.util.ResourceLocator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;

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
/*     */ public class RecordFactory
/*     */ {
/*     */   private static final int IN_USE = 65535;
/*     */   private EnumMap<RecordType, int[]> recordKeys;
/*     */   private HashMap<String, RecordType> recordTypes;
/*     */   private HashMap<String, String> privateRecordUIDs;
/*     */   private HashMap<String, int[]> privateRecordKeys;
/*     */   
/*     */   private void lazyLoadDefaultConfiguration() {
/*  74 */     if (this.recordTypes == null)
/*  75 */       loadDefaultConfiguration(); 
/*     */   }
/*     */   
/*     */   public void loadDefaultConfiguration() {
/*     */     try {
/*  80 */       loadConfiguration(ResourceLocator.getResource("org/org.dcm4che3/media/RecordFactory.xml", getClass()));
/*     */     }
/*  82 */     catch (Exception e) {
/*  83 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadConfiguration(String uri) throws ParserConfigurationException, SAXException, IOException {
/*  89 */     Attributes attrs = parseXML(uri);
/*  90 */     Sequence sq = attrs.getSequence(266784);
/*  91 */     if (sq == null) {
/*  92 */       throw new IllegalArgumentException("Missing Directory Record Sequence in " + uri);
/*     */     }
/*     */     
/*  95 */     EnumMap<RecordType, int[]> recordKeys = (EnumMap)new EnumMap<RecordType, Integer>(RecordType.class);
/*     */     
/*  97 */     HashMap<String, RecordType> recordTypes = new HashMap<String, RecordType>(134);
/*     */     
/*  99 */     HashMap<String, String> privateRecordUIDs = new HashMap<String, String>();
/* 100 */     HashMap<String, int[]> privateRecordKeys = (HashMap)new HashMap<String, Integer>();
/* 101 */     for (Attributes item : sq) {
/* 102 */       RecordType type = RecordType.forCode(item.getString(267312, null));
/*     */       
/* 104 */       String privuid = (type == RecordType.PRIVATE) ? item.getString(267314, null) : null;
/*     */       
/* 106 */       String[] cuids = item.getStrings(267536);
/* 107 */       if (cuids != null) {
/* 108 */         if (type != RecordType.PRIVATE) {
/* 109 */           for (String cuid : cuids) {
/* 110 */             recordTypes.put(cuid, type);
/*     */           }
/* 112 */         } else if (privuid != null) {
/* 113 */           for (String cuid : cuids) {
/* 114 */             privateRecordUIDs.put(cuid, privuid);
/*     */           }
/*     */         } 
/*     */       }
/* 118 */       item.remove(267312);
/* 119 */       item.remove(267314);
/* 120 */       item.remove(267536);
/* 121 */       int[] keys = item.tags();
/* 122 */       if (privuid != null) {
/* 123 */         if (privateRecordKeys.put(privuid, keys) != null)
/* 124 */           throw new IllegalArgumentException("Duplicate Private Record UID: " + privuid); 
/*     */         continue;
/*     */       } 
/* 127 */       if (recordKeys.put(type, keys) != null) {
/* 128 */         throw new IllegalArgumentException("Duplicate Record Type: " + type);
/*     */       }
/*     */     } 
/*     */     
/* 132 */     EnumSet<RecordType> missingTypes = EnumSet.allOf(RecordType.class);
/* 133 */     missingTypes.removeAll(recordKeys.keySet());
/* 134 */     if (!missingTypes.isEmpty()) {
/* 135 */       throw new IllegalArgumentException("Missing Record Types: " + missingTypes);
/*     */     }
/* 137 */     this.recordTypes = recordTypes;
/* 138 */     this.recordKeys = recordKeys;
/* 139 */     this.privateRecordUIDs = privateRecordUIDs;
/* 140 */     this.privateRecordKeys = privateRecordKeys;
/*     */   }
/*     */ 
/*     */   
/*     */   private Attributes parseXML(String uri) throws ParserConfigurationException, SAXException, IOException {
/* 145 */     Attributes attrs = new Attributes();
/* 146 */     SAXParserFactory f = SAXParserFactory.newInstance();
/* 147 */     SAXParser parser = f.newSAXParser();
/* 148 */     parser.parse(uri, (DefaultHandler)new ContentHandlerAdapter(attrs));
/* 149 */     return attrs;
/*     */   }
/*     */   
/*     */   public RecordType getRecordType(String cuid) {
/* 153 */     if (cuid == null)
/* 154 */       throw new NullPointerException(); 
/* 155 */     lazyLoadDefaultConfiguration();
/* 156 */     RecordType recordType = this.recordTypes.get(cuid);
/* 157 */     return (recordType != null) ? recordType : RecordType.PRIVATE;
/*     */   }
/*     */   
/*     */   public RecordType setRecordType(String cuid, RecordType type) {
/* 161 */     if (cuid == null || type == null)
/* 162 */       throw new NullPointerException(); 
/* 163 */     lazyLoadDefaultConfiguration();
/* 164 */     return this.recordTypes.put(cuid, type);
/*     */   }
/*     */   
/*     */   public void setRecordKeys(RecordType type, int[] keys) {
/* 168 */     if (type == null)
/* 169 */       throw new NullPointerException(); 
/* 170 */     int[] tmp = (int[])keys.clone();
/* 171 */     Arrays.sort(tmp);
/* 172 */     lazyLoadDefaultConfiguration();
/* 173 */     this.recordKeys.put(type, keys);
/*     */   }
/*     */   
/*     */   public String getPrivateRecordUID(String cuid) {
/* 177 */     if (cuid == null) {
/* 178 */       throw new NullPointerException();
/*     */     }
/* 180 */     lazyLoadDefaultConfiguration();
/* 181 */     String uid = this.privateRecordUIDs.get(cuid);
/* 182 */     return (uid != null) ? uid : cuid;
/*     */   }
/*     */   
/*     */   public String setPrivateRecordUID(String cuid, String uid) {
/* 186 */     if (cuid == null || uid == null) {
/* 187 */       throw new NullPointerException();
/*     */     }
/* 189 */     lazyLoadDefaultConfiguration();
/* 190 */     return this.privateRecordUIDs.put(cuid, uid);
/*     */   }
/*     */   
/*     */   public int[] setPrivateRecordKeys(String uid, int[] keys) {
/* 194 */     if (uid == null) {
/* 195 */       throw new NullPointerException();
/*     */     }
/* 197 */     int[] tmp = (int[])keys.clone();
/* 198 */     Arrays.sort(tmp);
/* 199 */     lazyLoadDefaultConfiguration();
/* 200 */     return this.privateRecordKeys.put(uid, tmp);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attributes createRecord(Attributes dataset, Attributes fmi, String[] fileIDs) {
/* 205 */     String cuid = fmi.getString(131074, null);
/* 206 */     RecordType type = getRecordType(cuid);
/* 207 */     return createRecord(type, (type == RecordType.PRIVATE) ? getPrivateRecordUID(cuid) : null, dataset, fmi, fileIDs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes createRecord(RecordType type, String privRecUID, Attributes dataset, Attributes fmi, String[] fileIDs) {
/* 214 */     if (type == null)
/* 215 */       throw new NullPointerException("type"); 
/* 216 */     if (dataset == null) {
/* 217 */       throw new NullPointerException("dataset");
/*     */     }
/* 219 */     lazyLoadDefaultConfiguration();
/* 220 */     int[] keys = null;
/* 221 */     if (type == RecordType.PRIVATE) {
/* 222 */       if (privRecUID == null) {
/* 223 */         throw new NullPointerException("privRecUID must not be null for type = PRIVATE");
/*     */       }
/* 225 */       keys = this.privateRecordKeys.get(privRecUID);
/*     */     }
/* 227 */     else if (privRecUID != null) {
/* 228 */       throw new IllegalArgumentException("privRecUID must be null for type != PRIVATE");
/*     */     } 
/*     */     
/* 231 */     if (keys == null)
/* 232 */       keys = this.recordKeys.get(type); 
/* 233 */     Attributes rec = new Attributes(keys.length + ((fileIDs != null) ? 9 : 5));
/* 234 */     rec.setInt(267264, VR.UL, new int[] { 0 });
/* 235 */     rec.setInt(267280, VR.US, new int[] { 65535 });
/* 236 */     rec.setInt(267296, VR.UL, new int[] { 0 });
/* 237 */     rec.setString(267312, VR.CS, type.code());
/* 238 */     if (privRecUID != null)
/* 239 */       rec.setString(267314, VR.UI, privRecUID);
/* 240 */     if (fileIDs != null) {
/* 241 */       rec.setString(267520, VR.CS, fileIDs);
/* 242 */       rec.setString(267536, VR.UI, fmi.getString(131074, null));
/*     */       
/* 244 */       rec.setString(267537, VR.UI, fmi.getString(131075, null));
/*     */       
/* 246 */       rec.setString(267538, VR.UI, fmi.getString(131088, null));
/*     */     } 
/*     */     
/* 249 */     rec.addSelected(dataset, keys, 0, keys.length);
/* 250 */     Sequence contentSeq = dataset.getSequence(4237104);
/* 251 */     if (contentSeq != null)
/* 252 */       copyConceptMod(contentSeq, rec); 
/* 253 */     return rec;
/*     */   }
/*     */   
/*     */   private void copyConceptMod(Sequence srcSeq, Attributes rec) {
/* 257 */     Sequence dstSeq = null;
/* 258 */     for (Attributes item : srcSeq) {
/* 259 */       if ("HAS CONCEPT MOD".equals(item.getString(4235280, null))) {
/*     */         
/* 261 */         if (dstSeq == null)
/* 262 */           dstSeq = rec.newSequence(4237104, 1); 
/* 263 */         dstSeq.add(new Attributes(item, false));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/media/RecordFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */