package cn.sdu.test;

import java.util.Arrays;
import java.util.*;
import java.math.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m=scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }



        int[] res = findMaxRightWithStack(array);
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(res[i]);
            } else {
                System.out.print(res[i] + " ");
            }

        }
    }

    public static int[] findMaxRightWithStack(int[] array) {
        if (array == null) {
            return array;
        }
        int size = array.length;
        int[] result = new int[size];
        Arrays.fill(result,-1);
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[j] > array[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }

        return result;
    }
}
