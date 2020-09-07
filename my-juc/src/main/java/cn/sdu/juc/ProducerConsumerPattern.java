package cn.sdu.juc;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 生产者消费者问题
 * 使用阻塞队列实现
 *
 * @author icatzfd
 * Created on 2020/7/23 15:14.
 */

class Producer implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;

    Producer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("proced:" + i);
                sharedQueue.put(i);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;

    public Consumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int i = (Integer) sharedQueue.take();
                System.out.println("consumed:" + i);
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class ProducerConsumerPattern {
    public static void main(String[] args) {
        BlockingQueue sharedQueue = new LinkedBlockingQueue();
        Thread proThread = new Thread(new Producer(sharedQueue));
        Thread conThread = new Thread(new Consumer(sharedQueue));

        proThread.start();
        conThread.start();
    }
}

