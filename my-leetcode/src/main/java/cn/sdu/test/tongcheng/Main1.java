package cn.sdu.test.tongcheng;

/** 最大连通区域
 * @author icatzfd
 * Created on 2020/9/14 21:09.
 */
public class Main1 {
    public static void main(String[] args) {

    }

    public int getMaxArea(int[][] data){
        int res = 0;
        int m = data.length;
        int n = data[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] == 1) {
                    res = Math.max(res, dfs(data, i, j, m, n));
                }
            }
        }
        return res;
    }
    private int dfs(int[][] data, int i, int j, int m, int n) {
        //越界
        if (i >= m || j >= n || i < 0 || j < 0) {
            return 0;
        }
        //该网格为海洋
        if (data[i][j] == 0) {
            return 0;
        }

        //该网格被访问过
        if(data[i][j]==-1){
            return 0;
        }
        //标记，已经访问过
        data[i][j]=-1;
        //当前节点是未被访问过得陆地，面积至少为1
        int area=1;
        //返回grid[i][j] 方向上的岛屿面积
        area+=dfs(data,i+1,j,m,n);
        area+=dfs(data,i-1,j,m,n);
        area+=dfs(data,i,j+1,m,n);
        area+=dfs(data,i,j-1,m,n);

        return area;
    }
}
