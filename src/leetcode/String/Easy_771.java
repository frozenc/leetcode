package leetcode.String;

import java.util.HashSet;
import java.util.Set;

//宝石与石头
public class Easy_771 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        int jLen = J.length(), sLen = S.length(), res = 0;
        for (int i = 0; i < jLen; i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < sLen; i++) {
            if (set.contains(S.charAt(i))) {
                res ++;
            }
        }
        return res;
    }
}
