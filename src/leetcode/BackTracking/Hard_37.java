package leetcode.BackTracking;

//解数独
public class Hard_37 {
    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }

    public boolean backTrack(char[][] board, int row, int col) {
        int n = board.length;
        if (col == n) {
            return backTrack(board, row+1, 0);
        }
        if (row == n) {
            return true;
        }
        if (board[row][col] != '.') {
            return backTrack(board, row, col + 1);
        }
        for (char c='1'; c<='9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c;
                if (backTrack(board, row, col+1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public boolean isValid(char[][]board, int row, int col, char c) {
        int n = board.length;
        for (int i=0; i<n; i++) {
            if (c == board[i][col]) {
                return false;
            }
            if (c == board[row][i]) {
                return false;
            }
            if (c == board[(row/3)*3+i/3][(col/3)*3+i%3]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        new Hard_37().solveSudoku(board);
    }
}
