package cn.sdu.juc.thread;

import java.util.concurrent.locks.Lock;

/**
 * 死锁
 * 两个或两个以上的进程在执行过程中，因资源争夺 造成的一种互相等待的现象
 * 若无外力干涉，将无法推进下去
 *  jstack -l jvm-pid 查看死锁
 * @author icatzfd
 * Created on 2020/8/21 10:34.
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA="lockA";
        String lockB="lockB";
        new Thread(new HoldLockThread(lockA,lockB),"AAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"BBB").start();
    }
}

class HoldLockThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockA+"\t 尝试获得"+lockB);

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 已获得"+lockB);
            }
        }
    }
}
