package cn.sdu.test.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 多多的n阶矩阵
 *
 * @author icatzfd
 * Created on 2020/9/1 19:02.
 */
public class Main1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] res = new int[n][n];
        if (n % 2 == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i + j < n - 1 && j >= n / 2) {
                        res[i][j] = 1;
                    } else if (i - j < 0 && j < n / 2) {
                        res[i][j] = 2;
                    } else if (i - j > 0 && i < n / 2) {
                        res[i][j] = 3;
                    } else if (i + j < n - 1 && i >= n / 2) {
                        res[i][j] = 4;
                    } else if (i + j > n - 1 && j < n / 2) {
                        res[i][j] = 5;
                    } else if (j >= n / 2 && i - j > 0) {
                        res[i][j] = 6;
                    } else if (i - j < 0 && i >= n / 2) {
                        res[i][j] = 7;
                    } else if (i < n / 2 && i + j > n - 1) {
                        res[i][j] = 8;
                    }
                }
            }
        }else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i + j < n - 1 && j > n / 2) {
                        res[i][j] = 1;
                    } else if (i - j < 0 && j < n / 2) {
                        res[i][j] = 2;
                    } else if (i - j > 0 && i < n / 2) {
                        res[i][j] = 3;
                    } else if (i + j < n - 1 && i > n / 2) {
                        res[i][j] = 4;
                    } else if (i + j > n - 1 && j < n / 2) {
                        res[i][j] = 5;
                    } else if (j > n / 2 && i - j > 0) {
                        res[i][j] = 6;
                    } else if (i - j < 0 && i > n / 2) {
                        res[i][j] = 7;
                    } else if (i < n / 2 && i + j > n - 1) {
                        res[i][j] = 8;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(res[i][j]+" ");

            }
            System.out.println();
        }
    }
}
