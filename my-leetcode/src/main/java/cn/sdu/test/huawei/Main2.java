package cn.sdu.test.huawei;

import java.util.Scanner;

/**
 * 二叉树的个数
 *
 * @author icatzfd
 * Created on 2020/8/19 19:58.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[scanner.nextInt()]+=1;
        }

        long res=1;
        for(int i=1;i<n;i++){
            if(arr[i]!=0){
                int q=arr[i-1]*2;
                int m=arr[i];
                if(m>q){
                    System.out.println(0);
                    return;
                }
                res*=factorial(q)/(factorial(q-m)*factorial(m));
            }else{
                break;
            }
        }

        System.out.println(res/1000000007);
    }

    public static long factorial(long number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}
