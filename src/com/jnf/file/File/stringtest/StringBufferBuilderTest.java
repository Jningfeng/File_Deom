package com.jnf.file.File.stringtest;

import org.junit.Test;

/**
 *
 * 关于StringBuffer和StringBuilder的使用
 */
public class StringBufferBuilderTest {
    /**
     * String、StringBuffer、StringBuilder三者的异同
     * String:不可变的字符序列，底层使用char[]存储
     * StringBuffer:可变的字符序列，线程安全的，效率低，底层使用char[]存储
     * StringBuilder:可变的字符序列，JDK5.0新增的，线程不安全的，效率高，底层使用char[]存储
     *
     * 源码分析：
     * String s1 = new String();//char[] value  = new char[0];
     * String s2 = new String("abc");//char[] value = new char[]{'a','b','c'};
     *
     * StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建了一个长度是16的数组
     * sb1.append('a');//value[0]='a';
     * sb2.append('b');//value[1]='b';
     * StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length()+16]
     *
     * 扩容问题：如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组
     *   默认情况下，扩容为原来容量的2倍+2，同时将原有数组中的元素复制到新的数组中。
     *   指导意义：开发中建议使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)
     *
     *    String、StringBuffer、StringBuilder三者效率：
     *     从高到低排列：StringBuilder > StringBuffer > String
     */

    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'e');
        System.out.println(sb1);
    }

    /**
     * StringBuffer的常用方法
     *
     * StringBuffer append(xxx):提供了很多的append()方法，用于字符串拼接
     * StringBuffer delete(int start, int end):删除指定位置的内容    //左闭右开
     * StringBuffer replace(int start, int end, String str):把[start,end]位置替换为str
     * StringBuffer insert(int offset, xxx):在指定位置插入xxx
     * StringBuffer reverse():把当前字符序列逆转
     *
     * public int indexOf(String str)
     * public String substring(int start, int end):返回一个从start开始到end索引结束的左闭右开区间的子字符串
     * public int length()
     * public char charAt(int n)
     * public void setCharAt(int n, char ch)
     *
     *
     */
    @Test
    public void test2(){
        StringBuffer sb1 = new StringBuffer("abc");
        //append
        sb1.append(1);
        sb1.append("d");
        System.out.println(sb1);

           //delete
          // sb1.delete(2,4);
         //  System.out.println(sb1);

        //replace
        //sb1.replace(2,4,"hello");
        System.out.println(sb1);

        //insert
       //  sb1.insert(2,false);
        System.out.println(sb1);
        System.out.println(sb1.length());

        //reverse
        sb1.reverse();
        System.out.println(sb1);

    }

}
