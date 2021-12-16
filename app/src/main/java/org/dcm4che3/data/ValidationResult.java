/*     */ package org.dcm4che3.data;
/*     */ 
/*     */

import org.dcm4che3.util.ByteUtils;
import org.dcm4che3.util.StringUtils;
import org.dcm4che3.util.TagUtils;

import java.util.ArrayList;
import java.util.List;

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
/*     */ public class ValidationResult
/*     */ {
/*     */   private ArrayList<IOD.DataElement> missingAttributes;
/*     */   private ArrayList<IOD.DataElement> missingAttributeValues;
/*     */   private ArrayList<IOD.DataElement> notAllowedAttributes;
/*     */   private ArrayList<InvalidAttributeValue> invalidAttributeValues;
/*     */   
/*     */   public enum Invalid
/*     */   {
/*  56 */     VR,
/*  57 */     VM,
/*  58 */     Value,
/*  59 */     Item,
/*  60 */     MultipleItems,
/*  61 */     Code;
/*     */   }
/*     */   
/*     */   public class InvalidAttributeValue {
/*     */     public final IOD.DataElement dataElement;
/*     */     public final Invalid reason;
/*     */     public final ValidationResult[] itemValidationResults;
/*     */     public final IOD[] missingItems;
/*     */
/*     */     public InvalidAttributeValue(IOD.DataElement dataElement, Invalid reason, ValidationResult[] itemValidationResults, IOD[] missingItems) {
/*  71 */       this.dataElement = dataElement;
/*  72 */       this.reason = reason;
/*  73 */       this.itemValidationResults = itemValidationResults;
/*  74 */       this.missingItems = missingItems;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasMissingAttributes() {
/*  84 */     return (this.missingAttributes != null);
/*     */   }
/*     */   
/*     */   public boolean hasMissingAttributeValues() {
/*  88 */     return (this.missingAttributeValues != null);
/*     */   }
/*     */   
/*     */   public boolean hasInvalidAttributeValues() {
/*  92 */     return (this.invalidAttributeValues != null);
/*     */   }
/*     */   
/*     */   public boolean hasNotAllowedAttributes() {
/*  96 */     return (this.notAllowedAttributes != null);
/*     */   }
/*     */   
/*     */   public boolean isValid() {
/* 100 */     return (!hasMissingAttributes() && !hasMissingAttributeValues() && !hasInvalidAttributeValues() && !hasNotAllowedAttributes());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addMissingAttribute(IOD.DataElement dataElement) {
/* 107 */     if (this.missingAttributes == null)
/* 108 */       this.missingAttributes = new ArrayList<IOD.DataElement>(); 
/* 109 */     this.missingAttributes.add(dataElement);
/*     */   }
/*     */   
/*     */   public void addMissingAttributeValue(IOD.DataElement dataElement) {
/* 113 */     if (this.missingAttributeValues == null)
/* 114 */       this.missingAttributeValues = new ArrayList<IOD.DataElement>(); 
/* 115 */     this.missingAttributeValues.add(dataElement);
/*     */   }
/*     */   
/*     */   public void addInvalidAttributeValue(IOD.DataElement dataElement, Invalid reason) {
/* 119 */     addInvalidAttributeValue(dataElement, reason, null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addInvalidAttributeValue(IOD.DataElement dataElement, Invalid reason, ValidationResult[] itemValidationResult, IOD[] missingItems) {
/* 124 */     if (this.invalidAttributeValues == null)
/* 125 */       this.invalidAttributeValues = new ArrayList<InvalidAttributeValue>(); 
/* 126 */     this.invalidAttributeValues.add(new InvalidAttributeValue(dataElement, reason, itemValidationResult, missingItems));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addNotAllowedAttribute(IOD.DataElement el) {
/* 132 */     if (this.notAllowedAttributes == null)
/* 133 */       this.notAllowedAttributes = new ArrayList<IOD.DataElement>(); 
/* 134 */     this.notAllowedAttributes.add(el);
/*     */   }
/*     */   
/*     */   public int[] tagsOfNotAllowedAttributes() {
/* 138 */     return tagsOf(this.notAllowedAttributes);
/*     */   }
/*     */   
/*     */   public int[] tagsOfMissingAttributeValues() {
/* 142 */     return tagsOf(this.missingAttributeValues);
/*     */   }
/*     */   
/*     */   public int[] tagsOfMissingAttributes() {
/* 146 */     return tagsOf(this.missingAttributes);
/*     */   }
/*     */   
/*     */   public int[] tagsOfInvalidAttributeValues() {
/* 150 */     ArrayList<InvalidAttributeValue> list = this.invalidAttributeValues;
/* 151 */     if (list == null) {
/* 152 */       return ByteUtils.EMPTY_INTS;
/*     */     }
/* 154 */     int[] tags = new int[list.size()];
/* 155 */     for (int i = 0; i < tags.length; i++)
/* 156 */       tags[i] = ((InvalidAttributeValue)list.get(i)).dataElement.tag; 
/* 157 */     return tags;
/*     */   }
/*     */   
/*     */   public int[] getOffendingElements() {
/* 161 */     return cat(new int[][] { tagsOfMissingAttributes(), tagsOfMissingAttributeValues(), tagsOfInvalidAttributeValues(), tagsOfNotAllowedAttributes() });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int[] cat(int[]... iss) {
/* 168 */     int length = 0;
/* 169 */     for (int[] is : iss)
/* 170 */       length += is.length; 
/* 171 */     int[] tags = new int[length];
/* 172 */     int off = 0;
/* 173 */     for (int[] is : iss) {
/* 174 */       System.arraycopy(is, 0, tags, off, is.length);
/* 175 */       off += is.length;
/*     */     } 
/* 177 */     return tags;
/*     */   }
/*     */   
/*     */   private int[] tagsOf(List<IOD.DataElement> list) {
/* 181 */     if (list == null) {
/* 182 */       return ByteUtils.EMPTY_INTS;
/*     */     }
/* 184 */     int[] tags = new int[list.size()];
/* 185 */     for (int i = 0; i < tags.length; i++)
/* 186 */       tags[i] = ((IOD.DataElement)list.get(i)).tag; 
/* 187 */     return tags;
/*     */   }
/*     */   
/*     */   public String getErrorComment() {
/* 191 */     StringBuilder sb = new StringBuilder();
/* 192 */     if (this.notAllowedAttributes != null) {
/* 193 */       return errorComment(sb, "Not allowed Attribute", tagsOfNotAllowedAttributes()).toString();
/*     */     }
/* 195 */     if (this.missingAttributes != null) {
/* 196 */       return errorComment(sb, "Missing Attribute", tagsOfMissingAttributes()).toString();
/*     */     }
/* 198 */     if (this.missingAttributeValues != null) {
/* 199 */       return errorComment(sb, "Missing Value of Attribute", tagsOfMissingAttributeValues()).toString();
/*     */     }
/* 201 */     if (this.invalidAttributeValues != null) {
/* 202 */       return errorComment(sb, "Invalid Attribute", tagsOfInvalidAttributeValues()).toString();
/*     */     }
/* 204 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static StringBuilder errorComment(StringBuilder sb, String prompt, int[] tags) {
/* 209 */     sb.append(prompt);
/* 210 */     String prefix = (tags.length > 1) ? "s: " : ": ";
/* 211 */     for (int tag : tags) {
/* 212 */       sb.append(prefix).append(TagUtils.toString(tag));
/* 213 */       prefix = ", ";
/*     */     } 
/* 215 */     return sb;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 220 */     if (isValid()) {
/* 221 */       return "VALID";
/*     */     }
/* 223 */     StringBuilder sb = new StringBuilder();
/* 224 */     if (this.notAllowedAttributes != null) {
/* 225 */       errorComment(sb, "Not allowed Attribute", tagsOfNotAllowedAttributes()).append(StringUtils.LINE_SEPARATOR);
/*     */     }
/* 227 */     if (this.missingAttributes != null) {
/* 228 */       errorComment(sb, "Missing Attribute", tagsOfMissingAttributes()).append(StringUtils.LINE_SEPARATOR);
/*     */     }
/* 230 */     if (this.missingAttributeValues != null) {
/* 231 */       errorComment(sb, "Missing Value of Attribute", tagsOfMissingAttributeValues()).append(StringUtils.LINE_SEPARATOR);
/*     */     }
/* 233 */     if (this.invalidAttributeValues != null) {
/* 234 */       errorComment(sb, "Invalid Attribute", tagsOfInvalidAttributeValues()).append(StringUtils.LINE_SEPARATOR);
/*     */     }
/*     */     
/* 237 */     return sb.substring(0, sb.length() - 1);
/*     */   }
/*     */   
/*     */   public String asText(Attributes attrs) {
/* 241 */     if (isValid()) {
/* 242 */       return "VALID";
/*     */     }
/* 244 */     StringBuilder sb = new StringBuilder();
/* 245 */     appendTextTo(0, attrs, sb);
/* 246 */     return sb.substring(0, sb.length() - 1);
/*     */   }
/*     */   
/*     */   private void appendTextTo(int level, Attributes attrs, StringBuilder sb) {
/* 250 */     if (this.notAllowedAttributes != null)
/* 251 */       appendTextTo(level, attrs, "Not allowed Attributes:", this.notAllowedAttributes, sb); 
/* 252 */     if (this.missingAttributes != null)
/* 253 */       appendTextTo(level, attrs, "Missing Attributes:", this.missingAttributes, sb); 
/* 254 */     if (this.missingAttributeValues != null)
/* 255 */       appendTextTo(level, attrs, "Missing Attribute Values:", this.missingAttributeValues, sb); 
/* 256 */     if (this.invalidAttributeValues != null) {
/* 257 */       appendInvalidAttributeValues(level, attrs, "Invalid Attribute Values:", sb);
/*     */     }
/*     */   }
/*     */   
/*     */   private void appendTextTo(int level, Attributes attrs, String title, List<IOD.DataElement> list, StringBuilder sb) {
/* 262 */     appendPrefixTo(level, sb);
/* 263 */     sb.append(title).append(StringUtils.LINE_SEPARATOR);
/* 264 */     for (IOD.DataElement el : list) {
/* 265 */       appendAttribute(level, el.tag, sb);
/* 266 */       appendIODRef(el.getLineNumber(), sb);
/* 267 */       sb.append(StringUtils.LINE_SEPARATOR);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void appendIODRef(int lineNumber, StringBuilder sb) {
/* 272 */     if (lineNumber > 0) {
/* 273 */       sb.append(" // IOD line #").append(lineNumber);
/*     */     }
/*     */   }
/*     */   
/*     */   private void appendInvalidAttributeValues(int level, Attributes attrs, String title, StringBuilder sb) {
/* 278 */     appendPrefixTo(level, sb);
/* 279 */     sb.append(title);
/* 280 */     sb.append(StringUtils.LINE_SEPARATOR);
/* 281 */     for (InvalidAttributeValue iav : this.invalidAttributeValues) {
/* 282 */       int tag = iav.dataElement.tag;
/* 283 */       appendAttribute(level, tag, sb);
/* 284 */       VR.Holder vr = new VR.Holder();
/* 285 */       Object value = attrs.getValue(tag, vr);
/* 286 */       sb.append(' ').append(vr.vr);
/* 287 */       sb.append(" [");
/* 288 */       vr.vr.prompt(value, attrs.bigEndian(), attrs.getSpecificCharacterSet(vr.vr), 200, sb);
/*     */ 
/*     */       
/* 291 */       sb.append(']');
/* 292 */       if (iav.reason != Invalid.Item) {
/* 293 */         sb.append(" Invalid ").append(iav.reason);
/* 294 */         appendIODRef(iav.dataElement.getLineNumber(), sb);
/*     */       } 
/* 296 */       sb.append(StringUtils.LINE_SEPARATOR);
/* 297 */       if (iav.missingItems != null) {
/* 298 */         for (IOD iod : iav.missingItems) {
/* 299 */           appendPrefixTo(level + 1, sb);
/* 300 */           sb.append("Missing Item");
/* 301 */           appendIODRef(iod.getLineNumber(), sb);
/* 302 */           sb.append(StringUtils.LINE_SEPARATOR);
/*     */         } 
/*     */       }
/* 305 */       if (iav.itemValidationResults != null) {
/* 306 */         Sequence seq = (Sequence)value;
/* 307 */         for (int i = 0; i < iav.itemValidationResults.length; i++) {
/* 308 */           ValidationResult itemResult = iav.itemValidationResults[i];
/* 309 */           if (!itemResult.isValid()) {
/* 310 */             appendPrefixTo(level + 1, sb);
/* 311 */             sb.append("Invalid Item ").append(i + 1).append(':').append(StringUtils.LINE_SEPARATOR);
/*     */             
/* 313 */             itemResult.appendTextTo(level + 1, seq.get(i), sb);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void appendAttribute(int level, int tag, StringBuilder sb) {
/* 321 */     appendPrefixTo(level, sb);
/* 322 */     sb.append(TagUtils.toString(tag)).append(' ').append(ElementDictionary.keywordOf(tag, null));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void appendPrefixTo(int level, StringBuilder sb) {
/* 328 */     while (level-- > 0)
/* 329 */       sb.append('>'); 
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/ValidationResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */