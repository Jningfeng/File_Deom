package com.jnf.file.File.io;

import org.junit.Test;

import java.io.*;

/**
 * 对象流
 * ObjectOutputStream    ObjectInputStream
 *  序列化
 *  反序列化
 *
 *  想要一个Java对象是可序列化的，需要满足相应情况：
 *   1.需要实现接口：Serializable
 *  2. 当前类提供一个全局常量：serialVersionUID
 *
 *  处理Java类需要实现Serializable接口之外，还必须保证其内部所有属性也必须是可序列化的。(默认情况下，基本数据类型可序列化)
 *
 *  补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 */
public class ObjectInputOutputStreamTest {

    @Test
    public void testObjectOutputStream(){
        //序列化   将内存中的Java对象保存到磁盘中或通过网络传输出去
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("我爱北京"));
            oos.flush();  //刷新
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void testObjectInputStream(){
        //反序列化    将磁盘中的对象还原为内存中的一个Java对象
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object object = ois.readObject();
            String str = (String) object;
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
