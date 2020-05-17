package leetcode.BackTracking;
//N皇后解法的数量
public class Hard_52 {
    int count = 0;

    public int totalNQueens(int n) {
        int[][] grid = new int[n][n];
        backTrack(grid, 0, n);
        return count;
    }

    public void backTrack(int[][] grid, int row, int n) {
        if (row == n) {
            count ++;
            return;
        }
        for (int col=0; col<n; col++) {
            if (isValid(grid, row, col, n)) {
                grid[row][col] = 1;
                backTrack(grid, row+1, n);
                grid[row][col] = 0;
            }
        }
    }

    public boolean isValid(int[][] grid, int row, int col, int n) {
        for (int i=0; i<row; i++) {
            if (grid[i][col] == 1) {
                return false;
            }
        }
        for (int i=row-1, j=col-1; i>=0&&j>=0; i--,j--) {
            if (grid[i][j] == 1) {
                return false;
            }
        }
        for (int i=row-1, j=col+1; i>=0&&j<n; i--,j++) {
            if (grid[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
