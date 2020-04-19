package leetcode.String;

import java.util.HashSet;
import java.util.Set;

//翻转元音字母
public class Easy_345 {
    //双指针
    public String reverseVowels(String s) {
        char[] vowels = new char[]{'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> set = new HashSet<>();
        for (char c:vowels) {
            set.add(c);
        }
        char[] str = s.toCharArray();
        int left = 0, right = s.length()-1;
        while(left < right) {
            while (left < str.length && !set.contains(str[left])) {
                left ++;
            }
            while (right >= 0 && !set.contains(str[right])) {
                right --;
            }
            if (left < right) {
                char tmp = str[left];
                str[left++] = str[right];
                str[right--] = tmp;
            }
        }
        return new String(str);
    }
}
