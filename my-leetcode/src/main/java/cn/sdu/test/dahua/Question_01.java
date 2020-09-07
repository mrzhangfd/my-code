package cn.sdu.test.dahua;

/**
 * @author icatzfd
 * Created on 2020/9/7 21:28.
 */

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 有4个线程分别获取C、D、E、F盘的大小，第5个线程统计总大小
 */
public class Question_01 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        DiskMemory diskMemory = new DiskMemory();
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            executorService.execute(() -> {
                try {
                    int size = diskMemory.getSize();
                    diskMemory.setSize(size);
                    Thread.sleep(1000);
                    System.out.println("线程执行，磁盘大小:" + size);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("--------");
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("磁盘总大小：" + diskMemory.getTotalSize());
        //线程池使用完需要手动关闭
        executorService.shutdown();
    }
}








