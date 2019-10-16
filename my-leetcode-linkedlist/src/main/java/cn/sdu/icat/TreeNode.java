package cn.sdu.icat;

/**
 * 二叉树节点
 *
 * @author 张峰达
 * Created on 2019/9/26 0:43.
 */


//Definition for a binary tree node.

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    /**
     * 654 最大二叉树
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(0,nums.length-1,nums);
    }

    private TreeNode construct(int left, int right, int[] nums) {
        if(left>right){
            return null;
        }

        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = left; i <= right; i++){
            if(max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = construct(left, index-1, nums);
        node.right = construct(index+1, right, nums);
        return node;
    }

}
