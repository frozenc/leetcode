package JianZhiOffer;

//数字在排序数组中出现的次数
public class Offer_53 {
    public int GetNumberOfK(int [] array , int k) {
        int left = 0, right = array.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == k) {
                int i=mid,j=mid;
                while (--i >= 0 && array[i] == k);
                while (++j < array.length && array[j] == k);
                return j-i-1;
            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}
