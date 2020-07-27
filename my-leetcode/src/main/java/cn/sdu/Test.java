package cn.sdu;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author icatzfd
 * Created on 2020/6/11 16:38.
 */
public class Test {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right && left < nums.length && right >= 0) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    left++;

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

    public int threeSumClosest(int[] nums, int target) {
        int minSub = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < minSub) {
                    res = sum;
                    minSub = Math.abs(sum - target);
                }
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    res = target;
                    return res;
                }

            }

        }
        return res;

    }

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cap = sc.nextInt();
        int count=0;
        while (count<num-1) {
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < cap; i++) {
                temp.add(sc.nextInt());
                count++;
            }
            list.add(temp);
        }
        System.out.println(list);
        return;
        /*//加载opencv的dll文件
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
        Imgcodecs.imwrite("C:\\\\Users\\\\icatzfd\\\\Desktop\\\\" + "stringBuilder.jpg", temp);*/

    }
}
