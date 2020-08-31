package cn.sdu;

import java.util.*;

/**
 * 层次遍历
 *
 * @author icatzfd
 * Created on 2020/6/18 21:58.
 */
public class LevelTraversal {

    //jzoffer:z字形
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //存放奇数层节点
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);
        //存放偶数层节点
        Stack<TreeNode> s2 = new Stack<>();
        int layer = 1;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (layer % 2 == 0) {
                ArrayList<Integer> tmp = new ArrayList<>();

                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        tmp.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!tmp.isEmpty()) {
                    res.add(tmp);
                    layer++;
                }
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        tmp.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }

                if (!tmp.isEmpty()) {
                    res.add(tmp);
                    layer++;
                }
            }
        }

        return res;
    }

    // leetcode：从上到下打印二叉树 || 二叉树的层序遍历
    public int[] levelOrder3(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>() {
        };
        queue.addLast(root);
        if (root == null) {
            return new int[0];
        }
        queue.offer(root);
        while (queue.size() != 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                res.add(node.val);
            }

        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    // leetcode：从上到下打印二叉树2 || 二叉树的层序遍历
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (queue.size() != 0) {
            int len = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                tmp.add(node.val);
            }
            if (!tmp.isEmpty()) {
                res.add(tmp);
            }

        }

        return res;
    }

    //使用双栈
    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        Stack<TreeNode> s1 = new Stack<>();
//        Stack<TreeNode> s2 = new Stack<>();
//        if (root == null) {
//            return res;
//        }
//        s1.push(root);
//        int layer = 1;
//        while (!s1.isEmpty() || !s2.isEmpty()) {
//            if (layer % 2 == 1) {
//
//            }
//        }
//    }
        return null;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>() {{
            add(1);
        }};
        linkedList.addLast(3);
        System.out.println(linkedList);
    }
}
