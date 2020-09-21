package cn.sdu.juc;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列
 * 几组api
 * add()/remove()  抛出异常
 * offer()/poll() 返回true/false
 * put()/take() 会阻塞
 * offer(Time ) /poll(Time) 有时间限制
 * @author icatzfd
 * Created on 2020/9/10 10:04.
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);
    }
}
