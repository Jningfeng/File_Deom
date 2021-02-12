package com.jnf.file.File.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK 8 之前日期和时间的API测试
 */
public class DateTimeTest {
    //System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        System.out.println(time); //返回时间戳
    }

    /**
     * java.util.Date类
     *    Java.sql.Date类
     *
     *  1.两个构造器的使用
     *        //构造器一：Date() 创建一个对应当前时间的Date对象
     *        //构造器二：创建指定毫秒数的Date对象
     *
     *  2.两个方法的使用
     *      toString():显示当前的年、月、日、时、分、秒
     *      getTime():获取当前Date对象对应的毫秒数。（时间戳）
     *
     *  3.Java.sql.Date  对应着数据库中的日期类型的变量
     *    如何实例化
     *    如何将Java.util.Date对象转换为java.sql.Date对象
     *
     */

    @Test
    public void test2(){
        //构造器一：Date() 创建一个对应当前时间的Date对象
        Date date1 = new Date();

        System.out.println(date1.toString()); //Mon Jan 11 14:27:47 CST 2021

        System.out.println(date1.getTime());//1610346523304

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1610346523304L);
        System.out.println(date2.toString());


        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(48382737284L);
        System.out.println(date3); //1971-07-15

        //如何将Java.util.Date对象转换为java.sql.Date对象
        //情况一
       // Date date4 = new java.sql.Date(12313525313L);
       // java.sql.Date date5 = (java.sql.Date) date4;
        //情况二
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }

    /**
     *
     *  SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
     *
     *  两个操作
     *        1.格式化：日期 --> 字符串
     *          解析：格式化的逆过程，字符串 ---> 日期
     *
     *       2. SimpleDateFormatd的实例化
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {

        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 --> 字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串 ---> 日期
        String str = "21-3-11 下午9:47";
        Date parse = sdf.parse(str);
        System.out.println(parse);

        //调用带参的构造器
       // SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）否则，抛异常
        Date date1 = sdf1.parse("2021-01-11 09:58:46");
        System.out.println(date1);
    }
    /*
      练习一：字符串"2021-08-08"转换为java.sql.Date
     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2021-08-08";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birth);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    /*
     Calendar 日历类（抽象类）的使用
     */
    @Test
    public void testCalendar(){
        //实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        //System.out.println(instance.getClass());

        //常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH); //本月第几天
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR)); //今年第几天

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH); //修改本月的第几天
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        days = calendar.get(Calendar.DAY_OF_MONTH); //在本月第几天的基础上加上几天
        System.out.println(days);

        //getTime():日历类 --> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date --> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH); //本月第几天
        System.out.println(days);
    }
}
