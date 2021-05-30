package cn.sdu.test.wanmeishijie.test0924;

import java.util.Scanner;

/**
 * 搜索旋转数组
 *leetcode 33题
 * @author icatzfd
 * Created on 2020/9/24 19:30.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        int result = search(nums, target);

        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
        //todo 实现算法
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0, j = nums.length - 1;
        //while的条件是i<=j，
        //若当 i==j时，恰好nums[i]==target,需要继续循环。
        //若条件为i<j，则跳出while，输出-1
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //因为mid 是向下取整，nums[mid] 就有可能等于 nums[i]
            if (nums[mid] >= nums[i]) {
                if (target < nums[mid] && target >= nums[i]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (nums[mid] == target) {
                    return mid;
                }
                if (target > nums[mid] && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }
}
