package leetcode.LinkedList;

//旋转链表
public class Medium_67 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        //找到链表长度
        int n=0;
        while (tail.next != null) {
            tail = tail.next;
            n ++;
        }
        k = k%n;
        //旋转次数未0
        if (k == 0) return dummy.next;
        int m = n-k;
        for (int i=0; i<m; i++) {
            ListNode temp = dummy.next;
            dummy.next = dummy.next.next;
            temp.next = tail.next;
            tail.next = temp;
            tail = temp;
        }
        return dummy.next;
    }
}
