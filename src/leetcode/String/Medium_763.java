package leetcode.String;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode
 * 2020/10/22 11:35
 * 划分字母区间
 *
 * @author Frozen Chan
 * @since
 **/
public class Medium_763 {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int len = S.length();
        for (int i = 0; i < len; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        ArrayList<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
