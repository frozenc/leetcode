package DataStructure.LinkedList;

import Util.ListNode;

//链表反转
public class ReverseLists {
    public ListNode reverseList(ListNode head) {
        ListNode prev = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = prev.next;
            prev.next = head;
            head = next;
        }
        return prev.next;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return dummy;
    }
}
