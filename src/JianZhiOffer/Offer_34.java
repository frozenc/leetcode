package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

//第一次出现的字符的位置
public class Offer_34 {
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();
        for (char c:arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i=0; i<arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new Offer_34().FirstNotRepeatingChar("google");
    }
}
