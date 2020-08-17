package cn.sdu.test.dji;

import java.util.Scanner;


/**
 * 0.64
 * https://www.nowcoder.com/discuss/479182?type=post&order=create&pos=&page=1&channel=666&source_id=search_post
 */
public class DijstraAlgorithm {
    public static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vertex = input.nextInt();
        int edge = input.nextInt();
        int start=0;
        int[][] matrix = new int[vertex][vertex];

        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                matrix[i][j] = MAX;
            }
        }
        for (int i = 0; i < edge; i++) {
            int source = input.nextInt();
            if(i==0){
                start=source;
            }
            int target = input.nextInt();
            int weight = input.nextInt();
            matrix[source][target] = weight;
        }
        int end=input.nextInt();
        dijstra(matrix, 0,end);
    }

    public static void dijstra(int[][] matrix, int source,int end) {
        int length = matrix.length;
        int[] shortPath = new int[length];
        shortPath[0] = 0;
        int[] visited = new int[length];
        for(int i = 0 ; i < length ; i++){
            visited[i] = 0;
        }
        visited[0] = 1;
        for(int m = 1 ; m < length ; m ++){
            int k = -1;
            int dmin = Integer.MAX_VALUE;
            for(int n = 0 ; n < length ; n++){
                if(visited[n] == 0 && matrix[source][n] < dmin){
                    dmin = matrix[source][n];
                    k = n;
                }
            }
            shortPath[k] = dmin;
            visited[k] = 1;
            for(int j = 0 ; j < length ; j++){
                if(visited[j] == 0 && matrix[k][j] != Integer.MAX_VALUE && matrix[source][k] + matrix[k][j] < matrix[source][j]){
                    matrix[source][j] = matrix[source][k] + matrix[k][j];
                }
            }
        }
        System.out.println(shortPath[end]);

    }
}