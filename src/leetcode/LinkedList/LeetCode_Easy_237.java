package leetcode.LinkedList;

//删除列表节点
public class LeetCode_Easy_237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
