package leetcode.stack_queue_heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//有效的括号
public class Easy_20 {
    //使用hashmap，看起来更简洁
    public boolean isValid(String s) {
        Map<Character, Character> map =new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c:arr) {
            if (map.containsValue(c)) {
                stack.push(c);
                continue;
            }
            if (map.containsKey(c)) {
                if (stack.empty() || map.get(c) != stack.peek()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }
    //手写，大量ifelse，写的很丑
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(s.charAt(i));
            } else {
                if(stack.empty()) return false;
                char c2 = stack.peek();
                switch(c) {
                    case '}':
                        if(c2 == '{') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case ']':
                        if(c2 == '[') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case ')':
                        if(c2 == '(') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
