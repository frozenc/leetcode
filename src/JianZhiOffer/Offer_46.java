package JianZhiOffer;

//圆圈中最后剩下的数
public class Offer_46 {
    //数组模拟链表
    public int LastRemaining_Solution(int n, int m) {
        if (n<1 || m<1) return -1;
        int[] arr = new int[n];
        int i=-1, step = 0, count = n;
        while (count > 0) {
            i ++;
            if (i>=n) i=0;
            if (arr[i] == -1) continue;
            step ++;
            if (step == m) {
                step = 0;
                count --;
                arr[i] = -1;
            }
        }
        return i;
    }
    //数学法
    public int LastRemaining_Solution2(int n, int m) {
        if (n<1 || m<1) return -1;
        int last = 0;
        for (int i=2; i<=n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
