package cn.sdu.test.tonghuashun;



import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author icatzfd
 * Created on 2020/9/5 10:53.
 */
public class Main {
    public void printNum() {
        for (int i = 1; i <= 999; i++) {
            if (!isHasFive(i)) {
                System.out.println(i);
            }
        }
    }

    public boolean isHasFive(int n) {
        int a = 0;
        while (n != 0) {
            a = n % 10;
            if (a == 5) {
                return true;
            }
            n = n / 10;
        }
        return false;
    }

    public static int find2th(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < 2) {
                queue.offer(num);
            } else {
                if (num > queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }

        }
        List<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()){
            list.add(queue.poll());
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int[] nums={3,2,5,1,4,6};
        System.out.println(find2th(nums));
    }
}
