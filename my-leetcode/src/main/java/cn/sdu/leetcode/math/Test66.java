package cn.sdu.leetcode.math;

/**
 * 加一
 *
 * @author icatzfd
 * Created on 2020/7/29 9:17.
 */
public class Test66 {

   /* public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i]=digits[i]%10;
            if(digits[i]!=0){
                return digits;
            }
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }*/

    public static int[] plusOne(int[] digits) {
        //两个相同数字异或=0，一个数和0异或还是它本身。
        //思路：分组。将两个单次元素分到两个组中。然后在两个组中找“其他元素出现两次，只有一个元素出现一次”即可。
        //分组依据：两个单次元素的二进制位肯定有一位不同，那么该位对应的异或结果必然为1。全体异或后，找到异或结果的为1的那一位，
        //异或结果为 ：110，则根据低2位 的值 为0的分为一组，低2位值为1的分为一组。
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        int[] a = new int[2];
        int t1 = 0, t2 = 0, n = digits.length, t = 0, s = 1;
        //思路：全体异或，结果就是两个单次元素的异或结果
        for (int num : digits) {
            t ^= num;
        }

        //因为异或规则: 不同为1，相同为0。
        //通过和s相与，可以获取两个单次元素的哪一个二进制位不同，
        //例如：3和5 ：二进制表示法分别为011 和101. 异或结果为110;
        //用初始值为1的s,s&110，可以获取110的右侧低位是否位1.若与的结果为0，说明异或结果中对应的该位为0，说明两个单次元素在该位相同。
        while ((t & s) == 0) {
            s = s << 1;
        }

        //此时s=010，低2位为1，分组依据就是低2位。
        for (int i = 0; i < n; i++) {
            if ((digits[i] & s) == 0) {
                t1 ^= digits[i];
            } else {
                t2 ^= digits[i];
            }
        }
        a[0] = t1;
        a[2] = t2;
        return a;
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9};
        int[] n = {1, 2, 3};
        int[] res = plusOne(nums);
        for (int i = 0; i < 4; i++) {
            System.out.println(res[i]);
        }
    }
}
