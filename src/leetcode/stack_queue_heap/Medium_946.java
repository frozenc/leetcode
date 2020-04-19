package leetcode.stack_queue_heap;

import java.util.Stack;

//验证栈序列
public class Medium_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        for (int i:pushed) {
            stack.push(i);
            while (!stack.empty()) {
                if(start < popped.length && stack.peek() == popped[start]) {
                    start++;
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        return stack.empty();
    }
}
