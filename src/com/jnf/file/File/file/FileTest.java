package com.jnf.file.File.file;

import org.junit.Test;
import org.omg.CORBA.ARG_OUT;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的一个对象，代表一个文件或一个文件目录。俗称：文件夹
 * File类声明在java.io包下
 *
 * 相对路径：相较于某个路径下，指明的路径
 * 绝对路径：包含盘符在内的文件或文件目录的路径
 *
 * 路径分隔符：
 * windows:\\
 * unix,URL:/
 */


public class FileTest {

    /*
    * 如何创建File实例
    * File(String filePath)
    * File(String parentPath，String childPath)
    * File(File parentPath，String childPath)
    * */

    @Test
    public void test1(){
        //构造器1
        File file1 = new File("hello.txt");//相对路径
        File file2 = new File("C:\\ideaIuGongZuo\\File_Deom\\hello.txt");//绝对路径

        System.out.println(file1);
        System.out.println(file2);

        //构造器2
        File file3 = new File("C:\\ideaIuGongZuo","File_Deom");
        System.out.println(file3);

        //构造器3
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);
    }

    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("d:\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());  //获取绝对路径
        System.out.println(file1.getPath());      //获取路径
        System.out.println(file1.getName());      //获取名称
        System.out.println(file1.getParent());    //获取上层文件目录路径。若无，返回null
        System.out.println(file1.length());      //获取文件长度 即：字节数。不能获取目录的长度
        System.out.println(new Date(file1.lastModified())); //获取最后的一次修改时间 。 毫秒数

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());

    }

    @Test
    public void test3(){
        File file = new File("C:\\ideaIuGongZuo\\File_Deom");
        String[] list = file.list();     //获取指定目录下的所有文件或者文件目录的名称数组
        for (String s : list){
            System.out.println(s);
        }

        System.out.println();

        File[] files = file.listFiles();    //获取指定目录下的所有文件或者文件目录d的File数组
        for (File f : files){
            System.out.println(f);
        }
    }

    @Test
    public void test4(){
        /*
        * boolean  renameTo(File dest)   //把文件重命名为指定的文件路径
        * 比如：file1.renameTo(file2)为例：
        *         要想保证返回true 需要file1在硬盘中是存在的，且fiel2不能在硬盘中c存在
        * */
        File file1 = new File("hello.txt");
        File file2 = new File("d:\\io\\hi.txt");

        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }

    @Test
    public void test5(){
        File file1 = new File("hello.txt");   //文件
        System.out.println(file1.isDirectory());//判断是否是文件目录
        System.out.println(file1.isFile());//判断是否是文件
        System.out.println(file1.exists());//判断是否存在
        System.out.println(file1.canRead());//判断是否可读
        System.out.println(file1.canWrite());//判断是否可写
        System.out.println(file1.isHidden());//判断是否隐藏

        System.out.println();

        File file2 = new File("d:\\io");   //目录
        System.out.println(file2.isDirectory());//判断是否是文件目录
        System.out.println(file2.isFile());//判断是否是文件
        System.out.println(file2.exists());//判断是否存在
        System.out.println(file2.canRead());//判断是否可读
        System.out.println(file2.canWrite());//判断是否可写
        System.out.println(file2.isHidden());//判断是否隐藏
    }

    @Test
    public void test6() throws IOException {
        //文件的创建
        File file1 = new File("hi.txt");
        if(!file1.exists()){
            //文件的创建
                file1.createNewFile();    //创建文件，若文件存在，则不创建，返回false
                System.out.println("创建成功");
        }else { //文件存在
            file1.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test7(){
        //文件目录的创建
        File file1 = new File("d:\\io\\io1");
        boolean mkdir = file1.mkdir();//创建目录，如果此文件目录存在，就不创建了。如果文件目录的上层目录存在，也不创建
        if (mkdir){
            System.out.println("创建成功1");
        }

        File file2 = new File("d:\\io\\io2");
        boolean mkdirs = file2.mkdirs(); //创建文件目录，如果上层文件目录不存在，也一并创建
        if (mkdirs){
            System.out.println("创建成功2");
        }


    }

}
