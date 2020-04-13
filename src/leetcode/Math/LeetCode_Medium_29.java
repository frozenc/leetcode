package leetcode.Math;

public class LeetCode_Medium_29 {
    public int divide(int dividend, int divisor) {
        //特殊处理
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                return -dividend;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        int sign = 1;
        if ((dividend>0 & divisor<0) || (dividend<0 & divisor>0)) {
            sign = -1;
        }
        //防止越界
        long dividend_l = dividend;
        dividend_l = dividend_l>0 ? dividend_l:-dividend_l;
        long divisor_l = divisor;
        divisor_l = divisor_l>0 ? divisor_l:-divisor_l;
        int res = calDivide(dividend_l, divisor_l);
        return sign>0 ? res : -res;
    }

    public int calDivide(long dividend, long divisor) {
        //递归计算
        if (dividend < divisor) return 0;
        int count = 1;
        long divisor_num = divisor;
        while (divisor_num << 1 < dividend) {
            count += count;
            divisor_num <<= 1;
        }
        System.out.println(count);
        return count + calDivide(dividend - divisor_num, divisor);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_Medium_29().divide(Integer.MIN_VALUE,2));
        System.out.println(2 << 1);
    }
}
