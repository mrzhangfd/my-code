package cn.sdu.test.duxiaoman;

/**
 * 涂色
 *
 * @author icatzfd
 * Created on 2020/9/20 20:48.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int result = 0;
        Map<Character, Integer> hashMap = new HashMap();
        for (char ch : str1.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }
        for (char ch : str2.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                if (hashMap.get(ch) > 0) {
                    hashMap.put(ch, hashMap.get(ch) - 1);
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}