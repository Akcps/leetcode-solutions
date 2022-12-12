class Solution {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sumSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumSoFar = Math.max(nums[i], nums[i] + sumSoFar);
            maxSum = Math.max(maxSum, sumSoFar);
        }
        return maxSum;
    }
}