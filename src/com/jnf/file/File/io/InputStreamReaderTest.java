package com.jnf.file.File.io;

import org.junit.Test;

import java.io.*;
import java.security.acl.Owner;

/**
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 *   InputStreamReader:将一个字节的输入流转换为字符的输入流
 *   OutputStreamWriter:将一个字符的输出流转换为字节的输出流
 *
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3.  解码   字节 字节数组   ---> 字符数组  字符串
 *     编码  字符数组，字符串 --->字节 字节数组
 *
 * 4.字符集
 *
 */
public class InputStreamReaderTest {

    /*
    * InputStreamReader:实现了字节的输入流到字符的输入流的转换
    * */

    @Test
    public void test1() {

        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("hello.txt");
            //InputStreamReader  isr = new InputStreamReader(fis);//使用系统默认的字符集
            //参数二指明了字符集，具体使用哪个字符集，取决于文件保存时使用的字符集
            isr = new InputStreamReader(fis, "UTF-8");

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        /*
        * InputStreamReader   OutputStreamWriter  综合使用
        * */
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            isr = new InputStreamReader(new FileInputStream(new File("hello.txt")),"utf-8");
            osw = new OutputStreamWriter(new FileOutputStream(new File("hello_gbk.txt")),"gbk");

            char[] cbuf = new char[20];
            int len ;
            while ((len = isr.read(cbuf)) != -1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
