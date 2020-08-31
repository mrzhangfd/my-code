package cn.sdu.test.kdxf;

import java.util.Scanner;

/**
 *
 * 作者：三分糖满分甜
 * 链接：https://www.nowcoder.com/discuss/463776?type=post&order=create&pos=&page=1&channel=2002&source_id=search_post
 * 来源：牛客网
 *
 * 题目一：钱币，找最少数量问题
 *      有1元、5元、10元、50元、100元不同面额的钱； 第一行输入不同面额的钱对应的数量，第二行输入需要支付的价格； 需要满足支付价格且使用钱的数量最少；
 *        输出满足的最小数量，没有符合的输出-1
 * @author icatzfd
 * Created on 2020/7/31 15:12.
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] counts = new long[5];
        for (int i = 0; i < 5; i++) {
            counts[i] = sc.nextLong();
        }

        long total = sc.nextLong();
        int res = 0;
        int[] money = {1, 5, 10, 50, 100};
        for (int i = 4; i > 0; i--) {
            if (total / money[i] >= counts[i]) {
                total = total - money[i] * counts[i];
                res += counts[i];
            } else {
                res += total / money[i];
                total = total % money[i];
            }
        }

        if(total>0){
            System.out.println(-1);
        }
        else {
            System.out.println(res);
        }
    }
}
