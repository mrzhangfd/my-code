package cn.sdu.leetcode.treenode;

import cn.sdu.TreeNode;
import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * 二叉树的遍历
 *
 * @author icatzfd
 * Created on 2020/7/21 9:30.
 */
public class Traversal {
    //先序,迭代版
    /*public List<Integer> preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            list.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return list;
    }*/


/*    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }*/

    //先序,迭代版
    public List<Integer> preOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }

    //中序 迭代版
    /*public List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }*/

    public List<Integer> inOrder(TreeNode root) {
        Set<Integer> set=new HashSet<>();
        Iterator<Integer> integerIterator=set.iterator();
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    //后序 迭代版  根据根右左遍历，然后反转链表
   /* public List<Integer> nextOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }*/

/*    //后序 迭代版
    public List<Integer> postOrder(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        TreeNode cur=root;
        //记录前一节点
        TreeNode pre=null;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.peek();
            if(cur.right==null ||cur.right==pre){
                list.add(cur.val);
                stack.pop();
                pre=cur;
                cur=null;
            }else {
                cur=cur.right;
            }
        }
        return  list;
    }*/

    //采用根右左的遍历，然后将结果反转的后序遍历
    public  List<Integer> postOrder1(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        TreeNode cur=root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                list.add(cur.val);
                stack.push(cur);
                cur=cur.right;
            }
            cur=stack.pop();
            cur=cur.left;
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        String s="567";
        List<String> list=new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("zxc");
        String.join(".",list);


        System.out.println(s.substring(0,0));
        int t=Integer.parseInt(s);
        int ss= Integer.valueOf(s);
        System.out.println(t);
        System.out.println(ss);
    }
}
