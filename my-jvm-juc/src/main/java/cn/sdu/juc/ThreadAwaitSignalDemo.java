package cn.sdu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者 消费者 lock方式
 * @link ThreadWaitNotifyDemo
 * @author icatzfd
 * Created on 2020/9/1 14:57.
 */
public class ThreadAwaitSignalDemo {
    public static void main(String[] args) {
        Resourcess resourcess=new Resourcess();

        new Thread(()->{
            for(int i=0;i<10;i++){
                resourcess.add();
            }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                resourcess.sub();
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                resourcess.add();
            }
        },"C").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                resourcess.sub();
            }
        },"D").start();

    }
}

//资源类
class Resourcess{
    private int num=0;
    private Lock lock=new ReentrantLock();

    private Condition condition=lock.newCondition();


    public void add(){
        lock.lock();
        try{
            //判断
            while (num!=0){
                condition.await();
            }

            //干活
            num++;
            System.out.println(Thread.currentThread().getName()+"\t "+num);

            //通知
            condition.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void sub(){
        lock.lock();
        try{
            //判断
            while (num==0){
                condition.await();
            }

            //干活
            num--;
            System.out.println(Thread.currentThread().getName()+"\t "+num);

            //通知
            condition.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}