package cn.sdu.test.qihu360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 魔塔闯关
 *
 * @author icatzfd
 * Created on 2020/8/24 14:26.
 */
public class Main5 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] nums=new int[n][2];
        int res=0;
        for(int i=0;i<n;i++){
            nums[i][0]=sc.nextInt();
            nums[i][1]=sc.nextInt();
            if(nums[i][1]==0){
                res+=nums[i][0];
            }
        }

        Arrays.sort(nums,(n1,n2)->{
            return n2[0]-n1[0];
        });


        for(int[] num:nums){
            System.out.println(num[0]);
            if(num[1]!=0) {
                if (num[0] > res) {
                    res += num[0];
                } else {
                    res *= 2;
                }
            }
        }
        System.out.println(res);
    }
}
