package leetcode.BackTracking;

//单词搜索
public class Medium_79 {
    //回溯+DFS
    int[][] direction = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    boolean[][] isUsed;
    char[][] board;
    String word;
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        isUsed = new boolean[board.length][board[0].length];
        this.board = board;
        this.word = word;
        m = board.length;
        if (m==0) return false;
        n = board[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(int i, int j, int start) {
        if (start == word.length()-1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            isUsed[i][j] = true;
            for (int k=0; k<4; k++) {
                int newX = i+direction[k][0];
                int newY = j+direction[k][1];
                if (newX >=0 && newX <m && newY >=0 && newY <n && !isUsed[newX][newY]) {
                    if (dfs(newX, newY, start+1)) {
                        return true;
                    }
                }
            }
            isUsed[i][j] = false;
        }
        return false;
    }
}
