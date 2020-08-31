package cn.sdu.test.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 斐波那契蛇
 *
 * @author icatzfd
 * Created on 2020/8/21 19:37.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int size=n*n;
        List<Integer> list=new ArrayList<>();
        Fibonacci(size, list);
        int count=size-1;
        int up=0,down=n-1;
        int left=0,right=n-1;
        int[][] res=new int[n][n];
        while (count>=0){
            for(int j=left;j<=right;j++){
                res[up][j]=list.get(count--);
            }

            up++;
            if(up>down){
                break;
            }

            for(int i=up;i<=down;i++){
                res[i][right]=list.get(count--);
            }

            right--;
            if(right<left){
                break;
            }

            for(int j=right;j>=left;j--){
                res[down][j]=list.get(count--);
            }

            down--;
            if(down<up){
                break;
            }

            for(int i=down;i>=up;i--){
                res[i][left]=list.get(count--);
            }
            left++;
            if(left>right){
                break;
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==n-1){
                    System.out.print(res[i][j]);
                }else {
                    System.out.print(res[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    public static List<Integer> Fibonacci(int n, List<Integer> list) {

        if(n==1){
            list.add(1);
            return list;
        }

        int a=0;
        int b=1;
        list.add(b);
        int c=0;
        for(int i=2;i<=n;i++){
            c=a+b;
            list.add(c);
            a=b;
            b=c;
        }

        return list;
    }
}
