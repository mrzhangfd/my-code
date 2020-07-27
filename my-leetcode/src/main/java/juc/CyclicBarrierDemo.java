package juc;

import java.util.PriorityQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierDemo
 *
 * @author icatzfd
 * Created on 2020/7/23 14:32.
 */
public class CyclicBarrierDemo {
    static class TaskThread extends Thread{
        CyclicBarrier barrier;
        public TaskThread(CyclicBarrier barrier){
            this.barrier=barrier;
        }

        @Override
        public void run(){
            try {
                Thread.sleep(1000);
                System.out.println(getName()+"到达栅栏A");
                barrier.await();
                System.out.println(getName()+"冲破栅栏A");
                Thread.sleep(2000);
                System.out.println(getName()+"到达栅栏B");
                barrier.await();
                System.out.println(getName()+"冲破栅栏B");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int threadNum=5;
        CyclicBarrier barrier=new CyclicBarrier(threadNum, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"完成最后任务");
            }
        });

        for(int i=0;i<threadNum;i++){
            new TaskThread(barrier).start();
        }
    }

}
