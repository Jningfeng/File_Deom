package com.jnf.file.File.stringtest;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;


/**
 * 涉及到String类与其他结构之间的转换
 */
public class StringTest1 {
    /*
    * String 与基本数据类型、包装类之间的转换
    *
    * String --> 基本数据类型、包装类：调用包装类的静态方法：parseXXX(str)
    * 基本数据类型、包装类 --> String:调用String重载的valueOf(xxx)
    * */
    @Test
    public void test1(){
        String s1 = "123";
        int i = Integer.parseInt(s1);

        String s2 = String.valueOf(i);//"123"
        String s3 = i + "";

        System.out.println(s1 == s3);
    }
    /**
     * String 与 char[]之间的转换
     * String --> char[]:调用String的toCharArray()
     * char[]  --> String:调用String的构造器
     */
    @Test
    public void test2(){
        String  s1 = "abc123";
        char[] chars = s1.toCharArray();
        for (char aChar : chars) {
            System.out.println(aChar);
        }

        char[] arr = new char[]{'a','b','c','d'};
        String s2 = new String(arr);
        System.out.println(s2);
    }

    /**
     * String 与 byte[] 之间的转换
     * 编码：String --> byte[]:调用String的getBytes()
     * 解码：byte[]  -->  String：调用String的构造器
     *
     * 编码：字符串 -->字节（看的懂 --> 看不懂的二进制数据）
     * 解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 --->看的懂 ）
     *
     * 说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1 = "abc123中国";
        byte[] bytes = s1.getBytes(); //使用默认的字符集,进行编码
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = s1.getBytes("gbk");//使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));

        System.out.println("****************");
        String s = new String(bytes);//使用默认的字符集，进行解码
        System.out.println(s);

        String s2 = new String(gbks);
        System.out.println(s2);  //出现乱码。原有：编码集和解码集不一致

        String gbk = new String(gbks, "gbk");
        System.out.println(gbk);  //没有出现乱码。原有：编码集和解码集一致


    }
}
