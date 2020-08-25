package cn.sdu.test.bytedance;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 无根树
 *
 * @author icatzfd
 * Created on 2020/8/23 10:19.
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int size=0;
            int n = scanner.nextInt();
            int[][] nums = new int[n][2];
            for (int j = 0; j < n; j++) {
                nums[j][0] = scanner.nextInt();
                nums[j][1] = scanner.nextInt();
            }
            Arrays.sort(nums, (n1, n2) -> {
                return n1[0] - n2[0];
            });
            for (int j = 0; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if(nums[k][0] > nums[j][1]){
                        break;
                    }
                    if (  nums[k][1] < nums[j][1]) {
                    } else {
                       size++;
                    }
                }
            }
            if(size==n-1){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
