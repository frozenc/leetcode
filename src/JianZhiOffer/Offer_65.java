package JianZhiOffer;

//矩阵中的路径
public class Offer_65 {
    //dfs搜索
    char[] board;
    boolean[][] isUsed;
    int[][] direction = {{0,1}, {-1,0}, {0, -1}, {1, 0}};
    int m;
    int n;
    char[] str;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        board = matrix;
        m = rows;
        n = cols;
        this.str = str;
        isUsed = new boolean[m][n];
        for (int i=0; i<matrix.length; i++) {
            if (dfs(i/n, i%n, 0)) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(int x, int y, int start) {
        if (start == str.length-1) {
            return str[start] == board[x*n+y];
        }
        if (str[start] == board[x*n+y]) {
            isUsed[x][y] = true;
            for (int i=0; i<4; i++) {
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !isUsed[newX][newY]) {
                    if (dfs(newX, newY, start+1)) {
                        return true;
                    }
                }
            }
            isUsed[x][y] = false;
        }
        return false;
    }
}
