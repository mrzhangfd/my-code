package cn.sdu.leetcode.dp;

import java.util.Stack;

/**
 * 最长有效括号
 *
 * @author icatzfd
 * Created on 2020/8/5 10:03.
 */
public class Test32 {
    public static int longestValidParentheses(String s) {
        Stack<Character> left = new Stack<>();
        int len = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.push('(');
            } else {
                if (left.isEmpty()) {
                    len = 0;
                    continue;
                } else {
                    left.pop();
                    len += 2;
                    max=Math.max(len,max);
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(longestValidParentheses(s));
    }
}
