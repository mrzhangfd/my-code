package cn.sdu;

import java.util.Arrays;

/**
 * @author 张峰达
 * 动态规划
 * Created on 2020/4/28 11:52.
 */

public class DP {
    public int rob(int[] nums) {
        //dp[i]表示抢劫到第i家时候总货物
        int[] dp = new int[nums.length + 1];
        //dp[i]=max(dp[i-2]+nums[i],dp[i-1])
        if (nums.length <= 2) {
            Arrays.sort(nums);
            return nums[nums.length - 1];
        }
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(dp[1], nums[1]);
        for (int i = 3; i <= nums.length; i++) {

            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[nums.length];

    }

    //64 最小路径和
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];

                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];

                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];

                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);

                }
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    //5 最长回文子串
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        //定义状态 ,dp[i][j]表示从j到j是否为回文子串
        boolean[][] dp = new boolean[len][len];

        char[] chars = s.toCharArray();
        //初始化状态
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;

        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    //300 最长上升子序列
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(nums, 1);
        int res = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    /**
     * 背包问题
     *
     * @param n     物品数量
     * @param goods 物品的数组
     * @param c     背包容量
     * @return
     */
    public static int packaged(int n, int[][] goods, int c) {
        //dp[i][j] 表示前i个物品 放到j容量的包中 获得的最大价值。
        int[][] dp = new int[n + 1][c + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < c + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    int w = goods[i - 1][0];
                    int v = goods[i - 1][1];
                    if (j >= w) {
                        dp[i][j] = Math.max(dp[i - 1][j - w] + v, dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }

                }

            }
        }
        return dp[n][c];
    }

    public static void main(String[] args) {
        DP dp = new DP();
        int[][] googs = {{1, 6}, {2, 9}, {3, 13}};
        System.out.println((int)5.90);
        //System.out.println(packaged(3, googs, 5));
        /*int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[] nums={10,9,2,5,3,7,101,18};
        System.out.println(dp.lengthOfLIS(nums));*/


    }

    private void minPathSumHelper(int i, int j, int[][] grid, int[][] dp) {

        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
    }


}

