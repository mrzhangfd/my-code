package javacourse.test3.chapter4;

import java.util.Scanner;

/**
 * 圆锥体类,计算表面积和体积
 *
 * @author icatzfd
 * Created on 2019/10/31 16:44.
 */
public class Cone implements Area, Volume {

    double radius, height, arc;

    public Cone(double radius, double height, double arc) {
        this.radius = radius;
        this.height = height;
        this.arc = arc;
    }

    @Override
    public double area() {
        return 3.14 * this.radius * this.arc + 3.14 * this.radius * this.radius;

    }

    @Override
    public double volume() {
        return 3.14 * this.radius * this.radius * this.height / 3;
    }

    public static void main(String[] args) {
        double radius, height, arc;
        Scanner in = new Scanner(System.in);
        System.out.print("请输入第一个圆锥的半径：");
        radius = in.nextDouble();
        System.out.print("请输入第一个圆锥的高：");
        height = in.nextDouble();
        System.out.print("请输入第一个圆锥的弧线：");
        arc = in.nextDouble();
        Cone c1 = new Cone(radius, height, arc);
        System.out.println("第一个圆锥的表面积是：" + c1.area());
        System.out.println("第一个圆锥的体积是：" + c1.volume());
        System.out.print("请输入第二个圆锥的半径：");
        radius = in.nextDouble();
        System.out.print("请输入第二个圆锥的高：");
        height = in.nextDouble();
        System.out.print("请输入第二个圆锥的弧线：");
        arc = in.nextDouble();
        Cone c2 = new Cone(radius, height, arc);
        System.out.println("第二个圆锥的表面积是：" + c2.area());
        System.out.println("第二个圆锥的体积是：" + c2.volume());
        if (c1.volume() > c2.volume()) {
            System.out.println("第一个圆锥的体积大于第二个圆锥的体积");
        } else {
            System.out.println("第一个圆锥的体积小于第二个圆锥的体积");
        }

    }

}
