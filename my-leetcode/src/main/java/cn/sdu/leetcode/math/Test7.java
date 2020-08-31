package cn.sdu.leetcode.math;

import cn.sdu.LeetCode;

/**
 * 整数反转
 *
 * @author icatzfd
 * Created on 2020/8/24 20:29.
 */
public class Test7 {
    public static int reverse(int x) {
        int res = 0;
        if (x > 0) {
            while (x != 0) {
                res += x % 10;
                x = x / 10;
                if (res > Integer.MAX_VALUE / 10 && x!=0) {
                    return 0;
                }
                if (x != 0) {
                    res *= 10;
                }

            }
            System.out.println(res);
            return res;

        } else if (x < 0) {
            while (x != 0) {
                res += x % 10;
                x = x / 10;
                if (res < Integer.MIN_VALUE / 10 && x!=0) {
                    return 0;
                }
                if (x != 0) {
                    res *= 10;
                }

            }
            System.out.println(res);
            return res;
        }else {
            return 0;
        }

    }

    public int reverse1(int x) {
        int res = 0;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            //判断是否 大于 最大32位整数
            if (res>214748364 || (res==214748364 && tmp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;
    }

/*    作者：wang_ni_ma
    链接：https://leetcode-cn.com/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    public static void main(String[] args) {
        reverse(
                563847412);

    }
}
