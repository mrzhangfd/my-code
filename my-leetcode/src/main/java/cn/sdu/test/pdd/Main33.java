package cn.sdu.test.pdd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/8/2 20:52.
 */
public class Main33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int T = scanner.nextInt();
        int[][] wucan = new int[m][2];
        int[][] wancan = new int[n][2];
        for (int i = 0; i < m; i++) {
            wucan[i][0] = scanner.nextInt();
            wucan[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            wancan[i][0] = scanner.nextInt();
            wancan[i][1] = scanner.nextInt();
        }

        Arrays.sort(wucan, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] / o2[0] - o1[1] / o1[0];
            }
        });

        Arrays.sort(wancan, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] / o2[0] - o1[1] / o1[0];
            }
        });
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (wucan[i][1] >= T) {
                    min = Math.min(wucan[i][0], min);
                }
                if (wancan[i][1] >= T) {
                    min = Math.min(wancan[i][0], min);
                }
                if (wucan[i][1] + wancan[j][1] >= T) {
                    min = Math.min(wucan[i][0] + wancan[j][0], min
                    );
                }else {

                }

            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }

    }
}
