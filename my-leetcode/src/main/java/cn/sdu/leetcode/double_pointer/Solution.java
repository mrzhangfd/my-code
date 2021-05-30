package cn.sdu.leetcode.double_pointer;

import cn.sdu.ListNode;

/**
 * @author icatzfd
 * Created on 2020/9/25 9:55.
 */
public class Solution {
    // 142 环形链表2
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
