package cn.sdu.test.kdxf;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给出一个数字序列，需要输出排序过程
 * @author icatzfd
 * Created on 2020/7/31 14:39.
 */
public class Main2 {

    //快排
    public static int[] quickSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSortHelper(arr, 0, arr.length - 1);
    }

    private static int[] quickSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            for (int n : arr) {
                System.out.print(n+" ");
            }
            System.out.println();
            quickSortHelper(arr, left, partitionIndex - 1);
            quickSortHelper(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    //严蔚敏的标准分割函数
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];

        }
        nums[left] = pivot;
        return left;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        quickSort(nums);

    }

}
