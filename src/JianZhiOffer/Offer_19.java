package JianZhiOffer;

import java.util.ArrayList;

//螺旋矩阵
public class Offer_19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, dir = 0;
        boolean[][] isVisited = new boolean[row][col];
        for (int i=0; i<row*col; i++) {
            res.add(matrix[x][y]);
            isVisited[x][y] = true;
            int newX = x + direction[dir][0];
            int newY = y + direction[dir][1];
            if (newX < 0 || newX >= row || newY < 0 || newY >= col || isVisited[newX][newY]) {
                dir = (dir + 1) % 4;
            }
            x += direction[dir][0];
            y += direction[dir][1];
        }
        return res;
    }
}
