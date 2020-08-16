package cn.sdu.leetcode.array;

import java.util.Arrays;

/**
 * 接雨水
 *
 * @author icatzfd
 * Created on 2020/8/9 15:24.
 */
public class Test42 {

    //自己的解法：按行求，但是超时了。
    public static int trap(int[] height) {
        if (height == null || height.length == 1) {
            return 0;
        }
        int max = height[0];
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
        }
        //表示层数
        int level = 0;

        //表示结果
        int res = 0;
        int[] temp = Arrays.copyOf(height, height.length);
        while (level < max) {

            for (int i = 0; i < height.length; i++) {
                height[i] = temp[i] - level;
            }
            //左右不为0 的边界
            int left = -1;
            int right = -1;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > 0) {
                    left = i;
                    break;
                }
            }
            for (int j = height.length - 1; j >= 0; j--) {
                if (height[j] > 0) {
                    right = j;
                    break;
                }
            }
            if (left < right) {
                for (int i = left; i <= right; i++) {
                    if (height[i] <= 0) {
                        res++;
                    }
                }
            }

            level++;
        }
        return res;
    }

    //题解解法：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
    //按列求每一列的水，我们只需要关注当前列，以及左边最高的墙，右边最高的墙就够了。
    //装水的多少，当然根据木桶效应，我们只需要看左边最高的墙和右边最高的墙中较矮的一个就够了。
    //
    //作者：windliang
    //链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static int trap1(int[] height) {
        if (height == null || height.length == 1) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = i;
            //找出左边最高
            for (int j = 0; j < i; j++) {
                if (height[j] > height[maxLeft]) {
                    maxLeft = j;
                }
            }

            //找出右边最高
            int maxRight = i;
            for (int j = i; j <= height.length - 1; j++) {
                if (height[j] > height[maxRight]) {
                    maxRight = j;
                }
            }

            //当且仅当 左右两边最高 均大于当前列时，当前列才会积水
            if (height[maxLeft] > height[i] && height[maxRight] > height[i]) {
                res += Math.min(height[maxLeft], height[maxRight]) - height[i];
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(nums));
    }
}
