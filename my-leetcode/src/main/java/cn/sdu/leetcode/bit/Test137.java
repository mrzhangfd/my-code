package cn.sdu.leetcode.bit;

/**
 * 只出现一次的数字2
 *
 * @author icatzfd
 * Created on 2020/7/29 9:45.
 */
public class Test137 {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int res = 0;
        //逐位考虑
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                //右移i位，再和1 相与，获取二进制最低位的数 为0 或者为1 。
                sum += (nums[j] >> i) & 1;
            }
            res |= (sum % 3) << i;
        }
        return res;
    }
}
