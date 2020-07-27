package juc;

import cn.sdu.TreeNode;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者，使用Condition实现
 *
 * @author icatzfd
 * Created on 2020/7/23 15:34.
 */
public class ProducerConsumerPattern_2 {

    private PriorityQueue<Integer> queue = new PriorityQueue<>(10);
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    notFull.signal();
                }finally {
                    lock.unlock();
                }

            }
        }
    }

    class Producer extends Thread{
        @Override
        public void run(){
            while (true){
                lock.lock();
                try{
                    while (queue.size()==10){
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);
                    notEmpty.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

}
