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
    //距离为k的
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

    //反转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;


    }

    // 路径总和3
    public int pathSum(TreeNode root, int sum) {
        return 1;
    }

    // 617 合并二叉树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        t1.val = t1.val + t2.val;
        return t1;
    }

    //543  二叉树的直径
    public int resDiameter;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        getDepth(root);
        return resDiameter;
    }

    private int getDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        resDiameter=Math.max(resDiameter,left+right);
        return Math.max(left,right)+1;
    }

}
