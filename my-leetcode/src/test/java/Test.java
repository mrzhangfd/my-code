/**
 * test
 *
 * @author 张峰达
 * Created on 2019/9/14 23:38.
 */

public class Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 4, k = 1;
        boolean up = true;//2-3的方向是向下。4-6的方向是向上，每完成一次就要改变一次方向
        int[][] a = new int[n][n];
        //左上三角形
        for (int s = 0; s < n; s++) { //s是下标和

            if (up) {
                for (int i = 0; i <= s; i++)
                    a[i][s - i] = k++;
            } else {
                for (int i = 0; i <= s; i++)
                    a[s - i][i] = k++;
            }
            up = !up;      //方向改变


        }
        //右下三角形
        for (int s = n; s < 2 * n - 1; s++) {

            if (up) {
                for (int j = s - n + 1; j < n; j++)//注意这里j的起始赋值
                    a[j][s - j] = k++;
            } else {
                for (int j = s - n + 1; j < n; j++)
                    a[s - j][j] = k++;
            }
            up = !up;


        }
        //输出数组
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%-5s" , a[i][j]);
            }
            System.out.println();
        }

    }

}
