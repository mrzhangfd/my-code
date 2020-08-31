package cn.sdu.jvm.gc;

/**jvm 各种参数
 * @author icatzfd
 * Created on 2020/8/22 9:03.
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
       /* System.out.println("++");
        Thread.sleep(Integer.MAX_VALUE);*/
        int a=2,b=3,c=4,d=5;
        System.out.println(--b *a + c*d--);
    }
}
