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
}
