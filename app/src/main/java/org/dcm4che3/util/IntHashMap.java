/*     */ package org.dcm4che3.util;
/*     */ 
/*     */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IntHashMap<V>
/*     */   implements Cloneable, Serializable
/*     */ {
/*     */   private static final int DEFAULT_CAPACITY = 32;
/*     */   private static final int MINIMUM_CAPACITY = 4;
/*     */   private static final int MAXIMUM_CAPACITY = 1073741824;
/*     */   private static final byte FREE = 0;
/*     */   private static final byte FULL = 1;
/*     */   private static final byte REMOVED = -1;
/*     */   private transient int[] keys;
/*     */   private transient Object[] values;
/*     */   private transient byte[] states;
/*     */   private transient int free;
/*     */   private transient int size;
/*     */   private static final long serialVersionUID = 9153226350279204066L;
/*     */   
/*     */   public IntHashMap() {
/*  63 */     init(32);
/*     */   }
/*     */   
/*     */   public IntHashMap(int expectedMaxSize) {
/*  67 */     if (expectedMaxSize < 0) {
/*  68 */       throw new IllegalArgumentException("expectedMaxSize is negative: " + expectedMaxSize);
/*     */     }
/*     */     
/*  71 */     init(capacity(expectedMaxSize));
/*     */   }
/*     */   
/*     */   private int capacity(int expectedMaxSize) {
/*  75 */     int minCapacity = expectedMaxSize << 1;
/*  76 */     if (minCapacity > 1073741824) {
/*  77 */       return 1073741824;
/*     */     }
/*  79 */     int capacity = 4;
/*  80 */     while (capacity < minCapacity) {
/*  81 */       capacity <<= 1;
/*     */     }
/*  83 */     return capacity;
/*     */   }
/*     */   
/*     */   private void init(int initCapacity) {
/*  87 */     this.keys = new int[initCapacity];
/*  88 */     this.values = new Object[initCapacity];
/*  89 */     this.states = new byte[initCapacity];
/*  90 */     this.free = initCapacity >>> 1;
/*     */   }
/*     */   
/*     */   public int size() {
/*  94 */     return this.size;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  98 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V get(int key) {
/* 104 */     byte[] states = this.states;
/* 105 */     int[] keys = this.keys;
/* 106 */     int mask = keys.length - 1;
/* 107 */     int i = key & mask;
/* 108 */     while (states[i] != 0) {
/* 109 */       if (keys[i] == key)
/* 110 */         return (V)this.values[i]; 
/* 111 */       i = i + 1 & mask;
/*     */     } 
/* 113 */     return null;
/*     */   }
/*     */   
/*     */   public boolean containsKey(int key) {
/* 117 */     byte[] states = this.states;
/* 118 */     int[] keys = this.keys;
/* 119 */     int mask = keys.length - 1;
/* 120 */     int i = key & mask;
/* 121 */     while (states[i] != 0) {
/* 122 */       if (keys[i] == key)
/* 123 */         return (states[i] > 0); 
/* 124 */       i = i + 1 & mask;
/*     */     } 
/* 126 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public V put(int key, V value) {
/* 131 */     byte[] states = this.states;
/* 132 */     int[] keys = this.keys;
/* 133 */     int mask = keys.length - 1;
/* 134 */     int i = key & mask;
/*     */     
/* 136 */     while (states[i] > 0) {
/* 137 */       if (keys[i] == key) {
/* 138 */         V oldValue = (V)this.values[i];
/* 139 */         this.values[i] = value;
/* 140 */         return oldValue;
/*     */       } 
/* 142 */       i = i + 1 & mask;
/*     */     } 
/* 144 */     byte oldState = states[i];
/* 145 */     states[i] = 1;
/* 146 */     keys[i] = key;
/* 147 */     this.values[i] = value;
/* 148 */     this.size++;
/* 149 */     if (oldState == 0 && --this.free < 0)
/* 150 */       resize(Math.max(capacity(this.size), keys.length)); 
/* 151 */     return null;
/*     */   }
/*     */   
/*     */   public void trimToSize() {
/* 155 */     resize(capacity(this.size));
/*     */   }
/*     */   
/*     */   public void rehash() {
/* 159 */     resize(this.keys.length);
/*     */   }
/*     */   
/*     */   private void resize(int newLength) {
/* 163 */     if (newLength > 1073741824) {
/* 164 */       throw new IllegalStateException("Capacity exhausted.");
/*     */     }
/* 166 */     int[] oldKeys = this.keys;
/* 167 */     Object[] oldValues = this.values;
/* 168 */     byte[] oldStates = this.states;
/* 169 */     int[] newKeys = new int[newLength];
/* 170 */     Object[] newValues = new Object[newLength];
/* 171 */     byte[] newStates = new byte[newLength];
/* 172 */     int mask = newLength - 1;
/*     */     
/* 174 */     for (int j = 0; j < oldKeys.length; j++) {
/* 175 */       if (oldStates[j] > 0) {
/* 176 */         int key = oldKeys[j];
/* 177 */         int i = key & mask;
/* 178 */         while (newStates[i] != 0)
/* 179 */           i = i + 1 & mask; 
/* 180 */         newStates[i] = 1;
/* 181 */         newKeys[i] = key;
/* 182 */         newValues[i] = oldValues[j];
/* 183 */         oldValues[j] = null;
/*     */       } 
/*     */     } 
/* 186 */     this.keys = newKeys;
/* 187 */     this.values = newValues;
/* 188 */     this.states = newStates;
/* 189 */     this.free = (newLength >>> 1) - this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public V remove(int key) {
/* 194 */     byte[] states = this.states;
/* 195 */     int[] keys = this.keys;
/* 196 */     int mask = keys.length - 1;
/* 197 */     int i = key & mask;
/* 198 */     while (states[i] != 0) {
/* 199 */       if (keys[i] == key) {
/* 200 */         if (states[i] < 0) {
/* 201 */           return null;
/*     */         }
/* 203 */         states[i] = -1;
/* 204 */         V oldValue = (V)this.values[i];
/* 205 */         this.values[i] = null;
/* 206 */         this.size--;
/* 207 */         return oldValue;
/*     */       } 
/* 209 */       i = i + 1 & mask;
/*     */     } 
/* 211 */     return null;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 215 */     Arrays.fill(this.values, (Object)null);
/* 216 */     Arrays.fill(this.states, (byte)0);
/* 217 */     this.size = 0;
/* 218 */     this.free = this.keys.length >>> 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() {
/*     */     try {
/* 224 */       IntHashMap<V> m = (IntHashMap<V>)super.clone();
/* 225 */       m.states = (byte[])this.states.clone();
/* 226 */       m.keys = (int[])this.keys.clone();
/* 227 */       m.values = (Object[])this.values.clone();
/* 228 */       return m;
/* 229 */     } catch (CloneNotSupportedException e) {
/* 230 */       throw new InternalError();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean accept(Visitor<V> visitor) {
/* 240 */     for (int i = 0; i < this.states.length; i++) {
/* 241 */       if (this.states[i] > 0 && 
/* 242 */         !visitor.visit(this.keys[i], (V)this.values[i]))
/* 243 */         return false; 
/* 244 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream s) throws IOException {
/* 251 */     s.defaultWriteObject();
/*     */     
/* 253 */     byte[] states = this.states;
/* 254 */     int[] keys = this.keys;
/* 255 */     Object[] values = this.values;
/* 256 */     s.writeInt(this.size);
/* 257 */     for (int i = 0; i < states.length; i++) {
/* 258 */       if (states[i] > 0) {
/* 259 */         s.writeInt(keys[i]);
/* 260 */         s.writeObject(values[i]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
/* 267 */     s.defaultReadObject();
/*     */     
/* 269 */     int count = s.readInt();
/* 270 */     init(capacity(count));
/* 271 */     this.size = count;
/* 272 */     this.free -= count;
/*     */     
/* 274 */     byte[] states = this.states;
/* 275 */     int[] keys = this.keys;
/* 276 */     Object[] values = this.values;
/* 277 */     int mask = keys.length - 1;
/*     */     
/* 279 */     while (count-- > 0) {
/* 280 */       int key = s.readInt();
/* 281 */       int i = key & mask;
/* 282 */       while (states[i] != 0)
/* 283 */         i = i + 1 & mask; 
/* 284 */       states[i] = 1;
/* 285 */       keys[i] = key;
/* 286 */       values[i] = s.readObject();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static interface Visitor<V> {
/*     */     boolean visit(int param1Int, V param1V);
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/util/IntHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */