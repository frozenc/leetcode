package Array;

import java.util.LinkedList;
import java.util.List;

//螺旋矩阵
public class LeetCode_Medium_54 {
    //按层遍历
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if(matrix.length == 0) return list;
        int c1=0, c2=matrix[0].length-1;
        int r1=0, r2=matrix.length-1;
        while(r1<=r2 && c1<=c2) {
            for (int i=c1; i<=c2; i++) list.add(matrix[r1][i]);
            for (int i=r1+1; i<=r2; i++) list.add(matrix[i][c2]);
            if(r1<r2 && c1<c2) {
                for (int i=c2-1; i>c1; i--) list.add(matrix[r2][i]);
                for (int i=r2; i>r1; i--) list.add(matrix[i][c1]);
            }
            c1++;
            c2--;
            r1++;
            r2--;
        }
        return list;
    }

    //螺旋模仿
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if(matrix.length == 0) return list;
        int r_nums = matrix.length, c_nums = matrix[0].length;
        //记录已经输出的位置
        boolean[][] seen = new boolean[r_nums][c_nums];
        //对应上下左右操作
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int c=0, r=0, di=0;
        for (int i = 0; i < r_nums*c_nums; i++) {
            list.add(matrix[r][c]);
            seen[r][c] = true;
            int _r = r+dr[di];
            int _c = c+dc[di];
            if (!(0 <= _r && _r<r_nums && 0<=_c && _c<c_nums && !seen[_r][_c])) {
                di = (di+1)%4;
            }
            r += dr[di];
            c += dc[di];
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = new LeetCode_Medium_54().spiralOrder2(matrix);
        System.out.println(list);
    }
}
