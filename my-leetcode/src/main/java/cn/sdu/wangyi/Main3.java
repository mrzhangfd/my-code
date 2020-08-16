package cn.sdu.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 平分物品
 *
 * @author icatzfd
 * Created on 2020/8/8 15:13.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            int res = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            Arrays.sort(nums);
            //固定
            for (int k = nums.length - 1; k > 0; k--) {
                for (int right = k - 1; right > 0; right--) {
                    if (nums[right] == nums[k]) {
                        res = Math.min(res, sum(nums, 0, right - 1));
                    } else {
                        int left = right - 1;
                        while (sum(nums, left, right) < sum(nums, k, nums.length-1) ) {
                            if(left==0){
                                break;
                            }
                            left--;
                        }
                        if(sum(nums, left, right) == sum(nums, k, nums.length-1)){
                            res = Math.min(res, sum(nums, 0, left - 1));
                        }

                    }
                }
            }
            System.out.println(res);
        }
    }

    private static int sum(int[] nums, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += nums[i];
        }
        return res;
    }


}
