package cn.sdu.leetcode.bit;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字3
 *
 * @author icatzfd
 * Created on 2020/7/29 10:09.
 */
public class Test260 {
    public static int[] singleNumber(int[] nums) {
        int[] res=new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        int idx=0;
        for (int n : map.keySet()) {
            if(map.get(n)==1){
                res[idx++]=n;
            }
        }
        System.out.println(map.values());
        return Arrays.copyOf(res,idx-1);
    }

    public static void main(String[] args) {
        int[] nums={1,2,1,3,2,5};
        singleNumber(nums);
    }
}
