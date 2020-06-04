package cn.sdu.icat;

import java.util.ArrayList;

/**
 * 数组和矩阵
 *
 * @author 张峰达
 * Created on 2020/4/27 15:01.
 */

public class ArraysandMatrices {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null) {
            return nums;
        }
        int rr = nums.length;
        int cc = nums[0].length;
        if (r * c > rr * cc) {
            return nums;
        }
        int[] list = new int[c * r];
        int index = 0;
        int[][] newnums = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                list[index++] = nums[i][j];
            }
        }
        index = 0;
        for (int i = 0; i < newnums.length; i++) {
            for (int j = 0; j < newnums[0].length; j++) {
                newnums[i][j] = list[index];
                index++;
            }
        }
        return newnums;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int i = 0;
        int j = 0;
        int tmp = 0;
        while (j < nums.length) {
            if (nums[j] == 1) {
                tmp = j - i + 1;
                j++;
            } else {
                i = j + 1;
                j++;
            }
            max = Math.max(tmp, max);
        }

        return max;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int i = 0, j = c-1;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return false;
        }
        while (i < r && j>=0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            }else {
                j--;
            }
        }
        return false;

    }



    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        ArraysandMatrices arraysandMatrices = new ArraysandMatrices();
        arraysandMatrices.findMaxConsecutiveOnes(nums);
    }
}
