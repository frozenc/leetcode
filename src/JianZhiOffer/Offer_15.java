package JianZhiOffer;

import Util.ListNode;

//翻转链表
public class Offer_15 {
    public ListNode ReverseList(ListNode head) {
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // 递归
    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
