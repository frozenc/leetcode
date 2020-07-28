package leetcode.String;

//判断子序列
public class Easy_392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int len1 = s.length(), len2 = t.length();
        while (i < len1 && j < len2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == len1;
    }
}
