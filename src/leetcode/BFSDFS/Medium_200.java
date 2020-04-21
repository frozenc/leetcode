package leetcode.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

//计算岛屿数量
public class Medium_200 {
    //BFS查找
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int nums = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<nr; i++) {
            for (int j=0; j<nc; j++) {
                if (grid[i][j] == '1') {
                    nums ++;
                    grid[i][j] = '0';
                    queue.offer(i*nc + j);
                    while (!queue.isEmpty()) {
                        int data = queue.poll();
                        int row = data/nc;
                        int col = data%nc;
                        if (row+1 < nr && grid[row+1][col] == '1') {
                            grid[row+1][col] = '0';
                            queue.offer((row+1)*nc+col);
                        }
                        if (col+1 < nc && grid[row][col+1] == '1') {
                            grid[row][col+1] = '0';
                            queue.offer((row)*nc+col+1);
                        }
                        if (row-1 >= 0 && grid[row-1][col] == '1') {
                            grid[row-1][col] = '0';
                            queue.offer((row-1)*nc+col);
                        }
                        if (col-1 >= 0 && grid[row][col-1] == '1') {
                            grid[row][col-1] = '0';
                            queue.offer((row)*nc+col-1);
                        }
                    }
                }
            }
        }
        return nums;
    }

    //DFS查找
    public int numIslands2(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int nums = 0;

        for (int i=0; i<nr; i++) {
            for (int j=0; j<nc; j++) {
                if (grid[i][j] == '1') {
                    nums++;
                    DFS(grid, i, j);
                }
            }
        }

        return nums;
    }

    public void DFS(char[][] grid, int row, int col) {
        if (grid[row][col] == '0') return;
        grid[row][col] = '0';
        int nr = grid.length;
        int nc = grid[0].length;

        if (row+1 < nr) DFS(grid, row+1, col);
        if (row-1 >= 0) DFS(grid, row-1, col);
        if (col+1 < nc) DFS(grid, row, col+1);
        if (col-1 >= 0) DFS(grid, row, col-1);
    }
}
