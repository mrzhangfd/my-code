package cn.sdu.test.qihu360.test0926;

import java.util.Scanner;

/**
 * 乌龟爬
 * 有向图的最短路径
 *
 * @author icatzfd
 * Created on 2020/9/26 19:49.
 */
public class Main2 {

    //最大权值，表示不可达
    static int maxValue = 1000000001;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int source = scanner.nextInt();
        int target = scanner.nextInt();
        int[][] nums = new int[m][3];


        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = maxValue;
            }
        }
        for (int i = 0; i < m; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
            nums[i][2] = scanner.nextInt();
            mat[nums[i][0] - 1][nums[i][1] - 1] = nums[i][2];
        }
        dijkstra(mat, source - 1, target - 1);
        System.out.println(mat[source - 1][target - 1]);

    }

    private static void dijkstra(int[][] mat, int source, int target) {

        //判断该点的最短路径是否求过
        int[] visited = new int[mat.length];



        //存储输出路径
        String[] path = new String[mat.length];
        //初始化输出路径
        for (int i = 0; i < mat.length; i++) {
            path[i] = new String(source + "-" + i);
        }

        visited[source] = 1;

        for (int i = 1; i < mat.length; i++) {
            int min = maxValue;
            int idx = -1;
            for (int j = 0; j < mat.length; j++) {
                if (visited[j] == 0 && mat[source][j] < maxValue) {
                    min = mat[source][j];
                    idx = j;
                }
            }

            visited[idx] = 1;

            for (int m = 0; m < mat.length; m++) {
                if (visited[m] == 1 && mat[source][idx] + mat[idx][m] < mat[source][m]) {
                    mat[source][m] = mat[source][idx] + mat[idx][m];

                }
            }
        }


    }
}

