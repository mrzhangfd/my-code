package cn.sdu.juc;

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
    //充当缓冲区
    static PriorityQueue<Integer> queue=new PriorityQueue<>(10);


    static class Consumer extends Thread{
        @Override
        public void run(){
            while (true){
                synchronized(queue){
                    //判断
                    while (queue.size()==0){
                        try {
                            //阻塞
                            queue.wait();
                        } catch (InterruptedException e) {
                            queue.notify();
                            e.printStackTrace();
                        }
                    }
                   //干活
                    System.out.println(queue.poll());

                    //唤醒一个正在等待此对象（queque）的monitor线程。
                    queue.notify();
                }
            }
        }
    }

    static class Producer extends Thread{
        @Override
        public void run(){
            while (true){
                synchronized (queue){
                    //判断
                    while (queue.size()==10){
                        try {
                            //阻塞
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    //干活
                    System.out.println(queue.offer(1));
                    //唤醒
                    queue.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Consumer consumer=new Consumer();
        Producer producer=new Producer();
        consumer.start();
        producer.start();
    }
}


