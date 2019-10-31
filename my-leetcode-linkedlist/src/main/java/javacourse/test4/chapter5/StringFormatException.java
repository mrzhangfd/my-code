package javacourse.test4.chapter5;

/**
 * 数字格式异常
 *
 * @author icatzfd
 * Created on 2019/10/31 17:29.
 */
public class StringFormatException extends IllegalArgumentException {
    public StringFormatException(String s) {
        super(s);
    }

    public StringFormatException() {
        super();
    }
}
