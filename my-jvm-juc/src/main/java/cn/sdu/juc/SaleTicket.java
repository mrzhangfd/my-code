package cn.sdu.juc;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 卖票
 * 多线程编程的企业级套路+模板
 * 1、 高内聚低耦合的前提下， 线程          操作(对外暴露的调用方法)           资源类
 *
 * @author icatzfd
 * Created on 2020/8/31 17:20.
 */
public class SaleTicket {
    public static void main(String[] args) throws Exception {
        Ticket ticket = new Ticket();

        //lambda表达式法
        new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                ticket.saleTicket();
            }
        }, "A").start();

        //sleep 不释放锁
        Thread.sleep(1000);

        //线程的状态:
        // 新建
        // 就绪（可运行）
        // 阻塞 wait()和sleep都会导致阻塞，区别是：wait() 释放锁，sleep不释放锁
        // 等待（或timed_waiting） 死等（过时不候）
        //获取线程状态
        System.out.println(Thread.currentThread().getState());


        //匿名内部类的写法
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        },"B").start();




       /* new Thread(()->{
            for(int i=0;i<50;i++){
                ticket.saleTicket();
            }

        },"A").start();
        new Thread(()->{
            for(int i=0;i<50;i++){
                ticket.saleTicket();
            }

        },"B").start();
        new Thread(()->{
            for(int i=0;i<50;i++){
                ticket.saleTicket();
            }

        },"C").start();*/

    }
}


/**
 * 资源类
 */
class Ticket {
    private int num = 30;
    private Lock lock = new ReentrantLock();

    public void saleTicket() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "\t 卖掉第" + num-- + "还剩下" + num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}