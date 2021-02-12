package com.jnf.file.File.date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * JDK8   日期跟时间
 */
public class JDK8DateTimeTest {
    /**
     * LocalDate、LocalTime、LocalDateTime的使用
     * 说明：
     *   LocalDateTime使用的频率要高
     */

    @Test
    public void test1(){
        //now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年、月、日、时、分、秒。
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 6, 8, 14, 23, 34);
        System.out.println(localDateTime1);

        //getXXX()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //体现不可变性
        //withXXX():设置相关的属性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime2);

        //加
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime3);

        //减
        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime4);
    }

    /**
     * Instant的使用
     * 类似于 java.util.Date类
     */
    @Test
    public void test2(){
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant); //2021-01-11T15:43:22.064Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); //2021-01-11T23:46:58.600+08:00

        //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数 ---> Date类的getTime方法
        long l = instant.toEpochMilli();
        System.out.println(l);

        //ofEpochMilli()：通过给定的毫秒数，获取Instant实例 --> Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(124514151415L);
        System.out.println(instant1);
    }
    /*
    * DateTimeFormatter:格式化或解析日期、时间
    * 类似于 SimpleDateFormat
    * */
    @Test
    public void test3(){
        //方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME   ISO_LOCAL_DATE  ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期 --> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);  //2021-01-12T00:03:28.796
        //解析：字符串 --> 日期
        TemporalAccessor parse = formatter.parse("2021-01-12T00:03:28.796");
        System.out.println(parse);  //{},ISO resolved to 2021-01-12T00:03:28.796

        //方式二：本地化相关的格式。如：ofLocalizedDateTime()
               //FormatStyle.LONG  FormatStyle.MEDIUM   FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);  //21-1-12 上午12:09
         //本地化相关的格式。如: ofLocalizedDate()
               //FormatStyle.FULL  FormatStyle.LONG  FormatStyle.MEDIUM   FormatStyle.SHORT :适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);  //2021年1月12日 星期二

        // 重点：方式三：自定义格式。 如：ofPattern("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4); //2021-01-12 12:16:46
        //解析
        TemporalAccessor parse1 = formatter3.parse("2021-01-12 12:16:46");
        System.out.println(parse1);//{NanoOfSecond=0, MicroOfSecond=0, HourOfAmPm=0, MinuteOfHour=16, MilliOfSecond=0, SecondOfMinute=46},ISO resolved to 2021-01-12


    }
}
