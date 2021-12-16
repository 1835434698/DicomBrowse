/*    */ package org.dcm4che3.util;
/*    */ 
/*    */

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;

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
/*    */ 
/*    */ 
/*    */ public class SafeClose
/*    */ {
/*    */   public static void close(Closeable io) {
/* 52 */     if (io != null)
/* 53 */       try { io.close(); } catch (IOException ignore) {} 
/*    */   }
/*    */   
/*    */   public static void close(Socket sock) {
/* 57 */     if (sock != null)
/* 58 */       try { sock.close(); } catch (IOException ignore) {} 
/*    */   }
/*    */ }


/* Location:              /Users/allin1477/Documents/ws/AndroidStudio/mine/DicomBrowse/app/libs/org.dcm4che3.jar!/org/org.dcm4che3/util/SafeClose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */