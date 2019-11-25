package javacourse.test2;

/**
 * 像素类
 *
 * @author icatzfd
 * Created on 2019/10/16 10:53.
 */
public class Pixel extends Point//继承点类
{
    Color color;

    public Pixel(Point p, int value) {//像素类的构造函数
        super(p);
        this.color = new Color(value);
    }
    public Pixel(){//像素类默认构造函数
        this(new Point(), new Color());
    }
    @Override
    public String toString(){//输出
        return this.getClass().getName()+"像素，坐标"+super.toString()+
                "，颜色"+this.color.toString();
    }

    public Pixel(Point p, Color color) {
        super(p);
        this.color = color;
    }
    public static void main(String args[]){
        System.out.println(new Pixel().toString());        //默认Point(0,0)，白色
        Point a = new Point(1,1);
        Color b = new Color(255,255,255);
        Pixel p = new Pixel(a,b);
        System.out.println(p.toString());
    }
}

