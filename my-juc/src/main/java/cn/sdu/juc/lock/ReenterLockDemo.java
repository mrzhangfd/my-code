package cn.sdu.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *可重入锁（递归锁）：指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码。
            线程可以进入任何一个它已经拥有的锁所同步着的代码块
            ReentrantLock 和Synchronized 都是可重入锁
 最大好处：避免死锁；
 * @author icatzfd
 * Created on 2020/8/16 16:21.
 */
class Phone implements Runnable {
    //synchronized 是可重入锁的例子。
    public synchronized void sendSMS() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t invoked sendEmail()");
    }

    //========================================================
    //ReentrantLock 是可重入锁的例子
    //默认false 非公平锁
    Lock lock=new ReentrantLock();
    public void get(){
        //两次lock 两次unlock 成功运行,只要成功配对即可
        //lock.lock();
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t invoked get()");
            set();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t invoked set()");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        get();
    }
}
public class ReenterLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Phone phone=new Phone();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println();
        System.out.println();
        System.out.println();
        Thread t3=new Thread(phone,"t3");
        Thread t4=new Thread(phone,"t4");
        t3.start();
        t4.start();;

    }
}
