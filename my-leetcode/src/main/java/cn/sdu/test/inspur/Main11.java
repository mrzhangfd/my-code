package cn.sdu.test.inspur;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/9/19 19:53.
 */
public class Main11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = 1, max = 1;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                temp[i] = nums[i];
                for (int j = i + 1; j < n; j++) {
                    temp[j] = nums[j];
                    if (temp[i] + 1 == temp[j]) {
                        num += 1;
                        temp[i] = temp[j];
                    }
                }
                if (num > max) {
                    max = num;
                }
                num = 1;
            }
            System.out.println(n - max);
        }

    }
}
