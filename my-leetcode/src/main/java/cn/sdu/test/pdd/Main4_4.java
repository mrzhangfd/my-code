package cn.sdu.test.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 多多的特征函数三
 *
 * @author icatzfd
 * Created on 2020/9/1 19:05.
 */
public class Main4_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }
        boolean[] arr = new boolean[n + 1];

        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int num : nums) {
                if (!arr[i] && (i % num) == 0) {
                    arr[i] = true;
                    for (int k = 2; k * i <= n; k++) {
                        arr[i * k] = true;
                    }
                }
            }
           /* for (int j = 0; j < m; j++) {
                if (!arr[i] && (i % nums[j] == 0)) {
                    arr[i] = true;
                    for (int k = i; i * k <= n; k++) {
                        arr[i * k] = true;
                    }
                }
            }*/
        }


        for (int i = 1; i <= n; i++) {
            if (arr[i]) {
                res++;
            }
        }
        System.out.println(res);
    }
}
