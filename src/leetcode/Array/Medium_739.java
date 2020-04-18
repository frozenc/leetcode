package leetcode.Array;

import java.util.Stack;

//每日温度
public class Medium_739 {
    //利用栈实现
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i=0; i<T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            T[stack.pop()] = 0;
        }
        return res;
    }

    //暴力法
    public int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        for (int i=0; i<T.length; i++) {
            int count = 0;
            int ptr = i;
            while (ptr<T.length) {
                if(T[ptr] > T[i]) {
                    break;
                }
                count ++;
                ptr ++;
            }
            res[i] = ptr == T.length ? 0 : count;
        }
        return res;
    }
}
