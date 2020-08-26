package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode
 * 2020/8/26 20:34
 *
 * @author Chan
 * @since
 **/
public class Meidum_17 {
    Map<String, String> map = new HashMap<>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            helper("", digits);
        }
        return res;
    }

    public void helper(String combinations, String digits) {
        if (digits.length() == 0) {
            res.add(combinations);
            return;
        }
        String sub = map.get(digits.substring(0, 1));
        for (int i=0; i<sub.length(); i++) {
            helper(combinations + sub.substring(i, i+1), digits.substring(1));
        }
    }
}
