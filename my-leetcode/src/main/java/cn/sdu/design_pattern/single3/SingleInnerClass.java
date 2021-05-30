package cn.sdu.design_pattern.single3;



/**
 * 静态内部类 单例模式
 *
 * @author icatzfd
 * Created on 2020/9/23 8:53.
 */
public class SingleInnerClass {
    private SingleInnerClass() {

    }

    static class SingleHelper{
        static final SingleInnerClass instance=new SingleInnerClass();
    }

    public SingleInnerClass getInstance(){
        return SingleHelper.instance;
    }
}
