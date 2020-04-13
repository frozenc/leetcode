package leetcode.LinkedList;

import java.util.HashMap;

import leetcode.Util.Node;

//深拷贝带有随机指针的链表
public class LeetCode_Medium_138 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node newHead = new Node(0);
        Node newCur = newHead;
        Node cur = head;
        //第一个循环，复制新节点，改变next指针
        while (cur != null) {
            Node node = new Node(cur.val);
            newCur.next = node;
            newCur = newCur.next;
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        newCur = newHead.next;
        //第二个循环，改变random指针
        while (cur != null) {
            if (cur.random != null) {
                newCur.random = map.get(cur.random);
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead.next;
    }
}
