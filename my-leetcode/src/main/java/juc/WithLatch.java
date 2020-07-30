package juc;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 多线程
 *
 * @author icatzfd
 * Created on 2020/7/5 16:12.
 */
public class WithLatch {
    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(3);
        for(int i=0;i<3;i++){
            new ChildThead(i,latch).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main finished");
    }

    static class ChildThead extends Thread{
        private  int id=-2;
        HashMap<Integer,Integer> map=new HashMap<>();
        private CountDownLatch latch=null;
        public ChildThead(int id,CountDownLatch latch){
            this.id=id;
            this.latch=latch;
        }

        @Override
        public void run(){
            try {
                Thread.sleep(Math.abs(new Random().nextInt(5000)));
                System.out.println(String.format("child thead %d finished",id));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }
}
