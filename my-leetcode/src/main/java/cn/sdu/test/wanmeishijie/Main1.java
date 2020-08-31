package cn.sdu.test.wanmeishijie;

import java.util.Scanner;

/**
 * 背包问题
 *
 * @author icatzfd
 * Created on 2020/8/25 20:35.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int knapsackCapacity = Integer.parseInt(input.nextLine().trim());

        String[] volumesStr = input.nextLine().split(" ");
        int[] volumes = new int[volumesStr.length];
        for (int i = 0; i < volumesStr.length; i++) {
            volumes[i] = Integer.parseInt(volumesStr[i].trim());
        }

        String[] valuesStr = input.nextLine().split(" ");
        int[] values = new int[valuesStr.length];
        for (int i = 0; i < valuesStr.length; i++) {
            values[i] = Integer.parseInt(valuesStr[i].trim());
        }

        if (volumes.length == values.length) {
            System.out.println(method(knapsackCapacity, volumes, values));
        }else {
            System.out.println("道具数量不一致。");
        }
        input.close();
    }


    private static int method(int knapsackCapacity, int[] volumes, int[] values) {
        //c 背包容量
        int c=knapsackCapacity;

        //n 物品数量
        int n= volumes.length;

        //前i 件物品，用j 容量背包，所能装的最大价值
        int[][] dp=new int[n+1][c+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=c;j++){
                if(i==0 ||j==0){
                    dp[i][j]=0;
                }else {
                    int w=volumes[i-1];
                    if(j>=w){
                        dp[i][j]=Math.max(dp[i-1][j-w]+values[i-1],dp[i-1][j]);
                    }else {
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }


        return dp[n][c];
    }
}
