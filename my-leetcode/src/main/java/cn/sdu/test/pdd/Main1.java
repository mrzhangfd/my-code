package cn.sdu.test.pdd;

import java.util.Scanner;

/**
 * 多多的飞行棋
 *
 * @author icatzfd
 * Created on 2020/8/2 19:01.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nums[i] = sc.nextInt();
        }
        //回退次数
        int count = 0;
        int i = 1;
        while (k != 0 && i < n +1) {
            if (nums[i] < k) {
                k -= nums[i];
            } else {
                k = nums[i] - k;
                count ++;
            }

            if (k == 0 && i != n) {
                System.out.println("paradox");
            }
            i++;
        }
        if(k!=0){
            System.out.println(k+" "+count);
        }

    }
}
