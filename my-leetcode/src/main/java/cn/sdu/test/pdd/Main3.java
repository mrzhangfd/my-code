package cn.sdu.test.pdd;

import java.util.Scanner;

/**
 * 多多吃饭
 *作者：跳至星空低入尘埃
 * 链接：https://www.nowcoder.com/discuss/464991?type=post&order=time&pos=&page=1&channel=666&source_id=search_post
 * 来源：牛客网
 *
 * 给出早餐的每一种的美味值和热量，给出晚餐的每一种的美味值和热量，可以吃一顿，可以不吃，可以吃午餐一种和晚餐一种，请问在满足美味值t的前提下，摄入最少热量为什么。 我是按照美味值排序，美味值想等，热量少的在前
 * @author icatzfd
 * Created on 2020/8/2 19:48.
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int T = scanner.nextInt();
        if (T <= 0) {
            System.out.println(0);
            return;
        }
        int[] cal = new int[m + n];
        int[] del = new int[m + n];
        float[] rate=new float[m+n];

        for (int i = 0; i < m + n; i++) {
            cal[i] = scanner.nextInt();
            del[i] = scanner.nextInt();
            rate[i]=(float)del[i]/cal[i];
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = n; j < m + n; j++) {
                if (del[i] >= T) {
                    min = Math.min(cal[i], min);
                }
                if (del[j] >= T) {
                    min = Math.min(cal[j], min);
                }
                if ((del[i] + del[j]) >= T) {
                    min = Math.min(cal[i] + cal[j], min);
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}
