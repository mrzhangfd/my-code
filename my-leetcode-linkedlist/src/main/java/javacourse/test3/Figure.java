package javacourse.test3;

/**
 * Figure图形抽象类
 *
 * @author icatzfd
 * Created on 2019/10/17 10:07.
 */
public abstract class Figure {
    public Point point;

    protected Figure(Point point1) {
        System.out.println(point1.toString());
    }



    protected Figure() {
    }


    @Override
    public String toString() {
        return this.point == null ? "" : this.point.toString();
    }


    public abstract void revolve(int angle);

    public abstract void zoom(int percentage);


}
