package cn.sdu.test.gld;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/7/29 20:51.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr[] = new int[n];
        HashMap<Integer, Integer> contentToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cur = input.nextInt();
            while (contentToIndex.containsKey(cur)) {
                Integer index = contentToIndex.get(cur);
                arr[index] = 0;
                contentToIndex.remove(cur);
                cur = 2 * cur;
            }
            arr[i] = cur;
            contentToIndex.put(cur, i);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                System.out.print(arr[i] + " ");
            }

        }
    }
}
