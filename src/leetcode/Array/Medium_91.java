package leetcode.Array;

//解码方法
public class Medium_91 {
    //有条件的动态规划
    //若i=0,当i-1为1或者2时dp[i]=dp[i-2],否则密码无效，直接返回0
    //若1<=i<=6且i-1为1或者2时，dp[i] = dp[i-1] + dp[i-2];
    //否则dp[i]=dp[i-1]
    public int numDecodings(String s) {
        if (s == null || s.charAt(0) == '0') return 0;
        int cur = 1, prev = 1;
        for (int i=1; i<s.length(); i++) {
            int temp = cur;
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                    //直接等于i-2时的匹配结果,只有一种译码方法，无新增
                    cur = prev;
                } else {
                    return 0;
                }
            } else if (s.charAt(i-1) == '1' || (s.charAt(i-1)=='2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) cur += prev;
            prev = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Medium_91().numDecodings("110"));
    }
}
