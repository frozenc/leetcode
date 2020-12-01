package JianZhiOffer;

//机器人的运动范围
public class Offer_66 {
    //dfs
    int count = 0;
    boolean[][] isUsed;
    int[][] direction = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    int rows;
    int cols;
    public int movingCount(int threshold, int rows, int cols)
    {
        isUsed = new boolean[rows][cols];
        this.rows = rows;
        this.cols = cols;
        dfs(0,0,threshold);
        return count;
    }

    public void dfs(int row, int col, int threshold) {
        if (calc(row, col) > threshold) return;
        count ++;
        isUsed[row][col] = true;
        for (int i=0; i<4; i++) {
            int newX = row + direction[i][0];
            int newY = col + direction[i][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !isUsed[newX][newY]) {
                dfs(newX, newY, threshold);
            }
        }
    }

    public int calc(int x, int y) {
        int num1 = 0;
        while (x>0) {
            num1 += x%10;
            x /= 10;
        }
        int num2 = 0;
        while (y>0) {
            num2 += y%10;
            y /= 10;
        }
        return num1 + num2;
    }

    public static void main(String[] args) {
        int res2 = new Offer_66().movingCount(10, 1, 100);
        System.out.println(res2);
    }
}
