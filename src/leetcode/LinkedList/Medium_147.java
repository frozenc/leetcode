package leetcode.LinkedList;

//插入法链表排序
public class Medium_147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode node = head;
        while(node != null) {
            ListNode cur = node;
            node = node.next;

            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < cur.val) prev = prev.next;

            cur.next = prev.next;
            prev.next = cur;
        }
        return dummy.next;
    }
}
