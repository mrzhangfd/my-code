package cn.sdu.test.alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2021/3/12 19:26.
 */


public class Test0312 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = 100000;
            }
        }

        for (int i = 0; i < n; i++) {
            map[i][i] = 1;
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int source = scanner.nextInt();
            int target = scanner.nextInt();
            map[source - 1][target - 1] = 1;
        }
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int tempSource = scanner.nextInt();
            int tempTarget = scanner.nextInt();
            //调用dijstra算法计算最短路径
            dijstra(map, tempSource - 1, tempTarget - 1);
        }
    }

    /**
     * @param matrix：邻接矩阵
     * @param source：起点
     */
    public static void dijstra(int[][] matrix, int source, int target) {
        //最短路径长度
        int[] shortest = new int[matrix.length];
        //判断该点的最短路径是否求出
        int[] visited = new int[matrix.length];


        //初始化起点，将起点放入S
        shortest[source] = 0;
        visited[source] = 1;

        for (int i = 1; i < matrix.length; i++) {       //i从1开始，因为起点已经加入S了
            int min = 100000;
            int index = -1;

            //找出某节点到起点路径最短
            for (int j = 0; j < matrix.length; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }

            //更新最短路径，标记起点到该节点的最短路径已经求出
            shortest[index] = min;
            visited[index] = 1;

            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < matrix.length; m++) {
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {
                    matrix[source][m] = matrix[source][index] + matrix[index][m];

                }
            }
        }

        //打印最短路径
        for (int i = 0; i < matrix.length; i++) {
            if (i != source) {
                if (i == target) {
                    if (shortest[i] == -1) {
                        System.out.println(-1);
                    } else {
                        System.out.println(shortest[i]);
                    }
                }
            }
        }
    }
}

