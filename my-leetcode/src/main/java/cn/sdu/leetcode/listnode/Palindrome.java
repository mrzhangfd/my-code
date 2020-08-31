package cn.sdu.leetcode.listnode;

import cn.sdu.ListNode;

import java.util.Stack;

/**
 * 回文链表
 *
 * @author icatzfd
 * Created on 2020/8/20 19:21.
 */
public class Palindrome {
    //234
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }

        ListNode cur=head;
        Stack<ListNode> stack=new Stack<>();

        while (cur!=null){
            ListNode node=new ListNode(cur.val);
            stack.push(node);
            cur=cur.next;
        }
        while (!stack.isEmpty() ){
            if(stack.pop().val!=head.val){
                return false;
            }
            head=head.next;
        }
        return true;
    }
}
