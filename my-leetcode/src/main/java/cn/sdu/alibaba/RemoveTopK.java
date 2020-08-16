package cn.sdu.alibaba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 1.生成一个长度为N的列表，元素0-1000之间，找出最大的三个元素，并且从原列表中删除
 *
 * @author icatzfd
 * Created on 2020/8/10 19:21.
 */
public class RemoveTopK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        int n=100;
        ArrayList<Integer> numList = addRandom(n);
        System.out.println(numList);
        removeTopK(numList, 3);
        System.out.println(numList);

    }

    public static ArrayList<Integer> addRandom(int n) {
        ArrayList<Integer> numList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            numList.add((int) (Math.random() * (1001)));
        }
        return numList;
    }

    public static void removeTopK(ArrayList<Integer> numList, int k) {
        int index = findK(numList, 0, numList.size() - 1, numList.size() - k);
        System.out.println("index="+index);
        System.out.println("list:"+numList);
        for (int i = numList.size() - 1; i > index; i--) {
            numList.remove(i);
        }
    }

    public static int findK(ArrayList<Integer> numList, int left, int right, int k) {
        int i = partition(numList, left, right);
        System.out.println("i="+i);
        System.out.println(numList);
        if (i == k - 1) {
            return i;
        } else if (i > k - 1) {
            return findK(numList, left, i - 1, k);
        } else if (i < k - 1) {
            return findK(numList, i + 1, right, k);
        }
        return 0;
    }

    private static int partition(ArrayList<Integer> numList, int left, int right) {

        int ranR = left + (int) (Math.random() * (right - left + 1));
        Collections.swap(numList, ranR, right);
        int k = numList.get(left);
        int i = left;
        int j = right;
        while (j > i) {
            while (numList.get(j) > k && j > i) {
                j--;
            }
            if (j > i) {
                numList.set(i, numList.get(j));
                i++;
            }
            while (numList.get(i) < k && j > i) {
                i++;
            }
            if (j > i) {
                numList.set(j, numList.get(i));
                j--;
            }
        }
        numList.set(j, k);
        return i;

    }

}
