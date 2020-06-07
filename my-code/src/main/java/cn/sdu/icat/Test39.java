package cn.sdu.icat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39 组合总数
 *
 * @author icatzfd
 * Created on 2019/10/31 18:33.
 */
public class Test39 {
    /**
     * 回溯+剪枝，代码不会写。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        //System.out.println(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<Integer>());
        System.out.println(res);
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, int start, ArrayList<Integer> tmp_list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            tmp_list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], res, i, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] can = {2, 6, 3, 7};
        int target = 7;
        Test39 test39 = new Test39();
        test39.combinationSum(can, target);
    }
}
