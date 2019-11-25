package javacourse.test3.chapter4;

/**
 * 求平均值接口
 *
 * @author icatzfd
 * Created on 2019/10/31 16:47.
 */
public interface Averageable {
    /**
     * 求数组前n个数平均值
     * @param value
     * @param n
     * @return
     */
    public abstract double average(double[] value, int n);


    /**
     * 求数组平均值
     * @param value
     * @return
     */
    public abstract  double average(double[] value);



}
