package cn.sdu.code_interview_guider.stack_queue;

import java.util.Stack;

/**
 * 最小栈
 *
 * @author icatzfd
 * Created on 2020/6/20 17:02.
 */
public class MinStack {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> idxStack = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dataStack=new Stack<>();
        idxStack=new Stack<>();
    }

    public void push(int x) {
        if(dataStack.isEmpty()){
            idxStack.push(x);
        }else {
            if (x <= idxStack.peek()) {
                idxStack.push(x);
            } else {
                idxStack.push(idxStack.peek());
            }
        }

        dataStack.push(x);

    }

    public void pop() {
        dataStack.pop();

        idxStack.pop();

    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return idxStack.peek();
    }
}
