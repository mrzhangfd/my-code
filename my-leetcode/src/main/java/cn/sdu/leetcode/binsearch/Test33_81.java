package cn.sdu.leetcode.binsearch;

/**
 * 33 搜索旋转排序数组
 * 81 搜索旋转排序数组2
 *
 * @author icatzfd
 * Created on 2020/8/2 17:04.
 */
public class Test33_81 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[i]) {
                if (target < nums[mid] && target >= nums[i]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;

    }

    public boolean search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[j]) {
                if (target > nums[mid] && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else if (nums[mid] > nums[j]) {
                if (target < nums[mid] && target>=nums[i]) {

                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                j--;
            }
        }
        return false;
    }
}
