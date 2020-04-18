package leetcode.Array;
//比特位计数
public class Medium_338 {
    //奇数比前一个偶数多1个1，偶数的1个数等于本身除以2的数的1个数
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for (int i=1; i<res.length; i++) {
            if (i%2 == 1) {
                res[i] = res[i-1] + 1;
            } else {
                res[i] = res[i/2];
            }
        }
        return res;
    }
}
