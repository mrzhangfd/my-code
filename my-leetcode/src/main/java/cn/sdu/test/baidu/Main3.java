package cn.sdu.test.baidu;

import java.util.Scanner;

/**
 * 变态走台阶
 *
 * @author icatzfd
 * Created on 2020/9/3 20:14.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
        }
        if (n == 2) {
            if (m <= 1) {
                System.out.println(0);
            } else if (m == 2) {
                System.out.println(1);
            }
        }
        if (n == 3) {
            if (m <= 1) {
                System.out.println(0);
            } else if(m==2) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }

        }
        if(n==4){
            if(m<=2){
                System.out.println(0);
            }else if(m==3){
                System.out.println(2);
            }else {
                System.out.println(3);
            }
        }
        if(n==5){
            if(m<=2){
                System.out.println(0);
            }else if(m==3){
                System.out.println(2);
            }else if(m==4){
                System.out.println(4);
            }else {
                System.out.println(5);
            }
        }

    }
}
