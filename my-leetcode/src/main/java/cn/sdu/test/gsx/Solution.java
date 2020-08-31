package cn.sdu.test.gsx;

import java.util.Stack;

/**
 * 跟谁学
 *
 * @author icatzfd
 * Created on 2020/8/7 20:09.
 */
class Node {
    int data;
    Node next;
}

public class Solution {
    public Node mergeTwoLists(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        Node head = new Node();
        Node cur = head;
        while (n1 != null && n2 != null) {
            if (n1.data <= n2.data) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        if (n1 != null) {
            cur.next = n1;
        }
        if (n2 != null) {
            cur.next = n2;
        }
        return head.next;
    }
}

class Solution1 {
    public String reverseParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        StringBuffer res = new StringBuffer();
        char[] chars = s.toCharArray();
        Stack<Integer> charStack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                charStack.push(i);
            } else if (chars[i] == ')') {
                reverse(chars, charStack.pop() + 1, i - 1);
            }
        }
        for(char c:chars){
            if(c!='(' && c!=')'){
                res.append(c);
            }
        }
        return res.toString();
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;
            start++;
            end--;
        }
    }
}
