package cn.sdu.test.jd;

import java.util.*;

/**
 * 京东
 *
 * @author icatzfd
 * Created on 2020/8/27 19:37.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Collections.addAll(res, 2, 3, 5);
        Collections.addAll(queue, 2, 3, 5);
        Collections.addAll(list, 2, 3, 5);

        if (n <= 3) {
            System.out.println(list.get(n - 1));
            return;
        }
        int count = 0;
        while (count < n && !queue.isEmpty()) {

            int num = queue.poll();
            for (int i = 0; i < list.size(); i++) {
                queue.offer(num * 10 + list.get(i));
                res.add(num * 10 + list.get(i));
                count++;
                if(count>=n){
                    break;
                }
            }

        }
        System.out.println(res.get(n-1));
    }
}
