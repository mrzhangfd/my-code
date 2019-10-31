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

}
