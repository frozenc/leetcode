package Week.w2020_10_25;

/**
 * leetcode
 * 2020/10/25 12:46
 * 按键持续最长时间的键
 *
 * @author Frozen Chan
 * @since
 **/
public class Easy_5546 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] map = new int[26];
        int n = releaseTimes.length;
        int pre = 0;
        for (int i =0; i < n; i ++) {
            char c = keysPressed.charAt(i);
            map[c - 'a'] = Math.max(releaseTimes[i] - pre, map[c - 'a']);
            pre = releaseTimes[i];
        }
        char max = 'a';
        int maxNum = -1;
        for (int i = 0; i < 26; i ++) {
            if (map[i] >= maxNum) {
                maxNum = map[i];
                max = (char)(i + 'a');
            }
        }
        return max;
    }
}
