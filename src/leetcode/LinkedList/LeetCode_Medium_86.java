package leetcode.LinkedList;

//分隔链表
public class LeetCode_Medium_86 {
    public ListNode partition(ListNode head, int x) {
        //创建两个链表头，一个保存大的，一个保存小的，链接在一起
        ListNode small = new ListNode(0);
        ListNode s_head = small;
        ListNode big = new ListNode(0);
        ListNode b_head = big;

        while (head != null) {
            if (head.val >= x) {
                big.next = head;
                big = big.next;
            } else {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }
        //防止形成环
        big.next = null;
        small.next = b_head.next;
        return s_head.next;
    }
}
