package cn.sdu.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯相关
 *
 * @author icatzfd
 * Created on 2020/9/28 9:20.
 */
public class Solution {
    //46 全排列
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        permuteHelper(res, path, 0, nums);
        return res;
    }

    static private void permuteHelper(List<List<Integer>> res, List<Integer> path, int start, int[] nums) {
        if (path.size() == nums.length) {

            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            permuteHelper(res, path, 0, nums);
            path.remove(path.size() - 1);

        }
    }

    //79 单词搜索
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Arrays.fill(visited, false);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {

                }
            }
        }
        return false;

    }

    //47 全排列2
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        permuteHelper1(res, path, 0, nums);
        return res;
    }

    private static void permuteHelper1(List<List<Integer>> res, List<Integer> path, int start, int[] nums) {
        if (path.size() == nums.length) {
            if (!res.contains(new ArrayList<>(path))) {
                res.add(new ArrayList<>(path));
            }

            return;
        }
        for (int i = start; i < nums.length; i++) {

            path.add(nums[i]);
            permuteHelper1(res, path, 0, nums);
            path.remove(path.size() - 1);

        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }
}
