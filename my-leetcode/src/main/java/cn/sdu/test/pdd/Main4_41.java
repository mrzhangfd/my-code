package cn.sdu.test.pdd;

import java.util.Scanner;

public class Main4_41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[m];
        String temp = String.valueOf(n);
        int length = temp.length();

        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }
        if (length <= 5) {
            System.out.println(num(n, nums));
        }
        else if (length == 6) {
            int resulrtemp=num(Integer.parseInt(temp.substring(0,length-1)), nums);
            String x=String.valueOf(resulrtemp);
            String y=x+x.substring(x.length()-1);
            System.out.println(y);
        }
        else if (length == 7) {
            int resulrtemp=num(Integer.parseInt(temp.substring(0,length-2)), nums);
            String x=String.valueOf(resulrtemp);
            String y=x+x.substring(x.length()-2);
            System.out.println(y);
        }
        else if (length == 8) {
            int resulrtemp=num(Integer.parseInt(temp.substring(0,length-3)), nums);
            String x=String.valueOf(resulrtemp);
            String y=x+x.substring(x.length()-3);
            System.out.println(y);
        }
        else if (length == 9) {
            int resulrtemp=num(Integer.parseInt(temp.substring(0,length-4)), nums);
            String x=String.valueOf(resulrtemp);
            String y=x+x.substring(x.length()-4);
            System.out.println(y);
        }else if (length == 10) {
            int resulrtemp=num(Integer.parseInt(temp.substring(0,length-5)), nums);
            String x=String.valueOf(resulrtemp);
            String y=x+x.substring(x.length()-5);
            System.out.println(y);
        }
    }

    public static int num(int n, int[] nums) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int y : nums) {
                if (i % y == 0) {
                    result += 1;
                    break;
                }

            }
        }
        return result;
    }
}
