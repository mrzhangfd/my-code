package cn.sdu.leetcode.array;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author icatzfd
 * Created on 2020/8/10 15:56.
 */
public class Test34 {

    public static int[] searchRange(int[] nums, int target) {
        int[] rets = new int[2];
        int first = findLeft(nums, target);
        int last = findRight(nums, target);
        if (first <= last) {
            rets[0] = first;
            rets[1] = last;

        } else {
            rets[0] = -1;
            rets[1] = -1;
        }
        System.out.println(rets[0]);
        System.out.println(rets[1]);
        return rets;
    }

    public static int findLeft(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                h = mid;
            } else if (nums[mid] > target) {
                h = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
           /* if (l == nums.length || nums[l] != target) {
                return -1;
            }*/
        /* return nums[l] == target ? l : -1;*/
    }

    public static int findRight(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                l = mid;
            } else if (nums[mid] > target) {
                h = mid;
            } else if (nums[mid] < target) {
                l = mid;
            }
        }
        return nums[l] == target ? l : -1;
           /* if (l==0 || nums[l-1] != target) {
                return -1;
            } else {
                return l-1;
            }*/
    }

    public static void main(String[] args) {
        int[] nums = {1};
        searchRange(nums, 1);
    }

}
