package cn.sdu.juc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 *
 *
 * @author icatzfd
 * Created on 2020/8/19 15:57.
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool= Executors.newFixedThreadPool(3);
        ExecutorService threadPool1=Executors.newSingleThreadExecutor();
        ExecutorService threadPool2=Executors.newCachedThreadPool();


    }
}
