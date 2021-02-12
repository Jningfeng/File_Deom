package com.jnf.file.File.stringtest;

/**
 * 枚举类的使用
 *  1.枚举类的理解：类的对象只有有限个，确定的，我们称此类为枚举类
 *  2.当需要定义一组常量时，强烈建议使用枚举类
 *  3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式
 *
 *  如何定义枚举类
 *   1.jdk5.0之前，自定义枚举类
 *   2.jdk5.0，可以使用enum关键字定义枚举类
 *        定义的枚举类默认继承于java.lang.Enum
 *
 *   Enum类中的常用方法
 *   values()：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值
 *   valueOf(String str):可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的”名字“。如不是，会有运行时异常：IllegalArgumentException
 *   toString():返回当前枚举类对象常量的名称
 *
 *   使用enum关键字定义的枚举类实现接口的情况
 *    情况一：实现接口，在enum类中实现抽象方法
 *    情况二：让枚举类的对象分别实现接口中的抽象方法
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        //toString
        System.out.println(spring.toString());
        //System.out.println(Season1.class.getSuperclass());  //class java.lang.Enum
        //values()
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            System.out.println(value);
        }
        //valueOf(String objName):返回枚举类中对象名是objName的对象
        //如果没有objName的枚举类对象，则抛异常：java.lang.IllegalArgumentException
        Season1 summer = Season1.valueOf("SUMMER");
       // Season1 summer = Season1.valueOf("SUMMER1");
        System.out.println(summer);
        summer.show();

    }
}

//自定义枚举类
class Season{
    //1.声明Season对象的属性：private final 修饰
     private final String seasonName ;
     private final String seasonDesc ;

     //私有化类的构造器，并给对象属性赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //提供当前枚举类的多个对象：public static final 的
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","一叶知秋");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    //获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }
    //提供toString()

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

interface  Info{
    void show() ;
}

//使用enum关键字
enum  Season1 implements Info{
    //提供当前枚举类的多个对象，多个对象用","隔开，末尾对象";"结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天");
        }
    },
    AUTUMN("秋天","一叶知秋"){
        @Override
        public void show() {
            System.out.println("秋天");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("冬天");
        }
    };

    //声明Season对象的属性：private final 修饰
    private final String seasonName ;
    private final String seasonDesc ;

    //私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }


}
