package cn.sdu.gld;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * gld
 *
 * @author icatzfd
 * Created on 2020/7/29 19:12.
 */
public class Main {

    private static int findMin(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextByte();
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }
        int[] res = new int[n];
        while (m > 0) {

            int temp=queue.poll();
            temp+=x;
            queue.add(temp);
            m--;
        }
        int ans = 0;
        ans=queue.peek();
      //  ans = min + res[minIdx];
        System.out.println(ans);
    }
}
