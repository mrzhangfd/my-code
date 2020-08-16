package cn.sdu.leetcode;

import cn.sdu.ListNode;

/**
 * 反转链表
 *
 * @author icatzfd
 * Created on 2020/8/7 18:28.
 */
public class Test206 {
    public ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            //next.next=cur;
            pre=cur;
            cur=next;

        }
        return pre;
    }
}
