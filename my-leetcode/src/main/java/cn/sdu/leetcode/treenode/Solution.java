package cn.sdu.leetcode.treenode;

import cn.sdu.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author icatzfd
 * Created on 2020/9/17 10:06.
 */
public class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        traversal(map, root);
        List<Integer> res = new ArrayList<>();
        findKDis(map, target, target, K, res);
        return res;
    }

    private void findKDis(Map<TreeNode, TreeNode> map, TreeNode cur, TreeNode target, int k, List<Integer> res) {
        if (cur == null) {
            return;
        }
        if (k == 0) {
            res.add(cur.val);
        }

        if (cur.left == target || cur.right == target) {
            return;
        }
        findKDis(map, cur.left, target, k - 1, res);
        findKDis(map, cur.right, target, k - 1, res);
        TreeNode par = map.get(cur);
        findKDis(map, par, target, k - 1, res);

    }

    private void traversal(Map<TreeNode, TreeNode> map, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }
        traversal(map, root.left);
        traversal(map, root.right);
    }


}
