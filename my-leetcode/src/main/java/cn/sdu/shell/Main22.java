package cn.sdu.shell;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/8/11 20:30.
 */
public class Main22 {


    public static int getMinMul(int n) {
        for (int i = 2; i <= Math.pow(n, 0.5); i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            if (N == 1) {
                System.out.println(getMinMul(M));
            } else if (M == 1) {
                System.out.println(getMinMul(N));
            } else {
                int minMul = Math.min(getMinMul(N), getMinMul(M));
                System.out.println(minMul);
            }
        }
    }
}
