package cn.sdu.bytedance;

import java.util.Scanner;

/**
 * 二叉树的叶子数
 *
 * @author icatzfd
 * Created on 2020/8/16 10:08.
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] preInt = new int[n];
        int[] inInt = new int[n];
        for(int i=0;i<n;i++){
            preInt[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            inInt[i]=sc.nextInt();
        }

        TreeNode root = reConstructBinaryTree(preInt, inInt);
        //System.out.println(root);
        System.out.println(countLeaf(root));
    }

    public static int countLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeaf(root.left) + countLeaf(root.right);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode res = reConHelper(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return res;
    }

    public static TreeNode reConHelper(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode node = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                node.left = reConHelper(pre, startPre + 1, i - startIn + startPre, in, startIn, i - 1);
                node.right = reConHelper(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return node;
    }
}
