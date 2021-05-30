package cn.sdu.test.sougou;

import java.util.HashSet;
import java.util.Set;

/**
 * @author icatzfd
 * Created on 2020/9/25 20:13.
 */
public class Main3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 在Interval类中返回结果，其中start表示有效字的个数，end表示全部有效字编号的和除以100000007的余数。
     *
     * @param N    int整型 字的总数
     * @param M    int整型 连接关系的总数
     * @param conn Interval类一维数组 全部连接关系
     * @return Interval类
     */
    public Interval trim(int N, int M, Interval[] conn) {
        Set<Integer> set = new HashSet<>();
        Interval cur = new Interval(-1, -1);
        Interval next = new Interval(-1, -1);
        for (int i = 0; i < conn.length; i++) {
            if (conn[i].start == 0) {
                set.add(conn[i].end);
                for (int j = 0; j < conn.length; j++) {
                    if (conn[j].start == conn[i].end) {
                        set.add(conn[j].start);
                    }
                }
            }
        }
        return new Interval(10, 55);
        // write code here
    }
}
