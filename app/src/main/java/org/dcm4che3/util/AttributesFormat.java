/*     */ package org.dcm4che3.util;
/*     */ 
/*     */

import org.dcm4che3.data.Attributes;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
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
/*     */ public class AttributesFormat
/*     */   extends Format
/*     */ {
/*     */   private static final long serialVersionUID = 1901510733531643054L;
/*     */   private final String pattern;
/*     */   private final int[] tags;
/*     */   private final int[] index;
/*     */   private final Type[] types;
/*     */   private final MessageFormat format;
/*     */   
/*     */   public AttributesFormat(String pattern) {
/*  68 */     ArrayList<String> tokens = tokenize(pattern);
/*  69 */     int n = tokens.size() / 2;
/*  70 */     this.pattern = pattern;
/*  71 */     this.tags = new int[n];
/*  72 */     this.index = new int[n];
/*  73 */     this.types = new Type[n];
/*  74 */     this.format = buildMessageFormat(tokens);
/*     */   }
/*     */   
/*     */   private ArrayList<String> tokenize(String s) {
/*  78 */     ArrayList<String> result = new ArrayList<String>();
/*  79 */     StringTokenizer stk = new StringTokenizer(s, "{}", true);
/*     */ 
/*     */     
/*  82 */     char prevDelim = '}';
/*  83 */     int level = 0;
/*  84 */     StringBuilder sb = new StringBuilder();
/*  85 */     while (stk.hasMoreTokens()) {
/*  86 */       String tk = stk.nextToken();
/*  87 */       char delim = tk.charAt(0);
/*  88 */       if (delim == '{') {
/*  89 */         if (level++ == 0) {
/*  90 */           if (prevDelim == '}')
/*  91 */             result.add(""); 
/*     */         } else {
/*  93 */           sb.append(delim);
/*     */         } 
/*  95 */       } else if (delim == '}') {
/*  96 */         if (--level == 0) {
/*  97 */           result.add(sb.toString());
/*  98 */           sb.setLength(0);
/*  99 */         } else if (level > 0) {
/* 100 */           sb.append(delim);
/*     */         } else {
/* 102 */           throw new IllegalArgumentException(s);
/*     */         } 
/* 104 */       } else if (level == 0) {
/* 105 */         result.add(tk);
/*     */       } else {
/* 107 */         sb.append(tk);
/*     */       } 
/* 109 */       prevDelim = delim;
/*     */     } 
/* 111 */     return result;
/*     */   }
/*     */   
/*     */   private MessageFormat buildMessageFormat(ArrayList<String> tokens) {
/* 115 */     StringBuilder formatBuilder = new StringBuilder(this.pattern.length());
/* 116 */     int j = 0;
/* 117 */     for (int i = 0; i < this.tags.length; i++) {
/* 118 */       formatBuilder.append(tokens.get(j++)).append('{').append(i);
/* 119 */       String tagStr = tokens.get(j++);
/* 120 */       int typeStart = tagStr.indexOf(',') + 1;
/* 121 */       if (!tagStr.startsWith("now")) {
/* 122 */         int tagStrLen = (typeStart != 0) ? (typeStart - 1) : tagStr.length();
/*     */ 
/*     */ 
/*     */         
/* 126 */         int indexStart = (tagStr.charAt(tagStrLen - 1) == ']') ? (tagStr.lastIndexOf('[', tagStrLen - 3) + 1) : 0;
/*     */ 
/*     */         
/*     */         try {
/* 130 */           this.tags[i] = Integer.parseInt(tagStr.substring(0, (indexStart != 0) ? (indexStart - 1) : tagStrLen), 16);
/*     */           
/* 132 */           if (indexStart != 0)
/* 133 */             this.index[i] = Integer.parseInt(tagStr.substring(indexStart, tagStrLen - 1)); 
/* 134 */         } catch (NumberFormatException e) {
/* 135 */           throw new IllegalArgumentException(this.pattern);
/*     */         } 
/*     */       } 
/* 138 */       if (typeStart != 0) {
/* 139 */         int typeEnd = tagStr.indexOf(',', typeStart);
/*     */         try {
/* 141 */           this.types[i] = Type.valueOf(tagStr.substring(typeStart, (typeEnd < 0) ? tagStr.length() : typeEnd));
/*     */         }
/* 143 */         catch (IllegalArgumentException e) {
/* 144 */           throw new IllegalArgumentException(this.pattern);
/*     */         } 
/* 146 */         if (this.types[i] != Type.hash && this.types[i] != Type.urlencoded) {
/* 147 */           formatBuilder.append((typeStart > 0) ? tagStr.substring(typeStart - 1) : tagStr);
/*     */         }
/*     */       } else {
/* 150 */         this.types[i] = Type.none;
/*     */       } 
/* 152 */       formatBuilder.append('}');
/*     */     } 
/* 154 */     if (j < tokens.size())
/* 155 */       formatBuilder.append(tokens.get(j)); 
/*     */     try {
/* 157 */       return new MessageFormat(formatBuilder.toString());
/* 158 */     } catch (IllegalArgumentException e) {
/* 159 */       throw new IllegalArgumentException(this.pattern);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static AttributesFormat valueOf(String s) {
/* 164 */     return (s != null) ? new AttributesFormat(s) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public StringBuffer format(Object obj, StringBuffer result, FieldPosition pos) {
/* 169 */     return this.format.format(toArgs((Attributes)obj), result, pos);
/*     */   }
/*     */   
/*     */   private Object[] toArgs(Attributes attrs) {
/* 173 */     Object[] args = new Object[this.tags.length];
/* 174 */     for (int i = 0; i < args.length; i++)
/* 175 */       args[i] = this.types[i].toArg(attrs, this.tags[i], this.index[i]); 
/* 176 */     return args;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object parseObject(String source, ParsePosition pos) {
/* 181 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 186 */     return this.pattern;
/*     */   }
/*     */   
/*     */   private enum Type {
/* 190 */     none
/*     */     {
/*     */       Object toArg(Attributes attrs, int tag, int index) {
/* 193 */         return attrs.getString(tag, index);
/*     */       }
/*     */     },
/* 196 */     number
/*     */     {
/*     */       Object toArg(Attributes attrs, int tag, int index) {
/* 199 */         return Double.valueOf(attrs.getDouble(tag, index, 0.0D));
/*     */       }
/*     */     },
/* 202 */     date
/*     */     {
/*     */       Object toArg(Attributes attrs, int tag, int index) {
/* 205 */         return (tag != 0) ? attrs.getDate(tag, index) : new Date();
/*     */       }
/*     */     },
/* 208 */     time
/*     */     {
/*     */       Object toArg(Attributes attrs, int tag, int index) {
/* 211 */         return (tag != 0) ? attrs.getDate(tag, index) : new Date();
/*     */       }
/*     */     },
/* 214 */     choice
/*     */     {
/*     */       Object toArg(Attributes attrs, int tag, int index) {
/* 217 */         return Double.valueOf(attrs.getDouble(tag, index, 0.0D));
/*     */       }
/*     */     },
/* 220 */     hash
/*     */     {
/*     */       Object toArg(Attributes attrs, int tag, int index) {
/* 223 */         String s = attrs.getString(tag, index);
/* 224 */         return (s != null) ? TagUtils.toHexString(s.hashCode()) : null;
/*     */       }
/*     */     },
/* 227 */     urlencoded
/*     */     {
/*     */       Object toArg(Attributes attrs, int tag, int index) {
/* 230 */         String s = attrs.getString(tag, index);
/*     */         try {
/* 232 */           return (s != null) ? URLEncoder.encode(s, "UTF-8") : null;
/* 233 */         } catch (UnsupportedEncodingException e) {
/* 234 */           throw new AssertionError(e);
/*     */         } 
/*     */       }
/*     */     };
/*     */     
/*     */     abstract Object toArg(Attributes param1Attributes, int param1Int1, int param1Int2);
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/util/AttributesFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */