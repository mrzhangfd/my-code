package cn.sdu.icat;

/**
 * @author icatzfd
 * Created on 2019/10/31 18:35.
 */
public class Test48 {

    public void rotate(int[][] matrix) {
        int tem;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                tem = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = tem;
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                tem = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n - i- 1][j] = tem;
            }
        }
        //return matrix;
    }



    public boolean isValid(int row, int col, int threshold){
        int sum = 0;
        while(row > 0){
            sum += row%10;
            row = row/10;
        }
        while(col >0){
            sum += col%10;
            col = col/10;
        }
        return sum <= threshold;
    }
    //统计能够走到的次数
    public int count = 0;

    public void help(int i, int j, int threshold, int rows, int cols, int[][] flag){
        if(i < 0 || i >= rows || j < 0 || j >= cols) {
            return;//如果坐标不符合则不计数
        }
        if(flag[i][j] == 1) {
            return;//如果曾经被访问过则不计数
        }
        if(!isValid(i, j, threshold)){
            flag[i][j] = 1;//如果不满足坐标有效性，则不计数并且标记是访问的
            return;
        }
        //无论是广度优先遍历还是深度优先遍历，我们一定要知道的时候遍历一定会有终止条件也就是要能够停止，
        //不然程序就会陷入死循环，这个一定是我们做此类题目必须要注意的地方
        flag[i][j] = 1;
        count++;
        help(i-1, j, threshold, rows, cols, flag);//遍历上下左右节点
        help(i+1, j, threshold, rows, cols, flag);
        help(i, j-1, threshold, rows, cols, flag);
        help(i, j+1, threshold, rows, cols, flag);
    }


    public int movingCount(int threshold, int rows, int cols)
    {
        int[][] flag = new int[rows][cols];
        help(0, 0, threshold, rows, cols, flag);
        return count;
    }

    public static void main(String[] args) {
        Test48 tt=new Test48();
        System.out.println(tt.movingCount(5,10,10));
    }
}
