package cn.sdu.test.pdd;

import java.util.Scanner;

/**
 * 多多的背包
 *
 * @author icatzfd
 * Created on 2020/9/1 19:37.
 */
public class Main3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                int temp = nums[i][0];
                if (j >= temp) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - temp] + temp);
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
