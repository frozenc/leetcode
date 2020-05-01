package leetcode.Math;

//数字1的个数
public class Hard_233 {
    //暴力法超时，只能使用数学法
    public int countDigitOne(int n) {
        int countr = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            countr += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0), i);
        }
        return countr;
    }
}
