package cn.sdu.test.tencent.test0906;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 中位数
 * ac
 * @author icatzfd
 * Created on 2020/9/6 20:18.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=input.nextInt();
            arr2[i]=arr1[i];
        }
        Arrays.sort(arr1);
        for(int i=0;i<n;i++){
            if(arr2[i]>arr1[n/2-1])
                System.out.println(arr1[n/2-1]);
            else {
                System.out.println(arr1[n/2]);
            }
        }
    }

}
