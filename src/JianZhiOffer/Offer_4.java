package JianZhiOffer;

//查找二分数组
public class Offer_4 {
    public boolean Find(int target, int [][] array) {
        int row = array.length-1;
        int col = 0;
        while (row >= 0 && col <array[0].length) {
            if (array[row][col] < target) {
                col++;
            } else if (array[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}
