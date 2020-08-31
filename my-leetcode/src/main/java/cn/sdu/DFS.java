package cn.sdu;

/**
 * 深度优先
 *
 * @author icatzfd
 * Created on 2020/6/15 19:07.
 */
public class DFS {

    //岛屿的最大面积
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j, m, n));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n) {
        //先判断是否越界
        if (i >= m || j >= n || i < 0 || j < 0) {
            return 0;
        }
        //该网格为海洋
        if (grid[i][j] == 0) {
            return 0;
        }

        //该网格被访问过
        if (grid[i][j] == -1) {
            return 0;
        }
        //标记，已经访问过
        grid[i][j] = -1;
        //当前节点是未被访问过得陆地，面积至少为1
        int area = 1;
        //返回grid[i][j] 方向上的岛屿面积
        area += dfs(grid, i + 1, j, m, n);
        area += dfs(grid, i - 1, j, m, n);
        area += dfs(grid, i, j + 1, m, n);
        area += dfs(grid, i, j - 1, m, n);

        return area;
    }

    // 200 岛屿数量
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int nums = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    nums++;
                    dfs2(grid, i, j, m, n);
                }
            }
        }
        return nums;
    }

    private void dfs2(char[][] grid, int i, int j, int m, int n) {
        if (i >= m || j >= n || i < 0 || j < 0) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs2(grid, i + 1, j, m, n);
        dfs2(grid, i, j + 1, m, n);
        dfs2(grid, i - 1, j, m, n);
        dfs2(grid, i, j - 1, m, n);
    }

    //463 岛屿的周长
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int num = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    num = dfs3(grid, i, j, m, n);
                }
            }
        }
        return num;
    }

    private int dfs3(int[][] grid, int i, int j, int m, int n) {
        if (i >= m || j >= n || i < 0 || j < 0) {
            return 1;
        }
        if (grid[i][j] == -1) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 1;
        }
        grid[i][j] = 0;
        int area = 0;
        area += dfs3(grid, i + 1, j, m, n);
        area += dfs3(grid, i, j + 1, m, n);
        area += dfs3(grid, i - 1, j, m, n);
        area += dfs3(grid, i, j - 1, m, n);

        return area;
    }

    //547 朋友圈
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int m = M.length;
        int n = M[0].length;
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    dfs4(M, i, j, m, n);
                    num++;
                }
            }
        }
        return num;
    }

    private void dfs4(int[][] Grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (Grid[i][j] == 0) {
            return;
        }
        Grid[i][j] = 0;
        dfs4(Grid, i + 1, j, m, n);
        dfs4(Grid, i - 1, j, m, n);
        dfs4(Grid, i, j + 1, m, n);
        dfs4(Grid, i, j - 1, m, n);

    }



}
