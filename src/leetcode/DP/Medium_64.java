package leetcode.DP;

//最小路径和
public class Medium_64 {
    //二维dp数组，从
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[m][n];
        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (i == m-1 && j != n-1) {
                    path[i][j] = path[i][j+1] + grid[i][j];
                } else if (i != m-1 && j == n-1) {
                    path[i][j] = path[i+1][j] + grid[i][j];
                } else if (i != m-1 && j != n-1) {
                    path[i][j] = Math.min(path[i+1][j], path[i][j+1]) + grid[i][j];
                } else {
                    path[i][j] = grid[i][j];
                }
            }
        }
        return path[0][0];
    }
    //一维dp数组
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] path = new int[n];
        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (i == m-1 && j != n-1) {
                    path[j] = path[j+1] + grid[i][j];
                } else if (i != m-1 && j == n-1) {
                    path[j] = path[j] + grid[i][j];
                } else if (i != m-1 && j != n-1) {
                    path[j] = Math.min(path[j], path[j+1]) + grid[i][j];
                } else {
                    path[j] = grid[i][j];
                }
            }
        }
        return path[0];
    }
    //不占用任何空间，直接在原数组上面修改
    public int minPathSum3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (i == m-1 && j != n-1) {
                    grid[i][j] = grid[i][j+1] + grid[i][j];
                } else if (i != m-1 && j == n-1) {
                    grid[i][j] = grid[i+1][j] + grid[i][j];
                } else if (i != m-1 && j != n-1) {
                    grid[i][j] = Math.min(grid[i+1][j], grid[i][j+1]) + grid[i][j];
                }
            }
        }
        return grid[0][0];
    }
}
