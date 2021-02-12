package com.jnf.file.File.io;


import org.junit.Test;

import java.io.*;

/**
 *
 * 处理流之一：缓存流的使用
 *
 * 1.缓冲流
 *    字节流
 *      BufferedInputStream
 *      BufferedOutputStream
 *    字符流
 *      BufferedReader
 *      BufferedWriter
 *
 * 2.作用：提高流的读取，写入的速度
 *    提高独写速度的原因：内部提供了一个缓存区
 *
 * 3.处理流，就是套接在已有的流的基础上
 *
 */
public class BufferedTest {

    //非文本文件的复制
    @Test
    public void testBufferedStream(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //造文件
            File srcFile = new File("feiJi.png");
            File destFile = new File("feiJi3.png");

            //造流
            //造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //复制
            byte[] buffer = new byte[10];
            int len ;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);

               // bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            //要求：先关闭外层的流，再关闭内层的流
            //说明：关闭外层的流的同时，内层的流也会自动的进行关闭。关于内层的流，我们可以省略
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //文本文件的复制
    //BufferedReader
    //BufferedWriter
    @Test
    public void testBufferedReaderBufferWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hello1.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello3.txt")));

            //方式一：使用char[] 数组
           /* char[] cbuf = new char[10];
            int len ;
            while ((len = br.read(cbuf)) != -1){
                bw.write(cbuf,0,len);
            }*/
           //方式二：使用String
            String data ;
            while ((data = br.readLine()) != null){
                //方法一
                //bw.write(data+"\n");  //data中不包含换行符
                //方法二
                bw.write(data);
                bw.newLine();    //换行
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
