package leetcode.DP;

import java.util.List;

//三角形最小路径和
public class Medium_120 {
    //递归，超时
    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(triangle, 0, 0);
    }

    public int helper(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()-1) return triangle.get(row).get(col);
        return triangle.get(row).get(col) + Math.min(helper(triangle, row+1, col), helper(triangle, row+1, col+1));
    }
    //dp，自底向上
    public int minimumTotal2(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] min = new int[rows+1];
        for (int row=rows-1; row>=0; row--) {
            for (int i=0; i<row+1; i++) {
                min[i] = Math.min(min[i], min[i+1]) + triangle.get(row).get(i);
            }
        }
        return min[0];
    }
    //dp,自顶向下，用一个二维数组保存累加的值，跟递归类似，使用记忆化搜索
    public int minimumTotal3(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row == 0) return 0;
        int[][] path = new int[row][row];
        minimumTotal(triangle, 0, 0, path);
        return path[0][0];
    }

    public int minimumTotal(List<List<Integer>> triangle, int row, int col, int[][] path) {

        if (path[row][col] != 0) {
            return path[row][col];
        }
        if (row == triangle.size()-1) {
            path[row][col] = triangle.get(row).get(col);
            return triangle.get(row).get(col);
        }
        int left = minimumTotal(triangle, row+1, col, path);
        int right = minimumTotal(triangle, row+1, col+1, path);
        path[row][col] = Math.min(left, right) + triangle.get(row).get(col);
        return path[row][col];
    }
}
