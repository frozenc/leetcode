package LinkedList;

//合并两个有序链表
public class LeetCode_Easy_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode n1 = l1, n2 = l2, cur = head;

        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        cur.next = n1 == null ? n2 : n1;
        return head.next;
    }
}
