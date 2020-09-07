package cn.sdu.test.bytedance.four;


import java.util.Scanner;

/**
 * 第四场 第四题
 *
 * @author icatzfd
 * Created on 2020/9/6 10:14.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n * m];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if (m * n - n >= 0) {
            System.arraycopy(nums, 0, nums, n, m * n - n);
        }
        int a = 0;
        int b = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m * n; i++) {
            if (i == 0) {
                b = nums[i];
            } else {
                b = Math.max(a + nums[i], nums[i]);
            }
            a = b;
            max = Math.max(b, max);
        }
        System.out.println(max);
    }
}

