package cn.sdu.test.huawei.test0331;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2021/3/31 19:41.
 */
import java.util.Scanner;


public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String line2 = line.substring(1, line.length() - 1);
        String[] ins = line2.split(",");
        if (ins[0].equals("")) {
            System.out.println(0);
            return;
        }
        int[] hatsCounter = new int[1000000];
        for (String hat: ins) {
            hatsCounter[Integer.parseInt(hat.trim())]++;
        }
        int ans = 0;
        for (int i = 0; i < 1000000; i++) {
            int pairs = hatsCounter[i] / (i + 1);
            if (hatsCounter[i] % (i + 1) != 0) {
                pairs++;
            }
            ans += pairs * (i + 1);
        }
        System.out.println(ans);
    }
}