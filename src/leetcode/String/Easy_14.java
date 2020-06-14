package leetcode.String;

//最长公共前缀
public class Easy_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for (String str:strs) {
            min = Math.min(min, str.length());
        }
        for (int i=0; i<min; i++) {
            char c = strs[0].charAt(i);
            for (int j=1; j<strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        for (int i=0; i<strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j=1; j<strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[j].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
