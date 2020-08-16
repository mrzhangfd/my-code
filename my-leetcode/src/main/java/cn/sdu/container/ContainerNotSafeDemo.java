package cn.sdu.container;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类不安全的问题
 *
 * @author icatzfd
 * Created on 2020/8/11 14:18.
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        listNotSafeDemo();
        setNotSafeDemo();
        mapNotSafeDemo();

    }

    private static void mapNotSafeDemo() {
        Map<String, String> map = new ConcurrentHashMap<>();//Collections.synchronizedMap()//new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    private static void setNotSafeDemo() {
        Set<String> set = new CopyOnWriteArraySet<>();//Collections.synchronizedSet()//new HashSet<>();
        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    private static void listNotSafeDemo() {
        List<String> list = new CopyOnWriteArrayList<>();//Collections.synchronizedList()//new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
