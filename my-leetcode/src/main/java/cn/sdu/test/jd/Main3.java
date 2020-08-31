package cn.sdu.test.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for (int i = 0; i < m; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                list = insertData(a, b, list);

            } else if (op == 2) {
                int a = sc.nextInt();
                list = removeData(a, list);
            } else {
                for (int j = 1; j < list.size(); j++) {
                    if (j == list.size() - 1) {
                        System.out.print(list.get(j));
                    } else {
                        System.out.print(list.get(j) + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static List<Integer> insertData(int a, int b, List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            res.add(list.get(i));
        }
        res.add(b);
        for (int i = a; i < list.size(); i++) {
            res.add(list.get(i));
        }
        return res;
    }

    public static List<Integer> removeData(int a, List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <list.size(); i++) {
            if(i==a){
                continue;
            }
            res.add(list.get(i));
        }
        return res;
    }
}

/**
 * 数列游戏
 *
 * @author icatzfd
 * Created on 2020/8/27 20:18.
 */