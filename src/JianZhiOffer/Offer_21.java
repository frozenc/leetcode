package JianZhiOffer;

import java.util.Stack;

//栈的压入，弹出序列
public class Offer_21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack  = new Stack<>();
        int i = 0, j = 0;
        while (i < pushA.length && j < popA.length) {
            stack.push(pushA[i++]);
            if (stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == popA[j]) {
                stack.pop();
                j++;
            } else {
                return false;
            }
        }
        return true;
    }

    //更简洁的写法
    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        Stack<Integer> stack  = new Stack<>();
        int j=0;
        for (int i=0; i<pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && j<popA.length && stack.peek()==popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,4,5};
        int[] num2 = new int[]{3,5,4,1,2};
        new Offer_21().IsPopOrder(num1, num2);
    }
}
