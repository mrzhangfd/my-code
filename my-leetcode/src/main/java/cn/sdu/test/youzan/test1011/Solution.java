package cn.sdu.test.youzan.test1011;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author icatzfd
 * Created on 2020/10/11 19:32.
 */
public class Solution {
    /**
     * leetcode 1363 形成三的最大倍数
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param digits int整型ArrayList
     * @return string字符串
     */
    public String largestMultipleOfThree(ArrayList<Integer> digits) {
        // write code here
        int[] arr = new int[10];

        int sum = 0;
        for (int digit : digits) {
            sum += digit;

            arr[digit]++;
        }
        sum %= 3;

        int n1 = arr[1] + arr[4] + arr[7];
        int n2 = arr[2] + arr[5] + arr[8];
        if (sum == 1) {
            if (n1 > 0) {
                n1--;
            } else {
                n2 -= 2;
            }
        } else if (sum == 2) {
            if (n2 > 0) {
                n2--;
            } else {
                n1 -= 2;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 9; i >= 0; i--) {

            if (i % 3 == 1) {
                while (n1 > 0 && arr[i] > 0) {
                    n1--;
                    arr[i]--;
                    stringBuilder.append(i);
                }

            } else if (i % 3 == 2) {

                while (n2 > 0 && arr[i] > 0) {
                    n2--;
                    arr[i]--;
                    stringBuilder.append(i);
                }
            } else {

                while (arr[i] > 0) {
                    arr[i]--;
                    stringBuilder.append(i);
                }
            }
        }
        if(stringBuilder.length() > 0 && stringBuilder.charAt(0) == '0'){
            return "0";
        }else {
           return stringBuilder.toString();
        }
    }

    /**
     * leetcode 888 公平的糖果交换
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param A int整型一维数组
     * @param B int整型一维数组
     * @return int整型一维数组
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        // write code here
        int sumA = 0;
        int sumB = 0;
        for (int a : A) {
            sumA += a;
        }
        for (int b : B) {
            sumB += b;
        }
        int temp = (sumA - sumB) / 2;
        List<Integer> setB = new ArrayList<>();
        for (int b : B) {
            setB.add(b);
        }
        for (int a : A) {
            if (setB.contains(a + temp)) {
                return new int[]{a, a + temp};
            }
        }
        return null;
    }
}
