/*     */ package org.dcm4che3.data;
/*     */ 
/*     */ import java.io.Serializable;

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
/*     */ public class Code
/*     */   implements Serializable
/*     */ {
/*     */   private static final String NO_CODE_MEANING = "<none>";
/*     */   private static final long serialVersionUID = 8807594793107889446L;
/*     */   private String codeValue;
/*     */   private String codingSchemeDesignator;
/*     */   private String codingSchemeVersion;
/*     */   private String codeMeaning;
/*     */   
/*     */   public Code(String codeValue, String codingSchemeDesignator, String codingSchemeVersion, String codeMeaning) {
/*  60 */     if (codeValue == null)
/*  61 */       throw new NullPointerException("Missing Code Value"); 
/*  62 */     if (codingSchemeDesignator == null)
/*  63 */       throw new NullPointerException("Missing Coding Scheme Designator"); 
/*  64 */     if (codeMeaning == null)
/*  65 */       throw new NullPointerException("Missing Code Meaning"); 
/*  66 */     this.codeValue = codeValue;
/*  67 */     this.codingSchemeDesignator = codingSchemeDesignator;
/*  68 */     this.codingSchemeVersion = codingSchemeVersion;
/*  69 */     this.codeMeaning = codeMeaning;
/*     */   }
/*     */   
/*     */   public Code(String s) {
/*  73 */     int len = s.length();
/*  74 */     if (len < 9 || s.charAt(0) != '(' || s.charAt(len - 2) != '"' || s.charAt(len - 1) != ')')
/*     */     {
/*     */ 
/*     */       
/*  78 */       throw new IllegalArgumentException(s);
/*     */     }
/*  80 */     int endVal = s.indexOf(',');
/*  81 */     int endScheme = s.indexOf(',', endVal + 1);
/*  82 */     int startMeaning = s.indexOf('"', endScheme + 1) + 1;
/*  83 */     this.codeValue = trimsubstring(s, 1, endVal);
/*  84 */     this.codingSchemeDesignator = trimsubstring(s, endVal + 1, endScheme);
/*  85 */     this.codeMeaning = trimsubstring(s, startMeaning, len - 2);
/*  86 */     if (this.codingSchemeDesignator.endsWith("]")) {
/*  87 */       int endVersion = s.lastIndexOf(']', endScheme - 1);
/*  88 */       endScheme = s.lastIndexOf('[', endVersion - 1);
/*  89 */       this.codingSchemeDesignator = trimsubstring(s, endVal + 1, endScheme);
/*  90 */       this.codingSchemeVersion = trimsubstring(s, endScheme + 1, endVersion);
/*     */     } 
/*     */   }
/*     */   
/*     */   private String trimsubstring(String s, int start, int end) {
/*     */     try {
/*  96 */       String trim = s.substring(start, end).trim();
/*  97 */       if (!trim.isEmpty())
/*  98 */         return trim; 
/*  99 */     } catch (StringIndexOutOfBoundsException e) {}
/* 100 */     throw new IllegalArgumentException(s);
/*     */   }
/*     */   
/*     */   public Code(Attributes item) {
/* 104 */     this(item.getString(524544, (String)null), item.getString(524546, (String)null), item.getString(524547, (String)null), item.getString(524548, "<none>"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Code() {}
/*     */ 
/*     */   
/*     */   public final String getCodeValue() {
/* 113 */     return this.codeValue;
/*     */   }
/*     */   
/*     */   public final String getCodingSchemeDesignator() {
/* 117 */     return this.codingSchemeDesignator;
/*     */   }
/*     */   
/*     */   public final String getCodingSchemeVersion() {
/* 121 */     return this.codingSchemeVersion;
/*     */   }
/*     */   
/*     */   public final String getCodeMeaning() {
/* 125 */     return this.codeMeaning;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 130 */     return 37 * (37 * (37 * this.codeValue.hashCode() + this.codeMeaning.hashCode()) + this.codingSchemeDesignator.hashCode()) + hashCode(this.codingSchemeVersion);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int hashCode(String s) {
/* 138 */     return (s == null) ? 0 : s.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 143 */     return equals(o, false);
/*     */   }
/*     */   
/*     */   public boolean equalsIgnoreMeaning(Code o) {
/* 147 */     return equals(o, true);
/*     */   }
/*     */   
/*     */   private boolean equals(Object o, boolean ignoreMeaning) {
/* 151 */     if (o == this)
/* 152 */       return true; 
/* 153 */     if (!(o instanceof Code))
/* 154 */       return false; 
/* 155 */     Code other = (Code)o;
/* 156 */     return (this.codeValue.equals(other.codeValue) && this.codingSchemeDesignator.equals(other.codingSchemeDesignator) && equals(this.codingSchemeVersion, other.codingSchemeVersion) && (ignoreMeaning || this.codeMeaning.equals(other.codeMeaning)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean equals(String s1, String s2) {
/* 163 */     return (s1 == s2 || (s1 != null && s1.equals(s2)));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 168 */     StringBuilder sb = new StringBuilder();
/* 169 */     sb.append('(').append(this.codeValue).append(", ").append(this.codingSchemeDesignator);
/* 170 */     if (this.codingSchemeVersion != null)
/* 171 */       sb.append(" [").append(this.codingSchemeVersion).append(']'); 
/* 172 */     sb.append(", \"").append(this.codeMeaning).append("\")");
/* 173 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public Attributes toItem() {
/* 177 */     Attributes codeItem = new Attributes((this.codingSchemeVersion != null) ? 4 : 3);
/* 178 */     codeItem.setString(524544, VR.SH, this.codeValue);
/* 179 */     codeItem.setString(524546, VR.SH, this.codingSchemeDesignator);
/* 180 */     if (this.codingSchemeVersion != null)
/* 181 */       codeItem.setString(524547, VR.SH, this.codingSchemeVersion);
/* 182 */     codeItem.setString(524548, VR.LO, this.codeMeaning);
/* 183 */     return codeItem;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/Code.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */