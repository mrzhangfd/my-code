package cn.sdu.gld;

import java.util.*;

/**
 * @author icatzfd
 * Created on 2020/7/29 19:33.
 */
public class Main1 {
    // 第一题优先队列，第二题不管是不是最小值重复就改第二个重复的值，
    // 第一个重复值改成0，就都ok了，第三题不会
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        boolean flag = false;
        int idx = 0;
        int count = 0;
        while (count != nums.length - idx - 1) {
            idx = 0;
            count = 0;

            for(int i=0;i< nums.length-1;i++){
                for(int j=i+1;j< nums.length;j++){
                    if(nums[i]==nums[j]){
                        nums[j]=2*nums[i];
                        nums[i]=0;
                    }
                }
            }
            Arrays.sort(nums);
            while (nums[idx] == 0) {
                idx++;
            }

            for (int i = idx; i < nums.length - 1; i++) {

                if (nums[i] == nums[i + 1]) {
                    nums[i + 1] = 2 * nums[i];
                    nums[i] = 0;
                } else if (nums[i] != nums[i + 1]) {
                    count++;
                }
            }

        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i));
        }
        System.out.print(list.get(list.size() - 1));

    }

    class test{
        public  void test(){
            Scanner input=new Scanner(System.in);
            int n=input.nextInt();
            int arr[]=new int[n];
            HashMap<Integer, Integer> contentToIndex = new HashMap<>();
            for(int i=0;i<n;i++){
                int cur=input.nextInt();
                while (contentToIndex.containsKey(cur)){
                    Integer index = contentToIndex.get(cur);
                    arr[index]=0;
                    contentToIndex.remove(cur);
                    cur=2*cur;
                }
                arr[i]=cur;
                contentToIndex.put(cur,i);
            }

            for(int i=0;i<n;i++ ){
                if(arr[i]!=0){
                    System.out.print(arr[i]+" ");
                }

            }
        }
    }
}
