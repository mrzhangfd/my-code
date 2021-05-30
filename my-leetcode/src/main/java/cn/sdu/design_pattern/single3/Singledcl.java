package cn.sdu.design_pattern.single3;

/**
 * 双重校验锁
 *
 * @author icatzfd
 * Created on 2020/9/23 9:07.
 */
public class Singledcl {
    private static volatile Singledcl instance;

    private Singledcl(){};

    public Singledcl getInstance() {
        if (instance == null) {
            synchronized (Singledcl.class) {
                if (instance == null) {
                    instance=new Singledcl();
                }
            }
        }
        return instance;
    }
}
