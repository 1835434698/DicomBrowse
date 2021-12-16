/*     */ package org.dcm4che3.data;
/*     */ 
/*     */

 // import org.slf4j.Logger;
 // import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.StringTokenizer;

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
/*     */ public class PersonName
/*     */ {
/*  53 */    // private static final Logger LOG = LoggerFactory.getLogger(PersonName.class);
/*     */   
/*     */   public enum Component {
/*  56 */     FamilyName, GivenName, MiddleName, NamePrefix, NameSuffix;
/*     */   }
/*     */   
/*     */   public enum Group {
/*  60 */     Alphabetic, Ideographic, Phonetic;
/*     */   }
/*     */   
/*  63 */   private final String[] fields = new String[15];
/*     */   
/*     */   public PersonName() {}
/*     */   
/*     */   public PersonName(String s) {
/*  68 */     this(s, false);
/*     */   }
/*     */   
/*     */   public PersonName(String s, boolean lenient) {
/*  72 */     if (s != null)
/*  73 */       parse(s, lenient); 
/*     */   }
/*     */   
/*     */   private void parse(String s, boolean lenient) {
/*  77 */     int gindex = 0;
/*  78 */     int cindex = 0;
/*  79 */     StringTokenizer stk = new StringTokenizer(s, "^=", true);
/*  80 */     while (stk.hasMoreTokens()) {
/*  81 */       String tk = stk.nextToken();
/*  82 */       switch (tk.charAt(0)) {
/*     */         case '=':
/*  84 */           if (++gindex > 2) {
/*  85 */             if (lenient) {
/*  86 */                // LOG.info("illegal PN: {} - truncate illegal component group(s)", s);
/*     */               
/*     */               return;
/*     */             } 
/*  90 */             throw new IllegalArgumentException(s);
/*  91 */           }  cindex = 0;
/*     */           continue;
/*     */         case '^':
/*  94 */           if (++cindex > 4) {
/*  95 */             if (lenient) {
/*  96 */                // LOG.info("illegal PN: {} - ignore illegal component(s)", s);
/*     */               
/*     */               continue;
/*     */             } 
/* 100 */             throw new IllegalArgumentException(s);
/*     */           }  continue;
/*     */       } 
/* 103 */       if (cindex <= 4) {
/* 104 */         set(gindex, cindex, tk);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public String toString() {
/* 110 */     int totLen = 0;
/* 111 */     Group lastGroup = Group.Alphabetic;
/* 112 */     for (Group g : Group.values()) {
/* 113 */       Component lastCompOfGroup = Component.FamilyName;
/* 114 */       for (Component c : Component.values()) {
/* 115 */         String s = get(g, c);
/* 116 */         if (s != null) {
/* 117 */           totLen += s.length();
/* 118 */           lastGroup = g;
/* 119 */           lastCompOfGroup = c;
/*     */         } 
/*     */       } 
/* 122 */       totLen += lastCompOfGroup.ordinal();
/*     */     } 
/* 124 */     totLen += lastGroup.ordinal();
/* 125 */     char[] ch = new char[totLen];
/* 126 */     int wpos = 0;
/* 127 */     for (Group g : Group.values()) {
/* 128 */       Component lastCompOfGroup = Component.FamilyName;
/* 129 */       for (Component c : Component.values()) {
/* 130 */         String s = get(g, c);
/* 131 */         if (s != null) {
/* 132 */           int d = c.ordinal() - lastCompOfGroup.ordinal();
/* 133 */           while (d-- > 0)
/* 134 */             ch[wpos++] = '^'; 
/* 135 */           d = s.length();
/* 136 */           s.getChars(0, d, ch, wpos);
/* 137 */           wpos += d;
/* 138 */           lastCompOfGroup = c;
/*     */         } 
/*     */       } 
/* 141 */       if (g == lastGroup)
/*     */         break; 
/* 143 */       ch[wpos++] = '=';
/*     */     } 
/* 145 */     return new String(ch);
/*     */   }
/*     */   
/*     */   public String toString(Group g, boolean trim) {
/* 149 */     int totLen = 0;
/* 150 */     Component lastCompOfGroup = Component.FamilyName;
/* 151 */     for (Component c : Component.values()) {
/* 152 */       String s = get(g, c);
/* 153 */       if (s != null) {
/* 154 */         totLen += s.length();
/* 155 */         lastCompOfGroup = c;
/*     */       } 
/*     */     } 
/* 158 */     totLen += trim ? lastCompOfGroup.ordinal() : 4;
/* 159 */     char[] ch = new char[totLen];
/* 160 */     int wpos = 0;
/* 161 */     for (Component c : Component.values()) {
/* 162 */       String s = get(g, c);
/* 163 */       if (s != null) {
/* 164 */         int d = s.length();
/* 165 */         s.getChars(0, d, ch, wpos);
/* 166 */         wpos += d;
/*     */       } 
/* 168 */       if (trim && c == lastCompOfGroup)
/*     */         break; 
/* 170 */       if (wpos < ch.length)
/* 171 */         ch[wpos++] = '^'; 
/*     */     } 
/* 173 */     return new String(ch);
/*     */   }
/*     */   
/*     */   public String get(Component c) {
/* 177 */     return get(Group.Alphabetic, c);
/*     */   }
/*     */   
/*     */   public String get(Group g, Component c) {
/* 181 */     return this.fields[g.ordinal() * 5 + c.ordinal()];
/*     */   }
/*     */   
/*     */   public void set(Component c, String s) {
/* 185 */     set(Group.Alphabetic, c, s);
/*     */   }
/*     */   
/*     */   public void set(Group g, Component c, String s) {
/* 189 */     set(g.ordinal(), c.ordinal(), s);
/*     */   }
/*     */   
/*     */   private void set(int gindex, int cindex, String s) {
/* 193 */     this.fields[gindex * 5 + cindex] = trim(s);
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 197 */     for (Group g : Group.values()) {
/* 198 */       if (contains(g))
/* 199 */         return false; 
/* 200 */     }  return true;
/*     */   }
/*     */   
/*     */   public boolean contains(Group g) {
/* 204 */     for (Component c : Component.values()) {
/* 205 */       if (contains(g, c))
/* 206 */         return true; 
/* 207 */     }  return false;
/*     */   }
/*     */   
/*     */   public boolean contains(Group g, Component c) {
/* 211 */     return (get(g, c) != null);
/*     */   }
/*     */   
/*     */   public boolean contains(Component c) {
/* 215 */     return contains(Group.Alphabetic, c);
/*     */   }
/*     */   
/*     */   private static String trim(String s) {
/* 219 */     return (s == null || (s = s.trim()).isEmpty()) ? null : s;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 224 */     return Arrays.hashCode((Object[])this.fields);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 229 */     if (obj == this) {
/* 230 */       return true;
/*     */     }
/* 232 */     if (!(obj instanceof PersonName)) {
/* 233 */       return false;
/*     */     }
/* 235 */     PersonName other = (PersonName)obj;
/* 236 */     return Arrays.equals((Object[])this.fields, (Object[])other.fields);
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/PersonName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */