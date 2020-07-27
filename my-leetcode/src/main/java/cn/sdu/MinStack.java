package cn.sdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 设计一个栈，可以实现查找最小元素的方法
 *
 * @author icatzfd
 * Created on 2019/12/16 21:59.
 */
public class MinStack {
    /**
     * 存数据的列表
     */
    private List<Integer> data = new ArrayList<Integer>();

    /**
     * 存最小值索引的列表
     */
    private List<Integer> mins = new ArrayList<Integer>();

    public void push(int num) throws Exception {
        if (data.isEmpty()) {
            mins.add(0);
        }
        if (num <= this.getMin()) {
            mins.add(data.size() - 1);
        } else {
            mins.add(data.indexOf(this.getMin()));
        }
        data.add(num);

    }

    public int pop() throws Exception {
        if (data.isEmpty()) {
            throw new Exception("栈为空，抛出异常");
        }
        int min = this.getMin();
        int popIndex = data.size() - 1;
        int minIndex = mins.get(mins.size() - 1);
        if (popIndex == minIndex) {
            mins.remove(mins.size() - 1);
        }
        return data.remove(data.size() - 1);

    }

    /**
     * 获取最小元素
     *
     * @return
     */
    public int getMin() throws Exception {
        if (data.isEmpty()) {
            throw new Exception("栈为空");
        }
        int minIndex = mins.get(mins.size() - 1);
        return data.get(minIndex);
    }

}

class Solution1 {

    /**
     * 存数据的栈
     */
    Stack<Integer> dataStack = new Stack();

    /**
     * 存最小值索引的栈
     */
    Stack<Integer> minStack = new Stack();

    public void push(int node) throws Exception {
        dataStack.push(node);
        if (dataStack.size() == 1) {
            minStack.push(node);
        }
        int min = min();
        if (min <= node) {
            minStack.push(min);
        } else {
            minStack.push(node);
        }

    }

    public void pop() throws Exception {
        if (dataStack.isEmpty() || minStack.isEmpty()) {
            throw new Exception("empty stack");

        }
        dataStack.pop();
        minStack.pop();

    }

    public int top() throws Exception {
        if (dataStack.isEmpty()) {
            throw new Exception("error1");
        }
        return dataStack.peek();
    }

    public int min() throws Exception {
        if (dataStack.isEmpty()) {
            throw new Exception("error");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        Solution1 solution1 = new Solution1();
        solution1.push(3);
        //System.out.println(solution1.dataStack.size());
        System.out.println(solution1.min());
        solution1.push(4);
        System.out.println(solution1.min());
        solution1.push(2);
        System.out.println(solution1.min());
        solution1.push(3);
        System.out.println(solution1.min());
        solution1.pop();
        System.out.println(solution1.min());
        solution1.pop();
        System.out.println(solution1.min());
        solution1.pop();
        System.out.println(solution1.min());
        solution1.push(0);
        System.out.println(solution1.min());


    }
}
