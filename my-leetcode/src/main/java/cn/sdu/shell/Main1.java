package cn.sdu.shell;

import java.util.Scanner;

/**
 * 回文串构造
 *
 * @author icatzfd
 * Created on 2020/8/11 19:42.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.nextLine();
        if (str.length() <= 1) {
            System.out.println(0);
        }
        int[][] dp = new int[n+1][n+1];


    }
}
