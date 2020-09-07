package cn.sdu.jvm.oom;

import java.util.Random;

/**
 * @author icatzfd
 * Created on 2020/8/23 11:17.
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String str = "abc";
        while (true) {

            str += str + new Random().nextInt(111111111) + new Random().nextInt(22222222);

            //这个native方法是向运行时常量池中添加内容，
            str.intern();
        }
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        //堆溢出
    }

    private static void stackOverflowError() {
        stackOverflowError();//Exception in thread "main" java.lang.StackOverflowError
    }
}
