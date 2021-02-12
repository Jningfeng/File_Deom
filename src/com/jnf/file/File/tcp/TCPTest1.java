package com.jnf.file.File.tcp;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 网络编程例题2
 */
public class TCPTest1 {

    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);

        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("feiJi.png"));
        byte[] buffer = new byte[1024];
        int len ;
        while ((len = fis.read(buffer)) != -1){
             os.write(buffer,0,len);
        }
        //关闭数据的输出
        socket.shutdownOutput();

        //接受服务端的数据
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bufferr = new byte[1024];
        int len1 ;
        while ((len1 = is.read(bufferr)) != -1){
            bos.write(bufferr,0,len1);
        }
        System.out.println(bos.toString());

        fis.close();
        os.close();
        socket.close();
        bos.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("feiJi2.png"));

        byte[] buffer = new byte[1024];
        int len ;
        while ((len = inputStream.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        System.out.println("图片传输完成");

        //服务端给客户端反馈
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("图片已接收".getBytes());

        outputStream.close();
        fos.close();
        inputStream.close();
        socket.close();
        ss.close();
    }

}
