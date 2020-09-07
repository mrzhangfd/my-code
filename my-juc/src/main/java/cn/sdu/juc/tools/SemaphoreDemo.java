package cn.sdu.juc.tools;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量主要用于：
 * 用于多个共享资源的互斥使用
 * 用于并发线程数的控制
 *
 * @author icatzfd
 * Created on 2020/8/17 23:38.
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//模拟三个停车位

        for (int i = 1; i <= 6; i++) {//模拟六辆汽车
            new Thread(() -> {
                try {
                    //获取一个
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "\t 停车三秒后 离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放
                    semaphore.release();
                }
            }, String.valueOf(i)).start();

        }
    }
}
