package cn.sdu.test.aiqiyi;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author icatzfd
 * Created on 2020/9/13 15:37.
 */
public class Main1 {
    public static void main(String[] args) {

       /* Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (str == null || str.length() == 0) {
            System.out.println(0);
            return;
        }
        Map<Character, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0, start = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (map.containsKey(temp)) {
                start = Math.max(map.get(temp), start);
            }
            max = Math.max(max, i - start + 1);
            map.put(temp, i + 1);

        }
        System.out.println(max);*/

    }
}
