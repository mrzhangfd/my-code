package cn.sdu.lanqiao;


import java.io.IOException;
import java.util.*;


/**
 * @author icatzfd
 * Created on 2019/12/20 16:09.
 */
public class Solution {


    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] rets = new int[2];
        int first = findLeft(nums, target);
        int last = findRight(nums, target);
        if (first <= last) {
            rets[0] = first;
            rets[1] = last;

        } else {
            rets[0] = -1;
            rets[1] = -1;
        }
        return rets;
    }

    public int findLeft(int[] nums, int target) {
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                h = mid;
            } else if (nums[mid] > target) {
                h = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        if (l == nums.length || nums[l] != target) {
            return -1;
        }
        return nums[l] == target ? l : -1;
    }

    public int findRight(int[] nums, int target) {
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                h = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        if (l == 0 || nums[l - 1] != target) {
            return -1;
        } else {
            return l - 1;
        }
    }

    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] < nums[h]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

   /* public int firstBadVersion(int n) {
        int l=1;
        int h=n;
        while (l<h){
            int mid=l+(h-l)/2;
            if(isBadVersion(mid)){
                h=mid;
            }else {
                l=mid+1;
            }
        }

        return l-1;
    }*/

    public int StrToInt(String str) {

        if (str == null) {
            return 0;
        }
        int result = 0;
        boolean negative = false;//是否负数
        int i = 0, len = str.length();
        /**
         * limit 默认初始化为 负的 最大正整数 ，假如字符串表示的是正数
         * 那么result(在返回之前一直是负数形式)就必须和这个最大正数的负数来比较，
         * 判断是否溢出
         */
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = str.charAt(0);//首先看第一位
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;//在负号的情况下，判断溢出的值就变成了 整数的 最小负数了
                } else if (firstChar != '+')//第一位不是数字和-只能是+
                {
                    return 0;
                }
                if (len == 1) // Cannot have lone "+" or "-"
                {
                    return 0;
                }
                i++;
            }
            multmin = limit / 10;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = str.charAt(i++) - '0';//char转int
                if (digit < 0 || digit > 9)//0到9以外的数字
                {
                    return 0;
                }

                //判断溢出
                if (result < multmin) {
                    return 0;
                }
                result *= 10;
                if (result < limit + digit) {
                    return 0;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        //如果是正数就返回-result（result一直是负数）
        return negative ? result : -result;
    }

    public void computerNum(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j < i / 2 + 1; j++) {
                if (i % j == 0) {
                    sum = j + sum;

                }

            }
        }
    }


    static class Meet   {
        int start;
        int end;

        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public void setEnd(int end) {
            this.end = end;
        }


    }

    private int meetProblem(Queue<Meet> meets) {
        if (meets == null || meets.size() == 0) {
            return 0;
        }

        int earlyEnd = 24;
        for (Meet meet : meets) {
            if (meet.end < earlyEnd) {
                earlyEnd = meet.end;
            }
        }
        return 1;
    }

    private int Jump(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        if (len == 1) {
            return arr[0];
        }
        if (len == 2) {
            return Math.max(arr[0], arr[1]);
        }

        int[] dp = new int[len];
        dp[0] = arr[0];
        dp[1] = arr[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i] - arr[i - 1], dp[i - 2] + arr[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int num : dp) {
            if (num >= max) {
                max = num;
            }
        }
        return max;
    }

    private int Jump2(int arr[]) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }

        return dp[arr.length - 1];
    }


    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        //int[] nums = new int[]{3, 4, 5, 1, 2};
/*        int target = 7;
        char a = 'a';
        int[] arr = {1000, 5, 20000, 100};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(solution.Jump2(arr));*/
        //System.out.println(Integer.valueOf(9));
        //solution.computerNum(1000);

        PriorityQueue<Meet> queue = new PriorityQueue<Meet>(11, new Comparator<Meet>() {
            @Override
            public int compare(Meet o1, Meet o2) {
                return o2.end - o1.end;
            }
        });
        int n;//测试数据的组数
        int count;//会议的场数
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        System.out.println(n);
        count = Integer.parseInt(sc.nextLine());
        System.out.println(count);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < count; j++) {
                String[] meets = sc.nextLine().split(" ");
                Meet meet = new Meet(Integer.parseInt(meets[0]), Integer.parseInt(meets[1]));
                queue.add(meet);
            }
            System.out.println(queue);
            int res = 1;
            Meet meet = queue.poll();
            int endTime = meet.end;
            int sum = meet.end - meet.start;
            for (int k = 1; k < count; k++) {
                System.out.println(endTime);
                if (endTime <= queue.peek().start) {
                    res++;
                    Meet tmp = queue.peek();
                    sum = sum + tmp.end - tmp.start;
                    endTime = tmp.end;
                }
                queue.poll();

            }
            queue.clear();
            System.out.println(sum);
        }
    }

}
