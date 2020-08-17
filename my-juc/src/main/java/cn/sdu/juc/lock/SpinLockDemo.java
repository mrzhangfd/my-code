package cn.sdu.juc.lock;

/**
 * 自旋锁
 *指的是；尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，
 * 好处：不会阻塞，减少了线程上下文切换的消耗
 * 缺点：循环会消耗cpu，如果长时间不获得锁，就会消耗cpu
 * @author icatzfd
 * Created on 2020/8/16 17:00.
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 设计一个自旋锁
 * 通过cas完成自旋锁，a线程先进来调用mylock方法，自己持有锁5秒钟，b随后进来发现当前线程持有锁，不是null。
 * 所以只能通过自旋等待，知道a释放锁后b随后抢到
 * @author icatzfd
 */
public class SpinLockDemo {

    //原子引用线程
    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    public void  myLock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in myLock()");
        //注意此处的取反
        while (!atomicReference.compareAndSet(null,thread)){
            System.out.println(Thread.currentThread().getName()+" \t在等待");
        }
    }

    public void myUnlock(){
        Thread thread=Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t invoked myUnlock()");
    }
    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo=new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        },"A").start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        },"B").start();
    }
}
