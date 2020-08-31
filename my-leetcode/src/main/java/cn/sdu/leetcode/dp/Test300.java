package cn.sdu.leetcode.dp;

import java.util.Arrays;

/**
 * 300 最长上升子序列
 *
 * @author icatzfd
 * Created on 2020/8/4 10:14.
 */
public class Test300 {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        //dp[i]表示：以nums[i]结尾的最长上升子序列
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max=0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);

                }

            }
            max=Math.max(dp[i],max);

        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(lengthOfLIS(nums));
    }
}
