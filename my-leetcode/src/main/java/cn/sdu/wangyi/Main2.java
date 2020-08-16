package cn.sdu.wangyi;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 排列
 *
 * @author icatzfd
 * Created on 2020/8/8 15:03.
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[m];
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
            hashSet.add(nums[i]);
        }
        int num = 1;
        int idx = 0;
        while (num <= n) {
            if (idx >= m) {
                System.out.print(num + " ");
                num++;
                continue;
            }
            if (nums[idx] < num) {
                System.out.print(nums[idx] + " ");
                idx++;
            } else if (hashSet.contains(num) && num != nums[idx]) {
                num++;
            } else if (hashSet.contains(num) && num == nums[idx]) {
                System.out.print(num + " ");
                idx++;
                num++;

            } else {
                System.out.print(num + " ");
                num++;
            }
        }
        while (idx < m) {
            System.out.print(nums[idx] + " ");
            idx++;
        }
    }
}
