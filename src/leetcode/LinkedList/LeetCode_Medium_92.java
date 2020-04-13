package leetcode.LinkedList;

public class LeetCode_Medium_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode cur = head;
        //寻找开始翻转的节点
        while(m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        //记录翻转节点的前一个节点，以及开始节点（翻转后尾巴）
        ListNode start = prev;
        ListNode tail = cur;
        ListNode next;

        //翻转中间链表
        while (n > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            n--;
        }

        //判断头部，是否从头部开始翻转，链接翻转后链表头部
        if (start == null) {
            head = prev;
        } else {
            start.next = prev;
        }

        //翻转后链表尾巴链接剩余节点
        tail.next = cur;
        return head;
    }
}
