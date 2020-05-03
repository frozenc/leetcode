package JianZhiOffer;

import java.util.Arrays;

//扑克牌的顺子
public class Offer_61 {
    //对数组排序，判断数组间隔数是否小于等于0的个数
    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 5) return false;
        Arrays.sort(numbers);
        int count = 0;
        int interval = 0;
        for (int i=0; i<numbers.length; i++) {
            if (numbers[i] == 0) {
                count ++;
                continue;
            }
            if (i>0 && numbers[i-1] != 0) {
                if (numbers[i] == numbers[i-1]) return false;
                interval += numbers[i] - numbers[i-1] - 1;
            }
        }
        if (count >= interval) return true;
        return false;
    }

    //跳过0，查看数组中是否含有重复数字，查看数组最大值最小值是否大于5
    public boolean isContinuous2(int [] numbers) {
        if (numbers.length < 5) return false;
        int[] nums = new int[14];
        int max=0, min = 14;
        for (int num:numbers) {
            nums[num] ++;
            if (num == 0) continue;
            if (nums[num] > 1) return false;
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        if (max - min < 5) return true;
        return false;
    }
}
