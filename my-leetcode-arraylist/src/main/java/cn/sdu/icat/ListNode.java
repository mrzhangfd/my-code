package cn.sdu.icat;

/**
 * Definition for singly-linked list.
 *
 * @author 张峰达
 * Created on 2019/9/14 23:54.
 */

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode leftNode = new ListNode(-1);
        ListNode rightNode = new ListNode(-1);
        ListNode tNode = new ListNode(-1);
        tNode.next = head;

        leftNode=tNode;

        rightNode.next = head.next;

        tNode.next = rightNode.next;
        leftNode.next = rightNode.next.next;
        rightNode.next = head;
        rightNode.next.next = leftNode.next;
        rightNode.next = leftNode.next.next;

        return tNode;
    }
}


