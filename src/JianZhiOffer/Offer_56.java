package JianZhiOffer;

import Util.ListNode;

//删除链表中的重复元素
public class Offer_56 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        prev.next = pHead;

        while (pHead != null) {
            ListNode next = pHead.next;
            //遇到重复元素就继续往下查找重复元素
            if (next != null && pHead.val == next.val) {
                while (next != null && pHead.val == next.val) {
                    pHead.next = next.next;
                    next = pHead.next;
                }
                //删除重复的第一个元素，prev指针不动
                prev.next = pHead.next;
            } else {
                //没有重复元素，prev指针后移
                prev = pHead;
            }
            //继续向后查找
            pHead = pHead.next;
        }
        return dummy.next;
    }
}
