package leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

//删除节点中的重复元素
public class Medium_82 {
    //纯指针实现
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                //temp指针指向最后一个重复元素
                ListNode temp = cur.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    //使用集合实现
    public ListNode deleteDuplicates2(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                set.add(head.val);
            }
            if (set.contains(head.val)) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        //最后一个节点
        if (head != null && set.contains(head.val)) {
            prev.next = null;
        }
        return newHead.next;
    }
}
