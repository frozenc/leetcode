package leetcode.LinkedList;

//相交链表
public class LeetCode_Easy_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //双指针法，A指针在链表A结束后指向B的链表头，B指针在链表B结束后指向A的头
        ListNode n1 = headA, n2 = headB;
        while (n1 != n2) {
            n1 = n1==null?headB : n1.next;
            n2 = n2==null?headA : n2.next;
        }
        return n1;
    }
}
