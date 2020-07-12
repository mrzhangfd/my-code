package cn.sdu.code_interview_guider.stack_queue;

import java.util.Stack;

/**
 * 仅用递归和栈逆序一个栈
 *
 * @author icatzfd
 * Created on 2020/6/20 18:31.
 */
public class ReverseStack {
    //获取栈底元素
    public int getandRemoveLast(Stack<Integer> stack) {
        int num = stack.pop();
        if (stack.isEmpty()) {
            return num;
        }
        return getandRemoveLast(stack);
    }

    public void reverse(Stack<Integer> stack){
        int num=getandRemoveLast(stack);
        if(stack.isEmpty()){
            stack.push(num);
            return;
        }

    }

    public static void main(String[] args) {
        ReverseStack reverseStack=new ReverseStack();

        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(reverseStack.getandRemoveLast(stack));
    }

}
