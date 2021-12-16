/*     */ package org.dcm4che3.media;
/*     */ 
/*     */

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.VR;
import org.dcm4che3.io.DicomInputStream;
import org.dcm4che3.io.RAFInputStreamAdapter;
import org.dcm4che3.util.IntHashMap;
import org.dcm4che3.util.SafeClose;
import org.dcm4che3.util.StringUtils;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DicomDirReader
/*     */   implements Closeable
/*     */ {
/*     */   protected final File file;
/*     */   protected final RandomAccessFile raf;
/*     */   protected final DicomInputStream in;
/*     */   protected final Attributes fmi;
/*     */   protected final Attributes fsInfo;
/*  66 */   protected final IntHashMap<Attributes> cache = new IntHashMap();
/*     */   
/*     */   public DicomDirReader(File file) throws IOException {
/*  69 */     this(file, "r");
/*     */   }
/*     */   
/*     */   protected DicomDirReader(File file, String mode) throws IOException {
/*  73 */     this.file = file;
/*  74 */     this.raf = new RandomAccessFile(file, mode);
/*     */     try {
/*  76 */       this.in = new DicomInputStream((InputStream)new RAFInputStreamAdapter(this.raf));
/*  77 */       this.fmi = this.in.readFileMetaInformation();
/*  78 */       this.fsInfo = this.in.readDataset(-1, 266784);
/*  79 */       if (this.in.tag() != 266784)
/*  80 */         throw new IOException("Missing Directory Record Sequence"); 
/*  81 */     } catch (IOException e) {
/*  82 */       SafeClose.close(this.raf);
/*  83 */       throw e;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final File getFile() {
/*  88 */     return this.file;
/*     */   }
/*     */   
/*     */   public final Attributes getFileMetaInformation() {
/*  92 */     return this.fmi;
/*     */   }
/*     */   
/*     */   public final Attributes getFileSetInformation() {
/*  96 */     return this.fsInfo;
/*     */   }
/*     */   
/*     */   public void close() throws IOException {
/* 100 */     this.raf.close();
/*     */   }
/*     */   
/*     */   public String getFileSetUID() {
/* 104 */     return this.fmi.getString(131075, null);
/*     */   }
/*     */   
/*     */   public String getTransferSyntaxUID() {
/* 108 */     return this.fmi.getString(131088, null);
/*     */   }
/*     */   
/*     */   public String getFileSetID() {
/* 112 */     return this.fsInfo.getString(266544, null);
/*     */   }
/*     */   
/*     */   public File getDescriptorFile() {
/* 116 */     return toFile(this.fsInfo.getStrings(266561));
/*     */   }
/*     */   
/*     */   public File toFile(String[] fileIDs) {
/* 120 */     if (fileIDs == null || fileIDs.length == 0) {
/* 121 */       return null;
/*     */     }
/* 123 */     return new File(this.file.getParent(), StringUtils.concat(fileIDs, File.separatorChar));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDescriptorFileCharacterSet() {
/* 128 */     return this.fsInfo.getString(266562, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFileSetConsistencyFlag() {
/* 133 */     return this.fsInfo.getInt(266770, 0);
/*     */   }
/*     */   
/*     */   protected void setFileSetConsistencyFlag(int i) {
/* 137 */     this.fsInfo.setInt(266770, VR.US, new int[] { i });
/*     */   }
/*     */   
/*     */   public boolean knownInconsistencies() {
/* 141 */     return (getFileSetConsistencyFlag() != 0);
/*     */   }
/*     */   
/*     */   public int getOffsetOfFirstRootDirectoryRecord() {
/* 145 */     return this.fsInfo.getInt(266752, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setOffsetOfFirstRootDirectoryRecord(int i) {
/* 150 */     this.fsInfo.setInt(266752, VR.UL, new int[] { i });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOffsetOfLastRootDirectoryRecord() {
/* 156 */     return this.fsInfo.getInt(266754, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setOffsetOfLastRootDirectoryRecord(int i) {
/* 161 */     this.fsInfo.setInt(266754, VR.UL, new int[] { i });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 167 */     return (getOffsetOfFirstRootDirectoryRecord() == 0);
/*     */   }
/*     */   
/*     */   public void clearCache() {
/* 171 */     this.cache.clear();
/*     */   }
/*     */   
/*     */   public Attributes readFirstRootDirectoryRecord() throws IOException {
/* 175 */     return readRecord(getOffsetOfFirstRootDirectoryRecord());
/*     */   }
/*     */   
/*     */   public Attributes readLastRootDirectoryRecord() throws IOException {
/* 179 */     return readRecord(getOffsetOfLastRootDirectoryRecord());
/*     */   }
/*     */ 
/*     */   
/*     */   public Attributes readNextDirectoryRecord(Attributes rec) throws IOException {
/* 184 */     return readRecord(rec.getInt(267264, 0));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes readLowerDirectoryRecord(Attributes rec) throws IOException {
/* 190 */     return readRecord(rec.getInt(267296, 0));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Attributes findLastLowerDirectoryRecord(Attributes rec) throws IOException {
/* 196 */     Attributes lower = readLowerDirectoryRecord(rec);
/* 197 */     if (lower == null) {
/* 198 */       return null;
/*     */     }
/*     */     Attributes next;
/* 201 */     while ((next = readNextDirectoryRecord(lower)) != null)
/* 202 */       lower = next; 
/* 203 */     return lower;
/*     */   }
/*     */   
/*     */   public Attributes findFirstRootDirectoryRecordInUse(boolean ignorePrivate) throws IOException {
/* 207 */     return findRootDirectoryRecord(ignorePrivate, (Attributes)null, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes findRootDirectoryRecord(Attributes keys, boolean ignorePrivate, boolean ignoreCaseOfPN, boolean matchNoValue) throws IOException {
/* 213 */     return findRecordInUse(getOffsetOfFirstRootDirectoryRecord(), ignorePrivate, keys, ignoreCaseOfPN, matchNoValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes findRootDirectoryRecord(boolean ignorePrivate, Attributes keys, boolean ignoreCaseOfPN, boolean matchNoValue) throws IOException {
/* 219 */     return findRootDirectoryRecord(keys, ignorePrivate, ignoreCaseOfPN, matchNoValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attributes findNextDirectoryRecordInUse(Attributes rec, boolean ignorePrivate) throws IOException {
/* 224 */     return findNextDirectoryRecord(rec, ignorePrivate, null, false, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attributes findNextDirectoryRecord(Attributes rec, boolean ignorePrivate, Attributes keys, boolean ignoreCaseOfPN, boolean matchNoValue) throws IOException {
/* 229 */     return findRecordInUse(rec.getInt(267264, 0), ignorePrivate, keys, ignoreCaseOfPN, matchNoValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes findLowerDirectoryRecordInUse(Attributes rec, boolean ignorePrivate) throws IOException {
/* 236 */     return findLowerDirectoryRecord(rec, ignorePrivate, null, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes findLowerDirectoryRecord(Attributes rec, boolean ignorePrivate, Attributes keys, boolean ignoreCaseOfPN, boolean matchNoValue) throws IOException {
/* 242 */     return findRecordInUse(rec.getInt(267296, 0), ignorePrivate, keys, ignoreCaseOfPN, matchNoValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes findPatientRecord(String... ids) throws IOException {
/* 248 */     return findRootDirectoryRecord(false, pk("PATIENT", 1048608, VR.LO, ids), false, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attributes findNextPatientRecord(Attributes patRec, String... ids) throws IOException {
/* 253 */     return findNextDirectoryRecord(patRec, false, pk("PATIENT", 1048608, VR.LO, ids), false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes findStudyRecord(Attributes patRec, String... iuids) throws IOException {
/* 259 */     return findLowerDirectoryRecord(patRec, false, pk("STUDY", 2097165, VR.UI, iuids), false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes findNextStudyRecord(Attributes studyRec, String... iuids) throws IOException {
/* 266 */     return findNextDirectoryRecord(studyRec, false, pk("STUDY", 2097165, VR.UI, iuids), false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes findSeriesRecord(Attributes studyRec, String... iuids) throws IOException {
/* 273 */     return findLowerDirectoryRecord(studyRec, false, pk("SERIES", 2097166, VR.UI, iuids), false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes findNextSeriesRecord(Attributes seriesRec, String... iuids) throws IOException {
/* 280 */     return findNextDirectoryRecord(seriesRec, false, pk("SERIES", 2097166, VR.UI, iuids), false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attributes findLowerInstanceRecord(Attributes seriesRec, boolean ignorePrivate, String... iuids) throws IOException {
/* 287 */     return findLowerDirectoryRecord(seriesRec, ignorePrivate, pk(iuids), false, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attributes findNextInstanceRecord(Attributes instRec, boolean ignorePrivate, String... iuids) throws IOException {
/* 292 */     return findNextDirectoryRecord(instRec, ignorePrivate, pk(iuids), false, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attributes findRootInstanceRecord(boolean ignorePrivate, String... iuids) throws IOException {
/* 297 */     return findRootDirectoryRecord(ignorePrivate, pk(iuids), false, false);
/*     */   }
/*     */   
/*     */   private Attributes pk(String type, int tag, VR vrTag, String... ids) {
/* 301 */     Attributes pk = new Attributes(2);
/* 302 */     pk.setString(267312, VR.CS, type);
/* 303 */     if (ids != null && ids.length != 0)
/* 304 */       pk.setString(tag, vrTag, ids);
/* 305 */     return pk;
/*     */   }
/*     */   
/*     */   private Attributes pk(String... iuids) {
/* 309 */     if (iuids == null || iuids.length == 0) {
/* 310 */       return null;
/*     */     }
/* 312 */     Attributes pk = new Attributes(1);
/* 313 */     pk.setString(267537, VR.UI, iuids);
/* 314 */     return pk;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Attributes findRecordInUse(int offset, boolean ignorePrivate, Attributes keys, boolean ignoreCaseOfPN, boolean matchNoValue) throws IOException {
/* 320 */     while (offset != 0) {
/* 321 */       Attributes item = readRecord(offset);
/* 322 */       if (inUse(item) && (!ignorePrivate || !isPrivate(item)) && (keys == null || item.matches(keys, ignoreCaseOfPN, matchNoValue)))
/*     */       {
/* 324 */         return item; } 
/* 325 */       offset = item.getInt(267264, 0);
/*     */     } 
/* 327 */     return null;
/*     */   }
/*     */   
/*     */   private synchronized Attributes readRecord(int offset) throws IOException {
/* 331 */     if (offset == 0) {
/* 332 */       return null;
/*     */     }
/* 334 */     Attributes item = (Attributes)this.cache.get(offset);
/* 335 */     if (item == null) {
/* 336 */       long off = offset & 0xFFFFFFFFL;
/* 337 */       this.raf.seek(off);
/* 338 */       this.in.setPosition(off);
/* 339 */       item = this.in.readItem();
/* 340 */       this.cache.put(offset, item);
/*     */     } 
/* 342 */     return item;
/*     */   }
/*     */   
/*     */   public static boolean inUse(Attributes rec) {
/* 346 */     return (rec.getInt(267280, 0) != 0);
/*     */   }
/*     */   
/*     */   public static boolean isPrivate(Attributes rec) {
/* 350 */     return "PRIVATE".equals(rec.getString(267312));
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/media/DicomDirReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */