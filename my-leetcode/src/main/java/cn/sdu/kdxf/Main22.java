package cn.sdu.kdxf;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给出一个数字序列，需要输出排序过程
 * @author icatzfd
 * Created on 2020/7/31 15:50.
 */
public class Main22 {
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }

        i = low;
        j = high;
        temp = arr[low];
        while (i < j) {
            while (temp <= arr[j] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }

        arr[low] = arr[i];
        arr[i]=temp;
        if(high-low>0){
            System.out.println(Arrays.toString(arr));
        }
        quickSort(arr,low,j-1);
        quickSort(arr,j+1,high);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        quickSort(nums,0,n-1);

    }
}
