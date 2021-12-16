package com.lsp.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;


import com.tangzy.dicomlib.DcmData;
import com.tangzy.dicomlib.FileLib;
import com.tangzy.dicom.Utils;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.imebra.CodecFactory;
import com.imebra.DataSet;
import com.imebra.Image;
import com.imebra.TransformsChain;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.data.VR;
import org.dcm4che3.io.DicomInputStream;

import java.io.*;
import java.util.ArrayList;

/**
 * 解析并显示dicom文件的示例
 */
public class MyActivity extends Activity {

    SubsamplingScaleImageView iv;
    TextView tv_picture;
    TextView tv_name;
    TextView tv_birthday;
    TextView tv_institution;
    TextView tv_station;
    TextView tv_StudyDescription;
    TextView tv_SeriesDescription;
    TextView tv_manufacturerModelName;
    TextView tv_manufacturer;
    TextView tv_StudyDate;
    int number = 0;
    SeekBar bar;
    ArrayList <String> names = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
        initEvent();
        names.add("100.dcm");
        names.add("101.dcm");
        names.add("102.dcm");
//        names.add("1.2.840.113619.2.369.4.2147483647.1550715294.792225.dcm");
//        names.add("1.2.840.113619.2.369.4.2147483647.1550715651.14475.dcm");
//        names.add("1.2.840.113619.2.369.4.2147483647.1550715652.251428.dcm");
//        names.add("1.2.840.113619.2.369.4.2147483647.1550715653.470926.dcm");
//        names.add("1.2.840.113619.2.369.4.2147483647.1550715654.674745.dcm");
//        names.add("1.2.840.113619.2.369.4.2147483647.1550715655.915230.dcm");
//        names.add("img01.dcm");
//        names.add("ImageFileName001.dcm");
//        names.add("0002.DCM");
//        names.add("dr1.dcm");
        btnLoadClicked(names.get(number));
    }

    private void initView() {
        iv = (SubsamplingScaleImageView) findViewById(R.id.iv);
        tv_picture = (TextView) findViewById(R.id.tv_picture);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_birthday = (TextView) findViewById(R.id.tv_birthday);
        tv_institution = (TextView) findViewById(R.id.tv_institution);
        tv_station = (TextView) findViewById(R.id.tv_station);
        tv_StudyDescription = (TextView) findViewById(R.id.tv_StudyDescription);
        tv_SeriesDescription = (TextView) findViewById(R.id.tv_SeriesDescription);
        tv_manufacturer = (TextView) findViewById(R.id.tv_manufacturer);
        tv_manufacturerModelName = (TextView) findViewById(R.id.tv_manufacturerModelName);
        tv_StudyDate = (TextView) findViewById(R.id.tv_StudyDate);
        bar= (SeekBar) findViewById(R.id.sample_progress);

    }


    private void initEvent() {


    }


    public void next(View view) {
        //清空数据
        tv_name.setText("");
        tv_birthday.setText("");
        tv_institution.setText("");
        tv_station.setText("");
        tv_StudyDescription.setText("");
        tv_manufacturer.setText("");
        tv_manufacturerModelName.setText("");
        tv_StudyDate.setText("");
        tv_SeriesDescription.setText("");

        tv_picture.setText(names.get(number));
//        String fileName = "test" + number + ".dcm";
//        tv_picture.setText(fileName);
        //加载图片
//        btnLoadClicked("img01.dcm");
//        btnLoadClicked("ImageFileName001.dcm");
//        btnLoadClicked("dr1.dcm");
//        btnLoadClicked("0002.DCM");
//        btnLoadClicked("test211.dcm");

//        btnLoadClicked("test111.dcm");

//        btnLoadClicked("MRBRAIN.DCM");

//        btnLoadClicked("100.dcm");


        btnLoadClicked(names.get(number));
        number++;
        if (number == names.size()-1)
            number = 0;

    }


    void btnLoadClicked(final String fileName) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String testFileName = "/storage/emulated/0/Dcm/"+fileName;
                readFile(testFileName); //读取本地路径中的dicom文件
            }
        }).start();
    }

    /**
     * 复制文件的代码
     */
    void copyFile(InputStream is, File dstFile) {
        try {

            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(dstFile), 1024);
            byte buf[] = new byte[1024];
            int c = 0;
            c = bis.read(buf);
            while (c > 0) {
                bos.write(buf, 0, c);
                c = bis.read(buf);
            }
            bis.close();
            bos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取文件数据
     */
    public void readFile(final String filePath) {
        final int frameIndex = 0;

//        final int count = MainActivity.getCountFromDcm(filePath);

//        final DicomImageReader dr = new DicomImageReader();
        try {
            File file = new File(filePath);
            //dcm文件输入流
            DicomInputStream dcmInputStream = new DicomInputStream(file);
            //属性对象
            final Attributes attrs = dcmInputStream.readDataset(-1, -1);
            //输出所有属性信息
            Log.e("TAG", "输出所有属性信息1:" + attrs);

            //获取行
            final int row = attrs.getInt(Tag.Rows, 1);
            //获取列
            final int columns = attrs.getInt(Tag.Columns, 1);
            //窗宽窗位
            final float win_center = attrs.getFloat(Tag.WindowCenter, 1);
            final float win_width = attrs.getFloat(Tag.WindowWidth, 1);
            Log.e("TAG", "" + "row=" + row + ",columns=" + row + "row*columns = " + row * columns);

            Log.e("TAG", "" + "win_center=" + win_center + ",win_width=" + win_width);
            //获取像素数据 ，这个像素数据不知道怎么用！！！，得到的是图片像素的两倍的长度
            //后面那个 raster.getByteData()是图片的像素数据
            byte[] b = attrs.getSafeBytes(Tag.PixelData);
            if (b != null) {
                Log.e("TAG", "" + "b.length=" + b.length);
            } else {
                Log.e("TAG", "" + "b==null");
            }

            //修改默认字符集为GB18030
            attrs.setString(Tag.SpecificCharacterSet, VR.CS, "GB18030");//解决中文乱码问题

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    setUi(attrs);
                }
            });

            try {
                showBitmap(filePath, frameIndex);
            } catch (Exception e) {
                e.printStackTrace();
            }

            bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    try {
                        showBitmap(filePath, i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            DcmData dataFromDcm = FileLib.getDataFromDcm(filePath);
        if (dataFromDcm != null){
            Log.e("TAG", "dataFromDcm = " + dataFromDcm.frameCount);

            setUi(dataFromDcm.frameCount);

        }

//            dr.open(file);
////            Attributes ds = dr.getAttributes();
////            String wc = ds.getString(Tag.WindowCenter);
////            String ww = ds.getString(Tag.WindowWidth);
////            Log.e("TAG", "" + "wc=" + wc + ",ww=" + ww);
//
//            int dataType = dr.getDataType();
//            Log.e("TAG", "" + "dataType = " + dataType);
//            int frameLength = dr.getNumImages();
//            Log.e("TAG", "" + "frameLength = " + frameLength);


        } catch (Exception e) {
            Log.e("TAG", "" + e);
        }

    }

    private void setUi(final int count) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bar.setMax(count-1);
            }
        });
    }


    private void setUi(Attributes attrs) {
        Log.e("TAG", "输出所有属性信息2:" + attrs);
        String patientName = attrs.getString(Tag.PatientName, "");
        tv_name.setText("姓名：" + patientName);

        //生日
        String patientBirthDate = attrs.getString(Tag.PatientBirthDate, "");
        tv_birthday.setText("生日：" + patientBirthDate);

        //机构
        String institution = attrs.getString(Tag.InstitutionName, "");
        tv_institution.setText("机构：" + institution);

        //站点
        String station = attrs.getString(Tag.StationName, "");
        tv_station.setText("站点：" + station);

        //制造商
        String Manufacturer = attrs.getString(Tag.Manufacturer, "");
        tv_manufacturer.setText("制造商：" + Manufacturer);

        //制造商模型
        String ManufacturerModelName = attrs.getString(Tag.ManufacturerModelName, "");
        tv_manufacturerModelName.setText("制造商模型：" + ManufacturerModelName);


        //描述--心房
        String description = attrs.getString(Tag.StudyDescription, "");
        tv_StudyDescription.setText("描述--心房：" + description);
        //描述--具体
        String SeriesDescription = attrs.getString(Tag.SeriesDescription, "");
        tv_SeriesDescription.setText("描述--具体：" + SeriesDescription);

        //描述时间
        String studyData = attrs.getString(Tag.StudyDate, "");
        tv_StudyDate.setText("描述时间：" + studyData);
    }

    private void showBitmap(String filePath, int frameIndex) throws Exception {

        DataSet loadedDataSet = CodecFactory.load(filePath, 8000);
        Image image = loadedDataSet.getImageApplyModalityTransform(frameIndex);
        String colorSpace = image.getColorSpace();
        long width = image.getWidth();
        long height = image.getHeight();
        TransformsChain chain = Utils.applyTransformation(colorSpace, loadedDataSet, image, width, height);


//        CodecFactory.setMaximumImageSize(8000, 8000);
//
//        // Get the selected URI, then open an input stream
////        Uri selectedfile = data.getData();
////        if(selectedfile == null) {
////            return;
////        }
////        InputStream stream = getContentResolver().openInputStream(selectedfile);
//        InputStream stream = new FileInputStream(filePath);
//
//        // The usage of the Pipe allows to use also files on Google Drive or other providers
//        PipeStream imebraPipe = new PipeStream(32000);
//
//        // Launch a separate thread that read from the InputStream and pushes the data
//        // to the Pipe.
//        Thread pushThread = new Thread(new PushToImebraPipe(imebraPipe, stream));
//        pushThread.start();
//
//        // The CodecFactory will read from the Pipe which is feed by the thread launched
//        // before. We could just pass a file name to it but this would limit what we
//        // can read to only local files
//        DataSet loadDataSet = CodecFactory.load(new StreamReader(imebraPipe.getStreamInput()));
//
//        // Get the first frame from the dataset (after the proper modality transforms
//        // have been applied).
////                Image dicomImage = loadDataSet.getImageApplyModalityTransform(0);
//        Image dicomImage = loadDataSet.getImage(frameIndex);
//
//        // Use a DrawBitmap to build a stream of bytes that can be handled by the
//        // Android Bitmap class.
//        TransformsChain chain = new TransformsChain();
//
//        if(ColorTransformsFactory.isMonochrome(dicomImage.getColorSpace()))
//        {
//            VOILUT voilut = new VOILUT(VOILUT.getOptimalVOI(dicomImage, 0, 0, dicomImage.getWidth(), dicomImage.getHeight()));
//            chain.addTransform(voilut);
//        }
//        DrawBitmap drawBitmap = new DrawBitmap(chain);
//        Memory memory = drawBitmap.getBitmap(dicomImage, drawBitmapType_t.drawBitmapRGBA, 4);
//
//        // Build the Android Bitmap from the raw bytes returned by DrawBitmap.
//        Bitmap renderBitmap = Bitmap.createBitmap((int)dicomImage.getWidth(), (int)dicomImage.getHeight(), Bitmap.Config.ARGB_8888);
//        byte[] memoryByte = new byte[(int)memory.size()];
//        memory.data(memoryByte);
//        ByteBuffer byteBuffer = ByteBuffer.wrap(memoryByte);
//        renderBitmap.copyPixelsFromBuffer(byteBuffer);

        iv.setPanLimit(SubsamplingScaleImageView.PAN_LIMIT_INSIDE);
        iv.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_INSIDE);
        iv.setMaxScale(8.0f);
        iv.setDoubleTapZoomScale(5.0f);
        iv.setDoubleTapZoomStyle(SubsamplingScaleImageView.ZOOM_FOCUS_CENTER);

        setBitmap(chain, image);
    }

    private void setBitmap(final TransformsChain chain, final Image image) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                iv.setDebug(false);
                iv.setImage(ImageSource.bitmap(Utils.generateBitmap(chain, image)));
            }
        });
    }


//    // Dicom

}