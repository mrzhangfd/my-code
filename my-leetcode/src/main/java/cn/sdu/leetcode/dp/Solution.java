package cn.sdu.leetcode.dp;

import java.util.Arrays;

/**
 * @author icatzfd
 * Created on 2020/9/20 16:03.
 */
public class Solution {
    // 152 乘积最大子数组
    public int maxProduct(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        dp[0] = nums[0];
        int max=0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] * nums[i], nums[i]);
            max=Math.max(dp[i],max);

        }
        return max;
    }
}
