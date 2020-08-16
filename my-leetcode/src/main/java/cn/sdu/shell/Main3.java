package cn.sdu.shell;

import java.util.Scanner;

/**
 * 最大子段或
 *
 * @author icatzfd
 * Created on 2020/8/11 19:29.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            if(dp[i-1]==0){

            }
        }

    }
}
