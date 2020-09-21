package cn.sdu.jvm.gc;

import java.util.Random;

/**七大垃圾回收器
 * 1、-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX+UseSerialGC         (DefNew+Tenured)
 * @author icatzfd
 * Created on 2020/9/12 16:14.
 */
public class GCDemo {
    public static void main(String[] args) {
        System.out.println("GCDemo hello");

        String str="test";
        while (true){
            str+=str+new Random().nextInt(7777777)+new Random().nextInt(8888888);
            str.intern();
        }
    }
}
