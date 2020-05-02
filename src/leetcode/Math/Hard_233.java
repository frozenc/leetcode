package leetcode.Math;

//数字1的个数
public class Hard_233 {
    //暴力法超时，只能使用数学法
    public int countDigitOne(int n) {
        int countr = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            //Math.max(n % divider - i + 1, 0)，如i=10，计算十位上的1的数目，前面一段(n / divider) * i算的是整百中包含的十位数字1，
            //后面计算的是剩余不足整百的包含的数字1，取余之后，判断是否包含最多的1，以十位位例，包含10-19中的十个，
            //故n%divider - i+1是判断有没有超过10个1，15-10+1中有6个1，22-10+1中有10个1，9-10+1中无1
            //最后Math.min判断是否超过10个1，超过了取10，不超过取计算出来的1的个数
            countr += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0), i);
        }
        return countr;
    }
}
