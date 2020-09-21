package cn.sdu.test.xiaohongshu;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 勇士挑战赛
 *
 * @author icatzfd
 * Created on 2020/9/6 19:41.
 */
public class Main2 {
    public static void main(String[] args) {
        Queue<Integer> queue=new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (i <= 2) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                int a = dp[i - 1];
                int b = dp[i - 2] + nums[i - 1];
                int c = dp[i - 3] + nums[i - 2] + nums[i - 1];
                int d = dp[i - 4] + nums[i - 1] + nums[i - 2] + nums[i - 3];

            }
        }
    }
}
