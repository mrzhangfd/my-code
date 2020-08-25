package cn.sdu.test.tencent.test0823;

import java.util.Scanner;

/**
 * 刷板子问题
 *
 * @author icatzfd
 * Created on 2020/8/23 20:42.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] nums=new int[n+1];
        for(int i=1;i<=n;i++){
            nums[i]=sc.nextInt();
        }
        if(n==1){
            System.out.println(1);
            return;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            if(i==2){
                if(nums[i]>nums[i-1] || nums[i]<nums[i-1]){
                    dp[i]=2;
                }else {
                    if(nums[i]==1){
                        dp[i]=1;
                    }else {
                        dp[i]=2;
                    }
                }

            }else {
                if(nums[i]>nums[i-1]){
                    dp[i]=dp[i-1]+1;
                }else {
                    dp[i]=dp[i-1];
                }
            }

        }
        System.out.println("==========");
        System.out.println(dp[n]);


    }
}
