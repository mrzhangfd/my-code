package cn.sdu.icat;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


import java.util.ArrayList;
import java.util.List;

/**
 * @author icatzfd
 * Created on 2020/6/11 16:38.
 */
public class Test {
    public static void main(String[] args) {

        //加载opencv的dll文件
        String path = "D:\\OpenCV\\opencv_java340\\";
        System.load(path + "opencv_java340-x64.dll");
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Point point = new Point();
            point.x = i;
            point.y = i;
            points.add(point);
        }
        System.out.println(points);
        MatOfPoint matOfPoint = new MatOfPoint();
        matOfPoint.fromList(points);
        System.out.println(matOfPoint.toList());
        List<MatOfPoint> matOfPoints=new ArrayList<>();
        matOfPoints.add(matOfPoint);
        //读入图片
        Mat src = Imgcodecs.imread("C:\\\\Users\\\\icatzfd\\\\Desktop\\\\test.jpg");
        //灰度化
        Imgproc.cvtColor(src, src, Imgproc.COLOR_BGR2GRAY);
        //二值化
        Imgproc.threshold(src, src, 120, 255, Imgproc.THRESH_BINARY);
        Mat temp = new Mat(src.size(), CvType.CV_8U, new Scalar(0));
        Imgproc.drawContours(temp, matOfPoints, 0, new Scalar(255), -1);
        Imgcodecs.imwrite("C:\\\\Users\\\\icatzfd\\\\Desktop\\\\" + "stringBuilder.jpg", temp);
        /*String path = "D:\\OpenCV\\opencv_java340\\";
        System.load(path + "opencv_java340-x64.dll");
        //读入图片
        Mat src = Imgcodecs.imread("C:\\\\Users\\\\icatzfd\\\\Desktop\\\\test.jpg");
        //灰度化
        Imgproc.cvtColor(src, src, Imgproc.COLOR_BGR2GRAY);
        //二值化
        Imgproc.threshold(src, src, 120, 255, Imgproc.THRESH_BINARY);
        //findContours测试
        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(src, contours, hierarchy, Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
        for (MatOfPoint contour : contours) {
            System.out.println(contour.toList());
        }*/
        /*for (int i = 0; i < contours.size(); i++) {
            Mat temp = new Mat(src.size(), CvType.CV_8U, new Scalar(0));


            //Imgproc.drawContours(temp, contours, i, new Scalar(255), -1);
            //ds[0]->同层级的下一个轮廓(不存在为-1)
            //ds[1]->同层级的上一个轮廓(不存在为-1)
            //ds[2]->第一个子轮廓(不存在为-1)
            //ds[3]->父轮廓(不存在为-1)
            double[] ds = hierarchy.get(0, i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i); //轮廓标记
            stringBuilder.append("="); //分割符
            stringBuilder.append(ds[0]); //同层级的下一个轮廓
            stringBuilder.append("="); //分割符
            stringBuilder.append(ds[1]); //同层级的上一个轮廓
            stringBuilder.append("="); //分割符
            stringBuilder.append(ds[2]); //第一个子轮廓
            stringBuilder.append("="); //分割符
            stringBuilder.append(ds[3]); //父轮廓
            stringBuilder.append(".jpg");
            Imgcodecs.imwrite("C:\\\\Users\\\\icatzfd\\\\Desktop\\\\" + stringBuilder, temp);
       }
*/
    }
}
