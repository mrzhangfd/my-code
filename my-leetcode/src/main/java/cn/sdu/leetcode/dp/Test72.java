package cn.sdu.leetcode.dp;

import org.opencv.core.Mat;

/**
 * 72 编辑距离
 *
 * @author icatzfd
 * Created on 2020/8/5 10:25.
 */
public class Test72 {
    //计算两个字符串的最小编辑距离。
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        //dp[i][j]表示 word1 的0——i 字符 转换为word2的0——j个字符所使用的最少操作数
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                if (Math.min(i, j) == 0) {
                    dp[i][j] = Math.max(i, j);
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        //dp[i-1][j] 表示 word1 的前i-1 个字符与word2的 前j个字符已经匹配的最小次数，此时为了计算dp[i][j]需要删除word1的第i个字符。
                        //dp[i][j-1] 表示word1的前i个字符与word2的前j-1个字符已经匹配的最小次数，此时为了计算dp[i][j]需要在word1后面插入一个字符。
                        //dp[i-1][j-1] 表示word1的前i-1个字符与word2的前j-1个字符已经匹配的最小次数，此时为了计算dp[i][j]需要替换word1的第i个字符。
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }

            }
        }

        return dp[len1][len2];
    }

    //判断两个字符串的编辑距离是不是1
    public boolean oneDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        //如果两个字符串长度相同，则编辑操作为替换。找到第一个不同的字符，如果有两个不同的字符，返回false
        if (len1 == len2) {
            //不同字符的数量
            int count = 0;
            for (int i = 0; i < len1; i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    count++;
                }
            }
            if (count >= 2) {
                return false;
            } else {
                return true;
            }

        } else if (Math.abs(len1 - len2) == 1) {
            //第一个不同字符的位置，假设为index.如果长字符在index之后的字符串内容 和 短字符包括index在内的之后的字符串内容相同，则返回true、
            // //如果两个字符串长度相差为1，则编辑操作为插入或者删除。
            if (len1 > len2) {
                for (int i = 0, j = 0; i < len1 && j < len2; i++, j++) {
                    if (word1.charAt(i) != word2.charAt(j)) {
                        return word1.substring(i + 1).equals(word2.substring(j));
                    }
                }
            } else {
                for (int i = 0, j = 0; i < len1 && j < len2; i++, j++) {
                    if (word1.charAt(i) != word2.charAt(j)) {
                        return word1.substring(i).equals(word2.substring(j + 1));
                    }
                }
            }


        } else {
            //如果长度相差大于1，则返回false
            return false;
        }

        return true;
    }
}
