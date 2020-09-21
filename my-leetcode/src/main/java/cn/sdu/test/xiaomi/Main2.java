package cn.sdu.test.xiaomi;


import java.util.Scanner;

/**
 * 单词搜索
 *
 * @author icatzfd
 * Created on 2020/9/8 18:32.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(str==null ||str.length()==0 || " ".equals(str)){
            System.out.println(false);
            return;
        }
        int n=args.length;
        int m=args[0].length();
       // char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[] chars={'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'};
        int rows = 3;
        int cols=4;

        char[] strs = str.toCharArray();
        System.out.println(hasPath(chars,rows,cols,strs));

    }


    public  static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] mat = new char[rows][cols];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = matrix[k++];
            }
        }
        int[][] visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == str[0]) {
                    //错误的写法如下注释，直接把hasPathHelper()的结果返回。
                    //return hasPathHelper();

                    if (hasPathHelper(i, j, 0, str, mat, visited)) {
                        return true;
                    }

                }
            }
        }

        return false;
    }

    private  static boolean hasPathHelper(int i, int j, int start, char[] str, char[][] mat, int[][] visited) {

        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length) {
            return false;
        }
        if (start >= str.length) {
            return false;
        }
        if (visited[i][j] == 1) {
            return false;
        }
        if (mat[i][j] != str[start]) {
            return false;
        }
        if (start == str.length - 1) {
            return true;
        }
        visited[i][j] = 1;
        boolean res = hasPathHelper(i + 1, j, start + 1, str, mat, visited) |
                hasPathHelper(i, j + 1, start + 1, str, mat, visited) ||
                hasPathHelper(i - 1, j, start + 1, str, mat, visited) ||
                hasPathHelper(i, j - 1, start + 1, str, mat, visited);
        //回溯
        visited[i][j] = 0;
        return res;
    }

}

