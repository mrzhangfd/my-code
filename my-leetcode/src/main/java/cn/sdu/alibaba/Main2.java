package cn.sdu.alibaba;

import java.util.Scanner;

/**
 * 自动删除机器
 *
 * @author icatzfd
 * Created on 2020/8/7 19:12.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int n = sc.nextInt();
        String[] stings = new String[n];
        for (int i = 0; i < n; i++) {
            stings[i] = sc.next();
        }
        int count = 0;
        while (true) {
            count = 0;
            for (int i = 0; i < n; i++) {
                if (S.contains(stings[i])) {
                    count++;
                    S = S.replaceAll(stings[i], "");
                }
            }
            if (count == 0) {
                break;
            }
        }
        System.out.println(S);

    }

  /*  public static boolean isSubString(String S, String str) {
        if (S == null || S.length() == 0) {
            return false;
        }
        int len1 = S.length();
        int len2 = str.length();
        for (int i = 0; i < len2; i++) {
            for (int j = 0; j < len1; j++) {
                if (S.charAt(j) == str.charAt(i)) {
                    if (S.substring(j, j + len2).equals(str)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }*/


}
