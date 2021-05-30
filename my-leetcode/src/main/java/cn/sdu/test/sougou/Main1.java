package cn.sdu.test.sougou;

/**
 * 做对的题数
 *
 * @author icatzfd
 * Created on 2020/9/25 19:47.
 */
class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main1 {
    public Interval solve(int n, int k, String str1, String str2) {
        int begin = 0;
        int end = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                num++;
            }

        }
        if (k == n) {
            begin = num;
            end = num;
            return new Interval(begin, end);
        }
        if (num == 0) {
            begin = 0;
            end = n - 1;
            return new Interval(begin, end);
        }
        if (k + n - num > n) {
            end = n + num - k;
        } else {
            end = k + n - num;
        }

        if (k + num - n > 0) {
            begin = k + num - n;
        } else {
            begin = 0;
        }
        return new Interval(begin, end);
    }
}
