package leetcode.LinkedList;

//链表，两数相加
public class LeetCode_Medium_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode n1 = l1, n2=l2, cur = head;
        int carry = 0;
        while (n1 != null || n2 != null) {
            int x = n1 != null ? n1.val : 0;
            int y = n2 != null ? n2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;
        }
        if (carry != 0) cur.next = new ListNode(1);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);
        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);
        System.out.println(new LeetCode_Medium_2().addTwoNumbers(n1,n2));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "leetcode.Util.ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


