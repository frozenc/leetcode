package JianZhiOffer;

import java.util.HashMap;

//复杂链表的复制
public class Offer_25 {
    //hashmap,空间复杂度O(n);
    public RandomListNode Clone(RandomListNode pHead)
    {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode cur = dummy;
        RandomListNode head = pHead;
        while (pHead != null) {
            RandomListNode node = new RandomListNode(pHead.label);
            map.put(pHead, node);
            pHead = pHead.next;
            cur.next = node;
            cur = cur.next;
        }
        cur = dummy.next;
        pHead = head;
        while (cur != null) {
            if (pHead.random != null) cur.random = map.get(pHead.random);
            pHead = pHead.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    //在老链表的每个节点后面加入深拷贝的新节点，第二次遍历添加random指针，第三次遍历断开老旧节点的链接
    public RandomListNode Clone2(RandomListNode pHead)
    {
        if (pHead == null) return null;
        RandomListNode oldPtr = pHead;
        while (oldPtr != null) {
            RandomListNode node = new RandomListNode(oldPtr.label);
            node.next = oldPtr.next;
            oldPtr.next = node;
            oldPtr = node.next;
        }
        oldPtr = pHead;
        while (oldPtr != null) {
            oldPtr.next.random = oldPtr.random == null ? null : oldPtr.random.next;
            oldPtr = oldPtr.next.next;
        }
        oldPtr = pHead;
        RandomListNode newPtr = pHead.next;
        RandomListNode head = pHead.next;
        while (oldPtr != null) {
            oldPtr.next = oldPtr.next.next;
            newPtr.next = newPtr.next == null ? null : newPtr.next.next;
            oldPtr = oldPtr.next;
            newPtr = newPtr.next;
        }
        return head;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
