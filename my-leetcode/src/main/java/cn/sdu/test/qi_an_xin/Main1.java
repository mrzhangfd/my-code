package cn.sdu.test.qi_an_xin;

import cn.sdu.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1、爬楼梯
 * 2、 拆迁分房子
 *
 * @author icatzfd
 * Created on 2020/9/2 15:39.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 36 || n <= 0) {
            System.out.println(0);
            return;
        }
        int a = 1;
        int b = 2;
        if (n <= 2) {
            System.out.println(n);
            return;
        }
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;

        }
        System.out.println(c);
    }

    /**
     * 2、 拆迁分房子
     *
     * @param person int整型一维数组
     * @return int整型
     */
    public int house(int[] person) {
        int n = person.length;
        int minIdx = 0;
        for (int i = 0; i < n; i++) {
            if (person[i] < person[minIdx]) {
                minIdx = i;
            }
        }
        int[] nums = new int[n];
        nums[minIdx] = 1;
        for (int i = minIdx + 1; i < n; i++) {
            if (i == minIdx + 1) {
                nums[i] = 2;
            } else {
                nums[i] = person[i] > person[i - 1] ? nums[i - 1] + 1 : nums[i - 1];
            }
        }
        for (int i = minIdx - 1; i >= 0; i--) {
            if (i == minIdx - 1) {
                nums[i] = 2;
            } else {
                nums[i] = person[i] > person[i + 1] ? nums[i + 1] + 1 : nums[i + 1];
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
        // write code here
    }

    public int house1(int[] person) {
        int n = person.length;
        int[] res = new int[n];
        if(n<=1){
            return n;
        }
        if(n==2){
            return person[0]==person[1]?2:3;
        }
        Arrays.fill(res, 1);
        if (person[1] > person[0]) {
            res[1] = res[0] + 1;
        } else if (person[1] < person[0]) {
            res[0] = 2;
            res[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            if (person[i] > person[i - 1]) {
                res[i] = res[i - 1] + 1;
            } else if (person[i] < person[i - 1]) {
                if (person[i - 1] > 1) {
                    res[i] = res[i - 1] - 1;
                } else {
                    int index = i - 2;
                    while (index >= 0) {
                        if (res[index] == 1) {
                            for (int j = index; j < i - 1; j++) {
                                res[j]=res[j]+1;
                            }
                            break;
                        }else {
                            index-=1;
                        }
                    }
                }


            }
        }
        int sum = 0;
        for (int num : res) {
            sum += num;
        }
        return sum;

    }

    public int house2(int[] people) {
        int n=people.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < n; i++) {
            if(people[i] > people[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int count = left[n- 1];
        for(int i = n - 2; i >= 0; i--) {
            if(people[i] > people[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            count += Math.max(left[i], right[i]);
        }
        return count;
    }


}
