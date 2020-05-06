package JianZhiOffer;

//青蛙跳台阶
public class Offer_8 {
    //斐波那契变形
    public int JumpFloor(int target) {
        if (target <= 0) return 0;
        if (target == 1) return 1;
        int oneStepBefore = 1;
        int twoStepsBefore = 1;
        int ret = oneStepBefore + twoStepsBefore;
        for (int i = 2; i <= target; i++) {
            ret = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = ret;
        }
        return ret;
    }
}
