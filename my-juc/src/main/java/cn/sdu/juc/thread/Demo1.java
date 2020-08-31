package cn.sdu.juc.thread;

/**
 * 创建多线程方式1
 *      继承Thread类，
 *      继承Thread类创建线程的步骤为：
 *
 * 　    （1）创建一个类继承Thread类，重写run()方法，将所要完成的任务代码写进run()方法中；
 *
 *     （2）创建Thread类的子类的对象；
 *
 *     （3）调用该对象的start()方法，该start()方法表示先开启线程，然后调用run()方法；
 * @author icatzfd
 * Created on 2020/8/18 10:37.
 */
public class Demo1 {
    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName()+"\t ");

        //创建一个线程
        ThreadDemo1 threadDemo1=new ThreadDemo1();
        threadDemo1.setName("线程1");
        //开启线程
        threadDemo1.start();
    }
}
class ThreadDemo1 extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"\t ");
    }
}
