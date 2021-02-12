package com.jnf.file.File.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口 ---JDK 5.0 新增
 *
 */

class NumThread implements Callable{

    @Override
    public Object call() throws Exception {
        int  sum = 0;
        for (int i = 1; i <=100 ; i++) {
            if (i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class Thread2Test {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);
        new Thread(futureTask).start();
        try {
            //get()返回值即为FutureTask构造器参数Callable实现类重写call()的返回值
            Object o = futureTask.get();
            System.out.println("总和为："+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
