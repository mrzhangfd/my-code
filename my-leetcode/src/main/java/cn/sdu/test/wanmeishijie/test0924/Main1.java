package cn.sdu.test.wanmeishijie.test0924;

import java.util.*;

/**
 * 天际线问题
 * leetcode 218
 * @author icatzfd
 * Created on 2020/9/24 19:39.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //建筑物个数
        int n = Integer.parseInt(sc.nextLine());
        int[][] buildings = new int[n][3];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            for (int j = 0; j < arr.length; j++) {
                buildings[i][j] = Integer.parseInt(arr[j]);
            }
        }

        List<List<Integer>> skyline = getSkyline(buildings);

        //输出skyline到标准输出
        for (List<Integer> point : skyline) {
            int size = point.size();
            for (int i = 0; i < size; i++) {
                System.out.print(point.get(i));
                if (i < size-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> res = new ArrayList<>();
        List<int[]> h = new ArrayList<>();

        for(int[] building:buildings){
            h.add(new int[]{building[0],-building[2]});
            h.add(new int[]{building[1],building[2]});
        }

        Collections.sort(h,(a, b)->{
            if(a[0]!=b[0]) {
                return a[0]-b[0];
            } else {
                return a[1]-b[1];
            }
        });

        Queue<Integer> queue = new PriorityQueue<Integer>(11,(a, b)->b-a);
        queue.offer(0);

        int prev = 0;

        for(int[] tmpH:h){
            if(tmpH[1]<0){
                queue.offer(-tmpH[1]);
            }else{
                queue.remove(tmpH[1]);
            }
            int cur = queue.peek();

            if(prev != cur){
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(tmpH[0]);
                integers.add(cur);
                res.add(integers);
                prev = cur;
            }
        }
        return res;
    }
}
