package cn.sdu.juc;


/**
 * 卖票
 * 多线程编程的企业级套路+模板
 * 1、 高内聚低耦合的前提下， 线程          操作(对外暴露的调用方法)           资源类
 *
 * @author icatzfd
 * Created on 2020/8/31 17:20.
 */
public class SaleTicket {
    public static void main(String[] args) throws Exception {
        Ticket ticket=new Ticket();
        for (int i = 1; i <= 3; i++) {

        }

        Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = new Thread();

    }
}


/**
 * //资源类
 */
class Ticket {
    private int num = 30;

    public void saleTicket() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "\t 卖掉第"+num--+"还剩下"+num);
        }
    }

}