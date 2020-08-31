package cn.sdu.test.trend;


import java.util.*;

/** 测试数据：88 81 85 80 19 22 31 15 27 29 30 12 22 26 5 14
 * 输出：300
 * @author icatzfd
 * Created on 2020/8/23 16:38.
 */
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        int x = Integer.parseInt(strings[0]);
        int y = Integer.parseInt(strings[1]);
        Point qu = new Point(x, y);
        x = Integer.parseInt(strings[2]);
        y = Integer.parseInt(strings[3]);
        Point qi = new Point(x, y);

        List<Point> newList = new ArrayList<>();

        for (int i = 4; i < strings.length; i = i + 2) {
            Point p = new Point(Integer.parseInt(strings[i]), Integer.parseInt(strings[i + 1]));
            newList.add(p);
            // queue.offer(p);
        }


        Point minPoint = null;
        Point curPoint = qu;
        double res = 0;
        while (!newList.isEmpty()) {
            double min = Integer.MAX_VALUE;
            for (Point point1 : newList) {
                double temp = calDis(curPoint, point1);
                if (temp < min) {
                    min = temp;
                    minPoint = point1;
                }
            }
            newList.remove(minPoint);
            curPoint = minPoint;
            res += min;
        }
        res += calDis(minPoint, qi);
        System.out.println(res);

    }

    public static double calDis(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }
}
