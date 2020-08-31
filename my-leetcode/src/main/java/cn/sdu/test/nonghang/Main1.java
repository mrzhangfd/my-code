package cn.sdu.test.nonghang;

/**
 * @author icatzfd
 * Created on 2020/8/29 10:01.
 */
public class Main1 {
    public static int get_index(String[] points) {
        int len = points.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = Integer.parseInt(points[i].split(",")[0]);
            arr[i][1] = Integer.parseInt(points[i].split(",")[1]);
        }
        double averageX = 0;
        double averageY = 0;
        int sumX = 0;
        int sumY = 0;
        for (int i = 0; i < len; i++) {
            sumX += arr[i][0];
            sumY += arr[i][1];
        }
        averageX = (double) sumX / len;
        averageY = (double) sumY / len;
        double minDis = Integer.MAX_VALUE;
        int minPointIndex = -1;
        for (int i = 0; i < len; i++) {
            double temp = get_dis(averageX, averageY, arr[i][0], arr[i][1]);
            if (temp < minDis) {
                minDis = temp;
                minPointIndex = i;
            } else if (temp == minDis) {
                minPointIndex = Math.min(minPointIndex, i);
            }
        }
        return minPointIndex;
    }
    public  static double get_dis(double averageX, double averageY, int x, int y) {
        double dis = 0;
        dis = Math.sqrt((x - averageX) * (x - averageX) + (y - averageY) * (y - averageY));
        return dis;
    }

    public static void main(String[] args) {
        String[] point={"1,1","2,2","1,2","1,3"};
        System.out.println(get_index(point));
    }

}
