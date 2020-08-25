package cn.sdu.test.bilibili;

/**
 * 找零
 *
 * @author icatzfd
 * Created on 2020/8/13 19:30.
 */
public class Main3 {
    /**
     * @param N int整型
     * @return int整型
     */
    public int GetCoinCount(int N) {

        // write code here
        int num = 1024 - N;
        int res = 0;
        int[] coins = {1, 4, 16, 64};
        for (int i = coins.length - 1; i >= 0; i--) {
            if (num == 0) {
                break;
            }
            res += num / coins[i];
            num = num % coins[i];
        }
        return res;
    }
}
