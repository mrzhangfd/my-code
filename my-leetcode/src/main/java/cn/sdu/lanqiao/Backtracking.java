package cn.sdu.lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author icatzfd
 * Created on 2020/5/31 16:36.
 * 回溯：排列、组合（39）、子集问题
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/
 */
public class Backtracking {
    public Backtracking() {
    }


    // 子集
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> res, ArrayList<Integer> tempList) {

        res.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(i + 1, nums, res, tempList);
            tempList.remove(tempList.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        //因为要考虑去重，所以先对数组排序。
        Arrays.sort(candidates);
        backtrack2(candidates, target, 0, res, tempList);
        return res;

    }

    private void backtrack2(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> tempList) {
        if (candidates == null) {
            return;
        }
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tempList.add(candidates[i]);
            backtrack2(candidates, target - candidates[i], i + 1, res, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        Arrays.sort(candidates);
        backtrack1(candidates, 0, target, res, tempList);
        return res;

    }

    private void backtrack1(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> tempList) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            //如果不new 一个ArrayList<>(tempList)，那么return 上层后，
            // tempList.remove() 会把已经加入到res中的解的最后一个元素移除。 （引用传递）
            res.add(new ArrayList<>(tempList));
            System.out.println(tempList);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i >= 1 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tempList.add(candidates[i]);
            backtrack1(candidates, i, target - candidates[i], res, tempList);
            tempList.remove(tempList.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();


        backtrack3(n, 1, n, k, res, tempList);
        return res;
    }

    private void backtrack3(int n, int start, int target, int resnum, List<List<Integer>> res, List<Integer> tempList) {

        if (target < 0) {
            return;
        }
        if (target == 0 && resnum == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        if (resnum < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > n) {
                break;
            }
            tempList.add(i);
            backtrack3(n, i + 1, target - i, resnum - 1, res, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    void test(ArrayList<Integer> res) {
        System.out.println(res);
    }

    /**
     * leetcode 46 全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        if (nums == null) {
            return null;
        }

        permuteHelper(nums, 0, res, tempList);
        return res;
    }

    private void permuteHelper(int[] nums, int start, List<List<Integer>> res, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // swap(start,i,nums);
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            permuteHelper(nums, 0, res, tempList);
            tempList.remove(tempList.size() - 1);
            // swap(start,i,nums);
        }
    }

    /**
     * 784 字母大小写全排列
     *
     * @param S
     * @return
     */
    public List<String> letterCasePermutation(String S) {
        List<String> ret = new ArrayList<>();
        letterCasePermutationHelper(S.toCharArray(), 0, ret);
        return ret;

    }

    private void letterCasePermutationHelper(char[] chars, int start, List<String> ret) {

        if (ret.contains(new String(chars))) {
            return;
        }
        if (start == chars.length) {
            ret.add(new String(chars));
            return;
        }
        for (int i = start; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                letterCasePermutationHelper(chars, i + 1, ret);
            } else {
                letterCasePermutationHelper(chars, i + 1, ret);
                if (chars[i] - 'a' < 0) {
                    chars[i] = (char) (chars[i] + 32);
                } else {
                    chars[i] = (char) (chars[i] - 32);
                }
                letterCasePermutationHelper(chars, i + 1, ret);

            }
        }
    }

    //77
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        combineHelper(1, n, k, res, tempList);
        return res;
    }

    private void combineHelper(int start, int n, int k, List<List<Integer>> res, List<Integer> tempList) {
        if (tempList.size() == k) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i <= n; i++) {
            tempList.add(i);
            combineHelper(i + 1, n, k, res, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    // 279 完全平方数
    public int numSquares(int n) {
        int ret = 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        numSquaresHelper(res, tempList, n, 1, n);
        System.out.println(res);
        return 0;
    }

    private void numSquaresHelper(List<List<Integer>> res, List<Integer> tempList, int target, int start, int n) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= n; i++) {

            int x = (int) Math.sqrt(i);
            System.out.println(x * x == i);
            if (i != x * x) {
                continue;
            } else {
                tempList.add(i);
                numSquaresHelper(res, tempList, n - i, i + 1, n);
                tempList.remove(tempList.size() - 1);
            }

        }
    }


    //90 子集2
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(res, 0, nums, tmp);
        return res;
    }

    private void subsetsWithDupHelper(List<List<Integer>> res, int start, int[] nums, List<Integer> tmp) {

        if (!res.contains(tmp)) {
            res.add(tmp);
        }
        if (start >= nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            subsetsWithDupHelper(res, i + 1, nums, tmp);
            tmp.remove(tmp.size() - 1);
        }

    }

    //三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length <= 2) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0, res, temp, 0);
        return res;
    }

    private void helper(int[] nums, int start, List<List<Integer>> res, List<Integer> temp, int target) {
        if (temp.size() == 3 && target == 0) {
            if (!res.contains(temp)) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if (start == nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            System.out.println(nums[i]);
            helper(nums, i + 1, res, temp, target - nums[i]);
            temp.remove(temp.size() - 1);
        }
    }


    //93 复原ip
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s, list, 0, 0, ans);
        return ans;
    }

    private void helper(String s, List<String> list, int cur, int num, List<String> ans) {
        if (list.size() > 4) {
            return;
        }
        if (num == 4 && cur == s.length()) {
            ans.add(String.join(".", list));
            return;
        }

        for (int i = cur; i < cur + 3 && i < s.length(); i++) {
            String ss = s.substring(cur, i + 1);
            if (legal(ss)) {
                list.add(ss);
                helper(s, list, i + 1, num + 1, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean legal(String s) {
        if (s.charAt(0) == '0' && s.length() != 1) {
            return false;
        }
        if (Integer.parseInt(s) <= 255 && Integer.parseInt(s) >= 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Backtracking backtrack = new Backtracking();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        char a = 'a';
        char A = 'A';
        char ss = 'A' + 32;
        String ip = "25525511135";
        System.out.println(backtrack.restoreIpAddresses(ip));
        // System.out.println(backtrack.threeSum(nums));
        //System.out.println(backtrack.letterCasePermutation("C"));

        //System.out.println(nums);
        //System.out.println(backtrack.combinationSum(nums, 7));
        //System.out.println(backtrack.combinationSum3(3, 7));
        //System.out.println(backtrack.permute(nums));
        //System.out.println(backtrack.subsets(nums));
    }


}

    /*public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && backtrack(i, j, 0, word, visited, board)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean backtrack(int i, int j, int idx, String word, boolean[][] visited, char[][] board) {
        if (idx == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0
                || board[i][j] != word.charAt(idx) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (backtrack(i + 1, j, idx + 1, word, visited, board)
                || backtrack(i - 1, j, idx + 1, word, visited, board)
                || backtrack(i, j + 1, idx + 1, word, visited, board)
                || backtrack(i, j - 1, idx + 1, word, visited, board)) {
            return true;
        }
        visited[i][j] = false; // 回溯
        return false;
    }*/

