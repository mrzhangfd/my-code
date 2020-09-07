package cn.sdu.test.caifu;

import cn.sdu.LeetCode;

import java.lang.ref.SoftReference;
import java.util.*;

/**
 * @author icatzfd
 * Created on 2020/9/4 20:14.
 */
public class Main1 {
    public int nQueens(int n) {
        List<List<String>> list = new LinkedList<>();
        if (n <= 0) {
            return list.size();
        }

        if (n == 1) {
            list.add(Collections.singletonList("Q"));
            return list.size();
        }

        int[] indexes = new int[n];

        calc(list, indexes, n, 0);

        return list.size();
    }

    private void calc(List<List<String>> list, int[] indexes, int n, int i) {
        if (i == n) {
            List<String> entry1 = new LinkedList<>();
            List<String> entry2 = new LinkedList<>();
            for (int index : indexes) {
                entry1.add(getRow(n, index));
                entry2.add(getRow(n, n - 1 - index));
            }

            list.add(entry1);
            list.add(entry2);

            return;
        }

        int[] available = new int[n];
        if (i == 0 || (i == 1 && n % 2 == 1 && indexes[0] == (n >> 1))) {
            for (int j = (n + 1) >> 1; j < n; j++) {
                available[j] = 1;
            }
        }

        for (int j = 0; j < i; j++) {
            available[indexes[j]] = 1;

            int left = indexes[j] + j - i;
            if (left >= 0) {
                available[left] = 1;
            }

            int right = indexes[j] + i - j;
            if (right < n) {
                available[right] = 1;
            }
        }

        for (int j = 0; j < n; j++) {
            if (available[j] == 1) {
                continue;
            }

            indexes[i] = j;

            calc(list, indexes, n, i + 1);
        }
    }

    private String getRow(int n, int index) {
        char[] cs = new char[n];
        for (int i = 0; i < n; i++) {
            cs[i] = '.';
        }

        cs[index] = 'Q';

        return String.valueOf(cs);
    }


    public int search(int L, int a, long modulus, int n, int[] nums) {
        // compute the hash of string S[:L]
        long h = 0;
        for (int i = 0; i < L; ++i) {
            h = (h * a + nums[i]) % modulus;
        }

        // already seen hashes of strings of length L
        HashSet<Long> seen = new HashSet();
        seen.add(h);
        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) {
            aL = (aL * a) % modulus;
        }

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            if (seen.contains(h)) {
                return start;
            }
            seen.add(h);
        }
        return -1;
    }

    public int longestDupSubstring(String S) {
        int n = S.length();
        // convert string to array of integers
        // to implement constant time slice
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = (int) S.charAt(i) - (int) 'a';
        }
        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long) Math.pow(2, 32);

        // binary search, L = repeating string length
        int left = 1, right = n;
        int L;
        while (left != right) {
            L = left + (right - left) / 2;
            if (search(L, a, modulus, n, nums) != -1) {
                left = L + 1;
            } else {
                right = L;
            }
        }

        int start = search(left - 1, a, modulus, n, nums);
        return start != -1 ? S.substring(start, start + left - 1).length() : 0;
    }


    public static void main(String[] args) {
        rec();
    }

    private static void rec(){
        rec();
    }


}

class Par {
    static int x = 1;

    public Par() {
    }

    ;

    public void test() {
        x = 3;
    }

}

class Son extends Par {

    public Son() {
    }

    ;

    @Override
    public void test() {
        x = 2;
        System.out.println(x);
    }
}