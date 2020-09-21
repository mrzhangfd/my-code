package cn.sdu.leetcode.treenode;

import cn.sdu.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树非递归遍历第二遍
 *
 * @author icatzfd
 * Created on 2020/9/20 14:01.
 */
public class Traversal2 {
    //94题  中序
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.pop();
            list.add(temp.val);
            cur=temp.right;
        }
        return list;

    }

    //先序
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            //先右 入栈，后左入栈
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return list;
    }

    //145 后序 可以利用先序的 先右后左，改为先左后右。
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            //先左 入栈，后右入栈
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }

        }

        //最后反转链表
        Collections.reverse(list);
        return list;
    }
}
