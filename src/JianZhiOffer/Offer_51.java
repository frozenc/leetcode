package JianZhiOffer;

//数组中的逆序对
public class Offer_51 {
    //暴力超时，使用归并排序
    public int InversePairs(int [] array) {
        if (array.length<2) return 0;
        return InversePairs(array, 0, array.length-1, new int[array.length])%1000000007;
    }

    public int InversePairs(int[] array, int left, int right, int[] temp) {
        if (left == right) return 0;

        int mid = left + (right - left)/2;
        int leftPairs = InversePairs(array, left, mid, temp);
        int rightPairs = InversePairs(array, mid+1, right, temp);

        if (array[mid] <= array[mid+1]) {
            return leftPairs + rightPairs;
        }

        int mergePairs = MergeAndCount(array, left, right, mid, temp);
        return (leftPairs + rightPairs + mergePairs)%1000000007;
    }

    public int MergeAndCount(int[] array, int left, int right, int mid, int[] temp) {
        for (int i=left; i<=right; i++) {
            temp[i] = array[i];
        }
        int count = 0;
        int i = left, j = mid+1;
        for (int k=left; k<=right; k++) {
            if (i == mid+1) {
                array[k] = temp[j++];
            } else if (j == right+1) {
                array[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                array[k] = temp[i++];
            } else {
                array[k] = temp[j++];
                count += (mid-i+1);
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            }
        }
        return count%1000000007;
    }
}
