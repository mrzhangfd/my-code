package javacourse.test3.chapter5;

/**
 * @author 张峰达
 * @description 一维整数数组
 * Created on 2019/10/31 19:47.
 */

public class IntArray {

    /**
     * 获得字符串数组str中所有整数
     *
     * @param str
     * @return
     */
    public static int[] getInsts(String[] str) {
        if (str == null || str.length == 0) {
            return null;
        }
        return null;
    }

    public void set(int year, int month, int day) throws StringFormatException {
        if (year <= -2000 || year > 2500) {
            throw new StringFormatException(year + "年份不合适");
        }
    }

    public static void main(String[] args) {
        IntArray intArray=new IntArray();
        intArray.set(2600,1,1);
    }
}

