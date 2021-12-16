package org.dcm4che3.io;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Fragments;
import org.dcm4che3.data.Sequence;

import java.io.IOException;

public interface DicomInputHandler {
  void readValue(DicomInputStream paramDicomInputStream, Attributes paramAttributes) throws IOException;
  
  void readValue(DicomInputStream paramDicomInputStream, Sequence paramSequence) throws IOException;
  
  void readValue(DicomInputStream paramDicomInputStream, Fragments paramFragments) throws IOException;
  
  void startDataset(DicomInputStream paramDicomInputStream) throws IOException;
  
  void endDataset(DicomInputStream paramDicomInputStream) throws IOException;
}


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/io/DicomInputHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */