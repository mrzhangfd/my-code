package cn.sdu.zhongxing;

import java.util.*;

/**
 * 图的价值
 *
 * @author icatzfd
 * Created on 2020/8/15 10:46.
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[m][2];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
            if (map.containsKey(nums[i][0])) {
                Set<Integer> set = map.get(nums[i][0]);
                set.add(nums[i][1]);
                map.put(nums[i][0], set);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(nums[i][1]);
                map.put(nums[i][0], set);
            }

            if (map.containsKey(nums[i][1])) {
                Set<Integer> set = map.get(nums[i][1]);
                set.add(nums[i][0]);
                map.put(nums[i][1], set);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(nums[i][0]);
                map.put(nums[i][1], set);
            }
        }


        Map<Set<Integer>, Integer> res = new HashMap<>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (res.containsKey(entry.getValue())) {
                res.put(entry.getValue(), res.get(entry.getValue()) + 1);
            } else {
                res.put(entry.getValue(), 1);
            }
        }
        int count=0;
        for(Set<Integer> set:res.keySet()){
            count+=res.get(set);
        }
        System.out.println(count/2);
    }

    public static boolean equals(Set<Integer> s1, Set<Integer> s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.size() != s2.size()) {
            return false;
        }

        return s1.containsAll(s2);
    }
}
