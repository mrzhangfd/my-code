package cn.sdu.icat;

import java.util.HashMap;
import java.util.Map;

/**
 * 3.无重复字符的最长子串
 *
 * @author 张峰达
 * Created on 2019/11/3 0:33.
 */

public class Test3 {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1){
            return 1;
        }
        int start, end;
        int ans = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (start = 0, end = 0; end <s.length(); end++) {
            char ch=s.charAt(end);
            if (charMap.containsKey(ch)) {
                start = Math.max(end+1,charMap.get(ch));
            }
            ans=Math.max(end-start+1,ans);
            charMap.put(s.charAt(end), end+1);

        }
        return ans;
    }

    public static void main(String[] args) {
        String s = " ";
//        Map<Character, Integer> charMap = new HashMap<>();
//        charMap.put(s.charAt(0),1);
//        System.out.println(charMap.toString());
        //System.out.println(s.length());
        Test3 test3 = new Test3();
        System.out.println(test3.lengthOfLongestSubstring(s));
    }
}
