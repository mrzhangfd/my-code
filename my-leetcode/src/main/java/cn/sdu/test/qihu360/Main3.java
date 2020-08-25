package cn.sdu.test.qihu360;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/8/24 11:02.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] strings = s.split("n");

        for (int i = 0; i < strings.length; i++) {
            if (i == 0 && strings[i] == "") {
                continue;
            } else if (strings[i] != null) {
                strings[i] = "N" + strings[i];
                System.out.println(strings[i]);
            }

        }

    }

    public static String upperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
