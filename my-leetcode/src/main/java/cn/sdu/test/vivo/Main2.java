package cn.sdu.test.vivo;

import java.util.Scanner;

/**
 * 回文字符串
 *
 * @author icatzfd
 * Created on 2020/9/12 20:23.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int flag = -1;
        for (int i = 0; i < str.length(); i++) {
            if (judge(str, i)) {
                flag = i;
            }
        }
        if(flag==-1){
            System.out.println("false");
        }else {
            StringBuilder ss= new StringBuilder();
            for(int i=0;i<str.length();i++){
                if(i!=flag){
                    ss.append(str.charAt(i));
                }
            }
            System.out.println(ss);
        }


    }

    private static boolean judge(String ss, int index) {
        String s1 = "";
        for (int i = 0; i < ss.length(); i++) {
            if (i != index) {
                s1 += ss.charAt(i);
            }
        }

        for (int i = 0; i < s1.length() / 2; i++) {

            if (s1.charAt(i) != s1.charAt(s1.length()-1-i)) {
                return false;
            }
        }
        return true;

    }
}
