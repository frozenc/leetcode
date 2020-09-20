package leetcode.String;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode
 * 2020/9/20 14:38
 * 重新排列字符串空格
 *
 * @author Chan
 * @since
 **/
public class Easy_5519 {
    //整理后代码
    public String reorderSpaces(String text) {
        int len = text.length();
        //记录空格数量
        int blankNum = 0;
        //记录单词数量
        int wordsNum = 0;
        //记录结果
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < len; i ++) {
            if (text.charAt(i) == ' ') {
                blankNum ++;
            } else if (i == 0 || text.charAt(i-1) == ' ') {
                wordsNum ++;
            }
        }

        //计算单词间的空格
        int n = wordsNum > 1 ? blankNum / (wordsNum - 1) : blankNum;

        int last = blankNum - n * (wordsNum - 1);
        int count = 1;

        for (int i = 0; i < text.length(); i++) {
            if (res.length() == 0 && text.charAt(i) == ' ') {
                continue;
            } else if (text.charAt(i) != ' ') {
                res.append(text.charAt(i));
            } else if (text.charAt(i-1) != ' ' && text.charAt(i) == ' ' && count < wordsNum) {
                count ++;
                for (int j = 0; j < n; j++) {
                    res.append(' ');
                }
            }
        }

        //填入剩余空格
        for (int i = 0; i < last; i ++) {
            res.append(' ');
        }
        return res.toString();
    }
    //朴素版本
    public String reorderSpaces2(String text) {
        int len = text.length();
        //记录空格数量
        int blankNum = 0;
        //记录全部单词
        List<String> words = new ArrayList<>();
        //记录单个单词
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < len; i ++) {
            if (text.charAt(i) == ' ') {
                blankNum ++;
                if (word.length() != 0) {
                    words.add(word.toString());
                    word = new StringBuilder();
                }
            } else {
                word.append(text.charAt(i));
            }
        }
        if (word.length() != 0) {
            words.add(word.toString());
            word = new StringBuilder();
        }
        int wordsNum = words.size();
        int n = 0;
        if (wordsNum > 1) {
            n = blankNum / (wordsNum - 1);
        }
        int last = blankNum - n * (wordsNum - 1);
        for (int i = 0; i < wordsNum - 1; i++) {
            word.append(words.get(i));
            for (int j = 0; j < n; j ++) {
                word.append(' ');
            }
        }
        word.append(words.get(wordsNum - 1));
        for (int i = 0; i < last; i ++) {
            word.append(' ');
        }
        return word.toString();
    }
}
