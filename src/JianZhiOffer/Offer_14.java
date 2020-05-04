package JianZhiOffer;

import Util.ListNode;

import java.util.Stack;

//输出链表的倒数第k个节点
public class Offer_14 {
    //通过栈实现
    public ListNode FindKthToTail(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int i = 1;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (i++ == k) {
                return node;
            }
        }
        return null;
    }
    //双指针法
    public ListNode FindKthToTail2(ListNode head,int k) {
        if (head == null || k == 0) return null;
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        //fast先走，走k步，当fast走到null时，slow正好走到倒数第k个
        while (k>0) {
            if (fast != null) {
                fast = fast.next;
                k--;
            } else {
                return null;
            }
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
