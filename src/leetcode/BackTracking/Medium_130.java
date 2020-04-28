package leetcode.BackTracking;

//被围绕的区域
public class Medium_130 {
    //先把边界的O用特殊字符#标记，然后所有O替换成X，#替换成O
    int m;
    int n;

    public void solve(char[][] board) {
        this.m = board.length;
        if (this.m == 0) return;
        this.n = board[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                boolean isEdge = i==0 || i==m-1 || j==0 || j == n-1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col) {
        if (board[row][col] == 'X' || board[row][col] == '#') return;

        board[row][col] = '#';
        int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for (int i=0; i<4; i++) {
            int newX = row + direction[i][0];
            int newY = col + direction[i][1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                dfs(board, newX, newY);
            }
        }
    }
}
