package cn.sdu.leetcode.string;

import org.opencv.core.Mat;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串
 *
 * @author icatzfd
 * Created on 2020/9/10 10:16.
 */
public class Solution {
    //3. 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch), start);
            }
            res = Math.max(res, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return res;
    }
}
