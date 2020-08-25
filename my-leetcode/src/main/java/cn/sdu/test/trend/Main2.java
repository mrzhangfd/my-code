package cn.sdu.test.trend;

import java.util.Scanner;

/**
 * 打印旋转矩阵
 * @author icatzfd
 * Created on 2020/8/23 16:38.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n<1 ||n >20){
            System.out.println("error");
            return;
        }

        int up=0;
        int down=n-1;
        int left=0;
        int right=n-1;
        int count=1;
        int[][] arr=new int[n][n];
        while (count<=n*n){
            for(int i=up;i<=down;i++){
                arr[i][right]=count++;
            }

            right--;
            if(right<left){
                break;
            }

            for(int j=right;j>=left;j--){
                arr[down][j]=count++;
            }

            down--;
            if(down<up){
                break;
            }

            for(int i=down;i>=up;i--){
                arr[i][left]=count++;
            }

            left++;
            if(left>right){
                break;
            }

            for(int j=left;j<=right;j++){
                arr[up][j]=count++;
            }

            up++;
            if(up>down){
                break;
            }

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%4c",arr[i][j]);
            }
            if(i!=n-1){
                System.out.println();
            }
        }
    }
}
