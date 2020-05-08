package leetcode.DP;

//寻找最大正方形
public class Medium_221 {
    //暴力法
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        int rows = matrix.length, cols=matrix[0].length;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, 1);
                    int border = Math.min(rows - i, cols - j);
                    //右边一列
                    for (int k=1; k<border; k++) {
                        boolean flag = true;
                        for (int m=0; m<=k; m++) {
                            if (matrix[i+k][j+m] == '0' || matrix[i+m][j+k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            max = Math.max(max, k+1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return max*max;
    }

    //dp
    public int maximalSquare2(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        int rows = matrix.length, cols=matrix[0].length;

        int[][] dp = new int[rows][cols];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if(matrix[i][j] == '1') {
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max*max;
    }
}
