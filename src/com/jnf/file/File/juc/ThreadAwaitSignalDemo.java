package com.jnf.file.File.juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource{
     private int number = 1 ;
     private Lock lock = new ReentrantLock() ;
     private Condition condition1 = lock.newCondition();
     private Condition condition2 = lock.newCondition();
     private Condition condition3 = lock.newCondition();

     public void print5(){
         lock.lock();
         try {
           //判断
             while (number != 1){
                 condition1.await();
             }
             //干活
             for (int i = 1; i <=5 ; i++) {
                 System.out.println(Thread.currentThread().getName()+"\t"+i);
             }
             //修改标志位
             number = 2;
             //通知
             condition2.signal();
         }catch (Exception e){
             e.printStackTrace();
         }finally {
              lock.unlock();
         }
     }
     public void print10(){
        lock.lock();
        try {
            //判断
            while (number != 2){
                condition2.await();
            }
            //干活
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //修改标志位
            number = 3;
            //通知
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
     public void print15(){
        lock.lock();
        try {
            //判断
            while (number != 3){
                condition3.await();
            }
            //干活
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //修改标志位
            number = 1;
            //通知
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * 多线程之间按顺序调用，实现A->B->C
 *   三个线程启动，要求如下：
 *
 *   AA打印5次，BB打印10次，CC打印15次
 *   接着
 *   AA打印5次，BB打印10次，CC打印15次
 *   ......来10轮
 */
public class ThreadAwaitSignalDemo {
    public static void main(String[] args) {
      ShareResource shareResource = new ShareResource();
      new Thread(() -> {
          for (int i = 1; i <10 ; i++) {
               shareResource.print5();
          }
      },"AA").start();
      new Thread(() -> {
            for (int i = 1; i <10 ; i++) {
                shareResource.print10();
            }
        },"BB").start();
      new Thread(() -> {
            for (int i = 1; i <10 ; i++) {
                shareResource.print15();
            }
        },"CC").start();

    }
}
