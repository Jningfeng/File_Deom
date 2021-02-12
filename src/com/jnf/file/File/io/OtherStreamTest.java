package com.jnf.file.File.io;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 标准的输入，输出流
 * System.in:标准的输入流，默认从键盘输入
 * System.out:标准的输出流，默认从控制台输出
 *
 */

public class OtherStreamTest {

    /**
      练习： 从键盘上输入字符串，要求将读到的字符串整行转到成大写。
        然后继续进行输出操作，直到当输入“e”或“exit”时，程序退出
     *
     * 使用System.in实现。System.in --->转换成--->BufferedReader的readLine
     *
     */


    public static void main(String[] args) {
            BufferedReader br = null;
            try {
                InputStreamReader isr = new InputStreamReader(System.in);
                br = new BufferedReader(isr);

                while (true) {
                    System.out.println("请输入字符串：");
                    String s = br.readLine();
                    if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
                        System.out.println("程序退出");
                        break;
                    }
                    String s1 = s.toUpperCase();
                    System.out.println(s1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}
