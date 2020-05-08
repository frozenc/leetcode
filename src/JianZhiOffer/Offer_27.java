package JianZhiOffer;

import java.util.*;

//字符串的全排列
public class Offer_27 {
    public ArrayList<String> Permutation(String str) {
        char[] arr = str.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        if (str.length() == 0) return res;
        dfs(arr, 0, res);
        Collections.sort(res);
        return res;
    }

    public void dfs(char[] arr, int i, ArrayList<String> res) {
        if (i == arr.length-1) {
            res.add(new String(arr));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int j=i; j<arr.length; j++) {
            if (j == i || !set.contains(arr[j])) {
                set.add(arr[j]);
                swap(arr, i, j);
                dfs(arr, i+1, res);
                swap(arr, i, j);
            }
        }
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        new Offer_27().Permutation("ab");
    }
}
