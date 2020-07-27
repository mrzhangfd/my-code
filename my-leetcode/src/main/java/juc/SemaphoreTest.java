package juc;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * SemaphoreTest
 *
 * @author icatzfd
 * Created on 2020/7/23 14:41.
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        //线程池
        ExecutorService exec = Executors.newCachedThreadPool();

        //只允许5个线程同时访问
        final Semaphore semp = new Semaphore(5);

        //模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可
                        semp.acquire();
                        System.out.println("accessing:" + NO);
                        Thread.sleep((long) (Math.random() * 10000));

                        //访问结束后，释放。如果不释放，则在控制台只能打印5条记录，之后线程一直阻塞
                        semp.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }

        //退出线程池
        exec.shutdown();
    }
}
