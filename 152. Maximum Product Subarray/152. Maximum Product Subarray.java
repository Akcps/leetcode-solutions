/**
 * Runtime: 1 ms, faster than 92.76% of Java online submissions for Maximum Product Subarray.
 * Memory Usage: 38.6 MB, less than 94.18% of Java online submissions for Maximum Product Subarray.
 */
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int minVal = 1, maxVal = 1, ans = Integer.MIN_VALUE, prevMax;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                maxVal *= nums[i];
                minVal = Math.min(1, minVal * nums[i]);
            } else if (nums[i] == 0) {
                maxVal = 0;
                minVal = 1;
            } else {
                prevMax = maxVal;
                maxVal = minVal * nums[i];
                minVal = prevMax * nums[i];
            }
            ans = Math.max(ans, maxVal);
            if (maxVal <= 0) {
                maxVal = 1;
            }

        }
        return ans;
    }
}