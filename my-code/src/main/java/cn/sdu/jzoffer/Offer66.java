package cn.sdu.jzoffer;

import cn.sdu.TreeNode;

import java.util.*;

/**
 * 二刷
 *
 * @author icatzfd
 * Created on 2020/6/27 10:51.
 */
public class Offer66 {

    Offer66 offer66 = new Offer66();

    //旋转数组的最小数，
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int l = 0;
        int h = array.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            //此处需要和array[h]相比
            //如果和array[l] 比较，若出现 1 ，2 ，3 ，4， 5 这种情况。则不行。
            if (array[mid] > array[h]) {
                l = mid + 1;
            } else if (array[mid] < array[h]) {
                h = mid;
            } else if (array[mid] == array[h]) {
                l++;
            }
        }
        return array[l];

    }

    //矩形覆盖
    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;


    }

    //二进制中1的个数
    //移位：有符号数移位时，按照补码的形式移位
    //右移：最右边的一位舍弃，最左边补符号位。
    //
    //左移：最左边的一位舍弃，最右边补0。

    //栈的压入、弹出序列
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //从上往下打印二叉树
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {


            TreeNode treeNode = queue.poll();
            res.add(treeNode.val);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }

        return res;
    }

    //二叉搜索树的后序遍历序列
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return helper(0, sequence.length - 1, sequence);
    }

    private boolean helper(int start, int end, int[] sequence) {
        if (end - start <= 1) {
            return true;
        }
        int rootVal = sequence[end];
        int curidx = start;
        while (sequence[curidx] < rootVal && curidx < end) {
            curidx++;
        }

        for (int i = curidx; i < end; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        return helper(start, curidx - 1, sequence) && helper(curidx, end - 1, sequence);
    }

    //二叉树中和为某一值的路径

    //二叉搜索树转为双向链表


    public ArrayList<Integer> GetLeastNumbers_Solution_queque(int[] input, int k) {
        return  null;
    }

    //最小的k个数 快排
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0) {
            return res;
        }
        quickSort(input, 0, input.length - 1);
        if (k > input.length) {
            return res;
        }
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int idx = partition(nums, left, right);
            quickSort(nums, left, idx - 1);
            quickSort(nums, idx + 1, right);
        }
    }

    //严蔚敏的标准分割函数
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];

        }
        nums[left] = pivot;
        return left;
    }

    private void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }


    public static void main(String[] args) {
        Offer66 offer66 = new Offer66();
//        int[] arr = {6501, 6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717, 9170, 9359, 9719, 9895, 9896, 9913, 9962, 154, 293, 334, 492,
//                1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392, 2996, 3282, 3812, 3903, 4465, 4605, 4665, 4772, 4828, 5142, 5437, 5448, 5668,
//                5706, 5725, 6300, 6335};
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        int[] seq = {5, 4, 3, 2, 1};
        int[] seq1 = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(offer66.VerifySquenceOfBST(seq));
        String ss = "234";

    }
}
