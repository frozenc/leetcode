package leetcode.DP;

//数字转化为字符串，dp问题
public class Translation {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int prev=0, pprev=0, res = 1;
        for (int i=0; i<str.length(); i++) {
            pprev = prev;
            prev = res;
            if (i == 0) {
                continue;
            }
            String pre = str.substring(i-1, i+1);
            if (pre.compareTo("25") <= 0&& pre.compareTo("10") >= 0) {
                res += pprev;
            }
        }
        return res;
    }
}
