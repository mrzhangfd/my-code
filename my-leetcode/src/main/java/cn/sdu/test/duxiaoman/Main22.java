package cn.sdu.test.duxiaoman;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/9/20 21:14.
 */
public class Main22 {
    static int res=Integer.MAX_VALUE;
    static int[] dirx ={-1,0,1,0};
    static int[] diry ={0,1,0,-1};
    static int[][] dp;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0;i<t;i++){
            res=Integer.MAX_VALUE;
            int m = scanner.nextInt();
            int n =scanner.nextInt();
            dp=new int[m][n];
            for(int j=0;j<m;j++) {
                for(int k=0;k<n;k++) {
                    dp[j][k]=Integer.MAX_VALUE;
                }
            }
            int row=0,col=0;
            char[][] map =new char[m][n];
            for(int j=0;j<m;j++){
                String next = scanner.next();
                int index = next.indexOf("@");
                if(index!=-1){
                    row=j;
                    col=index;
                }
                map[j]=next.toCharArray();
            }
            findWay(map,row,col,0);
            System.out.println(res==Integer.MAX_VALUE?-1:res);

        }


    }
    public static void findWay(char[][] map,int row,int col,int count) {
        if (map[row][col] != '#' && (row == 0 || row == map.length - 1 || col == 0 || col == map[0].length - 1)) {
            if (map[row][col] == '*') {
                count++;
            }
            res = Math.min(res, count);

            return;
        } else if (row == 0 || row == map.length - 1 || col == 0 || col == map[0].length - 1 || map[row][col] == '#') {
            return;
        }


        if (map[row][col] == '*') {
            count++;
        }
        if (dp[row][col] <= count) {
            return;
        }
        dp[row][col] = count;
        for (int i = 0; i < 4; i++) {

            findWay(map, row + dirx[i], col + diry[i], count);
        }
    }
}
