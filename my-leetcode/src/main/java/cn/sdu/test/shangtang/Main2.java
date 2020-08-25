package cn.sdu.test.shangtang;

import java.util.Scanner;

/**
 * 矩阵中的最长上升路径
 *
 * @author icatzfd
 * Created on 2020/8/20 20:44.
 */
public class Main2 {

        static int[][] dp;
        static int[] dx = {1, -1, 0, 0};
        static int[] dy = {0, 0, 1, -1};
        public static void main (String[]args){
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] nums = new int[n][m];
            dp = new int[n][m];
            int res = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = -1;
                    nums[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    res = Math.max(res, search(i, j, nums));
                }
            }
            System.out.println(res);


        }

        public static int search(int x,int y,int[][] arr){
            if(dp[x][y]!=-1){
                return dp[x][y];
            }
            int res=1;
            int xT,yT;
            for(int i=0;i<4;i++){
                xT=x+dx[i];
                yT=y+dy[i];
                if(0<=xT&&xT<arr.length&&0<=yT&&yT<arr[0].length){
                    if(arr[x][y]>arr[xT][yT]){
                        res=Math.max(res,search(xT,yT,arr)+1);
                    }
                }
            }
            dp[x][y]=res;
            return res;

        }
    }

