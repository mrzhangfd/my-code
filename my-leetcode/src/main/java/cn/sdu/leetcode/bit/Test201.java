package cn.sdu.leetcode.bit;

/**
 * 数字范围按位与
 *
 * @author icatzfd
 * Created on 2020/7/31 19:44.
 */
public class Test201 {
    public int rangeBitwiseAnd(int m, int n) {
        int count=0;
        while (m!=n){
            m=m>>1;
            n=n>>1;
            count++;
        }
        return m<<count;
    }
}
