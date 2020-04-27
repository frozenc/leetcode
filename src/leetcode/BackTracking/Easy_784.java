package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

//字母大小写全排列
public class Easy_784 {
    //构建stringBuilder, 每发现一个字符串新建一个，不断遍历
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());

        for (char c:S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i=0; i<n; i++) {
                    ans.add(new StringBuilder(ans.get(i)));
                    String str = "abc" + 'c';
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i=0; i<n; i++) {
                    ans.get(i).append(c);
                }
            }
        }
        for (int i=0;i<ans.size(); i++) {
            res.add(ans.get(i).toString());
        }
        return res;
    }

    //回溯实现
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation2(String S) {
        if (S.length() != 0) combine("", S);
        return res;
    }

    public void combine(String combinations, String nextString) {
        if (nextString.length() == 0) {
            res.add(combinations);
        } else {
            Character c = nextString.charAt(0);
            if (Character.isLetter(c)) {
                combine(combinations + Character.toLowerCase(c), nextString.substring(1));
                combine(combinations + Character.toUpperCase(c), nextString.substring(1));
            } else {
                combine(combinations + c, nextString.substring(1));
            }
        }
    }
}
