package com.jnf.file.File.array;

/**
 * 二维数组的概述
 *    1.理解
 *      对于二维数组的理解，我们可以看成是一维数组array1又作为另一个一维数组array2的元素而存在
 *     其实，从数组底层的运行机制来看，其实没有多维数组
 *
 *
 *    2. 二维数组的使用
 *         二维数组的声明和初始化
 *         如何调用数组的指定位置的元素
 *         如何获取数组的长度
 *         如何遍历数组
 *         数组元素的默认初始化值
 *            规定：二维数组分为外层数组的元素，内层数组的元素
 *            int[][] arr  = new int[4][3];
 *            外层元素：arr[0],arr[1]等
 *            内层元素：arr[0][0],arr[1][2]等
 *
 *            初始化方式一：比如： int[][] arr  = new int[4][3];
 *                外层元素的初始化值为：地址值
 *                内层元素的初始化值为：与一维数组初始化情况相同
 *
 *            初始化方式二：比如： int[][] arr  = new int[4][];
 *                外层元素的初始化值为：null
 *                内层元素的初始化值为：不能调用，否则报错
 *
 *       数组的内存解析
 */
public class ArrayTest1 {
    public static void main(String[] args) {
      //1.二维数组的声明和初始化
        //静态初始化
        int[][] arr = new int[][]{{1,2,3},{23,4 ,8 ,5},{32,2}};
        //动态初始化1
        String[][] arr1 = new String[3][2];
        //动态初始2
        String[][] arr2 =new String[3][] ;

      //2. 如何调用数组的指定位置的元素
        System.out.println(arr[0][2]);  //3
        System.out.println(arr1[1][1]); //null

        //arr2[1] = new String[3] ;
        //System.out.println(arr2[1][0]); //java.lang.NullPointerException

      //3.如何获取数组的长度
        System.out.println(arr.length); //3
        System.out.println(arr[0].length);//3
        System.out.println(arr[1].length); //1

      //4.如何遍历数组
        for (int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j < arr[i].length ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
