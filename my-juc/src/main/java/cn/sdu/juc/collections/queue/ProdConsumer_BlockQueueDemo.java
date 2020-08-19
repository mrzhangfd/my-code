package cn.sdu.juc.collections.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者 阻塞队列模式
 *
 * @author icatzfd
 * Created on 2020/8/18 9:56.
 */

class MyResource {
    private volatile boolean flag = true; //默认开启
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void myProd() throws Exception {
        String data = null;
        boolean retValue;
        System.out.println(Thread.currentThread().getName() + "\t 进入生产线程");
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 1, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() +"\t "+ data + "\t 插入队列成功");
            } else {
                System.out.println(Thread.currentThread().getName() + data + "\t 插入队列失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("======================停止生产");
    }

    public void myConsumer() throws Exception {
        String res = null;
        System.out.println(Thread.currentThread().getName() + "\t 进入消费线程");
        while (flag) {
            res = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (res == null) {
                flag=false;
                System.out.println(Thread.currentThread().getName()+"\t 超过两秒没有取到物品，消费退出");
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t"+res + "\t 取出队列成功");

        }
    }

    public void stop() {
        flag = false;
    }

}

public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);

        MyResource myResource=new MyResource(blockingQueue);
        new  Thread(()->{
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"myPrud").start();

        new Thread(()->{
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"myConsumer").start();

        TimeUnit.SECONDS.sleep(5);
        myResource.stop();
    }

}
