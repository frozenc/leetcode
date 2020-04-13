package leetcode.LinkedList;

//链表排序
public class LeetCode_Medium_148 {
    //归并排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = getMiddle(head);
        ListNode right = sortList(middle.next);
        middle.next = null;
        ListNode left = sortList(head);
        return mergeList(left, right);
    }

    public ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeList(ListNode left, ListNode right) {
        ListNode l = left, r = right;
        ListNode m_head = new ListNode(0);
        ListNode cur = m_head;
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        cur.next = l == null ? r : l;
        return m_head.next;
    }
}
