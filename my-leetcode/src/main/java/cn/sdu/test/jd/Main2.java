package cn.sdu.test.jd;

import java.util.Scanner;

/**
 * 滚球游戏
 *
 * @author icatzfd
 * Created on 2020/8/27 20:17.
 */
public class Main2 {
    static int[][] tmp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int[][] arr=new int[n][2*n-1];
        tmp=new int[n][2*n-1];
        int start=n-1;
        int end=n;
        for(int i=0;i<n;i++){
            for(int j=start;j<end;j++){
                arr[i][j]=scanner.nextInt();
            }
            start--;
            end++;
        }
        System.out.println(maxScorce(arr,0,n-1));

    }
    static int maxScorce(int[][] arr,int i,int j){
        if(i>=arr.length||j>=arr[0].length||j<0||arr[i][j]==0){
            return 0;
        }
        if(tmp[i][j]!=0){
            return tmp[i][j];
        }
        int left=arr[i][j]+maxScorce(arr,i+1,j-1);
        int down=arr[i][j]+maxScorce(arr,i+1,j);
        int right=arr[i][j]+maxScorce(arr,i+1,j+1);
        tmp[i][j]=Math.max(left,Math.max(down,right));
        return tmp[i][j];

    }
}
