package leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

//环形链表
public class LeetCode_Medium_141 {
    //通过哈希表实现
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    //快慢指针实现
    public boolean hasCycle2(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
