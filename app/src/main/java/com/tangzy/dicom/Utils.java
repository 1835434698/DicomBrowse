package com.tangzy.dicom;

import android.graphics.Bitmap;

import com.imebra.ColorTransformsFactory;
import com.imebra.DataSet;
import com.imebra.DrawBitmap;
import com.imebra.Image;
import com.imebra.LUT;
import com.imebra.TagId;
import com.imebra.TransformsChain;
import com.imebra.VOILUT;
import com.imebra.VOIs;
import com.imebra.drawBitmapType_t;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Utils {


    public static Bitmap generateBitmap(TransformsChain chain, Image image){
        DrawBitmap draw = new DrawBitmap();
        long requestedBufferSize = draw.getBitmap(image, drawBitmapType_t.drawBitmapRGBA, 4, new byte[0]);

        byte[] buffer = new byte[(int) requestedBufferSize];

        ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
        draw.getBitmap(image, drawBitmapType_t.drawBitmapRGBA, 4, buffer);
        Bitmap renderBitmap = Bitmap.createBitmap((int) image.getWidth(), (int) image.getHeight(), Bitmap.Config.ARGB_8888);
        renderBitmap.copyPixelsFromBuffer(byteBuffer);
        return renderBitmap;
    }


    public static TransformsChain applyTransformation(
            DataSet
                                                      loadedDataSet,
            Image image,
            int wCenter,
            int width ){
        TransformsChain chain = new TransformsChain();

    if (ColorTransformsFactory.isMonochrome(image.getColorSpace())){
        VOILUT voilutTransform = new VOILUT();
        voilutTransform.setCenterWidth(wCenter, width);
        chain.addTransform(voilutTransform);
//
//        VOIs vois = loadedDataSet.getVOIs();
//
//        List<LUT> luts = new ArrayList<>();
//
//        Long scanLUTs = 0l;
//
//        while (true){
//            try {
//                luts.add(loadedDataSet.getLUT(new TagId(0x0028,
//                        0x3010), scanLUTs));
//            }catch (Exception e){
//                break;
//            }
//            scanLUTs++;
//        }
//        if (!vois.isEmpty()){
//            voilutTransform.setCenterWidth(vois.get(0).getCenter(), vois.get(0).getWidth());
//        }else if (!luts.isEmpty()){
//            voilutTransform.setLUT(luts.get(0));
//        }else {
//            voilutTransform.applyOptimalVOI(image, 0, 0, width, height);
//        }
//        chain.addTransform(voilutTransform);
    }
        return chain;
    }

}
