package String;

public class LeetCode_Easy_28 {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                //判断数组越界
                if (i+j >= haystack.length()) return -1;
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                if (j+1 == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
        //使用substring方法快捷实现
//        int n = haystack.length(), l = needle.length();
//        for (int start = 0; start < n-l+1; start++) {
//            if (haystack.substring(start, start+l).equals(needle)) {
//                return start;
//            }
//        }
//        return -1;
    }

    public static void main(String[] args) {
    }
}
