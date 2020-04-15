package leetcode.LinkedList;

//删除链表中得倒数第n个节点
public class Medium_19 {
    //双指针法，第一个指针移动n次，第二个指针才开始移动
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        int i=1;
        while (first.next != null) {
            if (i > n) second = second.next;
            first = first.next;
            i+=1;
        }
        second.next = second.next.next;
        return dummy.next;
    }
    //暴力法，两次翻转
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode r1 = reverse(head);
        dummy.next = r1;
        ListNode cur = dummy;
        int i=1;
        while (i<n) {
            cur = cur.next;
            i++;
        }
        cur.next = cur.next.next;
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
