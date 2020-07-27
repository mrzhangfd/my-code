package cn.sdu;

/**
 * 广度优先遍历
 *
 * @author icatzfd
 * Created on 2020/6/16 16:53.
 */
public class BFS {
    //994 腐烂的橘子
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
//                    dfs5(grid,i,j);
                }
            }
        }
    return 1;
    }

}
