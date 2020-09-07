package cn.sdu.jvm.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author icatzfd
 * Created on 2020/8/22 22:22.
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        //引用队列
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

        //弱引用
        WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);

        //gc之前
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        //gc之后,o1 会被放到引用队列
        o1 = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());


    }
}
