package cn.sdu.wangyi;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/8/8 16:34.
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            max = Math.max(max, arr[i]);
        }
        if (max < 2) {
            System.out.println(0);
            return;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (arr[i] >= 3) {
                arr[i] -= 2;
                res++;
            }
        }
        System.out.println(res);
    }
}
