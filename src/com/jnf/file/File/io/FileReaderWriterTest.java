package com.jnf.file.File.io;

import org.junit.Test;

import java.io.*;

public class FileReaderWriterTest {


    //将hello.txt文件内容读入程序中，并输出到控制台
    @Test
    public void testFileReader() throws IOException {
        /*
        * read():返回读入的一个字符。如果达到文件末尾，返回-1
        * 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
        * 读入的文件一定要存在，否则就会报java.io.FileNotFoundException
        * */
        FileReader fileReader = null;
        try {
            //实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");
            //提供具体的流
            fileReader = new FileReader(file);
            //数据的读入
            //read():返回读入的一个字符。如果达到文件末尾，返回-1
            int read = fileReader.read();
            while (read != -1){
                System.out.print((char) read);
                read   =  fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if(fileReader != null){
                fileReader.close();
            }
        }
    }

    @Test
    public void testFileReader1() throws IOException {
        /*
        * read()升级
        *
        * */
        FileReader fileReader = null;
        try {
            //File类的实例化
            File file = new File("hello.txt");
            //FileReader流的实例化
            fileReader = new FileReader(file);
            //读入的操作
            char[] cbuf  = new char[5];
            int len ;
            while ((len = fileReader.read(cbuf)) != -1){
                //方式一 错误的写法
                /*for (int i = 0 ; i < cbuf.length ; i++){
                    System.out.print(cbuf[i]);
                }*/
                //正确的写法
                /*for(int i = 0 ; i < len ; i++){
                    System.out.print(cbuf[i]);
                }*/
                //方式二 错误的写法 对于着方式一的错误的写法
                /*String str = new String(cbuf);
                System.out.print(str);*/
                //正确的写法
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null){
                fileReader.close();
            }
        }
    }

    @Test
    public void testFileWriter() throws IOException {
        /*
        * 1.输出操作：对于的File可以不存在。。并不会报异常
        * 2.File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件
        *     如果存在：
        *       如果流使用的构造器是：FileWriter(file,falase) / FileWriter(file):对原有文件进行覆盖
        *       如果流使用的构造器是：FileWriter(file,true):不会覆盖，在原有文件上进行追加
        *
        * */
        FileWriter fileWriter = null;
        try {
            //提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");
            //提供FileWriter的对象，用于数据的写出
            fileWriter = new FileWriter(file);
            //写出的操作
            fileWriter.write("I hava a dream!\n");
            fileWriter.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null){
                //资源流的关闭
                 fileWriter.close();
            }
        }
    }

    @Test
    public void testFileReaderFileWriter(){
        /*
        * 字符流不能处理图片等字节数据
        * */
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //创建File类的对象，指明读入和写出的文件
            File srcFile  = new File("hello.txt");
            File destFile = new File("hello2.txt");
            //创建输入流和输出流的对象
            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(destFile);
            //数据的读入和写出操作
            char[] cbuf = new char[5];
            int len ;  //记录每次读入到cbuf数组中的个数
            while ((len = fileReader.read(cbuf)) != -1){
                    //每次写出len个字符
                fileWriter.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
