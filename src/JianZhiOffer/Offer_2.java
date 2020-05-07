package JianZhiOffer;

//替换空格
public class Offer_2 {
    public String replaceSpace(StringBuffer str) {
        int count = 0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count ++;
            }
        }
        char[] res = new char[str.length() + count*2];
        int idx = res.length-1;
        for (int i=str.length()-1; i>=0; i--) {
            if (str.charAt(i) == ' ') {
                res[idx--] = '0';
                res[idx--] = '2';
                res[idx--] = '%';
            } else {
                res[idx--] = str.charAt(i);
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(new Offer_2().replaceSpace(new StringBuffer("We are happy")));

    }
}
