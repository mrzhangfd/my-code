package cn.sdu.test.xeicheng;

import java.util.Scanner;

/**
 * 子串
 *
 * @author icatzfd
 * Created on 2020/9/8 20:07.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        if("".equals(s1) || "".equals(s2)){
            System.out.println("");
            return;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int minLen = Math.min(len1, len2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            stringBuilder.append(s1.charAt(i));
        }
        if(stringBuilder.length()==0){
            System.out.println("");
            return;
        }
        int m1 = len1 / stringBuilder.length();
        int m2 = len2 / stringBuilder.length();
        StringBuilder stringBuffer1 = new StringBuilder();
        StringBuilder stringBuffer2 = new StringBuilder();
        for (int i = 0; i < m1; i++) {
            stringBuffer1.append(stringBuilder);
        }
        for (int i = 0; i < m2; i++) {
            stringBuffer2.append(stringBuilder);
        }
        if(stringBuffer1.toString().equals(s1) && stringBuffer2.toString().equals(s2)){

            System.out.println(stringBuilder);
        }else {

            System.out.println("");
        }
    }
}
