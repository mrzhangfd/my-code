package cn.sdu.test.inspur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 被砍掉的树
 *
 * @author icatzfd
 * Created on 2020/9/19 19:32.
 */



public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> odd;
        List<Integer> even;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            odd = new ArrayList<Integer>();
            even = new ArrayList<Integer>();
            for (int i = 0; i < 50; i++) {
                odd.add(2 * i + 1);
                even.add(2 * i + 2);
            }
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                if (num % 2 == 1) {
                    for (int j = 0; j < odd.size(); j++) {
                        if (odd.get(j) == num) {
                            odd.remove(j);
                            break;
                        }
                    }
                } else {
                    for (int j = 0; j < even.size(); j++) {
                        if (even.get(j) == num) {
                            even.remove(j);
                            break;
                        }
                    }
                }
            }
            int maxvalue = 0;
            int maxstart = 0;
            int res = 1;
            int start = odd.get(0);

            for (int i = 0; i < odd.size() - 1; i++) {
                if (odd.get(i + 1) - odd.get(i) == 2) {
                    res++;
                } else {
                    if (res > maxvalue) {
                        maxvalue = res;
                        maxstart = start;

                    }
                    res = 1;
                    start = odd.get(i + 1);
                }
            }
            if (res > maxvalue) {
                maxvalue = res;
                maxstart = start;

            }
            res = 1;
            start = even.get(0);

            for (int i = 0; i < even.size() - 1; i++) {
                if (even.get(i + 1) - even.get(i) == 2) {
                    res++;
                } else {
                    if (res > maxvalue) {
                        maxvalue = res;
                        maxstart = start;

                    }
                    res = 1;
                    start = even.get(i + 1);
                }
            }
            if (res > maxvalue) {
                maxvalue = res;
                maxstart = start;

            }
            System.out.println(maxstart + " " + maxvalue);
        }


    }
}

