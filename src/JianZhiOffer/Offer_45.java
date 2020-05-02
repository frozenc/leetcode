package JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//数字排成最小的数
public class Offer_45 {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (int num:numbers) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                sb1.append(o1);
                sb1.append(o2);
                sb2.append(o2);
                sb2.append(o1);
                return sb1.toString().compareTo(sb2.toString());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String num:list) {
            sb.append(num);
        }
        return sb.toString();
    }
}
