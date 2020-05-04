package JianZhiOffer;

import Util.TreeLinkNode;

//二叉树的下一个节点
public class Offer_57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null) return null;
        //该节点的右孩子不为空，查找右孩子的最后一个左孩子
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //右孩子为空，向上寻找父节点，如果该节点是父节点的左孩子，直接返回，否则继续向上寻找
        while (pNode.next != null) {
            if (pNode == pNode.next.left) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
