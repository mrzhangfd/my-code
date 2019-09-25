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
        /**
         * 非递归
         */
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode p = dummyNode;

        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }

        return dummyNode.next;
        /*递归做法
        //http://lylblog.cn/blog/4
        //终止条件，只有一个或者没有的时候
        if (head != null && head.next != null) {
            //在本层中需要做的是交换head，和tHead。有三个结点 head，tHead，swapPairs（tHead.next）
            ListNode tHead = head.next;
            head.next=swapPairs(tHead.next);
            tHead.next=head;
            //给上一层的返回值是已经处理好的结点，即tHead。
            return tHead;
        }
        return head;*/
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        //每行最大值
        int[] r = new int[50];
        for (int i = 0; i < 50; i++) {
            r[i] = 0;
        }
        //每列最大值
        int[] c = new int[50];
        for (int i = 0; i < 50; i++) {
            c[i] = 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > c[i]) {
                    r[i] = grid[i][j];
                }
            }
        }
        return 1;
    }
}


