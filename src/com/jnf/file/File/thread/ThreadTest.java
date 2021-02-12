package com.jnf.file.File.thread;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()  --->将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 *
 * 例：变量100以内的偶数
 *
 */

//1.创建一个继承于Thread类的子类
class  MyThread extends Thread {

    //2.重写Thread类的run()  --->将此线程执行的操作声明在run()中
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
public class ThreadTest {

    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread myThread = new MyThread();

        //4.通过此对象调用start():1.启动当前线程 2.调用当前线程的run()
           myThread.start();

        //问题一：我们不能通过直接调用run()的方式启动线程
        //myThread.run();

        /*问题二：不能让已经start()的线程再去执行。会报IllegalThreadStateException
            myThread.start();
            我们需要重写创建一个线程的对象*/
            MyThread myThread1 = new MyThread();
            myThread1.start();

    }
}

/**
 * Thread中的常用方法：
 * 1.start():启动当前线程，调用当前线程的run()
 * 2.run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.ccurrentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前cpu的执行权
 * 7.join():在线程a中调用线程b的join()，此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态
 * 8.stop():已过时，当执行此方法时，强制结束当前线程
 * 9.sleep(long millitime):让当前线程“睡眠”指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态
 * 10.isAlive():判断当前线程是否存活
 *
 * 线程的优先级
 * 1.MAX_PRIORITY:10
 *   MIN_PRIORITY:1
 *   NORM_PRIORITY:5 -->默认优先级
 * 2.如何获取和设置当前线程的优先级
 *   getPriority():获取线程的优先级
 *   setPriority():设置线程的优先级
 *
 *  说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，高优先级的线程高概率的情况下
 *        被执行。并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行
 */
