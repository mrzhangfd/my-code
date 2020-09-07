package cn.sdu.juc;

import java.util.concurrent.TimeUnit;

/**
 * 多线程8锁
 *
 * @author icatzfd
 * Created on 2020/9/1 16:23.
 *
 * 1、标准访问 先打印邮件
 * 2、邮件方法暂停4秒钟，因为sleep 不释放锁，所以还是先打印邮件
 * 3、新增普通方法hello（） ，先打印邮件还是hello（）？
 * 4、两部手机（实例），先打印邮件还是短信？ 因为不同的资源类，所以先打印短信
 * 5、两个静态同步方法，同一个手机，先打印邮件还是短信 ？ 静态同步方法，锁住的是类。
 *
 *
 * 当一个线程试图访问同步代码块，它必须先获得锁，退出或抛出异常时候必须释放锁
 *
 * 普通同步方法：锁的是this这个实例对象
 * 静态同步方法：锁的是类对象本身。Class。
 *
 */
public class Lock8 {
    public static void main(String[] args)  throws Exception{
        Phone phone=new Phone();
        Phone phone1=new Phone();
        new Thread(()->{
            try {

                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        //Thread.sleep(200);

        new Thread(()->{
            try {

                phone1.sendMsg();
                //phone.hello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}

class Phone {
    public  synchronized void sendEmail() throws Exception {

        //问题2 邮件方法暂停4秒钟
        TimeUnit.SECONDS.sleep(4);

        System.out.println("send email");
    }

    public  synchronized void sendMsg() throws Exception {
        System.out.println("send msg");
    }

    public void hello(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("hello");
    }
}
