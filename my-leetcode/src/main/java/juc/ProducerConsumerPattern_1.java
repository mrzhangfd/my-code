package juc;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者问题，使用wait() 和notify()实现
 *
 * @author icatzfd
 * Created on 2020/7/23 15:21.
 */


public class ProducerConsumerPattern_1 {
    PriorityQueue<Integer> queue=new PriorityQueue<>(10);
    Lock lock=new ReentrantLock();

    class Consumer extends Thread{
        @Override
        public void run(){
            while (true){
                synchronized(queue){
                    while (queue.size()==0){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            queue.notify();
                            e.printStackTrace();
                        }
                    }
                    queue.poll();

                    //唤醒一个正在等待此对象（queque）的monitor线程。
                    queue.notify();
                }

            }
        }
    }

    class Producer extends Thread{
        @Override
        public void run(){
            while (true){
                synchronized (queue){
                    while (queue.size()==10){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1);
                    queue.notify();
                }
            }
        }
    }
}


