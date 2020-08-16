package cn.sdu.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 腐烂的橘子
 *
 * @author icatzfd
 * Created on 2020/8/2 15:29.
 */
public class Test994_腐烂的橘子 {
    //994 腐烂的橘子
    //https://leetcode-cn.com/problems/rotting-oranges/comments/266855
    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;

        //四个方向的坐标
        int[] p1 = {1, -1, 0, 0};
        int[] p2 = {0, 0, 1, -1};
        Deque<int[]> deque = new ArrayDeque<>();

        //把腐烂的🍊加入队列中，作为开始扩散的起点
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[]{i, j});
                }
            }
        }

        int steps = 0;
        //从腐烂的🍊开始感染，其实就是一个bfs求无权图最短路的问题
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] temp = deque.poll();
                for (int j = 0; j < p1.length; j++) {
                    //下一个点的位置坐标用x，y表示
                    int x = temp[0] + p1[j], y = temp[1] + p2[j];
                    if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        deque.offer(new int[]{x, y});
                    }
                }
            }
            if(!deque.isEmpty()){
                steps++;
            }
        }
        //遍历矩阵，判断是否有🍊还未被感染，也就是是否还有grid[i][j] = 1的地儿
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                    }
            }
        }
        System.out.println(steps);
        return steps;
    }

    public static void main(String[] args) {
        int[][] nums={{0,2}};
        orangesRotting(nums);
    }


}
