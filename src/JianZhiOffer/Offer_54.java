package JianZhiOffer;

//字符流中第一个出现一次的字符
public class Offer_54 {
    //Insert one char from stringstream
    String s = "";
    char[] arr = new char[256];
    public void Insert(char ch)
    {
        s += ch;
        arr[ch] ++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (int i=0; i<s.length(); i++) {
            int c = s.charAt(i);
            if (arr[c] == 1) {
                return (char) c;
            }
        }
        return '#';
    }
}
