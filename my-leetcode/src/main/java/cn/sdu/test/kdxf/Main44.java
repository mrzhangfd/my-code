package cn.sdu.test.kdxf;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/7/31 15:27.
 */
public class Main44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.trim();
        String str2 = " ";
        //flag=fasle 默认表示没有 1到9
        boolean flag = false;
        if (str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (!flag && str.charAt(i) == '-') {
                    str2 = "-";
                }
                if ('1' <= str.charAt(i) && str.charAt(i) <= '9' || flag && str.charAt(i) == '0') {
                    str2 += str.charAt(i);
                    flag = true;
                }
            }
            System.out.println(str2);
        }
    }
}
