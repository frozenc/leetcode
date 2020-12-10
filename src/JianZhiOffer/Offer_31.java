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

    public int NumberOf1Between1AndN_Solution2(int n) {
        // 类似于密码锁的思路
        // 2304， 十位上有0010-2219，0-229，共230个1 高位23*digit
        // 2314， 十位上有0010-2314，0-234，共234个1 高位23*digit+低位4
        // 2354， 十位上有0010-2319，0-239，共240个1 （高位23+1）*digit
        int digit = 1, count = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                count += high * digit;
            } else if (cur == 1) {
                count += high * digit + low + 1;
            } else {
                count += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return count;
    }
}
