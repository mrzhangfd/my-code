package cn.sdu.jzoffer;


import cn.sdu.ListNode;
import cn.sdu.RandomListNode;
import cn.sdu.TreeNode;


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
     * 最小的k个数
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (input == null || input.length == 0) {
            return ret;
        }
        int len = input.length;
        if (k > len || k == 0) {
            return ret;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            //PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int value : input) {
            if (priorityQueue.size() == k) {
                if (value < priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(value);
                }
            } else {
                priorityQueue.offer(value);
            }
        }
        while (!priorityQueue.isEmpty()) {
            ret.add(priorityQueue.poll());
        }
        return ret;
    }

    //两个链表的第一个公共节点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode cur1 = pHead1;
        while (cur1 != null) {
            s1.push(cur1);
            cur1 = cur1.next;
        }
        ListNode cur2 = pHead2;
        while (cur2 != null) {
            s2.push(cur2);
            cur2 = cur2.next;
        }
        ListNode res = null;
        while (!s1.isEmpty() && !s2.isEmpty() && s1.peek().val == s2.peek().val) {
            s2.pop();
            res = s1.pop();
        }

        return res;
    }

    //表示数值的字符串
    public boolean isNumeric(char[] str) {
        boolean signal = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'E' || str[i] == 'e') {
                if (i == str.length - 1) {
                    //e后面跟数字，否则不通过
                    return false;
                }
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                if (signal && str[i - 1] != 'E' && str[i - 1] != 'e') {
                    return false;
                }

                //正负号第一次出现，若果不是出现在第一位，那么要判断一下是不是出现在e的后面
                if (!signal && i > 0 && str[i - 1] != 'E' && str[i - 1] != 'e') {
                    return false;
                }
                signal = true;
            } else if (str[i] == '.') {
                if (hasE) {
                    //如果存在e，且e后面为小数，则不行。
                    return false;
                }
                if (decimal) {
                    return false;
                }
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;

    }

    //正则表达式匹配
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }

        //pattern先到尾部，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }

        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) ||
                    (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, patternIndex);
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        if (((strIndex != str.length) && pattern[patternIndex] == str[strIndex]) ||
                (pattern[patternIndex] == '.' && strIndex != str.length)
        ) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }

        return false;
    }

    /**
     * 丑数
     * https://leetcode-cn.com/problems/chou-shu-lcof/comments/250364
     *
     * @param index
     * @return
     */
    // 一个十分巧妙的动态规划问题
    // 1.我们将前面求得的丑数记录下来，后面的丑数就是前面的丑数*2，*3，*5
    // 2.但是问题来了，我怎么确定已知前面k-1个丑数，我怎么确定第k个丑数呢
    // 3.采取用三个指针的方法，p2,p3,p5
    // 4.p2指向的数字下一次永远*2，p3指向的数字下一次永远*3，p5指向的数字永远*5
    // 5.我们从2*ugly[p2] 3*ugly[p3] 5*ugly[p5]选取最小的一个数字，作为第k个丑数
    // 6.如果第K个丑数==2*ugly[p2]，也就是说前面0-p2个丑数*2不可能产生比第K个丑数更大的丑数了，所以p2++
    // 7.p3,p5同理
    // 8.返回第n个丑数
    // 链接：https://leetcode-cn.com/problems/chou-shu-lcof/solution/dong-tai-gui-hua-java100miao-sha-nei-you-xiang-xi-/
    public int GetUglyNumber_Solution(int index) {
        if (index == 1) {
            return 1;
        }
        if (index == 0) {
            return 0;
        }
        int[] ugly = new int[index];
        ugly[0] = 1;

        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        int i = 0;
        for (int idx = 1; idx < index; idx++) {
            int tmp = Math.min(ugly[idx2] * 2, Math.min(ugly[idx3] * 3, ugly[idx5] * 5));
            if (tmp == ugly[idx2] * 2) {
                idx2++;
            }
            if (tmp == ugly[idx3] * 3) {
                idx3++;
            }
            if (tmp == ugly[idx5] * 5) {
                idx5++;
            }
            ugly[idx] = tmp;
        }
        return ugly[index - 1];


    }

    //整数中1出现的次数
    /*
    作者：jyd
    链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public int NumberOf1Between1AndN_Solution(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) {
                res += high * digit;
            } else if(cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }


    /**
     * 不用加减乘除做加法
     * 1、两数相加，不计算进位=两数的异或 此时得到n1
     * 2、计算进位：两数相与，再左移一位。得到的是进位值 此时得到n2
     * 3、将n1和n2重复1 和2 两步。直到进位值为0。此时得到1中的n1 变为最后结果。
     *
     * @return
     */
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            if (carry == 0) {
                return sum;
            }
            num1 = sum;
            num2 = carry;
        }
        return num1;

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


    //树的子结构
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

    //链表中环的入口结点
    //自己的解答，当节点的val 不全为正数时，此法无效
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
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


    //数组中的逆序对数
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count;
    }

    private int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[locCopy--] = array[j--];
            }
        }
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];

        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
        return (leftCount + rightCount + count) % 1000000007;
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
     * 作者：Monotone
     * 链接：https://www.nowcoder.com/questionTerminal/8a19cbe657394eeaac2f6ea9b0f6fcf6?f=discussion
     * 来源：牛客网
     * <p>
     * 递归思想，每次将左右两颗子树当成新的子树进行处理，中序的左右子树索引很好找，前序的开始结束索引通过计算中序中左右子树的大小来计算，
     * 然后递归求解，直到startPre>endPre||startIn>endIn说明子树整理完到。方法每次返回左子树活右子树的根节点
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        TreeNode root = reConstructBinTreeHelper(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    /**
     * @param pre
     * @param in
     * @param
     */
    TreeNode reConstructBinTreeHelper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                root.left = reConstructBinTreeHelper(pre, preStart + 1, i - inStart + preStart, in, inStart, i - 1);
                root.right = reConstructBinTreeHelper(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);

                break;
            }
        }
        return root;

    }


    /**
     * 算法本质：
     * DFS||BFS 寻找连通分量
     * <p>
     * 题目分析：
     * 机器人在一个矩阵上的m*n个格子上移动，可进入的格子的集合可抽象为以下点集：
     * { (row, col) | (i%10+i/10+j%10+j/10) <= threshold }。且路径节点可重复，无步数限制。
     * 问：机器人能到达多少个格子？
     * <p>
     * 题目抽象：
     * 倘若我们把矩阵的每一个“格子”抽象成一个“结点”，把“格子相邻”抽象为“结点连通”（结点之间存在无向边），
     * 把“无法进入的格子”抽象成“与所有普通结点都不连通（不存在无向边）的孤点”，则整个问题可以抽象为：
     * 从某个结点出发，寻找无向图的连通分量的节点个数。很显然，可以使用DFS或者BFS进行实现
     * <p>
     * 算法实现：
     * 这里选择DFS进行实现。
     * 设置两个辅助boolean矩阵：visited与isWall。前者是DFS中的典型辅助矩阵，记录每个节点是否已访问过。
     * 后者用来表示每个节点是否是不能进入的“孤点”。
     * 设置静态变量nodeCnt，用于在DFS的过程中记录访问过的结点数
     * DFS递归函数的出口条件设置为：
     * (outOfBoundary(rows, cols, row, col) || visited[row][col] || isWall[row][col] )
     * 即：“若超过边界（到矩阵之外）”或“访问过”或“是无法进入的结点” 则 return
     * 然后进行DFS。
     */
    //机器人运动范围
    public int res = 0;

    public int movingCount(int threshold, int rows, int cols) {
        int[][] arr = new int[rows][cols];
        findWay(arr, 0, 0, threshold);

        return res;
    }

    private void findWay(int[][] arr, int i, int j, int threshold) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
            return;
        }
        if (getSum(i) + getSum(j) > threshold) {
            arr[i][j] = 1;
            return;
        }
        if (arr[i][j] == 1) {
            return;
        }

        //标记为1，表示访问过。
        arr[i][j] = 1;

        res++;

        findWay(arr, i + 1, j, threshold);
        findWay(arr, i, j + 1, threshold);
        findWay(arr, i - 1, j, threshold);
        findWay(arr, i, j - 1, threshold);

    }


    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
//        if (num >= 10) {
//            sum += num % 10;
//            sum += getSum(num / 10);
//        } else {
//            sum += num;
//        }
//        return sum;
    }


    HashMap<Character, Integer> map = new HashMap();
    ArrayList<Character> list = new ArrayList<Character>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
        list.add(ch);
    }

    /**
     * 找到字符流中第一次出现的字符
     *
     * @return
     */
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char c = '#';
        for (char key : list) {
            if (map.get(key) == 1) {
                c = key;
                break;
            }
        }
        return c;
    }

    /**
     * 变态跳台阶
     * 个人认为用回溯
     *
     * @param target
     * @return
     */
    int sum = 0;

    public int JumpFloorII(int target) {
        if (target < 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }

    }

    /**
     * 平衡二叉树
     *
     * @param root
     * @return
     */
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        getDepth(root);
        return isBalanced;

    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return right > left ? right + 1 : left + 1;
    }


    public int cutRope(int target) {
        int max = 1;
        if (target <= 3 && target > 0) {
            return target - 1;
        }
        while (target > 4) {
            target -= 3;
            max *= 3;
        }
        return max * target;
    }


    //矩阵中的路径
    //回溯法的经典应用
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        if (matrix == null || str == null) {
            return false;
        }
        int[][] visited = new int[rows][cols];
        char[][] arr = buildMatrix(rows, cols, matrix);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == str[0]) {
                    if (hasPathHeler(arr, str, i, j, 0, visited)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private boolean hasPathHeler(char[][] arr, char[] str, int i, int j, int idx, int[][] visited) {

        //边界条件!!!! 注意不要漏掉
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != str[idx] || visited[i][j] == 0) {
            return false;
        }
        //最后一个字符匹配
        if (idx == str.length - 1) {
            return true;
        }
        //该格子被访问过
        if (visited[i][j] == 1) {
            return false;
        }
        visited[i][j] = 1;
        boolean res = hasPathHeler(arr, str, i + 1, j, idx + 1, visited) ||
                hasPathHeler(arr, str, i - 1, j, idx + 1, visited) ||
                hasPathHeler(arr, str, i, j + 1, idx + 1, visited) ||
                hasPathHeler(arr, str, i, j - 1, idx + 1, visited);

        visited[i][j] = 0;
        return res;

    }

    private char[][] buildMatrix(int rows, int cols, char[] matrix) {
        char[][] arr = new char[rows][cols];
        for (int i = 0, idx = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = matrix[idx++];
            }
        }
        return arr;
    }

    //数据流中的中位数
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
        //PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    //取出来，再存入对方堆，保证了大根堆中的最大元素始终小于或等于小根堆中的最小元素
    public void Insert(Integer num) {
        //count为偶数，num进大根堆
        if ((count & 1) == 0) {
            //num进大根堆
            maxHeap.offer(num);
            //从大根堆中取最大值，进小根堆.
            int max = maxHeap.poll();
            minHeap.offer(max);
        } else {
            //num进小根堆
            minHeap.offer(num);
            //从小根堆中取最小值，进大根堆
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;

    }

    public Double GetMedian() {
        if ((count & 1) != 0) {
            return new Double(minHeap.peek());
        } else {
            return new Double(minHeap.peek() + maxHeap.peek()) / 2;
        }
    }

    //将字符串转换为整数
    public int StrToInt(String str) {
        String ss = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        int result = 0;
        //是否负数
        boolean neg = false;

        int i = 0;
        int len = ss.length();

        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = ss.charAt(0);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    neg = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar == '+') {
                    neg = false;
                    limit = -Integer.MAX_VALUE;
                } else {
                    return 0;
                }
                if (len == 1) {
                    return 0;
                }
                i++;
            }
            multmin = limit / 10;
            while (i < len) {
                digit = ss.charAt(i++) - '0';
                if (digit < 0 || digit > 9) {
                    return 0;
                }

                //判断溢出
                if (result < multmin) {
                    return 0;
                }

                result *= 10;
                if (result < limit + digit) {
                    return 0;
                }
                result -= digit;
            }
        } else {
            return 0;
        }

        return neg ? result : -result;


    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/8ee967e43c2c4ec193b040ea7fbb10b8?answerType=1&f=discussion
     * 来源：牛客网
     * <p>
     * 如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，
     * 原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响。
     * 举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，
     * 而前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。
     * 这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。如1100&1011=1000.也就是说，
     * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    //按之字形顺序打印二叉树
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null) {
            return res;
        }
        queue.offer(pRoot);
        int level = 0;
        while (queue.size() > 0) {
            if ((level & 1) == 0) {
                level++;
                ArrayList<Integer> tmp = new ArrayList<>();
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    TreeNode node = queue.poll();
                    assert node != null;
                    tmp.add(node.val);
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                }
                res.add(tmp);
            } else {
                level++;
                ArrayList<Integer> tmp = new ArrayList<>();
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    TreeNode node = queue.poll();
                    assert node != null;
                    tmp.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                res.add(tmp);
            }

        }
        return res;
    }

    //二叉树的下一个节点
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            TreeLinkNode cur = pNode.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        while (pNode.next != null) {
            TreeLinkNode parent = pNode.next;
            if (parent.left == pNode) {
                return parent;
            }
            pNode = pNode.next;
        }
        return null;


    }

    public static void main(String[] args) {
        Offer66Class offer66Class = new Offer66Class();
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};
        int[] numbers = {0, 3, 2, 6, 4};
        int size = 3;
        String str = "googgle";
        char[] mat = {'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'};
        char[] arr = {'A', 'B', 'C', 'B'};
        System.out.println(offer66Class.GetUglyNumber_Solution(7));
        //System.out.println(offer66Class.hasPath(mat, 3, 4, arr));
        //System.out.println(offer66Class.isContinuous(numbers));
        // System.out.println(offer66Class.InversePairs(array));
        //System.out.println(offer66Class.movingCount(5, 10, 10));
        //System.out.println(offer66Class.getSum(35));

    }


    //第一个只出现一次的字符
    public int FirstNotRepeatingChar(String str) {


        int[] words = new int[58];
        for (int i = 0; i < str.length(); i++) {
            words[((int) str.charAt(i)) - 65] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (words[((int) str.charAt(i)) - 65] == 1) {
                return i;
            }
        }
        return -1;
    }

    //扑克牌顺子
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int numof0 = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numof0++;
            }
        }
        //需要填补的king的个数
        int numofKing = 0;
        for (int i = numof0; i < numbers.length - 1; i++) {
            if (i == 0) {
                continue;
            }
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }

            numofKing += numbers[i + 1] - numbers[i] - 1;

        }

        //之前的写法

//        for (int i = numof0; i < numbers.length; i++) {
//            if (i == 0) {
//                continue;
//            }

//            if ( numbers[i] == numbers[i - 1]) {
//                return false;
//            }

//           //问题点在于：如果numbers={0,3,2,6,4} 此时计算的是 0 和2 之间需要填补的数目。
        //实际情况是需要从2开始计算 。0是可以当做任意数。注意和上面正确代码做对比。
//            numofKing += numbers[i] - numbers[i-1] - 1;
//
//        }
        return numofKing <= numof0;
    }


    //链表中环的入口节点
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode low = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        low = pHead;
        while (fast != low) {
            low = low.next;
            fast = fast.next;
        }
        return low;
    }

    //对称的二叉树
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetricalHelper(pRoot.left, pRoot.right);
    }

    private boolean isSymmetricalHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val
                    && isSymmetricalHelper(left.left, right.right)
                    && isSymmetricalHelper(right.left, left.right);
        }
        return false;
    }


    //和为S的连续正数序列
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum <= 1) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int low = 1;
        int high = 2;
        while (low < high) {
            int cur = (high + low) * (high - low + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> tempList = new ArrayList<>();
                for (int j = low; j <= high; j++) {

                    tempList.add(j);
                }
                res.add(tempList);
                low++;
            } else if (cur > sum) {
                low++;
            } else {
                high++;
            }
        }
        return res;
    }

    //求1+2+3
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n > 0) && ((sum += Sum_Solution(--n)) > 0);
        return sum;
    }

    //把数组排成最小的数
    public String PrintMinNumber(int[] numbers) {
        int n;
        String s = "";
        ArrayList<Integer> list = new ArrayList<>();
        n = numbers.length;
        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        for (int num : list) {
            s += num;
        }
        return s;
    }

    //复杂链表的复制
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode currentNode = pHead;
        //复制每个节点，并将新节点插入对应节点后面。
        //如 A-B-C 变为A-A1-B-B1-C-C1
        while (currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            cloneNode.next = currentNode.next;
            currentNode.next = cloneNode;
            currentNode = nextNode;
        }
        //将当前节点的随机节点的下一个节点赋给新节点的随机节点
        currentNode = pHead;
        while (currentNode != null) {
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //拆分两个链表
        currentNode = pHead;
        RandomListNode resNode = pHead.next;
        while (currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return resNode;
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

