package JianZhiOffer;

//丑数
public class Offer_33 {
    //思路就是不断乘以2，3，5，从结果中挑出最小的继续乘235
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) return index;
        int p1=0, p2=0, p3=0;
        int[] res = new int[index];
        int idx = 0;
        res[idx++] = 1;
        while(idx < index) {
            res[idx] = Math.min(res[p1]*2, Math.min(res[p2]*3, res[p3]*5));
            if (res[p1]*2 == res[idx]) p1++;
            if (res[p2]*3 == res[idx]) p2++;
            if (res[p3]*5 == res[idx]) p3++;
            idx++;
        }
        return res[index-1];
    }
}
