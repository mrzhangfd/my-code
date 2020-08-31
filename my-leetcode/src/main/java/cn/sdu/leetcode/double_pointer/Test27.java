package cn.sdu.leetcode.double_pointer;

/**
 * 移除元素
 *
 * @author icatzfd
 * Created on 2020/7/29 16:57.
 */
public class Test27 {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int i = 0;
        int j = len-1;
        while (i < j) {

            while (i < j && j >=0 && nums[j] == val) {
                j--;
            }
            while (i < j && nums[i] != val) {
                i++;
            }
            swap(nums, i, j );
        }

        if(j==0){
            if(nums[j]==val){
                return 0;
            }
        }
        return j + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(removeElement(nums, 1));
        for (int n : nums) {
            System.out.print(n);
        }
    }
}
