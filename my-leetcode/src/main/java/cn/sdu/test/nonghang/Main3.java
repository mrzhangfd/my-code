package cn.sdu.test.nonghang;

import java.util.Date;

/**
 * @author icatzfd
 * Created on 2020/8/29 10:40.
 */
public class Main3 extends Date {
    private static final long serId=1L;
    private void fun(){
        System.out.println(super.getClass().getName());
    }

    public static void main(String[] args) {
        new Main3().fun();
    }

}
