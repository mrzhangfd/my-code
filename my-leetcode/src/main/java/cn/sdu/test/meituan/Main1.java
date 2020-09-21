package cn.sdu.test.meituan;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 六位数
 * A了27
 * @author icatzfd
 * Created on 2020/9/20 10:05.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");

        int m = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);
        int a, b, c, d, e, f;
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            String num = String.valueOf(i);
            f = Integer.parseInt(num.substring(5, 6));
            e = Integer.parseInt(num.substring(4, 5));
            d = Integer.parseInt(num.substring(3, 4));
            c = Integer.parseInt(num.substring(2, 3));
            b = Integer.parseInt(num.substring(1, 2));
            a = Integer.parseInt(num.substring(0, 1));


            if (isDif(a, b) && isDif(a, c) && isDif(a, d) && isDif(a, e) && isDif(a, f)
                    && isDif(b, c) && isDif(b, d) && isDif(b, e) && isDif(b, f)
                    && isDif(c, d) && isDif(c, e) && isDif(c, f)
                    && isDif(d, e) && isDif(d, f)
                    && isDif(e, f) && a != 0 && c != 0 && e != 0
            ) {
                if (a * 10 + b + c * 10 + d == e * 10 + f) {
                    list.add(i);
                }
            }

        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= m && list.get(i) <= n) {
                res++;
            }
        }
        System.out.println(res);
    }

    public static boolean isDif(int a, int b) {
        return a != b;
    }
}
