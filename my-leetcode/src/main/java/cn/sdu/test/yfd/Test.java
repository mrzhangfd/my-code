package cn.sdu.test.yfd;

import java.util.Scanner;

/**
 * 猿辅导的 逆时针打印矩阵
 *
 * @author icatzfd
 * Created on 2020/7/30 9:05.
 */
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int count = 0;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            count++;
            sum += nums[i];
            if (sum > s) {
                if (count - 1 > res) {
                    res = count - 1;
                }
                sum = 0;
                count = 0;
            }
        }
        res=Math.max(res,count);
        System.out.println(res);
    }
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cols = sc.nextInt();
        int rows = sc.nextInt();
        int[][] nums = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        int left = 0;
        int right = rows - 1;
        int up = 0;
        int down = cols - 1;

        List<Integer> list = new ArrayList<>();
        while (list.size() <= cols * rows) {
            for (int i = up; i <= down; i++) {
                list.add(nums[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
            for (int j = left; j <= right; j++) {
                list.add(nums[down][j]);
            }
            down--;
            if (down < up) {
                break;
            }

            for (int i = down; i >= up; i--) {
                list.add(nums[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            for (int j = right; j >= left; j--) {
                list.add(nums[up][j]);
            }
            up++;
            if (up > down) {
                break;
            }

        }
        for(int n:list){
            System.out.print(n+" ");
        }
    }*/
}
