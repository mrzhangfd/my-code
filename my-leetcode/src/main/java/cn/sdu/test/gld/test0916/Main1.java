package cn.sdu.test.gld.test0916;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 种草
 *
 * @author icatzfd
 * Created on 2020/9/16 20:44.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }
        while (m > 0) {
            int temp=queue.poll();
            temp+=x;
            queue.add(temp);
            m--;
        }
        int ans = 0;
        ans=queue.peek();
        System.out.println(ans);
    }
}

