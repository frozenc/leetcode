package leetcode.LinkedList;

import java.util.Stack;

//两数相加，不可翻转链表
public class Medium_445 {
    //利用栈实现
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>(), s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode prev = null;
        ListNode ans = null;
        while (!s1.empty() || !s2.empty()) {
            int x = s1.empty() ? 0 : s1.pop().val;
            int y = s2.empty() ? 0 : s2.pop().val;
            int res = x+y+carry;
            carry = (x+y+carry) / 10;
            ans = new ListNode(res%10);
            ans.next = prev;
            prev = ans;
        }
        if (carry != 0) {
            ans = new ListNode(carry);
            ans.next = prev;
        }
        return ans;
    }
}
