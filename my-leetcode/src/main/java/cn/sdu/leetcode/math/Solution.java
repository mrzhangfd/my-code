package cn.sdu.leetcode.math;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 数学类
 *
 * @author icatzfd
 * Created on 2020/9/14 16:41.
 */
public class Solution {
    //949. 给定数字能组成的最大时间
    public String largestTimeFromDigits(int[] arr) {
        Arrays.sort(arr);
        int a = -1;
        int b = -1;
        int c = -1;
        int d = -1;

        List<Integer> list = CollectionUtils.arrayToList(arr);

        for (int i = 2; i >= 0; i--) {
            if (list.contains(i)) {
                a = i;
                break;
            }
        }
        list.remove(a);
        return null;
    }
}
