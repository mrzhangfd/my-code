package cn.sdu.test.cao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 合并升序数组
 *
 * @author icatzfd
 * Created on 2020/9/11 18:26.
 */
public class Main24 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String str=bufferedReader.readLine();
        System.out.println(str);
       /* Scanner sc = new Scanner(System.in);
        int[][] nums = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<3;i++){
            nums=rotate(nums);
        }
        System.out.println(Arrays.deepToString(nums));*/
    }

    public static int[][] rotate(int[][] matrix) {
        int n = 4;
        int[][] temp = new int[n][n];
        int dst = 3;
        for (int i = 0; i < n; i++, dst--) {
            for (int j = 0; j < n; j++) {
                temp[j][dst] = matrix[i][j];
            }
        }
        matrix=Arrays.copyOf(temp,4);
        return matrix;
    }
}
