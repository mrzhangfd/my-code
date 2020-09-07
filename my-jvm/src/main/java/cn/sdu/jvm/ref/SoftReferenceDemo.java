package cn.sdu.jvm.ref;

import java.lang.ref.SoftReference;

/**
 * 软引用
 * 对于只有软引用的对象来说：内存足够：不会回收它。内存不足时，会被回收
 * 软引用通常用在对内存敏感的程序中，比如“高速缓存”就有用到软引用。 内存够用时就保留，不够用时就回收。
 *
 * @author icatzfd
 * Created on 2020/8/22 15:46.
 */
public class SoftReferenceDemo {

    public static void softRefMemoryEnough() {
        Object o1 = new Object();
        //软引用
        SoftReference<Object> softReference = new SoftReference<>(o1);

        System.out.println(o1);
        System.out.println(softReference.get());

        //手动gc
        o1 = null;
        System.gc();

        //再次打印o1 和软引用
        System.out.println(o1);
        System.out.println(softReference.get());
        //null
        //java.lang.Object@7ea987ac
    }

    /**
     * 手动jvm 配置，故意产生大对象并配置小内存，让内存不够用导致oom，看软引用的回收情况
     * 配置内存为5m
     * -Xms5m -Xmx5m -XX：+PrintGCDetails
     */
    public static void softRefMemoryNotEnough() {
        Object o1 = new Object();
        //软引用
        SoftReference<Object> softReference = new SoftReference<>(o1);

        System.out.println(o1);
        System.out.println(softReference.get());

        //手动gc
        o1 = null;

        try {
            //new一个30M的大对象
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }

    }

    public static void main(String[] args) {
        softRefMemoryNotEnough();
    }
}
