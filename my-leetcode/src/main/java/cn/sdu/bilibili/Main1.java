package cn.sdu.bilibili;

/**
 * 算24点
 *
 * @author icatzfd
 * Created on 2020/8/13 19:26.
 */
public class Main1 {
    /**
     * @param arr int整型一维数组
     * @return bool布尔型
     */
    public boolean Game24Points(int[] arr) {
        if (arr == null || arr.length < 4) {
            return false;
        }
        char[] singal = {'+', '-', '*', '/'};
        return true;

        // write code here
    }

    private static boolean cheackF(int[] arr, int i, double res) {
        if (i == 4) {
            if (res == 24) {
                return true;

            } else {
                return false;
            }
        }


        return cheackF(arr, i + 1, res + arr[i]) | cheackF(arr, i + 1, res - arr[i]) | cheackF(arr, i + 1, res / arr[i]) | cheackF(arr, i + 1, res * arr[i]);

    }


    boolean result = false;

    public boolean Game24Points1(int[] arr) {

        if (arr == null || arr.length < 4) {
            return false;
        }
        helper(arr, 1, arr[0]);
        return result;
    }

    public void helper(int[] arr, int index, int res) {
        if (index >= arr.length) {
            if (res == 24) {
                result = true;

            }
            return;
        }
        helper(arr, index + 1, res + arr[index]);
        helper(arr, index + 1, res - arr[index]);
        helper(arr, index + 1, res * arr[index]);
        if (arr[index] != 0) {
            helper(arr, index + 1, res / arr[index]);
        }

    }
}
