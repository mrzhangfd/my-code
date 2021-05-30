package cn.sdu.test.qihu360.test0926;

import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/9/26 19:04.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int k = scanner.nextInt();
            int v = scanner.nextInt();
            int num = (int) (a * 1.0 / v + 0.5);

            int sum = 0;
            int i = 0;
            boolean end=false;
            while (b + 1 >= k) {
                sum += k;
                i++;
                if (sum >= num) {
                    System.out.println(i);
                    end=true;
                    break;
                }
                b -= (k - 1);
            }
            if(end) {
                continue;
            }
            System.out.println(b + 1 + sum > num ? i + 1 : i + num - b-sum);
        }
    }
}
