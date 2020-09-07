package cn.sdu.test.tencent.test0906;

import java.util.*;

/**
 * 链表的公共部分 ac
 *
 *
 * @author icatzfd
 * Created on 2020/9/6 20:09.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num1 = new int[n];
        List<Integer> list = new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            num1[i] = sc.nextInt();
            set.add(num1[i]);
        }
        int m = sc.nextInt();
        int[] num2 = new int[m];
        for (int i = 0; i < m; i++) {
            num2[i] = sc.nextInt();
            if (set.contains(num2[i])) {
                res.add(num2[i]);
            }
        }
        for(int num:res){
            System.out.print(num+" ");
        }

    }

}
