package cn.sdu.test.sico;

/**
 * @author icatzfd
 * Created on 2020/9/7 20:41.
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "test";
        String s2 = "test";

        String s3 = new String("test");
        String s4 = new String("test");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);

    }
}

