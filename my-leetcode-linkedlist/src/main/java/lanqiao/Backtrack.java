package lanqiao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author icatzfd
 * Created on 2020/5/31 16:36.
 */
public class Backtrack {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> res, ArrayList<Integer> temlist) {

        res.add(new ArrayList<>(temlist));

        for (int i = start; i < nums.length; i++) {
            temlist.add(nums[i]);
            backtrack(i + 1, nums, res, temlist);
            temlist.remove(temlist.size() - 1);
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

    public static void main(String[] args) {
        Backtrack backtrack = new Backtrack();

        int[] nums = {7, 2, 3, 6};
        //System.out.println(backtrack.combinationSum(nums, 7));
        System.out.println(backtrack.combinationSum3(3, 7));
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
}
