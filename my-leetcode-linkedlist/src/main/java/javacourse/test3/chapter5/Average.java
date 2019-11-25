package javacourse.test3.chapter5;

/**
 * 求平均值接口
 *
 * @author icatzfd
 * Created on 2019/10/31 17:22.
 */
public interface Average {

    /**
     * 以整形数组为参数
     *
     * @param value
     * @return 平均值
     */
    public abstract double averageByInt(int[] value);


    /**
     * 以字符串数组（数字的字符串形式）为参数
     *
     * @param value
     * @return 平均值
     */
    public abstract double averageByString(String[] value);
}
