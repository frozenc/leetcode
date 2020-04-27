package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

//二进制手表
public class Easy_401 {
    //使用bitCount 方法实现
    public List<String> readBinaryWatch(int num) {
        List<String> time = new ArrayList<>();
        for (int h=0; h<12; h++) {
            for (int m=0; m<60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                    time.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return time;
    }

    //回溯+DFS
    List<String> time = new ArrayList<>();
    int[] watch = {1,2,4,8,1,2,4,8,16,32};
    int[] onOff = {0,0,0,0,0,0,0,0,0,0};
    public List<String> readBinaryWatch2(int num) {
        if (num > 8) return time;
        dfs(num, 0, 0);
        return time;
    }

    public void dfs(int num, int onSum, int start) {
        if (onSum == num) {
            readWatch();
            return;
        }
        for (int i=start; i<watch.length; i++) {
            onOff[i] = 1;
            dfs(num, onSum + 1, i+1);
            onOff[i] = 0;
        }
    }

    public void readWatch() {
        int h=0, m=0;
        for (int i=0; i<onOff.length; i++) {
            if (onOff[i] == 1) {
                if (i < 4) {
                    h += watch[i];
                } else {
                    m += watch[i];
                }
            }
        }
        if (h > 11 || m > 59) return;
        time.add(String.format("%d:%02d", h, m));
    }
}
