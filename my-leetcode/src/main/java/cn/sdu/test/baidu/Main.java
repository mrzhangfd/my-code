package cn.sdu.test.baidu;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/9/3 20:31.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] features = new int[n];
            for (int j = 0; j < m; j++) {
                int k = scanner.nextInt();
                for (int q = 0; q < k; q++) {
                    int l = scanner.nextInt();
                    int r = scanner.nextInt();
                    l--;
                    for (; l < r; l++) {
                        features[l] += 1;
                    }
                }
            }
            int count = 0;
            ArrayList<Integer> res = new ArrayList<>();
            for (int q = 0; q < n; q++) {
                if (features[q] == m) {
                    count++;
                    res.add(q + 1);
                }
            }
            Collections.sort(res, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                   String s1=String.valueOf(o1)+""+String.valueOf(o2);
                   String s2=String.valueOf(o2)+""+String.valueOf(o1);
                   return s1.compareTo(s2);
                }
            });
            System.out.println(count);
            for (int j = 0; j < res.size(); j++) {
                if (j == res.size() - 1) {
                    System.out.println(res.get(j));
                } else {
                    System.out.print(res.get(j) + " ");
                }

            }

        }
    }
}
