package cn.sdu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组类
 *
 * @author icatzfd
 * Created on 2020/9/10 9:28.
 */
public class Solution {

    //287 寻找重复数
    public static int findDuplicate(int[] nums) {

        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            while (nums[i] != i + 1) {
                if (nums[nums[i] - 1] == nums[i]) {

                    return nums[i];
                }
                swap(nums, i, nums[i] - 1);
            }
        }

        return 1;
    }

    private static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    //448 找到所有数组中消失的数字
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    // 238 除自身以外数组的乘积
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int k = 1;
        for (int i = 0; i < n; i++) {
            res[i] = k;
            k *= nums[i];// 此时数组存储的是除去当前元素左边的元素乘积
        }

        k = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= k;// k为该数右边的乘积。
            k *= nums[i]; // 此时数组等于左边的 * 该数右边的。
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(arr));
    }
}
