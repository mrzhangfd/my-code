package lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 蓝桥模拟
 *
 * @author 张峰达
 * Created on 2020/4/20 14:02.
 */

public class Lanqiao {

    public void multi() {
        int res = 1;
        for (int i = 1; i <= 7; i++) {
            res = res * i;
        }
        System.out.println(res);
    }

    public void T5() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[3];
        for (int i = 0; i < 3; i++) {
            array[i] = scanner.nextInt();
        }
        int num = 0;
        for (int i = 1; i <= n; i++) {
            if (i % array[0] == 0 || i % array[1] == 0 || i % array[2] == 0) {
                continue;
            }
            num++;
        }
        System.out.println(num);
    }

    public void T6() {
        Scanner scanner = new Scanner(System.in);
        String ss = scanner.nextLine();
        char[] charmap = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] chars = ss.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int temp = chars[i] - 'a';
            chars[i] = charmap[temp + 3];
        }
        System.out.println(new String(chars));
    }

    public void T8() {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int ii = scanner.nextInt();
        int jj = scanner.nextInt();
        int[][] nums = new int[r][c];
        int num = 1;
        int right = c - 1;
        int left = 0;
        int up = 0;
        int down = r - 1;
        while (num <= r * c) {
            for (int col = left; col <= right; col++) {
                nums[up][col] = num;
                num++;
            }
            up++;
            if (up > down) {
                break;
            }
            for (int row = up; row <= down; row++) {
                nums[row][right] = num;
                num++;
            }
            right--;
            if (left > right) {
                break;
            }
            for (int col = right; col >= left; col--) {
                nums[down][col] = num;
                num++;
            }
            down--;
            if (up > down) {
                break;
            }
            for (int row = down; row >= up; row--) {
                nums[row][left] = num;
                num++;
            }
            left++;
            if (left > right) {
                break;
            }
        }
        System.out.println(nums[ii - 1][jj - 1]);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);

        return res;
    }

    //count1统计“(”的个数，count2统计“)”的个数
    public void generate(List<String> res, String ans, int count1, int count2, int n) {

        if (count1 > n || count2 > n) {
            return;
        }

        if (count1 == n && count2 == n) {
            res.add(ans);
        }
        if (count1 >= count2) {
            String ans1 = new String(ans);
            generate(res, ans + "(", count1 + 1, count2, n);
            generate(res, ans1 + ")", count1, count2 + 1, n);

        }
    }

    public static void main(String[] args) {
        Lanqiao lanqiao = new Lanqiao();
        //lanqiao.multi();
        //System.out.println(1024*1024*12.5);
        //System.out.println(new BigDecimal(12.5 * 1024 * 1024));
        //System.out.println(lanqiao.generateParenthesis(4).size());
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(new Point(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
        double[][] money = new double[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    money[i][j] = Double.MAX_VALUE;
                } else {
                    double dist = Math.sqrt(list.get(i).x * list.get(i).x + list.get(i).y * list.get(i).y + list.get(i).h * list.get(i).h);
                    money[i][j] = dist;
                }
            }
        }

        List<Point> list1 = new ArrayList<>();
        List<Point> list2 = new ArrayList<>();
        list1.add(list.get(0));
        double minMoney=Double.MIN_VALUE;
        while (true){
            for(int j=0;j<n;j++){
                break;
            }
        }
    }

    

    static class Point {
        int x;
        int y;
        int h;

        public Point(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}