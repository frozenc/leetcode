package leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

//寻找链表回环
public class LeetCode_Medium_142 {
    //双指针法
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //慢指针走了m步，快指针走了2m步
        //快指针比慢指针多走了nr步  2m = m+nr
        //慢指针走了nr步
        //指针从链表头走到链表入口，需要a+nr步
        //故慢指针再多走a步，即可指向链表入口
        do {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        //再使用新指针，从链表头走到入口，需要a步，刚好与慢指针共同指向链表入口
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    //哈希表法
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
