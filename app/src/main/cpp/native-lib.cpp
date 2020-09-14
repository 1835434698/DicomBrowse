#include <jni.h>
#include <android/log.h>
#include <string>


#include "dcmtk/dcmdata/dctk.h"
#include "dcmtk/dcmjpls/djdecode.h"
#include "dcmtk/dcmjpls/djencode.h"
#include "dcmtk/dcmimgle/dcmimage.h"
#include "dcmtk/dcmjpeg/djencode.h"
#include "dcmtk/dcmjpeg/djdecode.h"
#include "dcmtk/ofstd/offile.h"
#include "dcmtk/ofstd/ofstring.h"

#include "dcmtk/dcmdata/dcfilefo.h"
#include "dcmtk/dcmdata/dcdeftag.h"
#include "dcmtk/dcmdata/dcrledrg.h"
#include "dcmtk/dcmimage/diregist.h"



// 可选。定义方便使用的宏
//#definde LOGE(...) __android_log_print(ANDROID_LOG_ERROR, "Tag", __VA_ARGS__)


extern "C" JNIEXPORT jobject
JNICALL Java_com_allin_dicomlib_FileLib_getDataFromDcm(JNIEnv *env,jobject , jstring inputPath_) {
                __android_log_print(ANDROID_LOG_ERROR, "tag1", "hhhhhh");
        const char *input_pa_name =  env->GetStringUTFChars(inputPath_, JNI_FALSE);
        //dcmtk解析图像用的字典，下载有dcmtk源码，可在dcmdata\data里找到，未下载源码编译则拷贝assets目录下的到手机文件Download/中
        DcmDataDictionary &dict = dcmDataDict.wrlock();
        dict.loadDictionary(input_pa_name);
        dcmDataDict.wrunlock();
        OFFilename *file=new OFFilename(input_pa_name,false);
        DcmFileFormat *dcmFileFormat = new DcmFileFormat();
        OFCondition status = dcmFileFormat->loadFile(*file);
        if (status.good()) {
            OFString patientName;
            DcmDataset *dcmDataset = dcmFileFormat->getDataset();

            Sint32 frameCount;
            OFCondition condition1 = dcmDataset->findAndGetSint32(DCM_NumberOfFrames, frameCount);
             __android_log_print(ANDROID_LOG_ERROR, "tag1", "frameCount = %d", frameCount);
             if(frameCount == 0){
             __android_log_print(ANDROID_LOG_ERROR, "tag1", "11111hhhh");
                frameCount = 1;
             }
           //return frameCount;
             jclass myClass = env->FindClass("com/allin/dicomlib/DcmData");
             // 获取类的构造函数，记住这里是调用无参的构造函数
             jmethodID id = env->GetMethodID(myClass, "<init>", "()V");
             // 创建一个新的对象
             jobject dcmData_ = env->NewObject(myClass, id);


             jfieldID frames = env->GetFieldID(myClass, "frameCount", "I");
             env->SetIntField(dcmData_, frames, frameCount);


           //  jfieldID w = env->GetFieldID(myClass, "width", "J");
            // jfieldID h = env->GetFieldID(myClass, "height", "J");
            // jfieldID dcm = env->GetFieldID(myClass, "dcm", "[I");
             // env->SetLongField(dcmData_, w, imageWidth);
             // env->SetLongField(dcmData_, h, imageHeight);
             // env->SetObjectField(dcmData_, dcm, jntarray);

           // free(pixelData);
            //delete dcmFileFormat;
            return dcmData_;
     }
    return NULL;
}

