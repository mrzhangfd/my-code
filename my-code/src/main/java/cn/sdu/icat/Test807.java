package cn.sdu.icat;


/**
 * 807题
 *
 * @author 张峰达
 * Created on 2019/9/25 23:33.
 */

public class Test807 {
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
                if (grid[i][j] > r[i]) {
                    r[i] = grid[i][j];
                }
            }
        }

        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] > c[j]) {
                    c[j] = grid[i][j];
                }
            }
        }
        int det = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] <= c[j] && grid[i][j] <= r[i]) {
                    if(c[j]>r[i]){
                        det=r[i]-grid[i][j]+det;
                    }
                    else {
                        det=c[j]-grid[i][j]+det;
                    }

                }
                else {
                    System.out.println(1);
                }
            }
        }

        return det;
    }

    public static void main(String[] args) {
        Test807 test=new Test807();
        int[][] grid = new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};

        int num=test.maxIncreaseKeepingSkyline(grid);
        System.out.println(num);
    }
}
