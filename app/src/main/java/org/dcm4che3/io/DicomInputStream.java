package org.dcm4che3.io;

import android.util.Log;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.BulkData;
import org.dcm4che3.data.ElementDictionary;
import org.dcm4che3.data.Fragments;
import org.dcm4che3.data.ItemPointer;
import org.dcm4che3.data.Sequence;
import org.dcm4che3.data.Tag;
import org.dcm4che3.data.VR;
import org.dcm4che3.util.ByteUtils;
import org.dcm4che3.util.SafeClose;
import org.dcm4che3.util.StreamUtils;
import org.dcm4che3.util.TagUtils;
 // import org.slf4j.Logger;
 // import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;


public class DicomInputStream
        extends FilterInputStream
        implements DicomInputHandler {
    public enum IncludeBulkData {
        NO, YES, URI;
    }

     // private static final Logger LOG = LoggerFactory.getLogger(DicomInputStream.class);


    private static final String UNEXPECTED_NON_ZERO_ITEM_LENGTH = "Unexpected item value of {} #{} @ {}";

    private static final String UNEXPECTED_ATTRIBUTE = "Unexpected attribute {} #{} @ {}";

    private static final String MISSING_TRANSFER_SYNTAX = "Missing Transfer Syntax (0002,0010) - assume Explicit VR Little Endian";

    private static final String MISSING_FMI_LENGTH = "Missing or wrong File Meta Information Group Length (0002,0000)";

    private static final String NOT_A_DICOM_STREAM = "Not a DICOM Stream";

    private static final String IMPLICIT_VR_BIG_ENDIAN = "Implicit VR Big Endian encoded DICOM Stream";

    private static final String DEFLATED_WITH_ZLIB_HEADER = "Deflated DICOM Stream with ZLIB Header";

    private static final int ZLIB_HEADER = 30876;

    private static final int DEF_ALLOCATE_LIMIT = 67108864;

    /*  86 */   private int allocateLimit = 67108864;
    private String uri;
    private String tsuid;
    private byte[] preamble;
    private Attributes fileMetaInformation;
    private boolean hasfmi;
    private boolean bigEndian;
    private boolean explicitVR;
    /*  94 */   private IncludeBulkData includeBulkData = IncludeBulkData.YES;
    private long pos;
    /*  96 */   private long fmiEndPos = -1L;
    private long tagPos;
    private long markPos;
    private int tag;
    private VR vrTag;
    private int length;
    /* 102 */   private DicomInputHandler handler = this;
    /* 103 */   private BulkDataDescriptor bulkDataDescriptor = BulkDataDescriptor.DEFAULT;
    /* 104 */   private final byte[] buffer = new byte[12];
    /* 105 */   private ItemPointer[] itemPointers = new ItemPointer[0];

    private boolean decodeUNWithIVRLE = true;
    private boolean addBulkDataReferences;
    private boolean catBlkFiles;
    /* 110 */   private String blkFilePrefix = "blk";
    private String blkFileSuffix;
    private File blkDirectory;
    private ArrayList<File> blkFiles;
    private String blkURI;
    private FileOutputStream blkOut;
    private long blkOutPos;

    public DicomInputStream(InputStream in, String tsuid) throws IOException {
        /* 119 */
        super(in);
        /* 120 */
        switchTransferSyntax(tsuid);
    }

    public DicomInputStream(InputStream in) throws IOException {
        /* 124 */
        super(in.markSupported() ? in : new BufferedInputStream(in));
        /* 125 */
        guessTransferSyntax();
    }

    public DicomInputStream(File file) throws IOException {
        /* 129 */
        this(new FileInputStream(file));
        /* 130 */
        this.uri = file.toURI().toString();
    }

    public final String getTransferSyntax() {
        /* 134 */
        return this.tsuid;
    }


    public final int getAllocateLimit() {
        /* 146 */
        return this.allocateLimit;
    }


    public final void setAllocateLimit(int allocateLimit) {
        /* 168 */
        this.allocateLimit = allocateLimit;
    }

    public final String getURI() {
        /* 172 */
        return this.uri;
    }

    public final void setURI(String uri) {
        /* 176 */
        this.uri = uri;
    }

    public final IncludeBulkData getIncludeBulkData() {
        /* 180 */
        return this.includeBulkData;
    }

    public final void setIncludeBulkData(IncludeBulkData includeBulkData) {
        /* 184 */
        if (includeBulkData == null)
            /* 185 */ throw new NullPointerException();
        /* 186 */
        this.includeBulkData = includeBulkData;
    }

    public final BulkDataDescriptor getBulkDataDescriptor() {
        /* 190 */
        return this.bulkDataDescriptor;
    }

    public final void setBulkDataDescriptor(BulkDataDescriptor bulkDataDescriptor) {
        /* 194 */
        this.bulkDataDescriptor = bulkDataDescriptor;
    }

    public final String getBulkDataFilePrefix() {
        /* 198 */
        return this.blkFilePrefix;
    }

    public final void setBulkDataFilePrefix(String blkFilePrefix) {
        /* 202 */
        this.blkFilePrefix = blkFilePrefix;
    }

    public final String getBulkDataFileSuffix() {
        /* 206 */
        return this.blkFileSuffix;
    }

    public final void setBulkDataFileSuffix(String blkFileSuffix) {
        /* 210 */
        this.blkFileSuffix = blkFileSuffix;
    }

    public final File getBulkDataDirectory() {
        /* 214 */
        return this.blkDirectory;
    }

    public final void setBulkDataDirectory(File blkDirectory) {
        /* 218 */
        this.blkDirectory = blkDirectory;
    }

    public final boolean isConcatenateBulkDataFiles() {
        /* 222 */
        return this.catBlkFiles;
    }

    public final void setConcatenateBulkDataFiles(boolean catBlkFiles) {
        /* 226 */
        this.catBlkFiles = catBlkFiles;
    }

    public final List<File> getBulkDataFiles() {
        /* 230 */
        if (this.blkFiles != null) {
            /* 231 */
            return this.blkFiles;
        }
        /* 233 */
        return Collections.emptyList();
    }


    public final void setDicomInputHandler(DicomInputHandler handler) {
        /* 245 */
        if (handler == null)
            /* 246 */ throw new NullPointerException("handler");
        /* 247 */
        this.handler = handler;
    }

    public boolean isDecodeUNWithIVRLE() {
        /* 251 */
        return this.decodeUNWithIVRLE;
    }

    public void setDecodeUNWithIVRLE(boolean decodeUNWithIVRLE) {
        /* 255 */
        this.decodeUNWithIVRLE = decodeUNWithIVRLE;
    }

    public boolean isAddBulkDataReferences() {
        /* 259 */
        return this.addBulkDataReferences;
    }

    public void setAddBulkDataReferences(boolean addBulkDataReferences) {
        /* 263 */
        this.addBulkDataReferences = addBulkDataReferences;
    }

    public final void setFileMetaInformationGroupLength(byte[] val) {
        /* 267 */
        this.fmiEndPos = this.pos + ByteUtils.bytesToInt(val, 0, this.bigEndian);
    }

    public final byte[] getPreamble() {
        /* 271 */
        return this.preamble;
    }

    public Attributes getFileMetaInformation() throws IOException {
        /* 275 */
        readFileMetaInformation();
        /* 276 */
        return this.fileMetaInformation;
    }

    public final int level() {
        /* 280 */
        return this.itemPointers.length;
    }

    public final int tag() {
        /* 284 */
        return this.tag;
    }

    public final VR vr() {
        /* 288 */
        return this.vrTag;
    }

    public final int length() {
        /* 292 */
        return this.length;
    }

    public final long getPosition() {
        /* 296 */
        return this.pos;
    }

    public void setPosition(long pos) {
        /* 300 */
        this.pos = pos;
    }

    public long getTagPosition() {
        /* 304 */
        return this.tagPos;
    }

    public final boolean bigEndian() {
        /* 308 */
        return this.bigEndian;
    }

    public final boolean explicitVR() {
        /* 312 */
        return this.explicitVR;
    }


    public void close() throws IOException {
        /* 317 */
        SafeClose.close(this.blkOut);
        /* 318 */
        super.close();
    }


    public synchronized void mark(int readlimit) {
        /* 323 */
        super.mark(readlimit);
        /* 324 */
        this.markPos = this.pos;
    }


    public synchronized void reset() throws IOException {
        /* 329 */
        super.reset();
        /* 330 */
        this.pos = this.markPos;
    }


    public final int read() throws IOException {
        /* 335 */
        int read = super.read();
        /* 336 */
        if (read >= 0)
            /* 337 */ this.pos++;
        /* 338 */
        return read;
    }


    public final int read(byte[] b, int off, int len) throws IOException {
        /* 343 */
        int read = super.read(b, off, len);
        /* 344 */
        if (read > 0)
            /* 345 */ this.pos += read;
        /* 346 */
        return read;
    }


    public final int read(byte[] b) throws IOException {
        /* 351 */
        return read(b, 0, b.length);
    }


    public final long skip(long n) throws IOException {
        /* 356 */
        long skip = super.skip(n);
        /* 357 */
        this.pos += skip;
        /* 358 */
        return skip;
    }

    public void skipFully(long n) throws IOException {
        /* 362 */
        StreamUtils.skipFully(this, n);
    }

    public void readFully(byte[] b) throws IOException {
        /* 366 */
        readFully(b, 0, b.length);
    }
    private int lengthFile = 0;
    public int getLengthFile(){
        return lengthFile;
    }

    public void readFully(byte[] b, int off, int len) throws IOException {
        lengthFile = lengthFile+len;
        if (len == 8){
            byte[]b1 = new byte[b.length];
            System.arraycopy(b, 0, b1, 0, b.length);
            Log.d("tangzy", "111 readFully off = "+ off+", len = "+len+", tag = "+ByteUtils.bytesToTag(b, 0, this.bigEndian)+", byte = "+StreamUtils.bytesToHexString(b));
        }
        StreamUtils.readFully(this, b, off, len);
//        SpecificCharacterSet (0008,0005) GB18030
    }

    public int readHeader() throws IOException {
        byte[] buf = this.buffer;
        this.tagPos = this.pos;
        readFully(buf, 0, 8);
        switch (this.tag = ByteUtils.bytesToTag(buf, 0, this.bigEndian)) {
            case Tag.Item:
            case Tag.ItemDelimitationItem:
            case Tag.SequenceDelimitationItem:
                this.vrTag = null;
                this.length = ByteUtils.bytesToInt(buf, 4, this.bigEndian);
                return this.tag;
        }
        if (this.explicitVR) {
            this.vrTag = VR.valueOf(ByteUtils.bytesToVR(buf, 4));
            if (this.vrTag.headerLength() == 8) {
                this.length = ByteUtils.bytesToUShort(buf, 6, this.bigEndian);
                return this.tag;
            }
            readFully(buf, 4, 4);
        } else {
            this.vrTag = VR.UN;
        }
        this.length = ByteUtils.bytesToInt(buf, 4, this.bigEndian);
        return this.tag;
    }

    public Attributes readCommand() throws IOException {
        /* 400 */
        if (this.bigEndian || this.explicitVR) {
            /* 401 */
            throw new IllegalStateException("bigEndian=" + this.bigEndian + ", explicitVR=" + this.explicitVR);
        }
        /* 403 */
        Attributes attrs = new Attributes(9);
        /* 404 */
        readAttributes(attrs, -1, -1);
        /* 405 */
        return attrs;
    }
    /**
     * 复制单个文件
     * @param oldPath String 原文件路径 如：c:/fqf.txt
     * @param newPath String 复制后路径 如：f:/fqf.txt
     * @return boolean
     */
    public void copyFile(String oldPath, String newPath, int byteMax) {
        try {
            int bytesum = 0;
            int byteread = 0;
            int bufferLenth = 1144;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldPath); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[bufferLenth];
                int length;
                while ( (byteread = inStream.read(buffer)) != -1 && bytesum < byteMax) {
                    bytesum += byteread; //字节数 文件大小
//                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                    int i = byteMax - bytesum;
                    if (i < bufferLenth){
                        buffer = new byte[i];
                        Log.d("tangzy", "111 copyFile i = "+i);
                    }
                    Log.d("tangzy", "111 copyFile byteMax = "+ byteMax+", bytesum = "+bytesum);
                }
                inStream.close();
            }
        }
        catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }

    public Attributes readDataset(int len, int stopTag) throws IOException {
        lengthFile = 0;
        /* 409 */
        this.handler.startDataset(this);
        /* 410 */
        readFileMetaInformation();
        /* 411 */
        Attributes attrs = new Attributes(this.bigEndian, 64);
        /* 412 */
        readAttributes(attrs, len, stopTag);
        /* 413 */
        attrs.trimToSize();
        /* 414 */
        this.handler.endDataset(this);
        /* 415 */
        return attrs;
    }

    public Attributes readFileMetaInformation() throws IOException {
        /* 419 */
        if (!this.hasfmi)
            /* 420 */ return null;
        /* 421 */
        if (this.fileMetaInformation != null) {
            /* 422 */
            return this.fileMetaInformation;
        }
        /* 424 */
        Attributes attrs = new Attributes(this.bigEndian, 9);
        /* 425 */
        while (this.pos != this.fmiEndPos) {
            /* 426 */
            mark(12);
            /* tzy_001 */
            readHeader();
            /* 428 */
            if (TagUtils.groupNumber(this.tag) != 2) {
                /* 429 */
                 // LOG.warn("Missing or wrong File Meta Information Group Length (0002,0000)");
                /* 430 */
                reset();
                break;
            }
            /* 433 */
            if (this.vrTag != null) {
                /* 434 */
                if (this.vrTag == VR.UN) {
                    /* 435 */
                    this.vrTag = ElementDictionary.getStandardElementDictionary().vrOf(this.tag);
                }
                /* 437 */
                this.handler.readValue(this, attrs);
                continue;
            }
            /* 439 */
            skipAttribute("Unexpected attribute {} #{} @ {}");
        }
        /* 441 */
        this.fileMetaInformation = attrs;

        /* 443 */
        String tsuid = attrs.getString(131088, null);
        /* 444 */
        if (tsuid == null) {
            /* 445 */
             // LOG.warn("Missing Transfer Syntax (0002,0010) - assume Explicit VR Little Endian");
            /* 446 */
            tsuid = "1.2.840.10008.1.2.1";
        }
        /* 448 */
        switchTransferSyntax(tsuid);
        /* 449 */
        return attrs;
    }


    public void readAttributes(Attributes attrs, int len, int stopTag){
        ItemPointer[] prevItemPointers = this.itemPointers;
        this.itemPointers = attrs.itemPointers();
        boolean undeflen = (len == -1);
        boolean hasStopTag = (stopTag != -1);
        long endPos = this.pos + (len & 0xFFFFFFFFL);
        try {
            while (undeflen || this.pos < endPos) {
                try {
                    readHeader();
                } catch (Exception e) {
                    break;
//                if (undeflen && this.pos == this.tagPos)
//                    break;
//                throw e;
                }
                if (hasStopTag && this.tag == stopTag)
                    break;
                if (this.vrTag != null) {
                    boolean prevBigEndian = this.bigEndian;
                    boolean prevExplicitVR = this.explicitVR;
                    try {
                        if (this.vrTag == VR.UN) {
                            if (this.decodeUNWithIVRLE) {
                                this.bigEndian = false;
                                this.explicitVR = false;
                            }
                            this.vrTag = ElementDictionary.vrOf(this.tag, attrs.getPrivateCreator(this.tag));

                            if (this.vrTag == VR.UN && this.length == -1) {
                                this.vrTag = VR.SQ;
                            }
                        }
                        this.handler.readValue(this, attrs);
                    } finally {
                        this.bigEndian = prevBigEndian;
                        this.explicitVR = prevExplicitVR;
                    }

//                if (this.tag == 2145386512){
//
//                    break;
//                }
                    continue;
                }
                skipAttribute("Unexpected attribute {} #{} @ {}");
            }

        }catch (Exception e){

        }
        this.itemPointers = prevItemPointers;
    }


    public void readValue(DicomInputStream dis, Attributes attrs) throws IOException {
        /* 498 */
        checkIsThis(dis);
        /* 499 */
        if (this.includeBulkData == IncludeBulkData.NO && this.length != -1 && isBulkData(attrs)) {
            /* 500 */
            skipFully(this.length);
            /* 501 */
        } else if (this.length == 0) {
            /* 502 */
            attrs.setNull(this.tag, this.vrTag);
            /* 503 */
        } else if (this.vrTag == VR.SQ) {
            /* 504 */
            readSequence(this.length, attrs, this.tag);
            /* 505 */
        } else if (this.length == -1) {
            /* 506 */
            readFragments(attrs, this.tag, this.vrTag);
            /* 507 */
        } else if (this.length == 64507 && this.in instanceof ObjectInputStream) {

            /* 509 */
            attrs.setValue(this.tag, this.vrTag, BulkData.deserializeFrom((ObjectInputStream) this.in));
        }
        /* 511 */
        else if (this.includeBulkData == IncludeBulkData.URI && isBulkData(attrs)) {
            /* 512 */
            BulkData bulkData = createBulkData();
            /* 513 */
            attrs.setValue(this.tag, this.vrTag, bulkData);
            /* 514 */
            if (this.addBulkDataReferences) {
                /* 515 */
                attrs.getRoot().addBulkDataReference(attrs.privateCreatorOf(this.tag), this.tag & 0xFFFF00FF, this.vrTag, bulkData, attrs.itemPointers());

            }

        } else {


            /* 523 */
            byte[] b = readValue();
            /* 524 */
            if (!TagUtils.isGroupLength(this.tag)) {
                /* 525 */
                if (this.bigEndian != attrs.bigEndian())
                    /* 526 */ this.vrTag.toggleEndian(b, false);

                /* 527 */
                attrs.setBytes(this.tag, this.vrTag, b);
                /* 528 */
            } else if (this.tag == 131072) {
                /* 529 */
                setFileMetaInformationGroupLength(b);
            }
        }
    }

    public BulkData createBulkData() throws IOException {
        BulkData bulkData;
        /* 535 */
        if (this.uri != null && !(this.in instanceof InflaterInputStream)) {
            /* 536 */
            bulkData = new BulkData(this.uri, this.pos, this.length, this.bigEndian);
            /* 537 */
            skipFully(this.length);
        } else {
            /* 539 */
            if (this.blkOut == null) {
                /* 540 */
                File blkfile = File.createTempFile(this.blkFilePrefix, this.blkFileSuffix, this.blkDirectory);

                /* 542 */
                if (this.blkFiles == null)
                    /* 543 */ this.blkFiles = new ArrayList<File>();
                /* 544 */
                this.blkFiles.add(blkfile);
                /* 545 */
                this.blkURI = blkfile.toURI().toString();
                /* 546 */
                this.blkOut = new FileOutputStream(blkfile);
                /* 547 */
                this.blkOutPos = 0L;
            }
            try {
                /* 550 */
                StreamUtils.copy(this, this.blkOut, this.length);
            } finally {
                /* 552 */
                if (!this.catBlkFiles) {
                    /* 553 */
                    SafeClose.close(this.blkOut);
                    /* 554 */
                    this.blkOut = null;
                }
            }
            /* 557 */
            bulkData = new BulkData(this.blkURI, this.blkOutPos, this.length, this.bigEndian);
            /* 558 */
            this.blkOutPos += this.length;
        }
        /* 560 */
        return bulkData;
    }

    public boolean isBulkData(Attributes attrs) {
        /* 564 */
        return this.bulkDataDescriptor.isBulkData(attrs.getPrivateCreator(this.tag), this.tag, this.vrTag, this.length, this.itemPointers);
    }


    public boolean isBulkDataFragment(Fragments frags) {
        /* 569 */
        if (this.tag != -73728) {
            /* 570 */
            return false;
        }
        /* 572 */
        return this.bulkDataDescriptor.isBulkData(frags.privateCreator(), frags.tag(), frags.vr(), this.length, this.itemPointers);
    }


    public void readValue(DicomInputStream dis, Sequence seq) throws IOException {
        /* 579 */
        checkIsThis(dis);
        /* 580 */
        if (this.length == 0) {
            /* 581 */
            seq.add(new Attributes(seq.getParent().bigEndian(), 0));
            return;
        }
        /* 584 */
        Attributes attrs = new Attributes(seq.getParent().bigEndian());
        /* 585 */
        seq.add(attrs);
        /* 586 */
        readAttributes(attrs, this.length, -73715);
        /* 587 */
        attrs.trimToSize();
    }


    public void readValue(DicomInputStream dis, Fragments frags) throws IOException {
        /* 593 */
        checkIsThis(dis);
        /* 594 */
        if (this.includeBulkData == IncludeBulkData.NO && isBulkDataFragment(frags)) {
            /* 595 */
            skipFully(this.length);
            /* 596 */
        } else if (this.length == 0) {
            /* 597 */
            frags.add(ByteUtils.EMPTY_BYTES);
            /* 598 */
        } else if (this.length == 64507 && this.in instanceof ObjectInputStream) {

            /* 600 */
            frags.add(BulkData.deserializeFrom((ObjectInputStream) this.in));
            /* 601 */
        } else if (this.includeBulkData == IncludeBulkData.URI && isBulkDataFragment(frags)) {
            /* 602 */
            frags.add(createBulkData());
        } else {
            /* 604 */
            byte[] b = readValue();
            /* 605 */
            if (this.bigEndian != frags.bigEndian())
                /* 606 */ frags.vr().toggleEndian(b, false);
            /* 607 */
            frags.add(b);
        }
    }


    public void startDataset(DicomInputStream dis) {
    }


    public void endDataset(DicomInputStream dis) {
    }


    private void checkIsThis(DicomInputStream dis) {
        /* 620 */
        if (dis != this)
            /* 621 */ throw new IllegalArgumentException("dis != this");
    }

    private void skipAttribute(String message) throws IOException {
        /* 625 */
         // LOG.warn(message, new Object[]{TagUtils.toString(this.tag), Integer.valueOf(this.length), Long.valueOf(this.tagPos)});

        /* 627 */
        skip(this.length);
    }


    private void readSequence(int len, Attributes attrs, int sqtag) throws IOException {
        /* 632 */
        if (len == 0) {
            /* 633 */
            attrs.setNull(sqtag, VR.SQ);
            return;
        }
        /* 636 */
        Sequence seq = attrs.newSequence(sqtag, 10);
        /* 637 */
        String privateCreator = attrs.getPrivateCreator(sqtag);
        /* 638 */
        boolean undefLen = (len == -1);
        /* 639 */
        long endPos = this.pos + (len & 0xFFFFFFFFL);
        /* 640 */
        for (int i = 0; undefLen || this.pos < endPos; i++) {
            /* 641 */
            readHeader();
            /* 642 */
            if (this.tag == -73728)
                /* 643 */ {
                this.handler.readValue(this, seq);
            }
            /* 644 */
            else {
                if (this.tag == -73507) {
                    /* 645 */
                    if (this.length != 0)
                        /* 646 */ skipAttribute("Unexpected item value of {} #{} @ {}");
                    break;
                }
                /* 649 */
                skipAttribute("Unexpected attribute {} #{} @ {}");
            }

            /* 651 */
        }
        if (seq.isEmpty()) {
            /* 652 */
            attrs.setNull(sqtag, VR.SQ);
        } else {
            /* 654 */
            seq.trimToSize();
        }
    }

    public Attributes readItem() throws IOException {
        /* 658 */
        readHeader();
        /* 659 */
        if (this.tag != -73728) {
            /* 660 */
            throw new IOException("Unexpected attribute " + TagUtils.toString(this.tag) + " #" + this.length + " @ " + this.pos);
        }
        /* 662 */
        Attributes attrs = new Attributes(this.bigEndian);
        /* 663 */
        attrs.setItemPosition(this.tagPos);
        /* 664 */
        readAttributes(attrs, this.length, -73715);
        /* 665 */
        attrs.trimToSize();
        /* 666 */
        return attrs;
    }


    private void readFragments(Attributes attrs, int fragsTag, VR vrTag) throws IOException {
        /* 671 */
        String privateCreator = attrs.getPrivateCreator(fragsTag);
        /* 672 */
        Fragments frags = new Fragments(privateCreator, fragsTag, vrTag, attrs.bigEndian(), 10);
        /* 673 */
        for (int i = 0; ; i++) {
            /* 674 */
            readHeader();
            /* 675 */
            if (this.tag == -73728)
                /* 676 */ {
                this.handler.readValue(this, frags);
            }
            /* 677 */
            else {
                if (this.tag == -73507) {
                    /* 678 */
                    if (this.length != 0)
                        /* 679 */ skipAttribute("Unexpected item value of {} #{} @ {}");
                    break;
                }
                /* 682 */
                skipAttribute("Unexpected attribute {} #{} @ {}");
            }

            /* 684 */
        }
        if (frags.isEmpty()) {
            /* 685 */
            attrs.setNull(fragsTag, vrTag);
        } else {
            /* 687 */
            frags.trimToSize();
            /* 688 */
            attrs.setValue(fragsTag, vrTag, frags);
        }
    }

    public byte[] readValue() throws IOException {
        /* 693 */
        int valLen = this.length;
        try {
            /* 695 */
            if (valLen < 0)
                /* 696 */ throw new EOFException();
            /* 697 */
            int allocLen = (this.allocateLimit >= 0) ? Math.min(valLen, this.allocateLimit) : valLen;


            /* 700 */
            byte[] value = new byte[allocLen];
            /* 701 */
            readFully(value, 0, allocLen);
            /* 702 */
            while (allocLen < valLen) {
                /* 703 */
                int newLength = Math.min(valLen, allocLen << 1);
                /* 704 */
                value = Arrays.copyOf(value, newLength);
                /* 705 */
                readFully(value, allocLen, newLength - allocLen);
                /* 706 */
                allocLen = newLength;
            }
            /* 708 */
            return value;
            /* 709 */
        } catch (IOException e) {

            /* 711 */
             // LOG.warn(String.format("IOException during read of {} #{} @ {}", new Object[]{TagUtils.toString(this.tag), Integer.valueOf(this.length), Long.valueOf(this.tagPos)}), e);

            /* 713 */
            throw e;
        }
    }

    private void switchTransferSyntax(String tsuid) throws IOException {
        /* 718 */
        this.tsuid = tsuid;
        /* 719 */
        this.bigEndian = tsuid.equals("1.2.840.10008.1.2.2");
        /* 720 */
        this.explicitVR = !tsuid.equals("1.2.840.10008.1.2");
        /* 721 */
        if (tsuid.equals("1.2.840.10008.1.2.1.99") || tsuid.equals("1.2.840.10008.1.2.4.95")) {
            /* 723 */
            if (hasZLIBHeader()) {
                /* 724 */
                 // LOG.warn("Deflated DICOM Stream with ZLIB Header");
                /* 725 */
                this.in = new InflaterInputStream(this.in);
            } else {
                /* 727 */
                this.in = new InflaterInputStream(this.in, new Inflater(true));
            }
        }
    }

    private boolean hasZLIBHeader() throws IOException {
        /* 733 */
        if (!markSupported())
            /* 734 */ return false;
        /* 735 */
        byte[] buf = this.buffer;
        /* 736 */
        mark(2);
        /* 737 */
        read(buf, 0, 2);
        /* 738 */
        reset();
        /* 739 */
        return (ByteUtils.bytesToUShortBE(buf, 0) == 30876);
    }

    private void guessTransferSyntax() throws IOException {
        /* 743 */
        byte[] b128 = new byte[128];
        /* 744 */
        byte[] buf = this.buffer;
        /* 745 */
        mark(132);
        /* 746 */
        int rlen = read(b128);
        /* 747 */
        if (rlen == 128) {
            /* 748 */
            read(buf, 0, 4);
            /* 749 */
            if (buf[0] == 68 && buf[1] == 73 && buf[2] == 67 && buf[3] == 77) {

                /* 751 */
                this.preamble = (byte[]) b128.clone();
                /* 752 */
                if (!markSupported()) {
                    /* 753 */
                    this.hasfmi = true;
                    /* 754 */
                    this.tsuid = "1.2.840.10008.1.2.1";
                    /* 755 */
                    this.bigEndian = false;
                    /* 756 */
                    this.explicitVR = true;
                    return;
                }
                /* 759 */
                mark(128);
                /* 760 */
                read(b128);
            }
        }
        /* 763 */
        if (rlen < 8 || (!guessTransferSyntax(b128, rlen, false) && !guessTransferSyntax(b128, rlen, true))) {

            /* 766 */
            throw new DicomStreamException("Not a DICOM Stream");
        }
        /* 767 */
        reset();
        /* 768 */
        this.hasfmi = TagUtils.isFileMetaInformation(ByteUtils.bytesToTag(b128, 0, this.bigEndian));
    }


    private boolean guessTransferSyntax(byte[] b128, int rlen, boolean bigEndian) throws DicomStreamException {
        /* 774 */
        int tag1 = ByteUtils.bytesToTag(b128, 0, bigEndian);
        /* 775 */
        VR vrTag = ElementDictionary.vrOf(tag1, null);
        /* 776 */
        if (vrTag == VR.UN)
            /* 777 */ return false;
        /* 778 */
        if (ByteUtils.bytesToVR(b128, 4) == vrTag.code()) {
            /* 779 */
            this.tsuid = bigEndian ? "1.2.840.10008.1.2.2" : "1.2.840.10008.1.2.1";

            /* 781 */
            this.bigEndian = bigEndian;
            /* 782 */
            this.explicitVR = true;
            /* 783 */
            return true;
        }
        /* 785 */
        int len = ByteUtils.bytesToInt(b128, 4, bigEndian);
        /* 786 */
        if (len < 0 || 8 + len > rlen) {
            /* 787 */
            return false;
        }
        /* 789 */
        if (bigEndian) {
            /* 790 */
            throw new DicomStreamException("Implicit VR Big Endian encoded DICOM Stream");
        }
        /* 792 */
        this.tsuid = "1.2.840.10008.1.2";
        /* 793 */
        this.bigEndian = false;
        /* 794 */
        this.explicitVR = false;
        /* 795 */
        return true;
    }
}


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/io/DicomInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */