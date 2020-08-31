package cn.sdu.leetcode.greedy;

import java.util.*;

/**
 * 跳跃游戏
 *
 * @author icatzfd
 * Created on 2020/8/1 15:54.
 */
public class Test55_跳跃游戏 {
    //
    public static boolean canJump(int[] nums) {

        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    //Test45 跳跃游戏2
    public static int jump(int[] nums) {
        //此法超时了

        //dp[i] 表示从0位置跳到i位置最少的步数
        if (nums.length == 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0,last=0; i < nums.length; i++) {
            if(i==0){
                dp[i]=0;
            }
            else {
                while (last< nums.length&& last+nums[last]<i){
                    last++;
                }
                // 使用第一个能到i的点更新dp[i]
                dp[i]=dp[last]+1;
            }

        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
