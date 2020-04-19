package leetcode.String;

//验证回文串
public class Easy_125 {
    //双指针判断
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left ++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right --;
                continue;
            }
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
