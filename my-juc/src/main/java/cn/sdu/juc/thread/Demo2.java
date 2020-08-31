package cn.sdu.juc.thread;

/**
 * 实现Runnable接口
 *         实现Runnable接口创建线程的步骤为：
 *
 *      （1）创建一个类并实现Runnable接口
 *
 *      （2）重写run()方法，将所要完成的任务代码写进run()方法中
 *
 *      （3）创建实现Runnable接口的类的对象，将该对象当做Thread类的构造方法中的参数传进去
 *
 *      （4）使用Thread类的构造方法创建一个对象，并调用start()方法即可运行该线程
 * @author icatzfd
 * Created on 2020/8/18 10:40.
 */
public class Demo2 {
    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName()+":"+"输出的结果");
        //创建一个新线程
        Thread thread2 = new Thread(new ThreadDemo2());
        //为线程设置名称
        thread2.setName("线程二");
        //开启线程
        thread2.start();
    }
}

class ThreadDemo2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":"+"输出的结果");
    }
}
