package cn.sdu.test.aiqiyi;

import java.util.*;

/**
 * 三数之和
 *
 * @author icatzfd
 * Created on 2020/9/13 15:56.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int n = arr.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        List<List<Integer>> res = threeSum(nums);
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int a1=o1.get(0);
                int a2=o1.get(1);
                int a3=o1.get(2);

                int b1=o2.get(0);
                int b2=o2.get(1);
                int b3=o2.get(2);
                if(a1==b1){
                    if(a2==b2){
                        return a3-b3;
                    }else {
                        return a2-b2;
                    }
                }else {
                    return a1-b1;
                }


            }
        });

        for(List<Integer> list:res){
            for(int i=0;i<list.size();i++){
                if(i!=list.size()-1){
                    System.out.print(list.get(i)+" ");
                }else {
                    System.out.print(list.get(i));
                }
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right && left < nums.length && right >= 0) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(Arrays.asList(nums[left], nums[right], nums[i]));
                    Collections.sort(temp);
                    res.add(temp);
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    left++;
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;

                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
