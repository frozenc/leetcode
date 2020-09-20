package leetcode.String;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode
 * 2020/9/20 15:23
 * 拆分字符串
 *
 * @author Chan
 * @since
 **/
public class Medium_5520 {
    int res = 0;

    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        dfs(s, set, 0, 0);
        return res;
    }

    public void dfs(String s, Set<String> set, int start, int end) {
        //剪枝，剩余的字符不够
        if (s.length() - end + set.size() <= res) {
            return;
        }
        if (end == s.length() - 1) {
            if (set.contains(s.substring(start, end + 1))) {
                return;
            } else {
                res = Math.max(res, set.size() + 1);
                return;
            }
        }
        String cur = s.substring(start, end + 1);
        if (!set.contains(cur)) {
            set.add(cur);
            dfs(s, set, end + 1, end + 1);
            set.remove(cur);
        }
        dfs(s, set, start, end + 1);
    }
}
