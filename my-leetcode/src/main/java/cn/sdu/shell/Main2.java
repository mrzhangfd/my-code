package cn.sdu.shell;

import java.util.Scanner;

/**
 * 蛋壳第二题
 *
 * @author icatzfd
 * Created on 2020/8/11 18:52.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n * m == 1) {
                System.out.println(1);
            } else if ((n * m) % 2 == 0) {
                System.out.println(2);
            } else {
                boolean flag = false;
                for (int j = 3; j <= Math.pow(n * m, 0.5); j = j + 2) {
                    if ((n * m) % j == 0) {
                        flag = true;
                        System.out.println(j);
                        break;
                    }
                }
                if (!flag) {
                    System.out.println(Math.min(n, m));
                }

            }
        }
    }
}
