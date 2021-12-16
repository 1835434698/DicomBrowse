/*     */ package org.dcm4che3.data;
/*     */ 
/*     */

import org.dcm4che3.util.StringUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
/*     */ public class IDWithIssuer
/*     */ {
/*  53 */   public static final IDWithIssuer[] EMPTY = new IDWithIssuer[0];
/*     */   
/*     */   private final String id;
/*     */   private String identifierTypeCode;
/*     */   private Issuer issuer;
/*     */   
/*     */   public IDWithIssuer(String id, Issuer issuer) {
/*  60 */     if (id.isEmpty())
/*  61 */       throw new IllegalArgumentException("empty id"); 
/*  62 */     this.id = id;
/*  63 */     setIssuer(issuer);
/*     */   }
/*     */   
/*     */   public IDWithIssuer(String id, String issuer) {
/*  67 */     this.id = id;
/*  68 */     setIssuer((issuer != null) ? new Issuer(issuer, '&') : null);
/*     */   }
/*     */   
/*     */   public IDWithIssuer(String cx) {
/*  72 */     String[] ss = StringUtils.split(cx, '^');
/*  73 */     this.id = ss[0];
/*  74 */     setIdentifierTypeCode((ss.length > 4) ? ss[4] : null);
/*  75 */     setIssuer((ss.length > 3) ? new Issuer(ss[3], '&') : null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getID() {
/*  80 */     return this.id;
/*     */   }
/*     */   
/*     */   public final String getIdentifierTypeCode() {
/*  84 */     return this.identifierTypeCode;
/*     */   }
/*     */   
/*     */   public final void setIdentifierTypeCode(String identifierTypeCode) {
/*  88 */     this.identifierTypeCode = identifierTypeCode;
/*     */   }
/*     */   
/*     */   public final Issuer getIssuer() {
/*  92 */     return this.issuer;
/*     */   }
/*     */   
/*     */   public final void setIssuer(Issuer issuer) {
/*  96 */     this.issuer = issuer;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 101 */     if (this.issuer == null && this.identifierTypeCode == null) {
/* 102 */       return this.id;
/*     */     }
/* 104 */     StringBuilder sb = new StringBuilder(this.id);
/* 105 */     sb.append("^^^");
/* 106 */     if (this.issuer != null)
/* 107 */       sb.append(this.issuer.toString('&')); 
/* 108 */     if (this.identifierTypeCode != null)
/* 109 */       sb.append('^').append(this.identifierTypeCode); 
/* 110 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 115 */     int result = this.id.hashCode();
/* 116 */     if (this.identifierTypeCode != null)
/* 117 */       result += this.identifierTypeCode.hashCode() * 31; 
/* 118 */     if (this.issuer != null)
/* 119 */       result += this.issuer.hashCode() * 31; 
/* 120 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 125 */     if (this == obj)
/* 126 */       return true; 
/* 127 */     if (!(obj instanceof IDWithIssuer))
/* 128 */       return false; 
/* 129 */     IDWithIssuer other = (IDWithIssuer)obj;
/* 130 */     return (this.id.equals(other.id) && ((this.identifierTypeCode == null) ? (other.identifierTypeCode == null) : this.identifierTypeCode.equals(this.identifierTypeCode)) && ((this.issuer == null) ? (other.issuer == null) : this.issuer.equals(other.issuer)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(IDWithIssuer other) {
/* 140 */     return (this.id.equals(other.id) && ((this.issuer == null) ? (other.issuer == null) : this.issuer.matches(other.issuer)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes exportPatientIDWithIssuer(Attributes attrs) {
/* 147 */     if (attrs == null) {
/* 148 */       attrs = new Attributes(3);
/*     */     }
/* 150 */     attrs.setString(1048608, VR.LO, this.id);
/* 151 */     if (this.issuer == null && this.identifierTypeCode == null) {
/* 152 */       return attrs;
/*     */     }
/*     */     
/* 155 */     if (this.issuer != null) {
/* 156 */       this.issuer.toIssuerOfPatientID(attrs);
/*     */     }
/* 158 */     if (this.identifierTypeCode != null) {
/* 159 */       Attributes item = attrs.getNestedDataset(1048612);
/*     */       
/* 161 */       if (item == null) {
/* 162 */         item = new Attributes(1);
/* 163 */         attrs.newSequence(1048612, 1).add(item);
/*     */       } 
/*     */       
/* 166 */       item.setString(4194357, VR.CS, this.identifierTypeCode);
/*     */     } 
/* 168 */     return attrs;
/*     */   }
/*     */ 
/*     */   
/*     */   public static IDWithIssuer valueOf(Attributes attrs, int idTag, int issuerSeqTag) {
/* 173 */     String id = attrs.getString(idTag);
/* 174 */     if (id == null) {
/* 175 */       return null;
/*     */     }
/* 177 */     return new IDWithIssuer(id, Issuer.valueOf(attrs.getNestedDataset(issuerSeqTag)));
/*     */   }
/*     */ 
/*     */   
/*     */   public static IDWithIssuer pidOf(Attributes attrs) {
/* 182 */     String id = attrs.getString(1048608);
/* 183 */     if (id == null) {
/* 184 */       return null;
/*     */     }
/* 186 */     IDWithIssuer result = new IDWithIssuer(id, Issuer.fromIssuerOfPatientID(attrs));
/*     */     
/* 188 */     result.setIdentifierTypeCode(identifierTypeCodeOf(attrs));
/* 189 */     return result;
/*     */   }
/*     */   
/*     */   private static String identifierTypeCodeOf(Attributes attrs) {
/* 193 */     Attributes qualifiers = attrs.getNestedDataset(1048612);
/* 194 */     return (qualifiers != null) ? qualifiers.getString(4194357) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Set<IDWithIssuer> pidsOf(Attributes attrs) {
/* 200 */     IDWithIssuer pid = pidOf(attrs);
/* 201 */     Sequence opidseq = attrs.getSequence(1052674);
/* 202 */     if (opidseq == null) {
/* 203 */       if (pid == null) {
/* 204 */         return Collections.emptySet();
/*     */       }
/* 206 */       return Collections.singleton(pid);
/*     */     } 
/* 208 */     Set<IDWithIssuer> pids = new HashSet<IDWithIssuer>(1 + opidseq.size() << 1);
/*     */     
/* 210 */     if (pid != null)
/* 211 */       pids.add(pid); 
/* 212 */     for (Attributes item : opidseq) {
/* 213 */       pid = pidOf(item);
/* 214 */       if (pid != null)
/* 215 */         pids.add(pid); 
/*     */     } 
/* 217 */     return pids;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/IDWithIssuer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */