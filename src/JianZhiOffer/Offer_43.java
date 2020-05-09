package JianZhiOffer;

//左旋转字符串
public class Offer_43 {
    //延长字符串
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if (len == 0) return "";
        str += str;
        return str.substring(n, len+n);
    }

    //三次翻转
    public String LeftRotateString2(String str,int n) {
        int len = str.length();
        if (len == 0) return "";
        char[] arr = str.toCharArray();
        for (int i=0, j=n-1; i<j; i++,j--) swap(arr, i, j);
        for (int i=n, j=len-1; i<j; i++,j--) swap(arr, i, j);
        for (int i=0, j=len-1; i<j; i++,j--) swap(arr, i, j);
        return new String(arr);
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
