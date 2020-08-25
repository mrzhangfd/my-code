package cn.sdu.test.qihu360;

import java.util.Arrays;
import java.util.Scanner;

/**调整排列
 * @author icatzfd
 * Created on 2020/8/22 20:10.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=i+1;
        }
        for(int i=0;i<m;i++){
            if(sc.nextInt()==1){
                move(res);
            }else {
                swapAll(res);
            }
        }

        for(int i=0;i< res.length;i++){
            if(i== res.length-1){
                System.out.print(res[i]);
            }else {
                System.out.print(res[i]+" ");
            }
        }
    }
    public static void swapAll(int[] arr){
        for(int i=0;i< arr.length;i=i+2){
            swap(arr,i,i+1);
        }
    }

    public static void swap(int[] arr,int l,int r){
        int temp=arr[l];
        arr[l]= arr[r];
        arr[r]=temp;
    }
    public static void move(int[] arr){
        int temp=arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=temp;
    }

}
