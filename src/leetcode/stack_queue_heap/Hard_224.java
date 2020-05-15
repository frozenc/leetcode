package leetcode.stack_queue_heap;

import java.util.Stack;

//简单的计算器
public class Hard_224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int num = 0;
        int sign = 1;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num*10 + (int)(c-'0');
            } else if (c == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            } else  if (c == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * num;

                res *= stack.pop();

                res += stack.pop();

                num  = 0;
                sign = 1;
            }
        }
        res += sign * num;
        return res;
    }

    public static void main(String[] args) {
        new Hard_224().calculate("(1+(4+5+2)-3)+(6+8)");
    }
}
