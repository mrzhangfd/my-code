package cn.sdu;

import java.util.*;

/**
 * 二分查找
 *
 * @author 张峰达
 * Created on 2020/5/18 17:19.
 */

public class BinarySearch {

    /**
     * 在一个有重复元素的数组中查找 key 的最左位置的实现如下：
     *
     * @param nums
     * @param key
     * @return
     */
    public int binarySearch(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int m = (high - low) / 2 + low;
            if (nums[m] >= key) {
                high = m;
            } else {
                low = m + 1;
            }
        }
        return low;
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1;
        int h = x;
        while (l <= h) {
            int mid = (h - l) / 2 + l;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid < sqrt) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return h;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }
        int l = 0;
        int h = letters.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (letters[mid] <= target) {
               l=mid+1;
            }else {
                h = mid - 1;
            }
        }
        return letters[l];
    }



    public int findMin(int[] nums) {
        int l=0;
        int h=nums.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if(nums[h]<nums[mid]){
                l=mid+1;
            }else {
                h=mid-1;
            }
        }
        return nums[l];
    }



    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        System.out.println(list.getClass().getName());
        System.out.println(list.get(1));
        list = new LinkedList<>();
        System.out.println(list.getClass().getName());
        System.out.println(list);


    }

}
