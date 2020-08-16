package cn.sdu.wangyi;

import java.util.Scanner;

/**
 * 素数
 *
 * @author icatzfd
 * Created on 2020/8/8 15:22.
 */
public class Main1 {
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
        // 第i 个数字 拆为几个
        int[] dp = new int[max + 1];
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= max; i++) {

            for (int j = 1; j < i / 2 + 1; j++) {
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
            }

        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += dp[arr[i]];
        }

        System.out.println(res);
    }
}
