package design_pattern;



/**
 * 单例模式
 *
 * @author icatzfd
 * Created on 2020/7/11 10:49.
 */

/*public class Singleton {
    //利用静态内部类实现单例模式
    //延迟加载、线程安全
    private Singleton(){}
    //静态内部类在使用的时候才加载，只加载一次
    private static  class T{
        private static  Singleton t=new Singleton();
    }

    public static Singleton getInstance(){
        return T.t;
    }
}*/

//双重校验锁，使用volatile的场景之一
/*public class Singleton{
    private static volatile Singleton instance=null;
    private Singleton(){}

    //双重检查加锁，只有在第一次实例化时，才启用同步机制，提高性能。
    public  static  Singleton getInstance(){
        if(instance==null){
            synchronized(Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}*/






