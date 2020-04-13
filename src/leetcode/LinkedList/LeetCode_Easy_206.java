package leetcode.LinkedList;

//翻转链表
public class LeetCode_Easy_206 {
    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            //从链表头一个个拿出来
            ListNode next_tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next_tmp;
        }
        return prev;
    }

    //递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h = reverseList(head.next);
        //返回的h是一个已经翻转的链表
        head.next.next = head; // 指向未翻转前列表头，即翻转后链表尾
        head.next = null;
        return h;
    }
}
