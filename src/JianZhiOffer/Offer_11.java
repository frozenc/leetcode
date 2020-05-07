package JianZhiOffer;

public class Offer_11 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count ++;
            n &= n-1;
        }
        return count;
    }
    public int NumberOf12(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((n & flag) != 0) count ++;
            flag <<= 1;
        }
        return count;
    }
}
