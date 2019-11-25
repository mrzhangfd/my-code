package javacourse.test2;

/**
 * 复数类
 *
 * @author icatzfd
 * Created on 2019/10/16 9:47.
 */
public class Complex {
    private double real, image;
    char ii='i';
    public Complex(String s) {
        String[] split = s.split("\\+");
        if (split.length == 2) {
            int index = s.indexOf(ii);
            if (index == s.length() - 1) {
                this.real = Double.parseDouble(split[0]);
                this.image = Double.parseDouble(split[1].substring(0, split[1].lastIndexOf(ii)));
            } else {
                this.real = Double.parseDouble(split[1]);
                this.image = Double.parseDouble(split[0].substring(0, split[0].lastIndexOf(ii)));
            }
        } else if (split.length == 1) {
            if (s.indexOf(ii) == -1) {
                this.real = Double.parseDouble(split[0]);
                this.image = 0;

            } else {
                this.real = 0;
                this.image = Double.parseDouble(split[0].substring(0, split[0].lastIndexOf(ii)));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("3+4i".length());

        Complex complex=new Complex("3");
        System.out.println(complex.real+" "+complex.image);
    }
}
