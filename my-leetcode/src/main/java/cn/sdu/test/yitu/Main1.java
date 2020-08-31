package cn.sdu.test.yitu;

import java.util.Scanner;

/**
 * 依图
 *
 * @author icatzfd
 * Created on 2020/8/28 16:00.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = 0, y = 0;
            boolean isPrint=false;
            int flag = 1;//表示向上 -1 向下 2 向左 -2 向右
            for (int i = 0; i <=m; i++) {
                String chr = sc.nextLine();
                String[] strs = chr.split(" ");
                if (strs.length == 1) {
                    switch (strs[0]) {
                        case "L":
                            if (flag == 1) {
                                flag = 4;
                            } else {
                                flag--;
                            }
                            break;
                        case "R":
                            if (flag == 4) {
                                flag = 1;
                            } else {
                                flag++;
                            }
                            break;
                        case "P":
                            if(!isPrint){
                                System.out.printf("Case #%d", k + 1);
                            }
                            isPrint=true;
                            System.out.println();
                            System.out.println(x + " " + y);
                        default:
                    }
                } else {
                    if ("G".equals(strs[0])) {
                        int temp = Integer.parseInt(strs[1]);
                        if (flag == 1) {
                            if (y - temp <= 0) {
                                y = 0;
                            } else {
                                y -= temp;
                            }
                        } else if (flag == 2) {
                            if (x + temp >= n) {
                                x = n-1;
                            } else {
                                x += temp;
                            }
                        } else if (flag == 3) {
                            if (y + temp >= n) {
                                y = n-1;
                            } else {
                                y += temp;
                            }
                        } else {
                            if (x - temp <= 0) {
                                x = 0;
                            } else {
                                x -= temp;
                            }
                        }
                    }
                }

            }
        }
    }
}
