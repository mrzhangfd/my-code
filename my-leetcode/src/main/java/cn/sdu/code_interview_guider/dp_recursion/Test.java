package cn.sdu.code_interview_guider.dp_recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 换钱的最少货币数
 *
 * @author icatzfd
 * Created on 2020/8/2 15:00.
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int aim = sc.nextInt();
        if (aim == 0 || n == 0) {
            System.out.println(0);
        } else {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            int res = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (aim >= nums[i]) {
                    res += aim / nums[i];
                    aim = aim % nums[i];
                }
            }
            if (aim != 0) {
                System.out.println(-1);
            } else {
                System.out.println(res);
            }
        }

    }
}
