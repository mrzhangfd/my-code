package cn.sdu.test.wangyihuyu;

import java.util.Scanner;

public class Main22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] nums = new int[size][size];
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        while (size > 0) {
            result = resulted2(size, nums);
            nums = delete(nums, result, size);
            size = size - 1;
        }

    }

    //计算某行之和
    public static int row(int a, int[][] num, int rowNum) {
        int row = 0;
        for (int k = 0; k < a; k++) {
            row = num[rowNum][k] + row;
        }
        return row;
    }

    //计算某列之和
    public static int col(int a, int[][] num, int colNum) {
        int col = 0;
        for (int k = 0; k < a; k++) {
            col = num[k][colNum] + col;
        }
        return col;
    }

    public static int[][] total(int a, int[][] nums) {

        int[][] center = new int[2][a];
        for (int k = 0; k < a; k++) {
            center[0][k] = row(a, nums, k);
            center[1][k] = col(a, nums, k);
        }
        return center;
    }

    public static int[][] resulted2(int size, int[][] nums) {
        int[][] center = total(size, nums);
        int max = 0;
        int[][] temped = new int[size][size];
        int[][] result = new int[1][2];
        for (int n = 0; n < size; n++) {
            int totaltemp = 0;
            int temp = center[0][n];
            for (int m = 0; m < size; m++) {
                totaltemp = temp + center[1][m] - nums[n][m];

                if (totaltemp > max) {
                    result[0][0] = n;
                    result[0][1] = m;
                    max = totaltemp;
                }
            }
        }
        System.out.println((result[0][0] + 1) + " " + (result[0][1] + 1));
        return result;
    }

    public static int[][] delete(int[][] nums, int[][] result, int size) {

        int[][] temp = new int[size - 1][size - 1];
        int p = 0;
        for (int i = 0; i < size; ++i) {
            if (i == result[0][0]) {
                continue;
            }
            int q = 0;
            for (int j = 0; j < size; ++j) {
                if (j == result[0][1]) {
                    continue;
                }
                temp[p][q] = nums[i][j];
                ++q;
            }
            ++p;
        }
        return temp;
    }
}
