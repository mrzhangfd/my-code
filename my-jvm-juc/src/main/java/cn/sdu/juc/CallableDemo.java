package cn.sdu.juc;

import java.sql.Time;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author icatzfd
 * Created on 2020/9/6 15:31.
 * <p>
 * 多线程中，第三种获得多想的方法 Callable
 * 1\   futuretast.get() 方法一般放到最后
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());

        //对于同一个futureTask ,多个线程都调用同一个实例，只会调用一次。
        Thread thread = new Thread(futureTask, "A");
        thread.start();

        new Thread(futureTask,"B").start();


        //放到此处，get会阻塞主线程，直到拿到返回值
        //System.out.println(futureTask.get());


        System.out.println(Thread.currentThread().getName() + "\t计算完成");


        System.out.println(futureTask.get());

    }
}

class MyThread implements Runnable {

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("come in");
        //暂停4秒线程
        //TimeUnit.SECONDS.sleep(4);
        return 123;
    }
}