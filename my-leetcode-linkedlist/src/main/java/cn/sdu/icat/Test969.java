package cn.sdu.icat;

import java.util.ArrayList;
import java.util.List;

/**
 * 969 煎饼排序
 *
 * @author icatzfd
 * Created on 2019/10/29 23:32.
 */
public class Test969 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int i = A.length; i > 0; i--) {
            int pos = findMax(A, 0, i);
            if (pos != i) {
                reverse(A, 0, pos +1);
                reverse(A,0,i);
                res.add(pos+1);
                res.add(i);
            }
        }

        return res;
    }


    public void reverse(int[] A, int begin, int end) {
        end=end-1;
        while (begin < end) {
            int tmp = A[begin];
            A[begin] = A[end];
            A[end] = tmp;
            begin++;
            end--;
        }
    }

    public int findMax(int[] A, int begin, int end) {
        int max = Integer.MIN_VALUE;
        int pos = -1;
        for (int i = begin; i < end; i++) {
            if (A[i] >= max) {
                max = A[i];
                pos = i;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        Test969 test969 = new Test969();
        int[] A = new int[]{1, 3, 4, 5, 7};
        //int [] B=test969.reverse(4,A);
        //System.out.println(test969.findMax(A));
    }

}