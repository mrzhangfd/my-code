package cn.sdu.test.sico;

import java.util.Scanner;

/**
 * 跳跃游戏 leetcode 55
 *
 * @author icatzfd
 * Created on 2020/9/7 20:25.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        str = str.substring(1, len - 1);

        String[] strings = str.split(",");
        int length= strings.length;
        int[] nums=new int[length];

        for(int i=0;i<length;i++){
            nums[i]=Integer.parseInt(strings[i]);
        }
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i<=rightMost){
                rightMost=Math.max(rightMost,i+nums[i]);
                if(rightMost>= nums.length-1){
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);

    }
}
