package cn.sdu.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口 创建线程
 * 第三种（此法）和线程池用的越来越多
 *
 * @author icatzfd
 * Created on 2020/8/19 14:50.
 */

class MyThread1 implements Runnable{

    @Override
    public void run() {

    }
}

//有返回值
class MyThread2 implements Callable<Integer>{

    //抛出异常
    @Override
    public Integer call() throws Exception {
        System.out.println("come in Callable");
        return 100;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask=new FutureTask<>(new MyThread2());
        Thread thread=new Thread(futureTask,"AAA");
        thread.start();

        //获取返回值
        //将get（）一般放到最后,因为要求获得Callable线程的计算结果，如果没有计算完成就要去强求，会导致阻塞直到计算完成
        System.out.println(futureTask.get());
    }
}

/**
 * 对比Runnable ，Callable 有什么优势？
 *
 */
