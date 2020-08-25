package cn.sdu;

import java.io.IOException;
import java.util.*;

/**
 * 剑指offer
 *
 * @author icatzfd
 * Created on 2019/12/13 21:35.
 */


public class Solution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 从后往前输出列表
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack stack = new Stack();
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return new ArrayList<>();
        }
        while (listNode.next != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        if (listNode != null && listNode.next == null) {
            stack.push(listNode.val);
        }

        while (!stack.isEmpty()) {
            res.add(Integer.parseInt(stack.pop().toString()));
        }

        return res;
    }


    /**
     * 旋转数组的最小数字
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }


    /**
     * 用两个栈实现队列
     *
     * @param node
     */
    public void push(int node) {
        if (stack2.isEmpty()) {
            stack1.push(node);
        } else {
            while (!stack2.isEmpty()) {
                int tmp = stack2.pop();
                stack1.push(tmp);
            }
        }
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            int tmp = stack1.pop();
            stack2.push(tmp);
        }
        int res = stack2.pop();
        while (!stack2.isEmpty()) {
            int tmp = stack2.pop();
            stack1.push(tmp);
        }
        return res;
    }

    /**
     * 替换空格
     *
     * @param str We Are Happy
     * @return We%20Are%20Happy
     */
    public String replaceSpace(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        int tmp = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {

                str.replace(i + 2 * tmp, i + 2 * tmp + 1, "%20");
                tmp++;
            }
        }

        return str.toString();
    }


    /**
     * 二叉树的镜像
     *
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode treeNode = root.left;
        root.left = root.right;
        root.right = treeNode;
        Mirror(root.left);
        Mirror(root.right);
    }


    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        if (head == null) {
            return null;
        }
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 链表中倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (k != 1) {
            fast = fast.next;
            k--;
        }
        if (fast == null) {
            return null;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /**
     * 调整数组顺序使奇数位于偶数前面
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        int length = array.length;
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (array[i] % 2 == 0) {
                evenList.add(array[i]);
            } else {
                oddList.add(array[i]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (i <= oddList.size() - 1) {
                array[i] = oddList.get(i);
            } else {
                array[i] = evenList.get(i - oddList.size());
            }
        }
    }


    /**
     * 剪绳子
     *
     * @param target
     * @return
     */
    public int cutRope(int target) {
        return 1;
    }


    /**
     * 从上往下打印二叉树
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.remove(0);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            res.add(temp.val);
        }


        return res;
    }


    /**
     * 二叉树的层次遍历
     * 使用ArrayList 模拟队列
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode temp = queue.remove(0);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                count--;
                list.add(temp.val);
            }
            res.add(list);

        }
        return res;
    }

    /**
     * 层次遍历
     * 使用Queue
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        while (queue.size() != 0) {
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            while (count > 0) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                list.add(tmp.val);
                count--;
            }
            stack.push(list);

        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }


    /**
     * 第一次只出现一次的字符
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {

        return 0;
    }


    /**
     * 斐波那契数列
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }


    /**
     * 矩形覆盖
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        } else {
            int res = 2 * RectCover(target - 1) - 1;
            String s = "123";

            return res;
        }

    }

    /**
     * 数值的整数次方
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) throws Exception {
        if (base == 0 && exponent == 0) {
            throw new Exception("error");
        }
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }

        return Math.pow(base, exponent);
    }

    /**
     * 树的子结构
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return false;
        }
        return true;
    }

    /**
     * 栈的压入、弹出序列
     * <p>
     * 题目描述
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
     * （注意：这两个序列的长度是相等的）
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        Stack<Integer> help = new Stack<>();
        for (int i = 0, j = 0; i < pushA.length; i++) {
            help.push(pushA[i]);
            while (help.peek() == popA[j]) {
                help.pop();
                if (help.isEmpty()) {
                    return true;
                }
                j++;
            }
        }
        return help.isEmpty();
    }

    /**
     * 左旋转字符串
     * Queue使用时要尽量避免Collection的add()和remove()方法，add()和remove()方法在失败的时候会抛出异常。
     * <p>
     * 要使用offer()来加入元素，使用poll()来获取并移出元素。
     * <p>
     * 它们的优点是通过返回值可以判断成功与否， 如果要使用前端而不移出该元素，使用element()或者peek()方法。
     *
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str, int n) {
        if (str.length() == 0) {
            return "";
        }
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            queue.add(str.charAt(i));
        }
        while (n > 0) {
            char tmp = queue.poll();
            queue.offer(tmp);
            n--;
        }
        String ss = "";
        while (!queue.isEmpty()) {
            ss = ss + queue.poll();
        }
        return ss;

    }


    /**
     * 把二叉树打印成多行
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            int length = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (length > 0) {
                TreeNode tmpTreeNode = queue.poll();

                if (tmpTreeNode.left != null) {
                    queue.offer(tmpTreeNode.left);
                }
                if (tmpTreeNode.right != null) {
                    queue.offer(tmpTreeNode.right);
                }
                arrayList.add(tmpTreeNode.val);
                length--;
            }
            res.add(arrayList);

        }
        return res;
    }


    /**
     * 求1+2+3+...+n
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {

        int tmp = 0;

        return 1;

    }

    /**
     * 删除链表中重复的结点
     * 题目描述
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode preNode = new ListNode(-1);
        if (pHead == null) {
            return preNode;
        }
        preNode.next = pHead;
        ListNode nextNode = preNode.next;
        ListNode curNode = preNode;
        while (nextNode != null) {
            if (nextNode.next != null && nextNode.next.val == nextNode.val) {
                while (nextNode.next != null && nextNode.val == nextNode.next.val) {
                    nextNode = nextNode.next;
                }
                curNode.next = nextNode.next;
                nextNode = nextNode.next;
            } else {
                curNode = curNode.next;
                nextNode = nextNode.next;
            }
        }
        return preNode.next;
    }


    /**
     * 孩子们的游戏(圆圈中最后剩下的数)
     * 题目描述
     * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
     * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
     * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
     * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
     * <p>
     * 如果没有小朋友，请返回-1
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (m - 1 + index) % list.size();
            list.remove(index);
        }
        return list.size() == 1 ? list.get(0) : -1;

    }


    /**
     * 二维数组中的查找
     * 题目描述
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p>
     * /* 思路
     * * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
     * * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
     * * 要查找数字比左下角数字小时，上移
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int colNum = array[0].length;
        int rowNum = array.length;
        for (int i = rowNum - 1, j = 0; i >= 0 && j <= colNum - 1; ) {
            if (target == array[i][j]) {
                return true;
            }
            if (target > array[i][j]) {
                j++;
                continue;

            }
            if (target < array[i][j]) {
                i--;
            }
        }
        return false;
    }


    /**
     * 合并两个排序的链表
     * 题目描述
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     *
     * @param list1
     * @param list2
     * @return
     */

    /**
     * 反转单词顺序列
     *
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {

        String[] strings = str.split(" ");
        int length = strings.length;
        if (length == 0) {
            return "";
        }

        int i = 0;
        int j = length - 1;
        while (i <= j) {
            String tmp = strings[i];
            strings[i] = strings[j];
            strings[j] = tmp;
            i++;
            j--;
        }
        String res = "";
        for (String ss : strings) {
            res = res + ss + " ";
        }
        System.out.println(res);
        return res;
    }


    /**
     * 滑动窗口的最大值
     * 题目描述
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
     * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
     * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        if (num == null) {
            return res;
        }
        int length = num.length;
        if (size >= length) {
            int resNum = Arrays.stream(num).max().getAsInt();
            res.add(resNum);
            return res;
        }
        int low = 0;
        int high = size - 1;

        while (high < length) {
        }

        return res;

    }

    /**
     * 从尾到头打印链表
     * 递归法
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        printListFromTailToHead_1_Helper(listNode, res);
        return res;
    }

    public void printListFromTailToHead_1_Helper(ListNode listNode, ArrayList<Integer> res) {
        if (listNode == null) {
            return;
        }
        if (listNode.next != null) {
            printListFromTailToHead_1_Helper(listNode.next, res);
            res.add(listNode.val);
        } else {
            res.add(listNode.val);
        }
    }

    /**
     * 按之字形顺序打印二叉树
     * 题目描述
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        return res;

    }


    /**
     * 二叉搜索树的第k个结点
     * <p>
     * 题目描述
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode resNode = new TreeNode(-1);

        if (pRoot == null) {
            return resNode;
        }

        return resNode;
    }


    /**
     * 重建二叉树
     * 题目描述
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode res=new TreeNode(-1);


        return res;
    }



    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.ReverseSentence("  i   am   a    student ");
       /* int[][] test = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(solution.Find(16,test));*/
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        //System.out.println(solution.IsPopOrder(pushA, popA));

        //System.out.println(solution.IsPopOrder(pushA, popA));
        /*Scanner input = new Scanner(System.in);
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        System.out.println(s);*/
        /*int[] nums = new int[3];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }*/
        /*String string=input.nextLine();
        while (string!="end"){
            System.out.println("input:");
            string=input.nextLine();
            System.out.println("result:"+string);
        }*/
    }
}
