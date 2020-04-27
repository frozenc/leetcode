package leetcode.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

//合并K个链表
public class Hard_23 {
    //暴力法
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = lists[0];
        for (int i=1; i<lists.length; i++) {
            dummy = merge(dummy, lists[i]);
        }
        return dummy;
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node1 != null) {
            cur.next = node1;
        } else {
            cur.next = node2;
        }
        return dummy.next;
    }

    //分治法
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) return null;
        return helper(lists, 0, lists.length-1);
    }

    public ListNode helper(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left)/2;
        return merge(helper(lists, left, mid), helper(lists, mid+1, right));
    }

    //优先队列，小顶堆
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(int i=0; i<lists.length; i++) {
            if (lists[i] != null) queue.add(lists[i]);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (queue.size()>0) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) queue.add(node.next);
        }

        cur.next = null;
        return dummy.next;
    }
}
