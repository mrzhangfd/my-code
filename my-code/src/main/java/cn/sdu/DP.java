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



    public static void main(String[] args) {
        DP dp = new DP();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(dp.minPathSum(grid));

    }

    private void minPathSumHelper(int i, int j, int[][] grid, int[][] dp) {

        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
    }


}

