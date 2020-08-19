package cn.sdu.test.gld;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 元素平衡
 *
 * @author icatzfd
 * Created on 2020/8/19 22:28.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int i = 0;
        int j = 3;
        while (i < j) {
            while (nums[i] < nums[j]) {
                nums[j] -= 2;
                nums[i] += 1;
            }
            i++;
            j--;

        }
        for (int k = 1; k < 4; k++) {
            if (nums[k] != nums[k - 1]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(nums[1]*4);
    }
}
