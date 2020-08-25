package cn.sdu.juc.thread;

import java.util.concurrent.*;

/**
 * 线程池
 *
 *
 * @author icatzfd
 * Created on 2020/8/19 15:57.
 */
class ThreadDemo implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"\t 办理业务");
    }
}
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        //手写线程池，七个参数。同时指定工作队列大小。
        //如果使用jdk创建线程池，工作队列默认最大值。容易造成oom
        ExecutorService threadPool=new ThreadPoolExecutor(
                2,
                5,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try{
            for(int i=1;i<=10;i++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }

    private static void autoCreateThreadPool() {
        //5个处理线程
        //执行长期的任务，性能好的多
        ExecutorService threadPool= Executors.newFixedThreadPool(5);//一池5线程

        //一个任务一个任务执行的场景
        ExecutorService threadPool1=Executors.newSingleThreadExecutor();//一池一线程

        //执行很多短期异步的小程序或者负载比较轻的服务
        ExecutorService threadPool2 =Executors.newCachedThreadPool();//一池N线程
        ThreadDemo demo=new ThreadDemo();
        try{
            for (int i = 1; i < 10; i++) {
                threadPool.execute(demo);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }
}
