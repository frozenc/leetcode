package leetcode.SearchProblem;

import java.util.HashSet;
import java.util.Set;

//快乐数
public class Easy_202 {
    //使用hashset判断是否出现循环
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int cur = getSumOfSquare(n);
        while (cur != 1) {
            if (set.contains(cur)) return false;
            set.add(cur);
            cur = getSumOfSquare(cur);
        }
        return true;
    }
    //判断链表是否存在环，弗洛伊德循环查找
    public boolean isHappy2(int n) {
        int slow = n;
        int fast = getSumOfSquare(n);
        while (fast != 1) {
            if (slow == fast) return false;
            slow = getSumOfSquare(slow);
            fast = getSumOfSquare(getSumOfSquare(fast));
        }
        return true;
    }

    public int getSumOfSquare(int n) {
        int res = 0;
        while (n != 0) {
            res = res + (int)Math.pow(n%10, 2);
            n /= 10;
        }
        return res;
    }
}
