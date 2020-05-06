package JianZhiOffer;

//斐波那契数列
public class Offer_7 {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int one = 0;
        int two = 1;
        int temp = 0;
        for (int i=2; i<=n; i++) {
            temp = one + two;
            one = two;
            two = temp;
        }
        return temp;
    }
}
