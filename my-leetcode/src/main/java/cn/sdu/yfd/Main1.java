package cn.sdu.yfd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 猿辅导第一题
 *
 * @author icatzfd
 * Created on 2020/8/1 18:59.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] time=new int[1000000];
        int max=1;
        for(int[] num:nums){
            for(int j=num[0];j<num[1];j++){
                time[j]++;
                if (time[j] > max) {
                    max = time[j];
                }
            }
        }
        System.out.println(max);
      /*  for (int i = 0; i < n; i++) {
            for (int[] num : nums) {
                if (idx == -1 || num[0] > ans[idx][1]) {
                    ans[++idx] = num;
                } else {
                    ans[idx][1] = Math.max(ans[idx][1], num[1]);
                }
            }
        }
*/

        //return Arrays.copyOf(ans, idx + 1);

    }
}
