package cn.sdu.design_pattern;

/**双重校验锁
 * @author icatzfd
 * Created on 2020/9/22 20:54.
 */
public class Singletondcl {
    private static volatile Singletondcl singletondcl = null;

    private Singletondcl() {
    }

    public Singletondcl getInstance() {
        if (singletondcl == null) {
            synchronized (Singletondcl.class) {
                if (singletondcl == null) {
                    singletondcl = new Singletondcl();
                }
            }
        }
        return singletondcl;
    }
}
