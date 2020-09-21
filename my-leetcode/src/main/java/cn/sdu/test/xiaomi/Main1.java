package cn.sdu.test.xiaomi;

import java.util.Scanner;

/**
 * 密码生成器
 *
 * @author icatzfd
 * Created on 2020/9/8 18:37.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] strings = str.split(" ");
        for (String ss : strings) {
            if (ss.length() > 120 || ss.length() < 8) {
                System.out.println(1);
                continue;
            } else {
                for (int i = 0; i < ss.length(); i++) {

                }
            }
        }
    }
}
