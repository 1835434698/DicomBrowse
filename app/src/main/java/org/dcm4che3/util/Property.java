/*     */ package org.dcm4che3.util;
/*     */ 
/*     */

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Property
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 6618989493749845502L;
/*     */   private final String name;
/*     */   private final Object value;
/*     */   
/*     */   public Property(String name, Object value) {
/*  57 */     if (name == null)
/*  58 */       throw new NullPointerException("name"); 
/*  59 */     if (value == null) {
/*  60 */       throw new NullPointerException("value");
/*     */     }
/*  62 */     if (!(value instanceof String) && !(value instanceof Boolean) && !(value instanceof Number))
/*     */     {
/*     */       
/*  65 */       throw new IllegalArgumentException("value: " + value.getClass());
/*     */     }
/*  67 */     this.name = name;
/*  68 */     this.value = value;
/*     */   }
/*     */   
/*     */   public Property(String s) {
/*  72 */     int endParamName = s.indexOf('=');
/*  73 */     this.name = s.substring(0, endParamName);
/*  74 */     this.value = valueOf(s.substring(endParamName + 1));
/*     */   }
/*     */   
/*     */   public final String getName() {
/*  78 */     return this.name;
/*     */   }
/*     */   
/*     */   public final Object getValue() {
/*  82 */     return this.value;
/*     */   }
/*     */   
/*     */   private static Object valueOf(String s) {
/*     */     try {
/*  87 */       return Double.valueOf(s);
/*  88 */     } catch (NumberFormatException e) {
/*  89 */       return s.equalsIgnoreCase("true") ? Boolean.TRUE : (s.equalsIgnoreCase("false") ? Boolean.FALSE : s);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  97 */     return 31 * this.name.hashCode() + this.value.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 102 */     if (this == obj)
/* 103 */       return true; 
/* 104 */     if (obj == null)
/* 105 */       return false; 
/* 106 */     if (getClass() != obj.getClass()) {
/* 107 */       return false;
/*     */     }
/* 109 */     Property other = (Property)obj;
/* 110 */     return (this.name.equals(other.name) && this.value.equals(other.value));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 116 */     return this.name + '=' + this.value;
/*     */   }
/*     */   
/*     */   public void setAt(Object o) {
/* 120 */     String setterName = "set" + this.name.substring(0, 1).toUpperCase(Locale.ENGLISH) + this.name.substring(1);
/*     */ 
/*     */     
/*     */     try {
/* 124 */       Class<?> clazz = o.getClass();
/* 125 */       if (this.value instanceof String) {
/* 126 */         clazz.getMethod(setterName, new Class[] { String.class }).invoke(o, new Object[] { this.value });
/* 127 */       } else if (this.value instanceof Boolean) {
/* 128 */         clazz.getMethod(setterName, new Class[] { boolean.class }).invoke(o, new Object[] { this.value });
/*     */       } else {
/*     */         try {
/* 131 */           clazz.getMethod(setterName, new Class[] { double.class }).invoke(o, new Object[] { Double.valueOf(((Number)this.value).doubleValue()) });
/*     */         }
/* 133 */         catch (NoSuchMethodException e) {
/*     */           try {
/* 135 */             clazz.getMethod(setterName, new Class[] { float.class }).invoke(o, new Object[] { Float.valueOf(((Number)this.value).floatValue()) });
/*     */           }
/* 137 */           catch (NoSuchMethodException e2) {
/*     */             try {
/* 139 */               clazz.getMethod(setterName, new Class[] { int.class }).invoke(o, new Object[] { Integer.valueOf(((Number)this.value).intValue()) });
/*     */             }
/* 141 */             catch (NoSuchMethodException e3) {
/* 142 */               throw e;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 147 */     } catch (NoSuchMethodException e) {
/* 148 */       throw new IllegalArgumentException(e.getMessage());
/* 149 */     } catch (IllegalAccessException e) {
/* 150 */       throw new IllegalArgumentException(e.getMessage());
/* 151 */     } catch (InvocationTargetException e) {
/* 152 */       throw new IllegalArgumentException(e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Property[] valueOf(String[] ss) {
/* 157 */     Property[] properties = new Property[ss.length];
/* 158 */     for (int i = 0; i < properties.length; i++) {
/* 159 */       properties[i] = new Property(ss[i]);
/*     */     }
/* 161 */     return properties;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/util/Property.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */