package cn.sdu.juc.collections.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 阻塞队列
 *  ArrayBlockingQueue 基于数组结构的有界阻塞队列
 *  LinkedBlockingQueue 基于链表结构的阻塞队列(默认大小Integer.MAX_VALUE)，吞吐量高于ArrayBlockingQueue
 *  SynchronousQueue：一个不存储元素的阻塞队列，也就是单个元素的队列，
 *                     每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态
 * @author icatzfd
 * Created on 2020/8/18 9:09.
 * 1 、阻塞队列
 *  优点： 不需要关心什么时候需要阻塞线程，什么时候需要唤醒线程，
 *  不得不阻塞，如何管理：
 *  用在哪？  生产者消费者、 线程池  消息中间件
 */
public class BlockingQueueDemo {
    /*ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue();
    LinkedBlockingQueue linkedBlockingQueue=new LinkedBlockingQueue();
    SynchronousQueue synchronousQueue=new SynchronousQueue();
*/
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        // return the head of this queue
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue);


    }
}
