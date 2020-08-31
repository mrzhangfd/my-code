package cn.sdu.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原ip地址
 *
 * @author icatzfd
 * Created on 2020/7/31 19:37.
 */
public class Test93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s, res, list, 0, 0);
        return res;
    }

    private void helper(String s, List<String> res, List<String> list, int num, int cur) {
        if (list.size() > 4) {
            return;
        }
        if (num == 4 && cur == s.length()) {
            res.add(String.join(".", list));
        }
        for (int i = cur; i < cur + 3 && i < s.length(); i++) {
            String ss = s.substring(cur, i + 1);
            if (legal(ss)) {
                list.add(ss);
                helper(s, res, list, num + 1, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean legal(String ss) {
        if (ss.charAt(0) == '0' && ss.length() != 1) {
            return false;
        }

        if (Integer.parseInt(ss) <= 255 && Integer.parseInt(ss) >= 0) {
            return true;
        }
        return false;

    }

    //复原ip 二刷
    public static List<String> restoreIpAddresses1(String s) {
        List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper1(s, list, res, 0);
        return res;
    }

    private static void helper1(String s, List<String> list, List<String> res, int start) {
        if (list.size() > 4) {
            return;
        }
        if (start == s.length() && list.size() == 4) {
            String temp = String.join(".", list);
            res.add(temp);
        }
        for (int i = start; i < start + 3 && i < s.length(); i++) {
            String temp = s.substring(start, i + 1);
            if (legal(temp)) {
                list.add(temp);
                helper1(s, list, res, i + 1);
                list.remove(list.size() - 1);
            }

        }

    }

    //复原ip 3刷
    public static List<String> restoreIpAddresses2(String s) {
        List<String> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();

        helper2(res,temp,0,0,s);
        return res;
    }

    private static void helper2(List<String> res, List<String> temp, int start, int count, String s) {
        if(temp.size()>4){
            return;
        }
        if(count==4 && start==s.length()){
            String ss=String.join(".",temp);
            res.add( ss);
        }

        for(int i=start;i<s.length()&& i<=start+3;i++){
            String str=s.substring(start,i+1);
            if(legal(str)){
                temp.add(str);
                helper2(res,temp,i+1,count+1,s);
                temp.remove(temp.size()-1);
            }

        }
    }

    public static void main(String[] args) {
        String s = "25525511135";

        System.out.println(restoreIpAddresses2(s));
    }
}
