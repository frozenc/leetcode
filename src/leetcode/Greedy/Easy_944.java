package leetcode.Greedy;

//删列造序
public class Easy_944 {
    //暴力查找
    public int minDeletionSize(String[] A) {
        int res = 0;
        for (int col=0; col<A[0].length(); col++) {
            for (int row=1; row<A.length; row++) {
                if (A[row-1].charAt(col) > A[row].charAt(col)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
