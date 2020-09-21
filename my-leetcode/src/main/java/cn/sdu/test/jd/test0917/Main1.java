package cn.sdu.test.jd.test0917;


import java.util.Scanner;


/**
 * 提取年份
 *
 * @author icatzfd
 * Created on 2020/9/17 19:33.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int idx = 0;
        while (idx < str.length()) {

            if (isNum(str.charAt(idx))) {
                int len = 0;
                for (int i = idx; i < str.length(); i++) {
                    if (isNum(str.charAt(i))) {
                        len++;
                    } else {
                        break;
                    }
                }
                if (len == 4) {
                    if (isYear(str.substring(idx, idx + 4))) {
                        System.out.print(str.substring(idx, idx + 4) + " ");
                    }
                    idx = idx + 4;
                } else {
                    idx = idx + len;
                }

            } else {
                idx++;
            }
        }


    }

    public static boolean isNum(char ch) {
        int temp = ch - '0';
        if (temp >= 0 && temp <= 9) {
            return true;
        }
        return false;
    }

    public static boolean isYear(String ss) {
        int year = Integer.parseInt(ss);

        if (year >= 1000 && year <= 3999) {
            return true;
        }
        return false;
    }
}
