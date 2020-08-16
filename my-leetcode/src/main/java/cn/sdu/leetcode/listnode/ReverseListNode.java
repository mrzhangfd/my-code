package cn.sdu.leetcode.listnode;

import cn.sdu.ListNode;

import java.util.List;

/**
 * k个一组，反转链表
 *
 * @author icatzfd
 * Created on 2020/7/20 10:24.
 */
public class ReverseListNode {

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
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //如果end==null，要反转的链表节点数小于k，不执行反转
            if (end == null) {
                break;
            }

            //下一组的头结点
            ListNode next = end.next;

            //断开链表
            end.next = null;

            //要反转链表的头结点
            ListNode start = pre.next;

            //反转链表，pre.next指向反转后的链表头结点
            pre.next = reverse(start);

            //反转后，start指的是链表的尾结点。
            start.next = next;

            pre = start;
            end = start;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode node) {
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

    //92 反转链表2
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        //用pre保存截断链表的前一个
        ListNode pre = dummyHead;

        //用last保存截断链表的后一个
        ListNode last;

        ListNode cur = head;
        int count = 1;

        while (count < m) {
            pre = cur;
            cur = cur.next;
            count++;
        }
        System.out.println(cur.val);
        while (count < n) {
            cur = cur.next;
            count++;
        }
        //保存last
        last = cur.next;
        cur.next = null;
        cur = pre.next;
        //截断链表
        pre.next = null;
        pre.next = reverse(cur);
        cur.next = last;

        return dummyHead.next;


    }

    //默写反转链表函数
    public ListNode reverse1(ListNode node) {
        //记录链表头的前节点
        ListNode pre = null;

        //记录链表的下一个节点
        ListNode next;

        //记录当前节点
        ListNode cur = node;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }

        //此时 cur=null,而pre正是反转链表后的头结点。
        return pre;
    }

    //默写反转链表函数
    public ListNode reverse2(ListNode node) {
        ListNode pre = null;
        ListNode next = node.next;
        ListNode cur = node;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(2);
        for (int i = 2; i <= 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        //  System.out.println(head);
        ListNode res = reverseBetween(head, 2, 4);

        System.out.println(res);
    }
}
