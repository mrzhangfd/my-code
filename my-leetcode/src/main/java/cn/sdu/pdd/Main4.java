package cn.sdu.pdd;

import java.util.Scanner;

/**
 * 多多的农场
 *6*6地方，*为障碍物，# 为可种植的地方，现在又6种种子，一个点的种子必须要和上下左右不一样。求方案数
 * @author icatzfd
 * Created on 2020/8/2 19:33.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] chars = new char[6][6];

        int i = 0;

        while (true) {
            String str = sc.next();
            chars[i] = str.toCharArray();
            i++;
            if (i == 6) {
                break;
            }
        }

        int res = 1;
        int base = 6;
        for (int k = 0; k < 6; k++) {
            for (int j = 0; j < 6; j++) {
                if (chars[i][j] == '#') {
                    res *= base;
                    base--;
                    if (base == 1) {
                        System.out.println(res);
                    }
                }
            }
        }
    }
}
