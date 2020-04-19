package leetcode.stack_queue_heap;

import java.util.Stack;

//最小栈
public class Easy_155 {
    //使用辅助栈记录最小值
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> min;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (min.empty()) {
                min.push(x);
            } else if (min.peek() >= x) {
                min.push(x);
            }
        }

        public void pop() {
            int x = stack.pop();
            if (min.peek() == x) {
                min.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
