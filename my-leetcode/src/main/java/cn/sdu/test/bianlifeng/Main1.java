package cn.sdu.test.bianlifeng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 查找app更新的依赖  73%
 *
 * @author icatzfd
 * Created on 2020/10/10 20:11.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        int num=scanner.nextInt();
        int[] nums=new int[26];
        Arrays.fill(nums,-1);
        String[] temps=new String[num];
        for(int i=0;i<num;i++){
            temps[i]=scanner.next();

        }
        for(int i=0;i<num;i++){

            String[] strings=temps[i].split("->");
            char ch1=strings[0].charAt(0);
            char ch2=strings[1].charAt(0);
            nums[ch1-'A']=ch2-'A';
        }
        int res=0;

        int curIdx=str.charAt(0)-'A';
        int start=curIdx;
        while (nums[curIdx]!=-1 && nums[curIdx]!=start ){
            curIdx=nums[curIdx];
            res++;
        }
        System.out.println(res);
    }
}
