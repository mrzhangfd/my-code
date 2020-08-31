package cn.sdu;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.List;

/**
 * 贪心算法
 *
 * @author 张峰达
 * Created on 2020/4/20 12:29.
 */

public class GreedyThought  implements Externalizable {

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
    public  static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null || intervals.length==0 || intervals[0].length==0){
            return 0;
        }
        int ret = 0;
        Arrays.sort(intervals,(n1,n2)->{
            return n1[1]-n2[1];
        });
        int end=intervals[0][1];
        //至少有一个区间不相交
        int count=1;
        for (int[] interval : intervals) {
            if(interval[0]>=end){
                count++;
                end=interval[1];
            }
        }

        ret=intervals.length-count;
        System.out.println(ret);

        return ret;
    }

    public static void main(String[] args) {
        int[][] num={{1,2}};
        eraseOverlapIntervals(num);
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


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
