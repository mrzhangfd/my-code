package cn.sdu.bilibili;

import java.util.Stack;

/**
 * 括号匹配
 *
 * @author icatzfd
 * Created on 2020/8/13 19:35.
 */
public class Main2 {
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean IsValidExp(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                if (ch == '}' && temp != '{') {
                    return false;
                }
                if (ch == ']' && temp != '[') {
                    return false;
                }
                if (ch == ')' && temp != '(') {
                    return false;
                }
            }
        }
        return true;
    }
}
