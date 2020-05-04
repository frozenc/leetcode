package JianZhiOffer;

//构建乘积数组
public class Offer_51 {
    public int[] multiply(int[] A) {
        int[] res = new int[A.length];
        int k=1;
        //计算该数字左边的乘积
        for (int i=0; i<A.length; i++) {
            res[i] = k;
            k *= A[i];
        }
        k = 1;
        //计算该数字右边的乘积
        for (int i=A.length-1; i>=0; i--) {
            res[i] *= k;
            k *= A[i];
        }
        return res;
    }
}
