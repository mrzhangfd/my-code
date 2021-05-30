package cn.sdu.test.huawei.test0331;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2021/3/31 19:48.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Main3 {

    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String target = sc.nextLine();
        int start = Integer.parseInt(sc.nextLine());

        List<Integer>[] position = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            position[i] = new ArrayList<>();
        }
        for (int i = 0; i < str.length(); i++) {
            position[str.charAt(i) - 'a'].add(i);
        }
        dfs(start, 0, target.toCharArray(), 0, position, str.length());
        System.out.println(res);
        res = Integer.MAX_VALUE;
    }

    public static void dfs(int start, int nextPosition, char[] target, int cost, List<Integer>[] map, int n) {
        if (nextPosition == target.length) {
            res = Math.min(res, cost);
            return;
        }
        char cur = target[nextPosition];

        List<Integer> indexes = map[cur - 'a'];
        for (Integer index : indexes) {
            cost += Math.min(Math.abs(index - start), n - Math.abs(index - start));
            dfs(index, ++nextPosition, target, cost, map, n);
        }

    }
}