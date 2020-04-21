package leetcode.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

//01矩阵
public class Medium_542 {
    //BFS广度优先搜索
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0;j<n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    res[i][j] = -1;
                }
            }
        }
        //上，右，下，左
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i=0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && res[newX][newY] == -1) {
                    res[newX][newY] = res[x][y] + 1;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
        return res;
    }

    //动态规划
    public int[][] updateMatrix2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j=0; j < n; j++) {
                dist[i][j] = matrix[i][j] == 0 ? 0 : Integer.MAX_VALUE;
            }
        }
        //从左上角开始，往左上寻找
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i-1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i-1][j]+1);
                }
                if (j-1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j-1]+1);
                }
            }
        }

        //从右下角开始，往右下寻找
        for (int i= m-1; i>=0; i-- ) {
            for (int j=n-1; j>=0; j--) {
                if (i+1 <= m-1) {
                    dist[i][j] = Math.min(dist[i][j],dist[i+1][j]+1);
                }
                if (j+1 <= n-1) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j+1]+1);
                }
            }
        }

        return dist;

    }
}
