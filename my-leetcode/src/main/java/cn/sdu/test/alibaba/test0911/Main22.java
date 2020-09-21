package cn.sdu.test.alibaba.test0911;

import java.util.*;

//图像恢复
public class Main22 {
    static int neighbor=0;
    static boolean[][] visit;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                arr[i][j]=input.nextInt();
            }
        }

        restoreImg(arr);
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++){
                if(j<m-1){
                    System.out.print(arr[i][j]+" ");
                }else {
                    System.out.println(arr[i][j]);
                }
            }
        }


    }
    public static void restoreImg(int[][] arr){
        if(arr==null||arr.length==0||arr[0].length==0) {
            return;
        }
        int rows=arr.length;
        int cols=arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 注意char
                if (arr[i][j] == -1) {
                    neighbor=0;
                    visit=new boolean[rows][cols];
                    int count=dfsSearch(arr, i, j, rows, cols);
                    if(count==0){
                        neighbor=0;
                    }else {

                        neighbor=neighbor/count;
                    }
                    replace(arr,i,j,rows,cols);

                }
            }
        }

    }
    public static void replace(int[][] grid, int i, int j, int rows, int cols){
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return ;
        }
        if (grid[i][j] != -2) {
            return ;
        }

        grid[i][j] = neighbor;
        replace(grid, i + 1, j, rows, cols) ;
        replace(grid, i - 1, j, rows, cols);
        replace(grid, i, j + 1, rows, cols);
        replace(grid, i, j - 1, rows, cols);

    }
    private static int dfsSearch(int[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return 0;
        }
        if(grid[i][j]==-2) {
            return 0;
        }

        if (grid[i][j] != -1) {
            if(visit[i][j]) {
                return 0;
            }
            visit[i][j]=true;
            neighbor+=grid[i][j];
            return 1;
        }


        grid[i][j] = -2;
        return
                dfsSearch(grid, i + 1, j, rows, cols)+
                        dfsSearch(grid, i - 1, j, rows, cols)+
                        dfsSearch(grid, i, j + 1, rows, cols)+
                        dfsSearch(grid, i, j - 1, rows, cols);
    }
}

