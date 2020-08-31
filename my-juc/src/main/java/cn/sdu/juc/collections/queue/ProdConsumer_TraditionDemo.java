package cn.sdu.juc.collections.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者传统模式
 *题目：一个初始值为0的变量，两个线程对其交替操作，一个加一，一个减一
 *  步骤：
 *      1、线程  操作  资源类
 *      2、判断  干活  通知
 *      3、防止虚假唤醒机制  使用while 判断，不使用if
 * @author icatzfd
 * Created on 2020/8/18 9:56.
 */

class ShareData{
    private  int num=0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    public void increment() throws Exception{
        lock.lock();
        try{
            //1 判断
            while (num!=0){
                //等待
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"\t "+num);
            condition.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void decrement() throws Exception{
        lock.lock();
        try{
          while (num==0){
              //等待
              condition.await();
          }
          //干活
          num--;
          System.out.println(Thread.currentThread().getName()+"\t"+ num);

          //通知唤醒
            condition.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData=new ShareData();
        for(int i=0;i<5;i++){
            new Thread(()->{
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"AAA").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"BBB").start();
        }
    }
}
