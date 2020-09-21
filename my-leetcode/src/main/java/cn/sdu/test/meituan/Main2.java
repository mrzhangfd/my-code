package cn.sdu.test.meituan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 小美的新游戏
 *
 * @author icatzfd
 * Created on 2020/9/20 10:39.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        char[][] map = new char[n][m];

        int[] begin = new int[2];

        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            if (str.indexOf('S') != -1) {
                begin[0] = i;
                begin[1] = str.indexOf('S');
            }
            map[i] = str.toCharArray();
        }
        String path = scanner.nextLine();
        int idx = 0;
        int score = 0;
        int[] cur = {begin[0], begin[1]};
        boolean[][] visited = new boolean[n][m];
        while (idx < path.length()) {
            switch (path.charAt(idx++)) {
                case 'W':
                    if (cur[0] - 1 >= 0) {
                        char temp = map[cur[0] - 1][cur[1]];
                        if (temp != '#') {
                            if (temp == 'X' && visited[cur[0] - 1][cur[1]]) {
                                score -= q;
                            } else if (temp == 'O') {
                                score += p;
                            }
                            cur = new int[]{cur[0] - 1, cur[1]};
                        }

                    }
                    break;
                case 'A':
                    if (cur[1] - 1 >= 0) {
                        char temp = map[cur[0]][cur[1] - 1];
                        if (temp != '#') {
                            if (temp == 'X') {
                                score -= q;
                            } else if (temp == 'O') {
                                score += p;
                            }
                            cur = new int[]{cur[0], cur[1] - 1};
                        }
                    }
                    break;
                case 'S':
                    if (cur[0] + 1 < n) {
                        char temp = map[cur[0] + 1][cur[1]];
                        if (temp != '#') {
                            if (temp == 'X') {
                                score -= q;
                            } else if (temp == 'O') {
                                score += p;
                            }
                            cur = new int[]{cur[0] + 1, cur[1]};
                        }
                    }
                    break;
                default:
                    if (cur[1] + 1 < m) {
                        char temp = map[cur[0]][cur[1] + 1];
                        if (temp != '#') {
                            if (temp == 'X') {
                                score -= q;
                            } else if (temp == 'O') {
                                score += p;
                            }
                            cur = new int[]{cur[0], cur[1] + 1};
                        }
                    }
                    break;
            }
        }
        System.out.println(score);

    }


}
