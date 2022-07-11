class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int low = 0;
        int high = height.length - 1;
        while (low < high) {
            max = Math.max(Math.min(height[low], height[high]) * (high - low), max);
            if (height[low] <= height[high]) {
                low++;
            } else {
                high --;
            }
        }
        return max;
    }
}