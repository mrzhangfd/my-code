package cn.sdu.leetcode;

import cn.sdu.ListNode;
import cn.sdu.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/6/28 15:54.
 */
public class Test33 {

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return maxDepthHelper(node);
    }

    private int maxDepthHelper(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 1;
        }
        return Math.max(maxDepthHelper(node.right) + 1, maxDepthHelper(node.left) + 1);
    }


    //两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {

        return swapPairsHelper(head);
    }

    private ListNode swapPairsHelper(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode tmp = node.next;
        node.next = swapPairsHelper(tmp.next);
        tmp.next = node;
        return tmp;
    }

    //110 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        TreeNode cur = root;
        return true;
    }


    //会议安排，计算最大时长
    public static int cal(HashMap<Integer, String> endToBegin) {
        int maxTime = Integer.MIN_VALUE;
        int[] dpMaxTime = new int[24];
        for (int i = 8; i < 24; i++) {
            if (endToBegin.containsKey(i)) {
                String beginTimes = endToBegin.get(i);
                String[] begins = beginTimes.split("-");
                for (String begin : begins) {
                    //dpMaxTime[i] = Math.max(Math.max(dpMaxTime[i-1],dpMaxTime[i]), dpMaxTime[Integer.parseInt(begin)] + i - Integer.parseInt(begin));
                    dpMaxTime[i] = Math.max(dpMaxTime[i], dpMaxTime[Integer.parseInt(begin)] + i - Integer.parseInt(begin));
                    if (dpMaxTime[i] > maxTime) {
                        maxTime = dpMaxTime[i];
                    }
                }
            } else {
                dpMaxTime[i] = dpMaxTime[i - 1];
            }
        }
        return maxTime;


    }

    //快速指数幂
    public double Power(double base, int n) {
        double res = 1, curr = base;
        int exponent;
        if (n > 0) {
            exponent = n;
        } else if (n < 0) {
            if (base == 0) {
                throw new RuntimeException("分母不能为0");
            }
            exponent = -n;
        } else {// n==0
            return 1;// 0的0次方
        }
        while (exponent != 0) {
            //看最后一位是不是1
            if ((exponent & 1) == 1) {
                res *= curr;
            }
            curr *= curr;// 翻倍
            exponent >>= 1;// 右移一位
        }
        return n >= 0 ? res : (1 / res);
    }

    //逆时针打印矩阵
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;

        }
        //定义四个边界。上下左右
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int m = matrix.length ;
        int n = matrix[0].length ;
        while (res.size() <= m * n) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[up][j]);
            }
            up++;
            if (up > down) {
                break;
            }

            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }

            for (int j= right; j >= left; j--) {
                res.add(matrix[down][j]);
            }
            down--;
            if (down < up) {
                break;
            }
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }

            left++;
            if(left>right){
                break;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int n = 13;
        int base = 10;
        Test33 test33 = new Test33();
        //System.out.println(System.currentTimeMillis());
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Scanner sc=new Scanner(System.in);
        int[] num=new int[5];
        int i=0;
        int a=sc.nextInt();
        while (sc.hasNext()){
            num[i]=sc.nextInt();
            i++;
            if(i==5){
                break;
            }
        }
        System.out.println(a);
        for(int tt:num){
            System.out.println(tt);
        }
    }


}


