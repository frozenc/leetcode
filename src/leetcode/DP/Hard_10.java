package leetcode.DP;

//正则表达式匹配
public class Hard_10 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int len1 = s.length(), len2 = p.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for(int j=0; j<len2; j++) {
            if (p.charAt(j) == '*') {
                //在模式a*b*c*中，只要含有*，就可以视为0，直接使用前面的匹配结果
                dp[0][j+1] = dp[0][j-1];
            }
        }
        for (int i=0; i<len1; i++) {
            for (int j=0; j<len2; j++) {
                //单个字符匹配上，直接使用前一个字符的匹配结果
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                //如果模式是*，考虑前一个字符
                if (p.charAt(j) == '*') {
                    //前一个字符匹配不成功，如ab 和 abd*，将*视为0
                    if (p.charAt(j-1) != '.' && p.charAt(j-1) != s.charAt(i)) {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        //前一个字符成功匹配, 如abc 和 abc*(ab.*)
                        // abc 和 abc* 中忽略c* *取0的时候
                        // abc 和 abc* 中忽略* *取1的时候
                        // abc 和 abc* 中只看字符串中ab  *取多的时候
                        if (dp[i][j+1] || dp[i+1][j] || dp[i+1][j-1]) {
                            // if (dp[i+1][j-1] || dp[i+1][j] || dp[i][j+1]) {
                            dp[i+1][j+1] = true;
                        }
                    }
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        new Hard_10().isMatch("aa", "a*");
    }
}
