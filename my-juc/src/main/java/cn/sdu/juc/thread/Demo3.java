package cn.sdu.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口
 * 实现Callable接口创建线程的步骤为：
 * <p>
 * （1）创建一个类并实现Callable接口
 * <p>
 * （2）重写call()方法，将所要完成的任务的代码写进call()方法中，需要注意的是call()方法有返回值，并且可以抛出异常
 * <p>
 * （3）如果想要获取运行该线程后的返回值，需要创建Future接口的实现类的对象，即FutureTask类的对象，调用该对象的get()方法可获取call()方法的返回值
 * <p>
 * 　（4）使用Thread类的有参构造器创建对象，将FutureTask类的对象当做参数传进去，然后调用start()方法开启并运行该线程。
 *
 * @author icatzfd
 * Created on 2020/8/19 11:04.
 */
public class Demo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName() + ":" + "输出的结果");

        //创建FutureTask的对象
        FutureTask<String> task = new FutureTask<String>(new ThreadDemo3());
        //创建Thread类的对象
        Thread thread3 = new Thread(task);
        thread3.setName("线程三");
        //开启线程
        thread3.start();
        //获取call()方法的返回值，即线程运行结束后的返回值
        String result = task.get();
        System.out.println(result);
    }
}

class ThreadDemo3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "：输出的结果");
        return Thread.currentThread().getName() + "：返回的结果";
    }
}
