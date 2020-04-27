package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//分割回文字符串
public class Medium_131 {
    //利用栈保存路径
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s.length() != 0) backTracking(s, 0, s.length(), new Stack<>());
        return res;
    }

    public void backTracking(String s, int start, int len, Stack<String> path) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start; i<len; i++) {
            if (!checkPalindrome(s, start, i)) {
                continue;
            }
            path.push(s.substring(start, i+1));
            backTracking(s, i+1, len, path);
            path.pop();
        }
    }

    public boolean checkPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
