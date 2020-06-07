package cn.sdu.icat;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 *
 * @author 张峰达
 * Created on 2019/9/14 23:54.
 */
public class ListNode {
    int val;
    ListNode next = null;


    ListNode(int x) {
        val = x;
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            int tmp = stack1.pop();
            stack2.push(tmp);
        }
        Integer res = stack2.pop();
        while (!stack2.isEmpty()) {
            int tmp = stack1.pop();
            stack1.push(tmp);
        }

        return res;
    }

    public boolean Find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int rowNum = array.length;
        int colNum = array[0].length;

        return true;
    }
}



