package leetcode.BFSDFS;

//矩阵中的最长递增路径
public class Hard_329 {
    int[][] memo;
    int rows, cols;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        memo = new int[rows][cols];
        int max = -1;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }

        return max;
    }

    public int dfs(int[][] matrix, int row, int col) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        memo[row][col] ++;

        for (int i=0; i<dirs.length; i++) {
            int newX = row + dirs[i][0], newY = col + dirs[i][1];
            if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || memo[newX][newY] > memo[row][col]) {
                continue;
            }
            memo[row][col] = Math.max(memo[row][col], dfs(matrix, newX, newY) + 1);
        }

        return memo[row][col];
    }
}
