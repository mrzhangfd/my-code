package cn.sdu.test.yitu;

import java.util.Scanner;

/**
 * 珠子
 *
 * @author icatzfd
 * Created on 2020/8/28 16:41.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        for(int i=0;i<m;i++){
            String str=sc.next();
            int len=str.length();
            int[][] dp=new int[len+1][len+1];
            dp[0][0]=0;
            for(int j=0;j<=len;j++){
                for(int k=0;k<=len;k++){
                    if(j==0 ||k==0){
                        dp[j][k]=0;
                    }

                }

            }
        }
    }
}
