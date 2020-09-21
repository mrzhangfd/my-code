package cn.sdu.leetcode.array;

/**
 * 多数元素
 *
 * @author icatzfd
 * Created on 2020/9/10 8:54.
 */
public class Test169 {

    public static int majorityElement(int[] nums) {
        int flag = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                flag = nums[i];
                sum++;
            } else {
                if (nums[i] != flag) {
                    sum--;
                } else {
                    sum++;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] nums={2,2,1,1,1,2,2,1,1};
        System.out.println(majorityElement(nums));
    }
}
