package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//n皇后
public class Hard_51 {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = '.';
            }
        }
        backTrack(grid, 0);
        return res;
    }


    //摆放第row行的皇后
    public void backTrack(char[][] grid, int row) {
        if (row == grid.length) {
            addRes(grid);
            return;
        }

        int cols = grid[0].length;
        for (int col=0; col<cols; col++) {
            grid[row][col] = 'Q';
            if (isValid(grid, row, col)) {
                backTrack(grid, row+1);
            }
            grid[row][col] = '.';
        }
    }

    //检查在grid[row][col]摆放皇后是否会冲突
    public boolean isValid(char[][] grid, int row, int col) {
        int cols = grid[0].length;
        //查看正上方是否有皇后
        for (int i=0; i<row; i++) {
            if (grid[i][col] == 'Q') {
                return false;
            }
        }
        //查看左上方是否有皇后
        for (int i=row-1, j=col-1;i>=0 && j>=0; i--,j--) {
            if (grid[i][j] == 'Q') {
                return false;
            }
        }
        //查看右上方是否有皇后
        for (int i=row-1, j=col+1; i>=0 && j<cols; i--,j++) {
            if (grid[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public void addRes(char[][] grid) {
        int n = grid.length;
        List<String> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(new String(grid[i]));
        }
        res.add(list);
    }
}
