package cn.sdu.test.gld.test0916;

import java.util.Scanner;

/**
 * 元素平衡
 *
 * @author icatzfd
 * Created on 2020/9/16 20:51.
 */
public class Main2 {


    public static long balance(long a, long b, long c, long d) {
        long sum = a + b + c + d;
        long avg = sum / 4;
        for (long x = avg; x >= 0; x--) {
            long left = sum - 4 * x;
            long right = 0;
            if (x - a > 0) {
                right += x - a;
            }
            if (x - b > 0) {
                right += x - b;
            }
            if (x - c > 0) {
                right += x - c;
            }
            if (x - d > 0) {
                right += x - d;
            }
            if (left >= right) {
                return 4 * x;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a=sc.nextLong();
        long b=sc.nextLong();
        long c=sc.nextLong();
        long d=sc.nextLong();

        System.out.println(balance(a, b, c, d));
    }


}
