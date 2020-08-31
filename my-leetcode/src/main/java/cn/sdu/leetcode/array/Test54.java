package cn.sdu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 54 螺旋矩阵
 *
 * @author icatzfd
 * Created on 2020/8/13 8:44.
 */
public class Test54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int up = 0;
        int down = row - 1;
        while (list.size() < row * col) {
            for (int j = left; j <= right; j++) {
                list.add(matrix[up][j]);
            }
            up++;
            if (up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }

            for (int j = right; j >= left; j--) {
                list.add(matrix[down][j]);
            }
            down--;
            if (down < up) {
                break;
            }

            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }

        }
        return list;
    }

    // 59 螺旋矩阵 2
    public  static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int count = 1;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = n - 1;
        while (count <= n * n) {
            for (int j = left; j <= right; j++) {
                nums[up][j] = count++;
            }
            up++;
            if (up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                nums[i][right] = count++;
            }
            right--;
            if (left > right) {
                break;
            }
            for(int j=right;j>=left;j--){
                nums[down][j]=count++;
            }
            down--;
            if(down<up){
                break;
            }
            for(int i=down;i>=up;i--){
                nums[i][left]=count++;
            }
            left++;
            if(left>right){
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
       // System.out.println(spiralOrder(nums));
        System.out.println(generateMatrix(3));
    }
}
