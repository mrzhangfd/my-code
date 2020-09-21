package cn.sdu.test.jiage;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/9/11 21:09.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[m][2];
        int[] res = new int[n + 1];
        boolean[] flag = new boolean[n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
            if (nums[i][1] == 1) {
                res[nums[i][0]]++;
                count++;
            } else {
                res[nums[i][0]]--;
                if (res[nums[i][0]] == 0) {
                    flag[nums[i][0]] = true;
                }
            }
        }
        if (allZero(res)) {
            for (int i = 1; i <= n; i++) {
                if (!flag[i]) {
                    System.out.println(i + " ");
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (res[i] == 0 && !flag[i]) {
                    System.out.println(i + " ");
                }
            }
        }
    }

    public static boolean allZero(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }

}

