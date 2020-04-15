package cn.sdu.icat;

import java.lang.Math;
import java.util.*;

/**
 * LeetCode
 *
 * @author 张峰达
 * Created on 2020/4/1 19:49.
 */

public class LeetCode {

   /* public void recur(int level,int param){
        //递归终结条件
        if(level>MAX_LEVEL){
            return;
        }
        //处理当前层
        process(level,param);

        //下探到下一层
        recur(level:level+1,newParam);

        //清理当前层
        //reverse the current  level status if needed
    }*/

    public int paLouti(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return paLouti(n - 1) + paLouti(n - 2);
    }

    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (low != null && val <= low) {
            return false;
        }
        if (high != null && val >= high) {
            return false;
        }
        if (!valid(node.left, low, node.val)) {
            return false;
        }
        if (!valid(node.right, val, high)) {
            return false;
        }
        return true;
    }


    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 1;
        }

        int i = 0;
        for (int j = 1; j < len; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

    }

    /**
     * 11. 盛最多水的容器
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int len = height.length;
        int i = 0, j = len - 1;
        int temp;
        while (j >= i) {
            temp = (j - i) * Math.min(height[i], height[j]);
            if (temp >= maxArea) {
                maxArea = temp;
            }
            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }

    //144. 二叉树的前序遍历
    List<Integer> ret = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        helper(root);
        return ret;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        ret.add(node.val);
        helper(node.left);
        helper(node.right);
    }

    //242
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            count[ss[i] - 'a']++;
        }
        for (int i = 0; i < tt.length; i++) {
            count[tt[i] - 'a']--;
        }
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    //20
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        if (s.length() <= 1) {
            return false;
        }
        for (char c : chars) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (!stack.empty()) {
                    char tempChar = stack.pop();
                    if (!((tempChar == '[' && c == ']') || (tempChar == '{' && c == '}') || (tempChar == '(' && c == ')'))) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }

    //739单调栈，入栈的是数组元素的下标
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                    int index = stack.pop();
                    res[index] = i - index;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;
    }

    //160
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

    //206 头插法翻转链表
    public ListNode reverseList(ListNode head) {
        ListNode newNode = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newNode.next;
            newNode.next = head;
            head = next;
        }
        return newNode.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newNode = new ListNode(-1);
        ListNode preNode = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                preNode.next = l1;
                l1 = l1.next;

            } else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        if (l1 == null) {
            preNode.next = l2;
        } else {
            preNode.next = l1;
        }
        return newNode;
    }

    //83
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = new ListNode(-1);
        newNode.next = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return newNode.next;
    }

    //19
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        ListNode prv = new ListNode(-1);
        prv.next = head;
        int num = n;
        while (num != 1 && fast.next != null) {
            fast = fast.next;
            num--;
        }
        while (fast.next != null) {
            slow = slow.next;
            prv = prv.next;
            fast = fast.next;
        }
        prv.next = slow.next;
        return slow == head ? head.next : head;
    }

    //167
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            }
            if (numbers[i] + numbers[j] < target) {
                i++;
            }
        }
        res[0] = i + 1;
        res[1] = j + 1;
        return res;

    }


    //633
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == c) {
                return true;
            }
            if (sum < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    //345
    public String reverseVowels(String s) {
        HashSet<Character> hashSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i <= j) {
            if (!hashSet.contains(chars[i])) {
                i++;
            }
            if (!hashSet.contains(chars[j])) {
                j--;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);


    }

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return (isEqual(s, i++, j) || isEqual(s, i, j--));
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isEqual(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m, j = 0; i < m + n; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
        for (int i = 0, j = nums1.length - 1; i < j; i++, j--) {
            if (nums1[i] > nums1[j]) {
                int temp = nums1[i];
                nums1[i] = nums1[j];
                nums1[j] = temp;
            }
        }
        return;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)  // 维护堆的大小为 K
            {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        LeetCode leetCode = new LeetCode();
        int[] test = {3, 2, 1, 5, 6, 4};
        int[] test1={4,5,6,0,0,0};
        int[] test2={1,2,3};
        int m=3;
        int n=3;
        int k = 2;
        leetCode.merge(test1,m,test2,n);
        //System.out.println(leetCode.findKthLargest(test, 2));
    }


}
