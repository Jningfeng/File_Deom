package com.jnf.file.File.fanxing;

import org.junit.Test;

import java.util.List;

//如何自定义泛型结构：泛型类，泛型接口，泛型方法

public class OrderTest {

    @Test
    public void test1(){

        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果定义了类是带泛型的，建议在实例化时要指明类的泛型
        Order<String>  order = new Order<String>("orderAA",1001,"orderAAAAA") ;
        order.setOrderT("AA:hello");

    }

    @Test
    public void test2(){
        //由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不再需要指明泛型
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(1111);
    }

    //测试泛型方法
    @Test
    public void test3(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> integers = order.copyFromArrayToList(arr);
        System.out.println(integers);
    }
}
