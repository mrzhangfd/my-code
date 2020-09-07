package cn.sdu.test.baidu;

import java.util.Scanner;

/**
 * 数位
 *
 * @author icatzfd
 * Created on 2020/9/3 19:38.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        int numof0 = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
            if (nums[i] == 0) {
                numof0++;
            }
        }
        int sum1 = sum;
        int numof5 = 0;

        int temp = sum / 45;
        if (temp == 0) {
            if (numof0 != 0) {
                System.out.println(0);

            }else {
                System.out.println(-1);
            }
        } else if (temp >= 1) {
            StringBuilder stringBuilder=new StringBuilder();
            for(int i=0;i<9*temp;i++){
                stringBuilder.append(5);
            }
            for(int i=0;i<numof0;i++){
                stringBuilder.append(0);
            }
            System.out.println(stringBuilder.toString());
        }


       /* while (sum1 > 5) {
            sum = sum1;
            while (sum > 9) {
                String temp = String.valueOf(sum);
                sum = 0;
                for (int i = 0; i < temp.length(); i++) {
                    sum += Integer.parseInt(temp.substring(i, i + 1));
                }
            }
            if (sum != 9) {
                sum1 -= 5;
                numof5++;
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < n - numof0 - numof5; i++) {
                    stringBuffer.append(5);
                }
                for (int i = 0; i < numof0; i++) {
                    stringBuffer.append(0);
                }
                System.out.println(stringBuffer.toString());
            }


        }*/


    }
}
