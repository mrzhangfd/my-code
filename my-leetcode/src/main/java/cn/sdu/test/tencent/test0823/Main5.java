package cn.sdu.test.tencent.test0823;

/**
 * 回文子串
 *
 * @author icatzfd
 * Created on 2020/8/23 21:51.
 */

import java.util.*;

public class Main5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int x = input.nextInt();
        for (int i = 0; i < x; i++) {
            List<List<String>> listList = new ArrayList<>();
            String newString = s.substring(input.nextInt() - 1, input.nextInt());
            System.out.println(partition(newString));
        }
    }

    public static int partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return 0;
        }
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, dp, stack, res);
        int size = 10000;
        for (List x : res) {
            if (x.size() < size) {
                size = x.size();
            }
        }
        return size;
    }

    private static void backtracking(String s,
                                     int start,
                                     int len,
                                     boolean[][] dp,
                                     Deque<String> path,
                                     List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            // 剪枝
            if (!dp[start][i]) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, dp, path, res);
            path.removeLast();
        }
    }
}
