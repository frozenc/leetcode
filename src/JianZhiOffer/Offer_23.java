package JianZhiOffer;

//二叉树的后序遍历
public class Offer_23 {
    //按照定义，前半部分小于根节点，后半部分大于根节点
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) return false;
        if (sequence.length == 1) return true;
        int left = 0, right = sequence.length-1;
        while (right > 0) {
            left = 0;
            while (sequence[left] < sequence[right]) left++;
            while (sequence[left] > sequence[right]) left++;
            right --;
            if (left < right) return false;
        }
        return true;
    }
    //递归，分别判断左子树右子树是否合法
    public boolean VerifySquenceOfBST2(int [] sequence) {
        if (sequence.length == 0) return false;
        if (sequence.length == 1) return true;
        return helper(sequence, 0, sequence.length-1);
    }

    public boolean helper(int[] nums, int left, int right) {
        if (left >= right) return true;
        int i = left;
        while (nums[i] < nums[right]) i++;
        //判断后半部分是否合法右子树
        for (int j=i; j<right; j++) if (nums[j] < nums[right]) return false;
        return helper(nums, left, i-1) && helper(nums, i, right-1);
    }
}
