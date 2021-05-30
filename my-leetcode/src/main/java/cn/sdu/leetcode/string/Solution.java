package cn.sdu.leetcode.string;


import java.util.*;

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

    //49 字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();

        for(String str:strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String key=String.valueOf(chars);

            if(map.containsKey(key)){
                List<String> temp=map.get(key);
                temp.add(str);
                map.put(key,temp);
            }else {
                List<String> temp=new ArrayList<>();
                temp.add(str);
                map.put(key,temp);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

    }
}
