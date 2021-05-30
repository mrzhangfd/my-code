package cn.sdu.design_pattern.single3;

/**
 * @author icatzfd
 * Created on 2020/9/23 9:19.
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    //懒汉式 ——线程不安全 ,可以实现延迟实例化，如果没有用到该类，就不会实例化，节省资源
    public Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    //懒汉式——线程安全 但是存在性能问题，不推荐使用
    public synchronized Singleton getInstance1() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    //饿汉式——线程安全
    //线程不安全问题主要是由于 uniqueInstance 被实例化多次，采取直接实例化 instance1 的方式就不会产生线程不安全问题。
    //但是直接实例化的方式也丢失了延迟实例化带来的节约资源的好处。
    private static Singleton instance1 = new Singleton();


    //双重校验锁
    private static volatile Singleton instance2;

    public Singleton getInstance2() {
        if (instance2 == null) {
            synchronized (Singleton.class) {
                if (instance2 == null) {
                    instance2 = new Singleton();
                }
            }
        }
        return instance2;
    }

    //静态内部类
    static class SingleHelper {
        private final static Singleton instance = new Singleton();
    }

    public Singleton getInstace3() {
        return SingleHelper.instance;
    }
}
