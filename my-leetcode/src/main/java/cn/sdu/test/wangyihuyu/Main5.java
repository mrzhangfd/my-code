package cn.sdu.test.wangyihuyu;

import java.util.*;

/**
 * 迷宫探秘
 *
 * @author icatzfd
 * Created on 2020/9/5 15:30.
 */
public class Main5 {

    public static int bfs(char[][] map, int[] begin, int[] end) {
        //移动的四个方向
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        //用来储存距离到起始点最短路径的二维数组
        int[][] d = new int[map.length][map[0].length];
        //储存未进行处理的点
        Queue<int[]> que = new LinkedList<int[]>();
        //将所有的位置都初始化为最大
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }
        //将起始点放入队列
        que.offer(begin);
        //将起始点最短路径设为0
        d[begin[0]][begin[1]] = 0;
        //一直循环直到队列为空
        while (!que.isEmpty()) {
            //取出队列中最前端的点
            int[] current = que.poll();
            //如果是终点则结束
            if (current[0] == end[0] && current[1] == end[1]) break;
            //四个方向循环
            for (int i = 0; i < 4; i++) {
                //试探
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];
                //判断是否可以走
                if (ny >= 0 && ny < d.length && nx >= 0 && nx < d[0].length && map[ny][nx] == '#' && d[ny][nx] == Integer.MAX_VALUE) {
                    //如果可以走，则将该点的距离加1
                    d[ny][nx] = d[current[0]][current[1]] + 1;
                    //并将该点放入队列等待下次处理
                    int[] c = {ny, nx};
                    que.offer(c);

                }
            }
        }

        return d[end[0]][end[1]];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] nums = new int[n][2];
            for (int j = 0; j < n; j++) {
                nums[j][0] = sc.nextInt();
                nums[j][1] = sc.nextInt();
            }
            List<Point> list = new ArrayList<>();
            Point first = new Point();
            first.x = 0;
            first.y = 0;
            first.flag=true;
            Point curPoint = new Point();
            list.add(first);
            Point finalPoint = new Point();
            curPoint = first;
            int res = 0;
            for (int j = 0; j < n; j++) {
                if (j != n - 1) {
                    Point temp = new Point();
                    if (nums[j][0] == 0) {
                        temp.x = curPoint.x;
                        temp.y = curPoint.y + 1;
                        temp.flag = nums[j][1] == 1;
                    } else if (nums[j][0] == 1) {
                        temp.x = curPoint.x;
                        temp.y = curPoint.y - 1;
                        temp.flag = nums[j][1] == 1;
                    } else if (nums[j][0] == 2) {
                        temp.x = curPoint.x - 1;
                        temp.y = curPoint.y;
                        temp.flag = nums[j][1] == 1;
                    } else if (nums[j][0] == 3) {
                        temp.x = curPoint.x + 1;
                        temp.y = curPoint.y;
                        temp.flag = nums[j][1] == 1;
                    }

                    list.add(temp);
                    if(temp.flag){
                        curPoint = temp;
                    }

                } else {

                    if (nums[j][0] == 0) {
                        finalPoint.x = curPoint.x;
                        finalPoint.y = curPoint.y + 1;

                    } else if (nums[j][0] == 1) {
                        finalPoint.x = curPoint.x;
                        finalPoint.y = curPoint.y - 1;
                    } else if (nums[j][0] == 2) {
                        finalPoint.x = curPoint.x - 1;
                        finalPoint.y = curPoint.y;
                    } else if (nums[j][0] == 3) {
                        finalPoint.x = curPoint.x + 1;
                        finalPoint.y = curPoint.y;
                    }
                    finalPoint.flag = true;

                    list.add(finalPoint);

                    curPoint = finalPoint;

                }

            }

            int maxX = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE;
            int maxY = Integer.MIN_VALUE;
            int minY = Integer.MAX_VALUE;
            for (Point p : list) {
                if (p.flag) {
                    minX = Math.min(p.x, minX);
                    minY = Math.min(p.y, minY);
                    maxX = Math.max(p.x, maxX);
                    maxY = Math.max(p.y, maxY);
                }

            }

            int row = maxY - minY + 1;
            int col = maxX - minX + 1;
            /*Point[][] arr = new Point[row][col];
            Point temp = new Point();
            temp.flag = false;
            Arrays.fill(arr, temp);*/
            char[][] map = new char[col + 1][row + 1];
            for (Point p : list) {
                if (p.flag) {
                    map[p.x - minX][p.y - minY] = '#';
                }
                //arr[p.x - minX][p.y - minY].flag = true;

            }


           /* for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (arr[j][k].flag == false) {

                    }
                }
            }*/
            System.out.println(bfs(map, new int[]{first.x - minX, first.y - minY}, new int[]{finalPoint.x - minX, finalPoint.y - minY}));


        }
    }
}

class Point {
    int x;
    int y;
    boolean flag;

    public Point() {

    }
}