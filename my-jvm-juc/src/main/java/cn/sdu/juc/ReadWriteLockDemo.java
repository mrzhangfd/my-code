package cn.sdu.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 读读共存
 * 读写不能共存
 * 写写不能共存
 *
 * @author icatzfd
 * Created on 2020/9/8 10:33.
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            int finalI1 = i;
            new Thread(() -> {
                myCache.put(String.valueOf(finalI), finalI1);
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {

               myCache.get(String.valueOf(finalI));
            }, String.valueOf(i)).start();
        }
    }
}

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {

        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 开始写入");
            map.put(key, value);

            System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public Object get(String key) {
        readWriteLock.readLock().lock();
        Object res = null;
        try {
            System.out.println(Thread.currentThread().getName() + "\t 开始读");
            res = map.get(key);
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "\t 读结束");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
        return res;
    }
}
