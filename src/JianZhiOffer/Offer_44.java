package JianZhiOffer;

import java.util.Stack;

//翻转单词顺序列
public class Offer_44 {
    //暴力堆栈
    public String ReverseSentence(String str) {
        String[] arr = str.split(" ");
        if (arr.length == 0) return str;
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String s:arr) {
            stack.push(s);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String ReverseSentence2(String str) {
        String[] arr = str.split(" ");
        if (arr.length == 0) return str;
        StringBuilder sb = new StringBuilder();
        for (int i=arr.length-1; i>=0; i--) {
            sb.append(arr[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    //先翻转整个字符串，再翻转每个单词
    public String ReverseSentence3(String str) {
        int left = 0, right = str.length() - 1;
        //去除字符串前后的空格
        while (left <= right && str.charAt(left) == ' ') {
            left ++;
        }
        while (left <= right && str.charAt(right) == ' ') {
            right --;
        }

        // 去除字符间多余的空格
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            if (str.charAt(left) != ' ') {
                sb.append(str.charAt(left));
            } else if (left > 0 && str.charAt(left - 1) != ' ') {
                sb.append(str.charAt(left));
            }
            left ++;
        }

        char[] arr = str.toString().toCharArray();
        int len = arr.length, start = 0;
        reverse(arr, 0, len - 1);
        for (int i = 0; i < len; i ++) {
            if (arr[i] == ' ') {
                reverse(arr, start, i - 1);
                start = i + 1;
            }
        }
        reverse(arr, start, len - 1);
        return new String(arr);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        new Offer_44().ReverseSentence3("I am a student.");
    }
}
