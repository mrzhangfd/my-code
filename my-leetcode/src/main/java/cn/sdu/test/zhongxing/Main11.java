package cn.sdu.test.zhongxing;

import java.util.Scanner;

/**
 * 曹版
 *
 * @author icatzfd
 * Created on 2020/8/15 10:51.
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String num = scanner.next();

            int[] arr = new int[10];
            for (int j = 0; j < num.length(); j++) {
                int tmp = num.charAt(j) - '0';
                arr[tmp] +=   1;
            }
            boolean yesFlag = false;
            for (int j = 100; j < 1000; j++) {
                if (j % 6 == 0) {
                    int first = j / 100;
                    int sec = j % 100 / 10;
                    int end = j % 100 % 10;

                    arr[first] -= 1;
                    arr[sec] -= 1;
                    arr[end] -= 1;
                    if (arr[first] >= 0 && arr[sec] >= 0 && arr[end] >= 0) {
                        arr[first] += 1;
                        arr[sec] += 1;
                        arr[end] += 1;
                        System.out.println("YES");
                        yesFlag = true;
                        break;
                    }
                    arr[first] += 1;
                    arr[sec] += 1;
                    arr[end] += 1;
                }
            }
            if (!yesFlag) {

                System.out.println("NO");
            }
        }
    }
}
