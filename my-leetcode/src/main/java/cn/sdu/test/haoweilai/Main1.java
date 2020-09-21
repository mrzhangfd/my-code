package cn.sdu.test.haoweilai;

import cn.sdu.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历
 * 非递归
 *
 * @author icatzfd
 * Created on 2020/9/20 13:46.
 */
public class Main1 {
    /**
     * 二叉树的非递归前序遍历
     *
     * @param root TreeNode类 根节点
     * @return string字符串
     */
    public String notReCuPreOrder(TreeNode root) {
        // write code here

        if (root == null) {
            return "";
        }
        String res="";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp=stack.pop();
            res+=temp.val+",";
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }

        }
        return res.substring(0,res.length()-1);

    }


}
