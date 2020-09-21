package cn.sdu.test;

import cn.sdu.TreeNode;

import java.util.List;

/**
 * @author icatzfd
 * Created on 2020/9/14 15:56.
 */
public class main {
    public static void main(String[] args) {

    }

    public int sumNode(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int a = sumNode(node.left);
            int b = sumNode(node.right);
            return 1 + a + b;
        }
    }

}
