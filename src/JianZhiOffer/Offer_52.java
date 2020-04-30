package JianZhiOffer;

import Util.ListNode;

//两个链表的第一个公共节点
public class Offer_52 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            //判断当前节点是否为空，而不是判断next节点，否则当两个链表无相交节点陷入死循环
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,2};
        int[] nums2 = {6,0,3};
        int[] nums3 = {1,8,4,5};
        ListNode h1 = new ListNode(-1);
        ListNode h2 = new ListNode(-1);
        ListNode h3 = new ListNode(-1);
        ListNode c1 = h1;
        ListNode c2 = h2;
        ListNode c3 = h3;
        for (int num:nums1) {
            c1.next = new ListNode(num);
            c1 = c1.next;
        }
        for (int num:nums2) {
            c2.next = new ListNode(num);
            c2 = c2.next;
        }
        for (int num:nums3) {
            c3.next = new ListNode(num);
            c3 = c3.next;
        }
        c1.next = h3.next;
        c2.next = h3.next;
        System.out.println(new Offer_52().FindFirstCommonNode(h1.next, h2.next));
    }
}
