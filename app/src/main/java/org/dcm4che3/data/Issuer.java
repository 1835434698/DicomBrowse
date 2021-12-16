/*     */ package org.dcm4che3.data;
/*     */ 
/*     */

import org.dcm4che3.util.StringUtils;

import java.io.Serializable;

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
/*     */ public class Issuer
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 5350502680059507981L;
/*     */   private String localNamespaceEntityID;
/*     */   private String universalEntityID;
/*     */   private String universalEntityIDType;
/*     */   
/*     */   public Issuer(String localNamespaceEntityID, String universalEntityID, String universalEntityIDType) {
/*  59 */     this.localNamespaceEntityID = localNamespaceEntityID;
/*  60 */     this.universalEntityID = universalEntityID;
/*  61 */     this.universalEntityIDType = universalEntityIDType;
/*  62 */     validate();
/*     */   }
/*     */   
/*     */   public Issuer(String s) {
/*  66 */     this(s, '&');
/*     */   }
/*     */   
/*     */   public Issuer(String s, char delim) {
/*  70 */     String[] ss = StringUtils.split(s, delim);
/*  71 */     if (ss.length > 3)
/*  72 */       throw new IllegalArgumentException(s); 
/*  73 */     this.localNamespaceEntityID = emptyToNull(ss[0]);
/*  74 */     this.universalEntityID = (ss.length > 1) ? emptyToNull(ss[1]) : null;
/*  75 */     this.universalEntityIDType = (ss.length > 2) ? emptyToNull(ss[2]) : null;
/*  76 */     validate();
/*     */   }
/*     */   
/*     */   public Issuer(String issuerOfPatientID, Attributes qualifiers) {
/*  80 */     this(issuerOfPatientID, (qualifiers != null) ? qualifiers.getString(4194354) : null, (qualifiers != null) ? qualifiers.getString(4194355) : null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Issuer(Attributes issuerItem) {
/*  86 */     this(issuerItem.getString(4194353), issuerItem.getString(4194354), issuerItem.getString(4194355));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Issuer(Issuer other) {
/*  92 */     this(other.getLocalNamespaceEntityID(), other.getUniversalEntityID(), other.getUniversalEntityIDType());
/*     */   }
/*     */ 
/*     */   
/*     */   protected Issuer() {}
/*     */ 
/*     */   
/*     */   public static Issuer fromIssuerOfPatientID(Attributes attrs) {
/* 100 */     String issuerOfPatientID = attrs.getString(1048609);
/* 101 */     Attributes qualifiers = attrs.getNestedDataset(1048612);
/* 102 */     if (issuerOfPatientID == null && (qualifiers == null || qualifiers.isEmpty())) {
/* 103 */       return null;
/*     */     }
/* 105 */     return new Issuer(issuerOfPatientID, qualifiers);
/*     */   }
/*     */   
/*     */   public static Issuer valueOf(Attributes issuerItem) {
/* 109 */     if (issuerItem == null || issuerItem.isEmpty()) {
/* 110 */       return null;
/*     */     }
/* 112 */     return new Issuer(issuerItem);
/*     */   }
/*     */   
/*     */   private void validate() {
/* 116 */     if (this.localNamespaceEntityID == null && this.universalEntityID == null) {
/* 117 */       throw new IllegalArgumentException("Missing Local Namespace Entity ID or Universal Entity ID");
/*     */     }
/* 119 */     if (this.universalEntityID != null && 
/* 120 */       this.universalEntityIDType == null) {
/* 121 */       throw new IllegalArgumentException("Missing Universal Entity ID Type");
/*     */     }
/*     */   }
/*     */   
/*     */   private String emptyToNull(String s) {
/* 126 */     return s.isEmpty() ? null : s;
/*     */   }
/*     */   
/*     */   public final String getLocalNamespaceEntityID() {
/* 130 */     return this.localNamespaceEntityID;
/*     */   }
/*     */   
/*     */   public final String getUniversalEntityID() {
/* 134 */     return this.universalEntityID;
/*     */   }
/*     */   
/*     */   public final String getUniversalEntityIDType() {
/* 138 */     return this.universalEntityIDType;
/*     */   }
/*     */   
/*     */   public boolean merge(Issuer other) {
/* 142 */     if (!matches(other)) {
/* 143 */       throw new IllegalArgumentException("other=" + other);
/*     */     }
/*     */     
/*     */     boolean mergeLocalNamespace;
/* 147 */     if (mergeLocalNamespace = (this.localNamespaceEntityID == null && other.localNamespaceEntityID != null))
/*     */     {
/* 149 */       this.localNamespaceEntityID = other.localNamespaceEntityID; } 
/*     */     boolean mergeUniversal;
/* 151 */     if (mergeUniversal = (this.universalEntityID == null && other.universalEntityID != null)) {
/*     */       
/* 153 */       this.universalEntityID = other.universalEntityID;
/* 154 */       this.universalEntityIDType = other.universalEntityIDType;
/*     */     } 
/* 156 */     return (mergeLocalNamespace || mergeUniversal);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 161 */     return 37 * (37 * hashCode(this.localNamespaceEntityID) + hashCode(this.universalEntityID)) + hashCode(this.universalEntityIDType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int hashCode(String s) {
/* 168 */     return (s == null) ? 0 : s.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 173 */     if (o == this)
/* 174 */       return true; 
/* 175 */     if (!(o instanceof Issuer))
/* 176 */       return false; 
/* 177 */     Issuer other = (Issuer)o;
/* 178 */     return (equals(this.localNamespaceEntityID, other.localNamespaceEntityID) && equals(this.universalEntityID, other.universalEntityID) && equals(this.universalEntityIDType, other.universalEntityIDType));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean equals(String s1, String s2) {
/* 184 */     return (s1 == s2 || (s1 != null && s1.equals(s2)));
/*     */   }
/*     */   
/*     */   public boolean matches(Issuer other) {
/* 188 */     if (this == other || other == null) {
/* 189 */       return true;
/*     */     }
/* 191 */     boolean matchLocal = (this.localNamespaceEntityID != null && other.localNamespaceEntityID != null);
/*     */     
/* 193 */     boolean matchUniversal = (this.universalEntityID != null && other.universalEntityID != null);
/*     */ 
/*     */     
/* 196 */     return ((matchLocal || matchUniversal) && (!matchLocal || this.localNamespaceEntityID.equals(other.localNamespaceEntityID)) && (!matchUniversal || (this.universalEntityID.equals(other.universalEntityID) && this.universalEntityIDType.equals(other.universalEntityIDType))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 206 */     return toString('&');
/*     */   }
/*     */   
/*     */   public String toString(char delim) {
/* 210 */     if (this.universalEntityID == null)
/* 211 */       return this.localNamespaceEntityID; 
/* 212 */     StringBuilder sb = new StringBuilder();
/* 213 */     if (this.localNamespaceEntityID != null)
/* 214 */       sb.append(this.localNamespaceEntityID); 
/* 215 */     sb.append(delim);
/* 216 */     sb.append(this.universalEntityID);
/* 217 */     sb.append(delim);
/* 218 */     sb.append(this.universalEntityIDType);
/* 219 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public Attributes toItem() {
/* 223 */     int size = 0;
/* 224 */     if (this.localNamespaceEntityID != null)
/* 225 */       size++; 
/* 226 */     if (this.universalEntityID != null)
/* 227 */       size++; 
/* 228 */     if (this.universalEntityIDType != null) {
/* 229 */       size++;
/*     */     }
/* 231 */     Attributes item = new Attributes(size);
/* 232 */     if (this.localNamespaceEntityID != null)
/* 233 */       item.setString(4194353, VR.UT, this.localNamespaceEntityID);
/* 234 */     if (this.universalEntityID != null)
/* 235 */       item.setString(4194354, VR.UT, this.universalEntityID);
/* 236 */     if (this.universalEntityIDType != null)
/* 237 */       item.setString(4194355, VR.CS, this.universalEntityIDType);
/* 238 */     return item;
/*     */   }
/*     */   
/*     */   public Attributes toIssuerOfPatientID(Attributes attrs) {
/* 242 */     if (attrs == null)
/* 243 */       attrs = new Attributes(2); 
/* 244 */     if (this.localNamespaceEntityID != null)
/* 245 */       attrs.setString(1048609, VR.LO, this.localNamespaceEntityID);
/* 246 */     if (this.universalEntityID != null) {
/* 247 */       Attributes item = new Attributes(2);
/* 248 */       item.setString(4194354, VR.UT, this.universalEntityID);
/* 249 */       item.setString(4194355, VR.CS, this.universalEntityIDType);
/* 250 */       attrs.newSequence(1048612, 1).add(item);
/*     */     } 
/* 252 */     return attrs;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/Issuer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */