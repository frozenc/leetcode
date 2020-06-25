package leetcode.DP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Meidum_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;

        Set<String> set = new HashSet<>();
        for (String word:wordDict) {
            set.add(word);
        }

        for (int i=1; i<=len; i++) {
            for (int j=i-1; j>=0; j--) {
                String sub = s.substring(j, i);
                if (set.contains(sub) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
