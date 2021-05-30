package cn.sdu.test.beike.test0412;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        List<String> list=new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            list.add(minInteger(String.valueOf(n), k));
        }
        for(String str:list){
            System.out.println(str);
        }


    }

    public static String minInteger(String num, int k) {
        if (k == 0) {
            return num;
        }
        for (char c = '0'; c <= '9'; c++) {
            int i = num.indexOf(c);
            if (i >= 0) {
                if (i <= k) {
                    return c + minInteger(num.substring(0, i) + num.substring(i + 1), k - i);
                }
            }
        }
        return num;
    }
}


