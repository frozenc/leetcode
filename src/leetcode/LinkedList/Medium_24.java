package leetcode.LinkedList;

//两两交换链表中的节点
public class Medium_24 {
    //递归实现
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

    //迭代实现
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            ListNode temp = secondNode.next;

            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = secondNode.next;
            cur = firstNode;
            head = firstNode.next;;
        }
        return dummy.next;
    }
}
