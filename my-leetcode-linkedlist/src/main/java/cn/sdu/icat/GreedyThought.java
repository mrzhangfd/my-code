package cn.sdu.icat;

import java.util.Arrays;
import java.util.List;

/**
 * 贪心算法
 *
 * @author 张峰达
 * Created on 2020/4/20 12:29.
 */

public class GreedyThought {

    //455. 分发饼干
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return si;
    }

    //435. 无重叠区间
    public int eraseOverlapIntervals(int[][] intervals) {
        int ret = 0;
        for (int[] array : intervals) {

        }
        return ret;
    }

    public boolean isSubsequence(String s, String t) {
        char[] sChars=s.toCharArray();
        char[] tChars=t.toCharArray();
        int i=0,j=0;
        while (i<=sChars.length-1 && j<=tChars.length-1){
            if(sChars[i]==tChars[j]){
                i++;
            }
            j++;

        }
        if(i<=sChars.length-1 && j>tChars.length-1){
            return false;
        }
        return true;
    }


}
