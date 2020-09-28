package Util.NextNode;

/**
 * leetcode
 * 2020/9/28 13:38
 * 指向右侧节点的树
 *
 * @author Frozen Chan
 * @since
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
