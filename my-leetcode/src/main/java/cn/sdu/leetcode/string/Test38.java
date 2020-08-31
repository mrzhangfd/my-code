package cn.sdu.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 外观数列
 *
 * @author icatzfd
 * Created on 2020/7/28 16:47.
 */
public class Test38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = countAndSay(n - 1);
        StringBuffer res = new StringBuffer();
        int len = pre.length();
        int idx = 0;
        for (int i = 1; i < len + 1; i++) {
            if (i == len) {
                return res.append(i - idx).append(pre.charAt(idx)).toString();
            } else if (pre.charAt(i) != pre.charAt(idx)) {
                res.append(i - idx).append(pre.charAt(i));
                idx = i;
            }
        }
        return res.toString();

    }

    public int numOf1Group(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return 0;
        }
        int rows = nums.length;
        int cols = nums[0].length;
        int res = 0;
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (nums[i][j] == 1 && visited[i][j] == 0) {
                    res++;
                    helper(nums, i, j, visited, rows, cols);
                }
            }
        }
        return res;
    }

    private void helper(int[][] nums, int i, int j, int[][] visited, int rows, int cols) {
        if (i >= rows || i < 0 || j >= cols || j < 0) {
            return;
        }
        if (visited[i][j] == 1) {
            return;
        }
        if (nums[i][j] == 0) {
            return;
        }
        visited[i][j] = 1;
        helper(nums, i + 1, j, visited, rows, cols);
        helper(nums, i - 1, j, visited, rows, cols);
        helper(nums, i, j + 1, visited, rows, cols);
        helper(nums, i, j - 1, visited, rows, cols);
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        System.out.println(a ^ b ^ c);
        System.out.println(a & b);
        System.out.println(a | b);
        int[][] num = new int[2][2];
        for (int[] n : num) {
            System.out.println(n[0]);
        }
    }
}
