/*     */ package org.dcm4che3.media;
/*     */ 
/*     */

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.VR;
import org.dcm4che3.io.DicomEncodingOptions;
import org.dcm4che3.io.DicomOutputStream;
import org.dcm4che3.io.RAFOutputStreamAdapter;
import org.dcm4che3.util.ByteUtils;
import org.dcm4che3.util.StringUtils;
 // import org.slf4j.Logger;
 // import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DicomDirWriter
/*     */   extends DicomDirReader
/*     */ {
/*  66 */    // private static final Logger LOG = LoggerFactory.getLogger(DicomDirWriter.class);
/*     */   
/*     */   private static final int KNOWN_INCONSISTENCIES = 65535;
/*     */   
/*     */   private static final int NO_KNOWN_INCONSISTENCIES = 0;
/*     */   
/*     */   private static final int IN_USE = 65535;
/*     */   private static final int INACTIVE = 0;
/*  74 */   private final byte[] dirInfoHeader = new byte[] { 4, 0, 0, 18, 85, 76, 4, 0, 0, 0, 0, 0, 4, 0, 2, 18, 85, 76, 4, 0, 0, 0, 0, 0, 4, 0, 18, 18, 85, 83, 2, 0, 0, 0, 4, 0, 32, 18, 83, 81, 0, 0, 0, 0, 0, 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  80 */   private final byte[] dirRecordHeader = new byte[] { 4, 0, 0, 20, 85, 76, 4, 0, 0, 0, 0, 0, 4, 0, 16, 20, 85, 83, 2, 0, 0, 0, 4, 0, 32, 20, 85, 76, 4, 0, 0, 0, 0, 0 };
/*     */   
/*     */   private final DicomOutputStream out;
/*     */   
/*     */   private final int firstRecordPos;
/*     */   
/*     */   private int nextRecordPos;
/*     */   
/*  88 */   private int rollbackLen = -1;
/*  89 */   private IdentityHashMap<Attributes, Attributes> lastChildRecords = new IdentityHashMap<Attributes, Attributes>();
/*     */   
/*  91 */   private final ArrayList<Attributes> dirtyRecords = new ArrayList<Attributes>();
/*     */ 
/*     */   
/*     */   private DicomDirWriter(File file) throws IOException {
/*  95 */     super(file, "rw");
/*  96 */     this.out = new DicomOutputStream((OutputStream)new RAFOutputStreamAdapter(this.raf), getTransferSyntaxUID());
/*     */     
/*  98 */     int seqLen = this.in.length();
/*  99 */     boolean undefSeqLen = (seqLen <= 0);
/* 100 */     setEncodingOptions(new DicomEncodingOptions(false, undefSeqLen, false, undefSeqLen, false));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     this.nextRecordPos = this.firstRecordPos = (int)this.in.getPosition();
/* 107 */     if (!isEmpty())
/* 108 */       if (seqLen > 0) {
/* 109 */         this.nextRecordPos += seqLen;
/*     */       } else {
/* 111 */         this.nextRecordPos = (int)(this.raf.length() - 12L);
/*     */       }  
/* 113 */     updateDirInfoHeader();
/*     */   }
/*     */   
/*     */   public DicomEncodingOptions getEncodingOptions() {
/* 117 */     return this.out.getEncodingOptions();
/*     */   }
/*     */   
/*     */   public void setEncodingOptions(DicomEncodingOptions encOpts) {
/* 121 */     this.out.setEncodingOptions(encOpts);
/*     */   }
/*     */   
/*     */   public static DicomDirWriter open(File file) throws IOException {
/* 125 */     if (!file.isFile()) {
/* 126 */       throw new FileNotFoundException();
/*     */     }
/* 128 */     return new DicomDirWriter(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void createEmptyDirectory(File file, String iuid, String id, File descFile, String charset) throws IOException {
/* 133 */     Attributes fmi = Attributes.createFileMetaInformation(iuid, "1.2.840.10008.1.3.10", "1.2.840.10008.1.2.1");
/*     */     
/* 135 */     createEmptyDirectory(file, fmi, id, descFile, charset);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void createEmptyDirectory(File file, Attributes fmi, String id, File descFile, String charset) throws IOException {
/* 140 */     Attributes fsInfo = createFileSetInformation(file, id, descFile, charset);
/*     */     
/* 142 */     DicomOutputStream out = new DicomOutputStream(file);
/*     */     try {
/* 144 */       out.writeDataset(fmi, fsInfo);
/*     */     } finally {
/* 146 */       out.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static Attributes createFileSetInformation(File file, String id, File descFile, String charset) {
/* 152 */     Attributes fsInfo = new Attributes(7);
/* 153 */     fsInfo.setString(266544, VR.CS, id);
/* 154 */     if (descFile != null) {
/* 155 */       fsInfo.setString(266561, VR.CS, toFileIDs(file, descFile));
/*     */       
/* 157 */       if (charset != null && !charset.isEmpty()) {
/* 158 */         fsInfo.setString(266562, VR.CS, charset);
/*     */       }
/*     */     } 
/*     */     
/* 162 */     fsInfo.setInt(266752, VR.UL, new int[] { 0 });
/*     */ 
/*     */     
/* 165 */     fsInfo.setInt(266754, VR.UL, new int[] { 0 });
/*     */ 
/*     */     
/* 168 */     fsInfo.setInt(266770, VR.US, new int[] { 0 });
/* 169 */     fsInfo.setNull(266784, VR.SQ);
/* 170 */     return fsInfo;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Attributes addRootDirectoryRecord(Attributes rec) throws IOException {
/* 175 */     Attributes lastRootRecord = readLastRootDirectoryRecord();
/* 176 */     if (lastRootRecord == null) {
/* 177 */       writeRecord(this.firstRecordPos, rec);
/* 178 */       setOffsetOfFirstRootDirectoryRecord(this.firstRecordPos);
/*     */     } else {
/* 180 */       addRecord(267264, lastRootRecord, rec);
/*     */     } 
/* 182 */     setOffsetOfLastRootDirectoryRecord((int)rec.getItemPosition());
/* 183 */     return rec;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Attributes addLowerDirectoryRecord(Attributes parentRec, Attributes rec) throws IOException {
/* 188 */     Attributes prevRec = this.lastChildRecords.get(parentRec);
/* 189 */     if (prevRec == null) {
/* 190 */       prevRec = findLastLowerDirectoryRecord(parentRec);
/*     */     }
/* 192 */     if (prevRec != null) {
/* 193 */       addRecord(267264, prevRec, rec);
/*     */     } else {
/* 195 */       addRecord(267296, parentRec, rec);
/*     */     } 
/*     */     
/* 198 */     this.lastChildRecords.put(parentRec, rec);
/* 199 */     return rec;
/*     */   }
/*     */   
/*     */   public synchronized Attributes findOrAddPatientRecord(Attributes rec) throws IOException {
/* 203 */     Attributes patRec = findPatientRecord(new String[] { rec.getString(1048608) });
/* 204 */     return (patRec != null) ? patRec : addRootDirectoryRecord(rec);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Attributes findOrAddStudyRecord(Attributes patRec, Attributes rec) throws IOException {
/* 209 */     Attributes studyRec = findStudyRecord(patRec, new String[] { rec.getString(2097165) });
/* 210 */     return (studyRec != null) ? studyRec : addLowerDirectoryRecord(patRec, rec);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Attributes findOrAddSeriesRecord(Attributes studyRec, Attributes rec) throws IOException {
/* 215 */     Attributes seriesRec = findSeriesRecord(studyRec, new String[] { rec.getString(2097166) });
/* 216 */     return (seriesRec != null) ? seriesRec : addLowerDirectoryRecord(studyRec, rec);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized boolean deleteRecord(Attributes rec) throws IOException {
/* 221 */     if (rec.getInt(267280, 0) == 0) {
/* 222 */       return false;
/*     */     }
/* 224 */     Attributes lowerRec = readLowerDirectoryRecord(rec);
/* 225 */     for (; lowerRec != null; 
/* 226 */       lowerRec = readNextDirectoryRecord(lowerRec)) {
/* 227 */       deleteRecord(lowerRec);
/*     */     }
/* 229 */     rec.setInt(267280, VR.US, new int[] { 0 });
/* 230 */     markAsDirty(rec);
/* 231 */     return true;
/*     */   }
/*     */   
/*     */   public synchronized void rollback() throws IOException {
/* 235 */     if (this.dirtyRecords.isEmpty()) {
/*     */       return;
/*     */     }
/* 238 */     clearCache();
/* 239 */     this.dirtyRecords.clear();
/* 240 */     if (this.rollbackLen != -1) {
/* 241 */       restoreDirInfo();
/* 242 */       this.nextRecordPos = this.rollbackLen;
/* 243 */       if ((getEncodingOptions()).undefSequenceLength) {
/* 244 */         writeSequenceDelimitationItem();
/* 245 */         this.raf.setLength(this.raf.getFilePointer());
/*     */       } else {
/* 247 */         this.raf.setLength(this.rollbackLen);
/*     */       } 
/* 249 */       writeFileSetConsistencyFlag(0);
/* 250 */       this.rollbackLen = -1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clearCache() {
/* 255 */     this.lastChildRecords.clear();
/* 256 */     super.clearCache();
/*     */   }
/*     */   
/*     */   public synchronized void commit() throws IOException {
/* 260 */     if (this.dirtyRecords.isEmpty()) {
/*     */       return;
/*     */     }
/* 263 */     if (this.rollbackLen == -1) {
/* 264 */       writeFileSetConsistencyFlag(65535);
/*     */     }
/* 266 */     for (Attributes rec : this.dirtyRecords) {
/* 267 */       writeDirRecordHeader(rec);
/*     */     }
/* 269 */     this.dirtyRecords.clear();
/*     */     
/* 271 */     if (this.rollbackLen != -1 && (getEncodingOptions()).undefSequenceLength) {
/* 272 */       writeSequenceDelimitationItem();
/*     */     }
/* 274 */     writeDirInfoHeader();
/*     */     
/* 276 */     this.rollbackLen = -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 281 */     commit();
/* 282 */     super.close();
/*     */   }
/*     */   
/*     */   public String[] toFileIDs(File f) {
/* 286 */     return toFileIDs(this.file, f);
/*     */   }
/*     */   
/*     */   private static String[] toFileIDs(File dfile, File f) {
/* 290 */     String dfilepath = dfile.getAbsolutePath();
/* 291 */     int dend = dfilepath.lastIndexOf(File.separatorChar) + 1;
/* 292 */     String dpath = dfilepath.substring(0, dend);
/* 293 */     String fpath = f.getAbsolutePath();
/* 294 */     if (dend == 0 || !fpath.startsWith(dpath)) {
/* 295 */       throw new IllegalArgumentException("file: " + fpath + " not in directory: " + dfile.getAbsoluteFile());
/*     */     }
/* 297 */     return StringUtils.split(fpath.substring(dend), File.separatorChar);
/*     */   }
/*     */   
/*     */   private void updateDirInfoHeader() {
/* 301 */     ByteUtils.intToBytesLE(getOffsetOfFirstRootDirectoryRecord(), this.dirInfoHeader, 8);
/*     */ 
/*     */     
/* 304 */     ByteUtils.intToBytesLE(getOffsetOfLastRootDirectoryRecord(), this.dirInfoHeader, 20);
/*     */ 
/*     */     
/* 307 */     ByteUtils.intToBytesLE((getEncodingOptions()).undefSequenceLength ? -1 : (this.nextRecordPos - this.firstRecordPos), this.dirInfoHeader, 42);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void restoreDirInfo() {
/* 314 */     setOffsetOfFirstRootDirectoryRecord(ByteUtils.bytesToIntLE(this.dirInfoHeader, 8));
/*     */     
/* 316 */     setOffsetOfLastRootDirectoryRecord(ByteUtils.bytesToIntLE(this.dirInfoHeader, 20));
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeDirInfoHeader() throws IOException {
/* 321 */     updateDirInfoHeader();
/* 322 */     this.raf.seek((this.firstRecordPos - this.dirInfoHeader.length));
/* 323 */     this.raf.write(this.dirInfoHeader);
/*     */   }
/*     */   
/*     */   private void writeDirRecordHeader(Attributes rec) throws IOException {
/* 327 */     ByteUtils.intToBytesLE(rec.getInt(267264, 0), this.dirRecordHeader, 8);
/*     */ 
/*     */     
/* 330 */     ByteUtils.shortToBytesLE(rec.getInt(267280, 0), this.dirRecordHeader, 20);
/*     */ 
/*     */     
/* 333 */     ByteUtils.intToBytesLE(rec.getInt(267296, 0), this.dirRecordHeader, 30);
/*     */ 
/*     */     
/* 336 */     this.raf.seek(rec.getItemPosition() + 8L);
/* 337 */     this.raf.write(this.dirRecordHeader);
/*     */   }
/*     */   
/*     */   private void writeSequenceDelimitationItem() throws IOException {
/* 341 */     this.raf.seek(this.nextRecordPos);
/* 342 */     this.out.writeHeader(-73507, null, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private void addRecord(int tag, Attributes prevRec, Attributes rec) throws IOException {
/* 347 */     prevRec.setInt(tag, VR.UL, new int[] { this.nextRecordPos });
/* 348 */     markAsDirty(prevRec);
/* 349 */     writeRecord(this.nextRecordPos, rec);
/*     */   }
/*     */   
/*     */   private void writeRecord(int offset, Attributes rec) throws IOException {
///* 353 */     if ( true) {
/* 354 */        // LOG.info("M-UPDATE {}: add {} Record", this.file, rec.getString(267312, null));
///*     */     }
/* 356 */      // LOG.debug("Directory Record:\n{}", rec);
/* 357 */     rec.setItemPosition(offset);
/* 358 */     if (this.rollbackLen == -1) {
/* 359 */       this.rollbackLen = offset;
/* 360 */       writeFileSetConsistencyFlag(65535);
/*     */     } 
/* 362 */     this.raf.seek(offset);
/* 363 */     rec.setInt(267264, VR.UL, new int[] { 0 });
/* 364 */     rec.setInt(267280, VR.US, new int[] { 65535 });
/* 365 */     rec.setInt(267296, VR.UL, new int[] { 0 });
/* 366 */     rec.writeItemTo(this.out);
/* 367 */     this.nextRecordPos = (int)this.raf.getFilePointer();
/* 368 */     this.cache.put(offset, rec);
/*     */   }
/*     */   
/*     */   private void writeFileSetConsistencyFlag(int flag) throws IOException {
/* 372 */     this.raf.seek((this.firstRecordPos - 14));
/* 373 */     this.raf.writeShort(flag);
/* 374 */     setFileSetConsistencyFlag(flag);
/*     */   }
/*     */   
/* 377 */   private static final Comparator<Attributes> offsetComparator = new Comparator<Attributes>()
/*     */     {
/*     */       public int compare(Attributes item1, Attributes item2) {
/* 380 */         long d = item1.getItemPosition() - item2.getItemPosition();
/* 381 */         return (d < 0L) ? -1 : ((d > 0L) ? 1 : 0);
/*     */       }
/*     */     };
/*     */   
/*     */   private void markAsDirty(Attributes rec) {
/* 386 */     int index = Collections.binarySearch(this.dirtyRecords, rec, offsetComparator);
/* 387 */     if (index < 0)
/* 388 */       this.dirtyRecords.add(-(index + 1), rec); 
/*     */   }
/*     */   
/*     */   public synchronized int purge() throws IOException {
/* 392 */     int[] count = { 0 };
/* 393 */     purge(findFirstRootDirectoryRecordInUse(false), count);
/* 394 */     return count[0];
/*     */   }
/*     */   
/*     */   private boolean purge(Attributes rec, int[] count) throws IOException {
/* 398 */     boolean purge = true;
/* 399 */     while (rec != null) {
/* 400 */       if (purge(findLowerDirectoryRecordInUse(rec, false), count) && !rec.containsValue(267520)) {
/*     */         
/* 402 */         deleteRecord(rec);
/* 403 */         count[0] = count[0] + 1;
/*     */       } else {
/* 405 */         purge = false;
/* 406 */       }  rec = readNextDirectoryRecord(rec);
/*     */     } 
/* 408 */     return purge;
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/media/DicomDirWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */