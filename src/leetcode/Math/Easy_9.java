package leetcode.Math;

//回文数
public class Easy_9 {
    //转化为字符串，非常量的空间
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        int left = 0, right = str.length()-1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
    //数学方法，x慢慢反转，最后比较
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x%10 == 0 && x!=0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse/10;
    }
}
