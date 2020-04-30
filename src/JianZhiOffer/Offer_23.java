package JianZhiOffer;

import Util.ListNode;

//寻找链表环的入口
public class Offer_23 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fast = pHead;
        ListNode slow = pHead;
        do {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        } while (slow != fast);
        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
