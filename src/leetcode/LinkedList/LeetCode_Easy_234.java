package leetcode.LinkedList;

//回文链表
public class LeetCode_Easy_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode mid = getMiddle(head);
        ListNode second = reverseList(mid.next);
        ListNode first = head;
        boolean flag = true;
        while (flag && second != null) {
            if (first.val == second.val) {
                first = first.next;
                second = second.next;
            } else {
                flag = false;
            }
        }
        return flag;

    }

    public ListNode reverseList(ListNode node) {
        //翻转链表
        ListNode cur = node;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode getMiddle(ListNode node) {
        //快慢指针，快指针走两步，慢指针走一步
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next!=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
