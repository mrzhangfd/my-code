package cn.sdu.test.qihu360;

import java.util.Scanner;

/**
 * 游戏装备 dp问题
 *
 * @author icatzfd
 * Created on 2020/8/24 11:15.
 */
public class Main4 {
   /* 作者：牛客40554809号
    链接：https://www.nowcoder.com/discuss/486979?type=post&order=create&pos=&page=1&channel=1011&source_id=search_post
    来源：牛客网*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] m_n = new int[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                m_n[i][j] = sc.nextInt();
            }
        }
        System.out.println(getResult(m_n,m,n));
    }

    private static int getResult(int[][] m_n, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < n+1; i++) {
            dp[1][i] = m_n[1][i];
        }
        for (int i = 2; i < m+1; i++) {
            dp[i][0] = 0;
            dp[i][1] = Math.max(m_n[i][1],dp[i-1][1]);
            for (int j = 2; j < n+1; j++) {
                dp[i][j] = Math.max(dp[i][j-1]+m_n[i-1][1],m_n[i][j]+m_n[i-1][1]);
            }
        }
        return dp[m][n];
    }
}
