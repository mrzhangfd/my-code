package cn.sdu.test.xiaohongshu.test0912;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 字符串分割
 *
 * @author icatzfd
 * Created on 2020/9/12 10:25.
 */
public class Main2 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;
        int count = 0;
        while (idx < len) {
            char temp = chars[idx];
            for (int i = len - 1; i >= 0; i--) {
                if (chars[i] == temp) {
                    count++;
                    idx = i + 1;
                    break;
                }
            }
        }

        int idx2 = len - 1;
        int count2=0;
        while (idx2 >= 0) {
            char temp = chars[idx2];
            for (int i = 0; i < len; i++) {
                if (chars[i] == temp) {
                    count2++;
                    idx2 = i - 1;
                    break;
                }
            }
        }
        return Math.min(count,count2);

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }

        res = solution(_s);
        System.out.println(String.valueOf(res));

    }
}
