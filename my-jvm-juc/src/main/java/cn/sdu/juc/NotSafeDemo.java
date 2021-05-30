package cn.sdu.juc;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 集合类不安全举例
 * 1、 现象：java.util.ConcurrentModificationException
 * 2、导致原因
 *
 * 3、解决方案
 *      1、Vector
 *      2、Collections.synchronizedList(new ArrayList<>())
 *      3、new CopyOnWriteArrayList<>() 写时复制的容器
 *
 * @author icatzfd
 * Created on 2020/9/2 10:29.
 */
public class NotSafeDemo {
    public static void main(String[] args) {

        mapNotSafe();
    }

    private static void mapNotSafe() {
        Map<String,String> map=new ConcurrentHashMap();//Collections.synchronizedMap();
        //三个线程 写数据
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    private static void setNotSafe() {
        Set<String> set=new CopyOnWriteArraySet<>();//Collections.synchronizedSet(new HashSet<>());//new HashSet<>();

        //三个线程 写数据
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
        //HashSet 底层是HashMap
        //HashSet的add方法调用的是HashMap的put方法。key就是要放入的元素e，value是一个final类型的Object。map.put(e,PRESENT)
        //private static final Object PRESENT=new Object();
    }

    private static void listNotSafe() {
        List<String> list = new CopyOnWriteArrayList<>();
        //三个线程往list 写数据
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
/**
 * 写时复制：
 * CopyOnWriteArrayList容器。
 * 往一个容器添加元素的时候，不直接往当前容器Object[] 添加，而是现将当前容器Object[] 进行copy，复制出一份新的容器newElements，然后往新的容器
 * newElements添加元素，添加完毕后，再将原容器的引用指向新的容器setArray(newElements)。
 * 好处：可以对CopyOnWriter容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。
 * 读写分离的思想。读和写不同的容器。
 *
 *
 *
 *      * Appends the specified element to the end of this list.
 *      *
 *      * @param e element to be appended to this list
 *      * @return {@code true} (as specified by {@link Collection#add})
 *
 *
 *     **/
    /*
    public boolean add(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getArray();
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            lock.unlock();
        }
    }*/
