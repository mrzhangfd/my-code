package cn.sdu.jvm.ref;

/**
 * 强引用
 *
 * @author icatzfd
 * Created on 2020/8/22 15:43.
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object ob1 = new Object();
        //强引用
        Object ob2 = ob1;

        ob1 = null;
        //ob1 置空，垃圾回收会回收掉ob1

        System.gc();

        System.out.println(ob1);
        //null

        System.out.println(ob2);
        //但是ob2 不会被回收 结果为：java.lang.Object@7ea987ac

    }
}
