/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Subarray.
 * Memory Usage: 39.2 MB, less than 30.72% of Java online submissions for Maximum Subarray.
 * Time Complexity: O(N)
 * Space Complexity:O(1)
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int sumTillNow = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sumTillNow + nums[i] >= nums[i]) {
                sumTillNow = sumTillNow + nums[i];
            } else {
                sumTillNow = nums[i];
            }
            if (sumTillNow > maxSum) {
                maxSum = sumTillNow;
            }
        }
        return maxSum;
    }
}