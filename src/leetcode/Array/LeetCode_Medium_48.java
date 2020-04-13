package leetcode.Array;

//旋转图像
public class LeetCode_Medium_48 {
    public void rotate(int[][] matrix) {
        //转置矩阵
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
    }
}
