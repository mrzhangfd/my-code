package cn.sdu.icat;

import java.text.DecimalFormat;
import java.util.*;

/**
 * 剑指offer66
 *
 * @author 张峰达
 * Created on 2020/3/13 17:18.
 */

public class Offer66Class {
    /**
     * 数组中的重复数字
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        if (numbers == null) {
            return false;
        }
        for (int i = 0; i < length; i++) {

            if (hashMap.get(numbers[i]) != null) {
                duplication[0] = numbers[i];
                return true;
            }
            hashMap.put(numbers[i], numbers[i]);

        }
        return false;
    }

    /**
     * 求1+2+3+...+n
     *
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int nums[] = new int[n + 1];
        return 1;
    }

    /**
     * 最小的k个数
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        int length = input.length;
        ArrayList<Integer> ret = new ArrayList<>();
        return ret;

    }

    /**
     * 丑数
     *
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index == 1) {
            return 1;
        }
        for (int i = 2; i < Integer.MAX_VALUE; i++) {

        }
        return 0;
    }


    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1) {
            return true;
        }
        int rootVal = sequence[last];
        int cutIndex = first;
        while (sequence[cutIndex] < rootVal && cutIndex < last) {
            cutIndex++;
        }
        for (int i = cutIndex; i < last; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);
    }

    //二叉树中和为某一值的路径

    public ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(path));
        } else {
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        path.remove(path.size() - 1);
    }

    //数组中只出现一次的数字
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        //num1,num2分别为长度为1的数组。传出参数
        //将num1[0],num2[0]设置为返回结果
        num1[0] = array[0];
        num2[0] = array[1];
        if (array.length == 2) {
            return;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            hashMap.computeIfAbsent(i, i1 -> array[i1]);
            if (array[i] == hashMap.get(i)) {

            }

        }

    }

    public void FindNums(int[] array, int num1[], int num2[]) {
        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for (int i = 0; i < array.length; ++i) {
            bitResult ^= array[i];
        }
        int index = findFirs1(bitResult);
        for (int i = 0; i < array.length; ++i) {
            if (ifBit1(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }

    }

    private boolean ifBit1(int target, int index) {
        return ((target >> index) & 1) == 1;
    }

    private int findFirs1(int bitResult) {
        int index = 0;
        while ((bitResult & 1) == 0 && index < 32) {
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) {
            return list2;
        }
        if (list2 == null && list1 != null) {
            return list1;
        }
        ListNode retList = new ListNode(-1);
        ListNode currentNode = retList;
        while (list1 != null && list2 != null) {
            if (list2.val >= list1.val) {
                currentNode.next = list1;
                list1 = list1.next;
                currentNode = currentNode.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
                currentNode = currentNode.next;
            }
        }
        if (list1 == null) {
            currentNode.next = list2;
        } else {
            currentNode.next = list1;
        }
        return retList.next;
    }


    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean res = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                res = doesTree1HaveTree2(root1, root2);
            }
            if (!res) {
                res = HasSubtree(root1.left, root2);
            }
            if (!res) {
                res = HasSubtree(root1.right, root2);
            }
        }
        return res;
    }

    private boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }

        return doesTree1HaveTree2(node1.left, node2.left) &&
                doesTree1HaveTree2(node1.right, node2.right);

    }

    public String ReverseSentence(String str) {

        if (str.trim().equals("")) {
            return str;
        } else {
            String[] strings = str.split(" ");
            return reverse(strings);
        }

    }

    private String reverse(String[] array) {
        String[] newArray = new String[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[array.length - i - 1];
        }
        String resString = "";
        for (String ss : newArray) {
            resString = resString + ss + " ";
        }
        if (resString.length() >= 1) {
            return resString.substring(0, resString.length() - 1);
        }
        return "";
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode currentNode = pHead;
        if (pHead == null || pHead.next == null) {
            return null;
        }
        while (currentNode.next != null) {
            if (currentNode.val < 0) {
                currentNode.val = -currentNode.val;
                return currentNode;
            }
            currentNode.val = -currentNode.val;
            currentNode = currentNode.next;
        }
        return null;
    }

    List<TreeNode> resList = new ArrayList<>();

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (k == 0) {
            return null;
        }
        List<TreeNode> resList = new ArrayList<>();
        getPreOrder(pRoot);
        if (k > resList.size()) {
            return null;
        }
        return resList.get(k);
    }

    private void getPreOrder(TreeNode pRoot) {
        if (pRoot != null) {
            getPreOrder(pRoot.left);
            resList.add(pRoot);
            getPreOrder(pRoot.right);
        }
    }

    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length - 1; i++) {
            B[i] = 1;
        }
        for (int i = 1; i <= A.length - 1; i++) {
            B[0] = A[i] * B[0];
        }
        for (int i = 1; i <= A.length - 1; i++) {
            for (int j = 0; j <= A.length - 1; j++) {
                if (j == i) {
                    continue;
                }
                B[i] = A[j] * B[i];
            }
        }
        return B;
    }

    //和为S的两个数字
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        int minNum = Integer.MAX_VALUE;
        int[] B = new int[2];
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                int temp = array[i] * array[j];
                if (temp < minNum) {
                    minNum = temp;
                    B[0] = array[i];
                    B[1] = array[j];
                }
            }
            if (array[i] + array[j] < sum) {
                i++;
            } else {
                j--;
            }
        }
        if (B[1] + B[2] != sum) {
            return new ArrayList<>();
        }
        Arrays.sort(B);
        ret.add(B[0]);
        ret.add(B[1]);
        return ret;

    }


    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int up = 0;
        int down = rowNum - 1;
        int right = colNum - 1;
        int left = 0;
        while (list.size() <= rowNum * colNum) {
            for (int col = left; col <= right; col++) {
                list.add(matrix[up][col]);
            }
            up++;
            if (up > down) {
                break;
            }
            for (int row = up; row <= down; row++) {
                list.add(matrix[row][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            for (int col = right; col >= left; col--) {
                list.add(matrix[down][col]);
            }
            down--;
            if (down < up) {
                break;
            }
            for (int row = down; row >= up; row--) {
                list.add(matrix[row][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return list;
    }

    public int GetNumberOfK(int[] array, int k) {
        int length = array.length;
        if (array.length == 0 || array[0] > k || array[length - 1] < k) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] != k) {
                continue;
            }
            num++;
            if (array[i] > k) {
                break;
            }
        }
        return num;

    }

    public int InversePairs(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length < size) {
            return list;
        }
        //队列头部存的是当前窗口的最大值的下标
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!linkedList.isEmpty() && num[linkedList.peekLast()] < num[i]) {
                linkedList.pollLast();
            }
            linkedList.add(i);
            if (linkedList.peekFirst() <= (i - size)) {
                linkedList.pollFirst();
            }
            if (i >= size - 1) {
                list.add(num[linkedList.peekFirst()]);
            }
        }
        return list;
    }

   /* public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //最少两个数
        //100 也就是49+51
        DecimalFormat df=new DecimalFormat("0.0");//设置保留位数
        int n = 2;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for (n = 2; n < sum / 2; n++) {
            String num=df.format((float) sum/n);
            if(n/2==0){
                if(num.substring(2,2)=="5"){
                    tmp.add()
                }
            }

        }
    }*/



    public static void main(String[] args) {
        Offer66Class offer66Class = new Offer66Class();
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        System.out.println(offer66Class.maxInWindows(num, size));
    }
}

