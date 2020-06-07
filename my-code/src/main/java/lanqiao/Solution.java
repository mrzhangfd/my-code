package lanqiao;

import java.io.IOException;


/**
 * @author icatzfd
 * Created on 2019/12/20 16:09.
 */
public class Solution {


    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
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
        return rets;
    }

    public int findLeft(int[] nums, int target) {
        int l = 0;
        int h = nums.length;
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
        if (l == nums.length || nums[l] != target) {
            return -1;
        }
        return nums[l] == target ? l : -1;
    }

    public int findRight(int[] nums, int target) {
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                h = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        if (l == 0 || nums[l - 1] != target) {
            return -1;
        } else {
            return l - 1;
        }
    }

    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] < nums[h]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

   /* public int firstBadVersion(int n) {
        int l=1;
        int h=n;
        while (l<h){
            int mid=l+(h-l)/2;
            if(isBadVersion(mid)){
                h=mid;
            }else {
                l=mid+1;
            }
        }

        return l-1;
    }*/

    public int StrToInt(String str) {

        if (str == null) {
            return 0;
        }
        int result = 0;
        boolean negative = false;//是否负数
        int i = 0, len = str.length();
        /**
         * limit 默认初始化为 负的 最大正整数 ，假如字符串表示的是正数
         * 那么result(在返回之前一直是负数形式)就必须和这个最大正数的负数来比较，
         * 判断是否溢出
         */
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = str.charAt(0);//首先看第一位
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;//在负号的情况下，判断溢出的值就变成了 整数的 最小负数了
                } else if (firstChar != '+')//第一位不是数字和-只能是+
                {
                    return 0;
                }
                if (len == 1) // Cannot have lone "+" or "-"
                {
                    return 0;
                }
                i++;
            }
            multmin = limit / 10;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = str.charAt(i++) - '0';//char转int
                if (digit < 0 || digit > 9)//0到9以外的数字
                {
                    return 0;
                }

                //判断溢出
                if (result < multmin) {
                    return 0;
                }
                result *= 10;
                if (result < limit + digit) {
                    return 0;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        //如果是正数就返回-result（result一直是负数）
        return negative ? result : -result;
    }



    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        //int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums = new int[]{3, 4, 5, 1, 2};
        int target = 7;
        char a = 'a';
        System.out.println(Integer.valueOf(9));
    }

}
