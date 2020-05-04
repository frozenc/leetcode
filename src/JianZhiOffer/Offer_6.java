package JianZhiOffer;

//旋转数组的最小数字
public class Offer_6 {
    //二分查找
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) return 0;
        int left = 0, right = array.length-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (array[mid] < array[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return array[left];
    }
}
