package cn.sdu.test.aiqiyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 数组中多于二分之一数组长度的数
 *
 * @author icatzfd
 * Created on 2020/9/13 15:46.
 */
public class Main2 {

    public static int majorityElement(int[] nums) {
        int flag = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                flag = nums[i];
                sum++;
            } else {
                if (nums[i] != flag) {
                    sum--;
                } else {
                    sum++;
                }
            }
        }

        return flag;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.next().split(" ");
        int n = arr.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for(int num:map.keySet()){
            if(map.get(num)>n/2){
                System.out.println(num);
                return;
            }
        }
        System.out.println(majorityElement(nums));

    }

}
