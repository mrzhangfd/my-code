package cn.sdu.icat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 张峰达
 * Created on 2020/5/2 16:52.
 */

public class Sorts {
    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        //p0表示数字0的最右边界下标
        int p0 = 0;
        //p2表示数字2的最左边界下标
        int p2 = nums.length - 1;
        int cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                swap(nums, p0, cur);
                p0++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, p2);
                p2--;
                //因为curr左边的值已经扫描过了，所以curr要++继续扫描下一位，而与p2交换的值，
                // curr未扫描，要停下来扫描一下，所以curr不用++
            } else {
                cur++;
            }
        }
        System.out.println("1");
    }


    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public int[] topKFrequent(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        //1 使用哈希表展示数组中的数字频率
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }
        //2 使用频率作为数组下标
        List<Integer>[] lists = new List[nums.length + 1];
        for (int key : hashMap.keySet()) {
            int i = hashMap.get(key);
            if (lists[i] == null) {
                lists[i] = new ArrayList<>();
            }
            lists[i].add(key);
        }

        // 3 根据数组下标，倒序输出频率前k大的数字
        for (int i = lists.length - 1; i > 0 && res.size() < k; i--) {
            if (lists[i] == null) {
                continue;
            }
            res.addAll(lists[i]);
        }

        //4 list 转int[]
        return res.stream().mapToInt(Integer::valueOf).toArray();

    }

    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        //1 使用hashmap 表示频率
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : chars) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }

        //2 使用频率作为数组下标
        List<Character>[] lists = new List[chars.length + 1];
        for (char key : hashMap.keySet()) {
            int i = hashMap.get(key);
            if (lists[i] == null) {
                lists[i] = new ArrayList<>();
            }
            lists[i].add(key);
            //错误写法
           /* if (lists[i] == null) {
                lists[i] = new ArrayList<>();
            }else {
                lists[i].add(key);
            }*/

        }
        StringBuilder res = new StringBuilder();
        //3 根据数组下标 倒序
        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] == null) {
                continue;
            }
            for (char c : lists[i]) {
                for (int j = 0; j < i; j++) {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 0, 2, 0, 0};
        Sorts sorts = new Sorts();
        String ss = "tree";
        sorts.frequencySort(ss);


        //sorts.sortColors(nums);
    }
}
