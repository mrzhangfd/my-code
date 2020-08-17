package cn.sdu.test.zhongxing;

import java.util.Scanner;

/**
 * 能否被6整除
 *
 * @author icatzfd
 * Created on 2020/8/15 10:26.
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int num = sc.nextInt();
            int count = 0;
            if(getBitNum(num)<3){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }
    }

    public static int getBitSum(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num = num / 10;
        }
        return res;
    }

    public static int getBitNum(int num) {
        int res = 0;
        while (num != 0) {
            num = num / 10;
            res++;
        }
        return res;
    }


}
