package cn.sdu.juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatchDemo
 *
 * @author icatzfd
 * Created on 2020/7/23 14:22.
 */
public class CountDownLatchDemo implements Runnable {
    static final CountDownLatch latch = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //计数减一
            //放在finally 避免人物执行过程中出现异常，导师countDown()不能被执行
            latch.countDown();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.submit(demo);
        }
        //等待检查
        latch.await();
        //
        System.out.println("fire");

        //关闭线程池
        exec.shutdown();
    }
}
