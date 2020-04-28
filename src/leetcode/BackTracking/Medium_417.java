package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

//太平洋大西洋水流问题
public class Medium_417 {
    //从边缘逆流DFS计算
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];

        for (int i=0; i<m; i++) {
            //从太平洋边缘开始逆流搜索
            dfs(matrix, i, 0, m, n, pacific);
            //从大西洋边缘开始逆流搜索
            dfs(matrix, i, n-1, m, n, atlantic);
        }
        for (int j=0; j<n; j++) {
            //从太平洋边缘开始逆流搜索
            dfs(matrix, 0, j, m, n, pacific);
            //从大西洋边缘开始逆流搜索
            dfs(matrix, m-1, j, m, n, atlantic);
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] matrix, int row, int col, int m, int n, int[][] mark) {
        mark[row][col] = 1;

        int[][] direction = {{0,1}, {-1,0}, {0,-1}, {1,0}};

        for (int i=0; i<4; i++) {
            int newX = row + direction[i][0];
            int newY = col + direction[i][1];
            List<Integer> nl = new ArrayList<>();
            if (newX >= 0 && newX < m && newY < n && newY >= 0
                    && matrix[newX][newY] >= matrix[row][col] && mark[newX][newY]!=1) {
                dfs(matrix, newX, newY, m, n, mark);
            }
        }
    }
}
