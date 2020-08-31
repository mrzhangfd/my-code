package cn.sdu.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * GC回收时间过长
 *JVM参数配置：
 *      -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 * GC回收时间过长时，会抛出OutOfMemoryError
 *         过长的定义：超过98%的时间用来做GC 并且回收了不到2%的堆内存，
 *         连续多次GC都只回收了不到2%的极端情况才会抛出，假如不抛出GC overhead limit 错误：
 *         那么GC清理的这点内存会很快再次填满，迫使GC再次执行。这样就形成恶性循环
 *         cpu使用率一直是100%，而GC没有任何成果
 *
 * @author icatzfd
 * Created on 2020/8/23 14:45.
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
      /*  int i=0;
        List<String> list=new ArrayList<>();

        try{
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        }catch(Exception e){
            e.printStackTrace();//Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
        }finally{
            System.out.println(i);
        }*/
        Integer a=new Integer(2);
        Integer d=new Integer(2);
        Integer b=2;
        int c=2;
        System.out.println(a==b);
        System.out.println(a==c);
    }
}
