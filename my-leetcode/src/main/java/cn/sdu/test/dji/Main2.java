package cn.sdu.test.dji;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/discuss/479182?type=post&order=create&pos=&page=1&channel=666&source_id=search_post
 * https://www.nowcoder.com/discuss/479244
 * AC 100%
 * @author icatzfd
 * Created on 2020/8/16 19:29.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int x=scanner.nextInt();
        int[][] arr=new int[2][n+1];
        for(int i=1;i<=n;i++){
            arr[0][i]=scanner.nextInt();
            arr[1][i]=scanner.nextInt();
        }
        //dp[i][j]表示 计划j天 ，玩i个游戏的最大成就值。
        int[][] dp=new int[n+1][x+1];
        //最大成就值（点数）
        int maxPoints=0;
        //此处循环是为了初始化 ，只计划1天，即x=1时，取得的最大成就值。
        for(int i=1;i<=n;i++){
            if(arr[1][i]==1){
                maxPoints=Math.max(maxPoints,arr[0][i]);
            }
            dp[i][1]=maxPoints;
        }


        //此处循环是为了初始化 ，只玩第一个游戏，n=1时，取得的最大值。
        for(int i=1;i<=x;i++){
            if(arr[1][1]<=i){
                dp[1][i]=arr[0][1];
            }
        }
        for(int i=2;i<=n;i++){
            for(int j=2;j<=x;j++){
                int tmp=arr[1][i];
                if(tmp<=j){
                    dp[i][j]=Math.max(dp[i-1][j-tmp]+arr[0][i],dp[i-1][j]);
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][x]);
    }

}
