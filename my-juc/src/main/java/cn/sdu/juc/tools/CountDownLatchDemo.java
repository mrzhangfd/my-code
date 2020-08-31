package cn.sdu.juc.tools;

import cn.sdu.juc.enums.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @author icatzfd
 * Created on 2020/8/17 22:57.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(4);
        for (int i = 1; i <=4; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 结束");
                //计数器减一 ，调用countDown方法的线程不会阻塞
                countDownLatch.countDown();
            }, CountryEnum.forEachCountryEnum(i).getRetMessage()).start();
        }

        //countDownLatch的计数器减为0后，被阻塞的主线程会被唤醒。
        //当一个或多个线程调用await时，调用线程会被阻塞
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+" 发射");
    }
}
