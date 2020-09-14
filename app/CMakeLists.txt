# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

add_definitions(-DANDROID_PLATFORM=android-18)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

include_directories(libs/include)
set(DIR ../../../../libs)

add_library( # Sets the name of the library.
             native-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/native-lib.cpp )

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

add_library(dcmdata
            SHARED
            IMPORTED)
set_target_properties(dcmdata
                      PROPERTIES IMPORTED_LOCATION
                      ${DIR}/armeabi-v7a/libdcmdata.so)

#add_library(oflog
#            SHARED
#            IMPORTED)
#set_target_properties(oflog
#                      PROPERTIES IMPORTED_LOCATION
#                      ${DIR}/armeabi-v7a/liboflog.so)

add_library(ofstd
            SHARED
            IMPORTED)
set_target_properties(ofstd
                      PROPERTIES IMPORTED_LOCATION
                      ${DIR}/armeabi-v7a/libofstd.so)

add_library(dcmimgle
            SHARED
            IMPORTED)
set_target_properties(dcmimgle
                      PROPERTIES IMPORTED_LOCATION
                      ${DIR}/armeabi-v7a/libdcmimgle.so)
#
#add_library(dcmjpeg
#            SHARED
#            IMPORTED)
#set_target_properties(dcmjpeg
#                      PROPERTIES IMPORTED_LOCATION
#                      ${DIR}/armeabi-v7a/libdcmjpeg.so)
add_library(dcmjpls
            SHARED
            IMPORTED)
set_target_properties(dcmjpls
                      PROPERTIES IMPORTED_LOCATION
                      ${DIR}/armeabi-v7a/libdcmjpls.so)

add_library(dcmimage
            SHARED
            IMPORTED)
set_target_properties(dcmimage
                      PROPERTIES IMPORTED_LOCATION
                      ${DIR}/armeabi-v7a/libdcmimage.so)
#add_library(ijg8
#            SHARED
#            IMPORTED)
#set_target_properties(ijg8
#                      PROPERTIES IMPORTED_LOCATION
#                      ${DIR}/armeabi-v7a/libijg8.so)
add_library(ijg12
            SHARED
            IMPORTED)
set_target_properties(ijg12
                      PROPERTIES IMPORTED_LOCATION
                      ${DIR}/armeabi-v7a/libijg12.so)

add_library(ijg16
            SHARED
            IMPORTED)
set_target_properties(ijg16
                      PROPERTIES IMPORTED_LOCATION
                      ${DIR}/armeabi-v7a/libijg16.so)

add_library(charls
            SHARED
            IMPORTED)
set_target_properties(charls
                      PROPERTIES IMPORTED_LOCATION
                      ${DIR}/armeabi-v7a/libcharls.so)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       native-lib
                       dcmdata
                       dcmimage
#                       ijg8
                       dcmimgle
#                       dcmjpeg
                       dcmjpls
#                       oflog
                       ofstd
                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )
