package leetcode.LinkedList;

public class Medium_328 {
    public ListNode oddEvenList(ListNode head) {
        //奇偶双链表
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode odd = oddHead, even = evenHead;
        int count = 1;
        while (head != null) {
            if(count % 2 != 0) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            count ++;
        }
        //偶链表的结尾依然指向原链表
        even.next = null;
        odd.next = evenHead.next;
        return oddHead.next;
    }
}
