package JianZhiOffer;

//整数中1出现的次数
public class Offer_31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i=1; i<=n; i*=10) {
            long divider = i*10;
            count += n / divider * i + Math.min(Math.max(n%divider - i + 1, 0), i);
        }
        return count;
    }
}
