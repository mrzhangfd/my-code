package cn.sdu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程通信 生产者消费者
 * synchronized 方式
 *
 * @author icatzfd
 * Created on 2020/9/1 10:44.
 * <p>
 * 题目：两个线程，可以操作一个初始值为0的一个变量
 * 实现一个线程对变量加一，一个线程对变量减一
 * 实现交替，来10轮，变量初始值为0
 * <p>
 * 1 、  高内聚低耦合，线程操作资源类
 * 2、   判断/干活/通知
 * 3、   多线程交互中，防止多线程的虚假唤醒，用while，不能用if
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) throws Exception {

        Resources res = new Resources();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    res.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }, "A生产").start();

        new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                try {
                    res.sub();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "B消费").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    res.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }, "C生产").start();

        new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                try {
                    res.sub();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "D消费").start();
    }
}

class Resources {
    private int num = 0;
    private Lock lock = new ReentrantLock();

    /**
     * 调用wait()或者notify()之前，必须使用synchronized语义绑定住被wait/notify的对象。
     */
    public synchronized void add() throws InterruptedException {

        //notifyAll() 唤醒等待此对象监视器上的所有线程
        //notify() 唤醒等待此对象监视器上的某个线程。
       /* //1 用if虚假唤醒的判断
        if (num != 0) {
            //虚假唤醒：如果num=1,此时A堵塞在此，并释放了锁，当别的线程B调用sub()消费后，并notifyAll()时，A线程可能被唤醒
            //由于此时是if判断，则A继续往下走，num++,导致num=2；
            this.wait();
        }*/

        //1 防止虚假唤醒的判断
        while (num != 0) {
            //虚假唤醒：如果num=1,此时堵塞在此，当别的线程notifyAll()时，A线程可能被唤醒
            //由于此时是while循环，需要再次判断num的值，直到num==0，A才能往下走。

            this.wait();
        }

        //2 干活
        num++;
        System.out.println(Thread.currentThread().getName() + "\t " + num);

        //3 通知
        this.notifyAll();
    }

    public synchronized void sub() throws InterruptedException {

        //1 判断
        while (num == 0) {
            this.wait();
        }

        //2 干活
        num--;
        System.out.println(Thread.currentThread().getName() + "\t " + num);

        //3 通知
        this.notifyAll();

    }
}
