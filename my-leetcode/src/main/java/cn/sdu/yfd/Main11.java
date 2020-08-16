package cn.sdu.yfd;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/8/1 19:51.
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int max = 1;
        int[] time = new int[1000];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            for (int j = start; j < end; j++) {
                time[j] = time[j] + 1;
                if (time[j] > max) {
                    max = time[j];
                }
            }
        }
        //HashMap<Integer, Integer> timeToCount = new HashMap<>();
      /*  for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            for (int j = start; j < end; j++) {
                if (timeToCount.containsKey(j)) {
                    timeToCount.put(j, timeToCount.get(j) + 1);
                    max = max > timeToCount.get(j) ? max : timeToCount.get(j);
                } else {
                    timeToCount.put(j, 1);
                }
            }
        }*/
        System.out.println(max);
    }
}
