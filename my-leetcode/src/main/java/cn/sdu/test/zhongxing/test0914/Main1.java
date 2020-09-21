package cn.sdu.test.zhongxing.test0914;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/9/14 10:41.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i != 0 && nums[i] > nums[i - 1]) {
                nums[i - 1] = nums[i];
                count++;
            }
        }
        long sum=0;
        for(int num:nums){
            sum+=num;
        }
        System.out.println(sum+" "+count);
    }
}
