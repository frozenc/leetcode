package leetcode.LinkedList;

//删除链表节点，传入head
public class LeetCode_Easy_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode h = new ListNode(0);
        ListNode cur = h;
        h.next = head;
        while(cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return h.next;
    }
}
