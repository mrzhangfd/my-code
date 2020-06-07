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

    /**
     * 二叉搜索树与双向链表
     * 思路：定义一个链表的尾节点，递归处理左右子树，最后返回链表的头节点
     * https://blog.csdn.net/baiye_xing/article/details/78428347
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        //lastNode 链表的尾结点
        TreeNode lastNode = converHelper(pRootOfTree, null);
        TreeNode pHead = lastNode;
        while (pHead != null && pHead.left != null) {
            pHead = pHead.left;
        }
        return pHead;
    }

    private TreeNode converHelper(TreeNode root, TreeNode lastNode) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        if (cur.left != null) {
            lastNode = converHelper(cur.left, lastNode);
        }
        cur.left = lastNode;
        if (lastNode != null) {
            lastNode.right = cur;
        }
        lastNode = cur;
        if (cur.right != null) {
            lastNode = converHelper(cur.right, lastNode);
        }
        return lastNode;
    }

    /**
     * 字符串的排列
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        backtrackStr(0, chars, res);
        Collections.sort(res);
        return res;
    }

    private void backtrackStr(int start, char[] chars, ArrayList<String> res) {
        if (start == chars.length - 1) {
            String ss = String.valueOf(chars);
            System.out.println(ss);
            if (!res.contains(ss)) {
                res.add(ss);
            }
            return;
        }
        for (int i = start; i < chars.length; i++) {
            swap(chars, start, i);
            backtrackStr(start + 1, chars, res);
            swap(chars, start, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }


    /**
     * 数组中出现次数超过一半的数字
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(array[i])) {
                hashMap.put(array[i], hashMap.get(array[i]) + 1);
            } else {
                hashMap.put(array[i], 1);
            }
            if (hashMap.get(array[i]) * 2 > array.length) {
                return array[i];
            }
        }
        return 0;

    }

    /**
     * 连续子数组的最大和
     * 使用动态规划
     * 链接：https://www.nowcoder.com/questionTerminal/459bd355da1549fa8a49e350bf3df484?f=discussion
     * 来源：牛客网
     * <p>
     * dp[i]表示以元素array[i]结尾的最大连续子数组和.
     * 以[-2,-3,4,-1,-2,1,5,-3]为例
     * 可以发现,
     * dp[0] = -2
     * dp[1] = -3
     * dp[2] = 4
     * dp[3] = 3
     * 以此类推,会发现
     * dp[i] = max{dp[i-1]+array[i],array[i]}.
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(array[i] + dp[i - 1], array[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;

    }


    /**
     * 重建二叉树
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        TreeNode root = reConstructBinTreeHelper(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return null;
    }

    /**
     * @param pre
     * @param in
     * @param
     */
    TreeNode reConstructBinTreeHelper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {

      return null;

    }


    public static void main(String[] args) {
        Offer66Class offer66Class = new Offer66Class();
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        System.out.println(offer66Class.Permutation("abc"));
    }

    private void fun(char[] ch, List<String> list, int i) {
        //这是递归的终止条件，就是i下标已经移到char数组的末尾的时候，考虑添加这一组字符串进入结果集中
        if (i == ch.length - 1) {
            //判断一下是否重复
            if (!list.contains(new String(ch))) {
                list.add(new String(ch));
                return;
            }
        } else {
            //这一段就是回溯法，这里以"abc"为例

            //递归的思想与栈的入栈和出栈是一样的,某一个状态遇到return结束了之后，会回到被调用的地方继续执行

            //1.第一次进到这里是ch=['a','b','c'],list=[],i=0，我称为 状态A ，即初始状态
            //那么j=0，swap(ch,0,0)，就是['a','b','c']，进入递归，自己调自己，只是i为1，交换(0,0)位置之后的状态我称为 状态B
            //i不等于2，来到这里，j=1，执行第一个swap(ch,1,1)，这个状态我称为 状态C1 ,再进入fun函数，此时标记为T1，i为2，那么这时就进入上一个if，将"abc"放进list中
            /////////////-------》此时结果集为["abc"]

            //2.执行完list.add之后，遇到return，回退到T1处，接下来执行第二个swap(ch,1,1)，状态C1又恢复为状态B
            //恢复完之后，继续执行for循环，此时j=2,那么swap(ch,1,2),得到"acb"，这个状态我称为C2,然后执行fun，此时标记为T2,发现i+1=2,所以也被添加进结果集，此时return回退到T2处往下执行
            /////////////-------》此时结果集为["abc","acb"]
            //然后执行第二个swap(ch,1,2)，状态C2回归状态B,然后状态B的for循环退出回到状态A

            //             a|b|c(状态A)
            //               |
            //               |swap(0,0)
            //               |
            //             a|b|c(状态B)
            //             /  \
            //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
            //           /      \
            //         a|b|c   a|c|b

            //3.回到状态A之后，继续for循环，j=1,即swap(ch,0,1)，即"bac",这个状态可以再次叫做状态A,下面的步骤同上
            /////////////-------》此时结果集为["abc","acb","bac","bca"]

            //             a|b|c(状态A)
            //               |
            //               |swap(0,1)
            //               |
            //             b|a|c(状态B)
            //             /  \
            //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
            //           /      \
            //         b|a|c   b|c|a

            //4.再继续for循环，j=2,即swap(ch,0,2)，即"cab",这个状态可以再次叫做状态A，下面的步骤同上
            /////////////-------》此时结果集为["abc","acb","bac","bca","cab","cba"]

            //             a|b|c(状态A)
            //               |
            //               |swap(0,2)
            //               |
            //             c|b|a(状态B)
            //             /  \
            //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
            //           /      \
            //         c|b|a   c|a|b

            //5.最后退出for循环，结束。

            for (int j = i; j < ch.length; j++) {
                swap(ch, i, j);
                fun(ch, list, i + 1);
                swap(ch, i, j);
            }
        }
    }
}

