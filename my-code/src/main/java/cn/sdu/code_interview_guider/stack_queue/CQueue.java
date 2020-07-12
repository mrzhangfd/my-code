package cn.sdu.code_interview_guider.stack_queue;

import com.sun.org.apache.xml.internal.security.Init;

import java.util.Stack;

/**
 * 两个栈实现队列
 *
 * @author icatzfd
 * Created on 2020/6/20 17:22.
 */
public class CQueue {
    Stack<Integer> s1, s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s1.isEmpty()) {
            return -1;
        }
        if (s2.isEmpty()) {
            while (s1.size() != 0) {
                int tmp = s1.pop();
                s2.push(tmp);
            }
        }
        int head = s2.pop();
        while (s2.size() != 0) {
            s1.push(s2.pop());
        }
        return head;

    }
}
