/*     */ package org.dcm4che3.data;
/*     */ 
/*     */

import org.dcm4che3.io.DicomEncodingOptions;
import org.dcm4che3.io.DicomOutputStream;
import org.dcm4che3.util.ByteUtils;
import org.dcm4che3.util.StreamUtils;
import org.dcm4che3.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.MessageFormat;
import java.text.ParseException;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BulkData
/*     */   implements Value
/*     */ {
/*     */   public static final int MAGIC_LEN = 64507;
/*     */   public final String uri;
/*     */   public final String uuid;
/*     */   private final int uriPathEnd;
/*     */   public final boolean bigEndian;
/*     */   public final long offset;
/*     */   public final int length;
/*     */   
/*     */   public BulkData(String uuid, String uri, boolean bigEndian) {
/*  70 */     Object[] parsed = { uri, Integer.valueOf(0), Integer.valueOf(-1) };
/*  71 */     int uriPathEnd = 0;
/*  72 */     if (uri != null) {
/*  73 */       if (uuid != null)
/*  74 */         throw new IllegalArgumentException("uuid and uri are mutually exclusive"); 
/*     */       try {
/*  76 */         parsed = (new MessageFormat("{0}?offset={1,number}&length={2,number}")).parse(uri);
/*     */       
/*     */       }
/*  79 */       catch (ParseException e) {}
/*  80 */       uriPathEnd = ((String)parsed[0]).length();
/*  81 */     } else if (uuid == null) {
/*  82 */       throw new IllegalArgumentException("uuid or uri must be not null");
/*     */     } 
/*  84 */     this.uuid = uuid;
/*  85 */     this.uri = uri;
/*  86 */     this.uriPathEnd = uriPathEnd;
/*  87 */     this.offset = ((Number)parsed[1]).longValue();
/*  88 */     this.length = ((Number)parsed[2]).intValue();
/*  89 */     this.bigEndian = bigEndian;
/*     */   }
/*     */   
/*     */   public BulkData(String uri, long offset, int length, boolean bigEndian) {
/*  93 */     this.uuid = null;
/*  94 */     this.uriPathEnd = uri.length();
/*  95 */     this.uri = uri + "?offset=" + offset + "&length=" + length;
/*  96 */     this.offset = offset;
/*  97 */     this.length = length;
/*  98 */     this.bigEndian = bigEndian;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 103 */     return (this.length == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 108 */     return "BulkData[uuid=" + this.uuid + ", uri=" + this.uri + ", bigEndian=" + this.bigEndian + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getFile() {
/*     */     try {
/* 116 */       return new File(new URI(uriWithoutOffsetAndLength()));
/* 117 */     } catch (URISyntaxException e) {
/* 118 */       throw new IllegalStateException("uri: " + this.uri);
/* 119 */     } catch (IllegalArgumentException e) {
/* 120 */       throw new IllegalStateException("uri: " + this.uri);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String uriWithoutOffsetAndLength() {
/* 125 */     if (this.uri == null) {
/* 126 */       throw new IllegalStateException("uri: null");
/*     */     }
/* 128 */     return this.uri.substring(0, this.uriPathEnd);
/*     */   }
/*     */   
/*     */   public InputStream openStream() throws IOException {
/* 132 */     if (this.uri == null) {
/* 133 */       throw new IllegalStateException("uri: null");
/*     */     }
/* 135 */     if (!this.uri.startsWith("file:")) {
/* 136 */       return (new URL(this.uri)).openStream();
/*     */     }
/* 138 */     InputStream in = new FileInputStream(getFile());
/* 139 */     StreamUtils.skipFully(in, this.offset);
/* 140 */     return in;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int calcLength(DicomEncodingOptions encOpts, boolean explicitVR, VR vrTag) {
/* 146 */     if (this.length == -1) {
/* 147 */       throw new UnsupportedOperationException();
/*     */     }
/* 149 */     return this.length + 1 & 0xFFFFFFFE;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getEncodedLength(DicomEncodingOptions encOpts, boolean explicitVR, VR vrTag) {
/* 154 */     return (this.length == -1) ? -1 : (this.length + 1 & 0xFFFFFFFE);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] toBytes(VR vrTag, boolean bigEndian) throws IOException {
/* 159 */     if (this.length == -1) {
/* 160 */       throw new UnsupportedOperationException();
/*     */     }
/* 162 */     if (this.length == 0) {
/* 163 */       return ByteUtils.EMPTY_BYTES;
/*     */     }
/* 165 */     InputStream in = openStream();
/*     */     try {
/* 167 */       byte[] b = new byte[this.length];
/* 168 */       StreamUtils.readFully(in, b, 0, b.length);
/* 169 */       if (this.bigEndian != bigEndian) {
/* 170 */         vrTag.toggleEndian(b, false);
/*     */       }
/* 172 */       return b;
/*     */     } finally {
/* 174 */       in.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeTo(DicomOutputStream out, VR vrTag) throws IOException {
/* 181 */     InputStream in = openStream();
/*     */     try {
/* 183 */       if (this.bigEndian != out.isBigEndian()) {
/* 184 */         StreamUtils.copy(in, (OutputStream)out, this.length, vrTag.numEndianBytes());
/*     */       } else {
/* 186 */         StreamUtils.copy(in, (OutputStream)out, this.length);
/* 187 */       }  if ((this.length & 0x1) != 0)
/* 188 */         out.write(vrTag.paddingByte());
/*     */     } finally {
/* 190 */       in.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void serializeTo(ObjectOutputStream oos) throws IOException {
/* 195 */     oos.writeUTF((String)StringUtils.maskNull(this.uuid, ""));
/* 196 */     oos.writeUTF((String)StringUtils.maskNull(this.uri, ""));
/* 197 */     oos.writeBoolean(this.bigEndian);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Value deserializeFrom(ObjectInputStream ois) throws IOException {
/* 202 */     return new BulkData(StringUtils.maskEmpty(ois.readUTF(), null), StringUtils.maskEmpty(ois.readUTF(), null), ois.readBoolean());
/*     */   }
/*     */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/BulkData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */