package JianZhiOffer;

//整数幂
public class Offer_12 {
    public double Power(double base, int exponent) {
        double res = 1.0;
        int n = exponent > 0 ? exponent : -exponent;
        if (exponent == 0) {
            return 1;
        } else {
            while (n != 0) {
                if ((n & 1) != 0) {
                    res *= base;
                }
                base *= base;
                n >>= 1;
            }
        }
        return exponent > 0 ? res : 1 / res;
    }
}
