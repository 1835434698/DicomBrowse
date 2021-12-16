package com.tangzy.dicom;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.imebra.CodecFactory;
import com.imebra.DataSet;
import com.imebra.DrawBitmap;
import com.imebra.Image;
import com.imebra.TransformsChain;
import com.imebra.drawBitmapType_t;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import org.dcm4che3.android.Raster;
import org.dcm4che3.android.RasterUtil;
import org.dcm4che3.android.imageio.dicom.DicomImageReader;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.data.VR;
import org.dcm4che3.io.DicomInputStream;

public class MainActivity extends AppCompatActivity {


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
    ArrayList<String> names = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        names.add("100.dcm");
        names.add("101.dcm");
        names.add("102.dcm");
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
        try {
            File file = new File(filePath);
            file.exists();
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

                setUi(attrs.getInt(Tag.NumberOfFrames, 1));




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


    private int readType = 0;// 0是imebra， 1是dcm4che3
    private DataSet loadedDataSet;
    private Image image;

    int winCenter = -1;
    int winWidth = -1;
    private Bitmap mPreviewbitmap;
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

    private void showBitmap(String filePath, int frameIndex){
        try {
            readType = 0;
//            CodecFactory.setMaximumImageSize(20000, 20000);
//            loadedDataSet = CodecFactory.load(filePath);
            loadedDataSet = CodecFactory.load(filePath, 8000);
            image = loadedDataSet.getImageApplyModalityTransform(frameIndex);

            if (loadedDataSet.getVOIs() != null && loadedDataSet.getVOIs().size() > 0){
                winCenter = (int) loadedDataSet.getVOIs().get(0).getCenter();
                winWidth = (int) loadedDataSet.getVOIs().get(0).getWidth();
            }else {
                winCenter = 1;
                winWidth = 1;
            }


            iv.setPanLimit(SubsamplingScaleImageView.PAN_LIMIT_INSIDE);
            iv.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_INSIDE);
            iv.setMaxScale(8.0f);
            iv.setDoubleTapZoomScale(5.0f);
            iv.setDoubleTapZoomStyle(SubsamplingScaleImageView.ZOOM_FOCUS_CENTER);

            setBitmap();
        }catch (Exception e){
            readImageReader(filePath);
        }
    }

    private DicomImageReader dr;
    private Raster raster;
    private synchronized void readImageReader(String file ) {
        try {
            readType = 1;
            dr = new DicomImageReader();
            dr.open(new File(file));

            setBitmap();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void setBitmap() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (readType == 0) {
                    setBitmap(Utils.applyTransformation(loadedDataSet, image, winCenter, winWidth), image);
                }else {
                    try {
                        raster = dr.applyWindowCenter(0, winWidth, winCenter);
                        mPreviewbitmap = RasterUtil.rasterToBitmap(raster);

                        iv.setImage(ImageSource.bitmap(mPreviewbitmap));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }
    private void setBitmap(TransformsChain chain, Image image) {

        DrawBitmap draw = new DrawBitmap(chain);

        // Ask for the size of the buffer (in bytes)
        long requestedBufferSize = draw.getBitmap(image, drawBitmapType_t.drawBitmapRGBA, 4, new byte[0]);
        // Ideally you want to reuse this in subsequent calls to getBitmap()
        byte[] buffer = new byte[(int)requestedBufferSize];
        ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
        // Now fill the buffer with the image data and create a bitmap from it
        draw.getBitmap(image, drawBitmapType_t.drawBitmapRGBA, 4, buffer);

        mPreviewbitmap = Bitmap.createBitmap((int) image.getWidth(), (int) image.getHeight(), Bitmap.Config.ARGB_4444);
        mPreviewbitmap.copyPixelsFromBuffer(byteBuffer);
        iv.setImage(ImageSource.bitmap(mPreviewbitmap));
    }


//    // Dicom

}