package cn.sdu.test.kdxf;

import java.util.Scanner;

/**
 * 第四题
 *输入任意字符串，从字符串中提取整数
 * @author icatzfd
 * Created on 2020/7/31 14:08.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str.trim();
        StringBuffer ssbb = new StringBuffer();
        boolean isFirst = true;

        boolean hasNum = false;
        boolean isActive = true;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) == '-' || str.charAt(i) == '+') && (!hasNum) && isFirst) {
                if (str.charAt(i) == '-') {
                    isActive = false;
                } else if (str.charAt(i) == '+') {
                    isActive = true;
                }
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                hasNum = true;
                isFirst = false;
                ssbb.append(str.charAt(i));
            }
        }
        int res = Integer.parseInt(ssbb.toString());
        if (isActive) {
            System.out.println(res);
        } else {
            StringBuffer signal = new StringBuffer("-");
            StringBuffer newRes = signal.append(ssbb);
            System.out.println(newRes);
        }


    }
}
