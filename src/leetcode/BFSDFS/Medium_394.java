package leetcode.BFSDFS;

import java.util.Stack;

//字符串解码
public class Medium_394 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi=0;
        Stack<Integer> stack_multi = new Stack<>();
        Stack<String> stack_str = new Stack<>();
        for (char c:s.toCharArray()) {
            if (c == '[') {
                stack_multi.push(multi);
                multi = 0;
                stack_str.push(res.toString());
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.pop();
                for (int i=0; i<cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_str.pop() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c+"");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
