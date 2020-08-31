package cn.sdu.leetcode.dp;

import java.util.Arrays;

/**
 * 最长公共子序列
 *
 * @author icatzfd
 * Created on 2020/8/3 20:24.
 */
public class Test1143 {
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        int len1 = text1.length();
        int len2 = text2.length();
        //dp[i][j]表示 text1的前i个字符和text2的前j个字符最长公共子序列的长度
        int[][] dp = new int[len1][len2];
        //初始化
        int idx = 0;
        if (text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        } else {
            dp[0][0] = 0;
        }
        for (int j = 1; j < len2; j++) {
            if (text1.charAt(0) != text2.charAt(j)) {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < len1; i++) {
            if (text2.charAt(0) != text1.charAt(i)) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] =dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1-1][len2-1];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc","def"));
    }
}
