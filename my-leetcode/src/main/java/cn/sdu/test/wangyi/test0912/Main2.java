package cn.sdu.test.wangyi.test0912;

import cn.sdu.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 成双成对
 *
 * @author icatzfd
 * Created on 2020/9/12 15:06.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(findTheLongestSubstring(str));


    }

    public  static int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] pos = new int[1 << 6];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'b') {
                status ^= (1 << 1);
            } else if (ch == 'c') {
                status ^= (1 << 2);
            } else if (ch == 'x') {
                status ^= (1 << 3);
            } else if (ch == 'y') {
                status ^= (1 << 4);
            }else if(ch=='z'){
                status ^= (1 << 5);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }


}
