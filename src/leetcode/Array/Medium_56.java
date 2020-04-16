package leetcode.Array;

import java.util.Arrays;

//合并区间
public class Medium_56 {
    public int[][] merge(int[][] intervals) {
        //先排序，再合并，排序后合并只需要考虑三种情况[1,2]&[3,4],[1,3]&[2,4],[1,4]&[2,3]
        Arrays.sort(intervals,(V1, V2)->V1[0]-V2[0]);
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int[] interval:intervals) {
            //结果数组为空或者区间的左边大于结尾区间的右边
            if (index==-1 || interval[0] > res[index][1]) {
                res[++index] = interval;
            } else {
                //合并区间，如[1,5]与[2,4];
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(res,index+1);
    }
}
