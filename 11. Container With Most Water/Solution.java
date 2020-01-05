/**
 * Runtime: 2 ms, faster than 95.24% of Java online submissions for Container With Most Water.
 * Memory Usage: 40 MB, less than 94.23% of Java online submissions for Container With Most Water.
 */
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }
}