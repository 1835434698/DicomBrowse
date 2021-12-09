package com.tangzy.dicomlib;


public class FileLib {

    static {
        System.loadLibrary("native-lib");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    public native static DcmData getDataFromDcm(String filePath);

}
