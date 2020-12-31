package ByteDanceExplore.String;

/**
 * leetcode
 * 2020/12/31 21:14
 * 最长公共前缀
 *
 * @author Frozen Chan
 * @since
 **/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        for (int index = 0; index < len; index ++) {
            for (int i = 0; i < strs.length; i ++) {
                if (index == strs[i].length() || strs[i].charAt(index) != strs[0].charAt(index)) {
                    return strs[i].substring(0, index);
                }
            }
        }
        return strs[0];
    }
}
