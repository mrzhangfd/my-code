package cn.sdu.test.bytedance.test0411;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2021/4/11 19:22.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int[][] res = new int[n * (n - 1) / 2][5];
        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int k = i + 1; k < n; k++) {
                for (int j = 0; j < 5; j++) {
                    res[idx][j] = Math.max(arr[i][j], arr[k][j]);
                    idx++;
                }
            }

        }
        for (int i = 0; i < n * (n - 1) / 2; i++) {
            for (int j = 1; j < 5; j++) {
                if (res[i][j] < res[i][0]) {
                    res[i][0] = res[i][j];
                }
            }
        }

        for (int i = 0; i < n * (n - 1) / 2; i++) {

        }


    }
}
