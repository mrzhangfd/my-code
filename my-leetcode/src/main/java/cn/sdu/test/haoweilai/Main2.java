package cn.sdu.test.haoweilai;

import cn.sdu.ListNode;

/**
 * 单链表逆序
 *
 * @author icatzfd
 * Created on 2020/9/20 13:46.
 */
public class Main2 {
    /**
     * 逆序
     *
     * @param head ListNode类 头结点
     * @return ListNode类
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next ;
        while (cur != null) {
            next=cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }
}
