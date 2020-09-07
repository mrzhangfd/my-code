package cn.sdu.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author icatzfd
 * Created on 2020/9/7 14:50.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(10);
        for(int i=0;i<10;i++){
            final int num=i;
            new Thread(()->{
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+"\t准备就绪");
            },String.valueOf(num)).start();
        }
        countDownLatch.await();
        System.out.println("发射");

    }
}
