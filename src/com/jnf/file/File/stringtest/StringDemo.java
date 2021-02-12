package com.jnf.file.File.stringtest;

import org.junit.Test;

public class StringDemo {
    /**
     * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转“abfedcg”
     *
     * 方式一：转换为char[]
     */
    public String reverse(String srt ,int startIndex,int endIndex){
        if (srt != null){
            char[] chars = srt.toCharArray();
            for (int x = startIndex , y = endIndex ; x < y ; x++,y--){
                char temp = chars[x];
                chars[x] = chars[y] ;
                chars[y]  = temp ;
            }
            return  new String(chars);
        }
        return null ;
    }

    //方式二
    public String reverse2(String srt ,int startIndex,int endIndex){
        if (srt != null){
            StringBuilder builder = new StringBuilder(srt.length());
            //第一部分
            builder.append(srt.substring(0,startIndex));
            //第二部分
            for (int i = endIndex; i >=startIndex ; i--) {
                builder.append(srt.charAt(i));
            }
            //第三部分
            builder.append(srt.substring(endIndex+1));
            return builder.toString();
        }
        return null ;
    }

    @Test
    public void testReverse(){
        String str = "abcdefg";
        String reverse = reverse2(str,2,5);
        System.out.println(reverse);
    }
}
