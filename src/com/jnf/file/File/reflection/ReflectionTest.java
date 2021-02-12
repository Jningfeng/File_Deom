package com.jnf.file.File.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 使用反射操作Persom类
 */
public class ReflectionTest {

    @Test
    public void test1() throws Exception{

        Class  c = Person.class ;
        //1.通过反射，创建Person类的对象
        Constructor constructor = c.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());
        //2.通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = c.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());
        //调用方法
        Method show = c.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("**********************************");
        //通过反射，可以调用Person类的私有结构。比如构造器、方法、属性
        //调用私有的构造器
        Constructor constructor1 = c.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person p1 = (Person) constructor1.newInstance("Jerry");
        System.out.println(p1);
        //调用私有的属性
        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"jnf");
        System.out.println(p1);
        //调用私有的方法
        Method showNation = c.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"中国");
        System.out.println(nation);
    }

    /**
     * Class的实例就对应着一个运行时类
     *
     * 加载到内存中的运行时类，会缓存一定的时间，在此时间内，我们可以通过不同的方式来获取此运行时类
     *
     * 获取Class的实例的四种方式
     */
    @Test
    public void test2() throws ClassNotFoundException {
        //方式一 调用运行时类的属性：class
        Class<Person> c1 = Person.class;
        System.out.println(c1);
        //方式二 通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class c2 = p1.getClass();
        System.out.println(c2);
        //方式三 调用Class的静态方法：forName(String classPath)
        Class c3 = Class.forName("com.jnf.file.File.reflection.Person");
        System.out.println(c3);
        //方式四  使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class c4 = classLoader.loadClass("com.jnf.file.File.reflection.Person");
        System.out.println(c4);
    }



}
