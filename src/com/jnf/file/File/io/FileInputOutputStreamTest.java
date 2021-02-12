package com.jnf.file.File.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论：
 *    对于文本文件（.txt,.java,.c,.cpp）使用字符流处理
 *    对于非文本文件（.jpg,.mp3,.mp4,.avi,.doc,.ppt...）使用字节流处理
 */
public class FileInputOutputStreamTest {

    @Test
    public void testFileInputOutputStream(){
      //实现对图片的复制操作
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File strFile = new File("feiJi.png");
            File destFile = new File("feiJi1.png");

            fileInputStream = new FileInputStream(strFile);
            fileOutputStream = new FileOutputStream(destFile);

            byte[] bytes = new byte[5];
            int len ;
            while ((len = fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(fileInputStream != null){
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }

    //指定路径下文件的复制 / 抽取
    public void copyFile(String srcPath,String destPath){

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File strFile = new File(srcPath);
            File destFile = new File(destPath);

            fileInputStream = new FileInputStream(strFile);
            fileOutputStream = new FileOutputStream(destFile);

            byte[] bytes = new byte[1024];
            int len ;
            while ((len = fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(fileInputStream != null){
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }

    @Test
    public void testCopyFile(){

        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\贾宁锋\\Desktop\\GitHub.png";
        String destPath="C:\\Users\\贾宁锋\\Desktop\\GitHub1.png";

        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间："+(end - start));
    }

}
