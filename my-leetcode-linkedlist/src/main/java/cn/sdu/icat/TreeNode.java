package cn.sdu.icat;

import java.util.*;

/**
 * 二叉树节点
 *
 * @author 张峰达
 * Created on 2019/9/26 0:43.
 */


//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int x) {
        val = x;
    }

    /**
     * 113 路径总和 II
     *
     * @param root
     * @param sum
     * @return 从根节点到叶子节点，路径上的值总和为sum的节点 列表
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        path.add(root.val);

        return ans;
    }

    public boolean preOrderHelper(TreeNode root, int sum, List<Integer> path) {
        if (root == null) {
            return false;
        }
        path.add(root.val);
        sum = sum - root.val;
        if (root.left == null && root.right == null && sum == 0) {
            if (sum != 0) {
                path.remove(root.val);
            }
            return sum == 0;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    /**
     * 112 路径总和
     *
     * @param root 根节点
     * @param sum  目标总和
     * @return 是否存在从根节点到叶子节点的路径，各节点的value总和为sum
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum = sum - root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }


    /**
     * 654 最大二叉树
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(0, nums.length - 1, nums);
    }

    private TreeNode construct(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = construct(left, index - 1, nums);
        node.right = construct(index + 1, right, nums);
        return node;
    }


    /**
     * 102 二叉树的层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> oneLayer = new LinkedList<>();
        if (root == null) {
            return res;
        }
        oneLayer.add(root);
        while (oneLayer.size() != 0) {
            int count = oneLayer.size();
            List<Integer> list = new ArrayList<>();

            while (count > 0) {
                TreeNode tmp = oneLayer.poll();
                if (tmp.left != null) {
                    oneLayer.add(tmp.left);
                }
                if (tmp.right != null) {
                    oneLayer.add(tmp.right);
                }
                list.add(tmp.val);
                count--;
            }
            res.add(list);
        }

        return res;
    }

    /**
     * 144 二叉树的前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        preOrderHelper(root, res);
        return res;
    }

    private void preOrderHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrderHelper(root.left, res);
        preOrderHelper(root.right, res);
    }

    /**
     * 144 二叉树的前序遍历 （基于栈）
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalByStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            stack.push(root.left);
        }
        return res;
    }



    /**
     * 145 二叉树的后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        postorderHelper(root, res);
        return res;
    }

    private void postorderHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorderHelper(root.left, res);
        postorderHelper(root.right, res);
        res.add(root.val);
    }

    /**
     * 94 二叉树的中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        inorderHelper(root, res);
        return res;
    }

    private void inorderHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderHelper(root.left, res);
        res.add(root.val);
        inorderHelper(root.right, res);

    }

}
