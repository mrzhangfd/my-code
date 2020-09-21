package cn.sdu.test.vivo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author icatzfd
 * Created on 2020/9/12 20:04.
 */
public class Solution {

    //编译依赖问题
    public  static String compileSeq(String input) {

        String[] strings = input.split(",");
        int n = strings.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == -1) {

                nums[i] = n + 1;
                res.add(i);
                break;
            }
        }
        int count = 0;
        while (count < n - 1) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == -1 || res.contains(nums[i])) {
                    res.add(i);
                    nums[i] = n + 1;
                    count++;
                    break;
                }
            }

        }
        for (int j = 0; j < res.size(); j++) {
            if (j != res.size() - 1) {
                stringBuilder.append(res.get(j)).append(",");
            } else {
                stringBuilder.append(res.get(j));
            }
        }
       return stringBuilder.toString();

    }

    public static void main(String[] args) {
        String str="1,2,-1,1";
        System.out.println(compileSeq(str));
    }
}
