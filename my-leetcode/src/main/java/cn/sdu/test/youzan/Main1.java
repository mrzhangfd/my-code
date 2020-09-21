package cn.sdu.test.youzan;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/9/11 15:28.
 */
public class Main1 {
    public static void main(String[] args) {
        String a="a,1;b,2;c,3;";
        String b="a,2;b,4,d,5;";
        System.out.println(StringAdd(a,b));
    }

    public static String StringAdd(String a ,String b){
        int[] nums = new int[26];
        for (int i = 0; i < a.length(); i++) {
            char temp = a.charAt(i);
            int sub = temp - 'a';
            if (sub >= 0 && sub <= 25) {
                int num = Integer.parseInt(a.substring(i + 2, i + 3));
                nums[sub] += num;
            }
        }

        for (int i = 0; i < b.length(); i++) {
            char temp = b.charAt(i);
            int sub = temp - 'a';
            if (sub >= 0 && sub <= 25) {
                int num = Integer.parseInt(b.substring(i + 2, i + 3));
                nums[sub] += num;
            }
        }
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if(nums[i]!=0){
                stringBuffer.append((char)(i+97)).append(",").append(nums[i]).append(";");
            }

        }
        return stringBuffer.toString();
    }
}
