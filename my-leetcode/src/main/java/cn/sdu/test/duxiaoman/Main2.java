package cn.sdu.test.duxiaoman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 坚强的小昆虫
 *
 * @author icatzfd
 * Created on 2020/9/20 20:55.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int k = 0; k < t; k++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] map = new char[n][m];
            int[] begin = new int[2];
            for (int i = 0; i < n; i++) {
                String str = scanner.nextLine();
                if (str.indexOf('@') != -1) {
                    begin[0] = i;
                    begin[1] = str.indexOf('@');
                }
                map[i] = str.toCharArray();
            }
            List<Integer> list = new ArrayList<>();
            int[][] visited = new int[n][m];
            dfs(map, begin, list,visited);
        }
    }

    private static void dfs(char[][] map, int[] begin, List<Integer> list,int[][] visited) {

    }
}
