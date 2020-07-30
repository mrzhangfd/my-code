package cn.sdu.gld;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 广联达笔试7.29
 *
 * @author icatzfd
 * Created on 2020/7/29 14:06.
 */
public class Solution {

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
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] res = new int[n];
        int minIdx = findMin(nums);
        while (m > 0) {
            int idx = findMin(nums);
            nums[idx] += x;
            res[idx] += x;
            m--;
        }
        int ans=0;
        ans=res[minIdx]+ nums[minIdx];




        /*long[][] monster = new long[n][2];
        for (int i = 0; i < n; i++) {
            monster[i][0] = sc.nextInt();
            monster[i][1] = sc.nextInt();
        }
        Arrays.sort(monster, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int) (o1[0] - o2[0]);
            }
        });*/

    }
}
