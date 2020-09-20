package leetcode.DP;

/**
 * leetcode
 * 2020/9/20 14:34
 * 矩阵的最大非负积
 *
 * @author Chan
 * @since
 **/
public class Medium_5521 {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] dpMax = new long[m][n];
        long[][] dpMin = new long[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dpMax[i][j] = dpMin[i][j] = grid[0][0];
                } else if (i == 0) {
                    dpMax[i][j] = Math.max(grid[i][j] * dpMax[i][j-1], grid[i][j] * dpMin[i][j-1]);
                    dpMin[i][j] = Math.min(grid[i][j] * dpMax[i][j-1], grid[i][j] * dpMin[i][j-1]);
                } else if (j == 0) {
                    dpMax[i][j] = Math.max(grid[i][j] * dpMax[i-1][j], grid[i][j] * dpMin[i-1][j]);
                    dpMin[i][j] = Math.min(grid[i][j] * dpMax[i-1][j], grid[i][j] * dpMin[i-1][j]);
                } else {
                    long maxLeft = Math.max(grid[i][j] * dpMax[i][j-1], grid[i][j] * dpMin[i][j-1]);
                    long minLeft = Math.min(grid[i][j] * dpMax[i][j-1], grid[i][j] * dpMin[i][j-1]);
                    long maxUp = Math.max(grid[i][j] * dpMax[i-1][j], grid[i][j] * dpMin[i-1][j]);
                    long minUp = Math.min(grid[i][j] * dpMax[i-1][j], grid[i][j] * dpMin[i-1][j]);

                    dpMax[i][j] = Math.max(maxLeft, maxUp);
                    dpMin[i][j] = Math.min(minLeft, minUp);
                }
            }
        }

        long mod = (long)(1e9 + 7);
        return dpMax[m-1][n-1] >= 0 ? (int)(dpMax[m-1][n-1] % mod) : -1;
    }

    public void print(long[][] matrix) {
        for (int i = 0; i < matrix.length; i ++) {
            System.out.print("[");
            for (int j = 0; j < matrix[0].length; j ++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println("]");
        }
    }
}
