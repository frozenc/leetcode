package JianZhiOffer;

import Util.ListNode;

import java.util.ArrayList;
import java.util.Stack;

//从尾到头打印链表
public class Offer_3 {
    //用栈实现
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            list.add(temp.val);
        }
        return list;
    }
    //通过递归实现
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            if (listNode.next != null) {
                printListFromTailToHead(listNode.next);
            }
            res.add(listNode.val);
        }
        return res;
    }
}
