package cn.sdu.test.wangyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main44 {
    public static int n, m;
    public static double minV;  //输入所有边中权值最小的边
    public static double maxV;  //输入所有边中权值最大的边
    public static int[] id;
    public static ArrayList<edge> map;
    public static ArrayList<Double> result = new ArrayList<Double>();

    class MyComparator implements Comparator<edge> {
        @Override
        public int compare(edge arg0, edge arg1) {
            if (arg0.w > arg1.w) {
                return 1;
            } else if (arg0.w < arg1.w) {
                return -1;
            }
            return 0;
        }
    }

    static class edge {
        public int a;  //边的起点
        public int b;  //边的终点
        public double v;  //边的权值
        public double w;  //边权的方差值

        public edge(int a, int b, double v) {
            this.a = a;
            this.b = b;
            this.v = v;
            this.w = 0;
        }
    }

    public void init() {
        minV = Double.MAX_VALUE;
        maxV = Double.MIN_VALUE;
        map = new ArrayList<edge>();
    }

    public int find(int a) {
        int root = a;
        while (id[root] >= 0) {
            root = id[root];
        }
        int k = a, i;
        while (k != root) {
            i = id[k];
            id[k] = root;
            k = i;
        }
        return root;
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        int num = id[rootA] + id[rootB];
        if (id[rootA] < id[rootB]) {
            id[rootB] = rootA;
            id[rootA] = num;
        } else {
            id[rootA] = rootB;
            id[rootB] = num;
        }
    }

    public void getResult() {
        double avg = minV;
        double minResult = Double.MAX_VALUE;
        for (; avg <= maxV; avg = avg + 0.3) {  //此处是解决本题的关键，即枚举最小生成树的边权的均值
            for (int i = 0; i < map.size(); i++) {
                double v = map.get(i).v - avg;
                map.get(i).w = v * v;
            }
            Collections.sort(map, new MyComparator());
            id = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                id[i] = -1;
            }
            double sum = 0;
            double[] value = new double[n - 1];
            int count = 0;
            for (int i = 0; i < map.size(); i++) {
                int rootA = find(map.get(i).a);
                int rootB = find(map.get(i).b);
                if (rootA != rootB) {
                    union(map.get(i).a, map.get(i).b);
                    value[count++] = map.get(i).v;
                    sum += map.get(i).v;
                    if (count == n - 1) {
                        break;
                    }
                }
            }
            sum = sum / (n - 1);
            double temp = 0;
            for (int i = 0; i < value.length; i++) {
                temp = temp + (value[i] - sum) * (value[i] - sum);
            }
            temp = temp / (n - 1);
            if (minResult > temp) {
                minResult = temp;
            }
        }
        result.add(minResult);
    }


    public static void main(String[] args) {
        Main44 test = new Main44();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        test.init();
        for (int i = 1; i <= m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            double v = in.nextDouble();
            map.add(new edge(a, b, v));
            minV = Math.min(minV, v);
            maxV = Math.max(maxV, v);
        }
        test.getResult();

        for (int i = 0; i < result.size(); i++) {

            System.out.printf("%.2f", result.get(i));

        }
    }
}