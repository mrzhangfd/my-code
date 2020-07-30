package cn.sdu.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 合并区间
 *
 * @author icatzfd
 * Created on 2020/7/24 15:03.
 */
public class Test56 {
    //合并区间
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }
        int rows = intervals.length;

        int[][] ans = new int[rows][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int idx = -1;
        int i = 0;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > ans[idx][1]) {
                ans[++idx] = interval;
            }
            else {
                ans[idx][1]=Math.max(ans[idx][1],interval[1]);
            }
        }
        return Arrays.copyOf(ans,idx+1);

    }

    public boolean wordPattern(String pattern, String str) {
        if(str==null ||pattern==null){
            return false;
        }
        String[] words=str.split(" ");
        HashMap<Character,String> map1=new HashMap<>();
        HashMap<String ,Character> map2=new HashMap<>();

        int len1=pattern.length();
        int len2=words.length;
        if(len1!=len2){
            return false;
        }
        for(int i=0;i<len1;i++){
            if(map1.get(pattern.charAt(i))==null){
                map1.put(pattern.charAt(i),words[i]);
            }else{
                if(!map1.get(pattern.charAt(i)).equals(words[i])){
                    return false;
                }
            }
        }

        for(int i=0;i<len2;i++){
            if(map2.get(words[i])==null){
                map2.put(words[i],pattern.charAt(i));
            }else{
                if(!map2.get(words[i]).equals(pattern.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
       int[][] nums={{1,3},{2,6},{8,10},{15,18}} ;
        Test56 test56=new Test56();
       // System.out.println(test56.merge(nums));
        for(int[] res:test56.merge(nums)){
            System.out.println(res[0]);
            System.out.println(res[1]);
            System.out.println("===========");
        }

        String p="abba";
        String s="dog cat cat dog";
        System.out.println(test56.wordPattern(p,s));

        Map<String,String> map=new HashMap<>();
        String ss="111";




    }

}
