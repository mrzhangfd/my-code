package cn.sdu.design_pattern;

/**
 * 静态内部类 单例
 *
 * @author icatzfd
 * Created on 2020/9/22 20:57.
 */
public class SingletonInnerClass {

    private SingletonInnerClass() {
    }


    static class SingleHelper {
        private static final SingletonInnerClass single = new SingletonInnerClass();
    }

    public SingletonInnerClass getInstance() {
        return SingleHelper.single;
    }
}
