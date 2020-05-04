package JianZhiOffer;

import java.util.Stack;

//最小栈
public class Offer_20 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        if (min.isEmpty() || node < min.peek()) {
            min.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        if (stack.pop() == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
