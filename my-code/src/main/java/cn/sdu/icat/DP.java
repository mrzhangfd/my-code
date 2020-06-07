package cn.sdu.icat;

import java.util.Arrays;
import java.util.Scanner;

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


}

