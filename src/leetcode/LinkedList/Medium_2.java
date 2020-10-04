package leetcode.LinkedList;

/**
 * leetcode
 * 2020/10/4 9:33
 * 两数相加——链表
 *
 * @author Frozen Chan
 * @since
 **/
public class Medium_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode n1 = l1, n2 = l2, cur = head;
        int carry = 0;
        while (n1 != null || n2 != null) {
            int x = n1 != null ? n1.val : 0;
            int y = n2 != null ? n2.val : 0;
            int val = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            cur.next = node;
        }
        return head.next;
    }
}
