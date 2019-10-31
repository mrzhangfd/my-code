package javacourse.test4.chapter5;

/**
 * @author icatzfd
 * Created on 2019/10/31 17:26.
 */
public class AverageImpl implements Average {
    @Override
    public double averageByInt(int[] value) {
        return 0;
    }

    @Override
    public double averageByString(String[] value) throws StringFormatException {

        for (String s : value) {
            if (Integer.parseInt(s) != 1) {
                throw new StringFormatException("格式错误。");
            }


        }
        return 0;
    }
}
