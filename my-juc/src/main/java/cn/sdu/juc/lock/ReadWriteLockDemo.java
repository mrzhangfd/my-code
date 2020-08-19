package cn.sdu.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 *独占锁：该锁一次只能被一个线程所持有，对ReentrantLock 和Synchronized而言，都是独占锁
 * 共享锁：该锁可以被多个线程所持有
 * 对于：ReentrantReadWriteLock 其读锁是共享锁，其写锁是独占锁
 *
 * 写操作：原子+独占
 * 读操作：
 *
 * @author icatzfd
 * Created on 2020/8/17 21:30.
 */

//资源类
class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();
    //只用普通的锁，并不能保证并发
    //private Lock lock=new ReentrantLock();

    //用读写锁可以实现写独占，读并发
    ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    public void put(String key,Object value) throws InterruptedException {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 写入"+key);
            //暂停一会线程
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写完"+key);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public void get(String key) throws InterruptedException {

        readWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 读取"+key);
            //暂停一会线程
            TimeUnit.MILLISECONDS.sleep(300);
            Object res=map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读完"+key);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            readWriteLock.readLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {

    public static void main(String[] args) {

        MyCache myCache=new MyCache();
        for (int i = 0; i <5 ; i++) {
            //lambda表达式中的值应为final类型
            final int tempInt=i;
            new Thread(()->{
                try {
                    myCache.put(tempInt+"",tempInt+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }


        for (int i = 0; i <5 ; i++) {
            //lambda表达式中的值应为final类型
            final int tempInt=i;
            new Thread(()->{
                try {
                    myCache.get(tempInt+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
