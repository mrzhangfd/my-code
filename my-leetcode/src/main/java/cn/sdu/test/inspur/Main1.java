package cn.sdu.test.inspur;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 石头
 *
 * @author icatzfd
 * Created on 2020/9/19 19:14.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int max = 0;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (arr[i] - 1 != 0) {
                dp[arr[i] - 1] = dp[arr[i] - 2] + 1;
            } else {
                dp[arr[i] - 1] = 1;
            }

        }
        for(int i=0;i<n;i++){
            max=Math.max(dp[i],max);
        }
        System.out.println(n-max);

    }

    public static int lenOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int max = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }

            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
