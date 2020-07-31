package cn.sdu.kdxf;

import java.util.Scanner;

/**
 * 科大讯飞第一题
 *
 * @author icatzfd
 * Created on 2020/7/31 14:04.
 */
public class Main1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        int[] numss = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
            numss[i] = nums[i];
        }
        int k = sc.nextInt();
        if (k <= 0) {
            System.out.println(-1);
        }
        int sum = nums[0] + nums[1] * 5 + nums[2] * 10 + nums[3] * 50 + nums[4] * 100;
        if (k > sum) {
            System.out.println(-1);
        }
        if (k == sum) {
            int res = 0;
            for (int num : nums) {
                res += num;
            }
            System.out.println(res);
        }

        int count = k;
        while (count >= 0) {
            if (count >= 100) {
                if (count / 100 <= nums[4]) {
                    count -= (count / 100) * 100;
                    nums[4] -= count / 100;
                } else {
                    count -= nums[4] * 100;
                    nums[4] = 0;
                }
            } else if (count >= 50) {
                if (count / 50 <= nums[3]) {
                    count -= (count / 50) * 50;
                    nums[3] -= count / 50;
                } else {
                    count -= nums[3] * 50;
                    nums[3] = 0;
                }
            } else if (count >= 10) {
                if (count / 10 <= nums[2]) {
                    count -= (count / 10) * 10;
                    nums[2] -= count / 10;
                } else {
                    count -= nums[2] * 10;
                    nums[2] = 0;
                }
            } else if (count >= 5) {
                if (count / 5 <= nums[1]) {
                    count -= (count / 5) * 5;
                    nums[1] -= count / 5;
                } else {
                    count -= nums[1] * 5;
                    nums[1] = 0;
                }
            } else if (count > 0) {
                if (count <= nums[0]) {
                    count = 0;
                    nums[0] -= count;
                } else {
                    System.out.println(-1);
                    break;
                }
            }
            if (count == 0) {
                int res = 0;
                for (int i = 0; i < 5; i++) {
                    res += numss[i] - nums[i];
                }
                System.out.println(res);
                break;
            }
        }
    }
}
