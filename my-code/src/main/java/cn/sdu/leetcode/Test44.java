package cn.sdu.leetcode;

/**
 * @author icatzfd
 * Created on 2020/6/20 9:28.
 */
public class Test44 {

    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1){
            return;
        }

        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){

                reverse(nums,i,nums.length-1);
                for(int j=i;j<=nums.length-1;j++){
                    if(nums[j]>nums[i-1]){
                        swap(i-1,j,nums);
                        return;
                    }
                }
            }
        }

        reverse(nums,0,nums.length-1);
        return;
    }

    private void swap(int i,int j,int[] nums){
        int  temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

    }

    private void reverse(int[] nums,int i,int j){
        while(i<=j){
            swap(i,j,nums);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3};
        Test44 test44=new Test44();
        test44.nextPermutation(arr);

    }
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        assert s != null;
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if(s.charAt(i)==' '){
                return true;
            }
        }
        return false;
    }
}
