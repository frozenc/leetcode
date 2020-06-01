package leetcode.Array;

import java.util.Stack;

//柱状图中的最大矩形
public class Hard_84 {
    //暴力法，向两边延申
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i=0; i<heights.length; i++) {
            int left = i, right = i;
            while (left >=0 && heights[left] >= heights[i]) left--;
            while (right < heights.length && heights[right] >= heights[i]) right ++;
            max = Math.max(max, (right - left - 1) * heights[i]);
        }
        return max;
    }
    //维护一个单调栈
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        int max = 0;

        if (len == 0) return 0;
        if (len == 1) return heights[0];

        int[] newHeights = new int[len+2];
        for (int i=0; i<len; i++) {
            newHeights[i+1] = heights[i];
        }
        len += 2;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i=1; i<len; i++) {
            while (newHeights[i] < newHeights[stack.peek()]) {
                int curHeight = newHeights[stack.pop()];
                int curWidth = i - stack.peek() - 1;
                max = Math.max(max, curHeight * curWidth);
            }
            stack.push(i);
        }
        return max;
    }

    //记录每个坐标左右两边第一个比自己矮的柱子坐标
    public int largestRectangleArea3(int[] heights) {
        int len = heights.length;
        int max = 0;

        if (len == 0) return 0;
        if (len == 1) return heights[0];

        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = -1;
        right[len-1] = len;

        for (int i=1; i<len; i++) {
            int tmp = i-1;
            while(tmp >= 0 && heights[tmp] >= heights[i]) tmp = left[tmp];
            left[i] = tmp;
        }

        for (int i=len-2; i>=0; i--) {
            int tmp = i+1;
            while (tmp < len && heights[tmp] >= heights[i]) tmp = right[tmp];
            right[i] = tmp;
        }

        for (int i=0; i<len; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }

        return max;
    }
}
