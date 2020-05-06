package JianZhiOffer;

//矩形覆盖，跳台阶同理
public class Offer_10 {
    public int RectCover(int target) {
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
