package leetcode.Array;

//装最多水的容器
public class Medium_11 {
    //双指针，从两边往中间靠拢，比较最大面积
    public int maxArea(int[] height) {
        int maxArea = 0, area = 0, left = 0, right = height.length - 1;
        while(left != right) {
            area = (right - left) * Math.min(height[left], height[right]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] < height[right]) {
                left += 1;
            } else {
                right -= 1;
            }

        }
        return maxArea;
    }
}
