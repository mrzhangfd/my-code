package cn.sdu.test.baidu;

/**
 * @author icatzfd
 * Created on 2020/9/3 21:43.
 */
public class Dog extends A {
    Dog(){
        System.out.println("D");
    }

    public static void main(String[] args) {
        Dog dog=new Dog();
    }
}

class A
{
    A(){
        System.out.println("a");
    }
}
