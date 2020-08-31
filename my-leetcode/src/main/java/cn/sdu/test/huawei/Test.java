package cn.sdu.test.huawei;

/**
 * @author icatzfd
 * Created on 2020/8/19 20:33.
 */
public class Test {
    private static Integer age;
    public static void main(String[] args) {
        g(age);
        System.out.println(age);
       /*String s="[[7,9],[1,1],[8,2],[7,5],[4,4]]";
       String ss="[[7, 9], [1, 1], [8, 2], [7, 5], [4, 4]]";
       ss=ss.replaceAll(" ","");
        System.out.println(ss);
        System.out.println(s.equals(ss));
        System.out.println(ss.replaceAll(" ",""));*/
    }
    public static void g(int age){
        age++;}
}
