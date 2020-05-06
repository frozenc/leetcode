package JianZhiOffer;

//累加1....n,不使用乘除以及循环，if判断
public class Offer_47 {
    //巧妙使用逻辑短路与
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = n>0 && (sum += Sum_Solution(n-1))>0;
        return sum;
    }
}
