package cn.sdu.test.kdxf;

import java.util.Scanner;

/**
 * 矩形
 * 给出8个数据，前四个数据代表第一个矩形的对角线上的点坐标，后四个数据代表第二个矩形的对角线上的点坐标
 *       判断两矩形能否相交，能则输出1，否则输出0
 * @author icatzfd
 * Created on 2020/7/31 14:47.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        int x4 = sc.nextInt();
        int y4 = sc.nextInt();

        if ((Math.max(x1, x2) < Math.min(x3, x4)) || (Math.max(x3, x4) < Math.min(x1, x2))) {
            System.out.println(0);
        } else if ((Math.max(y1, y2) < Math.min(y3, y4)) || (Math.max(y3, y4) < Math.min(y1, y2))) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
