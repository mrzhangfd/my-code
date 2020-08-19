package cn.sdu.test.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 团建
 *
 * @author icatzfd
 * Created on 2020/8/19 19:06.
 */
//逆时针打印矩阵的变种
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if (m < 10 || m > 1000 || n < 10 || n > 1000) {
            //System.out.println(Arrays.deepToString(new int[0][0]));
            //System.out.println(Arrays.toString(new int[0]));
            System.out.println(Arrays.deepToString(new int[0][0]));
            return;
        }
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        int[][] nums = new int[m][n];
        List<List<Integer>> reslist=new ArrayList<>();
        List<Integer> tempList=new ArrayList<>();
        int[][] res = new int[m][2];
        int num = 1;
        int idx = 0;
        while (num <= m * n) {
            for (int j = left; j <=right; j++) {
                nums[up][j] = num;
                int ge = num % 10;
                int shi = num / 10 % 10;
                if (ge == 7 && isOdd(shi)) {
                    /*tempList.clear();
                    tempList.add(up);
                    tempList.add(j);
                    reslist.add(new ArrayList<>(tempList));*/
                    res[idx++] = new int[]{up, j};
                }
                num++;
            }
            up++;
            if(up>down){
                break;
            }
            for (int i = up; i <=down; i++) {
                nums[i][right] = num;
                int ge = num % 10;
                int shi = num / 10 % 10;
                if (ge == 7 && isOdd(shi)) {
                   /* tempList.clear();
                    tempList.add(i);
                    tempList.add(right);
                    reslist.add(new ArrayList<>(tempList));*/
                    res[idx++] = new int[]{i, right};
                }
                num++;
            }
            right--;
            if(right<left){
                break;
            }

            for (int j= right; j >= left; j--) {
                nums[down][j]=num;
                int ge = num % 10;
                int shi = num / 10 % 10;
                if (ge == 7 && isOdd(shi)) {
                   /* tempList.clear();
                    tempList.add(down);
                    tempList.add(j);
                    reslist.add(new ArrayList<>(tempList));*/
                    res[idx++] = new int[]{down,j};
                }
                num++;
            }
            down--;
            if (down < up) {
                break;
            }
            for (int i = down; i >= up; i--) {
                nums[i][left]=num;
                int ge = num % 10;
                int shi = num / 10 % 10;
                if (ge == 7 && isOdd(shi)) {
                   /* tempList.clear();
                    tempList.add(i);
                    tempList.add(left);
                    reslist.add(new ArrayList<>(tempList));*/
                    res[idx++] = new int[]{i,left};
                }
                num++;
            }

            left++;
            if(left>right){
                break;
            }
        }
        //System.out.println(Arrays.toString(reslist.toArray()));
        int[][] ress=Arrays.copyOf(res,idx);
        String sss=Arrays.deepToString(ress);
        sss=sss.replaceAll(" ","");
        System.out.println(sss);
        //System.out.println(Arrays.deepToString(nums));
    }

    public static boolean isOdd(int num) {
        if (num % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}
