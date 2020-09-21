package cn.sdu.test.cao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 统计出现三次的字符
 *
 * @author icatzfd
 * Created on 2020/9/11 18:20.
 */
public class Main3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }

            if (map.get(ch) == 3) {
                System.out.println(ch);
                return;
            }
        }
        System.out.println("没有出现三次的字符");
    }
}
