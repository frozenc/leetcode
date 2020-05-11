package leetcode.LinkedList;

//K个一组翻转链表
public class Hard_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end != null) {
            for (int i=0; i<k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;

            reverse(start);

            pre.next = end;
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    public void reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }
}
