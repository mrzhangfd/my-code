package cn.sdu.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * sync和lock区别
 *1、 关键字和 java 类
 * 2、使用方法：
 *      synchr 不需要手动释放锁，
 *      look 需要手动释放，如果不释放，可能导致死锁。
 * 3、等待是否可中断
 *       synchr 不可中断，除非抛出异常 或正常运行完成
 *       look 可中断  （1） 设置超时方法 trylock（long timeout,TimeUnit unit）
 *                    (2) lockInterruptibly() 放代码块中，调用interrupt（）方法可中断
 * 4、加锁是否公平
 *       synchr 非公平
 *       Reentrantlock 默认非公平
 *5、锁绑定多个条件Condition
 * synchronized 没有
 * Reentrantlocak 用来实现分组唤醒 需要唤醒的线程，可以精确唤醒，而不是像synchronized要么随机唤醒一个线程，要么唤醒全部线程
 * @author icatzfd
 * Created on 2020/8/18 10:52.
 *
 * 题目：多线程之间按顺序打印，实现A-B-C 三个线程启动。要求如下：
 * AA打印五次，BB打印10次，CC打印15次
 * AA打印五次，BB打印10次，CC打印15次
 * ....
 * 来十轮
 */
class ShareResource {
    private int num=1; // A:1  B:2  C:3
    private Lock lock=new ReentrantLock();
    private Condition conditionA=lock.newCondition();
    private Condition conditionB=lock.newCondition();
    private  Condition conditionC=lock.newCondition();
    public void print5(){
        lock.lock();
        try{
            //1 判断
            while (num!=1){
               conditionA.await();
            }
            //2、干活
            for (int i = 1; i<=5 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);

            }
            num=2;
            //3、 通知
            conditionB.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }

    public void print10(){
        lock.lock();
        try{
            //1 判断
            while (num!=2){
                conditionB.await();
            }
            //2、干活
            for (int i = 1; i<=10 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            num=3;
            //3、 通知
            conditionC.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try{
            //1 判断
            while (num!=3){
                conditionC.await();
            }
            //2、干活
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            num=1;
            //3、 通知
            conditionA.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource=new ShareResource();
        new Thread(()->{
            for (int i = 1; i <=5; i++) {
                shareResource.print5();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 1; i <=10; i++) {
                shareResource.print10();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 1; i <=15; i++) {
                shareResource.print15();
            }
        },"C").start();
    }
}
