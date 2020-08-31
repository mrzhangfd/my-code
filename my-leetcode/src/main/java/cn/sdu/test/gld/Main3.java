package cn.sdu.test.gld;

import java.util.Scanner;

/**
 * 机器人 曹老板
 *
 * @author icatzfd
 * Created on 2020/8/19 21:36.
 */
public class Main3 {
    // 0 1 背包问题
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        float[] dian = new float[n + 1];
        int[] yuyue = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dian[i] = sc.nextFloat();

            yuyue[i] = sc.nextInt();
        }
        int[][] dp = new int[n + 1][c + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= c; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    float d = dian[i];
                    int y = yuyue[i];
                    if (j >= d) {
                        dp[i][j] = Math.max(dp[i - 1][j - (int) (d+0.5)] + y, dp[i-1][j]);

                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[n][c]);
    }
}
