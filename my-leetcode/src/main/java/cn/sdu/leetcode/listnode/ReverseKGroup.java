package cn.sdu.leetcode.listnode;

import cn.sdu.ListNode;

/**
 * k个一组，反转链表
 *
 * @author icatzfd
 * Created on 2020/7/20 10:24.
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义一个假节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //初始化pre 和end 都指向dummy
        //pre指向每次反转的链表的头结点的前一个节点
        //end指向要反转的链表的尾结点
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end!= null; i++) {
                end = end.next;
            }
            //如果end==null，要反转的链表节点数小于k，不执行反转
            if(end==null){
                break;
            }

            //下一组的头结点
            ListNode next=end.next;

            //断开链表
            end.next=null;

            //要反转链表的头结点
            ListNode start=pre.next;

            //反转链表，pre.next指向反转后的链表头结点
            pre.next=reverse(start);

            //反转后，start指的是链表的尾结点。
            start.next=next;

            pre=start;
            end=start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode node) {
        //前一个节点
        ListNode pre = null;
        //当前节点
        ListNode cur = node;
        //下一个节点
        ListNode next;
        while (cur != null) {
            //保存当前节点的下一个节点
            next = cur.next;
            //进行反转
            cur.next = pre;
            //pre向后移动
            pre = cur;
            //cur向后移动
            cur = next;
        }
        return pre;
    }
}
