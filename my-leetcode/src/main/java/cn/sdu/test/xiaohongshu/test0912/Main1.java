package cn.sdu.test.xiaohongshu.test0912;

import cn.sdu.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**二叉树查找
 * @author icatzfd
 * Created on 2020/9/12 10:10.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int tree_size = 0;
        tree_size = Integer.parseInt(in.nextLine().trim());
        int[] tree = new int[tree_size];
        int tree_item;
        for(int tree_i = 0; tree_i < tree_size; tree_i++) {
            tree_item = Integer.parseInt(in.nextLine().trim());
            tree[tree_i] = tree_item;
        }

        res = findMin(tree);
        System.out.println(String.valueOf(res));
    }

    static int findMin(int[] tree) {
        int len = tree.length;

        Set<Integer> hashSet = new HashSet<>();
        for (int num : tree) {
            hashSet.add(num);
        }

        for (int i = 1; i <= len ; i++) {
            if (!hashSet.contains(i)){
                return i;
            }
        }

        return len + 1;


    }
}
