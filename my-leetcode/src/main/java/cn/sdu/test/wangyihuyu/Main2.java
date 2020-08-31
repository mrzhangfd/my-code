package cn.sdu.test.wangyihuyu;

import java.util.Scanner;

/**
 * 曹智版
 * @author icatzfd
 * Created on 2020/8/12 21:06.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
        int[] rowSum=new int[n];
        int[] colSum=new int[n];
        for(int i=0;i<n;i++){
            int rowSumTemp=0;
            int colSumTemp=0;
            for(int j=0;j<n;j++){
                rowSumTemp+=arr[i][j];
                colSumTemp+=arr[j][i];

            }
            rowSum[i]=rowSumTemp;
            colSum[i]=colSumTemp;
        }
        int[][] res = new int[n][2];
        int t=0;
        for(int i=0;i<n;i++){
            int max=0,r=0,c=0;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    int sum=rowSum[j]+colSum[k]-arr[j][k];
                    if(max<sum){
                        max=sum;
                        r=j;
                        c=k;
                    }
                }
            }
            rowSum[r]=0;
            for(int j=0;j<n;j++){
                colSum[j]-=arr[r][j];
                arr[r][j]=0;
            }

            colSum[c]=0;
            for(int j=0;j<n;j++){
                rowSum[j]-=arr[j][c];
                arr[j][c]=0;
            }


            res[t][0]=r;
            res[t][1]=c;
            t++;

            for(int j=0;j<t;j++){
                if(res[j][0]<r)
                    r--;
                if(res[j][1]<c)
                    c--;
            }
            System.out.println((r+1)+" "+(c+1));
        }
    }
}
