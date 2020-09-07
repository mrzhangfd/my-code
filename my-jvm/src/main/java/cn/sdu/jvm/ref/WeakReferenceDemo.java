package cn.sdu.jvm.ref;

import java.lang.ref.WeakReference;

/**
 * 弱引用
 * 对于只有弱引用的对象，只要垃圾回收机制一运行，不管内存是否足够，都会回收该对象
 *
 * @author icatzfd
 * Created on 2020/8/22 16:06.
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();
        System.out.println("==================");

        System.out.println(o1);
        System.out.println(weakReference.get());

//        java.lang.Object@7ea987ac
//        java.lang.Object@7ea987ac
//                ==================
//        null
//        null
    }
}
