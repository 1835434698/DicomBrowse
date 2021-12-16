/*     */ package org.dcm4che3.emf;
/*     */ 
/*     */

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.BulkData;
import org.dcm4che3.data.Fragments;
import org.dcm4che3.data.Sequence;
import org.dcm4che3.data.VR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MultiframeExtractor
/*     */ {
/*     */   private enum Impl
/*     */   {
/*  55 */     EnhancedCTImageExtractor("1.2.840.10008.5.1.4.1.1.2"),
/*  56 */     EnhancedMRImageExtractor("1.2.840.10008.5.1.4.1.1.4") {
/*     */       Attributes extract(MultiframeExtractor mfe, Attributes emf, int frame) {
/*  58 */         Attributes sf = super.extract(mfe, emf, frame);
/*  59 */         setEchoTime(sf);
/*  60 */         setScanningSequence(sf);
/*  61 */         setSequenceVariant(sf);
/*  62 */         setScanOptions(sf);
/*  63 */         return sf;
/*     */       }
/*     */       
/*     */       void setEchoTime(Attributes sf) {
/*  67 */         double echoTime = sf.getDouble(1609858, 0.0D);
/*  68 */         if (echoTime == 0.0D) {
/*  69 */           sf.setNull(1572993, VR.DS);
/*     */         } else {
/*  71 */           sf.setDouble(1572993, VR.DS, new double[] { echoTime });
/*     */         } 
/*     */       }
/*     */       void setScanningSequence(Attributes sf) {
/*  75 */         ArrayList<String> list = new ArrayList<String>(3);
/*     */         
/*  77 */         String eps = sf.getString(1609736);
/*  78 */         if (!"GRADIENT".equals(eps))
/*  79 */           list.add("SE"); 
/*  80 */         if (!"SPIN".equals(eps))
/*  81 */           list.add("GR"); 
/*  82 */         if ("YES".equals(sf.getString(1609737)))
/*  83 */           list.add("IR"); 
/*  84 */         if ("YES".equals(sf.getString(1609752)))
/*  85 */           list.add("EP"); 
/*  86 */         sf.setString(1572896, VR.CS, list.<String>toArray(new String[list.size()]));
/*     */       }
/*     */ 
/*     */       
/*     */       void setSequenceVariant(Attributes sf) {
/*  91 */         ArrayList<String> list = new ArrayList<String>(5);
/*  92 */         if (!"SINGLE".equals(sf.getString(1609779)))
/*  93 */           list.add("SK"); 
/*  94 */         String mf = sf.getString(1609760);
/*  95 */         if (mf != null && !"NONE".equals(mf))
/*  96 */           list.add("MTC"); 
/*  97 */         String ssps = sf.getString(1609751);
/*  98 */         if (ssps != null && !"NONE".equals(ssps))
/*  99 */           list.add("TIME_REVERSED".equals(ssps) ? "TRSS" : "SS"); 
/* 100 */         String sp = sf.getString(1609750);
/* 101 */         if (sp != null && !"NONE".equals(sp))
/* 102 */           list.add("SP"); 
/* 103 */         String op = sf.getString(1609769);
/* 104 */         if (op != null && !"NONE".equals(op))
/* 105 */           list.add("OSP"); 
/* 106 */         if (list.isEmpty())
/* 107 */           list.add("NONE"); 
/* 108 */         sf.setString(1572897, VR.CS, list.<String>toArray(new String[list.size()]));
/*     */       }
/*     */ 
/*     */       
/*     */       void setScanOptions(Attributes sf) {
/* 113 */         ArrayList<String> list = new ArrayList<String>(3);
/* 114 */         String per = sf.getString(1609780);
/* 115 */         if (per != null && !"LINEAR".equals(per))
/* 116 */           list.add("PER"); 
/* 117 */         String frameType3 = sf.getString(524296, 2);
/* 118 */         if ("ANGIO".equals(frameType3))
/* 119 */           sf.setString(1572901, VR.CS, "Y");
/* 120 */         if (frameType3.startsWith("CARD"))
/* 121 */           list.add("CG"); 
/* 122 */         if (frameType3.endsWith("RESP_GATED"))
/* 123 */           list.add("RG"); 
/* 124 */         String pfd = sf.getString(1609782);
/* 125 */         if ("PHASE".equals(pfd))
/* 126 */           list.add("PFP"); 
/* 127 */         if ("FREQUENCY".equals(pfd))
/* 128 */           list.add("PFF"); 
/* 129 */         String sp = sf.getString(1609767);
/* 130 */         if (sp != null && !"NONE".equals(sp))
/* 131 */           list.add("SP"); 
/* 132 */         String sss = sf.getString(1609765);
/* 133 */         if (sss != null && sss.startsWith("FAT"))
/* 134 */           list.add("FS"); 
/* 135 */         String fc = sf.getString(1609744);
/* 136 */         if (fc != null && !"NONE".equals(fc))
/* 137 */           list.add("FC"); 
/* 138 */         sf.setString(1572898, VR.CS, list.<String>toArray(new String[list.size()]));
/*     */       }
/*     */     },
/*     */ 
/*     */     
/* 143 */     EnhancedPETImageExtractor("1.2.840.10008.5.1.4.1.1.128");
/*     */     
/*     */     private final String sfcuid;
/*     */     
/*     */     Impl(String sfcuid) {
/* 148 */       this.sfcuid = sfcuid;
/*     */     }
/*     */     
/*     */     Attributes extract(MultiframeExtractor mfe, Attributes emf, int frame) {
/* 152 */       return mfe.extract(emf, frame, this.sfcuid);
/*     */     }
/*     */   }
/*     */   
/* 156 */   private static final HashMap<String, Impl> impls = new HashMap<String, Impl>(8);
/*     */   static {
/* 158 */     impls.put("1.2.840.10008.5.1.4.1.1.2.1", Impl.EnhancedCTImageExtractor);
/* 159 */     impls.put("1.2.840.10008.5.1.4.1.1.4.1", Impl.EnhancedMRImageExtractor);
/* 160 */     impls.put("1.2.840.10008.5.1.4.1.1.130", Impl.EnhancedPETImageExtractor);
/*     */   }
/*     */   
/* 163 */   private static final int[] EXCLUDE_TAGS = new int[] { 561298, 561492, 2134562, 2621448, 1375769129, 1375769136, 2145386512 };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean preserveSeriesInstanceUID;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 173 */   private String instanceNumberFormat = "%s%04d";
/* 174 */   private UIDMapper uidMapper = new HashUIDMapper();
/* 175 */   private NumberOfFramesAccessor nofAccessor = new NumberOfFramesAccessor();
/*     */   
/*     */   public static boolean isSupportedSOPClass(String cuid) {
/* 178 */     return impls.containsKey(cuid);
/*     */   }
/*     */   
/*     */   public static String legacySOPClassUID(String mfcuid) {
/* 182 */     Impl impl = impls.get(mfcuid);
/* 183 */     return (impl != null) ? impl.sfcuid : null;
/*     */   }
/*     */   
/*     */   public final boolean isPreserveSeriesInstanceUID() {
/* 187 */     return this.preserveSeriesInstanceUID;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setPreserveSeriesInstanceUID(boolean preserveSeriesInstanceUID) {
/* 192 */     this.preserveSeriesInstanceUID = preserveSeriesInstanceUID;
/*     */   }
/*     */   
/*     */   public final String getInstanceNumberFormat() {
/* 196 */     return this.instanceNumberFormat;
/*     */   }
/*     */   
/*     */   public final void setInstanceNumberFormat(String instanceNumberFormat) {
/* 200 */     String.format(instanceNumberFormat, new Object[] { "1", Integer.valueOf(1) });
/* 201 */     this.instanceNumberFormat = instanceNumberFormat;
/*     */   }
/*     */   
/*     */   public final UIDMapper getUIDMapper() {
/* 205 */     return this.uidMapper;
/*     */   }
/*     */   
/*     */   public final void setUIDMapper(UIDMapper uidMapper) {
/* 209 */     if (uidMapper == null)
/* 210 */       throw new NullPointerException(); 
/* 211 */     this.uidMapper = uidMapper;
/*     */   }
/*     */   
/*     */   public final NumberOfFramesAccessor getNumberOfFramesAccessorr() {
/* 215 */     return this.nofAccessor;
/*     */   }
/*     */   
/*     */   public final void setNumberOfFramesAccessor(NumberOfFramesAccessor accessor) {
/* 219 */     if (accessor == null)
/* 220 */       throw new NullPointerException(); 
/* 221 */     this.nofAccessor = accessor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes extract(Attributes emf, int frame) {
/* 232 */     return implFor(emf.getString(524310)).extract(this, emf, frame);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Impl implFor(String mfcuid) {
/* 237 */     Impl impl = impls.get(mfcuid);
/* 238 */     if (impl == null) {
/* 239 */       throw new IllegalArgumentException("Unsupported SOP Class: " + mfcuid);
/*     */     }
/* 241 */     return impl;
/*     */   }
/*     */   
/*     */   private Attributes extract(Attributes emf, int frame, String cuid) {
/* 245 */     Attributes sfgs = emf.getNestedDataset(1375769129);
/* 246 */     if (sfgs == null) {
/* 247 */       throw new IllegalArgumentException("Missing (5200,9229) Shared Functional Groups Sequence");
/*     */     }
/* 249 */     Attributes fgs = emf.getNestedDataset(1375769136, frame);
/* 250 */     if (fgs == null) {
/* 251 */       throw new IllegalArgumentException("Missing (5200,9230) Per-frame Functional Groups Sequence Item for frame #" + (frame + 1));
/*     */     }
/* 253 */     Attributes dest = new Attributes(emf.size() * 2);
/* 254 */     dest.addNotSelected(emf, EXCLUDE_TAGS);
/* 255 */     addFunctionGroups(dest, sfgs);
/* 256 */     addFunctionGroups(dest, fgs);
/* 257 */     addPixelData(dest, emf, frame);
/* 258 */     dest.setString(524310, VR.UI, cuid);
/* 259 */     dest.setString(524312, VR.UI, this.uidMapper.get(dest.getString(524312)) + '.' + (frame + 1));
/*     */     
/* 261 */     dest.setString(2097171, VR.IS, createInstanceNumber(dest.getString(2097171, ""), frame));
/*     */     
/* 263 */     dest.setString(524296, VR.CS, dest.getStrings(561159));
/* 264 */     dest.remove(561159);
/* 265 */     if (!this.preserveSeriesInstanceUID) {
/* 266 */       dest.setString(2097166, VR.UI, this.uidMapper.get(dest.getString(2097166)));
/*     */     }
/* 268 */     adjustReferencedImages(dest, 528704);
/* 269 */     adjustReferencedImages(dest, 532754);
/* 270 */     return dest;
/*     */   }
/*     */   
/*     */   private void adjustReferencedImages(Attributes attrs, int sqtag) {
/* 274 */     Sequence sq = attrs.getSequence(sqtag);
/* 275 */     if (sq == null) {
/*     */       return;
/*     */     }
/* 278 */     ArrayList<Attributes> newRefs = new ArrayList<Attributes>();
/* 279 */     for (Iterator<Attributes> itr = sq.iterator(); itr.hasNext(); ) {
/* 280 */       Attributes ref = itr.next();
/* 281 */       String cuid = legacySOPClassUID(ref.getString(528720));
/* 282 */       if (cuid == null) {
/*     */         continue;
/*     */       }
/* 285 */       itr.remove();
/* 286 */       String iuid = this.uidMapper.get(ref.getString(528725));
/* 287 */       int[] frames = ref.getInts(528736);
/* 288 */       int n = (frames == null) ? this.nofAccessor.getNumberOfFrames(iuid) : frames.length;
/*     */       
/* 290 */       ref.remove(528736);
/* 291 */       ref.setString(528720, VR.UI, cuid);
/* 292 */       for (int i = 0; i < n; i++) {
/* 293 */         Attributes newRef = new Attributes(ref);
/* 294 */         newRef.setString(528725, VR.UI, iuid + '.' + ((frames != null) ? frames[i] : (i + 1)));
/*     */         
/* 296 */         newRefs.add(newRef);
/*     */       } 
/*     */     } 
/* 299 */     for (Attributes ref : newRefs)
/* 300 */       sq.add(ref); 
/*     */   }
/*     */   
/*     */   private void addFunctionGroups(Attributes dest, Attributes fgs) {
/* 304 */     dest.addSelected(fgs, new int[] { 528704 });
/*     */     
/* 306 */     for (int sqTag : fgs.tags()) {
/* 307 */       Attributes fg; if (sqTag != 528704 && (fg = fgs.getNestedDataset(sqTag)) != null)
/*     */       {
/* 309 */         dest.addAll(fg); } 
/*     */     } 
/*     */   }
/*     */   private void addPixelData(Attributes dest, Attributes src, int frame) {
/* 313 */     VR.Holder vr = new VR.Holder();
/* 314 */     Object pixelData = src.getValue(2145386512, vr);
/* 315 */     if (pixelData instanceof byte[]) {
/* 316 */       dest.setBytes(2145386512, vr.vr, extractPixelData((byte[])pixelData, frame, calcFrameLength(src)));
/*     */     }
/* 318 */     else if (pixelData instanceof BulkData) {
/* 319 */       dest.setValue(2145386512, vr.vr, extractPixelData((BulkData)pixelData, frame, calcFrameLength(src)));
/*     */     } else {
/*     */       
/* 322 */       Fragments destFrags = dest.newFragments(2145386512, vr.vr, 2);
/* 323 */       destFrags.add(null);
/* 324 */       destFrags.add(((Fragments)pixelData).get(frame + 1));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private BulkData extractPixelData(BulkData src, int frame, int length) {
/* 330 */     return new BulkData(src.uriWithoutOffsetAndLength(), src.offset + (frame * length), length, src.bigEndian);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] extractPixelData(byte[] src, int frame, int length) {
/* 336 */     byte[] dest = new byte[length];
/* 337 */     System.arraycopy(src, frame * length, dest, 0, length);
/* 338 */     return dest;
/*     */   }
/*     */   
/*     */   private int calcFrameLength(Attributes src) {
/* 342 */     return src.getInt(2621456, 0) * src.getInt(2621457, 0) * (src.getInt(2621696, 8) >> 3) * src.getInt(1342185478, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String createInstanceNumber(String mfinstno, int frame) {
/* 349 */     String s = String.format(this.instanceNumberFormat, new Object[] { mfinstno, Integer.valueOf(frame + 1) });
/* 350 */     return (s.length() > 16) ? s.substring(s.length() - 16) : s;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/emf/MultiframeExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */