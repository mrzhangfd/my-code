package cn.sdu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程顺序访问
 *
 * @author icatzfd
 * Created on 2020/9/1 15:09.
 * <p>
 * 多线程之间按顺序调用，实现A-》B-》C
 * 三个线程启动，要求如下
 * AA打印5次，BB打印10次，CC打印15次
 * ..
 * AA打印5次，BB打印10次，CC打印15次
 * 来10轮
 * <p>
 * <p>
 * 1、高内聚 低耦合 ，线程操作资源类
 * 2、判断 干活 通知
 * 3、多线程交互中，必须防止多线程的虚假唤醒，
 * 4、注意标志位
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.print5();

            }

        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.print10();

            }

        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.print15();

            }

        }, "CC").start();

    }
}

class Resource {
    //用num控制A B C 谁来打印。 num=1 A打印。num=2 B打印。 num=3 C打印
    private  int num = 1;
    //标志位


    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            //判断
            while (num != 1) {
                condition1.await();
            }
            //干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }

            //通知
            num = 2;
            condition2.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            //判断
            while (num != 2) {
                condition2.await();
            }
            //干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }

            //通知
            num = 3;
            condition3.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //判断
            while (num != 3) {
                condition3.await();
            }
            //干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }

            //通知
            num = 1;
            condition1.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    //使用volatile 实现轮番打印
   /* private volatile int num = 1;
    public void p5() {
        while (num != 1) {

        }

        //干活
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "\t " + i);
        }

        //通知
        num = 2;

    }

    public void p10() {
        while (num != 2) {

        }

        //干活
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "\t " + i);
        }

        //通知
        num = 3;

    }

    public void p15() {
        while (num != 3) {

        }

        //干活
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "\t " + i);
        }

        //通知
        num = 1;

    }*/

}
