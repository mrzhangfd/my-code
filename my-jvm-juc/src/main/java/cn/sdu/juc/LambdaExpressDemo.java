package cn.sdu.juc;


/**
 * 接口中，有且仅有一个抽象方法，自动加上函数式接口
 */
@FunctionalInterface
interface Foo{
    //public void sayHello();
    public int add(int a,int b);

    //默认方法实现
    default int mul(int a,int b){
        System.out.println("mul");
        return a*b;
    }

    //可以有多个默认方法实现
    default int div(int a,int b){
        System.out.println("mul");
        return a/b;
    }
    //静态方法实现，可以有多个静态方法
    public static  int div2(int a,int b){
        return a/b;
    }

}
/**
 * lambda表达式
 * 2    Lambda Express
 *      2.1 拷贝小括号，写死右箭头，落地大括号
 *      2.2 @FunctionalInterface
 *      2.3 default java8 后的接口中可以有default的方法实现
 *      2.4 static 静态方法实现
 * @author icatzfd
 * Created on 2020/9/1 10:26.
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {

        //lambda 表达式
        //无参
     /*   Foo foo=()->{
            System.out.println("hello lambda");
        };
        foo.sayHello();//hello lambda*/

        //有参
        Foo foo=(a,b)->{
            System.out.println(a+"\t" +b);
            return a+b;
        };
        System.out.println(foo.add(1, 2));
        System.out.println(Foo.div2(4, 2));


       /* Foo foo=new Foo() {
            //匿名内部类，实现Foo中的方法
            @Override
            public void sayHello() {
                System.out.println("hello123");
            }
        };

        //调用接口中的方法
        foo.sayHello();//hello123*/

    }
}
