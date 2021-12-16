/*    */ package org.dcm4che3.data;
/*    */ 
/*    */

import org.dcm4che3.io.DicomEncodingOptions;
import org.dcm4che3.io.DicomOutputStream;
import org.dcm4che3.util.ByteUtils;

import java.io.IOException;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface Value
/*    */ {
/* 50 */   public static final Value NULL = new Value()
/*    */     {
/*    */       public boolean isEmpty()
/*    */       {
/* 54 */         return true;
/*    */       }
/*    */ 
/*    */       
/*    */       public int getEncodedLength(DicomEncodingOptions encOpts, boolean explicitVR, VR vrTag) {
/* 59 */         return (vrTag == VR.SQ && encOpts.undefEmptySequenceLength) ? -1 : 0;
/*    */       }
/*    */ 
/*    */ 
/*    */       
/*    */       public void writeTo(DicomOutputStream dos, VR vrTag) throws IOException {}
/*    */ 
/*    */       
/*    */       public int calcLength(DicomEncodingOptions encOpts, boolean explicitVR, VR vrTag) {
/* 68 */         return (vrTag == VR.SQ && encOpts.undefEmptySequenceLength) ? 8 : 0;
/*    */       }
/*    */ 
/*    */       
/*    */       public String toString() {
/* 73 */         return "";
/*    */       }
/*    */ 
/*    */       
/*    */       public byte[] toBytes(VR vrTag, boolean bigEndian) {
/* 78 */         return ByteUtils.EMPTY_BYTES;
/*    */       }
/*    */     };
/*    */   
/*    */   boolean isEmpty();
/*    */   
/*    */   byte[] toBytes(VR paramVRTag, boolean paramBoolean) throws IOException;
/*    */   
/*    */   void writeTo(DicomOutputStream paramDicomOutputStream, VR paramVRTag) throws IOException;
/*    */   
/*    */   int calcLength(DicomEncodingOptions paramDicomEncodingOptions, boolean paramBoolean, VR paramVRTag);
/*    */   
/*    */   int getEncodedLength(DicomEncodingOptions paramDicomEncodingOptions, boolean paramBoolean, VR paramVRTag);
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/data/Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */