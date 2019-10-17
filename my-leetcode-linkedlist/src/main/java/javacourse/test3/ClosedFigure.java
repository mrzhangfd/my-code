package javacourse.test3;

/**
 * 闭合图形抽象
 *
 * @author icatzfd
 * Created on 2019/10/17 10:20.
 */
public abstract class ClosedFigure extends Figure {
    protected String shape;
    protected ClosedFigure(String shape,Point point1){
        super(point1);
        this.shape=shape;
    }

    protected ClosedFigure(){
        this("",new Point());
    }
}
