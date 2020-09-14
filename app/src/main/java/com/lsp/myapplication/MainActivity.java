package com.lsp.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_PHONE_PERMISSIONS = 0;

    // Used to load the 'native-lib' library on application startup.
    public static final String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String SystemDownloadPath = rootPath+ File.separator+"Allinmd/linshi/";


    ImageView imageView;
    SeekBar bar;
    Bitmap img =null;
    List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        stringFromJNI();
        setPremission();
        startActivity(new Intent(this, MyActivity.class));
//        imageView=findViewById(R.id.sample_img);
//        bar=findViewById(R.id.sample_progress);
//        for (int i = 0; i < 20; i++) {
//            if (i<10){
//                list.add(SystemDownloadPath+"ImageFileName00"+i+".dcm");
//            }else if (i<100){
//                list.add(SystemDownloadPath+"ImageFileName0"+i+".dcm");
//            }else {
//                list.add(SystemDownloadPath+"ImageFileName"+i+".dcm");
//            }
//        }
//        bar.setMax(list.size()-1);
//        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                new MyAsyncTask().execute(list.get(i));
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
////        new MyAsyncTask().execute("/storage/emulated/0/dr1.dcm");
//        new MyAsyncTask().execute("/storage/emulated/0/Allinmd/linshi/100.dcm");
////        new MyAsyncTask().execute("/storage/emulated/0/Allinmd/linshi/0002.DCM");
////        new MyAsyncTask().execute("/storage/emulated/0/Allinmd/linshi/1.2.840.113619.2.369.4.2147483647.1550715294.792225.dcm");
////        new MyAsyncTask().execute("/storage/emulated/0/Allinmd/linshi/dicom.dic");
////        new MyAsyncTask().execute("/storage/emulated/0/Allinmd/linshi/ImageFileName009.DCM");
////        new MyAsyncTask().execute("/storage/emulated/0/ImageFileName009.dcm");
    }

//    private class MyAsyncTask extends AsyncTask<String,Integer,DcmBean>{
//
//        @Override
//        protected DcmBean doInBackground(String... strings) {
//            File file = new File(strings[0]);
//            boolean exists = file.exists();
//            DcmBean dcms= getIntFromDcm(strings[0]);
//            int count= getCountFromDcm(strings[0]);
//            Log.e("tag1", "count = "+count);
//            return dcms;
//        }
//
//        @Override
//        protected void onPostExecute(DcmBean dcms) {
//            if (null!=dcms){
//                if (null!=dcms.getDcm()){
//                    if (dcms.getDcm().length>0){
//                        img =Bitmap.createBitmap((int) dcms.getWidth(),(int) dcms.getHeight(),Bitmap.Config.ARGB_8888);
//                        img.copyPixelsFromBuffer(IntBuffer.wrap(dcms.getDcm()));
//                        imageView.setImageBitmap(img);
//                    }
//                }
//            }
//        }
//    }

    private void setPremission() {
        final List<String> permissionsList = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if ((checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED))
                permissionsList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ){
                permissionsList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
            if (permissionsList.size() == 0){
            }else{
                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        REQUEST_PHONE_PERMISSIONS);
            }
        }else{
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PHONE_PERMISSIONS:
                if (grantResults==null||grantResults.length==0||grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                }else {
                    Toast.makeText(MainActivity.this,"请赋予权限",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
//
//    public native DcmBean getIntFromDcm(String filePath);
//
//    public static native int getCountFromDcm(String filePath);
}
