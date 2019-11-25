package cn.sdu.icat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 12、整数转罗马数字
 *
 * @author 张峰达
 * Created on 2019/11/5 23:09.
 */

public class Test12 {

    public List<String> letterCombinations(String digits) {
        Map<String,String> map=new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");

        for(int i=0;i<digits.length();i++){
            return null;
        }
        return null;
    }
    public String intToRoman(int num) {
        int q,b,s,g;
        q=num/1000;
        b=num-num*100;

        return null;
    }
}
