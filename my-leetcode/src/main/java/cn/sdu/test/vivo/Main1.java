package cn.sdu.test.vivo;

/**
 * 最短路径
 *
 * @author icatzfd
 * Created on 2020/9/12 20:41.
 */
import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int[] begin = new int [2];
        int[] end = new int [2];
        begin[0]=input.nextInt();
        begin[1]=input.nextInt();
        end[0]=input.nextInt();
        end[1]=input.nextInt();
        char[][] map=new char[n][n];
        input.nextLine();
        for(int i=0;i<n;i++){
            String s = input.nextLine();
            map[i]=s.toCharArray();

        }

        System.out.println(bfs(map,begin,end));

    }
    public static int bfs(char [][] map, int [] begin, int [] end) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] d = new int [map.length][map[0].length];
        Queue<int []> que = new LinkedList<int []>();
        for(int i = 0; i < d.length; i++) {
            for(int j = 0; j < d[0].length; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }
        que.offer(begin);
        d[ begin[0] ][ begin[1] ] = 0;
        while(!que.isEmpty()) {
            int [] current = que.poll();
            for(int i = 0; i < 4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];
                if(ny >= 0 && ny < d.length && nx >= 0
                        && nx < d[0].length && map[ny][nx] != '#'
                        &&map[ny][nx] != '@'&&map[ny][nx] != '0'
                        ) {
                    d[ny][nx] = Math.min(d[ny][nx],d[current[0]][current[1]] + 1);
                    int[] c = {ny, nx};
                    que.offer(c);

                }
            }
        }
        return d[end[0]][end[1]]==Integer.MAX_VALUE?-1:d[end[0]][end[1]];
    }






}
