package cn.sdu.test.shangtang;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 无重叠区间调度问题
 *
 * @author icatzfd
 * Created on 2020/8/20 20:32.
 */
public class Main3 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        // write code here
        if(intervals.length==0){
            return 0;
        }
        return intervals.length-helper(intervals);
    }

    private static int helper(int[][] intervals) {

/*        Arrays.sort(intervals,(a,b)->{
            return a[1]-b[1];
        });*/

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int count=1;

        int xend=intervals[0][1];
        for(int[] interval:intervals){
            int start=interval[0];
            if(start>=xend){
                count++;
                xend=interval[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] intervals=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                intervals[i][j]=sc.nextInt();
            }
        }
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
