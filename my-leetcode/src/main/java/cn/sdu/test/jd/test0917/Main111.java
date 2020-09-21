package cn.sdu.test.jd.test0917;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 提取年份
 *
 * @author icatzfd
 * Created on 2020/9/17 20:27.
 */
public class Main111 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String reg = "[1-3]\\d{3}";
        Pattern pat = Pattern.compile (reg);
        Matcher mat = pat.matcher (s);
        while (mat.find ())
        {
            System.out.print (mat.group ()+" ");
        }
    }
}
