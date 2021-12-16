 package org.dcm4che3.android.imageio.dicom;

 import org.dcm4che3.android.Raster;
 import org.dcm4che3.android.image.LookupTable;
 import org.dcm4che3.android.image.LookupTableFactory;
 import org.dcm4che3.android.image.Overlays;
 import org.dcm4che3.android.image.PhotometricInterpretation;
 import org.dcm4che3.android.image.StoredValue;
 import org.dcm4che3.android.imageio.stream.ImageInputStreamAdapter;
 import org.dcm4che3.android.stream.FileImageInputStream;
 import org.dcm4che3.android.stream.ImageInputStream;
 import org.dcm4che3.data.Attributes;
 import org.dcm4che3.data.BulkData;
 import org.dcm4che3.data.Sequence;
 import org.dcm4che3.data.VR;
 import org.dcm4che3.io.BulkDataDescriptor;
 import org.dcm4che3.io.DicomInputStream;

 import java.io.File;
 import java.io.IOException;
 import java.io.InputStream;
 import java.nio.ByteOrder;


 public class DicomImageReader
 {
   private ImageInputStream iis;
   private Attributes ds;
   private DicomMetaData metadata;
   private int frames;
   private int width;
   private String patientName;
   private String versionName;
   private String patientBirthDate;
   private String studyDateAndTime;
   private String stationName;
   private int height;
   private BulkData pixeldata;
/*  41 */   private final VR.Holder pixeldataVR = new VR.Holder();
   
   private int samples;
   
   private int bitsAllocated;
   
   private int bitsStored;
   
   private boolean banded;
   
   private int dataType;
   
   private int frameLength;
   
   private PhotometricInterpretation pmi;
   
   private String institutionName;
   private String studyDescription;
   private String studyData;
   private String specificCharacterSet;
   
   public int getBitsStored() {
/*  63 */     return this.bitsStored;
   }
   
   public boolean getBanded() {
/*  67 */     return this.banded;
   }
   
   public BulkData getPixeldata() {
/*  71 */     return this.pixeldata;
   }
   
   public int getSamples() {
/*  75 */     return this.samples;
   }
   
   public int getBitsAllocated() {
/*  79 */     return this.bitsAllocated;
   }
   
   public int getFrameLength() {
/*  83 */     return this.frameLength;
   }
   
   public PhotometricInterpretation getPmi() {
/*  87 */     return this.pmi;
   }
 
   
   public void open(File src) throws Exception {
/*  92 */     resetInternalState();
/*  93 */     this.iis = (ImageInputStream)new FileImageInputStream(src);
/*  94 */     readMetadata();
   }
   
   public int getNumImages() {
/*  98 */     return this.frames;
   }
 
 
   
   public int getWidth() {
/* 104 */     return this.width;
   }
 
   
   public int getHeight() {
/* 109 */     return this.height;
   }
 
   
   public int getDataType() {
/* 114 */     return this.dataType;
   }
 
 
   
   public Attributes getAttributes() {
/* 120 */     return this.ds;
   }
 
   
   public String getPatientName() {
/* 125 */     return this.patientName;
   }
 
   
   public DicomMetaData getMetadata() {
/* 130 */     return this.metadata;
   }
 
   
   public boolean canReadRaster() {
/* 135 */     return true;
   }
 
 
   
   public Raster readRaster(int frameIndex) throws Exception {
/* 141 */     readMetadata();
/* 142 */     checkIndex(frameIndex);
/* 143 */     this.iis.setByteOrder(this.ds.bigEndian() ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
 
     
/* 146 */     this.iis.seek(this.pixeldata.offset + (frameIndex * this.frameLength));
/* 147 */     Raster raster = new Raster(this.width, this.height, this.dataType);
/* 148 */     if (this.dataType == 0) {
/* 149 */       byte[] data = raster.getByteData();
/* 150 */       this.iis.readFully(data, 0, data.length);
     } else {
/* 152 */       short[] data = raster.getShortData();
/* 153 */       this.iis.readFully(data, 0, data.length);
     } 
     
/* 156 */     return raster;
   }
 
 
   
   public byte[] extractOverlay(int gg0000, Raster raster) {
/* 162 */     Attributes attrs = this.metadata.getAttributes();
     
/* 164 */     if (attrs.getInt(0x60000100 | gg0000, 1) == 1) {
/* 165 */       return null;
     }
/* 167 */     int ovlyRows = attrs.getInt(0x60000010 | gg0000, 0);
/* 168 */     int ovlyColumns = attrs.getInt(0x60000011 | gg0000, 0);
/* 169 */     int bitPosition = attrs.getInt(0x60000102 | gg0000, 0);
     
/* 171 */     int mask = 1 << bitPosition;
/* 172 */     int length = ovlyRows * ovlyColumns;
     
/* 174 */     byte[] ovlyData = new byte[(length + 7 >>> 3) + 1 & 0xFFFFFFFE];
/* 175 */     Overlays.extractFromPixeldata(raster, mask, ovlyData, 0, length);
/* 176 */     return ovlyData;
   }
 
 
   
   public void applyOverlay(int gg0000, Raster raster, int frameIndex, DicomImageReadParam param, int outBits, byte[] ovlyData) {
/* 182 */     Attributes ovlyAttrs = this.metadata.getAttributes();
/* 183 */     int grayscaleValue = 65535;
/* 184 */     if (param instanceof DicomImageReadParam) {
/* 185 */       DicomImageReadParam dParam = param;
/* 186 */       Attributes psAttrs = dParam.getPresentationState();
/* 187 */       if (psAttrs != null) {
/* 188 */         if (psAttrs.containsValue(0x60003000 | gg0000))
/* 189 */           ovlyAttrs = psAttrs; 
/* 190 */         grayscaleValue = Overlays.getRecommendedDisplayGrayscaleValue(psAttrs, gg0000);
       } else {
         
/* 193 */         grayscaleValue = dParam.getOverlayGrayscaleValue();
       } 
/* 195 */     }  Overlays.applyOverlay((ovlyData != null) ? 0 : frameIndex, raster, ovlyAttrs, gg0000, grayscaleValue >>> 16 - outBits, ovlyData);
   }
 
   
   public int[] getActiveOverlayGroupOffsets(DicomImageReadParam param) {
/* 200 */     if (param instanceof DicomImageReadParam) {
/* 201 */       DicomImageReadParam dParam = param;
/* 202 */       Attributes psAttrs = dParam.getPresentationState();
/* 203 */       if (psAttrs != null) {
/* 204 */         return Overlays.getActiveOverlayGroupOffsets(psAttrs);
       }
/* 206 */       return Overlays.getActiveOverlayGroupOffsets(this.metadata.getAttributes(), dParam.getOverlayActivationMask());
     } 
 
     
/* 210 */     return Overlays.getActiveOverlayGroupOffsets(this.metadata.getAttributes(), 65535);
   }
 
 
 
   
   public Raster applyLUTs(Raster raster, int frameIndex, DicomImageReadParam dParam, int outBits) {
/* 217 */     Attributes imgAttrs = this.metadata.getAttributes();
/* 218 */     StoredValue sv = StoredValue.valueOf(imgAttrs);
/* 219 */     LookupTableFactory lutParam = new LookupTableFactory(sv);
/* 220 */     if (dParam == null)
/* 221 */       dParam = new DicomImageReadParam(); 
/* 222 */     Attributes psAttrs = dParam.getPresentationState();
/* 223 */     if (psAttrs != null) {
/* 224 */       lutParam.setModalityLUT(psAttrs);
/* 225 */       lutParam.setVOI(selectVOILUT(psAttrs, imgAttrs.getString(524312), frameIndex + 1), 0, 0, false);
 
 
 
       
/* 230 */       lutParam.setPresentationLUT(psAttrs);
     } else {
/* 232 */       Attributes sharedFctGroups = imgAttrs.getNestedDataset(1375769129);
       
/* 234 */       Attributes frameFctGroups = imgAttrs.getNestedDataset(1375769136, frameIndex);
       
/* 236 */       lutParam.setModalityLUT(selectFctGroup(imgAttrs, sharedFctGroups, frameFctGroups, 2658629));
 
       
/* 239 */       if (dParam.getWindowWidth() != 0.0F) {
/* 240 */         lutParam.setWindowCenter(dParam.getWindowCenter());
/* 241 */         lutParam.setWindowWidth(dParam.getWindowWidth());
       } else {
/* 243 */         lutParam.setVOI(selectFctGroup(imgAttrs, sharedFctGroups, frameFctGroups, 2658610), dParam.getWindowIndex(), dParam.getVOILUTIndex(), dParam.isPreferWindow());
       } 
 
 
 
       
/* 249 */       if (dParam.isAutoWindowing())
/* 250 */         lutParam.autoWindowing(imgAttrs, raster); 
/* 251 */       lutParam.setPresentationLUT(imgAttrs);
     } 
/* 253 */     LookupTable lut = lutParam.createLUT(outBits);
/* 254 */     Raster destRaster = new Raster(this.width, this.height, 3);
/* 255 */     lut.lookup(raster, destRaster);
/* 256 */     return destRaster;
   }
 
 
 
 
 
 
 
 
 
   
   public Raster applyWindowCenter(int frameIndex, int ww, int wc) throws Exception {
/* 269 */     checkIndex(frameIndex);
/* 270 */     Raster raster = readRaster(frameIndex);
/* 271 */     Attributes imgAttrs = this.metadata.getAttributes();
/* 272 */     StoredValue sv = StoredValue.valueOf(imgAttrs);
/* 273 */     LookupTableFactory lutParam = new LookupTableFactory(sv);
/* 274 */     DicomImageReadParam dParam = new DicomImageReadParam();
/* 275 */     Attributes psAttrs = dParam.getPresentationState();
/* 276 */     dParam.setWindowCenter(wc);
/* 277 */     dParam.setWindowWidth(ww);
/* 278 */     if (psAttrs != null) {
/* 279 */       lutParam.setModalityLUT(psAttrs);
/* 280 */       lutParam.setVOI(selectVOILUT(psAttrs, imgAttrs.getString(524312), frameIndex + 1), 0, 0, false);
 
 
 
       
/* 285 */       lutParam.setPresentationLUT(psAttrs);
     } else {
/* 287 */       Attributes sharedFctGroups = imgAttrs.getNestedDataset(1375769129);
       
/* 289 */       Attributes frameFctGroups = imgAttrs.getNestedDataset(1375769136, frameIndex);
       
/* 291 */       lutParam.setModalityLUT(selectFctGroup(imgAttrs, sharedFctGroups, frameFctGroups, 2658629));
 
       
/* 294 */       if (dParam.getWindowWidth() != 0.0F) {
/* 295 */         lutParam.setWindowCenter(dParam.getWindowCenter());
/* 296 */         lutParam.setWindowWidth(dParam.getWindowWidth());
       } else {
/* 298 */         lutParam.setVOI(selectFctGroup(imgAttrs, sharedFctGroups, frameFctGroups, 2658610), dParam.getWindowIndex(), dParam.getVOILUTIndex(), dParam.isPreferWindow());
       } 
 
 
 
 
       
/* 305 */       lutParam.setPresentationLUT(imgAttrs);
     } 
/* 307 */     LookupTable lut = lutParam.createLUT(8);
/* 308 */     Raster destRaster = new Raster(this.width, this.height, 0);
/* 309 */     lut.lookup(raster, destRaster);
/* 310 */     return destRaster;
   }
 
 
 
   
   private Attributes selectFctGroup(Attributes imgAttrs, Attributes sharedFctGroups, Attributes frameFctGroups, int tag) {
/* 317 */     if (frameFctGroups == null) {
/* 318 */       return imgAttrs;
     }
/* 320 */     Attributes group = frameFctGroups.getNestedDataset(tag);
/* 321 */     if (group == null && sharedFctGroups != null) {
/* 322 */       group = sharedFctGroups.getNestedDataset(tag);
     }
/* 324 */     return (group != null) ? group : imgAttrs;
   }
   
   private Attributes selectVOILUT(Attributes psAttrs, String iuid, int frame) {
/* 328 */     Sequence voiLUTs = psAttrs.getSequence(2634000);
/* 329 */     if (voiLUTs != null)
/* 330 */       for (Attributes voiLUT : voiLUTs) {
/* 331 */         Sequence refImgs = voiLUT.getSequence(528704);
/* 332 */         if (refImgs == null || refImgs.isEmpty())
/* 333 */           return voiLUT; 
/* 334 */         for (Attributes refImg : refImgs) {
/* 335 */           if (iuid.equals(refImg.getString(528725))) {
/* 336 */             int[] refFrames = refImg.getInts(528736);
/* 337 */             if (refFrames == null) {
/* 338 */               return voiLUT;
             }
/* 340 */             for (int refFrame : refFrames) {
/* 341 */               if (refFrame == frame)
/* 342 */                 return voiLUT; 
             } 
           } 
         } 
/* 346 */       }   return null;
   }
   
   private void readMetadata() throws Exception {
/* 350 */     if (this.metadata != null) {
       return;
     }
/* 353 */     if (this.iis == null) {
/* 354 */       throw new IllegalStateException("Input not set");
     }
     
/* 357 */     DicomInputStream dis = new DicomInputStream((InputStream)new ImageInputStreamAdapter(this.iis));
/* 358 */     dis.setIncludeBulkData(DicomInputStream.IncludeBulkData.URI);
/* 359 */     dis.setBulkDataDescriptor(BulkDataDescriptor.PIXELDATA);
/* 360 */     dis.setURI("java:iis");
/* 361 */     Attributes fmi = dis.readFileMetaInformation();
/* 362 */     Attributes ds = dis.readDataset(-1, -1);
/* 363 */     setMetadata(new DicomMetaData(fmi, ds));
   }
   
   private void setMetadata(DicomMetaData metadata) throws Exception {
/* 367 */     this.metadata = metadata;
/* 368 */     this.ds = metadata.getAttributes();
/* 369 */     Object pixeldata = this.ds.getValue(2145386512, this.pixeldataVR);
/* 370 */     if (pixeldata != null) {
 
       
/* 373 */       this.frames = this.ds.getInt(2621448, 1);
/* 374 */       this.width = this.ds.getInt(2621457, 0);
/* 375 */       this.height = this.ds.getInt(2621456, 0);
/* 376 */       this.samples = this.ds.getInt(2621442, 1);
/* 377 */       this.patientName = this.ds.getString(1048592, "");
/* 378 */       this.versionName = this.ds.getString(131091, "");
/* 379 */       this.patientBirthDate = this.ds.getString(1048624, "");
/* 380 */       this.stationName = this.ds.getString(528400, "");
/* 381 */       this.institutionName = this.ds.getString(524416, "");
/* 382 */       this.studyDescription = this.ds.getString(528432, "");
/* 383 */       this.studyData = this.ds.getString(524320, "");
/* 384 */       this.specificCharacterSet = this.ds.getString(524293, "");
       
/* 386 */       this.banded = (this.samples > 1 && this.ds.getInt(2621446, 0) != 0);
/* 387 */       this.bitsAllocated = this.ds.getInt(2621696, 8);
       
/* 389 */       this.bitsStored = this.ds.getInt(2621697, this.bitsAllocated);
/* 390 */       this.dataType = (this.bitsAllocated <= 8) ? 0 : 1;
       
/* 392 */       this.pmi = PhotometricInterpretation.fromString(this.ds.getString(2621444, "MONOCHROME2"));
       
/* 394 */       if (pixeldata instanceof BulkData) {
/* 395 */         this.frameLength = this.pmi.frameLength(this.width, this.height, this.samples, this.bitsAllocated);
/* 396 */         this.pixeldata = (BulkData)pixeldata;
       } else {
/* 398 */         throw new Exception("不支持压缩等其它格式");
       } 
     } 
   }
 
 
 
   
   private void resetInternalState() {
/* 407 */     this.metadata = null;
/* 408 */     this.ds = null;
/* 409 */     this.frames = 0;
/* 410 */     this.width = 0;
/* 411 */     this.height = 0;
/* 412 */     this.pixeldata = null;
/* 413 */     this.pmi = null;
   }
   
   private void checkIndex(int frameIndex) {
/* 417 */     if (this.frames == 0) {
/* 418 */       throw new IllegalStateException("Missing Pixel Data");
     }
/* 420 */     if (frameIndex < 0 || frameIndex >= this.frames) {
/* 421 */       throw new IndexOutOfBoundsException("imageIndex: " + frameIndex);
     }
   }
   
   public void close() throws IOException {
/* 426 */     resetInternalState();
/* 427 */     if (this.iis != null)
/* 428 */       this.iis.close(); 
   }
   
   public String getVersionName() {
/* 432 */     return this.versionName;
   }
   
   public String getPatientBirthDate() {
/* 436 */     return this.patientBirthDate;
   }
 
   
   public String getStationName() {
/* 441 */     return this.stationName;
   }
   
   public String getInstitutionName() {
/* 445 */     return this.institutionName;
   }
   
   public String getStudyDescription() {
/* 449 */     return this.studyDescription;
   }
   
   public String getStudyDate() {
/* 453 */     return this.studyData;
   }
   
   public String getSpecificCharacterSet() {
/* 457 */     return this.specificCharacterSet;
   }
 }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/android/imageio/dicom/DicomImageReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */