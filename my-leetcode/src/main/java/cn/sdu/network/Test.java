package cn.sdu.network;

/**
 * @author icatzfd
 * Created on 2020/9/1 22:20.
 */
public class Test {


    public static void main(String[] args) {
        Par p=new Son();
        System.out.println(p.x);
    }
}
class Par{
    int x=1;
    public Par(){
        System.out.println("par");
    }
}
class Son extends Par{
    int x=2;
    public Son(){
        System.out.println("Son");
    }
}