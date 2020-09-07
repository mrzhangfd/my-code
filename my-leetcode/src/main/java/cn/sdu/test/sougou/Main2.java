package cn.sdu.test.sougou;

import java.util.Arrays;

/**
 * @author icatzfd
 * Created on 2020/9/5 18:40.
 */
public class Main2 {

    //小镇新房
    public static int getHouses(int t, int[] xa) {
        int len = xa.length;
        float[][] nums = new float[len / 2][2];
        int idx = -1;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                idx++;
                nums[idx][0] = xa[i] - (float) xa[i + 1] / 2;
                nums[idx][1] = xa[i] + (float) xa[i + 1] / 2;

            }
        }
        int res = 0;
        for (int i = 0; i < idx; i++) {
            float sub = nums[i + 1][0] - nums[i][1];
            if (sub >= t) {
                if (sub == t) {
                    res++;
                } else {
                    res += 2;
                }
            }
        }
        return res + 2;

    }

    //奖品
    public static int numberofprize(int a, int b, int c) {

        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        int avgg = arr[0] + ((arr[1] - arr[0] + arr[2] - arr[0])) / 3;
        int i = avgg;
        for (; i >= 0; i--) {
            int j = 2;
            long tmpA = 0, tmpB = 0;

            for (; arr[j] > avgg; j--) {
                tmpA += arr[j] - i;
            }
            for (; j >= 0; j--) {
                tmpB += i - arr[j];
            }
            if (tmpA >= 2 * tmpB)
                break;
        }
        return  i;
    }

    public static void main(String[] args) {
        int[] ax = {-1, 4, 5, 2};
        System.out.println(numberofprize(1000,1000,1000));
    }
}





