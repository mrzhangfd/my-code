package cn.sdu.test.xeicheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 斜着打印矩阵
 *
 * @author icatzfd
 * Created on 2020/9/8 20:26.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int num = rows + cols - 2;
        int[][] arr = new int[rows][cols];
        int idx = 1;
        for (int k = 0; k <= num; k++) {
            for (int j = 0; j < cols; j++) {
                for (int i = 0; i < rows; i++) {

                    if (i + j == k) {
                        arr[i][j] = idx++;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
