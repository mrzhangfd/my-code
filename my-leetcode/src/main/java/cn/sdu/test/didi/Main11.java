package cn.sdu.test.didi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/8/21 20:31.
 */
public class Main11 {

    public static void main(String[] args) {

        //int s=scanner.nextInt();
        System.out.println("================1");
        List<int[]> list1 = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    if (i != j && i != k && k != j) {
                        int sum = i * 100 + j * 10 + k;
                        //list1.add(sum);
                        int sum1 = i * 100 + k * 10 + k;
                        //list2.add(sum1);
                        list1.add(new int[]{sum, sum1});
                    }
                }
            }
        }
        List<int[]> res = new ArrayList<>();
        for (int s = 101; s < 2000; s++) {

            for (int[] sum1 : list1) {
                if (sum1[0] + sum1[1] == s) {
                    res.add(sum1);
                }
            }
            if (res.size() == 0) {
                continue;
               /* System.out.println(0);
                return;*/
            }
            int[][] ress = new int[res.size()][2];
            for (int i = 0; i < res.size(); i++) {
                ress[i] = res.get(i);
            }
            Arrays.sort(ress, (a, b) -> {
                return a[0] - b[0];
            });

            //System.out.println(ress.length);
            if (ress.length >= 3) {
                System.out.println("----------------------------------------------");
            }
            System.out.println("111111111111111111111111111111111111111111111111111");
            for (int[] ints : ress) {
                System.out.println(ints[0] + " " + ints[1]);
            }
            System.out.println("222222222222222222222222222222222222222222222222222222");
        }


        //scanner.close();
    }
}
