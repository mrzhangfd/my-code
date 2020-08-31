package cn.sdu.test.wanmeishijie;

import java.util.Scanner;

/**
 * 图的最短路径
 *
 * @author icatzfd
 * Created on 2020/8/25 20:50.
 */
public class Main2 {
    public static void main(String[] args) {
        int[][] weight = new int[6][];

        String[] pointsStr = { "V1", "V2", "V3", "V4", "V5","V6"};
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < pointsStr.length; i++) {
            String[] valuesStr = input.nextLine().split(" ");
            int[] values = new int[valuesStr.length];
            for (int j = 0; j < valuesStr.length; j++) {
                values[j] = Integer.parseInt(valuesStr[j]);
            }
            weight[i] = values;
        }
        input.close();

        method(weight, pointsStr);
    }

    private static void method(int[][] weight, String[] pointsStr) {
        
    }
}
