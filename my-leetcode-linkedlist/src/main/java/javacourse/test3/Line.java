package javacourse.test3;

/**
 * 直线类
 *
 * @author icatzfd
 * Created on 2019/10/17 10:11.
 */
public class Line extends Figure{

    public Point point2;
    public Line(Point point1,Point point2){

    }

    public Line (int x1,int y1,int x2,int y2){
        System.out.println("2");
    }

    public double length(){
        return 0.0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void revolve(int angle) {

    }

    @Override
    public void zoom(int percentage) {

    }
}
