package cn.sdu.test.tencent;

import java.util.*;

/**
 * @author 张峰达
 * Created on 2020/8/13 10:12.
 */
class Coord {
    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class NearestCoord {
    public static List<Coord> GetNearestCoord(List<Coord> vec, Coord e, int k) {

        //最大堆（初始化大小为k）存储距离点e最近的k个点
        Queue<Coord> maxHeap = new PriorityQueue<>(k, new Comparator<Coord>() {
            @Override
            public int compare(Coord o1, Coord o2) {
                double d1 = calDistance(o1, e);
                double d2 = calDistance(o2, e);
                if (d2 > d1) {
                    return 1;
                } else if (d2 < d1) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (Coord coord : vec) {
            if (maxHeap.size() < k) {
                maxHeap.offer(coord);
            } else {
                Coord tempCoord = maxHeap.peek();
                double d1 = calDistance(coord, e);
                double d2 = calDistance(tempCoord, e);
                if (d1 > d2) {
                    maxHeap.poll();
                    maxHeap.offer(coord);
                }
            }
        }
        List<Coord> res = new ArrayList<>();
        for (Coord coord : maxHeap) {
            res.add(coord);
        }
        return res;
    }

    public static double calDistance(Coord source, Coord target) {
        return Math.sqrt((source.x - target.x) * (source.x - target.x)
                + (source.y - target.y) * (source.y - target.y));
    }

    public static void main(String[] args) {
        double x, y;

        List<Coord> vec = new ArrayList<>();
        Coord e = new Coord(50, 50);
        for (int i = 0; i < 10000; i++) {

            //随机生成10000个点测试
            x = Math.random() * 100;
            y = Math.random() * 100;
            Coord coord = new Coord((int) x, (int) y);
            System.out.println((int) x + " " + (int) y);
            vec.add(coord);
        }
        System.out.println("===================================");
        List<Coord> res = GetNearestCoord(vec, e, 10);
        for (int i = 0; i < 10; i++) {
            System.out.println(res.get(i).x + " " + res.get(i).y);
        }

    }
}
