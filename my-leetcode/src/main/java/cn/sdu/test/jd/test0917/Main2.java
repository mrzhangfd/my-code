package cn.sdu.test.jd.test0917;

import java.util.*;

/**
 * 王子与公主 ac
 *
 */
public class Main2{
    public static int  bfs(char [][] grid, int [] begin, int [] end) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] d = new int [grid.length][grid[0].length];
        Queue<int []> queue = new LinkedList<int []>();
        for(int i = 0; i < d.length; i++) {
            for(int j = 0; j < d[0].length; j++) {
                d[i][j] = -1;
            }
        }
        queue.offer(begin);
        d[ begin[0] ][ begin[1] ] = 0;
        while(!queue.isEmpty()) {
            int [] cur = queue.poll();
            if(cur[0] == end[0] && cur[1] == end[1]) {
                break;
            }
            for(int i = 0; i < 4; i++) {
                int xIndex = cur[1] + dx[i];
                int yIndex = cur[0] + dy[i];
                if(yIndex >= 0 && yIndex < d.length && xIndex >= 0 && xIndex < d[0].length && grid[yIndex][xIndex] != '#'&&d[yIndex][xIndex] == -1) {
                    d[yIndex][xIndex] = d[cur[0]][cur[1]] + 1;
                    int[] c = {yIndex, xIndex};
                    queue.offer(c);
                }
            }
        }
        return d[end[0]][end[1]];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0;i<t;i++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];
            int[] begin=new int[2];
            int[] end=new int[2];
            for(int j=0;j<n;j++){
                String next = scanner.next();
                grid[j]=next.toCharArray();
                if(next.indexOf('S')!=-1){

                    begin[0]=j;
                    begin[1]=next.indexOf('S');
                }
                if(next.indexOf('E')!=-1){

                    end[0]=j;
                    end[1]=next.indexOf('E');

                }
            }
            int dis = bfs(grid, begin, end);
            if(dis!=-1)
                System.out.println("YES");
            else
                System.out.println("NO");

        }

    }





}