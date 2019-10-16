package javacourse.test3;

/**
 * 点类
 *
 * @author icatzfd
 * Created on 2019/10/16 10:53.
 */
public class Point {
    public int x,y;

    public Point(int x,int y){//构造函数
        this.x=x;
        this.y=y;
    }
    public Point(){//不带参数的构造函数
        this(0,0);
    }
    public Point(Point p){//复制构造函数
        this(p.x,p.y);
    }
    @Override
    public String toString(){//输出该点
        return "Point("+x+','+y+')';
    }
    public void move(int x,int y){//移动点
        this.x+=x;
        this.y+=y;
    }
    public void moveTo(int x,int y){//移动到坐标点x,y
        this.x=x;
        this.y=y;
    }
    public void moveTo(Point p){
        this.x=p.x;
        this.y=p.y;
    }
}
