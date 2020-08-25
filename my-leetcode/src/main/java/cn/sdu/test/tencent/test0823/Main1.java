package cn.sdu.test.tencent.test0823;

import java.util.Scanner;

/**
 * 8.23 日 笔试
 * 删除节点
 *
 * @author icatzfd
 * Created on 2020/8/23 19:56.
 */
class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        ListNode pre=dummyHead;
        int count = 0;

       /* for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
        }*/
        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(scanner.nextInt());
            cur=node;
            count++;
            if(count==k){
                continue;
            }
            cur.next = node;
            cur = cur.next;
        }

        cur = dummyHead.next;

        if (k == 1) {
            dummyHead.next = cur.next;
            cur.next = null;
            printListNode(dummyHead.next);
            return;
        }
        while (count != k) {
            pre=cur;
            cur=cur.next;
            count++;
        }
        pre.next=cur.next;
        cur.next=null;
        printListNode(dummyHead.next);

    }

    private static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node=node.next;
        }
    }
}
