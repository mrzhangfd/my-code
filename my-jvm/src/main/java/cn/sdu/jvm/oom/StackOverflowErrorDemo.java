package cn.sdu.jvm.oom;

/**
 * @author icatzfd
 * Created on 2020/8/23 11:17.
 */
public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        //方法调用太多次，栈溢出
        stackOverflowError();//Exception in thread "main" java.lang.StackOverflowError
    }
}
