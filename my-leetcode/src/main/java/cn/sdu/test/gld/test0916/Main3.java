package cn.sdu.test.gld.test0916;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * AOE攻击
 *
 * @author icatzfd
 * Created on 2020/9/16 21:22.
 */
public class Main3 {


    public static void main(String[] args) {
        int res = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int y = sc.nextInt();

        int[][] pos = new int[n][2];
        for (int i = 0; i < n; i++) {
            pos[i][0] = sc.nextInt();
            pos[i][1] = sc.nextInt();
        }
        Arrays.sort(pos, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < n; i++) {
            while (pos[i][1] > 0) {
                int tmp = pos[i][1];
                for (int j = i; j < n; j++) {
                    if (pos[j][0] - pos[i][0] <= y * 2) {
                        pos[j][1] -= tmp;
                    }
                }
                res += tmp;
            }
        }
        System.out.println(res);
    }

}
